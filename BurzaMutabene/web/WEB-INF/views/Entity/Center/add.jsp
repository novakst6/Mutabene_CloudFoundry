<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Administrace center</h2>
    <p>
        Přidání nového centra:
    </p>
    <div>
        <f:form action="submit.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro přidání</legend>
            <div class="editor-label">Název</div>
            <f:input path="name"/>
            <f:errors path="name" cssClass="error"/>
            <div class="editor-label">Popis</div>
            <f:textarea cols="20" rows="5" path="description"/>
            <f:errors path="description" cssClass="error"/>
            <div class="editor-label">Adresa</div>
                <f:select path="idAddress">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listAddress}" var="address" >
                        <f:option label="${address['value']}" value="${address['key']}"/>
                    </c:forEach>
                </f:select>
            <f:errors path="idAddress" cssClass="error"/>
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>
        

<%@include file="../../../parts/footer.jspf"%>