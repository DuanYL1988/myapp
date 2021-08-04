var htmlFlag;
var heroImagePath = '/myapp/resources/images/feh/acter/';
var wenponCd = ['R-W','R-M','R-D','R-B','R-BOW','R-Dart',
  'B-W','B-M','B-D','B-B','B-BOW','B-Dart',
  'G-W','G-M','G-D','G-B','G-BOW','G-Dart',
  'N-W','N-Dart','N-Staff','N-D','N-B'];
  
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
       $("#block").css("display","");
       $("body").css("overflow-y","hidden");
    });
    
    $('#cancel').on('click',function(){
       $("#block").css("display","none");
       $("body").css("overflow-y","");
    });
    
    $('#picture').on('click',function(){
       $("#block").css("display","");
       $("body").css("overflow-y","hidden");
    });
});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initHtml(jsonData){
  //document.getElementById("main").innerHTML = "";
  
  for(var i=0;i<=wenponCd.length;i++){
    var data = jsonData[wenponCd[i]];
    secondLoop(data)
  }
}

function secondLoop(data){
    var parentDiv = document.createElement("div");
    parentDiv.className = "row";

    var rightDiv = document.createElement("div");
    rightDiv.className = "rightArea";
    
    $.each(data,function(){
    
      var cellDiv = document.createElement("div");
      cellDiv.className = "ih-item circle effect19";

      var spinner = document.createElement("div");
      spinner.className = "spinner";
      cellDiv.appendChild(spinner);
      
      var imgDiv = document.createElement("div");
      imgDiv.className = "img";
      imgDiv.id = this.id+";"+this.weaponType;
      var imgEle = document.createElement("img");
      imgEle.src = heroImagePath+this.imgName+"/face.png";
      imgDiv.appendChild(imgEle);
      cellDiv.appendChild(imgDiv);
      
      var infoDiv = document.createElement("div");
      infoDiv.className = "info";
      var infoBackDiv = document.createElement("div");
      infoBackDiv.className = "infoBackDiv";
      var h3Ele = document.createElement("h3");
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
      }
  });
}

function updateHeroInfo(){
    var id = $("#heroId").val();
    var url = '/myapp/hero/regist/' +id + "";
    var iLeft = (window.screen.availWidth - 10 - 850) / 2;
    window.open(url,"英雄更新","height=900 , width=850 , top=20 , left= " + iLeft, false);
}