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
});

</script>
</head>
<body>
    <div id="buttonArea">
        <a href="index" >返回</a>
    </div>
    <form action="" method="post">
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
            <c:forEach items="${list}" var="hero">
                <tr class="${hero.masterId }">
                    <c:if test="${hero.count >0}">
                        <td rowspan="${hero.count }"><input class="detailCheckbox" type="checkbox"/></td>
                    </c:if>
                    <td>
                        <span>${hero.name }</span>
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
    </form>
</body>
</html>
