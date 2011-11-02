<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2>Administrace uživatelských regionů</h2>
    <a href="#">Přidat novoý region</a>
    <p>
        Seznam dostupných regionů:
    </p>
    <table>
        <thead>
          <tr>
              <th>ID</th><th>NÁZEV REGIONU</th><th>NADŘAZENÝ REGION</th><th colspan="2">EDITACE</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${allRegions}" var="region">
                <tr>
                    <td>#${region.id}</td><td>${region.name}</td><td>${region.region.name}</td><td><a href="#">EDIT</a></td><td><a href="#">DEL</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../../../parts/footer.jspf"%>