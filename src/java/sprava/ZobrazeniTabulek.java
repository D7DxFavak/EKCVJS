/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sprava;

import controller.Resource;
import entity.WebProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Favak
 */
public class ZobrazeniTabulek {

    private int idObor;
    private int idObdobi;
    private int idAkce;
    private int idKategorieZakladni;
    private int idOborSkupina;
    private int idAktualita;
    private int idUloziste;
    private int idGalerie;
    private int pocetStrana;
    private int druhUzivatel;
    private int offset;
    private int zobrazitTabulku;
    private int sort;
    private int idOsOzHruba = 0;
    private int katOrgTyp;
    private int katOrgDruh;
    private String sortTyp;
    private String raditPodle;
    private String hledanaAkce;
    private String aktualniStranka;
    private String pomString;
    private List<TrojiceRetezRetezRetez> arTr;
    private Resource webProp;
    private String prislusnost;
    private String narodnost;
    private String potvrzeni;   
    
    public ZobrazeniTabulek(List<WebProperties> wp) {
        this.pocetStrana = 10;
        this.idAktualita = 0;
        this.offset = 0;
        this.idObdobi = 0;
        this.idOborSkupina = 0;
        this.idOsOzHruba = 0;
        this.idKategorieZakladni = 0;
        this.idObor = 0;
        this.idGalerie = 0;
        this.druhUzivatel = 0;
        this.katOrgTyp = 1;
        this.katOrgDruh = 1;
        this.sort = -1;
        this.sortTyp = " ASC";
        this.idUloziste = 0;
        this.idAkce = 0;
        this.zobrazitTabulku = 1;
        this.raditPodle = "";
        this.hledanaAkce = "";
        this.aktualniStranka = "index.jsp";
        this.narodnost=  "";
        this.prislusnost = "";
        this.potvrzeni  = "no";
        this.arTr = new ArrayList<TrojiceRetezRetezRetez>();
        this.webProp = new Resource("cs", wp);       
    }

    public void vycistit(String aktualniStranka) {
        this.pocetStrana = 10;
        this.offset = 0;
        this.idObdobi = 0;
        this.setIdOborSkupina(0);
        this.setIdObor(0);
        this.idAkce = 0;
        this.setIdGalerie(0);
        this.setIdOsOzHruba(0);
        this.setDruhUzivatel(0);
        this.sort = -1;
        this.setIdUloziste(0);
        this.setZobrazitTabulku(1);        
        this.setKatOrgTyp(1);
        this.setKatOrgDruh(1);
        this.hledanaAkce = "";
           this.setNarodnost("");
        this.setPrislusnost("");
         this.setPotvrzeni("no");
        this.sortTyp = " ASC";
        this.setRaditPodle("");
        this.aktualniStranka = aktualniStranka;
        this.arTr = new ArrayList<TrojiceRetezRetezRetez>();      
    }

    /**
     * @return the idObdobi
     */
    public int getIdObdobi() {
        return idObdobi;
    }

    /**
     * @param idObdobi the idObdobi to set
     */
    public void setIdObdobi(int idObdobi) {
        this.idObdobi = idObdobi;
    }

    /**
     * @return the idAkce
     */
    public int getIdAkce() {
        return idAkce;
    }

    /**
     * @param idAkce the idAkce to set
     */
    public void setIdAkce(int idAkce) {
        this.idAkce = idAkce;
    }

    /**
     * @return the pocetStrana
     */
    public int getPocetStrana() {
        return pocetStrana;
    }

