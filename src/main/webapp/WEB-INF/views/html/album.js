var htmlFlag;
var heroImagePath = '/myapp/resources/images/feh/acter/';
var showLevel = 1;
var imageBox=[];

$(function() {
    // 未定义返回ture
    htmlFlag = typeof(mode)=="undefined";
    if(htmlFlag){
        console.log("display from static html");
        heroImagePath = "../../../resources/images/feh/acter/";
        // 静态页面加载json数据
        jsonData = imageList;
        initilizeImage();
        $.each(imageBox,function(){
          createImg(this);
        });
    } else {
      jsonData = JSON.parse(jsonDate);
    }

    $('#btn_cancel').on('click',function(){

    });
});

function initilizeImage(){
  imageBox=[];
  $.each(jsonData,function(){
    if(this.level<=showLevel){
      var folder = this.folder;
      $.each(this.images,function(){
        var imgPath = heroImagePath+folder + "/" + this;
        imageBox.push(imgPath);
      });
    }
  });
}

function createImg(src){
  var imgEle = document.createElement("img");
  imgEle.src=src;
  document.getElementById("main").appendChild(imgEle);
}