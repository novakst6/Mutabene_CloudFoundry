<%@include file="../../../parts/header.jspf"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
   <h2>Administrace uživatelů</h2>
    <p>
        Editace uživatele:
    </p>
    <div>
        <f:form action="save.htm" commandName="formModel" method="post">
        <fieldset>
            <legend>Formulář pro přidání</legend>
            <div class="editor-label">Jméno</div>
            <f:input path="firstname"/>
            <f:errors path="firstname" cssClass="error"/>
            <div class="editor-label">Příjmení</div>
            <f:input path="surname"/>
            <f:errors path="surname" cssClass="error"/>
            <div class="editor-label">Pohlaví</div>
            <c:choose>
                <c:when test="${formModel.gender == 'MALE'}">
                    <f:radiobutton path="gender" value="MALE" label="Muž" id="rad_gender" checked="true"/>
                    <f:radiobutton path="gender" value="FEMALE" label="Žena" id="rad_gender" />
                </c:when>
                <c:when test="${formModel.gender == 'FEMALE'}">
                    <f:radiobutton path="gender" value="MALE" label="Muž" id="rad_gender"/>
                    <f:radiobutton path="gender" value="FEMALE" label="Žena" id="rad_gender" checked="true"/>
                </c:when>
            </c:choose>
            
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
                        <c:choose>
                            <c:when test="${address['key'] == formModel.idAddress}">
                                <f:option label="${address['value']}" value="${address['key']}" checked="true"/>
                            </c:when>
                            <c:when test="${address['key'] != formModel.idAddress}">
                                <f:option label="${address['value']}" value="${address['key']}"/>
                            </c:when>
                        </c:choose>
                        
                    </c:forEach>
                </f:select>
            <f:errors path="idAddress" cssClass="error"/>
            <div class="editor-label">Centrum</div>
            <f:select path="idCenter">
                    <f:option label="Vyberte možnost" value="" />
                    <c:forEach items="${listCenters}" var="center" >
                        <c:choose>
                            <c:when test="${center['key'] == formModel.idCenter}">
                                <f:option label="${center['value']}" value="${center['key']}" checked="true"/>
                            </c:when>
                            <c:when test="${center['key'] != formModel.idCenter}">
                                <f:option label="${center['value']}" value="${center['key']}"/>
                            </c:when>
                        </c:choose>
                        
                    </c:forEach>
                </f:select>
            <f:errors path="idCenter" cssClass="error"/>
            <div class="editor-label">Role</div>
            <f:select path="roles" multiple="true">
                <c:forEach items="${listRoles}" var="role" >
                    <c:choose>
                        <c:when test="${role['key'] == formModel.roles}">
                            <f:option label="${role['value']}" value="${role['key']}" checked="true"/>
                        </c:when>
                        <c:when test="${role['key'] != formModel.roles}">
                            <f:option label="${role['value']}" value="${role['key']}"/>
                        </c:when>
                    </c:choose>
                        
                </c:forEach>
            </f:select>
            <div class="editor-label">Aktivni</div>
            <f:checkbox path="active" label="Overeny"/>
            <f:errors path="active" cssClass="error"/>   
            <f:hidden path="id"/>
        </fieldset>
        <p><input type="submit" /></p>
        </f:form>
    </div>

<%@include file="../../../parts/footer.jspf"%>