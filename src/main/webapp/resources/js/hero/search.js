var htmlFlag;
var heroImagePath = '/myapp/resources/images/feh/acter/';
var wenponCd = ['R-W','R-M','R-D','R-B','R-BOW','R-Dart',
  'B-W','B-M','B-D','B-B','B-BOW','B-Dart',
  'G-W','G-M','G-D','G-B','G-BOW','G-Dart',
  'N-W','N-Dart','N-Staff','N-D','N-B'];

var colorMoveCd = ['01','02','03','04'];
var selectedHero;

$(function() {
    // 未定义返回ture
    htmlFlag = typeof(mode)=="undefined";
    if(htmlFlag){
        console.log("display from static html");
        heroImagePath = "../../../resources/images/feh/acter/";
        // 静态页面加载json数据
        jsonDate = staticJson;
        initHtml(staticJson);
    } else {
      jsonDate = JSON.parse(jsonDate);
      initHtml(jsonDate);
    }
    
    $('.img').on('click',function(){
        var heroId = this.id.split(';')[0];
        var weaponType = this.id.split(';')[1];
        if (!htmlFlag) {
            openInfoDiv(heroId)
        } else {
            opInfoWhenHtml(heroId,weaponType);
        }
    });
    
    $('#hide').on('click',function(){
      $("#leftDetailInfo").css("display","none");
    });

    $('#picture').on('click',function(){
        /*
       $("#block").css("display","");
       $("body").css("overflow-y","hidden");
       */
        var url = "/myapp/fileManagement/gallery?game=feh&height=980&name="+selectedHero.imgName;
        var iLeft = (window.screen.availWidth - 10 - 850) / 2;
        window.open(url,"立绘","location=no,height=1100 , width=1000 , top=0 , left= " + iLeft, false);
    });
    
    $('#cancel').on('click',function(){
       $("#block").css("display","none");
       $("body").css("overflow-y","");
    });

});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initHtml(jsonData){
  var displayGroup = $("#display_group").val();
  displayGroup = null == displayGroup ? "A" : displayGroup;
  
  if ("A"==displayGroup) {
      for(var i=0;i<=wenponCd.length;i++){
        var data = jsonData[wenponCd[i]];
        secondLoop(data)
      }
  } else {
     for(var i=0;i<=colorMoveCd.length;i++){
        var data = jsonData[colorMoveCd[i]];
        secondLoop(data)
      }
  }
}

function secondLoop(data){
    var parentDiv = createElement('div','','row');
    var rightDiv = createElement('div','','rightArea');

    $.each(data,function(){
      var cellDiv = createElement('div','','ih-item circle effect19');

      var spinner = createElement('div','','spinner');
      cellDiv.appendChild(spinner);

      var imgDiv = createElement('div',this.id+";"+this.weaponType,'img');
      var imgEle = createImg(heroImagePath+this.imgName+"/face.png",'','');
      imgDiv.appendChild(imgEle);
      cellDiv.appendChild(imgDiv);
      
      var infoDiv = createElement('div','','info');
      var infoBackDiv = createElement('div','','infoBackDiv');
      var h3Ele = createElement('h3','','');
      h3Ele.innerHTML = this.name;
      var pEle = document.createElement("p");
      pEle.innerHTML = this.titleName;
      infoBackDiv.appendChild(h3Ele);
      infoBackDiv.appendChild(pEle);
      infoDiv.appendChild(infoBackDiv);
      cellDiv.appendChild(infoDiv);

      rightDiv.appendChild(cellDiv);
  });
  parentDiv.appendChild(rightDiv);
  document.getElementById("main").appendChild(parentDiv);

}

/**
 * 打开信息面板(服务器)
 */
