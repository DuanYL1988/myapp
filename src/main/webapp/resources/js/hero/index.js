var htmlFlag;
var path;
var imgBox = [{id:'col1',height:0},{id:'col2',height:0},{id:'col3',height:0},{id:'col4',height:0}];
$(function() {
    // 未定义返回ture
    var htmlFlag = typeof(jsonData)=="undefined";

    if(htmlFlag){
        console.log("display from static html");
        path = "../../../resources/images/feh/";
        // 静态页面加载json数据
        initlize(staticJson,htmlFlag);

    } else {
        path = "/myapp/resources/images/feh/";
        initlize(jsonData,htmlFlag);
    }
});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initlize(jsonData,htmlFlag){
    $.each(jsonData,function(){
        // div块
        var parentDivEle = document.createElement('div');
        parentDivEle.className = "ih-item square effect6 from_top_and_bottom";
        // 图片块
        var imgDiv = document.createElement('div');
        imgDiv.className = "img";
        // 链接
        var linkEle = document.createElement('a');
        // 直接创建img对象
        var imgEle = document.createElement('img');
        if(htmlFlag){
            imgEle.src = path+this.htmlimagesrc;
            linkEle.href = this.htmlurl;
        } else {
            imgEle.src = path+this.imageSrc;
            linkEle.href = this.actionUrl;
        }
        // 文字div
        var txtDivEle = document.createElement('div');
        txtDivEle.className = "info";
        var txtLine1 = document.createElement('h3');
        txtLine1.innerHTML = this.name
        var txtLine2 = document.createElement('p');
        txtDivEle.appendChild(txtLine1);
        txtDivEle.appendChild(txtLine2);
        
        // 图片块添加图片
        imgDiv.appendChild(imgEle);
        
        // 连接块添加图片块
        linkEle.appendChild(imgDiv);
        
        // 连接块添加文本块
        linkEle.appendChild(txtDivEle);
        
        parentDivEle.appendChild(linkEle);
        // 加载图片信息需要一段时间
        sleep(50);
        // 取得最短列id
        var targetId = getShortDivId(imgEle.height);
        // 添加图片元素
        document.getElementById(targetId).appendChild(parentDivEle);
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