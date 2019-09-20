/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_hlavni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceHlavni.findAll", query = "SELECT a FROM AkceHlavni a"),
    @NamedQuery(name = "AkceHlavni.findByAkceId", query = "SELECT a FROM AkceHlavni a WHERE a.akceId = :akceId"),
    @NamedQuery(name = "AkceHlavni.findByNazev", query = "SELECT a FROM AkceHlavni a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceHlavni.findByCharakteristika", query = "SELECT a FROM AkceHlavni a WHERE a.charakteristika = :charakteristika"),
    @NamedQuery(name = "AkceHlavni.findByPopis", query = "SELECT a FROM AkceHlavni a WHERE a.popis = :popis"),
    @NamedQuery(name = "AkceHlavni.findByDoporuceno", query = "SELECT a FROM AkceHlavni a WHERE a.doporuceno = :doporuceno"),
    @NamedQuery(name = "AkceHlavni.findByTerminObecny", query = "SELECT a FROM AkceHlavni a WHERE a.terminObecny = :terminObecny"),
    @NamedQuery(name = "AkceHlavni.findByMistokonaniObecne", query = "SELECT a FROM AkceHlavni a WHERE a.mistokonaniObecne = :mistokonaniObecne"),
    @NamedQuery(name = "AkceHlavni.findByOptimalniPocet", query = "SELECT a FROM AkceHlavni a WHERE a.optimalniPocet = :optimalniPocet"),
    @NamedQuery(name = "AkceHlavni.findByPocetHranicerent", query = "SELECT a FROM AkceHlavni a WHERE a.pocetHranicerent = :pocetHranicerent"),
    @NamedQuery(name = "AkceHlavni.findByLektoriText", query = "SELECT a FROM AkceHlavni a WHERE a.lektoriText = :lektoriText"),
    @NamedQuery(name = "AkceHlavni.findByUcastnickyPoplatek", query = "SELECT a FROM AkceHlavni a WHERE a.ucastnickyPoplatek = :ucastnickyPoplatek"),
    @NamedQuery(name = "AkceHlavni.findByPoplatekText", query = "SELECT a FROM AkceHlavni a WHERE a.poplatekText = :poplatekText"),
    @NamedQuery(name = "AkceHlavni.findByPocetHodin", query = "SELECT a FROM AkceHlavni a WHERE a.pocetHodin = :pocetHodin"),
    @NamedQuery(name = "AkceHlavni.findByKomentarHodiny", query = "SELECT a FROM AkceHlavni a WHERE a.komentarHodiny = :komentarHodiny"),
    @NamedQuery(name = "AkceHlavni.findByDuvodStavu", query = "SELECT a FROM AkceHlavni a WHERE a.duvodStavu = :duvodStavu"),
    @NamedQuery(name = "AkceHlavni.findByKdyVlozeno", query = "SELECT a FROM AkceHlavni a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceHlavni.findByKdyZmeneno", query = "SELECT a FROM AkceHlavni a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceHlavni.findByKdoVlozil", query = "SELECT a FROM AkceHlavni a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceHlavni.findByKdoZmenil", query = "SELECT a FROM AkceHlavni a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceHlavni.findByPoznamky", query = "SELECT a FROM AkceHlavni a WHERE a.poznamky = :poznamky"),
    @NamedQuery(name = "AkceHlavni.findByAkceCislo", query = "SELECT a FROM AkceHlavni a WHERE a.akceCislo = :akceCislo"),
    @NamedQuery(name = "AkceHlavni.findByAkceTerminVystupnihoDokladu", query = "SELECT a FROM AkceHlavni a WHERE a.akceTerminVystupnihoDokladu = :akceTerminVystupnihoDokladu")})
