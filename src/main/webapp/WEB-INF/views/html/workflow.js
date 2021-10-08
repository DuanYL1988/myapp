var CURRENT_STEP;

$(function() {
  //console.dir(wkJson);
  CURRENT_STEP = wkJson.currentStep;
  initlize();
});

/** 初期化处理 */
function initlize(){
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
  
  // 按钮
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
 * 工作流动作
 */
function doEvent(step){
  if (doValidation()) {
    return;
  }

  var parentEle = arrIconReset();
  // 对象取得
  var targetEle = document.getElementById(step);
  CURRENT_STEP = step

  arrIconSet(targetEle);
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
