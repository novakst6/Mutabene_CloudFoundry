<%-- 
    Document   : login
    Created on : 26.7.2011, 10:57:14
    Author     : Stenlik
Slouzi pro vypis vsech aktivnich inzeratu toho uzivatele
--%>
<%@include file="../../../parts/header.jspf"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<h2>Inzeráty vložené uživatelem ${profilModel.firstname}</h2>
<table>
    <c:forEach items="${offers}" var="offer">
    <tr>
        <td></td>
    </tr>
    </c:forEach>

</table>
<%@include file="../../../parts/footer.jspf"%>