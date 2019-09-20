/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "parametry_obecne", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametryObecne.findAll", query = "SELECT p FROM ParametryObecne p"),
    @NamedQuery(name = "ParametryObecne.findByParametrId", query = "SELECT p FROM ParametryObecne p WHERE p.parametrId = :parametrId"),
    @NamedQuery(name = "ParametryObecne.findByNazevDatabaze", query = "SELECT p FROM ParametryObecne p WHERE p.nazevDatabaze = :nazevDatabaze"),
    @NamedQuery(name = "ParametryObecne.findByPrefixFaktur", query = "SELECT p FROM ParametryObecne p WHERE p.prefixFaktur = :prefixFaktur"),
    @NamedQuery(name = "ParametryObecne.findByDobaProdlpotvrzprihl", query = "SELECT p FROM ParametryObecne p WHERE p.dobaProdlpotvrzprihl = :dobaProdlpotvrzprihl"),
    @NamedQuery(name = "ParametryObecne.findByCastkaRs", query = "SELECT p FROM ParametryObecne p WHERE p.castkaRs = :castkaRs"),
    @NamedQuery(name = "ParametryObecne.findByCastkaMena", query = "SELECT p FROM ParametryObecne p WHERE p.castkaMena = :castkaMena"),
    @NamedQuery(name = "ParametryObecne.findByZpAdresa1", query = "SELECT p FROM ParametryObecne p WHERE p.zpAdresa1 = :zpAdresa1"),
    @NamedQuery(name = "ParametryObecne.findByZpAdresa2", query = "SELECT p FROM ParametryObecne p WHERE p.zpAdresa2 = :zpAdresa2"),
    @NamedQuery(name = "ParametryObecne.findByZpAdresa3", query = "SELECT p FROM ParametryObecne p WHERE p.zpAdresa3 = :zpAdresa3"),
    @NamedQuery(name = "ParametryObecne.findByZpAdresa4", query = "SELECT p FROM ParametryObecne p WHERE p.zpAdresa4 = :zpAdresa4"),
    @NamedQuery(name = "ParametryObecne.findByZpAdresa5", query = "SELECT p FROM ParametryObecne p WHERE p.zpAdresa5 = :zpAdresa5"),
    @NamedQuery(name = "ParametryObecne.findByObZnamka1", query = "SELECT p FROM ParametryObecne p WHERE p.obZnamka1 = :obZnamka1"),
    @NamedQuery(name = "ParametryObecne.findByObZnamka2", query = "SELECT p FROM ParametryObecne p WHERE p.obZnamka2 = :obZnamka2"),
    @NamedQuery(name = "ParametryObecne.findByObZnamka3", query = "SELECT p FROM ParametryObecne p WHERE p.obZnamka3 = :obZnamka3"),
    @NamedQuery(name = "ParametryObecne.findByObZnamka4", query = "SELECT p FROM ParametryObecne p WHERE p.obZnamka4 = :obZnamka4"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaUAkce", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaUAkce = :defPravaUAkce"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaGAkce", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaGAkce = :defPravaGAkce"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaOAkce", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaOAkce = :defPravaOAkce"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaUAkr", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaUAkr = :defPravaUAkr"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaGAkr", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaGAkr = :defPravaGAkr"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaOAkr", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaOAkr = :defPravaOAkr"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaUObory", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaUObory = :defPravaUObory"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaGObory", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaGObory = :defPravaGObory"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaOObory", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaOObory = :defPravaOObory"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaUOsoby", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaUOsoby = :defPravaUOsoby"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaGOsoby", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaGOsoby = :defPravaGOsoby"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaOOsoby", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaOOsoby = :defPravaOOsoby"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaUOrg", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaUOrg = :defPravaUOrg"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaGOrg", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaGOrg = :defPravaGOrg"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaOOrg", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaOOrg = :defPravaOOrg"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaUPrihl", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaUPrihl = :defPravaUPrihl"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaGPrihl", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaGPrihl = :defPravaGPrihl"),
    @NamedQuery(name = "ParametryObecne.findByDefPravaOPrihl", query = "SELECT p FROM ParametryObecne p WHERE p.defPravaOPrihl = :defPravaOPrihl"),
    @NamedQuery(name = "ParametryObecne.findByVychoziTiskexportdruhystavy", query = "SELECT p FROM ParametryObecne p WHERE p.vychoziTiskexportdruhystavy = :vychoziTiskexportdruhystavy"),
    @NamedQuery(name = "ParametryObecne.findByVychoziVolbyprehlaseni", query = "SELECT p FROM ParametryObecne p WHERE p.vychoziVolbyprehlaseni = :vychoziVolbyprehlaseni"),
    @NamedQuery(name = "ParametryObecne.findByPocetLidiObalkaMala", query = "SELECT p FROM ParametryObecne p WHERE p.pocetLidiObalkaMala = :pocetLidiObalkaMala"),
    @NamedQuery(name = "ParametryObecne.findByPocetLidiObalkaVelka", query = "SELECT p FROM ParametryObecne p WHERE p.pocetLidiObalkaVelka = :pocetLidiObalkaVelka"),
    @NamedQuery(name = "ParametryObecne.findByUmisteniObalek", query = "SELECT p FROM ParametryObecne p WHERE p.umisteniObalek = :umisteniObalek"),
    @NamedQuery(name = "ParametryObecne.findByPobsxm", query = "SELECT p FROM ParametryObecne p WHERE p.pobsxm = :pobsxm"),
    @NamedQuery(name = "ParametryObecne.findByPobsym", query = "SELECT p FROM ParametryObecne p WHERE p.pobsym = :pobsym"),
    @NamedQuery(name = "ParametryObecne.findByPobpxm", query = "SELECT p FROM ParametryObecne p WHERE p.pobpxm = :pobpxm"),
    @NamedQuery(name = "ParametryObecne.findByPobpym", query = "SELECT p FROM ParametryObecne p WHERE p.pobpym = :pobpym"),
    @NamedQuery(name = "ParametryObecne.findByPoblxm", query = "SELECT p FROM ParametryObecne p WHERE p.poblxm = :poblxm"),
    @NamedQuery(name = "ParametryObecne.findByPoblym", query = "SELECT p FROM ParametryObecne p WHERE p.poblym = :poblym"),
    @NamedQuery(name = "ParametryObecne.findByPobsxv", query = "SELECT p FROM ParametryObecne p WHERE p.pobsxv = :pobsxv"),
    @NamedQuery(name = "ParametryObecne.findByPobsyv", query = "SELECT p FROM ParametryObecne p WHERE p.pobsyv = :pobsyv"),
    @NamedQuery(name = "ParametryObecne.findByPobpxv", query = "SELECT p FROM ParametryObecne p WHERE p.pobpxv = :pobpxv"),
    @NamedQuery(name = "ParametryObecne.findByPobpyv", query = "SELECT p FROM ParametryObecne p WHERE p.pobpyv = :pobpyv"),
    @NamedQuery(name = "ParametryObecne.findByPoblxv", query = "SELECT p FROM ParametryObecne p WHERE p.poblxv = :poblxv"),
    @NamedQuery(name = "ParametryObecne.findByPoblyv", query = "SELECT p FROM ParametryObecne p WHERE p.poblyv = :poblyv"),
    @NamedQuery(name = "ParametryObecne.findByPslx", query = "SELECT p FROM ParametryObecne p WHERE p.pslx = :pslx"),
    @NamedQuery(name = "ParametryObecne.findByPsly", query = "SELECT p FROM ParametryObecne p WHERE p.psly = :psly"),
    @NamedQuery(name = "ParametryObecne.findByPoznamky", query = "SELECT p FROM ParametryObecne p WHERE p.poznamky = :poznamky"),
    @NamedQuery(name = "ParametryObecne.findByAkreditacePocetDniKonciciPlatnost", query = "SELECT p FROM ParametryObecne p WHERE p.akreditacePocetDniKonciciPlatnost = :akreditacePocetDniKonciciPlatnost")})
