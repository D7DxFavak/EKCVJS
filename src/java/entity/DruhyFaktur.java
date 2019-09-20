/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "druhy_faktur", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DruhyFaktur.findAll", query = "SELECT d FROM DruhyFaktur d"),
    @NamedQuery(name = "DruhyFaktur.findByDruhFakturyId", query = "SELECT d FROM DruhyFaktur d WHERE d.druhFakturyId = :druhFakturyId"),
    @NamedQuery(name = "DruhyFaktur.findByNazev", query = "SELECT d FROM DruhyFaktur d WHERE d.nazev = :nazev"),
    @NamedQuery(name = "DruhyFaktur.findByObjednavatel", query = "SELECT d FROM DruhyFaktur d WHERE d.objednavatel = :objednavatel"),
    @NamedQuery(name = "DruhyFaktur.findByObjNs", query = "SELECT d FROM DruhyFaktur d WHERE d.objNs = :objNs"),
    @NamedQuery(name = "DruhyFaktur.findByOdberatel", query = "SELECT d FROM DruhyFaktur d WHERE d.odberatel = :odberatel"),
    @NamedQuery(name = "DruhyFaktur.findByOdbNs", query = "SELECT d FROM DruhyFaktur d WHERE d.odbNs = :odbNs"),
    @NamedQuery(name = "DruhyFaktur.findByPlatce", query = "SELECT d FROM DruhyFaktur d WHERE d.platce = :platce"),
    @NamedQuery(name = "DruhyFaktur.findByPlNs", query = "SELECT d FROM DruhyFaktur d WHERE d.plNs = :plNs"),
    @NamedQuery(name = "DruhyFaktur.findByFakturaAdresa", query = "SELECT d FROM DruhyFaktur d WHERE d.fakturaAdresa = :fakturaAdresa"),
    @NamedQuery(name = "DruhyFaktur.findByPozadavkyOrganizace", query = "SELECT d FROM DruhyFaktur d WHERE d.pozadavkyOrganizace = :pozadavkyOrganizace"),
    @NamedQuery(name = "DruhyFaktur.findByPozadavkyOsoby", query = "SELECT d FROM DruhyFaktur d WHERE d.pozadavkyOsoby = :pozadavkyOsoby"),
    @NamedQuery(name = "DruhyFaktur.findByVyzadDatumzdanplneni", query = "SELECT d FROM DruhyFaktur d WHERE d.vyzadDatumzdanplneni = :vyzadDatumzdanplneni"),
    @NamedQuery(name = "DruhyFaktur.findByZakazModifikaceprihlasky", query = "SELECT d FROM DruhyFaktur d WHERE d.zakazModifikaceprihlasky = :zakazModifikaceprihlasky"),
    @NamedQuery(name = "DruhyFaktur.findByDobaSplatnosti", query = "SELECT d FROM DruhyFaktur d WHERE d.dobaSplatnosti = :dobaSplatnosti"),
    @NamedQuery(name = "DruhyFaktur.findByZalohaProcent", query = "SELECT d FROM DruhyFaktur d WHERE d.zalohaProcent = :zalohaProcent"),
    @NamedQuery(name = "DruhyFaktur.findByDennipenaleProcent", query = "SELECT d FROM DruhyFaktur d WHERE d.dennipenaleProcent = :dennipenaleProcent"),
    @NamedQuery(name = "DruhyFaktur.findByFakturaDruh", query = "SELECT d FROM DruhyFaktur d WHERE d.fakturaDruh = :fakturaDruh"),
    @NamedQuery(name = "DruhyFaktur.findByFakturaSeskupeni", query = "SELECT d FROM DruhyFaktur d WHERE d.fakturaSeskupeni = :fakturaSeskupeni"),
    @NamedQuery(name = "DruhyFaktur.findByDodavatelTitulek", query = "SELECT d FROM DruhyFaktur d WHERE d.dodavatelTitulek = :dodavatelTitulek"),
    @NamedQuery(name = "DruhyFaktur.findByObjednavatelTitulek", query = "SELECT d FROM DruhyFaktur d WHERE d.objednavatelTitulek = :objednavatelTitulek"),
    @NamedQuery(name = "DruhyFaktur.findByOdberatelTitulek", query = "SELECT d FROM DruhyFaktur d WHERE d.odberatelTitulek = :odberatelTitulek"),
    @NamedQuery(name = "DruhyFaktur.findByPlatceTitulek", query = "SELECT d FROM DruhyFaktur d WHERE d.platceTitulek = :platceTitulek"),
    @NamedQuery(name = "DruhyFaktur.findByCisloText", query = "SELECT d FROM DruhyFaktur d WHERE d.cisloText = :cisloText"),
    @NamedQuery(name = "DruhyFaktur.findByTitulek", query = "SELECT d FROM DruhyFaktur d WHERE d.titulek = :titulek"),
    @NamedQuery(name = "DruhyFaktur.findByNadpisPolozky", query = "SELECT d FROM DruhyFaktur d WHERE d.nadpisPolozky = :nadpisPolozky"),
    @NamedQuery(name = "DruhyFaktur.findByNPol1", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol1 = :nPol1"),
    @NamedQuery(name = "DruhyFaktur.findByNPol2", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol2 = :nPol2"),
    @NamedQuery(name = "DruhyFaktur.findByNPol3", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol3 = :nPol3"),
    @NamedQuery(name = "DruhyFaktur.findByNPol4", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol4 = :nPol4"),
    @NamedQuery(name = "DruhyFaktur.findByNPol5", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol5 = :nPol5"),
    @NamedQuery(name = "DruhyFaktur.findByNPol6", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol6 = :nPol6"),
    @NamedQuery(name = "DruhyFaktur.findByNPol7", query = "SELECT d FROM DruhyFaktur d WHERE d.nPol7 = :nPol7"),
    @NamedQuery(name = "DruhyFaktur.findByRekapitulaceTit1", query = "SELECT d FROM DruhyFaktur d WHERE d.rekapitulaceTit1 = :rekapitulaceTit1"),
    @NamedQuery(name = "DruhyFaktur.findByRekapitulaceTit2", query = "SELECT d FROM DruhyFaktur d WHERE d.rekapitulaceTit2 = :rekapitulaceTit2"),
    @NamedQuery(name = "DruhyFaktur.findByRekapitulaceTit3", query = "SELECT d FROM DruhyFaktur d WHERE d.rekapitulaceTit3 = :rekapitulaceTit3"),
    @NamedQuery(name = "DruhyFaktur.findByRekapitulaceTit4", query = "SELECT d FROM DruhyFaktur d WHERE d.rekapitulaceTit4 = :rekapitulaceTit4"),
    @NamedQuery(name = "DruhyFaktur.findByRekapitulaceTextFinal", query = "SELECT d FROM DruhyFaktur d WHERE d.rekapitulaceTextFinal = :rekapitulaceTextFinal"),
    @NamedQuery(name = "DruhyFaktur.findByRekapitulaceTextZaokrouhleni", query = "SELECT d FROM DruhyFaktur d WHERE d.rekapitulaceTextZaokrouhleni = :rekapitulaceTextZaokrouhleni"),
    @NamedQuery(name = "DruhyFaktur.findByMezisoucet", query = "SELECT d FROM DruhyFaktur d WHERE d.mezisoucet = :mezisoucet"),
    @NamedQuery(name = "DruhyFaktur.findByCelkem", query = "SELECT d FROM DruhyFaktur d WHERE d.celkem = :celkem"),
    @NamedQuery(name = "DruhyFaktur.findByVystavil", query = "SELECT d FROM DruhyFaktur d WHERE d.vystavil = :vystavil"),
    @NamedQuery(name = "DruhyFaktur.findByDodatekVystaveni", query = "SELECT d FROM DruhyFaktur d WHERE d.dodatekVystaveni = :dodatekVystaveni"),
    @NamedQuery(name = "DruhyFaktur.findByDodatekGlobal", query = "SELECT d FROM DruhyFaktur d WHERE d.dodatekGlobal = :dodatekGlobal"),
    @NamedQuery(name = "DruhyFaktur.findByPoznamky", query = "SELECT d FROM DruhyFaktur d WHERE d.poznamky = :poznamky"),
    @NamedQuery(name = "DruhyFaktur.findByPoradiVyber", query = "SELECT d FROM DruhyFaktur d WHERE d.poradiVyber = :poradiVyber")})
public class DruhyFaktur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "druh_faktury_id")
    private Integer druhFakturyId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "objednavatel")
    private Integer objednavatel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obj_ns")
    private boolean objNs;
    @Column(name = "odberatel")
    private Integer odberatel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odb_ns")
    private boolean odbNs;
    @Column(name = "platce")
    private Integer platce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pl_ns")
    private boolean plNs;
    @Column(name = "faktura_adresa")
    private Integer fakturaAdresa;
    @Column(name = "pozadavky_organizace")
    private Integer pozadavkyOrganizace;
    @Column(name = "pozadavky_osoby")
    private Integer pozadavkyOsoby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyzad_datumzdanplneni")
    private boolean vyzadDatumzdanplneni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zakaz_modifikaceprihlasky")
    private boolean zakazModifikaceprihlasky;
    @Column(name = "doba_splatnosti")
    private Integer dobaSplatnosti;
    @Column(name = "zaloha_procent")
    private Integer zalohaProcent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dennipenale_procent")
    private BigDecimal dennipenaleProcent;
    @Column(name = "faktura_druh")
    private Integer fakturaDruh;
    @Column(name = "faktura_seskupeni")
    private Integer fakturaSeskupeni;
    @Size(max = 30)
    @Column(name = "dodavatel_titulek")
    private String dodavatelTitulek;
    @Size(max = 30)
    @Column(name = "objednavatel_titulek")
    private String objednavatelTitulek;
    @Size(max = 30)
    @Column(name = "odberatel_titulek")
    private String odberatelTitulek;
    @Size(max = 30)
    @Column(name = "platce_titulek")
    private String platceTitulek;
    @Size(max = 50)
    @Column(name = "cislo_text")
    private String cisloText;
    @Size(max = 40)
    @Column(name = "titulek")
    private String titulek;
    @Size(max = 150)
    @Column(name = "nadpis_polozky")
    private String nadpisPolozky;
    @Size(max = 30)
    @Column(name = "n_pol_1")
    private String nPol1;
    @Size(max = 30)
    @Column(name = "n_pol_2")
    private String nPol2;
    @Size(max = 30)
    @Column(name = "n_pol_3")
    private String nPol3;
    @Size(max = 30)
    @Column(name = "n_pol_4")
    private String nPol4;
    @Size(max = 30)
    @Column(name = "n_pol_5")
    private String nPol5;
    @Size(max = 30)
    @Column(name = "n_pol_6")
    private String nPol6;
    @Size(max = 30)
    @Column(name = "n_pol_7")
    private String nPol7;
    @Size(max = 30)
    @Column(name = "rekapitulace_tit_1")
    private String rekapitulaceTit1;
    @Size(max = 30)
    @Column(name = "rekapitulace_tit_2")
    private String rekapitulaceTit2;
    @Size(max = 30)
    @Column(name = "rekapitulace_tit_3")
    private String rekapitulaceTit3;
    @Size(max = 30)
    @Column(name = "rekapitulace_tit_4")
    private String rekapitulaceTit4;
    @Size(max = 50)
    @Column(name = "rekapitulace_text_final")
    private String rekapitulaceTextFinal;
    @Size(max = 50)
    @Column(name = "rekapitulace_text_zaokrouhleni")
    private String rekapitulaceTextZaokrouhleni;
    @Size(max = 80)
    @Column(name = "mezisoucet")
    private String mezisoucet;
    @Size(max = 80)
    @Column(name = "celkem")
    private String celkem;
    @Size(max = 100)
    @Column(name = "vystavil")
    private String vystavil;
    @Size(max = 150)
    @Column(name = "dodatek_vystaveni")
    private String dodatekVystaveni;
    @Size(max = 300)
    @Column(name = "dodatek_global")
    private String dodatekGlobal;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @OneToMany(mappedBy = "druhfakt")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @OneToMany(mappedBy = "druhfakt")
    private Collection<KnihaFaktur> knihaFakturCollection;
    @OneToMany(mappedBy = "druhfakt")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyFaktur")
    private Collection<PrihlDruhyStavyFakturace> prihlDruhyStavyFakturaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyFaktur")
    private Collection<StavyDruhyFaktVztahy> stavyDruhyFaktVztahyCollection;

    public DruhyFaktur() {
    }

    public DruhyFaktur(Integer druhFakturyId) {
        this.druhFakturyId = druhFakturyId;
    }

    public DruhyFaktur(Integer druhFakturyId, boolean objNs, boolean odbNs, boolean plNs, boolean vyzadDatumzdanplneni, boolean zakazModifikaceprihlasky) {
        this.druhFakturyId = druhFakturyId;
        this.objNs = objNs;
        this.odbNs = odbNs;
        this.plNs = plNs;
        this.vyzadDatumzdanplneni = vyzadDatumzdanplneni;
        this.zakazModifikaceprihlasky = zakazModifikaceprihlasky;
    }

    public Integer getDruhFakturyId() {
        return druhFakturyId;
    }

    public void setDruhFakturyId(Integer druhFakturyId) {
        this.druhFakturyId = druhFakturyId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Integer getObjednavatel() {
        return objednavatel;
    }

    public void setObjednavatel(Integer objednavatel) {
        this.objednavatel = objednavatel;
    }

    public boolean getObjNs() {
        return objNs;
    }

    public void setObjNs(boolean objNs) {
        this.objNs = objNs;
    }

    public Integer getOdberatel() {
        return odberatel;
    }

    public void setOdberatel(Integer odberatel) {
        this.odberatel = odberatel;
    }

    public boolean getOdbNs() {
        return odbNs;
    }

    public void setOdbNs(boolean odbNs) {
        this.odbNs = odbNs;
    }

    public Integer getPlatce() {
        return platce;
    }

    public void setPlatce(Integer platce) {
        this.platce = platce;
    }

    public boolean getPlNs() {
        return plNs;
    }

    public void setPlNs(boolean plNs) {
        this.plNs = plNs;
    }

    public Integer getFakturaAdresa() {
        return fakturaAdresa;
    }

    public void setFakturaAdresa(Integer fakturaAdresa) {
        this.fakturaAdresa = fakturaAdresa;
    }

    public Integer getPozadavkyOrganizace() {
        return pozadavkyOrganizace;
    }

    public void setPozadavkyOrganizace(Integer pozadavkyOrganizace) {
        this.pozadavkyOrganizace = pozadavkyOrganizace;
    }

    public Integer getPozadavkyOsoby() {
        return pozadavkyOsoby;
    }

    public void setPozadavkyOsoby(Integer pozadavkyOsoby) {
        this.pozadavkyOsoby = pozadavkyOsoby;
    }

    public boolean getVyzadDatumzdanplneni() {
        return vyzadDatumzdanplneni;
    }

    public void setVyzadDatumzdanplneni(boolean vyzadDatumzdanplneni) {
        this.vyzadDatumzdanplneni = vyzadDatumzdanplneni;
    }

    public boolean getZakazModifikaceprihlasky() {
        return zakazModifikaceprihlasky;
    }

    public void setZakazModifikaceprihlasky(boolean zakazModifikaceprihlasky) {
        this.zakazModifikaceprihlasky = zakazModifikaceprihlasky;
    }

    public Integer getDobaSplatnosti() {
        return dobaSplatnosti;
    }

    public void setDobaSplatnosti(Integer dobaSplatnosti) {
        this.dobaSplatnosti = dobaSplatnosti;
    }

    public Integer getZalohaProcent() {
        return zalohaProcent;
    }

    public void setZalohaProcent(Integer zalohaProcent) {
        this.zalohaProcent = zalohaProcent;
    }

    public BigDecimal getDennipenaleProcent() {
        return dennipenaleProcent;
    }

    public void setDennipenaleProcent(BigDecimal dennipenaleProcent) {
        this.dennipenaleProcent = dennipenaleProcent;
    }

    public Integer getFakturaDruh() {
        return fakturaDruh;
    }

    public void setFakturaDruh(Integer fakturaDruh) {
        this.fakturaDruh = fakturaDruh;
    }

    public Integer getFakturaSeskupeni() {
        return fakturaSeskupeni;
    }

    public void setFakturaSeskupeni(Integer fakturaSeskupeni) {
        this.fakturaSeskupeni = fakturaSeskupeni;
    }

    public String getDodavatelTitulek() {
        return dodavatelTitulek;
    }

    public void setDodavatelTitulek(String dodavatelTitulek) {
        this.dodavatelTitulek = dodavatelTitulek;
    }

    public String getObjednavatelTitulek() {
        return objednavatelTitulek;
    }

    public void setObjednavatelTitulek(String objednavatelTitulek) {
        this.objednavatelTitulek = objednavatelTitulek;
    }

    public String getOdberatelTitulek() {
        return odberatelTitulek;
    }

    public void setOdberatelTitulek(String odberatelTitulek) {
        this.odberatelTitulek = odberatelTitulek;
    }

    public String getPlatceTitulek() {
        return platceTitulek;
    }

    public void setPlatceTitulek(String platceTitulek) {
        this.platceTitulek = platceTitulek;
    }

    public String getCisloText() {
        return cisloText;
    }

    public void setCisloText(String cisloText) {
        this.cisloText = cisloText;
    }

    public String getTitulek() {
        return titulek;
    }

    public void setTitulek(String titulek) {
        this.titulek = titulek;
    }

    public String getNadpisPolozky() {
        return nadpisPolozky;
    }

    public void setNadpisPolozky(String nadpisPolozky) {
        this.nadpisPolozky = nadpisPolozky;
    }

    public String getNPol1() {
        return nPol1;
    }

    public void setNPol1(String nPol1) {
        this.nPol1 = nPol1;
    }

    public String getNPol2() {
        return nPol2;
    }

    public void setNPol2(String nPol2) {
        this.nPol2 = nPol2;
    }

    public String getNPol3() {
        return nPol3;
    }

    public void setNPol3(String nPol3) {
        this.nPol3 = nPol3;
    }

    public String getNPol4() {
        return nPol4;
    }

    public void setNPol4(String nPol4) {
        this.nPol4 = nPol4;
    }

    public String getNPol5() {
        return nPol5;
    }

    public void setNPol5(String nPol5) {
        this.nPol5 = nPol5;
    }

    public String getNPol6() {
        return nPol6;
    }

    public void setNPol6(String nPol6) {
        this.nPol6 = nPol6;
    }

    public String getNPol7() {
        return nPol7;
    }

    public void setNPol7(String nPol7) {
        this.nPol7 = nPol7;
    }

    public String getRekapitulaceTit1() {
        return rekapitulaceTit1;
    }

    public void setRekapitulaceTit1(String rekapitulaceTit1) {
        this.rekapitulaceTit1 = rekapitulaceTit1;
    }

    public String getRekapitulaceTit2() {
        return rekapitulaceTit2;
    }

    public void setRekapitulaceTit2(String rekapitulaceTit2) {
        this.rekapitulaceTit2 = rekapitulaceTit2;
    }

    public String getRekapitulaceTit3() {
        return rekapitulaceTit3;
    }

    public void setRekapitulaceTit3(String rekapitulaceTit3) {
        this.rekapitulaceTit3 = rekapitulaceTit3;
    }

    public String getRekapitulaceTit4() {
        return rekapitulaceTit4;
    }

    public void setRekapitulaceTit4(String rekapitulaceTit4) {
        this.rekapitulaceTit4 = rekapitulaceTit4;
    }

    public String getRekapitulaceTextFinal() {
        return rekapitulaceTextFinal;
    }

    public void setRekapitulaceTextFinal(String rekapitulaceTextFinal) {
        this.rekapitulaceTextFinal = rekapitulaceTextFinal;
    }

    public String getRekapitulaceTextZaokrouhleni() {
        return rekapitulaceTextZaokrouhleni;
    }

    public void setRekapitulaceTextZaokrouhleni(String rekapitulaceTextZaokrouhleni) {
        this.rekapitulaceTextZaokrouhleni = rekapitulaceTextZaokrouhleni;
    }

    public String getMezisoucet() {
        return mezisoucet;
    }

    public void setMezisoucet(String mezisoucet) {
        this.mezisoucet = mezisoucet;
    }

    public String getCelkem() {
        return celkem;
    }

    public void setCelkem(String celkem) {
        this.celkem = celkem;
    }

    public String getVystavil() {
        return vystavil;
    }

    public void setVystavil(String vystavil) {
        this.vystavil = vystavil;
    }

    public String getDodatekVystaveni() {
        return dodatekVystaveni;
    }

    public void setDodatekVystaveni(String dodatekVystaveni) {
        this.dodatekVystaveni = dodatekVystaveni;
    }

    public String getDodatekGlobal() {
        return dodatekGlobal;
    }

    public void setDodatekGlobal(String dodatekGlobal) {
        this.dodatekGlobal = dodatekGlobal;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public Integer getPoradiVyber() {
        return poradiVyber;
    }

    public void setPoradiVyber(Integer poradiVyber) {
        this.poradiVyber = poradiVyber;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection() {
        return prihlaskyRozpisyCollection;
    }

    public void setPrihlaskyRozpisyCollection(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection) {
        this.prihlaskyRozpisyCollection = prihlaskyRozpisyCollection;
    }

    @XmlTransient
    public Collection<KnihaFaktur> getKnihaFakturCollection() {
        return knihaFakturCollection;
    }

    public void setKnihaFakturCollection(Collection<KnihaFaktur> knihaFakturCollection) {
        this.knihaFakturCollection = knihaFakturCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @XmlTransient
    public Collection<PrihlDruhyStavyFakturace> getPrihlDruhyStavyFakturaceCollection() {
        return prihlDruhyStavyFakturaceCollection;
    }

    public void setPrihlDruhyStavyFakturaceCollection(Collection<PrihlDruhyStavyFakturace> prihlDruhyStavyFakturaceCollection) {
        this.prihlDruhyStavyFakturaceCollection = prihlDruhyStavyFakturaceCollection;
    }

    @XmlTransient
    public Collection<StavyDruhyFaktVztahy> getStavyDruhyFaktVztahyCollection() {
        return stavyDruhyFaktVztahyCollection;
    }

    public void setStavyDruhyFaktVztahyCollection(Collection<StavyDruhyFaktVztahy> stavyDruhyFaktVztahyCollection) {
        this.stavyDruhyFaktVztahyCollection = stavyDruhyFaktVztahyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (druhFakturyId != null ? druhFakturyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DruhyFaktur)) {
            return false;
        }
        DruhyFaktur other = (DruhyFaktur) object;
        if ((this.druhFakturyId == null && other.druhFakturyId != null) || (this.druhFakturyId != null && !this.druhFakturyId.equals(other.druhFakturyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DruhyFaktur[ druhFakturyId=" + druhFakturyId + " ]";
    }
    
}
