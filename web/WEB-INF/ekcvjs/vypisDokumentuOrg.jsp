<%-- 
    Document   : vypisDokumentu
    Created on : 26.10.2011, 16:15:20
    Author     : 7Data Gotzy
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div id="wrapper">
            <div id="wrapperCenter2">
                <%--<div id="navigaceTop">
                    <ul class="navigaceList">
                        <li> 
                            <a href="ekcvjs?vypisDokumentu.jsp">
                                <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("dokumenty")}</span>                                
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

                <%-- <div id="vypisDokumentuOdkazy">          
                     <a href="ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=1">${zobrazeniTabulek.webProp.nazev("vystavene_faktury")}</a>
                     <a href="ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=2">${zobrazeniTabulek.webProp.nazev("vystavene_certifikaty")}</a>
                     <a href="ekcvjs?vypisDokumentu.jsp&zobrazitTabulku=3">${zobrazeniTabulek.webProp.nazev("vystavene_dokumenty")}</a>
                 </div>    --%>

                <c:choose>
                    <c:when test="${zobrazeniTabulek.zobrazitTabulku == 1}">
                        <div class="wrapperPrihlaskyNadpis">
                            <p>...${zobrazeniTabulek.webProp.nazev("vystavene_faktury")}</p>
                        </div>
                        <div id="tabulkaDokumentyFaktury">
                            <div id="tableHeaderFaktury">
                                <div id ="headerCisloFaktury">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=0">      
                                        <p>${zobrazeniTabulek.webProp.nazev("cislo_faktury")}</p>                                   
                                    </a>
                                </div>
                                <div id="headerDatumVystaveni">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=1">      
                                        <p>${zobrazeniTabulek.webProp.nazev("datum_vystaveni")}</p>                                       
                                    </a>                                
                                </div>
                                <div id="headerDatumSplatnosti">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=2">      
                                        <p>${zobrazeniTabulek.webProp.nazev("datum_splatnosti")}</p>                                       
                                    </a>                                  
                                </div>
                                <div id="headerfakturovanaCastka">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=3">      
                                        <p>${zobrazeniTabulek.webProp.nazev("fakturovana_castka")}</p>                                       
                                    </a>                                  
                                </div>
                                <div id="headeruhrazenaCastka">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=4">      
                                        <p>${zobrazeniTabulek.webProp.nazev("uhrazena_castka")}</p>                                       
                                    </a>                                 
                                </div>
                                <div id="headerFakturaDokument">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=5">      
                                        <p>${zobrazeniTabulek.webProp.nazev("faktura_stahnout")}</p>                                   
                                    </a>                                  
                                </div>   
                            </div> 
                            <table id="prihlaseniTable">               
                                <c:forEach var="faktura" items="${seznamFaktur}" varStatus="iter">                
                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">                                         
                                        <td width="83">
                                            ${faktura.cisloFaktury}                                               
                                        </td>
                                        <td width="154">
                                            <fmt:formatDate value="${faktura.datumVystaveni}" pattern="d.M.yyyy"/>                                 
                                        </td>
                                        <td width="151">
                                            <fmt:formatDate value="${faktura.datumSplatnosti}" pattern="d.M.yyyy"/>                                 
                                        </td>
                                        <td width="126">
                                            <fmt:formatNumber value="${faktura.fakturovano}" pattern="######"/> Kč                                
                                        </td>
                                        <td width="110">
                                            <fmt:formatNumber value="${faktura.uhrazeno}" pattern="######"/> Kč                                 
                                        </td>
                                        <td width="100">
                                            <c:if test="${faktura.existujePDF == true}">
                                                <a class="tabDokumentyShop" href="pdf?faktura=${faktura.cisloFaktury}">                                       
                                                    <img src="img/pdf.png" id="logoPDF" alt="pdf logo">   
                                                </a>   
                                            </c:if>                                                        
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>    
                        </div>  
                    </c:when>
                    <c:when test="${zobrazeniTabulek.zobrazitTabulku == 2}">
                         <div class="wrapperPrihlaskyNadpis">
                            <p>...${zobrazeniTabulek.webProp.nazev("vystavene_certifikaty")}</p>
                        </div>
                        <div id="tabulkaDokumentyCertifikaty">
                            <div id="tableHeaderCertifikaty">
                                <div id ="headerCertifikatCisloAkce">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=0">      
                                        <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>

                                    </a>                                
                                </div>
                                <div id="headerCertifikatJmenoPrijmeni">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=1">      
                                        <p>${zobrazeniTabulek.webProp.nazev("tab_jmeno_prijmeni")}</p>

                                    </a>                                     
                                </div>
                                <div id="headerCertifikatDatumVystaveni">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=2">      
                                        <p>${zobrazeniTabulek.webProp.nazev("datum_vystaveni")}</p>

                                    </a>                                   
                                </div>
                                <div id="headerCertifikatDokument">
                                    <a href="ekcvjs?vypisDokumentu.jsp&sort=2">      
                                        <p>${zobrazeniTabulek.webProp.nazev("certifikat_stahnout")}</p>                                  
                                    </a>                                
                                </div>   
                            </div> 
                            <table id="prihlaseniTable">               
                                <c:forEach var="certifikat" items="${seznamCertifikatu}" varStatus="iter">                
                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">                                         
                                        <td width="140">
                                            ${fn:substring(certifikat.prihlaskyRozpisy.akce.akceCislo,0,2)} - ${fn:substring(certifikat.prihlaskyRozpisy.akce.akceCislo,2,6)} - ${fn:substring(certifikat.prihlaskyRozpisy.akce.akceCislo,6,8)}                                                                             
                                        </td>
                                        <td width="220">
                                            ${certifikat.prihlaskyRozpisy.osoba.jmeno} ${certifikat.prihlaskyRozpisy.osoba.prijmeni}                                   
                                        </td>
                                        <td width="150">
                                            <fmt:formatDate value="${certifikat.ulozisteData.ulozisteDataVlozeno}" pattern="d.M.yyyy"/>                                 
                                        </td>
                                        <td width="242">                               
                                            <a class="tabDokumentyShop" href="pdf?polozka=${certifikat.prihlaskyRozpisy.polozka}">                                       
                                                <img src="img/pdf.png" id="logoPDF" alt="pdf logo">   
                                            </a>                                                                                      
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>    
                        </div>  
                    </c:when>
                    <c:otherwise>                   
                        <div id="tabulkaDokumentyOstatni">
                            <div class="wrapperPrihlaskyNadpis">
                            <p>...${zobrazeniTabulek.webProp.nazev("vystavene_dokumenty")}</p>
                        </div>
                            <div id="tableHeaderOstatni">
                                <div id ="headerOstatniDatumVystaveni">
                                    <p>${zobrazeniTabulek.webProp.nazev("datum_vystaveni")}</p>
                                </div>
                                <div id="headerOstatniNazevDokumentu">
                                    <p>${zobrazeniTabulek.webProp.nazev("nazev_dokumentu")}</p>
                                </div>                       
                                <div id="headerOstatniDokument">
                                    <p>${zobrazeniTabulek.webProp.nazev("dokument_stahnout")}</p>
                                </div>   
                            </div> 
                            <table id="prihlaseniTable">               
                                <c:forEach var="dokument" items="${seznamDokumentu}" varStatus="iter">                
                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">                                         
                                        <td width="150">
                                            <fmt:formatDate value="${dokument.ulozisteData.ulozisteDataVlozeno}" pattern="d.M.yyyy"/>                                               
                                        </td>
                                        <td width="400">
                                            ${dokument.ulozisteData.ulozisteDataNazev}                                   
                                        </td>                                
                                        <td width="216">                               
                                            <a class="tabDokumentyShop" href="pdf?ostatniDokumentyOrg=${dokument.ulozisteData.ulozisteDataId}">                                       
                                                <img src="img/pdf.png" id="logoPDF" alt="pdf logo">   
                                            </a>                                                                                      
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>    
                        </div>  
                    </c:otherwise>
                </c:choose>

                <div id ="navigace">
                    <div id="zobrZaznam">
                        <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                        <a class="navClass" href="ekcvjs?vypisDokumentuOrg.jsp&pocetStrana=10">10</a>
                        <a class="navClass" href="ekcvjs?vypisDokumentuOrg.jsp&pocetStrana=20">20</a>
                        <a class="navClass" href="ekcvjs?vypisDokumentuOrg.jsp&pocetStrana=50">50</a>             
                    </div>
                    <div id="strana">
                        <c:forEach var="strana" items="${strany}" varStatus="iter">
                            <c:choose>
                                <c:when test="${strana.cislo == -1}">
                                    <a class="navClass" href="ekcvjs?vypisDokumentuOrg.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                </c:when>
                                <c:when test="${strana.cislo == -2}">
                                    <span>...</span>
                                    <a class="navClass" href="ekcvjs?vypisDokumentuOrg.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="navClass" href="ekcvjs?vypisDokumentuOrg.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                </c:otherwise>
                            </c:choose>                      
                        </c:forEach>                                 
                    </div>  
                </div>
            </div>
        </div>
    </body>
</html>
