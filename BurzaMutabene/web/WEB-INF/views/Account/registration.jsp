<%@include file="../../parts/header.jspf"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<h2>Registrace nového člena</h2>
  <p>Vyplněním následujícího formuláře si vytvoříte účet na MUTABENE stránkách.</p>
  
  <form:form action="addUser.htm" commandName="regModelForm" method="post">

      <div>
      <fieldset>
          <legend>Registrační formulář</legend>
          <form:errors path="errors" cssClass="error" />
          <fieldset>
              <legend>Osobní údaje</legend>
            <div class="editor-label">
                Jméno:
            </div>
            <div class="editor-field">
                <form:input path="user.firstname" />
                <form:errors path="user.firstname" cssClass="error"/>
            </div>
            <div class="editor-label">
                Příjmení:
            </div>
            <div class="editor-field">
                <form:input path="user.surname" />
                <form:errors path="user.surname"  cssClass="error"/>
            </div>
            <div class="editor-label">
                Pohlaví:
            </div>
            <div class="editor-field">
                <form:radiobutton path="user.gender" value="MALE" label="Muž" id="rad_gender" checked="true"/>
                <form:radiobutton path="user.gender" value="FEMALE" label="Žena" id="rad_gender" />
            </div>
            <div class="editor-label">
                Email:
            </div>
            <div class="editor-field">
                <form:input path="user.email" />
                <form:errors path="user.email"  cssClass="error"/>
            </div>
            <div class="editor-label">
                Telefonní číslo:
            </div>
            <div class="editor-field">
                <form:input path="user.telephoneNumber" />
                <form:errors path="user.telephoneNumber"  cssClass="error"/>
            </div>
         </fieldset>
            <fieldset>
                <legend>Přihlašovací údaje</legend>
            <div class="editor-label">
                Uživatelské jméno:
            </div>
            <div class="editor-field">
                <form:input path="user.login" />
                <form:errors path="user.login"  cssClass="error"/>
            </div>
            <div class="editor-label">
                Heslo:
            </div>
            <div class="editor-field">
                <form:password path="user.password" />
                <form:errors path="user.password"  cssClass="error"/>
            </div>
            <div class="editor-label">
                Ověření hesla:
            </div>
            <div class="editor-field">
                <form:password path="confirmPassword" />
                <form:errors path="confirmPassword" cssClass="error"/>
            </div>
            </fieldset>
            <fieldset>
                <legend>Adresa</legend>
            <div class="editor-label">
                Region:
            </div>
            <div class="editor-field">
                <form:select path="regionId" >
                    <form:option label="Vyberte možnost" value="" />
                    <c:forEach items="${regionsList}" var="regItem">
                        <c:choose>
                        <c:when test="${regItem['key'] <= 14}">
                            <form:option label="${regItem['value']}" value="${regItem['key']}" disabled="true"/>
                        </c:when>
                        <c:when test="${regItem['key'] > 14}">
                            <form:option label="${regItem['value']}" value="${regItem['key']}" disabled="false"/>
                        </c:when>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <form:errors path="regionId" cssClass="error" />
                
            </div>
            <div class="editor-label">
                Město:
            </div>
            <div class="editor-field">
                <form:input path="address.city" />
                <form:errors path="address.city" cssClass="error" />
            </div>
            <div class="editor-label">
                Ulice:
            </div>
            <div class="editor-field">
                <form:input path="address.street" />
                <form:errors path="address.street" cssClass="error" />
            </div>
            <div class="editor-label">
                PSČ:
            </div>
            <div class="editor-field">
                <form:input path="address.zipCode" />
                <form:errors path="address.zipCode" cssClass="error" />
            </div>
            </fieldset>
            <fieldset>
                <legend>Mutabene centrum</legend>
            <div class="editor-label">
                Center:
            </div>
            <div class="editor-field">
                <form:select path="centerId">
                    <form:option label="Vyberte možnost" value="" />
                    <c:forEach items="${centersList}" var="centItem" >
                        <form:option label="${centItem['value']}" value="${centItem['key']}"/>
                    </c:forEach>
                </form:select>
                <form:errors path="centerId" cssClass="error" />
                <!-- selectbox -->
            </div>
            </fieldset>
                <p><input type="submit" /></p>
      </fieldset>
                
      </div>
  </form:form>

<%@include file="../../parts/footer.jspf"%>