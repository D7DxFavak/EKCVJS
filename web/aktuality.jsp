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
                        <a href="${kategorieAktuality}?aktuality.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("aktuality")}</span>                                
                        </a></li> 

                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="${kategorieAktuality}?${kategorieAktuality}.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(kategorieAktuality)}</span>                                
                        </a></li>               
                </ul>
            </div>--%>
            <ul>
                <c:forEach var="aktuality" items ="${aktualitySeznam}">                        
                    <li class="aktualitySeznamList">              
                        <div id="aktualitySeznamNadpis">
                            <p class="aktualitySeznamDatum"><fmt:formatDate value="${aktuality.webAktualityDatumVlozeni}" pattern="d.M.yyyy"/></p>

                            <a href="${kategorieAktuality}?aktuality.jsp&idAktualita=${aktuality.webAktualityPK.webAktualityId}">
                                <span class="aktualitySeznamLabel"></span>
                                <span class="aktualitySeznamText">${aktuality.webAktualityNazev}</span>
                            </a>
                        </div>
                        <c:choose>
                            <c:when test = "${idAktualitaDetail == aktuality.webAktualityPK.webAktualityId}">
                                <div id="aktualitySeznamMain">
                                    <p>${aktuality.webAktualityPopis}</p>
                                    <div id="aktualitaAutor">
                                        <span class="aktualitySeznamAutor">${zobrazeniTabulek.webProp.nazev("autor_textu")}: </span>
                                        <span class="aktualitySeznamAutorJmeno">${aktuality.webAktualityVlozil.titulPred} ${aktuality.webAktualityVlozil.jmeno} ${aktuality.webAktualityVlozil.prijmeni} ${aktuality.webAktualityVlozil.titulZa}</span>
                                    </div>
                                </div>                            

                            </c:when>                        
                            <c:otherwise>
                                <div id="aktualitySeznamMain">
                                    <p>
                                        ${aktuality.webAktualityPopisKratky}
                                    </p>
                                </div>
                                <div id="aktualitySeznamOdkaz">
                                    <a href="${kategorieAktuality}?aktuality.jsp&idAktualita=${aktuality.webAktualityPK.webAktualityId}">                                       
                                        <span class="aktualitySeznamText">${zobrazeniTabulek.webProp.nazev("vice")}</span>
                                    </a>
                                </div>
                            </c:otherwise>
                        </c:choose>                    
                    </li>                        
                </c:forEach>
            </ul>

            <div id ="navigace">
                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                <a class="navClass" href="index?aktuality.jsp&pocetStrana=10">10</a>
                <a class="navClass" href="index?aktuality.jsp&pocetStrana=15">15</a>
                <a class="navClass" href="index?aktuality.jsp&pocetStrana=20">20</a>             
            </div>
            <div id="strana">
                <c:forEach var="strana" items="${strany}" varStatus="iter">
                    <c:choose>
                        <c:when test="${strana.cislo == -1}">
                            <a class="navClass" href="index?aktuality.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:when test="${strana.cislo == -2}">
                            <span>...</span>
                            <a class="navClass" href="index?aktuality.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navClass" href="index?aktuality.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:otherwise>
                    </c:choose>                      
                </c:forEach>                                 
            </div> 
        </div>
    </body>
</html>
