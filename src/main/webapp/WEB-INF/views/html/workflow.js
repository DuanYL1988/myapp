var CURRENT_STEP;
var formEle;

$(function() {
  // 初始设定
  CURRENT_STEP = wkJson.currentStep;
  formEle = document.getElementById("infoForm");
  initlize();
  
  // 基本情报
  initEditArea(contract.baseInfo,formEle);
  // 默认表示区域
  initEditArea(contract[wkJson.displayArea],formEle);
  //
  initlizeTable(masterInfo.tableInfo);
});

function showSection(divEle){
  var parentEle = $(divEle).parents()[0];
  $(parentEle).children().attr('class','layout-title');
  divEle.className = 'layout-title current-layout';
  var nm = divEle.id.replace("title-","");
  $("div[class^='group-section']").hide();
  $("#"+nm).show();
}

/** 初期化处理 */
function initlize(){
  // 初始化
  document.getElementById("wk_icon_area").innerHTML = "";
  // 进度条
  $.each(wkJson.stepsStr,function(i,ele){
    // 状态图标
    var statusEle = createElement("div",this,"status");
    
    // 图标主体和方向箭头
    var preEle = createElement("div","","wk_icon_pre");
    var stepEle = createElement("div","","wk_icon");
    var nextEle = createElement("div","","wk_icon_next");
    
    // 文字
    var stepInfo = wkJson.steps[this];
    stepEle.innerHTML = stepInfo.name;
    
    // 当前状态颜色设置
    if(CURRENT_STEP == this) {
      stepEle.className = "wk_icon current";
      nextEle.className = "wk_icon_next currentNext";
    }

    // 第一个没有前方向,最后一个没有后方向
    if (i>0) {
      statusEle.appendChild(preEle);
    }
    statusEle.appendChild(stepEle);
    if (i < wkJson.stepsStr.length - 1) {
      statusEle.appendChild(nextEle);
    }
    statusEle.setAttribute("onclick","doEvent('"+this+"')");

    // 添加
    document.getElementById("wk_icon_area").appendChild(statusEle);
    
  });
  
  // 按钮区域初始化
  document.getElementById("eventArea").innerHTML = "";

  for(var i = wkJson.steps[CURRENT_STEP].actions.length; i > 0 ; i--) {
    var eventInfo = wkJson.steps[CURRENT_STEP].actions[i-1];
    var btnEle = createElement("button","","btn");
    btnEle.innerHTML = eventInfo.name;
    btnEle.setAttribute("onclick","doEvent('"+eventInfo.step+"')");
    
    // 添加
    document.getElementById("eventArea").appendChild(btnEle);
  }
}

/**
 * 生产状态区域DIV
 *
 * @param obj 状态Object(包含状态，布局信息等情报)
 * @param formEle 生产DIV的父DIV对象（Element）
 */
