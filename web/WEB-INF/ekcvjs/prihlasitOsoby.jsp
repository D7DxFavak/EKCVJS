<%-- 
    Document   : pridruzeneOsoby
    Created on : 28.12.2011, 10:30:54
    Author     : 7Data Gotzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prihlasit osoby</title>
    </head>
    <body>
        <div id="wrapperPrihlaskyContainer">
            <h2>${zobrazeniTabulek.webProp.nazev("vyber_seznamu_zamestnancu")}</h2>
            <form action="potvrditPrihlaseniOsoba" method="post" id="potvrditPrihlaseniOsoba">
                <table id="osobyOrgPrihlasitTable">

                    <tr class="header">
                        <th>${zobrazeniTabulek.webProp.nazev("tab_vybrat")}
                        </th>
                        <th>${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}
                        </th>
                        <th>${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}
                        </th>
                        <th>${zobrazeniTabulek.webProp.nazev("uzivatel_datum_narozeni")}
                        </th>
                        <th>${zobrazeniTabulek.webProp.nazev("uzivatel_rodne_cislo")}
                        </th>
                        <th>${zobrazeniTabulek.webProp.nazev("tab_detaily")}</th> 
                    </tr>

                    <c:forEach var="osoby" items="${pridruzeneOsoby}" varStatus="iter">

                        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                            <td width="90">
                                <input type="checkbox" name="idOsoba" value=${osoby.webOrgOsOsoba.osobaId} />
                            </td>
                            <td width="130">
                                ${osoby.webOrgOsOsoba.jmeno}               
                            </td>
                            <td width="140">
                                ${osoby.webOrgOsOsoba.prijmeni}                             
                            </td>
                            <td width="150">
                                <fmt:formatDate value="${osoby.webOrgOsOsoba.datumNarozeni}" pattern="d.M.yyyy"/>  
                            </td>
                            <td width="150">
                                ${osoby.webOrgOsOsoba.rodneCislo}  
                            <td width="130">
                                <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${osoby.webOrgOsOsoba.osobaId}">${zobrazeniTabulek.webProp.nazev("uzivatel_detail")} 
                            </td>

                        </tr>
                    </c:forEach>
                </table>
                <div id="inputVybrat">
                    <input type="submit" value="${zobrazeniTabulek.webProp.nazev("potvrdit_vyber")}" id="inputPrihlaseniOsoba"/> 
                </div>

            </form>
        </div>        
    </body>
</html>
