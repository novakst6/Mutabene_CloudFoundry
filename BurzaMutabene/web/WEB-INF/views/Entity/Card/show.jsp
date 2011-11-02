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
              <th>ID</th><th>NAME</th><th>POPIS</th><th>S/N</th><th>CENA</th><th>KATEGORIE</th><th>OBRÁZEK</th><th colspan="2">EDITACE</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${allCards}" var="card">
                <tr>
                    <td>#${card.id}</td><td>${card.name}</td><td>${card.description}</td><td>${card.serialNumber}</td><td>${card.price}</td><td>${card.cardCategoryEntity.name}</td><td><img src="${card.picture}"/></td><td><a href="#">EDIT</a></td><td><a href="#">DEL</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../../../parts/footer.jspf"%>