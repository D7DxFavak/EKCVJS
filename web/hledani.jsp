<%-- 
    Document   : aktuality
    Created on : 3.11.2011, 9:07:56
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>  
        <div id="wrapperContainer">
            <div class="searchLeftTop">
                <p> ${zobrazeniTabulek.webProp.nazev("hledany_vyraz")} : <span>${hledanyVyraz}</span></p>
            </div>
            <div class="searchRightTop">
                <p> ${zobrazeniTabulek.webProp.nazev("pocet_zaznamu")} : <span>${pocetZaznamuHledani}</span>
            </div>

            <ul>            
                <c:forEach var="vysledekHledani" items ="${hledanaData}">                        
                    <li class="hledaniSeznamList">                                       
                        <a href="${vysledekHledani.odkaz}">
                            <span class="seznamLabelText">${vysledekHledani.nazev}</span>
                        </a>
                    </li>                        
                </c:forEach>
            </ul>

            <div id ="navigaceHledani">
                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                <a class="navClassHledani" href="index?hledani.jsp&pocetStrana=10&hledanyVyraz=${hledanyVyraz}">10</a>
                <a class="navClassHledani" href="index?hledani.jsp&pocetStrana=20&hledanyVyraz=${hledanyVyraz}">20</a>
                <a class="navClassHledani" href="index?hledani.jsp&pocetStrana=50&hledanyVyraz=${hledanyVyraz}">50</a>             
            </div>
            <div id="stranaHledani">
                <c:forEach var="strana" items="${strany}" varStatus="iter">
                    <c:choose>
                        <c:when test="${strana.cislo == -1}">
                            <a class="navClassHledani" href="index?hledani.jsp&offset=${strana.cislo}&hledanyVyraz=${hledanyVyraz}">${strana.retez}</a>
                        </c:when>
                        <c:when test="${strana.cislo == -2}">
                            <span>...</span>
                            <a class="navClassHledani" href="index?hledani.jsp&offset=${strana.cislo}&hledanyVyraz=${hledanyVyraz}">${strana.retez}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navClassHledani" href="index?hledani.jsp&offset=${strana.cislo}&hledanyVyraz=${hledanyVyraz}">${strana.retez}</a>
                        </c:otherwise>
                    </c:choose>                      
                </c:forEach>                                 
            </div>      

        </div>
    </body>
</html>