public class ParametryObecne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "parametr_id")
    private Integer parametrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nazev_databaze")
    private String nazevDatabaze;
    @Column(name = "prefix_faktur")
    private Integer prefixFaktur;
    @Column(name = "doba_prodlpotvrzprihl")
    private Integer dobaProdlpotvrzprihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "castka_rs")
    private int castkaRs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "castka_mena")
    private String castkaMena;
    @Size(max = 40)
    @Column(name = "zp_adresa1")
    private String zpAdresa1;
    @Size(max = 40)
    @Column(name = "zp_adresa2")
    private String zpAdresa2;
    @Size(max = 40)
    @Column(name = "zp_adresa3")
    private String zpAdresa3;
    @Size(max = 40)
    @Column(name = "zp_adresa4")
    private String zpAdresa4;
    @Size(max = 40)
    @Column(name = "zp_adresa5")
    private String zpAdresa5;
    @Size(max = 20)
    @Column(name = "ob_znamka1")
    private String obZnamka1;
    @Size(max = 20)
    @Column(name = "ob_znamka2")
    private String obZnamka2;
    @Size(max = 20)
    @Column(name = "ob_znamka3")
    private String obZnamka3;
    @Size(max = 20)
    @Column(name = "ob_znamka4")
    private String obZnamka4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_u_akce")
    private int defPravaUAkce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_g_akce")
    private int defPravaGAkce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_o_akce")
    private int defPravaOAkce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_u_akr")
    private int defPravaUAkr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_g_akr")
    private int defPravaGAkr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_o_akr")
    private int defPravaOAkr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_u_obory")
    private int defPravaUObory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_g_obory")
    private int defPravaGObory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_o_obory")
    private int defPravaOObory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_u_osoby")
    private int defPravaUOsoby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_g_osoby")
    private int defPravaGOsoby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_o_osoby")
    private int defPravaOOsoby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_u_org")
    private int defPravaUOrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_g_org")
    private int defPravaGOrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_o_org")
    private int defPravaOOrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_u_prihl")
    private int defPravaUPrihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_g_prihl")
    private int defPravaGPrihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def_prava_o_prihl")
    private int defPravaOPrihl;
    @Column(name = "vychozi_tiskexportdruhystavy")
    private Integer vychoziTiskexportdruhystavy;
    @Column(name = "vychozi_volbyprehlaseni")
    private Integer vychoziVolbyprehlaseni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pocet_lidi_obalka_mala")
    private int pocetLidiObalkaMala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pocet_lidi_obalka_velka")
    private int pocetLidiObalkaVelka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "umisteni_obalek")
    private int umisteniObalek;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobsxm")
    private int pobsxm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobsym")
    private int pobsym;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobpxm")
    private int pobpxm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobpym")
    private int pobpym;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poblxm")
    private int poblxm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poblym")
    private int poblym;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobsxv")
    private int pobsxv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobsyv")
    private int pobsyv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobpxv")
    private int pobpxv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pobpyv")
    private int pobpyv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poblxv")
    private int poblxv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poblyv")
    private int poblyv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pslx")
    private int pslx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psly")
    private int psly;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akreditace_pocet_dni_koncici_platnost")
    private int akreditacePocetDniKonciciPlatnost;
    @JoinColumn(name = "druh_lektor", referencedColumnName = "druh_osoby_id")
    @ManyToOne
    private OsobyDruhy druhLektor;
    @JoinColumn(name = "druh_klient", referencedColumnName = "druh_osoby_id")
    @ManyToOne
    private OsobyDruhy druhKlient;
    @JoinColumn(name = "druh_garant", referencedColumnName = "druh_osoby_id")
    @ManyToOne
    private OsobyDruhy druhGarant;
    @JoinColumn(name = "druh_metodik", referencedColumnName = "druh_osoby_id")
    @ManyToOne
    private OsobyDruhy druhMetodik;
    @JoinColumn(name = "druh_extprac", referencedColumnName = "druh_osoby_id")
    @ManyToOne
    private OsobyDruhy druhExtprac;
    @JoinColumn(name = "dodavatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby dodavatelOs;
    @JoinColumn(name = "uzivatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby uzivatelOs;
    @JoinColumn(name = "dodavatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace dodavatelOrg;
    @JoinColumn(name = "uzivatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace uzivatelOrg;
    @JoinColumn(name = "aktualni_obdobi", referencedColumnName = "obdobi_id")
    @ManyToOne
    private Obdobi aktualniObdobi;
    @JoinColumn(name = "vychozi_dp", referencedColumnName = "druh_prihl_id")
    @ManyToOne
    private DruhyPrihlasek vychoziDp;
    @JoinColumn(name = "vychozi_stavakce", referencedColumnName = "stav_akce_id")
    @ManyToOne
    private AkceStavy vychoziStavakce;

    public ParametryObecne() {
    }

    public ParametryObecne(Integer parametrId) {
        this.parametrId = parametrId;
    }

    public ParametryObecne(Integer parametrId, String nazevDatabaze, int castkaRs, String castkaMena, int defPravaUAkce, int defPravaGAkce, int defPravaOAkce, int defPravaUAkr, int defPravaGAkr, int defPravaOAkr, int defPravaUObory, int defPravaGObory, int defPravaOObory, int defPravaUOsoby, int defPravaGOsoby, int defPravaOOsoby, int defPravaUOrg, int defPravaGOrg, int defPravaOOrg, int defPravaUPrihl, int defPravaGPrihl, int defPravaOPrihl, int pocetLidiObalkaMala, int pocetLidiObalkaVelka, int umisteniObalek, int pobsxm, int pobsym, int pobpxm, int pobpym, int poblxm, int poblym, int pobsxv, int pobsyv, int pobpxv, int pobpyv, int poblxv, int poblyv, int pslx, int psly, int akreditacePocetDniKonciciPlatnost) {
        this.parametrId = parametrId;
        this.nazevDatabaze = nazevDatabaze;
        this.castkaRs = castkaRs;
        this.castkaMena = castkaMena;
        this.defPravaUAkce = defPravaUAkce;
        this.defPravaGAkce = defPravaGAkce;
        this.defPravaOAkce = defPravaOAkce;
        this.defPravaUAkr = defPravaUAkr;
        this.defPravaGAkr = defPravaGAkr;
        this.defPravaOAkr = defPravaOAkr;
        this.defPravaUObory = defPravaUObory;
        this.defPravaGObory = defPravaGObory;
        this.defPravaOObory = defPravaOObory;
        this.defPravaUOsoby = defPravaUOsoby;
        this.defPravaGOsoby = defPravaGOsoby;
        this.defPravaOOsoby = defPravaOOsoby;
        this.defPravaUOrg = defPravaUOrg;
        this.defPravaGOrg = defPravaGOrg;
        this.defPravaOOrg = defPravaOOrg;
        this.defPravaUPrihl = defPravaUPrihl;
        this.defPravaGPrihl = defPravaGPrihl;
        this.defPravaOPrihl = defPravaOPrihl;
        this.pocetLidiObalkaMala = pocetLidiObalkaMala;
        this.pocetLidiObalkaVelka = pocetLidiObalkaVelka;
        this.umisteniObalek = umisteniObalek;
        this.pobsxm = pobsxm;
        this.pobsym = pobsym;
        this.pobpxm = pobpxm;
        this.pobpym = pobpym;
        this.poblxm = poblxm;
        this.poblym = poblym;
        this.pobsxv = pobsxv;
        this.pobsyv = pobsyv;
        this.pobpxv = pobpxv;
        this.pobpyv = pobpyv;
        this.poblxv = poblxv;
        this.poblyv = poblyv;
        this.pslx = pslx;
        this.psly = psly;
        this.akreditacePocetDniKonciciPlatnost = akreditacePocetDniKonciciPlatnost;
    }

    public Integer getParametrId() {
        return parametrId;
    }

    public void setParametrId(Integer parametrId) {
        this.parametrId = parametrId;
    }

    public String getNazevDatabaze() {
        return nazevDatabaze;
    }

    public void setNazevDatabaze(String nazevDatabaze) {
        this.nazevDatabaze = nazevDatabaze;
    }

    public Integer getPrefixFaktur() {
        return prefixFaktur;
    }

    public void setPrefixFaktur(Integer prefixFaktur) {
        this.prefixFaktur = prefixFaktur;
    }

    public Integer getDobaProdlpotvrzprihl() {
        return dobaProdlpotvrzprihl;
    }

    public void setDobaProdlpotvrzprihl(Integer dobaProdlpotvrzprihl) {
        this.dobaProdlpotvrzprihl = dobaProdlpotvrzprihl;
    }

    public int getCastkaRs() {
        return castkaRs;
    }

    public void setCastkaRs(int castkaRs) {
        this.castkaRs = castkaRs;
    }

    public String getCastkaMena() {
        return castkaMena;
    }

    public void setCastkaMena(String castkaMena) {
        this.castkaMena = castkaMena;
    }

    public String getZpAdresa1() {
        return zpAdresa1;
    }

    public void setZpAdresa1(String zpAdresa1) {
        this.zpAdresa1 = zpAdresa1;
    }

    public String getZpAdresa2() {
        return zpAdresa2;
    }

    public void setZpAdresa2(String zpAdresa2) {
        this.zpAdresa2 = zpAdresa2;
    }

    public String getZpAdresa3() {
        return zpAdresa3;
    }

    public void setZpAdresa3(String zpAdresa3) {
        this.zpAdresa3 = zpAdresa3;
    }

    public String getZpAdresa4() {
        return zpAdresa4;
    }

    public void setZpAdresa4(String zpAdresa4) {
        this.zpAdresa4 = zpAdresa4;
    }

    public String getZpAdresa5() {
        return zpAdresa5;
    }

    public void setZpAdresa5(String zpAdresa5) {
        this.zpAdresa5 = zpAdresa5;
    }

    public String getObZnamka1() {
        return obZnamka1;
    }

    public void setObZnamka1(String obZnamka1) {
        this.obZnamka1 = obZnamka1;
    }

    public String getObZnamka2() {
        return obZnamka2;
    }

    public void setObZnamka2(String obZnamka2) {
        this.obZnamka2 = obZnamka2;
    }

    public String getObZnamka3() {
        return obZnamka3;
    }

    public void setObZnamka3(String obZnamka3) {
        this.obZnamka3 = obZnamka3;
    }

    public String getObZnamka4() {
        return obZnamka4;
    }

    public void setObZnamka4(String obZnamka4) {
        this.obZnamka4 = obZnamka4;
    }

    public int getDefPravaUAkce() {
        return defPravaUAkce;
    }

    public void setDefPravaUAkce(int defPravaUAkce) {
        this.defPravaUAkce = defPravaUAkce;
    }

    public int getDefPravaGAkce() {
        return defPravaGAkce;
    }

    public void setDefPravaGAkce(int defPravaGAkce) {
        this.defPravaGAkce = defPravaGAkce;
    }

    public int getDefPravaOAkce() {
        return defPravaOAkce;
    }

    public void setDefPravaOAkce(int defPravaOAkce) {
        this.defPravaOAkce = defPravaOAkce;
    }

    public int getDefPravaUAkr() {
        return defPravaUAkr;
    }

    public void setDefPravaUAkr(int defPravaUAkr) {
        this.defPravaUAkr = defPravaUAkr;
    }

    public int getDefPravaGAkr() {
        return defPravaGAkr;
    }

    public void setDefPravaGAkr(int defPravaGAkr) {
        this.defPravaGAkr = defPravaGAkr;
    }

    public int getDefPravaOAkr() {
        return defPravaOAkr;
    }

    public void setDefPravaOAkr(int defPravaOAkr) {
        this.defPravaOAkr = defPravaOAkr;
    }

    public int getDefPravaUObory() {
        return defPravaUObory;
    }

    public void setDefPravaUObory(int defPravaUObory) {
        this.defPravaUObory = defPravaUObory;
    }

    public int getDefPravaGObory() {
        return defPravaGObory;
    }

    public void setDefPravaGObory(int defPravaGObory) {
        this.defPravaGObory = defPravaGObory;
    }

    public int getDefPravaOObory() {
        return defPravaOObory;
    }

    public void setDefPravaOObory(int defPravaOObory) {
        this.defPravaOObory = defPravaOObory;
    }

    public int getDefPravaUOsoby() {
        return defPravaUOsoby;
    }

    public void setDefPravaUOsoby(int defPravaUOsoby) {
        this.defPravaUOsoby = defPravaUOsoby;
    }

    public int getDefPravaGOsoby() {
        return defPravaGOsoby;
    }

    public void setDefPravaGOsoby(int defPravaGOsoby) {
        this.defPravaGOsoby = defPravaGOsoby;
    }

    public int getDefPravaOOsoby() {
        return defPravaOOsoby;
    }

    public void setDefPravaOOsoby(int defPravaOOsoby) {
        this.defPravaOOsoby = defPravaOOsoby;
    }

    public int getDefPravaUOrg() {
        return defPravaUOrg;
    }

    public void setDefPravaUOrg(int defPravaUOrg) {
        this.defPravaUOrg = defPravaUOrg;
    }

    public int getDefPravaGOrg() {
        return defPravaGOrg;
    }

    public void setDefPravaGOrg(int defPravaGOrg) {
        this.defPravaGOrg = defPravaGOrg;
    }

    public int getDefPravaOOrg() {
        return defPravaOOrg;
    }

    public void setDefPravaOOrg(int defPravaOOrg) {
        this.defPravaOOrg = defPravaOOrg;
    }

    public int getDefPravaUPrihl() {
        return defPravaUPrihl;
    }

    public void setDefPravaUPrihl(int defPravaUPrihl) {
        this.defPravaUPrihl = defPravaUPrihl;
    }

    public int getDefPravaGPrihl() {
        return defPravaGPrihl;
    }

    public void setDefPravaGPrihl(int defPravaGPrihl) {
        this.defPravaGPrihl = defPravaGPrihl;
    }

    public int getDefPravaOPrihl() {
        return defPravaOPrihl;
    }

    public void setDefPravaOPrihl(int defPravaOPrihl) {
        this.defPravaOPrihl = defPravaOPrihl;
    }

    public Integer getVychoziTiskexportdruhystavy() {
        return vychoziTiskexportdruhystavy;
    }

    public void setVychoziTiskexportdruhystavy(Integer vychoziTiskexportdruhystavy) {
        this.vychoziTiskexportdruhystavy = vychoziTiskexportdruhystavy;
    }

    public Integer getVychoziVolbyprehlaseni() {
        return vychoziVolbyprehlaseni;
    }

    public void setVychoziVolbyprehlaseni(Integer vychoziVolbyprehlaseni) {
        this.vychoziVolbyprehlaseni = vychoziVolbyprehlaseni;
    }

    public int getPocetLidiObalkaMala() {
        return pocetLidiObalkaMala;
    }

    public void setPocetLidiObalkaMala(int pocetLidiObalkaMala) {
        this.pocetLidiObalkaMala = pocetLidiObalkaMala;
    }

    public int getPocetLidiObalkaVelka() {
        return pocetLidiObalkaVelka;
    }

    public void setPocetLidiObalkaVelka(int pocetLidiObalkaVelka) {
        this.pocetLidiObalkaVelka = pocetLidiObalkaVelka;
    }

    public int getUmisteniObalek() {
        return umisteniObalek;
    }

    public void setUmisteniObalek(int umisteniObalek) {
        this.umisteniObalek = umisteniObalek;
    }

    public int getPobsxm() {
        return pobsxm;
    }

    public void setPobsxm(int pobsxm) {
        this.pobsxm = pobsxm;
    }

    public int getPobsym() {
        return pobsym;
    }

    public void setPobsym(int pobsym) {
        this.pobsym = pobsym;
    }

    public int getPobpxm() {
        return pobpxm;
    }

    public void setPobpxm(int pobpxm) {
        this.pobpxm = pobpxm;
    }

    public int getPobpym() {
        return pobpym;
    }

    public void setPobpym(int pobpym) {
        this.pobpym = pobpym;
    }

    public int getPoblxm() {
        return poblxm;
    }

    public void setPoblxm(int poblxm) {
        this.poblxm = poblxm;
    }

    public int getPoblym() {
        return poblym;
    }

    public void setPoblym(int poblym) {
        this.poblym = poblym;
    }

    public int getPobsxv() {
        return pobsxv;
    }

    public void setPobsxv(int pobsxv) {
        this.pobsxv = pobsxv;
    }

    public int getPobsyv() {
        return pobsyv;
    }

    public void setPobsyv(int pobsyv) {
        this.pobsyv = pobsyv;
    }

    public int getPobpxv() {
        return pobpxv;
    }

    public void setPobpxv(int pobpxv) {
        this.pobpxv = pobpxv;
    }

    public int getPobpyv() {
        return pobpyv;
    }

    public void setPobpyv(int pobpyv) {
        this.pobpyv = pobpyv;
    }

    public int getPoblxv() {
        return poblxv;
    }

    public void setPoblxv(int poblxv) {
        this.poblxv = poblxv;
    }

    public int getPoblyv() {
        return poblyv;
    }

    public void setPoblyv(int poblyv) {
        this.poblyv = poblyv;
    }

    public int getPslx() {
        return pslx;
    }

    public void setPslx(int pslx) {
        this.pslx = pslx;
    }

    public int getPsly() {
        return psly;
    }

    public void setPsly(int psly) {
        this.psly = psly;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public int getAkreditacePocetDniKonciciPlatnost() {
        return akreditacePocetDniKonciciPlatnost;
    }

    public void setAkreditacePocetDniKonciciPlatnost(int akreditacePocetDniKonciciPlatnost) {
        this.akreditacePocetDniKonciciPlatnost = akreditacePocetDniKonciciPlatnost;
    }

    public OsobyDruhy getDruhLektor() {
        return druhLektor;
    }

    public void setDruhLektor(OsobyDruhy druhLektor) {
        this.druhLektor = druhLektor;
    }

    public OsobyDruhy getDruhKlient() {
        return druhKlient;
    }

    public void setDruhKlient(OsobyDruhy druhKlient) {
        this.druhKlient = druhKlient;
    }

    public OsobyDruhy getDruhGarant() {
        return druhGarant;
    }

    public void setDruhGarant(OsobyDruhy druhGarant) {
        this.druhGarant = druhGarant;
    }

    public OsobyDruhy getDruhMetodik() {
        return druhMetodik;
    }

    public void setDruhMetodik(OsobyDruhy druhMetodik) {
        this.druhMetodik = druhMetodik;
    }

    public OsobyDruhy getDruhExtprac() {
        return druhExtprac;
    }

    public void setDruhExtprac(OsobyDruhy druhExtprac) {
        this.druhExtprac = druhExtprac;
    }

    public Osoby getDodavatelOs() {
        return dodavatelOs;
    }

    public void setDodavatelOs(Osoby dodavatelOs) {
        this.dodavatelOs = dodavatelOs;
    }

    public Osoby getUzivatelOs() {
        return uzivatelOs;
    }

    public void setUzivatelOs(Osoby uzivatelOs) {
        this.uzivatelOs = uzivatelOs;
    }

    public Organizace getDodavatelOrg() {
        return dodavatelOrg;
    }

    public void setDodavatelOrg(Organizace dodavatelOrg) {
        this.dodavatelOrg = dodavatelOrg;
    }

    public Organizace getUzivatelOrg() {
        return uzivatelOrg;
    }

    public void setUzivatelOrg(Organizace uzivatelOrg) {
        this.uzivatelOrg = uzivatelOrg;
    }

    public Obdobi getAktualniObdobi() {
        return aktualniObdobi;
    }

    public void setAktualniObdobi(Obdobi aktualniObdobi) {
        this.aktualniObdobi = aktualniObdobi;
    }

    public DruhyPrihlasek getVychoziDp() {
        return vychoziDp;
    }

    public void setVychoziDp(DruhyPrihlasek vychoziDp) {
        this.vychoziDp = vychoziDp;
    }

    public AkceStavy getVychoziStavakce() {
        return vychoziStavakce;
    }

    public void setVychoziStavakce(AkceStavy vychoziStavakce) {
        this.vychoziStavakce = vychoziStavakce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parametrId != null ? parametrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametryObecne)) {
            return false;
        }
        ParametryObecne other = (ParametryObecne) object;
        if ((this.parametrId == null && other.parametrId != null) || (this.parametrId != null && !this.parametrId.equals(other.parametrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ParametryObecne[ parametrId=" + parametrId + " ]";
    }
    
}
