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
              <th>ID</th><th>ULICE</th><th>MĚSTO</th><th>PSČ</th><th>REGION</th><th colspan="2">EDITACE</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${allAddress}" var="address">
                <tr>
                    <td>#${address.id}</td><td>${address.street}</td><td>${address.city}</td><td>${address.zipCode}</td><td>${address.region.name}</td><td><a href="#">EDIT</a></td><td><a href="#">DEL</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../../../parts/footer.jspf"%>