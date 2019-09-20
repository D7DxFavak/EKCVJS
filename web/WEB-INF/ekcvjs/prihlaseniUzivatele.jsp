<%-- 
    Document   : prihlaseniUzivatele
    Created on : 7.2.2012, 12:19:39
    Author     : Favak
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GDPRInfo</title>
    </head>
    <body>
        <div id="wrapperContainer">
           <%-- <div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="ekcvjs?prihlaseniUzivatele.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("prihlaseni")}</span>                                
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
            <c:if test="${typKlient == 1 && klientPrihlaseni.gdprUdeleno eq false}">
                <h2 class="prihlaseniWarningHeader">${zobrazeniTabulek.webProp.nazev("chybejici_gdpr")}</h2>
                <p class="prihlaseniWarningP">Prosíme věnujte pozornost novému nařízení EU o zpracování osobních údajů, pokračujte prosím zde :  <a href='ekcvjs?gdprInfo.jsp'>Souhlas se zpracováním údajů</a></p>
            </c:if>    
            <c:if test="${typKlient == 2 && gdprVsichniZamestnanci eq false}">
                <h2 class="prihlaseniWarningHeader">${zobrazeniTabulek.webProp.nazev("chybejici_gdpr")}</h2>
                <p class="prihlaseniWarningP">Někteří z vašich zaměstnanců ještě neprovedli souhlas se zpracováním osobních údajů dle nového nařízení EU 2016/679 o ochraně osobních údajů, pokračujte prosím zde :  <a href='ekcvjs?gdprInfo.jsp'>Souhlas se zpracováním údajů</a></p>
            </c:if>
            <h2 class="prihlaseniHeader">${zobrazeniTabulek.webProp.nazev("prihlaseni_uspesne")}</h2>
            <p class="prihlaseniUzivatel">${zobrazeniTabulek.webProp.nazev("prihlasen_uzivatel")}: ${logUser}</p>


            
            <div id="prihlaseniInfo">
                <div class="prihlaseniPrihlasky1">
                    <p>${zobrazeniTabulek.webProp.nazev("pocet_aktivnich_prihlasek")}: ${aktivniPrihlasky}</p>
                    <p><span>${zobrazeniTabulek.webProp.nazev("seznam_nahlednout")} </span>
                        <a href="ekcvjs?prihlaskyAkce.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a></p>
                </div>
                <div class="prihlaseniPrihlasky2">
                    <p>${zobrazeniTabulek.webProp.nazev("pocet_skoncenych_prihlasek")}: ${skoncenePrihlasky}</p>               
                    <p><span>${zobrazeniTabulek.webProp.nazev("seznam_nahlednout")} </span>
                        <a href="ekcvjs?absolvovaneAkce.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a></p>
                </div>               
            </div>
           <%-- <div id ="prihlaseniNavrat">
                <p> <span>${zobrazeniTabulek.webProp.nazev("pokracovani_predchozi_strana")} </span>
                    <a href="${zobrazeniTabulek.aktualniStranka}">${zobrazeniTabulek.webProp.nazev("zde")}</a></p>
            
            </div>--%>
        </div>
    </body>
</html>
