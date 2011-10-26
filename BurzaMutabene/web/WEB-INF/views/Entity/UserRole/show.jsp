<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2>Administrace uživatelských rolí</h2>
    <a href="#">Přidat novou roli</a>
    <p>
        Seznam dostupných uživatelských rolí:
    </p>
    
    <table>
        <thead>
          <tr>
              <th>ID</th><th>NÁZEV ROLE</th><th>POPIS</th><th colspan="2">EDITACE</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${allRoles}" var="role">
                <tr>
                    <td>#${role.id}</td><td>${role.name}</td><td>${role.description}</td><td><a href="#">EDIT</a></td><td><a href="#">DEL</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../../../parts/footer.jspf"%>