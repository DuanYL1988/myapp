const shortName = 'db_html';
const version = '1.0';
const displayName = 'Display Information';
const maxSize = 5*1024*1024;
let db = openDatabase(shortName,version,displayName,maxSize);
let result = db ? 'success' : 'filed';

const columnMap = transListToMap(jsonData.columns,'name',true);
var selectedData;

let paramObj = {
  "head" : "",
  "width" : "5000px",
  "id" : "displayTable",
  "groupby" : "true",
  "fifter" : "true",
  "selectAll" : "true",
};
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
  let sql = getSelectQuary('','','','','','','','');
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
  let sql = getSelectQuary('','','','','','','','');
  sql += ' order by ' + columnName + ' ' + orderby;
  reflashTable(sql);
}

/** 筛选数据
 * 
 */
function fifterRows(column,inputEle) {
  let sql = getSelectQuary('','','','','','','','');
  sql += " and " + column + " like '%" +inputEle.value+"%'";
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
    if (isNotEmpty(columnMap[this]) && isEmpty(columnMap[this].hide)) {
      let th = createElement("th","",classNm,"");
      th.innerHTML = columnMap[this].title;
      // orderBy
      if (isNotEmpty(paramObj.groupby)) {
        th.setAttribute('onClick','reSearch("'+this+'")');
      }
      tr.appendChild(th);
      
      // fifter
      let fifterTh = createElement("th","","","");
      if (isNotEmpty(columnMap[this])){
        let widthSize = columnMap[this].length;
        let inputCol;
        if (isEmpty(columnMap[this].inputType)){
          inputCol = createElement("input","","","fifter_"+this);
        } else {
          inputCol = createElement("select","","","fifter_"+this);
          let categoryId = columnMap[this].inputType.split('_')[1];
          getOptionsFromCodeMaster(inputCol,categoryId);
        }
        // 输入框宽度
        inputCol.style.width = columnMap[this].fifterWidth;
        // Event
        inputCol.setAttribute('onChange','fifterRows("'+this+'",this)')
        fifterTh.appendChild(inputCol);
      }
      fifterRow.appendChild(fifterTh);
    }
  });
  // 事件
  let eventTh = createElement("th","","","");
  eventTh.innerHTML = 'Action';
  eventTh.style.width = '100px';
  tr.appendChild(eventTh);
  thead.appendChild(tr);
  fifterRow.appendChild(createElement("th","","",""));
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

function createTbody(dataList){
  // Tbody
  var tbody = createElement("tbody","detailRows","","");
  $.each(dataList.rows,function(i,rowRec){
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
    $.each(paramObj.head,function(){
      if (isNotEmpty(columnMap[this]) && isEmpty(columnMap[this].hide)){
        let td = createElement("td","","","");
        td.innerHTML = rowRec[this];
        tr.appendChild(td);
      }
    });
    let id = this.id;
    let eventTd = createElement("td","","","");
    eventTd.style.display = 'inline-block';
    eventTd.style.width = '120px';
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
