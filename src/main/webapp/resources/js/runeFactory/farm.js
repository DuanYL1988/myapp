var getCount = 0;
var getMoney = 0;
var compIdArr = [];
var todoArr = [];
// 空闲土地
var todoCnt = 0;
$(function() {
    var farmType = $("#farmType").val();
    var farm = document.getElementById('firstFarm');
    if ("" != farmType) {
        farm.style.display = "";
        if ("02" == farmType || "03" == farmType) {
            farm.className = "earth_dragon";
            $('body').css("zoom","1");
        } else if ("04" == farmType) {
            farm.className = "ice_dragon";
            $('body').css("zoom","0.85");
            farm.style.left = '12%';
        } else {
            $('body').css("zoom","1");
        }
    }

    var index = 1;
    var parentFarm = createDiv("first_" + index, "parent_cell");
    jsonData = JSON.parse(jsonData);
    for (var row = 1; row <= jsonData.length; row++) {
        if ((row - 1) % 4 == 0) {
            parentFarm = createDiv("first_" + index, "parent_cell");
        }
        parentFarm.appendChild(createDiv("first_" + index + "_" + row, "item_farm", jsonData[row - 1]));
        if (row % 4 == 0) {
            farm.appendChild(parentFarm);
            index++;
        }
    }

    if(getCount>0){
        $("#100count").html(getCount);
        $("#100price").html(getMoney);
    }
});

/**
 * 农田信息
 */
function createDiv(id, classNm, farm) {
    var div = document.createElement("div");
    div.className = classNm;
    div.id = id;
    if ("item_farm" == classNm) {
        var compFlag = false;
        if (isNotEmpty(farm.cropId)) {
            var farmObj = calFarmInfo(farm);
            var farmInfo = "";
            farmInfo += "<span class='farmCellTitle'>" + setValue(farm.cropNm) +'</span><br>';
            farmInfo += setValue(farm.startDate) + '~' + farmObj.endDate +'<br>';
            // 二熟植物残HP
            if (isNotEmpty(farm.nameExpand4)) {
                farmInfo += 'HP:' + setValue(farm.cropHp,'0') +'<br>';
            }
            // 成熟植物
            if ('100%' == farmObj.persent) {
                div.style.backgroundColor = "#707162";
                getCount++;
                getMoney = getMoney + (parseFloat(farmObj.price)*parseFloat(farmObj.count));
                if (isEmpty(farm.nameExpand4)) {
                    compIdArr.push(farm.id);
                }
                compFlag = true;
            }
            farmInfo += farmObj.persent +'<br>';
            
            farmInfo += 'Lv:' +farmObj.totalLevel + ';Heal:' + farmObj.health +'<br>';
            div.innerHTML = farmInfo;
        } else {
            todoCnt ++ ;
            todoArr.push(farm.id);
        }

        div.id = farm.id;
        div.onclick = function() {
            setFarmInfo(farm);
            if ("item_farm" == div.className) {
                div.className = "item_farm_clicked";
            } else {
                div.className = "item_farm";
            }
        }
        
        if (!compFlag) {
            div.onmouseover = function(){
                div.style.backgroundColor = "#7dd069e0";
            }
            div.onmouseout = function(){
                if ("item_farm"==div.className) {
                    div.style.backgroundColor = "#adb16f";
                } else {
                    div.style.backgroundColor = "#8a6183";
                }
            }
        }
    }
    return div;
}

function calFarmInfo(farm){
    // 适应季节
    var season = setValue(farm.nameExpand6);
    // 一熟日期
    var explant1 = setValue(farm.nameExpand3);
    // 2熟日期
    var explant2 = setValue(farm.nameExpand4);
    // 播种时间
    var stDate = farm.startDate;
    // HP
    farm.cropHp = setValue(farm.cropHp);
    // 收获
    getEndDate(stDate,explant1,explant2,season,farm);
    // 售价
    farm['price']= farm.nameExpand2;
    // 个数
    farm['count']= farm.nameExpand3;
    
    return farm;
}

/**
 * 间隔
 */
function getDays(startDate,endDate) {
    var startDay = parseInt(startDate.split('/')[1]);
    var endDay =  parseInt(endDate.split('/')[1]);
    if (startDay > endDay) {
        endDay = endDay+30;
    }
    return  endDay - startDay;
}

/**
 * 取得收获日
 */
