<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2>Administrace uživatelů</h2>
    <a href="#">Přidat nového uživatele</a>
    <p>
        Seznam registrovaných uživatelů:
    </p>
    <table>
        <thead>
          <tr>
              <th>ID</th><th>JMÉNO</th><th>PŘÍJMENÍ</th><th>POHLAVÍ</th><th>EMAIL</th><th>TEL</th><th>ROLE</th><th>CENTRUM</th><th>ADRESA</th><th>REGION</th><th>AKTIVNI</th><th colspan="2">EDITACE</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td>#${user.id}</td><td>${user.firstname}</td><td>${user.surname}</td><td>${user.gender}</td><td>${user.email}</td><td>${user.telephoneNumber}</td><td><c:forEach items="${user.roleIT}" var="role">${role.name} </c:forEach></td><td>${user.center.name}</td><td>${user.address.street}, ${user.address.city}, ${user.address.zipCode}</td><td>${user.address.region.name}</td><td>${user.active}</td><td><a href="#">EDIT</a></td><td><a href="#">DEL</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../../../parts/footer.jspf"%>