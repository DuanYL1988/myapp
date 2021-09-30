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
  
  function isNotEmpty(arg) {
      var rslt = isEmpty(arg) ? false : true;
      return rslt;
  }
  
  function createImg(path,id,name){
      var imgEle = createElement('img',id,name);
      imgEle.src = path;
      return imgEle;
  }
  
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
