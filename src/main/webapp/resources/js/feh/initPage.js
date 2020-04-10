/**
* 火纹管理页面业务js
*/
function openImg(acterId){
  var Height = window.screen.height-50;
  var iLeft = (window.screen.width-10-800)/2;
  window.open("acterInfo/"+acterId, "FEH", "height="+Height+",width=790,top=0,left="+iLeft+",toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no,channelmode=yes");
}
$(function(){
  //fehActerRegist/update/#{acterId}#
  //window.open("fireEmblem/init", "FEH", "height=500,width=1080,top="+iTop+",left="+iLeft+",location=no,status=no,scrollvars=no");
//  var baseHtml = '<a href="/myapp/fireEmblem/acterInfo/#{acterId}#" target="_blank"><img alt="#{acterName}#" src="#{resourceimg}#" width="120" height="120" ></a></div></td>';
  var baseHtml = '<a href="javascript:openImg(#{acterId}#)"><img class="#{color}#" alt="#{acterName}#" src="#{resourceimg}#" width="80" height="80" ></a></div></td>';
  //acterList:以武器种类为Key的Map
  createHtml(acterList['1'],'weapon-type-red-sword');
  createHtml(acterList['2'],'weapon-type-blue-spear');
  createHtml(acterList['3'],'weapon-type-green-ax');
  createHtml(acterList['4'],'weapon-type-red-magic');
  createHtml(acterList['5'],'weapon-type-blue-magic');
  createHtml(acterList['6'],'weapon-type-green-magic');
  createHtml(acterList['7'],'weapon-type-red-breath');
  createHtml(acterList['8'],'weapon-type-blue-breath');
  createHtml(acterList['9'],'weapon-type-green-breath');
  createHtml(acterList['10'],'weapon-type-none-breath');
  createHtml(acterList['11'],'weapon-type-red-arrow');
  createHtml(acterList['12'],'weapon-type-blue-arrow');
  createHtml(acterList['13'],'weapon-type-green-arrow');
  createHtml(acterList['14'],'weapon-type-none-arrow');
  createHtml(acterList['15'],'weapon-type-red-assassin');
  createHtml(acterList['16'],'weapon-type-blue-assassin');
  createHtml(acterList['17'],'weapon-type-green-assassin');
  createHtml(acterList['18'],'weapon-type-none-assassin');
  createHtml(acterList['19'],'weapon-type-none-wand');
  createHtml(acterList['20'],'weapon-type-red-beast');
  createHtml(acterList['21'],'weapon-type-blue-beast');
  createHtml(acterList['22'],'weapon-type-green-beast');
  createHtml(acterList['23'],'weapon-type-none-beast');

      
  function createHtml(list, elementId) {
        if (null == list) {
            return;
        }
        var html = $('#' + elementId).html();
        $.each(list, function() {
            var cellHtml = baseHtml.replace('#{acterName}#', this.basename);
            cellHtml = cellHtml.replace('#{resourceimg}#', this.faceImg.replace('../../../', '/myapp/'));
            cellHtml = cellHtml.replace('#{acterId}#', this.id);
            // 颜色
            if (elementId.indexOf('red') > 0) {
                cellHtml = cellHtml.replace('#{color}#', 'redface');
            } else if (elementId.indexOf('blue') > 0) {
                cellHtml = cellHtml.replace('#{color}#', 'blueface');
            } else if (elementId.indexOf('green') > 0) {
                cellHtml = cellHtml.replace('#{color}#', 'greenface');
            } else if (elementId.indexOf('none') > 0) {
                cellHtml = cellHtml.replace('#{color}#', 'noneface');
            }
            html += cellHtml;
        });
        $('#' + elementId).html(html);
    }
});