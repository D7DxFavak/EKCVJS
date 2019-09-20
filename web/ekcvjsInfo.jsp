<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/category' scope='session' />





<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/affablebean2.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico">

        <title>KCVJŠ</title>
    </head>

    <body>

        <%-- <div id="indexTopColumn">
             <div id="indexTopColumnL1">
                 <img src="img/mainM_left.png" alt="altL">
             </div>
             <div id="indexTopColumnC1">
                 <ul>
                     <li class="topListItemNektivni">
                         <a href="index.jsp">               
                             <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("home")}</span>                   
                         </a>
                         <ul>
                             <c:forEach var="odkazDetail" items ="${panelyHomeData}">                    
                                 <li onclick="location.href = 'index?${odkazDetail.webPanelyOdkaz}';"> 
                                     <a href="index?${odkazDetail.webPanelyOdkaz}">
                                         <span class="catDetailLabel"></span>
                                         <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                     </a>
                                 </li>                        
                             </c:forEach>
                         </ul>
                     </li>
                     <li class="topListItemNektivni">
                         <a href="ucitele?ucitele.jsp">        
                             <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("ucitele")}</span>                   
                         </a>
                         <ul>
                             <c:forEach var="odkazDetail" items ="${panelyUciteleData}">

                                <li onclick="location.href = 'ucitele?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="ucitele?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>                       
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="topListItemNektivni">
                        <a href="js?js.jsp">
                            <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("js")}</span>                   
                        </a>
                        <ul>
                            <c:forEach var="odkazDetail" items ="${panelyJsData}">

                                <li onclick="location.href = 'js?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="js?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>

                            </c:forEach>
                        </ul>
                    </li>                    
                    <li class="topListItemAktivni">
                        <c:choose>
                            <c:when test="${pageContext.request.remoteUser != null}">
                                <a href="ekcvjsInfo.jsp">                
                                    <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                   
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="ekcvjs?prihlaseniUzivatele.jsp">                
                                    <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                   
                                </a>
                            </c:otherwise>
                        </c:choose>
                        <ul>
                            <c:if test="${pageContext.request.remoteUser != null}">
                                <c:forEach var="odkazDetail" items ="${panelyEkcvjsData}">
                                    <c:choose>
                                        <c:when test="${odkazDetail.webPanelyOdkaz eq 'ekcvjs.jsp'}">
                                            <li onclick="location.href = 'ekcvjsInfo.jsp';"> 
                                                <a href="ekcvjsInfo.jsp">
                                                    <span class="catDetailLabel"></span>
                                                    <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                                </a>
                                            </li>
                                        </c:when>
                                        <c:when test="${panely.webPanelyOdkaz eq 'pridruzeneOsoby.jsp'}">
                                            <c:choose>
                                                <c:when test="${typKlient ==1}">
                                                    <li onclick="location.href = 'ekcvjs?zamestnavatelUdaje.jsp';">  
                                                        <a href="ekcvjs?zamestnavatelUdaje.jsp" class="panelButton">
                                                            <img src="img/mbuttarr.png" alt="mbutar">
                                                            <span class="panelText">
                                                                ${zobrazeniTabulek.webProp.nazev("zamestnavatel_udaje")}
                                                            </span>
                                                        </a>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li onclick="location.href = 'ekcvjs?${panely.webPanelyOdkaz}';">  
                                                        <a href="ekcvjs?${panely.webPanelyOdkaz}" class="panelButton">
                                                            <img src="img/mbuttarr.png" alt="mbutar">
                                                            <span class="panelText">
                                                                ${zobrazeniTabulek.webProp.nazev(panely.webPanelyNazev)}
                                                            </span>
                                                        </a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:when>        
                                        <c:otherwise>

                                            <li onclick="location.href = 'ekcvjs?${odkazDetail.webPanelyOdkaz}';">                                               
                                                <a href="ekcvjs?${odkazDetail.webPanelyOdkaz}">
                                                    <span class="catDetailLabel"></span>
                                                    <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                                </a>
                                            </li>
                                        </c:otherwise>  
                                    </c:choose>                     
                                </c:forEach>
                            </c:if>
                        </ul>
                    </li>
                </ul>  
            </div>
            <div id="indexTopColumnFCB">
                <ul>
                    <li class="topListItemNektivni">
                        <a href="https://www.facebook.com/KCVJS">               
                            <img id="logoFCB" src="img/fb-art.png" name="logoFCB">          
                        </a>
                    </li>
                </ul>     
            </div>  
            <div id="indexTopColumnR1">
                <img src="img/mainM_right.png" alt="altR">
            </div>  
        </div>--%>

        <div id="container70">

            <div id="panelLeftColumn">
                <%--<div id="leftColumnUl1">
                    <form action="hledani" method="post" id="hledatForm">
                        <input type="text" name="vyraz"
                               value='${zobrazeniTabulek.webProp.nazev("hledany_vyraz")}'
                               class="inp_text" onfocus=
                               "javascript:{
                                            if (this.value == '${zobrazeniTabulek.webProp.nazev("hledany_vyraz")}')
                                                this.value = '';
                                        }"
                               onkeypress="if (window.event.keyCode == 13) {
                                            submit
                                        }"    
                               >
                    </form>
                </div>--%>
                <div id="leftColumnUl2">
                    <ul>
                        <li class="leftColumnHeader">
                            ${zobrazeniTabulek.webProp.nazev("dokumenty")}
                        </li>            
                        <li class="leftColumnText" onclick="location.href = 'ekcvjs?ekcvjs.jsp';">  
                                        <a href="ekcvjs?ekcvjs.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("home")}
                                            </span>
                                        </a>
                                    </li>
                        <li class="leftColumnText" onclick="location.href = 'ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=1';">                      
                            <a class="panelButton" href="ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=1">
                                <span class="panelText">
                                    ${zobrazeniTabulek.webProp.nazev("vystavene_faktury")}
                                </span>
                            </a>
                        </li>
                        <li class="leftColumnText" onclick="location.href = 'ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=2';">                      
                            <a class="panelButton" href="ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=2">
                                <span class="panelText">
                                    ${zobrazeniTabulek.webProp.nazev("vystavene_certifikaty")}
                                </span>
                            </a>
                        </li>
                        <li class="leftColumnText" onclick="location.href = 'ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=3';">                      
                            <a class="panelButton" href="ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=3">
                                <span class="panelText">
                                    ${zobrazeniTabulek.webProp.nazev("vystavene_dokumenty")}
                                </span>
                            </a>
                        </li>
                        <li class="leftColumnText" onclick="location.href = 'ekcvjs?keStazeni.jsp';">                      
                            <a class="panelButton" href="ekcvjs?keStazeni.jsp">
                                <span class="panelText">
                                    ${zobrazeniTabulek.webProp.nazev("ke_stazeni")}
                                </span>
                            </a>
                        </li>   
                        <li class="leftColumnText" onclick="location.href = 'ekcvjs?vseobecnepodminky.jsp';">                      
                            <a class="panelButton" href="ekcvjs?vseobecnepodminky.jsp">
                                <span class="panelText">
                                    ${zobrazeniTabulek.webProp.nazev("vseobecne_podminky")}
                                </span>
                            </a>
                        </li> 
                    </ul>
                </div>
                <div id="leftColumnUl3">   
                    <ul>
                        <li class="leftColumnHeader">
                            <c:choose>
                                <c:when test="${typKlient ==2}">
                                    ${zobrazeniTabulek.webProp.nazev("vasefirma")}
                                </c:when>
                                <c:otherwise>
                                    ${zobrazeniTabulek.webProp.nazev("vaseudaje")}
                                </c:otherwise>
                            </c:choose>

                        </li>
                        <c:if test="${pageContext.request.remoteUser != null}">
                            <c:choose>
                                <c:when test="${typKlient ==2}">                                    
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?novePrihlaseni.jsp';">  
                                        <a href="ekcvjs?novePrihlaseni.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("nova_prihlaska")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?gdprInfo.jsp';">  
                                        <a href="ekcvjs?gdprInfo.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("tab_gdpr")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?klientskeUdaje.jsp';">  
                                        <a href="ekcvjs?klientskeUdaje.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("osobni_udaje")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?loginUdaje.jsp';">  
                                        <a href="ekcvjs?loginUdaje.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("prihlasovaci_udaje")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?prihlaskyAkce.jsp';">  
                                        <a href="ekcvjs?prihlaskyAkce.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("prihlasky_na_akce")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?absolvovaneAkce.jsp';">  
                                        <a href="ekcvjs?absolvovaneAkce.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("absolvovane_akce")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?pridruzeneOsoby.jsp';">  
                                        <a href="ekcvjs?prihlaskyOsoby.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("pridruzene_osoby")}
                                            </span>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?ekcvjs.jsp';">  
                                        <a href="ekcvjs?ekcvjs.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("home")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?novePrihlaseni.jsp';">  
                                        <a href="ekcvjs?novePrihlaseni.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("nova_prihlaska")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?gdprInfo.jsp';">  
                                        <a href="ekcvjs?gdprInfo.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("tab_gdpr")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?klientskeUdaje.jsp';">  
                                        <a href="ekcvjs?klientskeUdaje.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("osobni_udaje")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?loginUdaje.jsp';">  
                                        <a href="ekcvjs?loginUdaje.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("prihlasovaci_udaje")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?prihlaskyAkce.jsp';">  
                                        <a href="ekcvjs?prihlaskyAkce.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("prihlasky_na_akce")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?absolvovaneAkce.jsp';">  
                                        <a href="ekcvjs?absolvovaneAkce.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("absolvovane_akce")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?zamestnavatelUdaje.jsp';">  
                                        <a href="ekcvjs?zamestnavatelUdaje.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("zamestnavatel_udaje")}
                                            </span>
                                        </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </ul>
                </div>
                <div id="leftColumnUl4">
                    <div id="kontaktTop">                
                        <a href="index?kontakty.jsp">
                            <span class="kontaktNadpis">${zobrazeniTabulek.webProp.nazev("menu_kontakt_nadpis")}</span>
                        </a>                          
                    </div>
                    <div id="kontaktCenter">
                        <p class="kontaktTelefonText">${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),0,4)}
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),5,8)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),9,12)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),13,16)}</span></p>
                        <p class="kontaktEmailText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_email")}</p>
                        <p class="kontaktHodinyText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_hodiny")}</p>
                    </div>
                    <%--<div id="kontaktBottom">
                        <img src="img/lNewsLow.png" class="lnews" alt="lnews">
                        <a href="index?kontakty.jsp">
                            <img src="img/rNewsArr.png" class="kontaktDwnarr" alt="dwnarr">
                        </a>
                    </div> --%>
                </div>
                <div id="leftColumnUl5">
                    <div id="kontaktJSTop">                
                        <a href="index?kontakty.jsp">
                            <span class="kontaktNadpis">${zobrazeniTabulek.webProp.nazev("menu_kontakt_js_nadpis")}</span>
                        </a>                          
                    </div>
                    <div id="kontaktJSCenter">
                        <p class="kontaktTelefonText">${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_js_telefon"),0,4)}
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_js_telefon"),5,8)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_js_telefon"),9,12)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_js_telefon"),13,16)}</span></p>
                        <p class="kontaktEmailText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_js_email")}</p>
                        <p class="kontaktHodinyText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_js_hodiny")}</p>
                    </div>
                    <%--<div id="kontaktJSBottom">
                        <img src="img/lNewsLow.png" class="lnews" alt="lnews">
                        <a href="index?kontakty.jsp">
                            <img src="img/rNewsArr.png" class="kontaktDwnarr" alt="dwnarr">
                        </a>
                    </div> --%>
                </div>
            </div>  

            <div id="wrapper">
                <div id="wrapperTop">
                    <%-- <img src="img/wrapperTop.png" alt="wrapperTop">--%>
                </div>
                <div id="wrapperCenter">
                    <ul>
                        <c:forEach var="panelyData" items ="${ekcvjsPanelyData}">                        
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
                </div>
                <div id="wrapperBottom">
                    <%--<img src="img/wrapperBottom.png" class="kontaktDwnarr" alt="wrapperBottom">--%>
                </div>
            </div>


            <%--<div id="panelRightColumn">
                <div id="rightColumnUl1">
                    <ul>
                        <c:forEach var="aktuality" items ="${aktualitySouhrn}" varStatus="i">                        
                            <li>
                                <div id="newsTop">
                                    <p class="popisAktuality">${zobrazeniTabulek.webProp.nazev("menu_aktualne")}</p>
                                    <p class="datumAktuality"><fmt:formatDate value="${aktuality.webAktualityDatumVlozeni}" pattern="d.M.yyyy"/></p>
                                </div>
                                <a href="index?aktualita.jsp&idAktualita=${aktuality.webAktualityPK.webAktualityId}">
                                    <span class="aktualityLabel"></span>
                                    <span class="aktualityLabelText">${aktuality.webAktualityNazev}</span>
                                </a>
                                <img src="img/rNewsLow.png" class="rnews" alt="rnews">
                                <a href="index?aktualita.jsp&idAktualita=${aktuality.webAktualityPK.webAktualityId}">
                                    <img src="img/rNewsArr.png" class="dwnarr${i.count}" alt="dwnarr"></a>
                            </li>                        
                        </c:forEach>
                    </ul>
                </div>
                <div id="rightColumnUl2">
                    <ul></ul>
                </div>
                <div id="rightColumnUl3">

                </div>
            </div>--%>

        </div>

    </body>
</html>