function initEditArea(obj,parentEle){
  // 
  if (isEmpty(obj)) {
    return;
  }
  if (isNotEmpty(document.getElementById(obj.id))) {
    document.getElementById(obj.id).style.display = "";
    return;
  }
  if ("group"==obj.layout) {
    
    var stepEle = createElement("div",obj.id,"group-layout");
    // 标题
    /**/
    var titleEle = createElement("span","","title");
    titleEle.innerHTML = obj.title;
    stepEle.appendChild(titleEle); 
    
    // Group标签标题部
    var titleEle = createElement("div","","group-title");
    var firstTagId = "";
    $.each(obj.sections,function(){
      var layoutTitle = createElement("div","","layout-title");
      layoutTitle.id = "title-" + obj.id + "-" + this;
      layoutTitle.innerHTML = obj.layoutGroup[this].title;
      titleEle.appendChild(layoutTitle);
      
      // 第一个标签默认选中
      if ("" == firstTagId) {
        firstTagId = obj.id + "-" + this;
        layoutTitle.className += " current-layout"; 
      }
    });
    stepEle.appendChild(titleEle);
    
    // 标签对应的显示部分
    $.each(obj.sections,function(){
      var layoutId = obj.id + "-" + this;
      var singleLayout = createElement("div",layoutId,"group-section");
      initEditArea(obj.layoutGroup[this],singleLayout);
      stepEle.appendChild(singleLayout);
    });
    
    parentEle.appendChild(stepEle);
    
    // 第一个标签默认显示
    $("#"+firstTagId).show();
    
    // Group Layout
    $("div[class^='layout-title']").on('click',function(){
      showSection(this);
    });
    
  } else {
    // 实际编辑区域
    var baseInfoEle = createElement("div",obj.id,"editArea");
    // 标题
    var titleEle = createElement("span","","title");
    titleEle.innerHTML = obj.title;
    baseInfoEle.appendChild(titleEle);
    
    $.each(obj.detail.rows,function(i,rows){
      var inputRowEle = createElement("div","","inputRow");
      // 排列方向
      if ("vertical" == rows.design) {
        inputRowEle.className = "inputRow vertical";
      }
      //prop
      $.each(rows.items,function(j,prop){
        var inputCell = createElement("div","","inputCell");
        // 属性Title
        var inputType = prop.type;
        var lblEle = createElement("label","","");
        if ("button" != inputType) {
          lblEle.innerHTML = prop.name;
          inputCell.appendChild(lblEle);
        }
        // 属性Input
        var inputEle = createElement("input","","");
        inputEle.name = obj.id + "." + prop.property;
        inputEle.id = obj.id + "_" + prop.property;
        
        // 输入框
        if ("text" == inputType) {
          inputEle.type = "text";
          inputEle.value = prop.value;
          inputEle.style = prop.style;
        // 下拉菜单
        } else if ("select" == prop.type){
          inputEle = createElement("select","","");
          createOptions(inputEle,masterInfo[prop.masterId]);
          
        // Autocomplete
        } else if ("autocomplete" == inputType) {
          inputEle.type = "text";
          inputEle.autocomplete = "on";
          inputEle.setAttribute("list",prop.masterId);
          inputEle.value = prop.value;
          
          var datalistEle = createElement("datalist",prop.masterId,"");
          createOptions(datalistEle,masterInfo[prop.masterId]);
          document.getElementById("hideArea").appendChild(datalistEle);
          
        // 单选,复选按钮
        } else if ("radio" == inputType || "checkbox" == inputType){
          inputEle = null;
          // 属性设定
          var eleInfo = {
            "name" : obj.id + "." + prop.property,
            "id" : "",
            "classNm" : "",
            "type" : inputType,
            "require" : prop.require
          };
          createCheck(eleInfo,masterInfo[prop.masterId],inputCell);
          
        // 单纯表示项目
        } else if ("label" == inputType){
          inputEle = createElement("label","","");
          inputEle.innerHTML = prop.value;
          inputEle.style.width = "auto";
        } else if ("textarea" == inputType){
          inputEle = createElement("textarea","","");
          inputEle.value = prop.value;
          inputEle.rows = 7;
          inputEle.cols = 80;
        // 日期控件
        } else if ("datetime" == inputType) {
          inputEle.type = "datetime-local";
          inputEle.className = "dateTime";
          inputEle.value = prop.value;
        // 按钮
        } else if ("button" == inputType) {
          inputEle = createElement("button","","");
          inputEle.setAttribute("onclick",prop.value);
          inputEle.innerHTML = prop.name;
          inputEle.type = "button"
          inputEle.className = "cell_btn";
          inputEle.name = "";
        }
        
        // 单选复选是对象为空
        if (isNotEmpty(inputEle)) {
          // require
          if (isNotEmpty(prop.require)) {
            inputEle.setAttribute("notempty","true");
          }
          // 只读
          var displayEle = createElement("span","","displayOnly");
          inputCell.appendChild(inputEle);
          inputCell.appendChild(displayEle);

        }
        inputRowEle.appendChild(inputCell);
      });
      baseInfoEle.appendChild(inputRowEle);
    });
    
    parentEle.appendChild(baseInfoEle);
  }
}

