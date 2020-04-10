/**
 * 
 */
var selectImgObj = null;
var alertnativeSelected = false;
var teamSelected = false;
var teamcellObj = null;
var baseTeamImgId = "teamImg"

//
var showTeamImg = [];
$(function() {
  $(".teams").children().hide();
  $(".team1").show();
  
  $(".alterNativeImg").on("click", function() {
    // ALERTNATIVE WILL SELECTED
    alertnativeSelected = true;
    // TEAM NOT SELECTED
    if (teamSelected == false) {
      // ALERTNATIVE AREA INITIAL
      $("img.alterNativeImg").css("border", "");
      // SELECTED IMAGE CSS SET
      this.style.border = "solid 2px blue";
      this.style.boxSizing = "border-box";
      // SELECTED IMAGE
      selectImgObj = this;
    // TEAM AREA DIV SELECTED
    } else {
      // ALERTNVATIVE NOT SELECTED YET
      if (null == selectImgObj) {
        selectImgObj = this;
      } else {
      }
      changeImage();
    }
  });

  //
  $(".teamCell").on("click", function() {
    // TEAM AREA IMG WILL SELECTED
    teamSelected = true;
    // 
    teamcellObj = this;
    // TEAM AREA IMG CSS INITIAL
    $(".teamCell").css("border", "solid 2px #83fcad");
    this.style.border = "solid 2px green";
    // IF NO IMG
    if (selectImgObj != null) {
      changeImage();
    }
  });

  $("#saveTeam").on('click',function(){
    $(".teams").children().each(function() {
      if (this.style.display == null || this.style.display == "") {
        var index = this.className.replace("team", "");
        var imgList = $(this).find("img");
        if(imgList.length < 4){
          alert("THERE HAS NO FOUR PERSON IN THIS TEAM!");
          return;
        }
        var id = "";
        for (var i=0;i<imgList.length;i++){
          if(i==3){
            id = id+imgList[i].id.replace(baseTeamImgId,'');
          }else{
            id = id+imgList[i].id.replace(baseTeamImgId,'') + ",";
          }
        }
        var jsonData = {
          acterIdList:id,
          teamId:index
        };
        ajaxGet('/myapp/fireEmblem/saveTeam',jsonData,function(data){
          alert(data.message);
        });
      }
    });
  });

  /*
   * SELECTED IMAGE CANCEL
   */
  $("#cancel").on('click',function(){
    // IF TEAM IMAGE SELECTED
    if(teamcellObj != null){
      var thisImg = $(teamcellObj).find("img")[0];
      var imgId = thisImg.id.replace(baseTeamImgId, '');
      $("#" + imgId).show();
      teamcellObj.innerHTML = "";
    } else {
      var imageList = $(".teams").find("img");
      if(imageList.length > 0) {
        var index = imageList.length-1;
        var imgId = imageList[index].id.replace(baseTeamImgId, '');
        $("#" + imgId).show();
        imageList[index].outerHTML = "";
      }
    }
    init();
  });

  /*
   * SEARCH CONDITION
   */
  $(".searchSelect").on("change",function(){
    var searchObj = {};
    searchObj.moveType = $("#moveType").val();
    searchObj.color = $("#color").val();
    searchObj.race = $("#race").val();
//    searchObj.skillA = $("#skillA").find("option:selected").text();
//    searchObj.skillB = $("#skillB").find("option:selected").text();
//    searchObj.skillC = $("#skillC").find("option:selected").text();
    
    ajaxPost('/myapp/fireEmblem/searchTeam',searchObj,function(data){
      $(".alterNativeImg").hide();
      var imgIdList = data.data;
      for(var i = 0;i<imgIdList.length;i++){
        $("#"+imgIdList[i]).show();
      }
      hideCurrentSelectImg();
    });
  });

  function changeImage() {
    // GET IMAGE IN DIV
    var thisImg = $(teamcellObj).find("img")[0];
    // HIDE ALERTNATEIVE IMAGE
    var imgHtml = "<img class='teamImg' id='" + baseTeamImgId + selectImgObj.id + "' src ='" + selectImgObj.src + "' />";
    teamcellObj.innerHTML = imgHtml;
    // PROV IMAGE SHOW
    $(selectImgObj).hide();
    // DIV HAS IMAGE
    if (thisImg != null) {
      var imgId = thisImg.id.replace(baseTeamImgId, '');
      $("#" + imgId).show();
    }
    var imgHtml = "<img class='teamImg' id='" + baseTeamImgId + selectImgObj.id + "' src ='" + selectImgObj.src + "' />";
    teamcellObj.innerHTML = imgHtml;
    init();
  }
  
  function init() {
    selectImgObj = null;
    teamcellObj = null;
    alertnativeSelected = false;
    teamSelected = false;
    $(".teamCell").css("border", "solid 2px #83fcad");
    $("img.alterNativeImg").css("border", "");
    $("img.alterNativeImg").css("margin", "");
  }

  hideCurrentSelectImg();
});

/* 
 * CHANGE TEAM
 */
function changeTeam(kbn) {
  var index;
  $(".teams").children().each(function() {
    if (this.style.display == null || this.style.display == "") {
      index = this.className.replace("team", "");
    }
  });
  $(".team"+index).hide();
  if(kbn==0){
    if(index==1){
      index = 15
    } else {
      index = parseInt(index) - 1;
    }
  } else {
    if (index == 15) {
      index = 1
    } else {
      index = parseInt(index) + 1;
    }
  }
  $(".team"+index).show(200);
  hideCurrentSelectImg();
}

/**
 * GET CURRENT SELECTED TEAM IMG ID
 */
function hideCurrentSelectImg(){
  // WHEN CHANGE TEAM SHOW BEFORE IMG
  if (showTeamImg.length > 0) {
    for(var i = 0;i<showTeamImg.length;i++){
      $($("#"+showTeamImg[i]).show());
    }
  }
  // initialize
  showTeamImg = [];
  var undisPlayTeamId;
  // GET CURRENT SELECTED TEAM
  $(".teams").children().each(function() {
    if (this.style.display == null || this.style.display == "") {
      undisPlayTeamId = this;
      return true;
    }
  });
  // GET UNDISPLAY IMG ID
  $(undisPlayTeamId).find("img").each(function(){
    var imgId = this.id.replace(baseTeamImgId,"");
    showTeamImg.push(imgId);
    $("#"+imgId).hide();
  });
}