public class AkceHlavni implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private Integer akceId;
    @Size(max = 300)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 200000)
    @Column(name = "charakteristika")
    private String charakteristika;
    @Size(max = 2147483647)
    @Column(name = "popis")
    private String popis;
    @Size(max = 100)
    @Column(name = "doporuceno")
    private String doporuceno;
    @Size(max = 500)
    @Column(name = "termin_obecny")
    private String terminObecny;
    @Size(max = 500)
    @Column(name = "mistokonani_obecne")
    private String mistokonaniObecne;
    @Column(name = "optimalni_pocet")
    private Integer optimalniPocet;
    @Column(name = "pocet_hranicerent")
    private Integer pocetHranicerent;
    @Size(max = 1000)
    @Column(name = "lektori_text")
    private String lektoriText;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ucastnicky_poplatek")
    private BigDecimal ucastnickyPoplatek;
    @Size(max = 200)
    @Column(name = "poplatek_text")
    private String poplatekText;
    @Column(name = "pocet_hodin")
    private Integer pocetHodin;
    @Size(max = 200)
    @Column(name = "komentar_hodiny")
    private String komentarHodiny;
    @Size(max = 2147483647)
    @Column(name = "duvod_stavu")
    private String duvodStavu;
    @Column(name = "kdy_vlozeno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyVlozeno;
    @Column(name = "kdy_zmeneno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyZmeneno;
    @Size(max = 100)
    @Column(name = "kdo_vlozil")
    private String kdoVlozil;
    @Size(max = 100)
    @Column(name = "kdo_zmenil")
    private String kdoZmenil;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Size(max = 14)
    @Column(name = "akce_cislo")
    private String akceCislo;
    @Column(name = "akce_termin_vystupniho_dokladu")
    @Temporal(TemporalType.DATE)
    private Date akceTerminVystupnihoDokladu;
    @OneToMany(mappedBy = "akce")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @JoinColumn(name = "akce_zpusob_komunikace_lektor_id", referencedColumnName = "zpusob_komunikace_lektor_id")
    @ManyToOne
    private ZpusobKomunikaceLektor akceZpusobKomunikaceLektorId;
    @JoinColumn(name = "sazba_dph", referencedColumnName = "sazba_dph_id")
    @ManyToOne
    private SazbyDph sazbaDph;
    @JoinColumn(name = "prim_obor", referencedColumnName = "obor_id")
    @ManyToOne
    private Obory primObor;
    @JoinColumn(name = "akce_obdobi", referencedColumnName = "obdobi_id")
    @ManyToOne
    private Obdobi akceObdobi;
    @JoinColumn(name = "akce_jazyk_id", referencedColumnName = "jazyky_id")
    @ManyToOne
    private Jazyky akceJazykId;
    @JoinColumn(name = "typ_hodiny", referencedColumnName = "cas_jednotka_id")
    @ManyToOne
    private CasoveJednotky typHodiny;
    @JoinColumn(name = "stav_akce", referencedColumnName = "stav_akce_id")
    @ManyToOne
    private AkceStavy stavAkce;
    @JoinColumn(name = "akce_rezim_zverejneni_id", referencedColumnName = "akce_rezim_zverejneni_id")
    @ManyToOne
    private AkceRezimZverejneni akceRezimZverejneniId;
    @JoinColumn(name = "formaakce", referencedColumnName = "akce_forma_id")
    @ManyToOne
    private AkceFormyAkce formaakce;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceCilskup> akceCilskupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkcePokracovani> akcePokracovaniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni1")
    private Collection<AkcePokracovani> akcePokracovaniCollection1;
    @OneToMany(mappedBy = "akce")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceKalkulace> akceKalkulaceCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private AkceJsDetaily akceJsDetaily;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceNavaznosti> akceNavaznostiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni1")
    private Collection<AkceNavaznosti> akceNavaznostiCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceVyuctovani> akceVyuctovaniCollection;
    @OneToMany(mappedBy = "akceId")
    private Collection<AkceRozpisy> akceRozpisyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceAkreditace> akceAkreditaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<VyberAkceFakturace> vyberAkceFakturaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceKalkulaceNaklady> akceKalkulaceNakladyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceDalsiObory> akceDalsiOboryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceLektori> akceLektoriCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<VazbaAkceUlozisteData> vazbaAkceUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<WebVazbaKategorieAkceHlavni> webVazbaKategorieAkceHlavniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceHlavni")
    private Collection<AkceOrganizace> akceOrganizaceCollection;
    @Transient
    private boolean volno;

    public AkceHlavni() {
    }

    public AkceHlavni(Integer akceId) {
        this.akceId = akceId;
    }

    public Integer getAkceId() {
        return akceId;
    }

    public void setAkceId(Integer akceId) {
        this.akceId = akceId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getCharakteristika() {
        return charakteristika;
    }

    public void setCharakteristika(String charakteristika) {
        this.charakteristika = charakteristika;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getDoporuceno() {
        return doporuceno;
    }

    public void setDoporuceno(String doporuceno) {
        this.doporuceno = doporuceno;
    }

    public String getTerminObecny() {
        return terminObecny;
    }

    public void setTerminObecny(String terminObecny) {
        this.terminObecny = terminObecny;
    }

    public String getMistokonaniObecne() {
        return mistokonaniObecne;
    }

    public void setMistokonaniObecne(String mistokonaniObecne) {
        this.mistokonaniObecne = mistokonaniObecne;
    }

    public Integer getOptimalniPocet() {
        return optimalniPocet;
    }

    public void setOptimalniPocet(Integer optimalniPocet) {
        this.optimalniPocet = optimalniPocet;
    }

    public Integer getPocetHranicerent() {
        return pocetHranicerent;
    }

    public void setPocetHranicerent(Integer pocetHranicerent) {
        this.pocetHranicerent = pocetHranicerent;
    }

    public String getLektoriText() {
        return lektoriText;
    }

    public void setLektoriText(String lektoriText) {
        this.lektoriText = lektoriText;
    }

    public BigDecimal getUcastnickyPoplatek() {
        return ucastnickyPoplatek;
    }

    public void setUcastnickyPoplatek(BigDecimal ucastnickyPoplatek) {
        this.ucastnickyPoplatek = ucastnickyPoplatek;
    }

    public String getPoplatekText() {
        return poplatekText;
    }

    public void setPoplatekText(String poplatekText) {
        this.poplatekText = poplatekText;
    }

    public Integer getPocetHodin() {
        return pocetHodin;
    }

    public void setPocetHodin(Integer pocetHodin) {
        this.pocetHodin = pocetHodin;
    }

    public String getKomentarHodiny() {
        return komentarHodiny;
    }

    public void setKomentarHodiny(String komentarHodiny) {
        this.komentarHodiny = komentarHodiny;
    }

    public String getDuvodStavu() {
        return duvodStavu;
    }

    public void setDuvodStavu(String duvodStavu) {
        this.duvodStavu = duvodStavu;
    }

    public Date getKdyVlozeno() {
        return kdyVlozeno;
    }

    public void setKdyVlozeno(Date kdyVlozeno) {
        this.kdyVlozeno = kdyVlozeno;
    }

    public Date getKdyZmeneno() {
        return kdyZmeneno;
    }

    public void setKdyZmeneno(Date kdyZmeneno) {
        this.kdyZmeneno = kdyZmeneno;
    }

    public String getKdoVlozil() {
        return kdoVlozil;
    }

    public void setKdoVlozil(String kdoVlozil) {
        this.kdoVlozil = kdoVlozil;
    }

    public String getKdoZmenil() {
        return kdoZmenil;
    }

    public void setKdoZmenil(String kdoZmenil) {
        this.kdoZmenil = kdoZmenil;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public String getAkceCislo() {
        return akceCislo;
    }

    public void setAkceCislo(String akceCislo) {
        this.akceCislo = akceCislo;
    }

    public Date getAkceTerminVystupnihoDokladu() {
        return akceTerminVystupnihoDokladu;
    }

    public void setAkceTerminVystupnihoDokladu(Date akceTerminVystupnihoDokladu) {
        this.akceTerminVystupnihoDokladu = akceTerminVystupnihoDokladu;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection() {
        return prihlaskyRozpisyCollection;
    }

    public void setPrihlaskyRozpisyCollection(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection) {
        this.prihlaskyRozpisyCollection = prihlaskyRozpisyCollection;
    }

    public ZpusobKomunikaceLektor getAkceZpusobKomunikaceLektorId() {
        return akceZpusobKomunikaceLektorId;
    }

    public void setAkceZpusobKomunikaceLektorId(ZpusobKomunikaceLektor akceZpusobKomunikaceLektorId) {
        this.akceZpusobKomunikaceLektorId = akceZpusobKomunikaceLektorId;
    }

    public SazbyDph getSazbaDph() {
        return sazbaDph;
    }

    public void setSazbaDph(SazbyDph sazbaDph) {
        this.sazbaDph = sazbaDph;
    }

    public Obory getPrimObor() {
        return primObor;
    }

    public void setPrimObor(Obory primObor) {
        this.primObor = primObor;
    }

    public Obdobi getAkceObdobi() {
        return akceObdobi;
    }

    public void setAkceObdobi(Obdobi akceObdobi) {
        this.akceObdobi = akceObdobi;
    }

    public Jazyky getAkceJazykId() {
        return akceJazykId;
    }

    public void setAkceJazykId(Jazyky akceJazykId) {
        this.akceJazykId = akceJazykId;
    }

    public CasoveJednotky getTypHodiny() {
        return typHodiny;
    }

    public void setTypHodiny(CasoveJednotky typHodiny) {
        this.typHodiny = typHodiny;
    }

    public AkceStavy getStavAkce() {
        return stavAkce;
    }

    public void setStavAkce(AkceStavy stavAkce) {
        this.stavAkce = stavAkce;
    }

    public AkceRezimZverejneni getAkceRezimZverejneniId() {
        return akceRezimZverejneniId;
    }

    public void setAkceRezimZverejneniId(AkceRezimZverejneni akceRezimZverejneniId) {
        this.akceRezimZverejneniId = akceRezimZverejneniId;
    }

    public AkceFormyAkce getFormaakce() {
        return formaakce;
    }

    public void setFormaakce(AkceFormyAkce formaakce) {
        this.formaakce = formaakce;
    }

    @XmlTransient
    public Collection<AkceCilskup> getAkceCilskupCollection() {
        return akceCilskupCollection;
    }

    public void setAkceCilskupCollection(Collection<AkceCilskup> akceCilskupCollection) {
        this.akceCilskupCollection = akceCilskupCollection;
    }

    @XmlTransient
    public Collection<AkcePokracovani> getAkcePokracovaniCollection() {
        return akcePokracovaniCollection;
    }

    public void setAkcePokracovaniCollection(Collection<AkcePokracovani> akcePokracovaniCollection) {
        this.akcePokracovaniCollection = akcePokracovaniCollection;
    }

    @XmlTransient
    public Collection<AkcePokracovani> getAkcePokracovaniCollection1() {
        return akcePokracovaniCollection1;
    }

    public void setAkcePokracovaniCollection1(Collection<AkcePokracovani> akcePokracovaniCollection1) {
        this.akcePokracovaniCollection1 = akcePokracovaniCollection1;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @XmlTransient
    public Collection<AkceKalkulace> getAkceKalkulaceCollection() {
        return akceKalkulaceCollection;
    }

    public void setAkceKalkulaceCollection(Collection<AkceKalkulace> akceKalkulaceCollection) {
        this.akceKalkulaceCollection = akceKalkulaceCollection;
    }

    public AkceJsDetaily getAkceJsDetaily() {
        return akceJsDetaily;
    }

    public void setAkceJsDetaily(AkceJsDetaily akceJsDetaily) {
        this.akceJsDetaily = akceJsDetaily;
    }

    @XmlTransient
    public Collection<AkceNavaznosti> getAkceNavaznostiCollection() {
        return akceNavaznostiCollection;
    }

    public void setAkceNavaznostiCollection(Collection<AkceNavaznosti> akceNavaznostiCollection) {
        this.akceNavaznostiCollection = akceNavaznostiCollection;
    }

    @XmlTransient
    public Collection<AkceNavaznosti> getAkceNavaznostiCollection1() {
        return akceNavaznostiCollection1;
    }

    public void setAkceNavaznostiCollection1(Collection<AkceNavaznosti> akceNavaznostiCollection1) {
        this.akceNavaznostiCollection1 = akceNavaznostiCollection1;
    }

    @XmlTransient
    public Collection<AkceVyuctovani> getAkceVyuctovaniCollection() {
        return akceVyuctovaniCollection;
    }

    public void setAkceVyuctovaniCollection(Collection<AkceVyuctovani> akceVyuctovaniCollection) {
        this.akceVyuctovaniCollection = akceVyuctovaniCollection;
    }

    @XmlTransient
    public Collection<AkceRozpisy> getAkceRozpisyCollection() {
        return akceRozpisyCollection;
    }

    public void setAkceRozpisyCollection(Collection<AkceRozpisy> akceRozpisyCollection) {
        this.akceRozpisyCollection = akceRozpisyCollection;
    }

    @XmlTransient
    public Collection<AkceAkreditace> getAkceAkreditaceCollection() {
        return akceAkreditaceCollection;
    }

    public void setAkceAkreditaceCollection(Collection<AkceAkreditace> akceAkreditaceCollection) {
        this.akceAkreditaceCollection = akceAkreditaceCollection;
    }

    @XmlTransient
    public Collection<VyberAkceFakturace> getVyberAkceFakturaceCollection() {
        return vyberAkceFakturaceCollection;
    }

    public void setVyberAkceFakturaceCollection(Collection<VyberAkceFakturace> vyberAkceFakturaceCollection) {
        this.vyberAkceFakturaceCollection = vyberAkceFakturaceCollection;
    }

    @XmlTransient
    public Collection<AkceKalkulaceNaklady> getAkceKalkulaceNakladyCollection() {
        return akceKalkulaceNakladyCollection;
    }

    public void setAkceKalkulaceNakladyCollection(Collection<AkceKalkulaceNaklady> akceKalkulaceNakladyCollection) {
        this.akceKalkulaceNakladyCollection = akceKalkulaceNakladyCollection;
    }

    @XmlTransient
    public Collection<AkceDalsiObory> getAkceDalsiOboryCollection() {
        return akceDalsiOboryCollection;
    }

    public void setAkceDalsiOboryCollection(Collection<AkceDalsiObory> akceDalsiOboryCollection) {
        this.akceDalsiOboryCollection = akceDalsiOboryCollection;
    }

    @XmlTransient
    public Collection<AkceLektori> getAkceLektoriCollection() {
        return akceLektoriCollection;
    }

    public void setAkceLektoriCollection(Collection<AkceLektori> akceLektoriCollection) {
        this.akceLektoriCollection = akceLektoriCollection;
    }

    @XmlTransient
    public Collection<VazbaAkceUlozisteData> getVazbaAkceUlozisteDataCollection() {
        return vazbaAkceUlozisteDataCollection;
    }

    public void setVazbaAkceUlozisteDataCollection(Collection<VazbaAkceUlozisteData> vazbaAkceUlozisteDataCollection) {
        this.vazbaAkceUlozisteDataCollection = vazbaAkceUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<WebVazbaKategorieAkceHlavni> getWebVazbaKategorieAkceHlavniCollection() {
        return webVazbaKategorieAkceHlavniCollection;
    }

    public void setWebVazbaKategorieAkceHlavniCollection(Collection<WebVazbaKategorieAkceHlavni> webVazbaKategorieAkceHlavniCollection) {
        this.webVazbaKategorieAkceHlavniCollection = webVazbaKategorieAkceHlavniCollection;
    }

    @XmlTransient
    public Collection<AkceOrganizace> getAkceOrganizaceCollection() {
        return akceOrganizaceCollection;
    }

    public void setAkceOrganizaceCollection(Collection<AkceOrganizace> akceOrganizaceCollection) {
        this.akceOrganizaceCollection = akceOrganizaceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceId != null ? akceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceHlavni)) {
            return false;
        }
        AkceHlavni other = (AkceHlavni) object;
        if ((this.akceId == null && other.akceId != null) || (this.akceId != null && !this.akceId.equals(other.akceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceHlavni[ akceId=" + akceId + " ]";
    }

    /**
     * @return the volno
     */
    public boolean isVolno() {
        return volno;
    }

    /**
     * @param volno the volno to set
     */
    public void setVolno(boolean volno) {
        this.volno = volno;
    }
    
}