function getEndDate(stDate,explant1,explant2,season,farm) {
    var endDate = stDate;
    //compareDate
    var persent = parseFloat(0.00);
    var displayP;
    var currM = "";
    while(persent<explant1){
        var dayP = 1;
        endDate = changeDate("add",endDate);
        currM = endDate.split('/')[0];
        // 合适月
        if (season.indexOf(currM) >= 0) {
            dayP = parseFloat(1.5);
        }
        // 土地补正
        dayP = dayP * parseFloat(farm.speedLevel);
        persent = persent + dayP;
        // 进度
        if (0 == compareDate($("#gameDate").val(),endDate)) {
            displayP = parseFloat(persent/explant1);
            displayP = displayP > 1 ? 1:displayP;
        }
    }
    // 多熟
    if (parseInt(explant2) > 0 && compareDate(endDate,$("#gameDate").val()) > 0) {
        // 下次成熟间隔
        var days = getDays(endDate,$("#gameDate").val());
        days = (parseInt(days) + parseInt(explant2)) % parseInt(explant2);
        // 当天为止进度
        while(compareDate(endDate,$("#gameDate").val())>=0) {
            var dayP = 1;
            endDate = changeDate("add",endDate);
            currM = endDate.split('/')[0];
            // 合适月
            if (season.indexOf(currM) >= 0) {
                dayP = parseFloat(1.5);
            }
            // 土地补正
            dayP = dayP * parseFloat(farm.speedLevel);
            persent = persent + dayP;
            persent = persent > parseFloat(explant2) ? 0:persent;
            // 进度
            displayP = parseFloat(persent/explant2);
        }
        // 下次成熟时间
        while(persent<explant2){
            var dayP = 1;
            endDate = changeDate("add",endDate);
            currM = endDate.split('/')[0];
            // 合适月
            if (season.indexOf(currM) >= 0) {
                dayP = parseFloat(1.5);
            }
            // 土地补正
            dayP = dayP * parseFloat(farm.speedLevel);
            persent = persent + dayP;
        }
    }
    displayP = displayP * 100;
    displayP = displayP.toFixed(0) + "%";

    farm['endDate'] = endDate;
    farm['persent'] = displayP;
}

function setFarmInfo(farm) {
    $("#farmId").val(farm.id);
    $("#location").val(farm.location);
    $("#parentFarm").val(farm.parentFarm);
    $("#cropId").val(farm.cropId);
    $("#cropNm").val(farm.cropNm);
    $("#cropHp").val(farm.cropHp);
    $("#startDate").val(farm.startDate);

    $("#totalLevel").val(farm.totalLevel);
    $("#health").val(farm.health);
    $("#sizeLevel").val(farm.sizeLevel);
    $("#speedLevel").val(farm.speedLevel);
    $("#qualityLevel").val(farm.qualityLevel);
    $("#countLevel").val(farm.countLevel);
}

/**
 * ajax更新
 */
function seed(type) {
    $("#mode").val(type);
    if ('batchPut' == type || 'batchGet' == type) {
        var idList = "";

        $("#mode").val('batch');
        
        $.each($("div[class='item_farm_clicked']"), function() {
            idList += this.id + ",";
        });
        
        if ('batchPut' == type) {
            // 种子
            if (isEmpty($("#sctCorpId").val())){
                alert('选择种子');
                return;
            }
            if (isEmpty(idList)){
                $.each(todoArr, function() {
                    idList += this + ",";
                });
            }
            
            $("#selectCorpId").val($("#sctCorpId").val());
        } else {
            $("#selectCorpId").val("");
            if (isEmpty(idList)){
                $.each(compIdArr, function() {
                    idList += this + ",";
                });
            }
        }
        idList += "0";
        $("#farmIdList").val(idList);
        
        $("form")[0].submit();

    } else if ("updateDate" == type) {
        var param = {
            "selectCorpId": "999",
            "gameDate": $("#gameDate").val()
        }
        ajaxPost('/myapp/rune/seed', param, function(data) {
            console.log(data);
        });
        return;
    }
    $("form")[0].submit();
}

function setValue(value,defVal) {
    if (isEmpty(value)) {
        return isEmpty(defVal) ? "" : defVal;
    } else {
        return value;
    }
}

/**
 * 比较日期
 */
function compareDate(stDate,edDate){
    var stM = stDate.split('/')[0];
    var edM = edDate.split('/')[0];
    if (parseInt(edM) > parseInt(stM)){
        return 1;
    } else if (parseInt(stM) == parseInt(edM)) {
        var stD = stDate.split('/')[1];
        var edD = edDate.split('/')[1];
        if (parseInt(edD) > parseInt(stD)) {
            return 1;
        } else if (parseInt(edD) == parseInt(stD)) {
            return 0;
        } else {
            return -1;
        }
    } else {
        if (parseInt(edM) == 1 && parseInt(stM) == 4) {
            return 1;
        } else {
            return -1;
        }
    }
}

/** 
 * 游戏时间变更
 */
function changeDate(type,gameDate) {
    if (isEmpty(gameDate)) {
         gameDate = $("#gameDate").val();
    }
    var month = gameDate.split('/')[0];
    var day = gameDate.split('/')[1];
    if ('next' == type || 'add' == type) {
        day = parseInt(day) + 1;
    } else {
        day = parseInt(day) - 1;
    }
    
    if (day == 31) {
        day = 1;
        month = parseInt(month) + 1;
    } else if (day == 0) {
        day = 30;
        month = parseInt(month) - 1;
    }
    
    if (month == 5) {
        month = 1;
    } else if (month == 0) {
        month = 4;
    }
    
    if ('add' == type) {
        return month+'/'+day;
    }
    
    $("#gameDate").val(month+'/'+day);
}