    /**
     * @param pocetStrana the pocetStrana to set
     */
    public void setPocetStrana(int pocetStrana) {
        this.pocetStrana = pocetStrana;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return the hledanaAkce
     */
    public String getHledanaAkce() {
        return hledanaAkce;
    }

    /**
     * @param hledanaAkce the hledanaAkce to set
     */
    public void setHledanaAkce(String hledanaAkce) {
        this.hledanaAkce = hledanaAkce;
    }

    /**
     * @return the aktualniStranka
     */
    public String getAktualniStranka() {
        return aktualniStranka;
    }

    /**
     * @param aktualniStranka the aktualniStranka to set
     */
    public void setAktualniStranka(String aktualniStranka) {
        this.aktualniStranka = aktualniStranka;
    }

    /**
     * @return the idObor
     */
    public int getIdObor() {
        return idObor;
    }

    /**
     * @param idObor the idObor to set
     */
    public void setIdObor(int idObor) {
        this.idObor = idObor;
    }

    /**
     * @return the idAktualita
     */
    public int getIdAktualita() {
        return idAktualita;
    }

    /**
     * @param idAktualita the idAktualita to set
     */
    public void setIdAktualita(int idAktualita) {
        this.idAktualita = idAktualita;
    }

    /**
     * @return the idOborSkupina
     */
    public int getIdOborSkupina() {
        return idOborSkupina;
    }

    /**
     * @param idOborSkupina the idOborSkupina to set
     */
    public void setIdOborSkupina(int idOborSkupina) {
        this.idOborSkupina = idOborSkupina;
    }

    /**
     * @return the zobrazitTabulku
     */
    public int getZobrazitTabulku() {
        return zobrazitTabulku;
    }

    /**
     * @param zobrazitTabulku the zobrazitTabulku to set
     */
    public void setZobrazitTabulku(int zobrazitTabulku) {
        this.zobrazitTabulku = zobrazitTabulku;
    }

    /**
     * @return the idUloziste
     */
    public int getIdUloziste() {
        return idUloziste;
    }

    /**
     * @param idUloziste the idUloziste to set
     */
    public void setIdUloziste(int idUloziste) {
        this.idUloziste = idUloziste;
    }

    /**
     * @return the sort
     */
    public int getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(int sort) {
        this.sort = sort;
    }

    /**
     * @return the raditPodle
     */
    public String getRaditPodle() {
        return raditPodle;
    }

    /**
     * @param raditPodle the raditPodle to set
     */
    public void setRaditPodle(String raditPodle) {
        this.raditPodle = raditPodle;
    }

    /**
     * @return the sortTyp
     */
    public String getSortTyp() {
        return sortTyp;
    }

    /**
     * @param sortTyp the sortTyp to set
     */
    public void setSortTyp(String sortTyp) {
        this.sortTyp = sortTyp;
    }

    /**
     * @return the idOsOzHruba
     */
    public int getIdOsOzHruba() {
        return idOsOzHruba;
    }

    /**
     * @param idOsOzHruba the idOsOzHruba to set
     */
    public void setIdOsOzHruba(int idOsOzHruba) {
        this.idOsOzHruba = idOsOzHruba;
    }

    /**
     * @return the arTr
     */
    public List<TrojiceRetezRetezRetez> getArTr() {
        return arTr;
    }

    /**
     * @param arTr the arTr to set
     */
    public void setArTr(List<TrojiceRetezRetezRetez> arTr) {
        this.arTr = arTr;
    }

    /**
     * @return the webProp
     */
    public Resource getWebProp() {
        return webProp;
    }

    /**
     * @param webProp the webProp to set
     */
    public void setWebProp(Resource webProp) {
        this.webProp = webProp;
    }

    /**
     * @return the idGalerie
     */
    public int getIdGalerie() {
        return idGalerie;
    }

    /**
     * @param idGalerie the idGalerie to set
     */
    public void setIdGalerie(int idGalerie) {
        this.idGalerie = idGalerie;
    }

    /**
     * @return the pomString
     */
    public String getPomString() {
        return pomString;
    }

    /**
     * @param pomString the pomString to set
     */
    public void setPomString(String pomString) {
        this.pomString = pomString;
    }

    /**
     * @return the druhUzivatel
     */
    public int getDruhUzivatel() {
        return druhUzivatel;
    }

    /**
     * @param druhUzivatel the druhUzivatel to set
     */
    public void setDruhUzivatel(int druhUzivatel) {
        this.druhUzivatel = druhUzivatel;
    }

    /**
     * @return the katOrgTyp
     */
    public int getKatOrgTyp() {
        return katOrgTyp;
    }

    /**
     * @param katOrgTyp the katOrgTyp to set
     */
    public void setKatOrgTyp(int katOrgTyp) {
        this.katOrgTyp = katOrgTyp;
    }

    /**
     * @return the katOrgDruh
     */
    public int getKatOrgDruh() {
        return katOrgDruh;
    }

    /**
     * @param katOrgDruh the katOrgDruh to set
     */
    public void setKatOrgDruh(int katOrgDruh) {
        this.katOrgDruh = katOrgDruh;
    }

    /**
     * @return the idKategorieZakladni
     */
    public int getIdKategorieZakladni() {
        return idKategorieZakladni;
    }

    /**
     * @param idKategorieZakladni the idKategorieZakladni to set
     */
    public void setIdKategorieZakladni(int idKategorieZakladni) {
        this.idKategorieZakladni = idKategorieZakladni;
    }

    /**
     * @return the prislusnost
     */
    public String getPrislusnost() {
        return prislusnost;
    }

    /**
     * @param prislusnost the prislusnost to set
     */
    public void setPrislusnost(String prislusnost) {
        this.prislusnost = prislusnost;
    }

    /**
     * @return the narodnost
     */
    public String getNarodnost() {
        return narodnost;
    }

    /**
     * @param narodnost the narodnost to set
     */
    public void setNarodnost(String narodnost) {
        this.narodnost = narodnost;
    }

    /**
     * @return the potvrzeni
     */
    public String getPotvrzeni() {
        return potvrzeni;
    }

    /**
     * @param potvrzeni the potvrzeni to set
     */
    public void setPotvrzeni(String potvrzeni) {
        this.potvrzeni = potvrzeni;
    }    
}
