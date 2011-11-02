<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Burza karet</h2>
    <p>
        Přidání nové nabídky/poptávky:
    </p>
    <div>
        <f:form action="submit.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro přidání</legend>
            <div class="editor-label">Město</div>
            <f:input path="city"/>
            <f:errors path="city" cssClass="error"/>
            <div class="editor-label">Ulice, ČP</div>
            <f:input path="street"/>
            <f:errors path="street" cssClass="error"/>
            <div class="editor-label">PSČ</div>
            <f:input path="zipCode"/>
            <f:errors path="zipCode" cssClass="error"/>
            <div class="editor-label">Region</div>
                <f:select path="idRegion">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listRegions}" var="region" >
                        <c:choose>
                            <c:when test="${region['key'] == 'parent'}">
                                <f:option label="${region['value']}" value="${region['key']}" disabled="true"/>
                            </c:when>
                            <c:when test="${region['key'] != 'parent'}">
                                <f:option label="${region['value']}" value="${region['key']}"/>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </f:select>
            <f:errors path="idRegion" cssClass="error"/>
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>
        

<%@include file="../../../parts/footer.jspf"%>