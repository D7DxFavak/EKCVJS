<%-- 
    Document   : potvrzeniRegistrace
    Created on : 4.11.2011, 14:25:43
    Author     : 7Data Gotzy
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/potvrzeniRegistrace' scope='session' />

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Potvrzeni registrace</title>
    </head>
    <body>
        <div id="wrapperContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="index?potvrzeniRegistraceOrg.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("potvrzeni_registrace")}</span>                                
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
                <c:forEach var="panelyData" items ="${panelyData}">                        
                    <li class="statickeInfoList">          
                        <p class="statickeInfoNazev">${panelyData.getNazev(zobrazeniTabulek.webProp.lang)}</p>
                        <div class="statickeInfoDiv">
                            <c:forEach var="vazbaPanelyData" items ="${panelyData.vazbaPanelyDataUlozisteCollection}">  
                                <img align="left" src="index?ulozisteData=${vazbaPanelyData.ulozisteData.ulozisteDataId}" name="fotoStat" alt="fotoStat">
                            </c:forEach>
                            ${panelyData.getPopis(zobrazeniTabulek.webProp.lang)} 
                        </div>            
                    </li>                        
                </c:forEach>
            </ul>
            <%--<h1>${zobrazeniTabulek.webProp.nazev("uspesna_registrace")}</h1>
            <p>${organizacePrihlaseni.nazev}</p>
            <br>
            <a href="${pageContext.request.contextPath}/index.jsp">Pokračovat na stránky                                                       
            </a>--%>
        </div>
    </body>
</html>
