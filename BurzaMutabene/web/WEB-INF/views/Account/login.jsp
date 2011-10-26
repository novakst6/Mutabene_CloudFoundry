<%-- 
    Document   : login
    Created on : 26.7.2011, 10:57:14
    Author     : Anysek
--%>
<%@include file="../../parts/header.jspf"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<h2>Přihlášení</h2>
    <p>Vyplněním následujícího formuláře se přihlásíte na MUTABENE stránky.</p>
    <form action="j_spring_security_check" method="post">
        <div>
            <fieldset>
                <legend>Přihlašovací formulář</legend>
                  <c:if test="${not empty param.error}">
                            <div class="error" >Uživatelské jméno nebo heslo je nesprávné !</div>
                  </c:if>
                    <div class="editor-label">

                    Uživatelské jméno:
                    </div>
                   <div class="editor-field">
                       <input type="text" name="j_username" id="j_username" />                   
                   </div>
                    <div class="editor-label">
                    Heslo:
                    </div>
                    <div class="editor-field">
                        <input type="password" name="j_password" id="j_password" />
                    </div>
                    <p><input type="submit" /></p>
            </fieldset>
        </div>
        
    </form>
<%@include file="../../parts/footer.jspf"%>