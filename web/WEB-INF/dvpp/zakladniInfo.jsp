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
                    <a href="dvpp?zakladniInfo.jsp">
                        <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("zakladni_info")}</span>                                
                    </a></li> 
                <li>
                    <div class="slash">></div>
                </li>    
                <li> 
                    <a href="dvpp?dvpp.jsp">
                        <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("dvpp")}</span>                                
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
    </body>
</html>
