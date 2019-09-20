<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var='view' value='/klientskeUdaje' scope='session' />
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="wrapperContainer">
    <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("osobni_udaje")}</p>
        </div>
    <%--<div id="navigaceTop">
        <ul class="navigaceList">
            <li> 
                <a href="ekcvjs?klientskeUdaje.jsp">
                    <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("osobni_udaje")}</span>                                
                </a></li>
            <li>
                <div class="slash">></div>
            </li>    
            <li> 
                <a href="ekcvjs.jsp">
                    <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                                
                </a>
            </li>               
        </ul>
    </div>--%>
    <div id="panelUdajeOsoba">

        <!--<h2>${zobrazeniTabulek.webProp.nazev("detaily_osoby")}</h2>!-->
        <h2>Detaily</h2>
        <form action="potvrzeniUdajeOs" method="post" id="klientInfoForm">                   
            <label for="titulpred">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_pred")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="titulpred"
                   name="titulpred"
                   value="${klientPrihlaseni.titulPred}">
            <br>
            <label for="jmeno">${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="name"
                   name="jmeno"
                   value="${klientPrihlaseni.jmeno}">
            <br>
            <label for="prijmeni">${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="surname"
                   name="prijmeni"
                   value="${klientPrihlaseni.prijmeni}">
            <br>
            <label for="titulza">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_za")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="titulza"
                   name="titulza"
                   value="${klientPrihlaseni.titulZa}">
            <br>
            <br>
            <c:if test="${chybaRegistrace eq 'neniRodneCislo'}">
                <p class="loginError" >${zobrazeniTabulek.webProp.nazev("zadejte_rodne_cislo")}</p>
            </c:if> 
            <c:if test="${chybaRegistrace eq 'spatneRC'}">
                <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_rodne_cislo")}</p>
            </c:if> 
            <label for="rodnecislo">${zobrazeniTabulek.webProp.nazev("uzivatel_rodne_cislo")}:</label>
            <input type="text"
                   size="31"
                   maxlength="19"
                   id="rodnecislo"
                   name="rodnecislo"
                   value="${klientPrihlaseni.rodneCislo}">
            <br>
            <label for="datumnarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_datum_narozeni")}:</label>
            <input type="text"
                   size="31"
                   maxlength="19"
                   id="datumnarozeni"
                   name="datumnarozeni"
                   value="<fmt:formatDate value="${klientPrihlaseni.datumNarozeni}" pattern="d.M.yyyy"/>  ">
            <br>
            <label for="mistonarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_misto_narozeni")}:</label>
            <input type="text"
                   size="31"
                   maxlength="19"
                   id="mistonarozeni"
                   name="mistonarozeni"
                   value="${klientPrihlaseni.mistoNarozeni}">
            <br>
            <div id="narodnostInfoDiv">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("uzivatel_narodnost")}:</p>
                <select name="vyberNarodnost" size="1">
                    <c:forEach var="narodnost" items="${narodnosti}">       
                        <c:choose>
                            <c:when test="${narodnost.narodnostNazev eq klientPrihlaseni.narodnost}">
                                <option selected value="${narodnost.narodnostNazev}">${narodnost.narodnostNazev}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${narodnost.narodnostNazev}">${narodnost.narodnostNazev}</option>
                            </c:otherwise>
                        </c:choose> 
                    </c:forEach>
                </select>
                <br>
            </div>
            <div id="prislusnostInfoDiv">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("uzivatel_prislusnost")}:</p>
                <select name="vyberPrislusnost" size="1">
                    <c:forEach var="prislusnost" items="${statPrislusnosti}">       
                        <c:choose>
                            <c:when test="${prislusnost.statniPrislusnostNazev eq klientPrihlaseni.statniPrislusnost}">                                                          orgTypPol.katOrgPolozkyPK.katorgpolId == vyberKatOrgDruh}">
                                <option selected value="${prislusnost.statniPrislusnostNazev}">${prislusnost.statniPrislusnostNazev}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${prislusnost.statniPrislusnostNazev}">${prislusnost.statniPrislusnostNazev}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>                            
                <br>
            </div>
            <%-- <label for="narodnost">${zobrazeniTabulek.webProp.nazev("uzivatel_narodnost")}:</label>
             <input type="text"
                    size="31"
                    maxlength="45"
                    id="narodnost"
                    name="narodnost"
                    value="${klientPrihlaseni.narodnost}">  
             <br>
             <label for="prislusnost">${zobrazeniTabulek.webProp.nazev("uzivatel_prislusnost")}:</label>
             <input type="text"
                    size="31"
                    maxlength="45"
                    id="prislusnost"
                    name="prislusnost"
                    value="${klientPrihlaseni.statniPrislusnost}">
            <br>--%>
            <br>
            <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="adresa"
                   name="adresa"
                   value="${klientPrihlaseni.adresa}">           
            <br>
            <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="mesto"
                   name="mesto"
                   value="${klientPrihlaseni.mesto}">    
            <br>
            <label for="psc">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="psc"
                   name="psc"
                   value="${klientPrihlaseni.psc}"> 
            <br>
            <br>
            <label for="email">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</label>
            <input type="text"
                   size="31"
                   maxlength="45"
                   id="email"
                   name="email"
                   value="${klientPrihlaseni.EMail}">
            <br>
            <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
            <input type="text"
                   size="31"
                   maxlength="16"
                   id="telefon"
                   name="telefon"
                   value="${klientPrihlaseni.telefon}">
            <br>
            <input type="submit" value="Potvrdit" id="submitOsobaUdaje"/>                 
        </form>

    </div>
</div>

