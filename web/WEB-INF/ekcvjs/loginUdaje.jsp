<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/loginUdaje' scope='session' />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>
        <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("prihlasovaci_udaje")}</p>
        </div>
        <div id="wrapperContainer">
            <%--  <div id="navigaceTop">
                  <ul class="navigaceList">
                      <li> 
                          <a href="ekcvjs?klientskeUdaje.jsp">
                              <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("osobni_udaje")}</span>                                
                          </a></li>
                      <li>
                          <div class="slash">></div>
                      </li>    
                      <li> 
                          <a href="ekcvjs.jsp">
                              <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                                
                          </a>
                      </li>               
                  </ul>
              </div>--%>
            <div id="panelUdajeLogin">

                <h2>${zobrazeniTabulek.webProp.nazev("sprava_prihlasovacich_udaju")}</h2>         

                <form action="zmenaHesla" method="post" id="klientInfoForm">          
                    <c:if test="${zmenaHeslaInfo eq 'uspesnaZmena'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("uspesna_zmena_hesla")}</p>
                    </c:if> 
                    <label for="uzivJmeno">${zobrazeniTabulek.webProp.nazev("uzivatelske_jmeno")}:</label>
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="uzivJmeno"
                           name="uzivJmeno"
                           value="${uzivatelePrihlaseni.uzivateleJmeno}">
                    <br>
                    <c:if test="${zmenaHeslaInfo eq 'chybneHeslo'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_stavajici_heslo")}</p>
                    </c:if> 
                    <label for="hesloPrvni">${zobrazeniTabulek.webProp.nazev("heslo_stavajici")}:</label>
                    <input type="password"
                           size="31"
                           maxlength="45"
                           id="hesloPrvni"
                           name="hesloPrvni"
                           value="">
                    <br>
                    <br>
                    <c:if test="${zmenaHeslaInfo eq 'ruznaHesla'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("ruzna_hesla")}</p>
                    </c:if> 
                    <c:if test="${zmenaHeslaInfo eq 'vyplnteObePole'}">
                        <p class="loginError" >${zobrazeniTabulek.webProp.nazev("vyplnte_obe_pole")}</p>
                    </c:if> 
                    <label for="hesloNove">${zobrazeniTabulek.webProp.nazev("heslo_nove")}:</label>
                    <input type="password"
                           size="31"
                           maxlength="45"
                           id="hesloNove"
                           name="hesloNove"
                           value="">
                    <br>

                    <label for="hesloZnovu">${zobrazeniTabulek.webProp.nazev("heslo_overit")}:</label>
                    <input type="password"
                           size="31"
                           maxlength="45"
                           id="hesloZnovu"
                           name="hesloZnovu"
                           value="">
                    <br>                
                    <input type="submit" value="Potvrdit" id="submitOsobaUdaje"/>                 
                </form>

            </div>
        </div>
    </body>
</html>
