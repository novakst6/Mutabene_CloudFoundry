<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2>Administrace center</h2>
    <a href="#">Přidat nové centrum</a>
    <p>
        Seznam dostupných center:
    </p>
    <table>
        <thead>
          <tr>
              <th>ID</th><th>NÁZEV</th><th>POPIS</th><th>MĚSTO</th><th>ULICE</th><th>PSČ</th><th>REGION</th><th colspan="2">EDITACE</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${allCenters}" var="center">
                <tr>
                    <td>#${center.id}</td><td>${center.name}</td><td>${center.description}</td><td>${center.address.city}</td><td>${center.address.street}</td><td>${center.address.zipCode}</td><td>${center.address.region.name}</td><td><a href="#">EDIT</a></td><td><a href="#">DEL</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../../../parts/footer.jspf"%>