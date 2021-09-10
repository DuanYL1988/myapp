var htmlFlag;
var imageBox = [];
var currentIndex = -1;
var imgHeight = '1080px';

$(function() {

    if ('feh' == type) {
        imageBox = ['normal.png', 'attact.png', 'extra.png', 'break.png'];
    } else if ('fgo' == type) {
        imageBox = ['Stage1.png', 'Stage2.png', 'Stage3.png', 'Stage4.png'];
    }

    initilizeImage();

    $(document).on('keydown', function(event) {
        if (currentIndex < 0) {
            return;
        }
        if (event.keyCode == 37 || event.keyCode == 65) {
            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = imageBox.length - 1;
            }
        } else if (event.keyCode == 39 || event.keyCode == 68) {
            currentIndex++;
            if (currentIndex >= imageBox.length) {
                currentIndex = 0;
            }
        }
        var src = imageBox[currentIndex];
        $("#showFullImg").attr('src', path + "/" + src);
    });
});

function initilizeImage() {

    $.each(imageBox, function(index, imgSrc) {
        createImg(path + "/" + imgSrc, index);
    });

    var popupFlag = window.opener != null;
    if (popupFlag) {
        if (type) {
            $("#showFullImg").css('height', imgHeight);
        }
        $("#showFullImg").css('height', height + 'px');
    }
    currentIndex = 0;
    $("#showFullImg").attr('src', path + "/" + imageBox[0]);
}

function createImg(src, index) {
    var imgEle = document.createElement("img");
    imgEle.src = src;
    imgEle.onclick = function() {
        showImg(imgEle, index);
    };
    document.getElementById("navImg").appendChild(imgEle);
}

function showImg(imgEle, index) {
    currentIndex = index;
    $("#showFullImg").attr('src', imgEle.src);
}

function showInWindows() {
    var maxWidth = document.body.clientWidth + 'px';
    //var windows = $(document);
    var showDiv = $("#showWindow")[0];
    if (showDiv.className == "showWindow") {
        $("#sctFolder").css('display', 'none');
        document.documentElement.requestFullscreen();
        $("#navite").css('display', 'none');
        showDiv.className = "showFullWindow";
        showDiv.style.width = maxWidth;
        $("#showFullImg").css('height', '1080px');
    } else {
        location.reload();
    }
}