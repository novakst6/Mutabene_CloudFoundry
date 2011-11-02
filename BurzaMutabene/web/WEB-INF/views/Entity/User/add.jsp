<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Administrace uživatelů</h2>
    <p>
        Přidání nového uživatele:
    </p>
    <div>
        <f:form action="submit.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro přidání</legend>
            <div class="editor-label">Jméno</div>
            <f:input path="firstname"/>
            <f:errors path="firstname" cssClass="error"/>
            <div class="editor-label">Příjmení</div>
            <f:input path="surname"/>
            <f:errors path="surname" cssClass="error"/>
            <div class="editor-label">Pohlaví</div>
            <f:radiobutton path="gender" value="MALE" label="Muž" id="rad_gender" checked="true"/>
            <f:radiobutton path="gender" value="FEMALE" label="Žena" id="rad_gender" />
            <div class="editor-label">E-mail</div>
            <f:input path="email"/>
            <f:errors path="email" cssClass="error"/>
            <div class="editor-label">Heslo</div>
            <f:input path="passwd"/>
            <f:errors path="passwd" cssClass="error"/>
            <div class="editor-label">Telefonní číslo</div>
            <f:input path="telNumber"/>
            <f:errors path="telNumber" cssClass="error"/>         
            <div class="editor-label">Adresa</div>
                <f:select path="idAddress">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listAddress}" var="address" >
                        <f:option label="${address['value']}" value="${address['key']}"/>
                    </c:forEach>
                </f:select>
            <f:errors path="idAddress" cssClass="error"/>
            <div class="editor-label">Centrum</div>
            <f:select path="idCenter">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listCenters}" var="center" >
                        <f:option label="${center['value']}" value="${center['key']}"/>
                    </c:forEach>
                </f:select>
            <f:errors path="idCenter" cssClass="error"/>
            <div class="editor-label">Role</div>
            <f:select path="roles" multiple="true">
                <c:forEach items="${listRoles}" var="role" >
                        <f:option label="${role['value']}" value="${role['key']}"/>
                </c:forEach>
            </f:select>
            <div class="editor-label">Aktivni</div>
            <f:checkbox path="active" label="Overeny"/>
            <f:errors path="active" cssClass="error"/>   
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>
        

<%@include file="../../../parts/footer.jspf"%>