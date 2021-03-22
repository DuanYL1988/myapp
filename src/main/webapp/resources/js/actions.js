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

/*
 *
 */
function getDetailClassify(){
    var tableBody = $("#detailList");
    var detailList = [];
    var changeFlag = false;
    // 循环行
    $.each($(tableBody).children(),function(){
        var index = $.trim($(this).find("td[class='detal_index']")[0].innerHTML);
        var obj = {};
        // 循环列
        $.each($(this).children(),function(){
            // 单元格
            var hdnEle = $(this).find("input[type='hidden']")[0];
            if(null != hdnEle){
                obj[hdnEle.name]= hdnEle.value;
            }
            var inputEle = $(this).find("input[class='list_input']")[0];
            if(null!=inputEle) {
                obj[hdnEle.name]= inputEle.value;
                if(hdnEle.value != inputEle.value){
                    obj.type = 'UPD';
                    changeFlag = true;
                    $("span[name='heroList["+index+"].type']")[0].innerHTML = "UPD";
                }
            }
        });
        detailList.push(obj);
    });
    console.log(JSON.stringify(detailList));
    if(changeFlag){
        var form = $('form')[0]
        form.action='getNext';
        form.submit();
    }
}