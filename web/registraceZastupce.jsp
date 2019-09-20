<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/registrace' scope='session' />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="$/css/affablebean2.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>
        <div id="wrapperContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="index?registrace.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("menu_registrace_zastupce")}</span>                                
                        </a></li> 

                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="index.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("home")}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
            <div id="panelRegistrace">
                <h2 class="registraceNadpis">${zobrazeniTabulek.webProp.nazev("registrace_zakonneho_zastupce")}</h2>                            
                <form action="registraceZakZastupce" method="post" id="registraceForm">                    
                    <fieldset>
                        <legend></legend>                       
                        <c:if test="${chybaRegistrace eq 'prazdneJmeno'}">
                            <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_jmeno")}</p>
                        </c:if> 
                        <label for="jmenoZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="jmenoZastupce"
                               name="jmenoZastupce"
                               value="${param.jmenoZastupce}">
                        <br>
                        <c:if test="${chybaRegistrace eq 'prazdnePrijmeni'}">
                            <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_prijmeni")}</p>
                        </c:if> 
                        <label for="prijmeniZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="prijmeniZastupce"
                               name="prijmeniZastupce"
                               value="${param.prijmeniZastupce}">
                        <br>                      
                    </fieldset>                 
                    <fieldset>
                        <legend></legend>
                        <c:if test="${chybaRegistrace eq 'prazdnaAdresa'}">
                            <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdna_adresa")}</p>
                        </c:if> 
                        <label for="adresaZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="adresaZastupce"
                               name="adresaZastupce"
                               value="${param.adresaZastupce}">           
                        <br>
                        <c:if test="${chybaRegistrace eq 'prazdneMesto'}">
                            <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_mesto")}</p>
                        </c:if> 
                        <label for="mestoZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="mestoZastupce"
                               name="mestoZastupce"
                               value="${param.mestoZastupce}">    
                        <br>
                        <c:if test="${chybaRegistrace eq 'prazdnePSC'}">
                            <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_psc")}</p>
                        </c:if> 
                        <label for="pscZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="pscZastupce"
                               name="pscZastupce"
                               value="${param.pscZastupce}"> 
                        <br>
                        <br>
                        <c:if test="${chybaRegistrace eq 'chybiEmail'}">
                            <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_email")}</p>
                        </c:if>
                        <label for="emailZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:*</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="emailZastupce"
                               name="emailZastupce"
                               value="${param.emailZastupce}">
                        <br>
                        <label for="telefonZastupce">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="16"
                               id="telefonZastupce"
                               name="telefonZastupce"
                               value="${param.telefonZastupce}">
                        <br>
                        <p id="nepovinneUdaje">${zobrazeniTabulek.webProp.nazev("nepovinne_udaje")}</p>
                        <br>                            
                        <input name="submitOsobaUdaje" type="submit" value="Potvrdit" id="submitOsobaUdaje"/> 
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
