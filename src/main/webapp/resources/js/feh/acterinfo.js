/**
* 火纹管理页面业务js
*/
$(window).on('load',function(){
    // 通过作品名筛选出角色名
    $('#acterOrigin').on('change',function(){
        var jsonData = {
                codeId : this.value,
                catagoryId : '0004'
        }
        var callback = function(data){
            var charActerName = $('#acterName');
            charActerName.html('<option></option>');
            var resultData = data.data;
            for(var i=0;i<resultData.length;i++){
                var optionHtml = '<option value="'+resultData[i].codeName+'" >'+resultData[i].codeName+'</option>';
                charActerName.html(charActerName.html()+optionHtml);
            }
        }
        var val = this.value;
        var url = '/myapp/ajax/testAjax/' +val
         ajaxPost('/myapp/ajax/getInfoByCategory',jsonData,callback);
    });
    
    // 反应角色头像
    $('#imagePath').on('change',function(){
        alert(this.value);
        var path = this.value;
        path = path.replace(/'\'/g,'/');
        $("#faceImg").attr("src","../../../"+path);
    });
    
    //把下拉框中的值赋给输入框
    $('select[class="inputSelect"]').on('change',function(){
        $inputEle = $(this).parent().find('input').val(this.value);
    });
    
    //通过入力内容缩小下拉框中内容
    $('select[class="inputSelect"]').on('click',function(){
        var inputVal = $(this).parent().find('input').val();
            var options = this.childNodes;
            $.each(options,function(){
                if(this.value.indexOf(inputVal)<0 && inputVal.length>0){
                    this.style.display = 'none';
                }else{
                    this.style.display = 'inline';
                }
        });
    });
    //
    var skillEleList = ['characterSkillA','characterSkillB','characterSkillC','characterSkillS','characterSkillD','characterSkillE','characterWeapon'];
    var skillInde = 0;
    $.each(mapObj,function(){
        var $skillEle = $('#'+skillEleList[skillInde]);
        if($skillEle.length>0){
            $skillEle.empty();
            $skillEle.append('<option value=""></option>');
            for(var i=0;i<this.length;i++){
                $skillEle.append('<option value="'+this[i]+'" >'+this[i]+'</option>');
            }
        }
        skillInde++;
    });
    
    // 提交表单
    $('#submitForm').on('click',function(){
        var jsonObj = $('#feh-character-form').serializeObject();
        var originEle = $('#acterOrigin').find('option:selected').text();
        jsonObj.charActer.origin = originEle;
        if(jsonObj.charActer.id.length>0){
            jsonObj.mode = 'update';
        }
        var callback = function(data){
            alert(data.message);
        }
        ajaxPost('/myapp/fireEmblem/save',jsonObj,callback);
    });
    
});