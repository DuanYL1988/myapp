var htmlFlag;
var path;
var imgBox = [{id:'col1',height:0},{id:'col2',height:0},{id:'col3',height:0}];
$(function() {
    // 未定义返回ture
    var htmlFlag = typeof(jsonData)=="undefined";
    if(htmlFlag){
        console.log("display from static html");
        path = "../../../resources/images/feh/";
        // 静态页面加载json数据
        ajaxGet("htmlJson.json",null,function(data){
            var jsonData = data;
            initlize(jsonData);
        });
    } else {
        path = "/myapp/resources/images/feh/";
        initlize(jsonData);
    }
});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initlize(jsonData){
    $.each(jsonData,function(){
        /*
           只是单纯文字列,得到图片信息需要再次取得元素对象所以不使用
         var imgHtml = "<img src='#{src}'/>";
        */
        // 直接创建img对象
        var imgEle = document.createElement('img');
        if(htmlFlag){
            imgEle.src=path+this.imageSrc;
        } else {
            imgEle.src=path+this.htmlimagesrc;
        }
        // 加载图片信息需要一段时间
        sleep(100);
        // 取得最短列id
        var targetId = getShortDivId(imgEle.height);
        // 添加图片元素
        document.getElementById(targetId).appendChild(imgEle);
    });
}

function getShortDivId(imageHeight){
    var shortest = imgBox[0];
    var index = 0;
    // 取得最短div
    for(var i=1;i<imgBox.length;i++){
        var current = imgBox[i].height;
        if (shortest.height > current){
            shortest = imgBox[i];
            index = i;
        }
    }
    // 更新长度
    imgBox[index].height += imageHeight;
    return shortest.id;
}

/**
 * 方法一加载出图片信息需要暂停执行一段时间
 */
function sleep(ms){
    for(var t=Date.now();Date.now()-t<=ms;);
}