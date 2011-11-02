<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Administrace uživatelských rolí</h2>
    <p>
        Editace regionu:
    </p>
    <div>
       <f:form action="save.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro přidání</legend>
            <div class="editor-label">Název regionu</div>
            <f:input path="name"/>
            <f:errors path="name" cssClass="error"/>
            <div class="editor-label">Nadřazený region</div>
                <f:select path="id">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listRegions}" var="region" >
                        <c:choose>
                            <c:when test="${region['key'] == formModel.id}">
                                <f:option label="${region['value']}" value="${region['key']}" selected="true"/>
                            </c:when>
                            <c:when test="${region['key'] != formModel.id}">
                                <f:option label="${region['value']}" value="${region['key']}"/>
                            </c:when>                     
                        </c:choose> 
                    </c:forEach>
                </f:select>
            <f:errors path="id" cssClass="error"/>
            <f:hidden path="idOrig" />
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>

<%@include file="../../../parts/footer.jspf"%>