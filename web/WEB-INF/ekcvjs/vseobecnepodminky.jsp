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
           <%-- <li>
                <p class="statickeInfoNazev">Informované souhlasy Vašich zaměstnanců</p>
                <ul>
                    <li>
                        <ul>
                            <li>Vzhledem k modernizaci elektronické KCVJŠ a novému nařízení EU o ochraně osobních dat došlo k několika změnám</li>
                            <li>Abychom mohli nadále pracovat s vybranými osobními údaji vašich zaměstnanců, potřebujeme k tomu jejich souhlas</li>
                            <li>Každému ze zaměstnanců, který u nás byl na vzdělávací akci byl vygenerován přístup do elektronické KCVJŠ, kde nám může souhlas udělit</li>
                            <li>Tento souhlas musí každý udělit osobně. Nelze toto provést v zastoupení.</li>
                        </ul>
                    </li>

                </ul>
            </li>
            <li>
                <p class="statickeInfoNazev">Novinky v elektronickém KCVJŠ</p>
                <ul>
                    <li>
                        <ul>
                            <li>Rádi bychom, aby se vaši zaměsntanci přihlašovali sami, proto všem vytvoříme uživatelské účty</li>
                            <li>Od vás očekáváme udržování přidružených osob v aktuální podobě a mazání osob, které u vás již nepracují</li>
                            <li>Celý proces se výrazně zjednoduší, vaši zaměstnanci budou pracovat samostatně, popř. s vaší pomocí</li>
                        </ul>
                    </li>

                </ul>
            </li>--%>
        </ul>  
    </body>
</html>
