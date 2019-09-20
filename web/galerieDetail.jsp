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
        <div id="wrapperPrihlaskyContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="${kategorieGalerie}?galerieDetail.jsp&idGalerie=${vybranaGalerie}">
                            <span class="navigacePopis">${infoGalerie}</span>                                
                        </a></li> 

                    <li>
                        <div class="slash">></div>                        
                    </li>  
                    <li> 
                        <a href="${kategorieGalerie}?galerie.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("galerie")}</span>                                
                        </a></li> 

                    <li>
                        <div class="slash">></div>
                    </li>                        
                    <li> 
                        <a href="${kategorieGalerie}">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(kategorieGalerie)}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
            <div id="fotoSeznamTop">
                <ul>
                    <li>
                        <a href="${kategorieGalerie}?galerieDetail.jsp&offset=-1">
                            <img src="img/arrowLeft.png" name="arLeft" alt="arLeft">
                        </a>
                    </li>
                    <c:forEach var="foto" items ="${fotoSeznam}" varStatus="iter">                        
                        <li class="fotoSeznamList">                           
                            <a href="${kategorieGalerie}?galerieDetail.jsp&idFotoGalerie=${foto.vazbaGalerieUlozistePK.vazbaGalerieUlozisteUloziste}&iterIndex=${iter.index}">
                                <c:choose>
                                    <c:when test="${foto.vazbaGalerieUlozistePK.vazbaGalerieUlozisteUloziste == zobrazeniTabulek.idUloziste}">
                                        <img class="aktImage" src="index?ulozisteData=${foto.vazbaGalerieUlozisteNahled.ulozisteDataId}" name="fotoList" alt="fotoList">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="index?ulozisteData=${foto.vazbaGalerieUlozisteNahled.ulozisteDataId}" name="fotoList" alt="fotoList">
                                    </c:otherwise>
                                </c:choose>

                            </a>
                        </li>                        
                    </c:forEach>
                    <li>
                        <a href="${kategorieGalerie}?galerieDetail.jsp&offset=-2">
                            <img src="img/arrowRight.png" name="arRight" alt="arRight">
                        </a>
                    </li>
                </ul>
            </div> 
            <div id="fotoSeznamBottom">

                <img src="index?ulozisteData=${zobrazeniTabulek.idUloziste}" name="fotoVelke" alt="fotoVelke">
                <p class="fotoPopisList">${zobrazeniTabulek.pomString}</p>
            </div>
        </div>
    </body>
</html>
