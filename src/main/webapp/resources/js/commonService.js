(function ($) {
  $.extend(true, window, {
      'ajaxGet': ajaxGet,
      'ajaxPost': ajaxPost,
      'getValByKey':getValByKey,
      'changeNull':changeNull,
      'isEmpty':isEmpty,
      'isNotEmpty':isNotEmpty,
      'createImg':createImg,
      'createElement':createElement,
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
        
        // 必须输入
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
  
    //
    if(!firstFlag) {
      var formObj = $("#infoForm").serializeObject();
      console.dir(formObj);
      return false;
    } else {
      return true;
    }
  }

  $.fn.serializeObject = function(){
      console.log("excute serializeObject!");
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
