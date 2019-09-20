<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/registrace' scope='session' />
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="$/css/affablebean2.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>         
    <li class="statickeInfoList"> 
        <p class="statickeInfoNazev">Registrace v elektronické KCVJŠ</p>
        <div class="statickeInfoDiv">
            Elektronická KCVJŠ slouží pro ...
        </div>                         
    </li> 
    <li class="statickeInfoList"> 
        <p class="statickeInfoNazev">Registrace jednotlivce - fyzické osoby</p>
        <div class="statickeInfoDiv">
            Pokud se registrujete jako jednotlivec, klikněte zde : <a href="index?registrace.jsp&idDruhUzivatel=1">${zobrazeniTabulek.webProp.nazev("druh_uzivatele_osoba")}</a>
        </div>                         
    </li> 
    <li class="statickeInfoList"> 
        <p class="statickeInfoNazev">Registrace organizací / firem</p>
        <div class="statickeInfoDiv">
            Pokud se registrujete jako organizace / firma spravující vzdělávací kurzy pro svoje zaměstnance, klikněte zde  : <a href="index?registrace.jsp&idDruhUzivatel=2">${zobrazeniTabulek.webProp.nazev("druh_uzivatele_organizace")}</a>
        </div>                         
    </li> 
    <%--<div id="wrapperRegistrace">            
        <div id="panelRegistrace">
            <h2 class="registraceNadpis">${zobrazeniTabulek.webProp.nazev("zalozeni_uctu_ekcvjs")}</h2>
            <div id="registraceVyber">
                <span>${zobrazeniTabulek.webProp.nazev("druh_uzivatel")} : </span>
                
                <span>${zobrazeniTabulek.webProp.nazev("nebo")}</span>
                <a href="index?registrace.jsp&idDruhUzivatel=2">
                    ${zobrazeniTabulek.webProp.nazev("druh_uzivatele_organizace")}
                </a>
            </div>               
        </div>
    </div>--%>
</body>
</html>
