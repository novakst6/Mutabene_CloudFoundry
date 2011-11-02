<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <h2>Administrace center</h2>
    <p>
        Editace centra:
    </p>
    <div>
  <f:form action="save.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro přidání</legend>
            <div class="editor-label">Název</div>
            <f:input path="name"/>
            <f:errors path="name" cssClass="error"/>
            <div class="editor-label">Popis</div>
            <f:input path="description"/>
            <f:errors path="description" cssClass="error"/>
            <div class="editor-label">Adresa</div>
                <f:select path="idAddress">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listAddress}" var="address" >
                       <c:choose>
                            <c:when test="${address['key'] == formModel.idAddress}">
                                <f:option label="${address['value']}" value="${address['key']}" selected="true"/>
                            </c:when>
                            <c:when test="${address['key'] != formModel.idAddress}">
                                <f:option label="${address['value']}" value="${address['key']}"/>
                            </c:when>                     
                        </c:choose> 
                    </c:forEach>
                </f:select>
            <f:errors path="idAddress" cssClass="error"/>
            <f:hidden path="id" />
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>

<%@include file="../../../parts/footer.jspf"%>