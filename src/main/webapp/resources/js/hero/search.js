var path;
$(function() {
    // 未定义返回ture
    var htmlFlag = typeof(mode)=="undefined";
    if(htmlFlag){
        console.log("display from static html");
        path = "../../../resources/images/feh/acter/";
        // 静态页面加载json数据
        ajaxGet("searchList.json",null,function(data){
            var jsonData = data;
            initHtml(jsonData);
        });
    }
});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initHtml(jsonData){
  document.getElementById("main").innerHTML = "";
  for(var i=1;i<=23;i++){
    var id = i;
    if (id<10) {
      i = "0"+i;
    }
    var data = jsonData["0002-"+i];
    secondLoop(i,data)
  }
}

function secondLoop(id,data){
    var parentDiv = document.createElement("div");
    parentDiv.className = "row";
    
    var leftDiv = document.createElement("div");
    leftDiv.className = "leftArea";
    
    var textEle = document.createElement("p");
    textEle.innerHTML = id;
    leftDiv.appendChild(textEle);
    parentDiv.appendChild(leftDiv);
    
    var rightDiv = document.createElement("div");
    rightDiv.className = "rightArea";
    
  $.each(data,function(){
    
    var cellDiv = document.createElement("div");
    cellDiv.className = "ih-item circle effect19";
    var linkEle = document.createElement("a");
    linkEle.href = "detail.html";
    
    var spinner = document.createElement("div");
    spinner.className = "spinner";
    linkEle.appendChild(spinner);
    
    var imgDiv = document.createElement("div");
    imgDiv.className = "img";
    var imgEle = document.createElement("img");
    imgEle.src = path+this.imgName+"/face.png";
    imgDiv.appendChild(imgEle);
    linkEle.appendChild(imgDiv);
    
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
    linkEle.appendChild(infoDiv);
    
    cellDiv.appendChild(linkEle);
    rightDiv.appendChild(cellDiv);
  });
  parentDiv.appendChild(rightDiv);
  document.getElementById("main").appendChild(parentDiv);
}