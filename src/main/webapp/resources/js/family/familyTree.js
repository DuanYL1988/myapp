/**
 * 
 */
var html = "";
$(function() {
  var obj = createTestData();
  $("#content").html(createTree(obj));
});

function createTree(data){
  if(data){
    html += "<ul>";
    for(var i=0;i<data.length;i++){
      html += "<li>";
      if(data[i]["child"]){
        html+="<div open='true'><span class='close'></span><span class='openTrue'>"+data[i]["name"]+"</span></div>";
      }else{
        html+="<div><span class='leaf'></span><span class='leafName'>"+data[i]["name"]+"</div>";
      }
      createTree(data[i]["child"]);
      html+="</li>"
    }
    html+="</ul>";
  }
  return html;
}

function createTestData() {
  var familyObj = [ {
    name : 'DUAN DENGKAI',
    mate : 'GAO YUNLAN',
    child : [ {
      name : 'DUAN GUOQIN',
      mate : 'HU JIANFEN',
      child : [ {
        name : 'DUAN TING',
        mate : 'LI WEI',
        child : [ {
          name : 'LI XIANG',
          mate : null,
          child : null
        } ]
      } ]
    }, {
      name : 'DUAN LIANHAI',
      mate : 'HU ',
      child : [ {
        name : 'DUAN LI',
        mate : null,
        child : null
      } ]
    }, {
      name : 'DUAN JIANHAI',
      mate : 'XX',
      child : [ {
        name : 'DUAN YANLIN',
        mate : null,
        child : null
      } ]
    }, {
      name : 'DUAN WENHAI',
      mate : 'YANG LIAN',
      child : [ {
        name : 'DUAN YANGLONG',
        mate : null,
        child : null
      } ]
    } ]
  } ]
  return familyObj;
}