<%--
    Document   : index
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>




<div id="container70">    
    <c:choose>
        <c:when test="${selectedCenter == null && pageContext.request.remoteUser != null}">
            <div id="panelLeftColumn">       
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
                                        <a href="ekcvjs?pridruzeneOsoby.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("pridruzene_osoby")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?navrhovaneOsoby.jsp';">  
                                        <a href="ekcvjs?navrhovaneOsoby.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("navrhovane_osoby")}
                                            </span>
                                        </a>
                                    </li>
                                    <li class="leftColumnText" onclick="location.href = 'ekcvjs?novaOsoba.jsp';">  
                                        <a href="ekcvjs?novaOsoba.jsp" class="panelButton">                                                
                                            <span class="panelText">
                                                ${zobrazeniTabulek.webProp.nazev("registrovat_nova_osoba")}
                                            </span>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>                            
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
                    <jsp:include page="WEB-INF/ekcvjs/prihlaseniUzivatele.jsp"/>
                </div>                   
            </div>               
        </c:when>
        <c:otherwise>
            <div id="panelLeftColumn">                    
                <div id="leftColumnUl6">    
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
                    <c:choose>
                        <c:when test="${selectedCenter == null && request.getRemoteUser() == null}">
                            
                            <div id="wrapperContainer">                           
                                <div id="mainLogin">       

                                    <p>${zobrazeniTabulek.webProp.nazev("vyplnte_udaje")}</p>

                                    <form action="<c:url value='j_security_check'/>" method=post id ="loginForm"> <%--prihlasitIndex--%>
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
                        </c:when>

                        <c:otherwise>
                            <jsp:include page="${selectedCenter}"/>
                        </c:otherwise>
                    </c:choose>

                </div>                   
            </div>      
        </c:otherwise>
    </c:choose>

</div>  
