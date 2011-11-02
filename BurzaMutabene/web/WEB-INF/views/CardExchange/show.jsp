<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Burza karet</h2>
    <p>
        Zobrazení pohledávek:
    </p>
    <div>Zobraz: VSE | ${types}</div>
    <div>
        <table>
        <c:forEach items="${offers}" var="offer">
            <tr>
                <td></td>
            </tr>
        </c:forEach>
        </table>
    </div>
        

<%@include file="../../../parts/footer.jspf"%>