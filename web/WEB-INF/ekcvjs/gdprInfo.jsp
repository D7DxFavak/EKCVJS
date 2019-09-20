<%-- 
    Document   : zakladniInfoOs
    Created on : 27.10.2011, 11:51:32
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    </head>
    <body>
        <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("tab_gdpr")}</p>
        </div>
        <ul>                           
            <c:choose>
                <c:when test="${typKlient == 1}">
                    <li class="statickeInfoList"> 
                        <p class="statickeInfoNazev">Informovaný souhlas o poskytnutí osobních údajů</p>
                        <div class="statickeInfoDiv">
                            V souladu z nařízením Evropského parlamentu a Rady (EU) 2016/679 o ochraně fyzických osob Vás žádáme o 
                            udělení souhlasu se zpracováním Vašich osobních údajů za účelem kontaktování a zpracování objednávky. 
                            V případě neuskutečnění objednávky budou Vaše data smazána. 
                        </div>                         
                    </li>    
                    <li class="statickeInfoList"> 
                        <p class="statickeInfoNazev">Co to pro přesně znamená?</p>                        
                        <div class="statickeInfoDiv">
                            Pro rychlejší komunikaci s našimi klienty využíváme nejraději e-mail nebo telefon. Obě tyto informace jsou Vašimi osobními údaji,
                            které máte právo poskytovat pouze Vy. Rádi bychom s Vámi nadále komunikovali takto elektronicky a proto Vás žádáme o udělění souhlasu se
                            zpracováním vašeho e-mailu, popř. telefonu. Udělením souhlasu nám umožníte pokračovat v jednoduché, rychlé a moderní komunikaci. Vaše osobní údaje 
                            v žádném případě nepředáváme dalším osobám nebo institucím. Zůstanou řádně zabezpečené v naší databázi a pouze pro účely naší instituce                            
                        </div> 
                    </li>

                    <c:choose>
                        <c:when test="${klientPrihlaseni.gdprUdeleno eq false}">
                            <form action="souhlasGDPR" method="post" id="souhlasGdprForm1">  
                                <div id="souhlasUdajeDiv"> 
                                    <label class="souhlasContainer">
                                        <input id="souhlasCheck" type="checkbox" name="souhlasCheck" />                  
                                        <span class="souhlasCheckmark"></span>
                                        <span class="souhlasCheckmarkInfo1">Souhlasím se zpracováním údajů za účelem objednávání, fakturace a zasílání informací o kurzech</span>
                                    </label>  
                                </div>
                                <input type="submit" value="POTVRDIT" id="submitGDPR"/> 
                            </form>
                        </c:when>
                        <c:otherwise>
                            <div class="statickeInfoDiv">Informovaný souhlas se zpracováním osobních údajů nám již byl udělen. Pokud tento souhlas chcete odvolat a chcete, aby Vaše osobní údaje byly smazány, 
                                zašlete prosím e-mail na adresu <a href="mailto: sekretariat@kcvjs.cz"> sekretariat@kcvjs.cz</a> .
                            </div>                                                                
                        </c:otherwise>

                    </c:choose>



                </c:when>
                <c:otherwise>
                    <li class="statickeInfoList"> 
                        <p class="statickeInfoNazev">Informovaný souhlas o poskytnutí osobních údajů vašich zaměstnanců</p>
                        <div class="statickeInfoDiv">
                            V souladu z nařízením Evropského parlamentu a Rady (EU) 2016/679 o ochraně fyzických osob Vás žádáme o spolupráci při
                            udělení souhlasu se zpracováním osobních údajů vašich zaměstnanců za účelem kontaktování a zpracování objednávky. 
                            Tyto souhlasy mohou vaši zaměstnanci kdykoliv odvolat.
                        </div> 
                    </li> 
                    <li class="statickeInfoList"> 
                        <p class="statickeInfoNazev">Co to pro přesně znamená?</p>                        
                        <div class="statickeInfoDiv">
                            Pro rychlejší komunikaci s našimi klienty využíváme nejraději e-mail nebo telefon. Obě tyto informace jsou osobními údaji vašich zaměstnanců,
                            které mají poskytovat pouze oni sami. Rádi bychom s našimi klienty nadále komunikovali takto elektronicky a proto Vás žádáme o spolupráci při udělění souhlasu se
                            zpracováním osobních údajů. Udělením souhlasu nám naši klienti umožní pokračovat v jednoduché, rychlé a moderní komunikaci. Tyto osobní údaje 
                            se v žádném případě nepředávájí dalším osobám nebo institucím. Zůstanou řádně zabezpečené v naší databázi a pouze pro účely naší instituce.                            
                        </div> 
                    </li>
                    <li class="statickeInfoList"> 
                        <p class="statickeInfoNazev">Jak souhlasit se zpracováním osobních údajů?</p>                        
                        <div class="statickeInfoDiv">
                            Všichni vaši zaměstnanci mají k dispozici svoje přihlašovací údaje do našeho elektronického systému. Je proto nutné, aby se přihlásili (stejným způsobem jako se přihlašujete jako 
                            organizace/firma) a v záložce "Souhlas GDPR" souhlasili se zpracováním jejich osobních údajů. V opačné případě budou jejich osobní data z naší databáze odstraněna. 
                        </div> 
                    </li>
                    <li class="statickeInfoList"> 
                        <p class="statickeInfoNazev">Kdo ze zaměstnanců neudělil souhlas se zpracováním osobních údajů?</p>                        
                        <div class="statickeInfoDiv">
                            V tabulce <a href='ekcvjs?pridruzeneOsoby.jsp'>Přidružené osoby</a> je seznam Vašich zaměstnanců. V tabulce najdete, zda daný zaměstnanec udělil nebo neudělil souhlas se zpracováním jeho osobních údajů. 
                        </div>  
                    </li>    
                </c:otherwise>
            </c:choose>                       
        </ul>       
    </body>
</html>
