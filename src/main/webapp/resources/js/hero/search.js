var htmlFlag;
var heroImagePath = '/myapp/resources/images/feh/acter/';
var selectedHero;
// 表示方式
var displayType = ['color','moveType','weaponType'];
var jsonDate = transListToMap(staticJson,displayType[1]);
// 直接取得对象
const heroMap = transListToMap(staticJson,"id",true);
// 按照人物分组
const personMap = transListToMap(staticJson,"masterId");
// 分组对象
const teamMap = transListToMap(staticJson,"team");

/** ----angularJs---- */
var firstApp = angular.module('firstApp',[]);
firstApp.controller('myCtrl',function($scope){
  $scope.heroMap = jsonDate;
});
/** ----angularJs---- */

$(function() {
    // 未定义返回ture
    htmlFlag = typeof (mode) == "undefined";
    if (htmlFlag) {
        heroImagePath = "../../../resources/images/feh/acter/";
        // 静态页面加载json数据
        // initHtml(jsonDate);
    } else {
        jsonDate = JSON.parse(jsonDate);
        // initHtml(jsonDate);
    }
/**/
    $('.img').on('click', function() {
        let heroId = this.id.split(';')[0];
        let imgNm = this.id.split(';')[1];
        openInfoDiv(heroId,imgNm);
    });

    $('#hide').on('click', function() {
        $("#leftDetailInfo").css("display", "none");
    });

    $('#picture').on('click', function() {
        var url = "/myapp/fileManagement/gallery?game=feh&height=980&name=" + selectedHero.imgName;
        var iLeft = (window.screen.availWidth - 10 - 850) / 2;
        window.open(url, "立绘", "location=no,height=1100 , width=1000 , top=0 , left= " + iLeft, false);
    });

    $('#cancel').on('click', function() {
        $("#block").css("display", "none");
        $("body").css("overflow-y", "");
    });

});

/**
 * 打开信息面板(服务器)
 */
function openInfoDiv(id,imgName) {
    let data = heroMap[id];
    $("#heroId").val(id);
    /*
    // ajax取得英雄信息
    var url = '/myapp/hero/openLeftInfo/' + id;
    ajaxGet(url, null, setSingleHeroInfo(data));
    */
    setSingleHeroInfo(data);
    displaySamePerson(personMap[data.masterId],data.id,"samePerson");
    displaySamePerson(teamMap[data.team],"","teamMember");
    console.log(teamMap[data.team].length);

}

function setSingleHeroInfo(heroObject){
  // 选择的角色
  selectedHero = heroObject;

  $("#hero_img").prop("src", heroImagePath + selectedHero.imgName + "/face.png");
  $("#hero_titleName").html(selectedHero.titleName + "-" + selectedHero.name);
  $("#hero_weapon").html(selectedHero.weapon);
  $("#hero_skillA").html(selectedHero.skillA);
  $("#hero_skillB").html(selectedHero.skillB);
  $("#hero_skillC").html(selectedHero.skillC);
  $("#hero_skillS").html(selectedHero.skillS);
  $("#hero_skillE").html(selectedHero.skillE);
  $("#hero_hp").html(selectedHero.hp);
  $("#hero_pow").html(selectedHero.attact);
  $("#hero_spd").html(selectedHero.speed);
  $("#hero_def").html(selectedHero.def);
  $("#hero_mdf").html(selectedHero.mdf);
  $("#hero_total").html(selectedHero.hp+selectedHero.attact+selectedHero.speed+selectedHero.def+selectedHero.mdf);

  /*
  $("#round_hp").html('排位:' + data.listData01[0].roundVal + "/" + data.listData01[0].totalVal);
  $("#round_pow").html('排位:' + data.listData01[1].roundVal + "/" + data.listData01[1].totalVal);
  $("#round_spd").html('排位:' + data.listData01[2].roundVal + "/" + data.listData01[2].totalVal);
  $("#round_def").html('排位:' + data.listData01[3].roundVal + "/" + data.listData01[3].totalVal);
  $("#round_mdf").html('排位:' + data.listData01[4].roundVal + "/" + data.listData01[4].totalVal);
  $("#round_total").html('排位:' + data.listData01[5].roundVal + "/" + data.listData01[5].totalVal);

  $("#stick_hp").css('width', (localHp / data.listData01[0].maxVal) * 180 + "px");
  $("#stick_pow").css('width', (localPow / data.listData01[1].maxVal) * 180 + "px");
  $("#stick_spd").css('width', (localSpd / data.listData01[2].maxVal) * 180 + "px");
  $("#stick_def").css('width', (localDef / data.listData01[3].maxVal) * 180 + "px");
  $("#stick_mdf").css('width', (localMdf / data.listData01[4].maxVal) * 180 + "px");
  $("#stick_total").css('width', (localTotal / data.listData01[5].maxVal) * 180 + "px");

  // 初期状态
  var heroOtherSkinDiv = document.getElementById('otherSkin');
  heroOtherSkinDiv.innerHTML = '';
  // 组队
  if (null != data.listData02) {
      $.each(data.listData02, function() {
          var imgEle = createImg(heroImagePath + this.imgName + "/face.png", '', '');
          imgEle.style.width = '100px';
          var dataId = this.id;
          $(imgEle).on('click', function() {
              openInfoDiv(dataId);
          });
          heroOtherSkinDiv.appendChild(imgEle);
      });
  }
  */
}

function displaySamePerson(heroList,id,eleId) {
  document.getElementById(eleId).innerHTML = "";
  $.each(heroList,function(){
    if (id!=this.id) {
      var imgEle = createImg(heroImagePath + this.imgName + "/face.png", '', 'faceImg');
      document.getElementById(eleId).appendChild(imgEle);
    }
  });
}

function updateHeroInfo() {
    var id = $("#heroId").val();
    var url = '/myapp/hero/regist/' + id + "";
    var iLeft = (window.screen.availWidth - 10 - 850) / 2;
    window.open(url, "英雄更新", "height=900 , width=850 , top=20 , left= " + iLeft, false);
}