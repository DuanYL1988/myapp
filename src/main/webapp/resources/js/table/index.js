/**
 * 
 */
$(function() {
    // html代码模板
    var sampleHead = "<div class='colCell'>";
    var sampleTitle = "<span>{COLUMN_NAME}</span><br>";
    var sampleType = "<input type='hidden' class='type' name='fieldInfo[{index}].type'  value='{VALUE}'>";
    var sampleName = "<input type='hidden' class='name' name='fieldInfo[{index}].name' value='{VALUE}'>";
    var sampleExtra = "<input type='hidden' class='extra' name='fieldInfo[{index}].extra' value='{VALUE}'>";
    var sampleValue = "<input type='text' class='value' name='fieldInfo[{index}].value' value='{VALUE}'>";
    var sampleEnd = "</div>";

    if (columnList.length > 0) {
        var cell = $("#tableColumnArea");
        var html = "";
        for (var i = 0; i < columnList.length; i++) {
            var colObj = columnList[i];
            var titleHtml = sampleTitle.replace("{COLUMN_NAME}", colObj.name);

            var typeHtml = sampleType.replace("{VALUE}", colObj.type);
            typeHtml = typeHtml.replace("{index}", i);

            var nameHtml = sampleName.replace("{VALUE}", colObj.name);
            nameHtml = nameHtml.replace("{index}", i);

            var extraHtml = sampleExtra.replace("{VALUE}", colObj.extra);
            extraHtml = extraHtml.replace("{index}", i);

            var mode = $("#db_type").val();
            var value = colObj.defaultValue;
            if(1==mode && "ID"==colObj.name){
                value = oracleNextVal;
            }
            var valueHtml = sampleValue.replace("{VALUE}", value);
            valueHtml = valueHtml.replace("{index}", i);

            html += sampleHead + titleHtml + typeHtml + nameHtml + extraHtml + valueHtml
                    + sampleEnd;
        }
        $(cell).html(html);
    }

    if (json.length > 0) {
        initGrid(columnList, json);
    }
});

function tableRegist() {

    var columns = $("div[class='colCell']");
    var fieldList = new Array();
    var obj = [];
    for (var i = 0; i < columns.length; i++) {
        var colName = $(columns[i]).find("span").html();
        var colValue = $(columns[i]).find("input[class='value']").val();
        var colType = $(columns[i]).find("input[class='type']").val();
        var colExtra = $(columns[i]).find("input[class='extra']").val();
        var fieldInfo = new Object();
        fieldInfo.name = changeNull(colName);
        fieldInfo.value = changeNull(colValue);
        fieldInfo.type = changeNull(colType);
        fieldInfo.extra = changeNull(colExtra);
        fieldList.push(fieldInfo);
        obj.push(fieldInfo);
    }
    var formObj = $("#registForm").serializeObject();
    ajaxPost("/myapp/rigstTable/regist", fieldList, function(data) {
        alert(data);
    });
}

function initGrid(columnList, json) {
    // 初始化定义
    var gridView;
    var grid;
    var data = [];
    var columns = [];
    // 设置列名
    for (var i = 0; i < columnList.length; i++) {
        var columnObj = columnList[i];
        var gridCol = new Object();
        gridCol.id = columnObj.name;
        gridCol.name = columnObj.name;
        gridCol.field = columnObj.name;
        var size = columnObj.size;
        if (null == size || size <= 10) {
            size = 100;
        } else if (10 < size && size > 30) {
            size = 180;
        } else {
            size = 300;
        }
        gridCol.width = size;
        columns.push(gridCol);
    }
    // 
    var options = {
        editable : false,
        enableCellNavigation : true,
        enableColumnReorder : true,
        asyncEditorLoading : true,
        forceFitColumns : false,
        topPanelHeight : 25
    };
    //
    var data = jQuery.parseJSON(json);
    //
    gridView = new Slick.Data.DataView({
        inlineFilters : true
    });
    grid = new Slick.Grid("#myGrid", data, columns, options);
    gridView.setItems(data, "ID");
    // 选择一行，不设的话会选择单元格
    grid.setSelectionModel(new Slick.RowSelectionModel());

    // STEP.2 扩展功能
    // 2-1.隐藏列
    var visibleColumns = [];
    for (var i = 0; i < columns.length; i++) {
        if (i != 0) {
            //  第一列隐藏，从第二列开始设置可见
            visibleColumns.push(columns[i]);
        }
    }
    // 调用方法
    grid.setColumns(visibleColumns);
}