var htmlFlag;
var heroImagePath = '/myapp/resources/images/feh/acter/';
var startFlag = false;
var turn = 0;//0:red 1:black
var wenponCd = ['R-W','R-M','R-D','R-B','R-BOW','R-Dart',
  'B-W','B-M','B-D','R-B','B-BOW','B-Dart',
  'G-W','G-M','G-D','R-B','G-BOW','G-Dart',
  'N-W','N-Dart','N-Staff','N-D'];
  
var heroObj = {};
var redTeam = [];
var blackTeam = [];

$(function() {
    // 未定义返回ture
    htmlFlag = typeof(mode)=="undefined";
    if(htmlFlag){
        console.log("display from static html");
        heroImagePath = "../../../resources/images/feh/acter/";
        // 静态页面加载json数据
        jsonDate = staticJson;
        initHtml(staticJson,"redTeam");
        initHtml(staticJson,"blackTeam");
    } else {
      jsonDate = JSON.parse(jsonDate);
      initHtml(jsonDate,"redTeam");
      initHtml(jsonDate,"blackTeam");
    }

    // 制作地图DIV
    createMap();

    // 人物选择选中事件
    $('.img').on('click',function(){
      var heroId = this.id.split(':')[0];
      var weaponType = this.id.split(':')[1];
      var areaPart = this.parentElement.parentElement.id.replace("Team","");
      if (!htmlFlag) {
        openInfoDiv(heroId);
      } else {
        // 取得对象
        opInfoWhenHtml(heroId,weaponType);
        editTeam(areaPart);
      }
    });

    // 黑棋选中事件
    $(".chessman_black").on('click',function(){
      if(startFlag && turn==0){
        alert('this is red trun');
      }
      $(".chessman_black").find('img').css('borderColor','black');
      $(this).find('img').css('borderColor','green');
    });

    // 红棋选中事件
    $(".chessman_red").on('click',function(){
      if(startFlag && turn==1){
        alert('this is black trun');
      }
      $(".chessman_red").find('img').css('borderColor','red');
      $(this).find('img').css('borderColor','green');
    });

});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initHtml(jsonData,areaId){
  document.getElementById(areaId).innerHTML = "";

  for(var i=0;i<=wenponCd.length;i++){
    var data = jsonData[wenponCd[i]];
    secondLoop(data,areaId)
  }
}

/*
 * 循环出人物信息
 */
function secondLoop(data,areaId){
    var parentDiv = document.createElement("div");
    parentDiv.className = "row";

    $.each(data,function(){
      var imgDiv = document.createElement("div");
      imgDiv.className = "img";
      imgDiv.id = this.id+":"+this.weaponType;
      var imgEle = document.createElement("img");
      imgEle.src = heroImagePath+this.imgName+"/face.png";
      imgDiv.appendChild(imgEle);

      parentDiv.appendChild(imgDiv);
  });
  document.getElementById(areaId).appendChild(parentDiv);
}

/*
 * 创建地图
 */
function createMap(){
  var mapObj = document.getElementsByClassName("map")[0];
  mapObj.innerHTML = "";
  for(var row=0;row<map.length;row++){
    var rowDiv = document.createElement("div");
    var rowIndex = row+1;
    rowDiv.className = "row";
    rowDiv.id = "row"+rowIndex;
    for(var col=0;col<map[row].length;col++){
      // 取得地图块信息
      var cellObj = map[row][col];
      // 创建列DIV
      var colDiv = document.createElement("div");
      var colInde = col+1;
      
      // 出击配置处
      if(cellObj.deploy){
        colDiv.style.backgroundColor="#d7e682b5";
        var deployColor = cellObj.deployType;
        // 创建棋子
        var chessman = document.createElement("div");
        var classNm = "";
        if('red'==deployColor){
          classNm = 'chessman_red';
        } else {
          classNm = 'chessman_black';
        }
        chessman.className = classNm;
        var imgElement = document.createElement("img");
        imgElement.style.borderColor=deployColor;
        chessman.appendChild(imgElement);
        colDiv.appendChild(chessman);
      }
      
      colDiv.id = rowIndex +"-"+colInde;
      colDiv.className = "mapCell";

      rowDiv.appendChild(colDiv);
    }
    mapObj.appendChild(rowDiv);
  }
  
}

/*
 * 通过武器类型和ID取得选取对象
 */
