<%-- 
    Document   : dvpp
    Created on : 2.11.2011, 11:36:06
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/category' scope='session' />



<div id="indexTopColumn">
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
                        <c:choose>
                            <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                    <a href="http://kcvjs.cz/forum">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li onclick="location.href = 'index?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="index?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>      
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </ul>
            </li>
            <li class="topListItemNektivni">
                <a href="ucitele?ucitele.jsp">
                    <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("ucitele")}</span>                   
                </a>
                <ul>
                    <c:forEach var="odkazDetail" items ="${panelyUciteleData}">
                        <c:choose>
                            <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                    <a href="http://kcvjs.cz/forum">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li onclick="location.href = 'ucitele?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="ucitele?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>      
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </ul>
            </li>
            <li class="topListItemNektivni">
                <a href="js?js.jsp">
                    <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("js")}</span>                   
                </a>
                <ul>
                    <c:forEach var="odkazDetail" items ="${panelyJsData}">
                        <c:choose>
                            <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                    <a href="http://kcvjs.cz/forum">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li onclick="location.href = 'js?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="js?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>     
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </li>
            <%--<li class="topListItemAktivni">
                <a href="dvpp?dvpp.jsp">
                    <span class="categoryLabelTextAktivni">${zobrazeniTabulek.webProp.nazev("dvpp")}</span>                   
                </a>
                <ul>
                    <c:forEach var="odkazDetail" items ="${panelyDvppData}">
                        <c:choose>
                            <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                    <a href="http://kcvjs.cz/forum">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li onclick="location.href = 'dvpp?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="dvpp?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li> 
                            </c:otherwise>
                        </c:choose>                        
                    </c:forEach>
                </ul>
            </li> --%>      
            <%--<li class="topListItemNektivni">
                <a href="dvppvpk?dvppvpk.jsp">                
                    <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("dvppvpk")}</span>                   
                </a>
                <ul>
                    <c:forEach var="odkazDetail" items ="${panelyDvppvpkData}">
                        <c:choose>
                            <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                    <a href="http://kcvjs.cz/forum">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li onclick="location.href = 'dvppvpk?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="dvppvpk?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>                                     
                    </c:forEach>
                </ul>
            </li>--%>
            <li class="topListItemNektivni">
                <a href="ekcvjsInfo.jsp">                
                    <span class="categoryLabelTextNektivni">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                   
                </a>
                <ul>
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
                            <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                    <a href="http://kcvjs.cz/forum">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li onclick="location.href = 'https://kcvjs.cz/ekcvjs/ekcvjs?${odkazDetail.webPanelyOdkaz}';"> 
                                    <a href="https://kcvjs.cz/ekcvjs/ekcvjs?${odkazDetail.webPanelyOdkaz}">
                                        <span class="catDetailLabel"></span>
                                        <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                    </a>
                                </li>
                            </c:otherwise>  
                        </c:choose>                                                                         
                    </c:forEach>
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
</div>

<div id="container40">

    <div id="panelLeftColumn">
        <div id="leftColumnUl1">
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
        </div>
        <div id="leftColumnUl2">  
            <ul>
                <c:forEach var="panely" items="${panelyDvppData}">     
                    <c:choose>
                        <c:when test="${panely.webPanelyOdkaz eq 'forum.jsp'}">
                            <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                <a href="http://kcvjs.cz/forum" class="panelButton">
                                    <img src="img/mbuttarr.png" alt="mbutar">
                                    <span class="panelText">
                                        ${zobrazeniTabulek.webProp.nazev(panely.webPanelyNazev)}
                                    </span>                                
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li onclick="location.href = 'dvpp?${panely.webPanelyOdkaz}';">  
                                <a href="dvpp?${panely.webPanelyOdkaz}" class="panelButton">
                                    <img src="img/mbuttarr.png" alt="mbutar">
                                    <span class="panelText">
                                        ${zobrazeniTabulek.webProp.nazev(panely.webPanelyNazev)}
                                    </span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose> 
                </c:forEach>
            </ul>
        </div>
        <div id="leftColumnUl3">               
           <%-- <p class="citatText">${zobrazeniTabulek.webProp.nazev("dv_menu_citat")}</p>                 --%>
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
            <div id="kontaktBottom">
                <img src="img/lNewsLow.png" class="lnews" alt="lnews">
                <a href="index?kontakty.jsp">
                    <img src="img/rNewsArr.png" class="kontaktDwnarr" alt="dwnarr">
                </a>
            </div> 
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
            <div id="kontaktJSBottom">
                <img src="img/lNewsLow.png" class="lnews" alt="lnews">
                <a href="index?kontakty.jsp">
                    <img src="img/rNewsArr.png" class="kontaktDwnarr" alt="dwnarr">
                </a>
            </div> 
        </div>
    </div>


    <c:choose>
        <c:when test="${selectedCenter eq 'WEB-INF/dvpp/vzdProgramy.jsp'}">
            <div id="wrapperPrihlasky">      
                <div id="wrapperPrihlaskyTop">
                    <img src="img/wrapperPrihlaskyTop.png" alt="wrapperPrihlaskyTop">
                </div>
                <div id="wrapperPrihlaskyCenter">
                    <c:choose>
                        <c:when test="${zobrazeniTabulek.idAkce > 0}">
                            <jsp:include page="${selectedCenter}"/> 
                        </c:when>
                        <c:otherwise>
                            <jsp:include page="${selectedCenter}"/> 
                        </c:otherwise>
                    </c:choose>   
                </div>
                <div id="wrapperPrihlaskyBottom">
                    <img src="img/wrapperPrihlaskyBottom.png" class="kontaktDwnarr" alt="wrapperPrihlaskyBottom">
                </div>                          
            </div>
        </c:when>
        <c:when test="${selectedCenter eq 'galerieDetail.jsp'}">
            <div id="wrapperPrihlasky">      
                <div id="wrapperPrihlaskyTop">
                    <img src="img/wrapperPrihlaskyTop.png" alt="wrapperTop">
                </div>
                <div id="wrapperPrihlaskyCenter">
                    <jsp:include page="${selectedCenter}"/> 
                </div>
                <div id="wrapperPrihlaskyBottom">
                    <img src="img/wrapperPrihlaskyBottom.png" class="kontaktDwnarr" alt="wrapperBottom">
                </div>                          
            </div>
        </c:when>
        <c:otherwise>
            <div id="wrapper">
                <div id="wrapperTop">
                    <img src="img/wrapperTop.png" alt="wrapperTop">
                </div>
                <div id="wrapperCenter">
                    <c:choose>       
                        <c:when test="${selectedCenter == null}">
                            <jsp:include page="WEB-INF/dvpp/zakladniInfo.jsp"/>
                        </c:when>
                        <c:otherwise>
                            <jsp:include page="${selectedCenter}"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div id="wrapperBottom">
                    <img src="img/wrapperBottom.png" class="kontaktDwnarr" alt="wrapperBottom">
                </div>
            </div>
        </c:otherwise>       
    </c:choose>   

    <c:if test= "${selectedCenter ne 'WEB-INF/dvpp/vzdProgramy.jsp'}">
        <c:if test= "${selectedCenter ne 'galerieDetail.jsp'}">
            <div id="panelRightColumn">
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
            </div>
        </c:if>
    </c:if>
</div>
