const shortName = 'db_html';
const version = '1.0';
const displayName = 'Display Information';
const maxSize = 5*1024*1024;
let db = openDatabase(shortName,version,displayName,maxSize);
let result = db ? 'success' : 'filed';

const columnMap = transListToMap(jsonData.columns,'name',true);
console.log(columnMap);
var recoderObj = jsonData.dataList[0];
var selectedData;

let paramObj = {
  "head" : "",
  "width" : "",
  "id" : "displayTable",
  "groupby" : "true",
  "fifter" : "true",
  "selectAll" : "true",
};
var orderby = 'asc';

function createTable(){
  let createTblSql = 'create table if not exists ' + jsonData.tableName +
    '(id integer primary key autoincrement'
  $.each(jsonData.columns,function(){
    createTblSql += ',' + this.name + ' ' + this.type +'(' + this.length +')';
  });
  createTblSql += ')';
  executeQuary(createTblSql);
}

function insertDataList() {
  let tblNm = jsonData.tableName;
  $.each(jsonData.dataList,function(i,recoderObj){
    insertData(tblNm,recoderObj);
  });
}

function insertData(tableName,recoderObj) {
  let keys = Object.keys(recoderObj);
  let colSql = "insert into "+ tableName +"("
  let valSql = " values ('";
  $.each(keys,function(i,col){
    colSql += col;
    valSql += recoderObj[col];
    if (i < keys.length - 1) {
      colSql += ",";
      valSql += "','";
    } else {
      colSql += ")";
      valSql += "')";
    }
  });
  let sql = colSql + valSql;
  executeQuary(sql);
}

function searchQuary(callback) {
  let sql = 'select * from ' + jsonData.tableName;
  executeQuary(sql,function(result){
    selectedData = result.rows;
    makeTableElement(result);
  });
}

/** 点击列重新排序
 *
 */
function reSearch(columnName) {
  orderby = 'asc' == orderby ? 'desc' : 'asc';
  let sql = 'select * from ' + jsonData.tableName;
  sql += ' order by ' + columnName + ' ' + orderby;
  reflashTable(sql);
}

/** 筛选数据
 * 
 */
function fifterRows(column,inputEle) {
  let sql = 'select * from ' + jsonData.tableName;
  sql += " where " + column + " like '%" +inputEle.value+"%'";
  reflashTable(sql);
}

/** 刷新结果区域
 *
 */
function reflashTable(sql) {
  executeQuary(sql,function(result){
    console.log(result.rows);
    //let tbody = $('#detailRows');
    document.getElementById('detailRows').outerHTML = '';
    document.getElementById('resultTbl').appendChild(createTbody(result));
  });
}

function executeQuary(query,callback){
  console.log(query);
  let db = openDatabase(shortName,version,displayName,maxSize);
  db.transaction(tx => {
    tx.executeSql(query,[],
      (tx,result) => {
        console.log('SQL-success:' + result);
        if (typeof callback == 'function') {
          callback(result);
        }
      },
      (tx,error) => {
        console.log('SQL-filed:' + error.message);
      }
    )
    return result;
  });
}

function makeTableElement(dataList){
  let columns = Object.keys(dataList.rows[0]);

  paramObj.head = columns;
  // Table
  var tableEle = createElement("table","resultTbl","","");
  tableEle.setAttribute("cellspacing",0);
  tableEle.border = "1";
  // Thead
  var thead = createElement("thead","","","");
  var tr = createElement("tr","","","");
  // fifter
  var fifterRow = createElement("tr","","fifterRow","");
  // selectAll
  if (isNotEmpty(paramObj.selectAll)) {
    var th = createElement("th","","","");
    // fifter row
    fifterRow.appendChild(createElement("th","","",""));
    
    var selectAll = createElement("input","","","selectAll");
    selectAll.type = "checkbox";
    $(selectAll).on("click",function(){
      var tblEle = $(this).parents("table")[0];
      var checkCnt = $(tblEle).find("input[type='checkbox']");
      $(checkCnt).attr("checked",this.checked);
    });
    th.appendChild(selectAll);
    tr.appendChild(th);
  }

  $.each(paramObj.head,function(){
    let classNm = isNotEmpty(paramObj.groupby) ? "orderbyCol" : "";
    let th = createElement("th","",classNm,"");
    th.innerHTML = this;
    // orderBy
    if (isNotEmpty(paramObj.groupby)) {
      th.setAttribute('onClick','reSearch("'+this+'")');
    }
    tr.appendChild(th);
    
    // fifter
    let fifterTh = createElement("th","","","");
    if (isNotEmpty(columnMap[this])){
      let widthSize = columnMap[this].length;
      let inputCol = createElement("input","","","fifter_"+this);
      // 输入框宽度
      inputCol.style.width = columnMap[this].fifterWidth;
      // Event
      inputCol.setAttribute('onChange','fifterRows("'+this+'",this)')
      fifterTh.appendChild(inputCol);
    }
    fifterRow.appendChild(fifterTh);
  });
  // 事件
  let eventTh = createElement("th","","","");
  eventTh.innerHTML = 'Action';
  tr.appendChild(eventTh);
 
  thead.appendChild(tr);
  // 
  if (isNotEmpty(paramObj.fifter)) {
    thead.appendChild(fifterRow);
  }
  tableEle.appendChild(thead);
  
  // tbody
  tableEle.appendChild(createTbody(dataList));
  document.getElementById('displayArea').appendChild(tableEle);
  //return tableEle;
}

function createTbody(dataList){
  // Tbody
  var tbody = createElement("tbody","detailRows","","");
  $.each(dataList.rows,function(){
    tr = createElement("tr","","","");
    // selectAll
    if (isNotEmpty(paramObj.selectAll)) {
      let selectTd = createElement("td","","","");
      let checkedEle = createElement("input","","","");
      checkedEle.type = "checkbox";
      selectTd.appendChild(checkedEle);
      tr.appendChild(selectTd);
    }
    // data
    $.each(this,function(j,cell){
      let td = createElement("td","","","");
      td.innerHTML = cell;
      tr.appendChild(td);
    });
    let id = this.id;
    let eventTd = createElement("td","","","");
    let updateBtn = createElement("button","","rowBtn","");
    updateBtn.style = "button";
    updateBtn.innerHTML = "更新";
    updateBtn.setAttribute('onclick',"updateRow('"+this.id+"')");
    eventTd.appendChild(updateBtn);
    
    let delBtn = createElement("button","","rowBtn","");
    delBtn.style = "button";
    delBtn.innerHTML = "删除";
    delBtn.setAttribute('onclick',"delete('"+this.id+"')");
    eventTd.appendChild(delBtn);
    
    tr.appendChild(eventTd);
    // event
    tbody.appendChild(tr);
  });
  return tbody;
}
