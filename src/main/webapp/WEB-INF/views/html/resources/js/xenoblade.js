var baseImgPath = '../../../resources/images/xenoblade/face/';
var attrMap = {};
var bladeMap = {};
let team = ["", "", ""];
let tblRecords = [];

$(function() {
  attrMap = createMap("ATTR",bladeList);
  bladeMap = createMap("ID",bladeList);
  //
  var tableTh = ["异刃连击1","异刃连击2","异刃连击3","",""];
});

/**
 * 通用方法:将list进行group处理成map
 * @param keyNm Group化项目名
 * @param dataList 元数据集合
 */
function createMap(keyNm,dataList) {
  var rstMap = {};
  $.each(dataList,function(i,data){
    // key不存在
    var key = data[keyNm];
    if (isEmpty(rstMap[key])){
      var obj = [];
      obj.push(data);
      rstMap[key] = obj;
    } else {
      rstMap[key].push(data);
    }
  });
  return rstMap;
}

/**
 * 取得第三异刃
 */
function getThirdBladelist(selectEle){

  document.getElementById("firstBlade").innerHTML = "";
  document.getElementById("secondBlade").innerHTML = "";
  var info = createPulldown("thirdBlade",[selectEle.value]);
  // 结果
  tblRecords = [];
  $.each(info,function(){
    var rowData = {"combo1":{},"combo2":{},"combo3":{}};
    var blade = bladeMap[this.code][0];
    rowData.combo3 = blade;
    tblRecords.push(rowData);
  });
  reflushTable(tblRecords);
}

/**
 * 选择第一或第二异刃刷新结果
 */
function filterTable(){
  let firstId = document.getElementById("firstBlade").value;
  let secondId = document.getElementById("secondBlade").value;
  
  var newTbl = [];
  $.each(tblRecords,function(){
    if((this.combo1.ID == firstId || ""==firstId) && (this.combo2.ID == secondId || ""==secondId)) {
      newTbl.push(this);
    }
  });
  reflushTable(newTbl);
}

/**
 * 最终连击异刃,查找连击组合
 */
function getComboListWithLast(selectEle){
  // 确认连击队伍
  team = ["","",selectEle.value];
  // 第三异刃情报
  var thirdBlade = bladeMap[selectEle.value][0];
  var thirdAttr = thirdBlade.ATTR;
  // 获得连击可能性集合
  var newComboList = getNewComboList(thirdAttr);
  
  // 结果
  tblRecords = [];
  // 循环可能所有可能组合
  var select1 = [];
  var select2 = [];
  $.each(newComboList,function(i,combo){
    // 第一异刃
    var firstBladeList = attrMap[combo[0]];
    select1.push(combo[0]);
    // 第二异刃
    var secondBladeList = attrMap[combo[1]];
    select2.push(combo[1]);
    
    // 循环第一异刃所有组合
    /**/
    $.each(firstBladeList,function(j,firstBlade){
      // 已确认的第三异刃
      var record = team;
      // 异刃不重复
      if (!isInclude(firstBlade.ID,record)){
        record[0] = firstBlade.ID;
        // 循环第二异刃
        $.each(secondBladeList,function(k,secondBlade){
          if (!isInclude(secondBlade.ID,record)) {
            record[1] = secondBlade.ID;
            tblRecords.push({"combo1":firstBlade,"combo2":secondBlade,"combo3":thirdBlade});
          }
        })
      }
    });
  });
  
  // 下拉框
  createPulldown("firstBlade",select1);
  createPulldown("secondBlade",select2);
  
  // 去除重复
  $.each(tblRecords,function(i,team1){
    for(let j=tblRecords.length-1;j>i;j--) {
      let team2 = tblRecords[j];
      if (team1.combo1.ID == team2.combo2.ID && team1.combo2.ID == team2.combo1.ID) {
        tblRecords.splice(j,1);
      }
    }
  });
  
  console.log(tblRecords.length);
  reflushTable(tblRecords);
}

/**
 * 取得可能的连协路径
 */
function getNewComboList(thirdAttr){
  var newComboList = [];
  $.each(comboList,function(){
    if(thirdAttr === this[2]){
      newComboList.push(this);
    }
  });
  return newComboList;
}

/**
 * 刷新结果
 */
function reflushSelectBlade(index,selectEle){
  var bladeId = selectEle.value;
  if (0 == index) {
    var info = createPulldown("firstBlade",bladeId);
  } else if (1 == index){
    var info = createPulldown("secondBlade",bladeId);
  }
}

/**
 * 异刃选择下拉框
 */
function createPulldown(selectId,attrs) {
  var info = [];
  $.each(attrs,function(index,attr){
    $.each(attrMap[attr],function(){
      info.push({"code" : this.ID,"value" : this.NAME,"master" : this.MASTER});
    });
  });
  document.getElementById(selectId).innerHTML = "";
  createOptions(document.getElementById(selectId),info,true);
  return info;
}

/**
 * 更新结果
 */
function reflushTable(dataList){
  var tbl = document.getElementById("resultDataTbl");
  var tbody = tbl.getElementsByTagName("tbody")[0];
  // 初始化
  tbody.innerHTML = "";
  $.each(dataList,function(){
    var trEle = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    // COL3
    createImgTd(this.combo1,td1,trEle)
    createImgTd(this.combo2,td2,trEle)
    createImgTd(this.combo3,td3,trEle)

    tbody.appendChild(trEle);
  });
}

function createImgTd(blade,tdElement,trElement){
  if (isNotEmpty(blade.ID)){
    var imgEle = document.createElement("img");
    imgEle.src = baseImgPath + blade.ID + ".jpg";
    imgEle.className = "tdImg";
    tdElement.appendChild(imgEle);
    var imgEle2 = document.createElement("img");
    imgEle2.src = baseImgPath + blade.MASTER + ".jpg";
    imgEle2.className = "tdImg";
    tdElement.appendChild(imgEle2);
  }
  trElement.appendChild(tdElement);
}