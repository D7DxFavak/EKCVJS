<%-- 
    Document   : potvrzeniRegistrace
    Created on : 4.11.2011, 14:25:43
    Author     : 7Data Gotzy
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/potvrzeniRegistrace' scope='session' />

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Potvrzeni registrace</title>
    </head>
    <body>
        <div id="wrapperContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="index?potvrzeniRegistrace.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("potvrzeni_registrace")}</span>                                
                        </a></li> 

                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="index.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("home")}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
            <p class="statickeInfoNazev">${zobrazeniTabulek.webProp.nazev("registrace_uspesna")}</p>
            <p></p>
            <table border="0" cellspacing="8" cellpadding="1">            
                <tbody>
                    <tr>
                        <td width="180">${zobrazeniTabulek.webProp.nazev("uzivatelske_jmeno")}: </td>
                        <td width="400">${user.uzivateleJmeno}</td>
                    </tr>
                    <tr>
                        <td width="180">${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}: </td>
                        <td width="400">${klientPrihlaseni.jmeno}</td>
                    </tr>
                    <tr>
                        <td width="180">${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")} :</td>
                        <td width="400">${klientPrihlaseni.prijmeni}</td>
                    </tr>  
                    <tr>
                        <td colspan="2" width="580">
                            ${zobrazeniTabulek.webProp.nazev("uzivatelske_udaje_v_kcvjs")} 
                        </td>
                    </tr> 
                    <tr>
                        <td colspan="2" width="580">
                            <a href="${pageContext.request.contextPath}/index.jsp">${zobrazeniTabulek.webProp.nazev("pokracovat_na_kcvjs")}             </a>

                        </td>
                    </tr> 
                </tbody>
            </table>        
        </div>
    </body>
</html>
