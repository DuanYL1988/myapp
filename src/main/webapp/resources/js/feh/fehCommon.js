(function ($) {
  $.extend(true, window, {
      'getImageByCatAndCd':getImageByCatAndCd
  });
  
  var imgBaseLoc = "http://localhost:8080/myapp/resources/images/feh/";
  var contentMap = [{
      key:'0001',value:[
      {key:'1',value:imgBaseLoc+'i_fire_sword.png'}
      ,{key:'2',value:imgBaseLoc+'i_thunder_spear.png'}
      ,{key:'3',value:imgBaseLoc+'i_wind_ax.png'}
      ,{key:'4',value:imgBaseLoc+'i_fire_magic.png'}
      ,{key:'5',value:imgBaseLoc+'i_thunder_magic.png'}
      ,{key:'6',value:imgBaseLoc+'i_wind_magic.png'}
      ,{key:'7',value:imgBaseLoc+'i_fire_dragon.png'}
      ,{key:'8',value:imgBaseLoc+'i_thunder_dragon.png'}
      ,{key:'9',value:imgBaseLoc+'i_wind_dragon.png'}
      ,{key:'10',value:imgBaseLoc+'i_none_dragon.png'}
      ,{key:'11',value:imgBaseLoc+'i_fire_arrow.png'}
      ,{key:'12',value:imgBaseLoc+'i_thunder_arrow.png'}
      ,{key:'13',value:imgBaseLoc+'i_wind_arrow.png'}
      ,{key:'14',value:imgBaseLoc+'i_none_arrow.png'}
      ,{key:'15',value:imgBaseLoc+'i_fire_assassin.png'}
      ,{key:'16',value:imgBaseLoc+'i_thunder_assassin.png'}
      ,{key:'17',value:imgBaseLoc+'i_wind_assassin.png'}
      ,{key:'18',value:imgBaseLoc+'i_none_assassin.png'}
      ,{key:'19',value:imgBaseLoc+'i_none_wand.png'}
      ,{key:'20',value:imgBaseLoc+'i_fire_beast.png'}
      ,{key:'21',value:imgBaseLoc+'i_thunder_beast.png'}
      ,{key:'22',value:imgBaseLoc+'i_wind_beast.png'}
      ,{key:'23',value:imgBaseLoc+'i_none_beast.png'}
      ]},
      {key:'0002',value:[
          {key:'1',value:imgBaseLoc+'i_type_pawn.png'}
          ,{key:'2',value:imgBaseLoc+'i_type_knight.png'}
          ,{key:'3',value:imgBaseLoc+'i_type_fly.png'}
          ,{key:'4',value:imgBaseLoc+'i_type_armor.png'}
          ]},
      {key:'0003',value:[ 
           {key:'1',value:imgBaseLoc+'i_BlessA.png'}
           ,{key:'2',value:imgBaseLoc+'i_BlessF.png'}
           ,{key:'3',value:imgBaseLoc+'i_BlessW.png'}
           ,{key:'4',value:imgBaseLoc+'i_BlessE.png'}
           ]
      }];
  
  function getImageByCatAndCd(category,code) {
      for(var i= 0;i<contentMap.length;i++){
          if(contentMap[i].key == category){
              var tarObj = contentMap[i].value;
              for(var j=0;j<tarObj.length;j++){
                  if(tarObj[j].key == code){
                      return tarObj[j].value;
                  }
              }
          }
      }
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


})(jQuery);