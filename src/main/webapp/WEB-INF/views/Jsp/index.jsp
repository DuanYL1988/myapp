<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ page import="com.app.controller.JspAction" %>
<!-- 導入共通資源文件 -->
<%@ include file="resources.jsp" %>
<script type="text/javascript">
$(function(){

});
</script>
</head>
<body>
  <div id="buttonArea"> 
    <input type="button" value="參照" onclick="getSelectRow()" /> 
    <input type="button" value="追加" onclick="javascript : document.getElementById('type').value='addNew'" /> 
  </div>
  <form action="goDetail" method="post">
   <input type="hidden" name="type" id="type" value="">
   <input type="hidden" name="detailList" id="selectRows" value="">
    <table>
      <thead>
        <tr>
          <td><input type="checkbox" id="checkAll" onclick="detailSelectAll(this)" /></td>
          <c:forEach items="${columnList }" var="title">
            <!-- 和java静态变量比较 -->
            <c:if test="${title eq JspAction.COLUNM_NAME }">
              <td><span>NAME</span></td>
            </c:if>
            <c:if test="${title eq 'IMG_NAME' }">
              <td><span>IMG</span></td>
            </c:if>
            <c:if test="${title eq 'TITLE_NAME' }">
              <td><span>TITLE NAME</span></td>
            </c:if>
            <c:if test="${title eq 'ORIGIN' }">
              <td><span>ORIGIN</span></td>
            </c:if>
            <c:if test="${title eq 'HP' }">
              <td><span>HP</span></td>
            </c:if>
            <c:if test="${title eq 'ATTACT' }">
              <td><span>ATTACT</span></td>
            </c:if>
            <c:if test="${title eq 'SPEED' }">
              <td><span>SPEED</span></td>
            </c:if>
            <c:if test="${title eq 'DEF' }">
              <td><span>DEF</span></td>
            </c:if>
            <c:if test="${title eq 'MDF' }">
              <td><span>MDF</span></td>
            </c:if>
            <c:if test="${title eq 'MOVETYPE' }">
              <td><span>MOVETYPE</span></td>
            </c:if>
            <c:if test="${title eq 'WEAPON_TYPE' }">
              <td><span>WEAPON_TYPE</span></td>
            </c:if>
            <c:if test="${title eq 'WEAPON' }">
              <td><span>WEAPON</span></td>
            </c:if>
          </c:forEach>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${list}" var="hero" begin="0" step="1" varStatus="status">
          <tr>
            <td><input name="detailList[${status.index }].selected" class="detailCheckbox" type="checkbox" /></td>
            <c:forEach items="${columnList }" var="title">
              <c:if test="${title eq 'NAME' }">
                <td> <span>${hero.name }</span> <input type="hidden" value="${hero.name }" name="detailList[${status.index }].name" /> </td>
              </c:if>
              <c:if test="${title eq 'IMG_NAME' }">
                <td><img class='list_face' src="${pageContext.request.contextPath}/resources/images/feh/acter/${hero.imgName}/face.png"></td>
              </c:if>
              <c:if test="${title eq 'TITLE_NAME' }">
                <td><span>${hero.titleName }</span></td>
              </c:if>
              <c:if test="${title eq 'ORIGIN' }">
                <td><span>${hero.origin }</span></td>
              </c:if>
              <c:if test="${title eq 'HP' }">
                <td><span>${hero.hp }</span></td>
              </c:if>
              <c:if test="${title eq 'ATTACT' }">
                <td><span>${hero.attact }</span></td>
              </c:if>
              <c:if test="${title eq 'SPEED' }">
                <td><span>${hero.speed }</span></td>
              </c:if>
              <c:if test="${title eq 'DEF' }">
                <td><span>${hero.def }</span></td>
              </c:if>
              <c:if test="${title eq 'MDF' }">
                <td><span>${hero.mdf }</span></td>
              </c:if>
              <c:if test="${title eq 'MOVE_TYPE' }">
                <td><span>${hero.moveType }</span></td>
              </c:if>
              <c:if test="${title eq 'WEAPON_TYPE' }">
                <td><span>${hero.weaponType }</span></td>
              </c:if>
              <c:if test="${title eq 'WEAPON' }">
                <td><span>${hero.weapon }</span></td>
              </c:if>
            </c:forEach>
          </tr>
        </c:forEach>
      </tbody>
    </table> <input type="submit" value="submit" /> </form>
</body>
</html>