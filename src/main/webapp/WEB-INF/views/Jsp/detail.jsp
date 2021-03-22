<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!-- 導入共通資源文件 -->
<%@ include file="resources.jsp" %>
<script type="text/javascript">
$(function(){
    $("input[class='detailCheckbox']").on('click',function(){
        changeColor(this);
    });
    
    if(!${requestScope.nextFlag}) {
        $("#getNext").attr('disabled', 'disabled');
     }
    // getNext
    $("#getNext").on('click',function(){
        var form = $('form')[0]
        form.action='getNext';
        form.submit();
    });
});

</script>
</head>
<body>
    <div id="buttonArea">
        <a href="index" >返回</a>
        <input type="button" id="getNext" value="next"/>
        <input type="button" id="editCheck" value="分类区分" onclick="getDetailClassify()"/>
    </div>
    <form action="" method="post">
        <!-- 使用单引号 -->
        <input type="hidden" name="detailList" id="selectRows" value='${detailList }'>
    <table>
        <thead>
            <tr>
                <td><span>No.</span></td>
                <td><input type="checkbox" id="checkAll" onclick="detailSelectAll(this)"/></td>
                <td><span>分类</span></td>
                <td><span>NAME</span></td>
                <td><span>IMG</span></td>
                <td><span>TITLE NAME</span></td>
                <td><span>ORIGIN</span></td>
                <td><span>HP</span></td>
                <td><span>ATTACT</span></td>
                <td><span>SPEED</span></td>
                <td><span>DEF</span></td>
                <td><span>MDF</span></td>
                <td><span>MOVETYPE</span></td>
                <td><span>WEAPON</span></td>
            </tr>
        </thead>
        <tbody id="detailList">
            <c:forEach items="${list}" var="hero" varStatus="status">
                <tr class="${hero.masterId }">
                    <td class="detal_index">${status.index }</td>
                    <c:if test="${hero.count >0}">
                        <td rowspan="${hero.count }"><input class="detailCheckbox" type="checkbox"/></td>
                    </c:if>
                    <td><span name="heroList[${status.index}].type">${hero.type }</span></td>
                    <td>
                        <span>${hero.name }</span>
                        <input type="hidden" name="name" value="${hero.name }">
                    </td>
                    <td>
                        <img class='list_face' src="${pageContext.request.contextPath}/resources/images/feh/acter/${hero.imgName}/face.png">
                        <input type="hidden" name="imgName" value="${hero.imgName }">
                    </td>
                    <td>
                        <span>${hero.titleName }</span>
                        <input type="hidden" name="titleName" value="${hero.titleName }">
                    </td>
                    <td>
                        <span>${hero.origin }</span>
                        <input type="hidden" name="origin" value="${hero.origin }">
                    </td>
                    <td>
                        <input type="number" class="list_input" name="heroList[${status.index }].hp" value="${hero.hp }">
                        <input type="hidden" name="hp" value="${hero.hp }">
                    </td>
                    <td>
                        <input type="number" class="list_input" name="heroList[${status.index }].attact" value="${hero.attact }">
                        <input type="hidden" name="attact" value="${hero.attact }">
                    </td>
                    <td>
                        <input type="number" class="list_input" name="heroList[${status.index }].speed" value="${hero.speed }">
                        <input type="hidden" name="speed" value="${hero.speed }">
                    </td>
                    <td>
                        <input type="number" class="list_input" name="heroList[${status.index }].def" value="${hero.def }">
                        <input type="hidden" name="def" value="${hero.def }">
                    </td>
                    <td>
                        <input type="number" class="list_input" name="heroList[${status.index }].mdf" value="${hero.mdf }">
                        <input type="hidden" name="mdf" value="${hero.mdf }">
                    </td>
                    <td>
                        <span>${hero.moveType }</span>
                        <input type="hidden" name="moveType" value="${hero.moveType }">
                    </td>
                    <td>
                        <span>${hero.weapon }</span>
                        <input type="hidden" name="weapon" value="${hero.weapon }">
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </form>
</body>
</html>
