// STEP.1 设置初始表示的grid
var gridView;
var grid;
var selectRowNo;
var data = [];
// 定义表示的列名
var columns = [ {
    id : "id",
    name : "id",
    field : "id",
    behavior : "select",
    width : 150
}, {
    id : "skillName",
    name : "SKILL_NAME",
    field : "skillName",
    width : 150
}, {
    id : "skillType",
    name : "SKILL_TYPE",
    field : "skillType",
    width : 150,
    sortable: true
}, {
    id : "skillColour",
    name : "SKILL_COLOR",
    field : "skillColour",
    width : 150,
    sortable: true
}, {
  id : "skillExtend",
  name : "EXTEND",
  field : "skillExtend",
  width : 150,
  formatter: Slick.Formatters.Checkmark,
  editor: Slick.Editors.Checkbox
}, {
    id : "skillPower",
    name : "SKILL_POW",
    field : "skillPower",
    width : 150,
    sortable: true
}, {
  id : "skillInfo",
  name : "SKILL_INFO",
  field : "skillInfo",
  width : 150,
  editor: Slick.Editors.Text
}, {
  id : "skillSpEffect",
  name : "SKILL_SP",
  field : "skillSpEffect",
  width : 150,
  sortable: true
} ];
// 定义grid的一些属性
var options = {
    editable : true,
    enableCellNavigation : true,
    enableColumnReorder : true,
    asyncEditorLoading : true,
    forceFitColumns : false,
    topPanelHeight : 25
};
//
var data = jQuery.parseJSON(jsonData);
//模式
var checkboxSelector = new Slick.CheckboxSelectColumn({
  cssClass:"slick-cell-checkboxsel"
});
//
var checkboxcolumns = [];
checkboxcolumns.push(checkboxSelector.getColumnDefinition());

for(var i=0;i<columns.length;i++){
  checkboxcolumns.push(columns[i]);
}
// 往gird中放入数据
$(function() {
  grid = new Slick.Grid("#myGrid", data, checkboxcolumns, options);
  grid.setSelectionModel(new Slick.RowSelectionModel({
    selectActiveRow : false
  }));
  //放入模式
  grid.registerPlugin(checkboxSelector);
  //
  var columnpicker = new Slick.Controls.ColumnPicker(checkboxcolumns, grid,
      options);

  // 选择一行，不设的话会选择单元格
  grid.setSelectionModel(new Slick.RowSelectionModel());
  // 分页控件
  gridView = new Slick.Data.DataView({
    inlineFilters : true
  });
  gridView.setItems(data, "id");
  var pager = new Slick.Controls.Pager(gridView, grid, $("#pager"));
  // STEP.2 扩展功能
  // 2-1.隐藏列
  var visibleColumns = [];
  for (var i = 0; i < checkboxcolumns.length; i++) {
    if (i != 1) {
      //  第一列隐藏，从第二列开始设置可见
      visibleColumns.push(checkboxcolumns[i]);
    }
  }
  // 调用方法
  grid.setColumns(visibleColumns);
  //
  grid.onSelectedRowsChanged.subscribe(function (e, args) {
    var currentRow = args.rows[0];
    if(selectRowNo==null || selectRowNo==currentRow){
      selectRowNo = currentRow;
      return
    }
    selectRowNo = currentRow;
    var item = grid.getDataItem(currentRow);
    window.console.log(JSON.stringify(item));
    if(confirm("保存编辑内容吗")){
      ajaxPost('/myapp/fireEmblem/saveSkill',item,function(data){
        alert(data.message);
      });
    }
  });
})