function opInfoWhenHtml(heroId,weaponType){
  heroObj = {};
  var data = jsonDate[weaponType];
  $.each(data,function(){
    if(this.id == heroId) {
      heroObj.titleName = this.titleName;
      heroObj.name = this.name;
      heroObj.imgName = this.imgName;
      heroObj.id = this.id;
      heroObj.weaponType = this.weaponType;
      heroObj.moveType = this.moveType;
      // 移动距离设定
      if(this.moveType=='02'){
        heroObj.moveSpace = 3;
      } else if (this.moveType=='04'){
        heroObj.moveSpace = 1;
      } else {
        heroObj.moveSpace = 2;
      }
      // 地形无视
      if(this.moveType=='03'){
        heroObj.moveIgnore = true;
      } else {
        heroObj.moveIgnore = false;
      }
      heroObj.hp = this.hp;
      heroObj.attact = this.attact;
      heroObj.speed = this.speed;
      heroObj.def = this.def;
      heroObj.mdf = this.mdf;
      return heroObj;
    }
  });
}

/*
 * 编组队伍
 */
function editTeam(areaPart){
  var teamImgs = $(".chessman_"+areaPart);
  for(var i=0;i<teamImgs.length;i++) {
    var imgObj = $(teamImgs[i]).find("img")[0];
    var imgStyle = imgObj.style.borderColor;
    var updateFlag = false;
    var imgSrc = heroImagePath+heroObj.imgName+"/face.png";
    if(imgStyle.length >0 && imgStyle.indexOf(areaPart)<0){
      imgObj.src = imgSrc;
      // 选择取消
      imgObj.style.borderColor=areaPart;
      updateFlag = true;
    }
    if(imgObj.src=="") {
      imgObj.src = imgSrc;
      updateFlag = true;
    }
    if(updateFlag){
      if("red"==areaPart){
        redTeam[i]=heroObj;
        printInfo(redTeam);
      } else {
        blackTeam[i]=heroObj;
        printInfo(blackTeam);
      }
      return;
    }
  }
}

/*
 * 游戏开始
 */
function gameStart(){
  if(redTeam.length<4 || blackTeam.length<4){
    var mes = confirm("有队伍成员未选,确认开始吗");
    if(!mes){
      return;
    }
  }
  // 出击配置处颜色取消
  $('.mapCell').css('background-color','');
  // 去除无内容棋子
  $.each($('.mapCell'),function(){
    var imgEle = $(this).find('img')[0]
    if(typeof(imgEle)=="undefined"){
      this.innerHTML = "";
    }else if("" == imgEle.src){
      this.innerHTML = "";
    }
  });
  // 切换BGM
  // $('#bgm').prop('src','attact.mp3');
  // 人物选择界面隐藏
  $('#redTeam').hide();
  $('#blackTeam').hide();
  createTeamMemberInfo('redTeamCombat',redTeam);
  createTeamMemberInfo('blackTeamCombat',blackTeam);
  
}

function createTeamMemberInfo(divId,team){
  var teamMemberArea = document.getElementById(divId);
  teamMemberArea.innerHTML = "";
  for(var i=0;i<team.length;i++){
    var member = team[i];
    // 父div
    var memberDiv = document.createElement("div");
    memberDiv.className='team_member';
    // 图片div
    var faceDiv = document.createElement("div");
    faceDiv.className='memberFace';
    // image
    var imgEle = document.createElement("img");
    imgEle.src = heroImagePath + member.imgName+"/face.png";
    
    faceDiv.appendChild(imgEle);
    memberDiv.appendChild(faceDiv);
    // 详细
    var infoDiv = document.createElement("div");
    infoDiv.className='memberInfo';
    var ulElement = document.createElement("ul");
    createAndAppendElement(ulElement,"li",member.titleName+'-'+member.name,null);
    createAndAppendElement(ulElement,"li",member.hp,null);
    createAndAppendElement(ulElement,"li",member.attact,null);
    createAndAppendElement(ulElement,"li",member.speed,null);
    createAndAppendElement(ulElement,"li",member.def,null);
    createAndAppendElement(ulElement,"li",member.mdf,null);

    infoDiv.appendChild(ulElement);
    memberDiv.appendChild(infoDiv);
    //
    teamMemberArea.appendChild(memberDiv);
  }
}

/*
 * 设置子元素值
 */
function createAndAppendElement(parentEle,childEleType,htmlText,valText){
  var childEle = document.createElement(childEleType);
  childEle.innerHTML = htmlText;
  childEle.value = valText;
  parentEle.appendChild(childEle);
}

function printInfo(obj){
  window.console.log(JSON.stringify(obj));
}