function initlizeTable(arr){
  if(isNotEmpty(arr)) {
    $.each(arr,function(){
      addTableRecord("display_table_body",this);
    });
  }
}

/**
 * 工作流动作
 */
function doEvent(step){
  if (doValidation()) {
    return;
  }

  var parentEle = arrIconReset();
  // 对象取得
  var targetEle = document.getElementById(step);
  // 设置当前step
  CURRENT_STEP = step

  // 状态Step图标重设
  arrIconSet(targetEle);
  
  // 内容刷新
  $.each($(formEle).children(),function(){
    if ("baseInfo" != this.id) {
      $(this).hide();
    }
  });
  var classNm = wkJson.steps[step].clnm;
  initEditArea(contract[classNm],formEle);
}

/**
 * ICON初期化
 * @return 当前St的父元素
 */
function arrIconReset(){
  // 消息清空
  showMsg('',"");
  var curStEle = $("div[class='wk_icon current']")[0];
  curStEle.className = "wk_icon";
  // 箭头
  var nextIcon = $(curStEle).next()[0];
  if(null != nextIcon) {
    nextIcon.className = nextIcon.className.replace(' currentNext','');
  }
  return $(curStEle).parents()[0];
}

/**
 * 元素设置颜色
 * @param targetEle 动作的下一步父元素
 */
function arrIconSet(targetEle){
  // 活性控制
  $('#btn_pre').prop('disabled','');
  $('#btn_next').prop('disabled','');
  if(isEmpty($(targetEle).prev()[0])) {
    $('#btn_pre').prop('disabled','true');
  }
  if(isEmpty($(targetEle).next()[0])) {
    $('#btn_next').prop('disabled','true');
  }

  $.each($(targetEle).children(),function(){
    var clsNm = this.className;
    if('wk_icon'==clsNm){
      this.className = clsNm + ' current';
    } else if('wk_icon_next'==clsNm){
      this.className = clsNm + ' currentNext';
    }
  });

  // 页面重置
  initlize();
}

function addRecord() {
  var strTime = formateTypeDT("heathInfo_startTime");
  var endTime = formateTypeDT("heathInfo_currentTime");
  var info = $("#heathInfo_information").val();
  var countermeasure = $("#heathInfo_countermeasure").val();
  var timeDiff = getTimeDiff(strTime,endTime);
  
  var columns = [$("#heathInfo_currentTime").val(),timeDiff.strHM,info+"<br>"+countermeasure];
  addTableRecord("display_table_body",columns);
  
  getTableInfo();
}

function getTableInfo(){
  var trEles = $("#display_table_body").find("tr");
  var tableInfo = [];
  $.each(trEles,function(){
    var row = [];
    $.each($(this).find("td"),function(i,tdEle){
      row.push(tdEle.innerHTML);
    });
    tableInfo.push(row);
  })
  console.log(tableInfo);
}

/**
 * 对table添加行
 */
function addTableRecord(tblBodyId,columns){
  var trEle = createElement("tr","","");
  $.each(columns,function(){
    var tdEle = createElement("td","","");
    tdEle.innerHTML = this;
    trEle.appendChild(tdEle);
  });
  document.getElementById(tblBodyId).appendChild(trEle);
}

/**
 * 对<input type="datetime">的值进行转换
 *
 * @param eleId 输入框的ID
 */
function formateTypeDT(eleId){
  var stTime = document.getElementById(eleId).value;
  stTime = stTime.replace("T"," ");
  stTime += ":00";
  stTime = new Date(stTime);
  return stTime;
}

/**
 * 计算时间差
 */
function getTimeDiff(strTime,endTime){
  var bt = (endTime-strTime)/1000/60;
  var bth = parseInt(bt/60);
  var btm = bt%60;
  
  var result = {
    "strHM" : bth+"小时"+btm+"分",
    "mSecond" : bt
  };
  return result;
}


function writeFile(){
  
}
