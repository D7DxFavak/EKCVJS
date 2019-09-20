<%-- 
    Document   : aktualita
    Created on : 5.12.2011, 11:06:52
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${vyberAktualita.webAktualityNazev}</title>
    </head>
    <body>   
        <div id="wrapperContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                         <a href="${vyberAktualita.webKategorieZakladni.webKategorieZakladniOdkaz}?aktuality.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("aktuality")}</span>                                
                        </a></li>
                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                       <a href="${vyberAktualita.webKategorieZakladni.webKategorieZakladniOdkaz}.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(vyberAktualita.webKategorieZakladni.webKategorieZakladniOdkaz)}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
        
            <div id="aktualitySeznamNadpis">
                <p class="aktualitySeznamDatum"> 
                    <fmt:formatDate value="${vyberAktualita.webAktualityDatumVlozeni}" pattern="d.M.yyyy"/>               
                </p>   

                <span class="aktualitySeznamText2">${vyberAktualita.webAktualityNazev}</span>
            </div>

            <div id="aktualitaText">
                ${vyberAktualita.webAktualityPopis}
            </div>   

            <div id="aktualitaAutor">
                <span class="aktualitySeznamAutor">${zobrazeniTabulek.webProp.nazev("autor_textu")}: </span>
                <span class="aktualitySeznamAutorJmeno">${vyberAktualita.webAktualityVlozil.titulPred} ${vyberAktualita.webAktualityVlozil.jmeno} ${vyberAktualita.webAktualityVlozil.prijmeni} ${vyberAktualita.webAktualityVlozil.titulZa}</span>
            </div>

        </div>
    </body>
</html>
