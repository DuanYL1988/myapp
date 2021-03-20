<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!-- 導入共通資源文件 -->
<%@ include file="resources.jsp" %>
<script type="text/javascript">
$(function(){
});

</script>
</head>
<body>
    <div id="buttonArea">
        <input type="button" value="參照" onclick="getSelectRow()"/>
        <input type="button" value="追加" onclick="javascript : document.getElementById('type').value='addNew'" />
    </div>
    <form action="goDetail" method="post">
        <input type="hidden" name="type" id="type" value="">
        <input type="hidden" name="detailList" id="selectRows" value="">
    <table>
        <thead>
            <tr>
                <td><input type="checkbox" id="checkAll" onclick="detailSelectAll(this)"/></td>
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
        <tbody>
            <c:forEach items="${list}" var="hero" begin="0" step="1" varStatus="status">
                <tr>
                    <td><input name="detailList[${status.index }].selected" class="detailCheckbox" type="checkbox"/></td>
                    <td>
                        <span>${hero.name }</span>
                        <input type="hidden" value="${hero.name }" name="detailList[${status.index }].name" />
                    </td>
                    <td><img class='list_face' src="${pageContext.request.contextPath}/resources/images/feh/acter/${hero.imgName}/face.png"></td>
                    <td><span>${hero.titleName }</span></td>
                    <td><span>${hero.origin }</span></td>
                    <td><span>${hero.hp }</span></td>
                    <td><span>${hero.attact }</span></td>
                    <td><span>${hero.speed }</span></td>
                    <td><span>${hero.def }</span></td>
                    <td><span>${hero.mdf }</span></td>
                    <td><span>${hero.moveType }</span></td>
                    <td><span>${hero.weapon }</span></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <input type="submit" value="submit" />
    </form>
</body>
</html>