function openInfoDiv(id){
    // ajax取得英雄信息
    var url ='/myapp/hero/openLeftInfo/' +id;
    
    ajaxGet(url,null,function(data){
        // 选择的角色
        selectedHero = data.data;

        var leftAside = $("#leftDetailInfo");
        leftAside.css("display","");
        leftAside.css("background","url('/myapp/resources/images/feh/background.jpg')");
        $("#hero_img").prop("src",heroImagePath+data.data.imgName+"/face.png");
        $("#hero_titleName").html(data.data.titleName+"-"+data.data.name);
        var localHp = data.listData01[0].localVal;
        var localPow = data.listData01[1].localVal;
        var localSpd = data.listData01[2].localVal;
        var localDef = data.listData01[3].localVal;
        var localMdf = data.listData01[4].localVal;
        var localTotal = data.listData01[5].localVal;
        $("#hero_hp").html(localHp);
        $("#hero_pow").html(localPow);
        $("#hero_spd").html(localSpd);
        $("#hero_def").html(localDef);
        $("#hero_mdf").html(localMdf);
        $("#hero_total").html(localTotal);
        $("#hero_weapon").html(data.data.weapon);
        $("#hero_skillA").html(data.data.skillA);
        $("#hero_skillB").html(data.data.skillB);
        $("#hero_skillC").html(data.data.skillC);
        $("#hero_skillS").html(data.data.skillS);
        $("#hero_skillE").html(data.data.skillE);
        
        $("#round_hp").html('排位:'+data.listData01[0].roundVal+"/"+data.listData01[0].totalVal);
        $("#round_pow").html('排位:'+data.listData01[1].roundVal+"/"+data.listData01[1].totalVal);
        $("#round_spd").html('排位:'+data.listData01[2].roundVal+"/"+data.listData01[2].totalVal);
        $("#round_def").html('排位:'+data.listData01[3].roundVal+"/"+data.listData01[3].totalVal);
        $("#round_mdf").html('排位:'+data.listData01[4].roundVal+"/"+data.listData01[4].totalVal);
        $("#round_total").html('排位:'+data.listData01[5].roundVal+"/"+data.listData01[5].totalVal);
        
        $("#stick_hp").css('width',(localHp/data.listData01[0].maxVal)*180+"px");
        $("#stick_pow").css('width',(localPow/data.listData01[1].maxVal)*180+"px");
        $("#stick_spd").css('width',(localSpd/data.listData01[2].maxVal)*180+"px");
        $("#stick_def").css('width',(localDef/data.listData01[3].maxVal)*180+"px");
        $("#stick_mdf").css('width',(localMdf/data.listData01[4].maxVal)*180+"px");
        $("#stick_total").css('width',(localTotal/data.listData01[5].maxVal)*180+"px");
        
        // 组队
        if (null != data.listData02){
            $.each(data.listData02,function(index,member){
                $("#team_"+index).prop("src",heroImagePath+member.imgName+"/face.png");
            });
        }
    });
    
    $("#heroId").val(id);
}

/**
 * 打开信息面板(静态页面json)
 */
function opInfoWhenHtml(heroId,weaponType){
  var data = jsonDate[weaponType];
  $.each(data,function(){
      if(this.id == heroId) {
          $("#leftDetailInfo").css("display","");
          window.console.log(this.imgName);
          $("#hero_img").prop("src",heroImagePath+this.imgName+"/face.png");
          $("#hero_hp").html(this.hp);
          $("#hero_pow").html(this.attact);
          $("#hero_spd").html(this.speed);
          $("#hero_def").html(this.def);
          $("#hero_mdf").html(this.mdf);
          $("#hero_total").html(this.hp+this.attact+this.speed+this.def+this.mdf);
          $("#hero_weapon").html(this.weapon);
          $("#hero_skillA").html(this.skillA);
          $("#hero_skillB").html(this.skillB);
          $("#hero_skillC").html(this.skillC);
          $("#hero_skillS").html(this.skillS);
          $("#hero_skillE").html(this.skillE);
      }
  });
}

function updateHeroInfo(){
    var id = $("#heroId").val();
    var url = '/myapp/hero/regist/' +id + "";
    var iLeft = (window.screen.availWidth - 10 - 850) / 2;
    window.open(url,"英雄更新","height=900 , width=850 , top=20 , left= " + iLeft, false);
}