const shortName = 'db_html';
const version = '1.0';
const displayName = 'Display Information';
const maxSize = 65536;
let db = openDatabase(shortName,version,displayName,maxSize);
let result = db ? 'success' : 'filed';

let recoderObj = masterInfo.gameName[1];
console.log(db);

function createTable(){
  let createTblSql = 'create table if not exists CODE_MASTER(' + 
  'id integer primary key autoincrement,code varchar(4),value varchar(50))'; 
  console.log(createTblSql);
  executeQuary(createTblSql);
}

function insertValue() {
  let keys = Object.keys(recoderObj);
  let colSql = "insert into CODE_MASTER ("
  let valSql = " values ('";
  /*
  */
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
  console.log(sql);
  executeQuary(sql);
}

function doSelect(){
  let sql = 'select * from CODE_MASTER';
  executeQuary(sql,function(data){
    let paramObj = {
      "head" : ["id","code","value"],
      "width" : "",
      "id" : "displayTable",
      "selectAll" : "true",
    }

    let tblEle = makeTableElement(paramObj,data.rows);
    document.getElementById('displayArea').appendChild(tblEle);
  });
}

function executeQuary(ddlSql,callback){
  let db = openDatabase(shortName,version,displayName,maxSize);
  db.transaction(tx => {
    tx.executeSql(ddlSql,[],
      (tx,result) => {
        console.log('SQL-success:' + result);
        if (typeof callback == 'function') {
          callback(result);
        }
      },
      (tx,error) => {
        console.log('SQL-filed:' + error);
      }
    )
    return result;
  });
}

function makeTableElement(paramObj,dataList){
    // Table
    var tableEle = createElement("table","","","");
    tableEle.setAttribute("cellspacing",0);
    tableEle.border = "1";
    tableEle.style.width = paramObj.width;
    tableEle.id = paramObj.id;
    
    // Thead
    var thead = createElement("thead","","","");
    var tr = createElement("tr","","","");
    // selectAll
    if (isNotEmpty(paramObj.selectAll)) {
      var th = createElement("th","","","");
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
      var th = createElement("th","","","");
      th.innerHTML = this;
      tr.appendChild(th);
    });
    thead.appendChild(tr);
    tableEle.appendChild(thead);
    
    // Tbody
    var tbody = createElement("tbody","","","");
    $.each(dataList,function(){
      tr = createElement("tr","","","");
      // selectAll
      if (isNotEmpty(paramObj.selectAll)) {
        var selectTd = createElement("td","","","");
        var checkedEle = createElement("input","","","");
        checkedEle.type = "checkbox";
        selectTd.appendChild(checkedEle);
        tr.appendChild(selectTd);
      }
      // data
      $.each(this,function(j,cell){
        var td = createElement("td","","","");
        td.innerHTML = cell;
        tr.appendChild(td);
      });
      tbody.appendChild(tr);
    
    });
    tableEle.appendChild(tbody);
    return tableEle;
  }