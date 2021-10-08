(function ($) {
  $.extend(true, window, {
      'ajaxGet': ajaxGet,
      'ajaxPost': ajaxPost,
      'getValByKey':getValByKey,
      'changeNull':changeNull,
      'isEmpty':isEmpty,
      'isNotEmpty':isNotEmpty,
      'isInclude':isInclude,
      'createElement':createElement,
      'createImg':createImg,
      'createOptions':createOptions,
      'createCheck':createCheck,
      'doValidation':doValidation,
      'showMsg':showMsg
  });
  
  function ajaxGet(url,jsonData,callback){
      $.ajax({
            type : 'GET',
            url :url,
            data :jsonData,
            dataType : 'json',
            success : callback,
            error:function(data){
                alert(JSON.stringify(data))
            }
        });
  }
  
  function ajaxPost(url,jsonData,callback){
      $.ajax({
            type : 'POST',
            url :url,
            contentType: 'application/json;charset=UTF-8',
            data :JSON.stringify(jsonData),
            dataType : 'JSON',
            success : callback,
            error:function(data){
                alert(JSON.stringify(data));
            }
        });
  }
  
  function getValByKey(key) {
      var value;
      jQuery.i18n.properties({
          name : "message",
          path : "/myapp/resources/",
          language : "",
          mode : "map",
          callback : function() {
              value = jQuery.i18n.prop(key);
          }
      });
      return value;
  }

  function changeNull(text){
      if("null"==text){
          return "";
      }
      return text;
  }
  
  /**
   * 对象为空判断
   * @param arg js对象,值
   */
  function isEmpty(arg) {
      arg = $.trim(arg);
      if (typeof arg == 'undefined') {
          return true;
      } else {
          if (typeof arg == 'object') {
              return false;
          } else if (''==arg || null == arg || 'null' == arg) {
              return true;
          }
          return false;
      }
  }
  
  /**
   * 对象不为空判断
   * @param arg js对象,值
   */
  function isNotEmpty(arg) {
      var rslt = isEmpty(arg) ? false : true;
      return rslt;
  }
  
  /**
   * 数组内是否包含元素
   */
  function isInclude(str,arr) {
    if (typeof arr == "object" && arr.length > 0) {
      var incluedeFlag = false;
      $.each(arr,function(){
        if (str == this || incluedeFlag) {
          incluedeFlag = true;
        }
      });
      return incluedeFlag;
    } else {
      return false;
    }
  }
  
  /**
   * 生成<option>标签
   *
   * @param ele <option>的父标签,如<select><dataset>
   * @param arrs 内容集合,格式[{"code":"A","value":"NM"},{"code":"B",,"value":"NM2"}]
   */
  function createOptions(ele,arrs){
    $.each(arrs,function(){
      var optionEle = createElement("option","","");
      optionEle.value = this.code;
      optionEle.innerHTML = this.value;
      ele.appendChild(optionEle);
    });
  }
  
  /**
   * 生成单选,复选框
   *
   * @param eleInfo Radio或Checkbox的属性对象{"id":test,"name":"hero.imgSrc",...}
   * @param infoList 内容集合,格式[{"code":"A","value":"NM"},{"code":"B",,"value":"NM2"}]
   * @param parentEle Radio或Checkbox存放位置的父标签
   */
  function createCheck(eleInfo,infoList,parentEle) {
    if (isEmpty(infoList)){
      // 没有设定内容时设置默认值
      infoList = [{"code":"1","value":"Yes"}];
      if ("radio" == eleInfo.type){
        infoList.push({"code":"0","value":"No"});
      }
    }
    
    $.each(infoList,function(){
      var gpEle = createElement("div","","checkItem");
      gpEle.style.display = ""
      var inputEle = createElement("input","","");
      inputEle.name = eleInfo.name;
      inputEle.className = eleInfo.classNm;
      inputEle.id = eleInfo.id;
      inputEle.type = eleInfo.type;
      inputEle.value = this.code;
      // require
      if (isNotEmpty(eleInfo.require)) {
        inputEle.setAttribute("notempty","true");
      }
      gpEle.appendChild(inputEle);
      
      var labelEle = createElement("label","","");
      labelEle.innerHTML = this.value;
      labelEle.style.width = "auto";
      gpEle.appendChild(labelEle);
      
      parentEle.appendChild(gpEle);
    });
    
    // 只读
    var displayEle = createElement("span","","displayOnly");
    parentEle.appendChild(displayEle);
  }
  
  /**
   * 创建图片元素<img>
   * @param arg js对象,值
   */
  function createImg(path,id,name){
      var imgEle = createElement('img',id,name);
      imgEle.src = path;
      return imgEle;
  }
  
  /**
   * 创建html元素<img>
   * @param arg js对象,值
   */
  function createElement(type,id,name) {
    var ele = document.createElement(type);
    ele.id = id;
    ele.className = name;
    return ele;
  }
  
  function showMsg(type,message){
    $('#warMsg').html('&nbsp');
    $('#errMsg').html('&nbsp');
    if ('war'==type) {
      $('#warMsg').html(message);
    } else if ('err'==type) {
      $('#errMsg').html(message);
    }
  }
  
  /**
    * 输入验证
    */
  function doValidation(){
    // 清空
    $(".error").prop('class','');
  
    // 取得输入元素
    var inputEleList = $("input[type='text']");
    
    // 首个出错项目
    var firstFlag = false;
    
    $.each(inputEleList,function(){
      // 可以输入
      if(!this.disabled) {
        // 必须输入验证
        if(isNotEmpty(this.attributes.notempty) && isEmpty(this.value)) {
          this.placeholder = 'please input value!';
          this.className = this.className + "error";
          if (!firstFlag) {
            this.focus();
            firstFlag = true;
          }
        }
  
        // 属性验证
        if(isNotEmpty(this.attributes.validation) && isNotEmpty(this.value)) {
          var valType = this.attributes.validation.value;
          // TODO
          if (!firstFlag && false) {
            this.focus();
            firstFlag = true;
          }
        }
      }
    });

    // 单选，复选框
    var radioEles = $("input[type='radio'],[type='checkbox']");
    var namesCond = [];
    $.each(radioEles,function(){
      if (this.name.indexOf(".")>0) {
        if(!isInclude(this.name , namesCond)){
          namesCond.push(this.name);
        } else {
          return;
        }
      }
    });
    
    // 表单对象Json
    var formObj = $("#infoForm").serializeObject();
    // 验证单选，复选框
    $.each(namesCond,function(){
      var radioEle = $("input[name='"+this+"']")[0];
      var parentEle = $(radioEle).parents("div[class='inputCell']")[0];
      var msgSpan = $(parentEle).find("span")[0];
      msgSpan.innerHTML = "";
      var value = "";
      // 判断是否为对象
      if (this.indexOf(".") > 0) {
        var objNm = this.split(".")[0];
        var attrNm = this.split(".")[1];
        value = formObj[objNm][attrNm];
      } else {
        value = formObj[objNm];
      }
      // 验证
      if (isNotEmpty(radioEle.attributes.notempty) && isEmpty(value)) {
          msgSpan.innerHTML = attrNm + " input please!";
          firstFlag = true;
          return;
        }
    });
  
    //
    if(!firstFlag) {
      console.dir(formObj);
      alert(JSON.stringify(formObj));
      return false;
    } else {
      return true;
    }
  }

  $.fn.serializeObject = function(){
      var jsonObj = {};
      var formParam = this.serializeArray();
      $.each(formParam,function(){
          var keyName = this.name.split('.');
          if(keyName.length>1){
              var innerObjKey = keyName[0];
              if(jsonObj.hasOwnProperty(innerObjKey)){
                  jsonObj[this.name.split('.')[0]][this.name.split('.')[1]] = this.value || '';
              } else {
                  jsonObj[this.name.split('.')[0]] = {};
                  jsonObj[this.name.split('.')[0]][this.name.split('.')[1]] = this.value || '';
              }
          } else {
              if(jsonObj.hasOwnProperty(this.name)){
                jsonObj[this.name].push(this.value || '');
              } else {
                jsonObj[this.name] = this.value;
              }
          }
      });
      return jsonObj;
  }
  
})(jQuery);
