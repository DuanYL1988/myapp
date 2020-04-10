// STEP.1 设置初始表示的grid
var gridView;
var grid;
var data = [];
// 定义表示的列名
var columns = [ {
    id : "id",
    name : "id",
    field : "id",
    behavior : "select",
    width : 150
}, {
    id : "name",
    name : "BLADE_NAME",
    field : "name",
    width : 150
}, {
    id : "type",
    name : "BLADE_CLASS",
    field : "type",
    width : 150
}, {
    id : "weapon",
    name : "WEAPON",
    field : "weapon",
    width : 150
}, {
    id : "attr",
    name : "BLADE_ATTR",
    field : "attr",
    width : 150
} ];
// 定义grid的一些属性
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
// 往gird中放入数据
$(function() {
    gridView = new Slick.Data.DataView({
        inlineFilters : true
    });
    grid = new Slick.Grid("#myGrid", data, columns, options);
    gridView.setItems(data, "id");
    // 选择一行，不设的话会选择单元格
    grid.setSelectionModel(new Slick.RowSelectionModel());

    // STEP.2 扩展功能
    // 2-1.隐藏列
    var visibleColumns = [];
    for (var i = 0; i < columns.length; i++) {
        if (i != 0) {
            //	第一列隐藏，从第二列开始设置可见
            visibleColumns.push(columns[i]);
        }
    }
    // 调用方法
    grid.setColumns(visibleColumns);

})