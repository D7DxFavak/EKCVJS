<%--
    Document   : index
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/index' scope='session' />
<%--<jsp:useBean id="langBean" scope="request"
    class="controller.Resource"/>--%>
<%--<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>--%>

<%--<div id="indexLeftColumn">
    <div id="welcomeText">
        <p style="font-size: larger"><fmt:message key='greeting'/></p>
        <p><fmt:message key='introText'/></p>       
    </div>
</div>--%>

<%--<div id="indexTopColumn">
    <div id="indexTopColumnL1">
        <img src="img/mainM_left.png" alt="altL">
    </div>
    <div id="indexTopColumnC1">
        <ul>
            <li class="topListItemAktivni">
                <a href="index.jsp">
                    <span class="categoryLabelTextAktivni">${zobrazeniTabulek.webProp.nazev("home")}</span>                   
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
            <li class="topListItemNektivni">
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
                                <c:when test="${odkazDetail.webPanelyOdkaz eq 'forum.jsp'}">
                                    <li target="_blank" onclick="location.href = 'http://kcvjs.cz/forum';"> 
                                        <a href="http://kcvjs.cz/forum">
                                            <span class="catDetailLabel"></span>
                                            <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                        </a>
                                    </li>
                                </c:when>
                                <c:when test="${odkazDetail.webPanelyOdkaz eq 'pridruzeneOsoby.jsp'}">
                                    <c:if test="${typKlient == 2}">
                                        <li onclick="location.href = 'pridruzeneOsoby.jsp';"> 
                                            <a href="pridruzeneOsoby.jsp">
                                                <span class="catDetailLabel"></span>
                                                <span class="catDetailLabelText">${zobrazeniTabulek.webProp.nazev(odkazDetail.webPanelyNazev)}</span>                                
                                            </a>
                                        </li>
                                    </c:if>                              
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

<div id="container10">

    <%--<div id="panelLeftColumn">
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
                <c:forEach var="panely" items="${panelyHomeData}">    
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
                            <li onclick="location.href = 'index?${panely.webPanelyOdkaz}';">  
                                <a href="index?${panely.webPanelyOdkaz}" class="panelButton">
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
    </div>--%>

    <c:choose>       
        <c:when test="${selectedCenter eq 'galerieDetail.jsp'}">
            <div id="wrapperPrihlasky">      
                <div id="wrapperPrihlaskyTop">

                </div>
                <div id="wrapperPrihlaskyCenter">
                    <jsp:include page="${selectedCenter}"/> 
                </div>
                <div id="wrapperPrihlaskyBottom">
                    <
                </div>                          
            </div>
        </c:when>
        <c:when test="${selectedCenter eq 'galerieDetail.jsp'}">
            <div id="wrapperPrihlasky">      
                <div id="wrapperPrihlaskyTop">

                </div>
                <div id="wrapperPrihlaskyCenter">
                    <jsp:include page="${selectedCenter}"/> 
                </div>
                <div id="wrapperPrihlaskyBottom">
                    <
                </div>                          
            </div>
        </c:when>
        <c:when test="${selectedCenter eq 'registrace.jsp'}">
            <div id="panelLeftColumn">
                <div id="leftColumnUl4">
                    <li class="leftColumnHeader">                    
                        ${zobrazeniTabulek.webProp.nazev("menu_kontakt_nadpis")}                      
                    </li> 
                    <div id="kontaktCenter">
                        <p class="kontaktTelefonText">${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),0,4)}
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),5,8)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),9,12)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),13,16)}</span></p>
                        <p class="kontaktEmailText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_email")}</p>
                        <p class="kontaktHodinyText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_hodiny")}</p>
                    </div>                  
                </div>
                <div id="leftColumnUl5">
                    <li class="leftColumnHeader">                    
                        ${zobrazeniTabulek.webProp.nazev("menu_kontakt_it_nadpis")}                      
                    </li> 
                    <div id="kontaktJSCenter">
                        <p class="kontaktTelefonText">${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),0,4)}
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),5,8)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),9,12)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),13,16)}</span></p>
                        <p class="kontaktEmailText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_it_email")}</p>
                        <p class="kontaktHodinyText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_hodiny")}</p>
                    </div>               
                </div>
            </div>
            <div id="wrapperPrihlasky">      
                <div id="wrapperPrihlaskyTop">

                </div>
                <div id="wrapperPrihlaskyCenter">
                    <jsp:include page="${selectedCenter}"/> 
                </div>
                <div id="wrapperPrihlaskyBottom">

                </div>                          
            </div>
        </c:when>
        <c:otherwise>
            <div id="panelLeftColumn">
                <div id="leftColumnUl4">
                    <li class="leftColumnHeader">                    
                        ${zobrazeniTabulek.webProp.nazev("menu_kontakt_nadpis")}                      
                    </li> 
                    <div id="kontaktCenter">
                        <p class="kontaktTelefonText">${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),0,4)}
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),5,8)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),9,12)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_telefon"),13,16)}</span></p>
                        <p class="kontaktEmailText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_email")}</p>
                        <p class="kontaktHodinyText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_hodiny")}</p>
                    </div>                  
                </div>
                <div id="leftColumnUl5">
                    <li class="leftColumnHeader">                    
                        ${zobrazeniTabulek.webProp.nazev("menu_kontakt_it_nadpis")}                      
                    </li> 
                    <div id="kontaktJSCenter">
                        <p class="kontaktTelefonText">${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),0,4)}
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),5,8)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),9,12)}</span>
                            <span>${fn:substring(zobrazeniTabulek.webProp.nazev("menu_kontakt_it_telefon"),13,16)}</span></p>
                        <p class="kontaktEmailText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_it_email")}</p>
                        <p class="kontaktHodinyText">${zobrazeniTabulek.webProp.nazev("menu_kontakt_hodiny")}</p>
                    </div>               
                </div>
            </div>
            <div id="wrapper">
                <div id="wrapperTop">

                </div>
                <div id="wrapperCenter">
                    <c:choose>
                        <c:when test="${selectedCenter == null}">
                            <jsp:include page="WEB-INF/index/zakladniInfo.jsp"/>
                        </c:when>
                        <c:otherwise>
                            <jsp:include page="${selectedCenter}"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div id="wrapperBottom">

                </div>
            </div>
        </c:otherwise>       
    </c:choose>                          

</div>