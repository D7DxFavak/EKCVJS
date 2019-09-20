<%-- 
    Document   : zakladniInfoDVPP
    Created on : 27.10.2011, 13:00:10
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    </head>
    <body>    
        <%--<div id="navigaceTop">
            <ul class="navigaceList">
                <li> 
                    <a href="index?index.jsp">
                        <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("zakladni_info")}</span>                                
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

        <ul>
            <c:forEach var="mainPagePolozka" items ="${mainPagePolozky}" varStatus="i">
                <li class="homePanelLi${i.count}">
                    <c:choose>
                        <c:when test="${mainPagePolozka.webMainPageKategorie.webKategorieZakladniId == 50}">
                            <div class="homePanelNazev${i.count}" onclick="location.href='https://kcvjs.cz/ekcvjs/ekcvjs?ekcvjs.jsp';">
                                <a href="https://kcvjs.cz/ekcvjs/ekcvjs?ekcvjs.jsp"></a>           
                            </div>
                        </c:when>
                          <c:when test="${mainPagePolozka.webMainPageKategorie.webKategorieZakladniId == 80}">
                            <div class="homePanelNazev${i.count}" onclick="location.href='http://www.infokariera.cz';">
                                <a href="http://www.infokariera.cz"></a>           
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="homePanelNazev${i.count}" onclick="location.href='${mainPagePolozka.webMainPageKategorie.webKategorieZakladniOdkaz}?${mainPagePolozka.webMainPageKategorie.webKategorieZakladniOdkaz}.jsp';">
                                <a href="${mainPagePolozka.webMainPageKategorie.webKategorieZakladniOdkaz}?${mainPagePolozka.webMainPageKategorie.webKategorieZakladniOdkaz}.jsp"> </a>                         
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <div class="homePanelDetail">
                        <h2>${mainPagePolozka.getNazev(zobrazeniTabulek.webProp.lang)}</h2>
                        <p>${mainPagePolozka.getPopis(zobrazeniTabulek.webProp.lang)}</p>
                        <img src="img/mPthin.png" id="stripMainPage" alt="stripMain">
                        <c:choose>
                            <c:when test="${mainPagePolozka.webMainPageKategorie.webKategorieZakladniId == 50}">
                                <a href="index?loginRegistrace.jsp">${zobrazeniTabulek.webProp.nazev("menu_registrace")} / ${zobrazeniTabulek.webProp.nazev("menu_prihlaseni")}</a>                                     
                            </c:when>
                                  <c:when test="${mainPagePolozka.webMainPageKategorie.webKategorieZakladniId == 80}">
                                <a href="http://www.infokariera.cz/kdo-jsme-co-chceme">${zobrazeniTabulek.webProp.nazev("nabidka_nasich_sluzeb")}</a>                                     
                            </c:when>
                            <c:otherwise>
                                <a href="${mainPagePolozka.webMainPageKategorie.webKategorieZakladniOdkaz}?vzdProgramy.jsp">${zobrazeniTabulek.webProp.nazev("nabidka_vzdelavaci_programy")}</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </li>
            </c:forEach>
        </ul>

        <%--<div id="spolupraceHome">
            <p class="spolupraceNadpis">${zobrazeniTabulek.webProp.nazev("aktualni_projekty")}
            <ul> 
                <c:forEach var="webLogaHlavni" items ="${webLogaHlavni}" varStatus="i">
                    <li>
                        <c:if test="${webLogaHlavni.webLogaZobrazLogo == true}">
                            <a href="${webLogaHlavni.webLogaOdkaz}">
                                <img src="index?index.jsp&ulozisteData=${webLogaHlavni.webLogaUlozisteData.ulozisteDataId}" name="logo">
                            </a>
                        </c:if>
                        <c:if test="${webLogaHlavni.webLogaZobrazOdkaz == true}">
                            <a href="${webLogaHlavni.webLogaOdkaz}">${webLogaHlavni.webLogaOdkaz}                           
                            </a>
                        </c:if>
                        <c:if test="${webLogaHlavni.webLogaZobrazPopis == true}">
                            ${webLogaHlavni.webLogaPopis}                         
                        </c:if>
                    </li>
                </c:forEach>                     
            </ul>
        </div>--%>
    </body>
</html>
