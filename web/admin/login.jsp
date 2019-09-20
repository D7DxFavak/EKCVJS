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

<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>

<script type="text/javascript">
    function fillForm() {
        //var encryptedAES = CryptoJS.AES.encrypt("pokus", "pokus");
        var lid;
        var decryptedBytes;
        var plaintext;
        var hashParams = window.location.hash.substr(1).split('&'); // substr(1) to remove the `#`
        for (var i = 0; i < hashParams.length; i++) {
            var p = hashParams[i].split('=');
            if (i == 0) {
                document.getElementById('loginInput').value = decodeURIComponent(p[1]);
                lid = decodeURIComponent(p[1]);
            }
            if (i == 1) {
                // decryptedBytes = CryptoJS.AES.decrypt(decodeURIComponent(p[1]), lid);
                // plaintext = decryptedBytes.toString(CryptoJS.enc.Utf8);
                plainttext = decodeURIComponent(p[1]);
                document.getElementById('passInput').value = plaintext;
            }
            if (i == 2) {
                document.getElementById('tempKosikUrl').value = /*plaintext + ';' +*/ window.location.hash.toString();

                //var test = decodeURIComponent(p[1]);               

            }

        }
        //  document.getElementById('loginInput').value = hashParams.length;
        if (hashParams.length > 1) {
            document.getElementById('container70').style.visibility = "hidden";
            document.getElementById('kosikTempForm').submit();
        } else {
            document.getElementById('loginInput').value = '';
            document.getElementById('cartLogin').style.visibility = "hidden";
        }
        /*if (plaintext != null) {
         document.getElementById('container70').style.visibility = "hidden";
         document.getElementById('kosikTempForm').submit();
         } else {
         document.getElementById('loginInput').value = '';
         document.getElementById('cartLogin').style.visibility = "hidden";
         }*/
        //document.getElementById('loginInput').value = encryptedAES.toString();
    }
</script>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/affablebean2.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico">
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>       

        <title>KCVJŠ</title>
    </head>

    <body onload="fillForm()">
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
                        <div id="logoSovaDiv">
                            <img src="img/logo_b.svg" id="logoSovaImg" alt="r">       
                            <div id="nazevPopis">
                                <p>KRAJSKÉ CENTRUM VZDĚLÁVÁNÍ</p>
                                <p>A JAZYKOVÁ ŠKOLA, PLZEŇ</p>
                            </div>
                        </div>
                        <%-- login widget --%>
                        <div class="headerWidget" id="headerLogin">
                            <%
                                if (request.getRemoteUser() == null) {%>
                            <a href="ekcvjs?prihlaseniUzivatele.jsp">${zobrazeniTabulek.webProp.nazev("header_prihlasit")}</a>
                            <div class="slash">|</div>
                            <a href="index?preRegistrace.jsp"> ${zobrazeniTabulek.webProp.nazev("header_registrace")}</a>
                            <div class="slash">|</div>                           
                            <%} else {%>
                            <span> ${zobrazeniTabulek.webProp.nazev("header_prihlasen")}<%out.println(" : " + request.getRemoteUser());%></span>                        
                            <div class="slash">|</div>
                            <a href="admin/logout"> ${zobrazeniTabulek.webProp.nazev("header_odhlasit")}</a>
                            <div class="slash">|</div>                         
                            <%  }%>

                        </div>
                    </div>                   
                </div>               
            </div>
        </div>
        <div id="bbottom">
            <span></span>
        </div>
        <div id="main">
            <%--<div id="subMain">--%>

            <div id="container70">                

                <div id="wrapperLogin">                  



                    <div id="cartLogin">
                        <form action="tempKosik" method="post" id="kosikTempForm">
                            <input type="hidden" id="tempKosikUrl" name="tempKosikUrl"> 
                            <input type="submit" value="uloz kosik">                            
                        </form>
                    </div>

                    <div id="mainLogin">       

                        <p>${zobrazeniTabulek.webProp.nazev("vyplnte_udaje")}</p>

                        <form action="<c:url value='j_security_check'/>" method=post id ="loginForm">
                            <div id="loginBox">
                                <label for="loginLabel">${zobrazeniTabulek.webProp.nazev("uzivatelske_jmeno")}</label>

                                <input type="text" size="20" name="j_username" id="loginInput" >
                                <label for="passLabel">${zobrazeniTabulek.webProp.nazev("heslo")}</label>

                                <input type="password" size="20" name="j_password" id="passInput">                         
                                
                                <input type="submit" value="${zobrazeniTabulek.webProp.nazev("potvrdit")}" id="submitLogin">
                            </div>
                        </form>                       
                        <p>${zobrazeniTabulek.webProp.nazev("nejste_registrovani")}</p>               
                        <p class="loginReg">${zobrazeniTabulek.webProp.nazev("registrace_zde")}</p>
                        <a href="index?preRegistrace.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a>

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
    </body>
</html>