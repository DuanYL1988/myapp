var heroImagePath = '/myapp/resources/images/feh/acter/';
var wenponCd = ['R-W', 'R-M', 'R-D', 'R-B', 'R-BOW', 'R-Dart',
    'B-W', 'B-M', 'B-D', 'B-B', 'B-BOW', 'B-Dart',
    'G-W', 'G-M', 'G-D', 'G-B', 'G-BOW', 'G-Dart',
    'N-W', 'N-Dart', 'N-Staff', 'N-D', 'N-B'];
var colorMoveCd = ['01', '02', '03', '04'];
// 选中的ID
var selectedId = 0;
// 选中的基本名
var selectedImgNm = "";
// 分隔符
var SPLIT_MK = ",";

$(function() {
    // 未定义返回ture
    htmlFlag = typeof (mode) == "undefined";

    jsonDate = JSON.parse(jsonDate);
    initHtml(jsonDate);
    hideTeam(1);

    // 选择部图片Id,基本path取得
    $('.img').on('click', function() {
        selectedId = this.id.split(SPLIT_MK)[0];
        selectedImgNm = this.id.split(SPLIT_MK)[1];

        // 选中样式变更
        $('.img').prop('className','img');
        $(this).prop('className','img selected');
    });

    $('.teamMemberDiv').on('click',function(){
        editTeamMember(this);
    });
});

/**
 * 静态html打开时,读取json设置隐藏区域的图片
 */
function initHtml(jsonData) {
    var displayGroup = $("#display_group").val();
    displayGroup = null == displayGroup ? "A" : displayGroup;

    if ("A" == displayGroup) {
        for (var i = 0; i <= wenponCd.length; i++) {
            var data = jsonData[wenponCd[i]];
            secondLoop(data)
        }
    } else {
        for (var i = 0; i <= colorMoveCd.length; i++) {
            var data = jsonData[colorMoveCd[i]];
            secondLoop(data)
        }
    }
}

function secondLoop(data) {
    var parentDiv = createElement('div', '', 'row');
    var rightDiv = createElement('div', '', 'rightArea');

    $.each(data, function() {
        var cellDiv = createElement('div', '', 'ih-item circle effect19');

        var spinner = createElement('div', '', 'spinner');
        cellDiv.appendChild(spinner);

        var imgDiv = createElement('div', this.id + SPLIT_MK + this.imgName, 'img');
        var imgEle = createImg(heroImagePath + this.imgName + "/face.png", '', '');
        imgDiv.appendChild(imgEle);
        cellDiv.appendChild(imgDiv);

        var infoDiv = createElement('div', '', 'info');
        var infoBackDiv = createElement('div', '', 'infoBackDiv');
        var h3Ele = createElement('h3', '', '');
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
 * 20组中表示5组队伍
 */
function hideTeam(teamNo) {
    teamNo = parseInt(teamNo);
    var st = ((teamNo - 1) * 5) + 1;
    var ed = teamNo * 5;
    $("div[class='team']").hide();

    $.each($("div[class='team']"), function() {
        var inputEle = $(this).find("input[type='hidden']")[0];
        var getId = parseInt(inputEle.value);
        if (getId >= st && getId <= ed) {
            $(this).show();
        }
    });
}

/**
 * 编队
 */
function editTeamMember(btnElement){
    // 没有被选队员
    if (selectedId == 0){
        return;
    }
    // 锁定判断
    var parent = $(btnElement).parent();
    lockChk = $(parent).find("input[class='lockTeam']")[0];
    if (lockChk.checked) {
        alert("该队伍被锁定,无法编辑");
        return;
    }
    // 更新队员Id
    btnElement.id = selectedId + SPLIT_MK + selectedImgNm;
    // 更新头像
    var imgEle = $(btnElement).children("img[class='memeberImg']")[0];
    imgEle.src = heroImagePath + selectedImgNm + "/face.png";
    
    // 取消被选
    $('.img').prop('className','img');
    selectedId = 0;
    
    //
    hidnHeroInTeam();
}

/**
 * 异步检索
 */
function ajaxSearch() {
    var jsonObj = $('#ajaxSearchForm').serializeObject();
    console.log(jsonObj);
}

/**
 * 队伍中成员备选区不显示
 */
function hidnHeroInTeam(){
    $('.img').show();
    var hideFlg = document.getElementById("hidnHeroChk").checked;
    if (hideFlg) {
        $.each($('.teamMemberDiv'),function(){
            var id = this.id.split(SPLIT_MK)[0];
            $("div[class='img'][id^='"+ id + SPLIT_MK + "']").css('display','none');
        });
    }
}

function updateTeam(teamId, btnElement) {
    var parentEle = $(btnElement).parent();
    var teamMemberId = "";
    $.each($(parentEle).find("div[class='teamMemberDiv']"), function() {
        teamMemberId += this.id.split(SPLIT_MK)[0] + SPLIT_MK;
    });
    var jsonObj = { 'teamNo': teamId, 'teamMember': teamMemberId };
    console.log(jsonObj);
    
    var url = "/myapp/hero/updateTeam";
    ajaxPost(url,jsonObj,function(data){
        if(data.code=="SUCCESS"){
            var lockChk = $(btnElement).next()[0];
            lockChk.checked = true;
        }
    });
}