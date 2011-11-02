<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Administrace uživatelských rolí</h2>
    <p>
        Editace uživatelské role:
    </p>
    <div>
        <f:form action="save.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro editaci role ${formModel.id}</legend>
            <div class="editor-label">Název role</div>
            <f:hidden path="id" />
            <f:input path="name"/>
            <f:errors path="name" cssClass="error"/>
            <div class="editor-label">Popis role</div>
            <f:textarea cols="40" rows="5" path="description"/>
            <f:errors path="description" cssClass="error"/>
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>

<%@include file="../../../parts/footer.jspf"%>