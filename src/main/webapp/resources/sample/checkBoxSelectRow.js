// STEP.1 设置初始表示的grid
var grid;
var data = [];
// 定义表示的列名
var columns = [
{id:"button",name:"button",field:"id",editor:Slick.Editors.TextButton},
{id:"id",name:"id",field:"id",behavior:"select",width:150},
{id:"name",name:"BLADE_NAME",field:"name",width:150},
{id:"type",name:"BLADE_CLASS",field:"type",width:150},
{id:"weapon",name:"WEAPON",field:"weapon",width:150},
{id:"attr",name:"BLADE_ATTR",field:"attr",width:150}
];
// 定义grid的一些属性
var options = {
editable:false,
enableCellNavigation:true,
enableColumnReorder: true,  
asyncEditorLoading: true,  
forceFitColumns: false,  
topPanelHeight: 25 
};
//
var data = jQuery.parseJSON(json);
// 模式
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
$(function(){
grid = new Slick.Grid("#myGrid",data,checkboxcolumns,options);
grid.setSelectionModel(new Slick.RowSelectionModel({selectActiveRow:false}));
// 放入模式
grid.registerPlugin(checkboxSelector);
// 
var columnpicker = new Slick.Controls.ColumnPicker(checkboxcolumns,grid,options);
//
$("#getSelectedInfo").on("click",openInfo);
});

function openInfo() {
  var selected = grid.getSelectedRows();
  for (var i = 0; i < selected.length; i++) {
    var item = grid.getDataItem(selected[i]);
    alert(item);
  }
}