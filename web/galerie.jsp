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
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="${kategorieGalerie}?galerie.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("galerie")}</span>                                
                        </a></li> 

                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="${kategorieGalerie}?${kategorieGalerie}.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(kategorieGalerie)}</span>                                
                        </a></li>               
                </ul>
            </div>--%>
            <ul>
                <c:forEach var="galerie" items ="${galerieSeznam}">                        
                    <li class="galerieSeznamList">              
                        <div class="galerieLogo" onclick="location.href='${kategorieGalerie}?galerieDetail.jsp&idGalerie=${galerie.webGalerieId}';">
                            <img class="im2" src="index?galerieUvodni=${galerie.webGalerieId}" name="fotoUvodni" alt="" />
                            <div class="galerieSub">                                
                            </div>
                        </div>
                        <div class="galerieInfo">
                            <a href="${kategorieGalerie}?galerieDetail.jsp&idGalerie=${galerie.webGalerieId}">
                                <span class="galerieSeznamLabel"></span>
                                <span class="galerieSeznamText">${galerie.webGalerieNazev}</span>
                            </a>
                            <span class="galerieDatum">
                                <fmt:formatDate value="${galerie.webGalerieDatumVlozeni}" pattern="d.M.yyyy"/>
                            </span>
                            <img src="img/gallStrip.png" class="galerieStrip" alt="stripMain">
                            <p class="galeriePopis">${galerie.webGaleriePopis}</p>
                            <div id="galerieVlozil">
                                <span class="galerieAutor">${zobrazeniTabulek.webProp.nazev("galerie_vlozil")}: </span>
                                <span class="galerieAutorJmeno">${galerie.webGalerieVlozil.titulPred} ${galerie.webGalerieVlozil.jmeno} ${galerie.webGalerieVlozil.prijmeni} ${galerie.webGalerieVlozil.titulZa}</span>
                            </div>
                        </div>
                    </li>                        
                </c:forEach>
            </ul>

            <div id ="navigace">
                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                <a class="navClass" href="index?galerie.jsp&pocetStrana=5">5</a>
                <a class="navClass" href="index?galerie.jsp&pocetStrana=10">10</a>
                <a class="navClass" href="index?galerie.jsp&pocetStrana=20">20</a>             
            </div>
            <div id="strana">
                <c:forEach var="strana" items="${strany}" varStatus="iter">
                    <c:choose>
                        <c:when test="${strana.cislo == -1}">
                            <a class="navClass" href="index?galerie.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:when test="${strana.cislo == -2}">
                            <span>...</span>
                            <a class="navClass" href="index?galerie.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navClass" href="index?galerie.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:otherwise>
                    </c:choose>                      
                </c:forEach>                                 
            </div> 
        </div>
    </body>
</html>
