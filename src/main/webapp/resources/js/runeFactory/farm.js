$(function() {
    var farmType = $("#farmType").val();
    var farm = document.getElementById('firstFarm');
    if ("01" == farmType) {
        farm.style.display = "";
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

});

function createDiv(id, classNm, farm) {
    var aEle = document.createElement("a");
    aEle.href = "#";
    aEle.className = classNm;
    var div = document.createElement("div");
    div.id = id;
    if ("item_farm" == classNm) {
        var farmInfo = "";
        farmInfo += "作物:" + setValue(farm.cropNm);

        div.innerHTML = farmInfo;

        aEle.id = farm.id;
        aEle.onmousedown = function() {
            setFarmInfo(farm);
            if ("item_farm_clicked" == aEle.className) {
                aEle.className = "item_farm";
            } else {
                aEle.className = "item_farm_clicked";
            }
        }
    }
    aEle.appendChild(div);
    return aEle;
}

function setFarmInfo(farm) {
    $("#farmId").val(farm.id);
    $("#cropId").val(farm.cropId);
    $("#cropNm").val(farm.cropNm);
    $("#startDate").val(farm.startDate);
}

function seed(type) {
    if ('batch' == type) {
        var idList = "";
        $.each($("a[class='item_farm_clicked']"), function() {
            idList += this.id + ",";
        })
        idList += "0";

        var param = {
            "cropId": $("#sctCorpId").val(),
            "farm.cropId": $("#sctCorpId").val(),
            "gameDate": $("#gameDate").val(),
            "farmIdList": idList
        }

        ajaxPost('/myapp/rune/seed', param, function(data) {
            console.log(data);
        });
    }
}

function setValue(value) {
    if ("undefined" == value || typeof value == "undefined" || null == value) {
        return "";
    } else {
        return value;
    }
}