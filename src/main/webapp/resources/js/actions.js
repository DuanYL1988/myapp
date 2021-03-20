function detailSelectAll(obj){
    var detailList = $(".detailCheckbox");
    $.each(detailList,function(){
        this.checked = obj.checked;
    });
}

/*
 * 取得一览所有选中行
 */
function getSelectRow(){
    $("#type").val('refence');
    var detailList = [];
    $.each($(".detailCheckbox"),function(index,checkEle){
        if(checkEle.checked){
            var hero = {};
            var name = $("input[name='detailList["+index+"].name']").val();
            hero.name = name;
            hero.selected = "true";
            detailList.push(hero);
        }
    });
    var txt = JSON.stringify(detailList);
    console.log(txt);
    $("#selectRows").val(txt);
    $("form").submit();
}

/*
 * 单个子类选中的父类所有子类颜色变更
 */
function changeColor(obj){
    var trEle = $(obj).parent().parent()[0];
    var masterId = trEle.className;
    if(obj.checked){
        $.each($("tr[class='"+masterId+"']"),function(){
            this.className += " selected";
        });
    } else {
        $.each($("tr[class='"+masterId+"']"),function(){
            this.className = $.trim(this.className.replace(new RegExp('selected',"gm"),''));
        });
    }
}