<%-- 
    Document   : login
    Created on : 26.7.2011, 10:57:14
    Author     : Anysek
--%>
<%@include file="../../../parts/header.jspf"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>
<h2>Profil uživatele ${profilModel.firstname}</h2>
<div>
    <fieldset>
        <legend>Základní informace</legend>
        <table>
            <tr>
            <td><div class="editor-label">Jméno:</div></td><td>${profilModel.firstname}</td>
            </tr>
            <tr>
            <td><div class="editor-label">Příjmení:</div></td><td>${profilModel.surname}</td>
            </tr>
            <tr>
            <td><div class="editor-label">E-mail:</div></td><td>${profilModel.email}</td>
            </tr>
            <tr>
            <td><div class="editor-label">Telefonní číslo:</div></td><td>${profilModel.telNumber}</td>
            </tr>
            <tr>
            <td><div class="editor-label">Je členem centra:</div></td><td>${profilModel.centerName}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>Adresa</legend>
        <table>
            <tr>
            <td><div class="editor-label">Ulice:</div></td><td>${profilModel.street}</td>
            </tr>
            <tr>
            <td><div class="editor-label">Město:</div></td><td>${profilModel.city}</td>
            </tr>
            <tr>
            <td><div class="editor-label">PSČ:</div></td><td>${profilModel.zipCode}</td>
            </tr>
            <tr>
            <td><div class="editor-label">Region:</div></td><td>${profilModel.regionName}</td>
            </tr>
        </table>
    </fieldset>
</div>
<%@include file="../../../parts/footer.jspf"%>