(function ($) {
  $.extend(true, window, {
      'ajaxGet': ajaxGet,
      'ajaxPost': ajaxPost,
      'getValByKey':getValByKey,
      'changeNull':changeNull
  });
  
  function ajaxGet(url,jsonData,callback){
      $.ajax({
            type : 'GET',
            url :url,
            data :jsonData,
            dataType : 'JSON',
            success : callback,
            error:function(){
                alert('Error')
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
              if(jsonObj[this.name]){
                  if(!jsonObj[this.name].push){
                      jsonObj[this.name] = [jsonObj[this.name]];
                  }
                  jsonObj[this.name].push(this.value || '');
              } else {
                  jsonObj[this.name].push(this.value || '');
              }
          }
      });
      return jsonObj;
  }

})(jQuery);