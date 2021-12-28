const shortName = 'db_html';
const version = '1.0';
const displayName = 'Display Information';
const maxSize = 5*1024*1024;
let db = openDatabase(shortName,version,displayName,maxSize);
let result = db ? 'success' : 'filed';

// 列List转为列对象MAP
const columnMap = transListToMap(jsonData.columns,'name',true);

// 检索设定参数
let paramObj = {
  "head" : "",
  "width" : "",
  "id" : "displayTable",
  "groupby" : "true",
  "fifter" : "true",
  "selectAll" : "true",
};

// 上次执行过的检索SQL
var searchedQuary;

// 上次检索后的结果对象
var selectedData;

// 默认排序
var orderby = 'asc';

/** 创建表
 *
 */
function createTable(){
  let createTblSql = 'create table if not exists ' + jsonData.tableName +
    '(id integer primary key autoincrement'
  $.each(jsonData.columns,function(){
    createTblSql += ',' + this.name + ' ' + this.type +'(' + this.length +')';
  });
  createTblSql += ')';
  executeQuary(createTblSql);
}

/** 批量插入数据
 *
 */
function insertDataList() {
  let tblNm = jsonData.tableName;
  $.each(jsonData.dataList,function(i,recoderObj){
    insertData(tblNm,recoderObj);
  });
}

/*当前行数据插入
 *
 */
function insertRow(btnEle){
  let recoderObj = {};
  let rowEle = $(btnEle).parents()[1];
  $.each($(rowEle).find("input"),function(){
    recoderObj[this.name] = this.value;
  });
  console.log(recoderObj);
  insertData(jsonData.tableName,recoderObj);
  
  reflashTable(searchedQuary);
}

/** 插入数据
 *
 */
function insertData(tableName,recoderObj) {
  //let keys = Object.keys(recoderObj);
  let keys = jsonData.columns;
  let colSql = "insert into "+ tableName +"("
  let valSql = " values ('";
  $.each(keys,function(i,col){
    colSql += this.name;
    valSql += recoderObj[this.name];
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

/** 删除表
 * 
 */
function dropTable(tableNm) {
  let sql = 'drop table ' + tableNm;
  executeQuary(sql);
}

/** 创建select文
 * 
 */
function getSelectQuary(columns,tableName,condition,orderby,from,to,pageSize,pageNo) {
  let sql = "SELECT * FROM " + jsonData.tableName;
  sql += " where 1 = 1 and masterId = '4' ";
  return sql;
}

/** 检索DB
 *
 */
function searchQuary(callback) {
  searchedQuary = 'select * from ' + jsonData.tableName;
  executeQuary(searchedQuary,function(result){
    selectedData = result.rows;
    makeTableElement(result,"mianTbl");
  });
}

/** 点击列重新排序
 *
 */
function reSearch(columnName) {
  orderby = 'asc' == orderby ? 'desc' : 'asc';
  searchedQuary = 'select * from ' + jsonData.tableName;
  searchedQuary += ' order by ' + columnName + ' ' + orderby;
  reflashTable(searchedQuary);
}

/** 筛选数据
 * 
 */
function fifterRows(column,inputEle) {
  searchedQuary = 'select * from ' + jsonData.tableName;
  searchedQuary += " where " + column + " like '%" +inputEle.value+"%'";
  reflashTable(searchedQuary);
}

/** 刷新结果区域
 *
 */
function reflashTable(sql) {
  executeQuary(sql,function(result){
    console.log(result.rows);
    document.getElementById('detailRows').outerHTML = '';
    document.getElementById('mianTbl').appendChild(createTbody(result));
  });
}

/** WebSql执行sql
 *
 */
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

/** 显示检索数据一览
 * 
 */ 
function makeTableElement(dataList,tblEleId){
  // 结果列
  let columns = Object.keys(dataList.rows[0]);
  // 设定参数更新
  paramObj.head = columns;
  // Table
  var tableEle = document.getElementById(tblEleId);
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
    // 全选事件
    $(selectAll).on("click",function(){
      var tblEle = $(this).parents("table")[0];
      var checkCnt = $(tblEle).find("input[type='checkbox']");
      $(checkCnt).attr("checked",this.checked);
    });
    th.appendChild(selectAll);
    tr.appendChild(th);
  }

  // 结果设定
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
      // 设置id属性,后面追加 更新入力框设定name用
      let inputCol = createElement("input","","","fifter_"+this);
      // 输入框宽度
      inputCol.style.width = columnMap[this].fifterWidth;
      // 筛选事件
      inputCol.setAttribute('onChange','fifterRows("'+this+'",this)')
      fifterTh.appendChild(inputCol);
    }
    fifterRow.appendChild(fifterTh);
  });
  // 行事件
  let eventTh = createElement("th","","","");
  eventTh.innerHTML = 'Action';
  tr.appendChild(eventTh);
 
  thead.appendChild(tr);
  
  // 筛选功能设定有
  if (isNotEmpty(paramObj.fifter)) {
    fifterRow.appendChild(createElement("th","","",""));
    thead.appendChild(fifterRow);
  }
  tableEle.appendChild(thead);
  
  // tbody
  tableEle.appendChild(createTbody(dataList));
  document.getElementById('displayArea').appendChild(tableEle);
  //return tableEle;
}

/** 下拉框从codeMaster中取值设定选项
 *
 */
function getOptionsFromCodeMaster(selectEle,categoryId){
  //let sql = "select * from CODE_MASTER where categoryId ='"+categoryId+"'";
  let sql = "select * from CODE_MASTER ";
  executeQuary(sql,function(result){
    selectEle.appendChild(createElement('option','','',''));
    $.each(result.rows,function(){
      let optionEle = createElement('option','','','');
      optionEle.value = this.code;
      optionEle.innerHTML = this.value;
      selectEle.appendChild(optionEle);
    })
  });
}

/** 显示检索结果
 *
 */
function createTbody(dataList){
  // Tbody
  var tbody = createElement("tbody","detailRows","","");
  $.each(dataList.rows,function(i){
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
    $.each(this,function(key,cell){
      let id = "row" + i + "_" + key;
      let td = createElement("td",id,"","");
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

/** 新加一条数据
 *
 */
function addLine(){
  let tbody = document.getElementById('detailRows');
  let rowEle = $(tbody).children()[0];
  let newRow = createElement("tr","","","");
  let maxLength = $(rowEle).children().length;
  $.each($(rowEle).children(),function(i,tdEle){
    let newTd = createElement("td","","","");
    if(i>1 && i < maxLength-1) {
      let name = tdEle.id.split("_")[1];
      let inputEle = createElement("input","","",name);
      inputEle.style.width = tdEle.clientWidth -10 + "px";
      inputEle.value = tdEle.innerHTML;
      newTd.innerHTML = "";
      newTd.appendChild(inputEle);
    } else if (i == maxLength-1) {
      let addBtn = createElement("button","","rowBtn","");
      addBtn.style = "button";
      addBtn.innerHTML = "追加";
      addBtn.setAttribute('onclick',"insertRow(this)");
      newTd.appendChild(addBtn);
    }
    newRow.appendChild(newTd);
  });
  console.log(newRow);
  tbody.appendChild(newRow);
}
