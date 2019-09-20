<%-- 
    Document   : aktualityPanel
    Created on : 27.10.2011, 15:20:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='view' value='/aktualityPanel' scope='session' />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <ul>
            <c:forEach var="aktuality" items ="${aktualitySouhrn}">                        
                <li>
                    <p class="aktualityPanelNazev">${aktuality.webAktualityDatumVlozeni} - ${aktuality.webAktualityNazev}</p>
                    <span class="aktualityPanelText">${aktuality.webAktualityPopisKratky}</span>

                    <%-- <img src="${initParam.categoryImagePath}${category.webKategorieZakladniId}.jpg"
                
alt="${category.webKategorieZakladniNazev}" class="categoryImage">--%>
                    <a href="aktuality?${aktuality.webAktualityPK.webAktualityId}" class="aktualityPanelOdkaz">více</a>
                </li>                        
            </c:forEach>
        </ul>
    </body>
</html>
