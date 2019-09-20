<%--
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html

 * author: tgiunipero
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var='view' value='/category' scope='session' />

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/affablebean2.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico">
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>    

        <title>KCVJŠ</title>
    </head>

    <body>
        <div id="btop">          
            <div id="header">
                <div id="indexTopColumnC1">
                    <div id="widgetBar">
                        <div class="cartWidget" id ="headerCheckout">
                            <c:if test="${!empty cart && cart.numberOfItems != 0 &&
                                          !fn:contains(pageContext.request.servletPath,'/checkout') &&
                                          requestScope['javax.servlet.forward.servlet_path'] ne '/checkout' &&

                                          !fn:contains(pageContext.request.servletPath,'/cart') &&
                                          requestScope['javax.servlet.forward.servlet_path'] ne '/cart'}">

                                  <a href="viewCart" class="bubble">
                                      <img src="img/cart.png" id="kosik" alt="kosik">
                                      ${zobrazeniTabulek.webProp.nazev("header_zobrazit_kosik")}
                                  </a>
                            </c:if>
                        </div>

                        <%-- login widget --%>
                        <div class="headerWidget" id="headerLogin">
                            <%
                                if (request.getRemoteUser() == null) {%>
                            <a href="ekcvjs?prihlaseniUzivatele.jsp">${zobrazeniTabulek.webProp.nazev("header_prihlasit")}</a>
                            <div class="slash">|</div>
                            <a href="index?registrace.jsp"> ${zobrazeniTabulek.webProp.nazev("header_registrace")}</a>
                            <div class="slash">|</div>
                            <%--               out.print("<a href=\"admin/login.jsp\">");
                                   ${zobrazeniTabulek.webProp.nazev("header_prihlasit")}                         
                                   <%out.println("</a>");%>
                                   <div class="slash">|</div>
                                       <%out.println("<a href=\"registrace.jsp\">");%>
                                   ${zobrazeniTabulek.webProp.nazev("header_registrace")}
                                   <%out.println("</a>");%>
                                   <div class="slash">|</div>--%>
                            <%} else {%>
                            <span> ${zobrazeniTabulek.webProp.nazev("header_prihlasen")}<%out.println(" : " + request.getRemoteUser());%></span>                        
                            <div class="slash">|</div>
                            <a href="admin/logout"> ${zobrazeniTabulek.webProp.nazev("header_odhlasit")}</a>
                            <div class="slash">|</div>

                            <%--    out.println("<p>");%>
                            ${zobrazeniTabulek.webProp.nazev("header_prihlasen")}
                            <%out.println(" : " + request.getRemoteUser());%>
                            <div class="slash">|</div>
                              <%  out.println("  <a href=\"admin/logout\">");%> 
                            ${zobrazeniTabulek.webProp.nazev("header_odhlasit")}
                            <%out.println("</a><div class=\"slash\">|</div></p>");--%>
                            <%  }%>

                        </div>
                    </div>               
                </div>                
            </div>
        </div>
        <div id ="main">
            <div id="container70">
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
                    <div id="wrapperCenter">
                        <div id="wrapperContainer">                           
                            <div id="mainLogin">       

                                <p style="color: darkred">${zobrazeniTabulek.webProp.nazev("vyplnte_udaje_error")}</p>

                                <form action="<c:url value='j_security_check'/>" method=post id ="loginForm">
                                    <div id="loginBox">
                                        <label for="loginLabel">${zobrazeniTabulek.webProp.nazev("uzivatelske_jmeno")}</label>

                                        <input type="text" size="20" name="j_username" id="loginInput">
                                        <label for="passLabel">${zobrazeniTabulek.webProp.nazev("heslo")}</label>

                                        <input type="password" size="20" name="j_password" id="passInput">

                                        <input type="submit" value="${zobrazeniTabulek.webProp.nazev("potvrdit")}" id="submitLogin">
                                    </div>
                                </form>

                                <p>${zobrazeniTabulek.webProp.nazev("nejste_registrovani")}</p>               
                                <p class="loginReg">${zobrazeniTabulek.webProp.nazev("registrace_zde")}</p>
                                <a href="index?registrace.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a>

                                <div id ="zapomenuteHeslo">
                                    <p>${zobrazeniTabulek.webProp.nazev("zapomenute_heslo")}</p>                                  
                                    <p class="passRecoveryText">${zobrazeniTabulek.webProp.nazev("heslo_zaslat_email")}</p>                                
                                    <form action="poslatHeslo" method="post">
                                        <label for="uzivEmail">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}</label>
                                        <input type="text"
                                               size="31"
                                               maxlength="45"
                                               id="uzivEmail"
                                               name="uzivEmail"
                                               value="${uzivatelePrihlaseni.uzivateleOsobyId.eMail}">
                                        <br>
                                        <input type="submit"
                                               name="submit"
                                               class="hesloButton"
                                               value="${zobrazeniTabulek.webProp.nazev("heslo_zaslat")}">
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>                   
                </div>               
            </div>  
        </div>
    </body>
</html>