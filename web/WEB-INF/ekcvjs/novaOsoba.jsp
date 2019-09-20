<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/detailyOsoby' scope='session' />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>
        <div id="wrapperContainer">
            <div class="wrapperPrihlaskyNadpis">
                <p>...${zobrazeniTabulek.webProp.nazev("registrovat_nova_osoba")}</p>
            </div>
            <%-- <div id="navigaceTop">
                 <ul class="navigaceList">
                     <li> 
                         <a href="ekcvjs?novaOsoba.jsp">
                             <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("nova_osoba")}</span>                                
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


            <%-- <div id="panelUdajeOsoba">--%>
            <div id="panelRegistrace">
                <h2>${zobrazeniTabulek.webProp.nazev("nova_osoba")}</h2>
                <form action="novaOsobaOrg" method="post" id="klientInfoForm">          
                    <c:if test="${chybaRegistrace eq 'jizRegistrovanaOsoba'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("jiz_registrovana_osoba")}</p>
                    </c:if> 
                    <label for="titulpred">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_pred")}:*</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="titulpred"
                           name="titulpred"
                           value="${param.titulPred}">
                    <br>
                    <c:if test="${chybaRegistrace eq 'prazdneJmeno'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_jmeno")}</p>
                    </c:if> 
                    <label for="jmeno">${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="name"
                           name="jmeno"
                           value="${param.jmeno}">
                    <br>
                    <c:if test="${chybaRegistrace eq 'prazdnePrijmeni'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_prijmeni")}</p>
                    </c:if> 
                    <label for="prijmeni">${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="surname"
                           name="prijmeni"
                           value="${param.prijmeni}">
                    <br>
                    <label for="titulza">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_za")}:*</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="titulza"
                           name="titulza"
                           value="${param.titulZa}">
                    <br>
                    <div id="registraceRCCheck">
                        <input type="checkbox" name="neexRodneCislo" value="${param.neexrodnecislo} "onclick="if (this.checked) {
                                    this.form.rodnecislo.disabled = 1
                                } else {
                                    this.form.rodnecislo.disabled = 0
                                }"/>
                        <span>${zobrazeniTabulek.webProp.nazev("neexistuje_rodne_cislo_zam")}</span>
                    </div>
                    <c:if test="${chybaRegistrace eq 'neniRodneCislo'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("zadejte_rodne_cislo")}</p>
                    </c:if> 
                    <c:if test="${chybaRegistrace eq 'spatneRC'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_rodne_cislo")}</p>
                    </c:if> 
                    <br>
                    <label for="rodnecislo">${zobrazeniTabulek.webProp.nazev("uzivatel_rodne_cislo")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="rodnecislo"
                           name="rodnecislo"
                           value="${param.rodneCislo}">
                    <br>
                    <label for="datumnarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_datum_narozeni")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="datumnarozeni"
                           name="datumnarozeni"                       
                           value="<fmt:formatDate value="${param.datumNarozeni}" pattern="d.M.yyyy"/>  ">
                    <br>
                    <label for="mistonarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_misto_narozeni")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="mistonarozeni"
                           name="mistonarozeni"
                           value="${param.mistoNarozeni}">
                    <br>
                    <div id="narodnostInfoDiv">
                        <p class="detailyNarodnostP">${zobrazeniTabulek.webProp.nazev("uzivatel_narodnost")}:</p>
                        <select class="detailyNarodnostSelect" name="vyberNarodnost" size="1">
                            <c:forEach var="narodnost" items="${narodnosti}">       
                                <c:choose>
                                    <c:when test="${narodnost.narodnostNazev eq param.narodnost}">
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
                        <p class="detailyPrislusnostP">${zobrazeniTabulek.webProp.nazev("uzivatel_prislusnost")}:</p>
                        <select class="detailyPrislusnostSelect" name="vyberPrislusnost" size="1">
                            <c:forEach var="prislusnost" items="${statPrislusnosti}">       
                                <c:choose>
                                    <c:when test="${prislusnost.statniPrislusnostNazev eq param.statniPrislusnost}">                                                          orgTypPol.katOrgPolozkyPK.katorgpolId == vyberKatOrgDruh}">
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
                    <br>
                    <c:if test="${chybaRegistrace eq 'chybiAdresyUdaje'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("zadejte_kompletni_adresu")}</p>
                    </c:if> 
                    <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="adresa"
                           name="adresa"
                           value="${param.adresa}">           
                    <br>
                    <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="mesto"
                           name="mesto"
                           value="${param.mesto}">    
                    <br>
                    <label for="psc">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="psc"
                           name="psc"
                           value="${param.psc}"> 
                    <br>
                    <br>
                    <c:if test="${chybaRegistrace eq 'chybiEmail'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_email")}</p>
                    </c:if>
                    <label for="email">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.eMail}">
                    <br>
                    <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="telefon"
                           name="telefon"
                           value="${param.telefon}">
                    <br>
                    <p id="nepovinneUdaje">${zobrazeniTabulek.webProp.nazev("nepovinne_udaje")}</p>
                    <br>
                    <input type="submit" value="Potvrdit" id="submitOsobaUdaje"/>                 
                </form>
            </div>                                 
        </div>
    </body>
</html>
