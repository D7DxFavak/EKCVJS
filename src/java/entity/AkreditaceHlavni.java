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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akreditace_hlavni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkreditaceHlavni.findAll", query = "SELECT a FROM AkreditaceHlavni a"),
    @NamedQuery(name = "AkreditaceHlavni.findByAkreditaceId", query = "SELECT a FROM AkreditaceHlavni a WHERE a.akreditaceHlavniPK.akreditaceId = :akreditaceId"),
    @NamedQuery(name = "AkreditaceHlavni.findByAkreditacePoradi", query = "SELECT a FROM AkreditaceHlavni a WHERE a.akreditaceHlavniPK.akreditacePoradi = :akreditacePoradi"),
    @NamedQuery(name = "AkreditaceHlavni.findByPrideleneCislo", query = "SELECT a FROM AkreditaceHlavni a WHERE a.prideleneCislo = :prideleneCislo"),
    @NamedQuery(name = "AkreditaceHlavni.findByNazevAkce", query = "SELECT a FROM AkreditaceHlavni a WHERE a.nazevAkce = :nazevAkce"),
    @NamedQuery(name = "AkreditaceHlavni.findByCharkaAkce", query = "SELECT a FROM AkreditaceHlavni a WHERE a.charkaAkce = :charkaAkce"),
    @NamedQuery(name = "AkreditaceHlavni.findByVzdelavaciCil", query = "SELECT a FROM AkreditaceHlavni a WHERE a.vzdelavaciCil = :vzdelavaciCil"),
    @NamedQuery(name = "AkreditaceHlavni.findByHodinovaDotace", query = "SELECT a FROM AkreditaceHlavni a WHERE a.hodinovaDotace = :hodinovaDotace"),
    @NamedQuery(name = "AkreditaceHlavni.findByLektoriText", query = "SELECT a FROM AkreditaceHlavni a WHERE a.lektoriText = :lektoriText"),
    @NamedQuery(name = "AkreditaceHlavni.findByPocetUcastniku", query = "SELECT a FROM AkreditaceHlavni a WHERE a.pocetUcastniku = :pocetUcastniku"),
    @NamedQuery(name = "AkreditaceHlavni.findByPocetHranicerent", query = "SELECT a FROM AkreditaceHlavni a WHERE a.pocetHranicerent = :pocetHranicerent"),
    @NamedQuery(name = "AkreditaceHlavni.findByUcastnickyPoplatek", query = "SELECT a FROM AkreditaceHlavni a WHERE a.ucastnickyPoplatek = :ucastnickyPoplatek"),
    @NamedQuery(name = "AkreditaceHlavni.findByUpresneniCilskupiny", query = "SELECT a FROM AkreditaceHlavni a WHERE a.upresneniCilskupiny = :upresneniCilskupiny"),
    @NamedQuery(name = "AkreditaceHlavni.findByPlanMistokonani", query = "SELECT a FROM AkreditaceHlavni a WHERE a.planMistokonani = :planMistokonani"),
    @NamedQuery(name = "AkreditaceHlavni.findByMaterialtechZabezpeceni", query = "SELECT a FROM AkreditaceHlavni a WHERE a.materialtechZabezpeceni = :materialtechZabezpeceni"),
    @NamedQuery(name = "AkreditaceHlavni.findByZpusobVyhodnoceni", query = "SELECT a FROM AkreditaceHlavni a WHERE a.zpusobVyhodnoceni = :zpusobVyhodnoceni"),
    @NamedQuery(name = "AkreditaceHlavni.findByReference", query = "SELECT a FROM AkreditaceHlavni a WHERE a.reference = :reference"),
    @NamedQuery(name = "AkreditaceHlavni.findByDalsiUdaje", query = "SELECT a FROM AkreditaceHlavni a WHERE a.dalsiUdaje = :dalsiUdaje"),
    @NamedQuery(name = "AkreditaceHlavni.findByAkreditovanoAN", query = "SELECT a FROM AkreditaceHlavni a WHERE a.akreditovanoAN = :akreditovanoAN"),
    @NamedQuery(name = "AkreditaceHlavni.findByDatumOdeslani", query = "SELECT a FROM AkreditaceHlavni a WHERE a.datumOdeslani = :datumOdeslani"),
    @NamedQuery(name = "AkreditaceHlavni.findByDatumUdeleno", query = "SELECT a FROM AkreditaceHlavni a WHERE a.datumUdeleno = :datumUdeleno"),
    @NamedQuery(name = "AkreditaceHlavni.findByPlatnostOd", query = "SELECT a FROM AkreditaceHlavni a WHERE a.platnostOd = :platnostOd"),
    @NamedQuery(name = "AkreditaceHlavni.findByPlatnostDo", query = "SELECT a FROM AkreditaceHlavni a WHERE a.platnostDo = :platnostDo"),
    @NamedQuery(name = "AkreditaceHlavni.findByAkrUdeleniDetaily", query = "SELECT a FROM AkreditaceHlavni a WHERE a.akrUdeleniDetaily = :akrUdeleniDetaily"),
    @NamedQuery(name = "AkreditaceHlavni.findByKdyVlozeno", query = "SELECT a FROM AkreditaceHlavni a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkreditaceHlavni.findByKdyZmeneno", query = "SELECT a FROM AkreditaceHlavni a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkreditaceHlavni.findByKdoVlozil", query = "SELECT a FROM AkreditaceHlavni a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkreditaceHlavni.findByKdoZmenil", query = "SELECT a FROM AkreditaceHlavni a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkreditaceHlavni.findByPoznamky", query = "SELECT a FROM AkreditaceHlavni a WHERE a.poznamky = :poznamky"),
    @NamedQuery(name = "AkreditaceHlavni.findByAkreditaceTerminVystupnihoDokladu", query = "SELECT a FROM AkreditaceHlavni a WHERE a.akreditaceTerminVystupnihoDokladu = :akreditaceTerminVystupnihoDokladu")})
public class AkreditaceHlavni implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkreditaceHlavniPK akreditaceHlavniPK;
    @Size(max = 250)
    @Column(name = "pridelene_cislo")
    private String prideleneCislo;
    @Size(max = 300)
    @Column(name = "nazev_akce")
    private String nazevAkce;
    @Size(max = 2000000)
    @Column(name = "charka_akce")
    private String charkaAkce;
    @Size(max = 2147483647)
    @Column(name = "vzdelavaci_cil")
    private String vzdelavaciCil;
    @Column(name = "hodinova_dotace")
    private Integer hodinovaDotace;
    @Size(max = 1000)
    @Column(name = "lektori_text")
    private String lektoriText;
    @Column(name = "pocet_ucastniku")
    private Integer pocetUcastniku;
    @Column(name = "pocet_hranicerent")
    private Integer pocetHranicerent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ucastnicky_poplatek")
    private BigDecimal ucastnickyPoplatek;
    @Size(max = 2147483647)
    @Column(name = "upresneni_cilskupiny")
    private String upresneniCilskupiny;
    @Size(max = 250)
    @Column(name = "plan_mistokonani")
    private String planMistokonani;
    @Size(max = 2147483647)
    @Column(name = "materialtech_zabezpeceni")
    private String materialtechZabezpeceni;
    @Size(max = 2147483647)
    @Column(name = "zpusob_vyhodnoceni")
    private String zpusobVyhodnoceni;
    @Size(max = 2147483647)
    @Column(name = "reference")
    private String reference;
    @Size(max = 2147483647)
    @Column(name = "dalsi_udaje")
    private String dalsiUdaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akreditovano_a_n")
    private boolean akreditovanoAN;
    @Column(name = "datum_odeslani")
    @Temporal(TemporalType.DATE)
    private Date datumOdeslani;
    @Column(name = "datum_udeleno")
    @Temporal(TemporalType.DATE)
    private Date datumUdeleno;
    @Column(name = "platnost_od")
    @Temporal(TemporalType.DATE)
    private Date platnostOd;
    @Column(name = "platnost_do")
    @Temporal(TemporalType.DATE)
    private Date platnostDo;
    @Size(max = 2147483647)
    @Column(name = "akr_udeleni_detaily")
    private String akrUdeleniDetaily;
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
    @Column(name = "akreditace_termin_vystupniho_dokladu")
    @Temporal(TemporalType.DATE)
    private Date akreditaceTerminVystupnihoDokladu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akreditaceHlavni")
    private Collection<VazbaAkreditaceUlozisteData> vazbaAkreditaceUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akreditaceHlavni")
    private Collection<AkrDalsiCilskup> akrDalsiCilskupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akreditaceHlavni")
    private Collection<AkrKalkulaceNaklady> akrKalkulaceNakladyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akreditaceHlavni")
    private Collection<AkrLektori> akrLektoriCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akreditaceHlavni")
    private Collection<AkceAkreditace> akceAkreditaceCollection;
    @JoinColumn(name = "akreditace_zpusob_komunikace_lektor_id", referencedColumnName = "zpusob_komunikace_lektor_id")
    @ManyToOne
    private ZpusobKomunikaceLektor akreditaceZpusobKomunikaceLektorId;
    @JoinColumn(name = "sazba_dph", referencedColumnName = "sazba_dph_id")
    @ManyToOne
    private SazbyDph sazbaDph;
    @JoinColumn(name = "hlavni_garant", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby hlavniGarant;
    @JoinColumn(name = "mistokonani_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace mistokonaniOrg;
    @JoinColumn(name = "obor", referencedColumnName = "obor_id")
    @ManyToOne
    private Obory obor;
    @JoinColumn(name = "typ_hodiny", referencedColumnName = "cas_jednotka_id")
    @ManyToOne
    private CasoveJednotky typHodiny;
    @JoinColumns({
        @JoinColumn(name = "prim_oblzar_hrube", referencedColumnName = "oblzar_hrube_id"),
        @JoinColumn(name = "prim_oblzar_jemne", referencedColumnName = "oblzar_jemne_id")})
    @ManyToOne
    private AkrOblzarJemne akrOblzarJemne;
    @JoinColumn(name = "prim_oblzar_hrube", referencedColumnName = "oblzar_hrube_id", insertable=false, updatable=false)
    @ManyToOne
    private AkrOblzarHrube primOblzarHrube;
    @JoinColumn(name = "akr_formaakce", referencedColumnName = "akr_forma_id", insertable=false, updatable=false)
    @ManyToOne
    private AkrFormyAkce akrFormaakce;
    @JoinColumn(name = "prim_cilskupina", referencedColumnName = "akr_cilskup_id")
    @ManyToOne
    private AkrCiloveSkupiny primCilskupina;

    public AkreditaceHlavni() {
    }

    public AkreditaceHlavni(AkreditaceHlavniPK akreditaceHlavniPK) {
        this.akreditaceHlavniPK = akreditaceHlavniPK;
    }

    public AkreditaceHlavni(AkreditaceHlavniPK akreditaceHlavniPK, boolean akreditovanoAN) {
        this.akreditaceHlavniPK = akreditaceHlavniPK;
        this.akreditovanoAN = akreditovanoAN;
    }

    public AkreditaceHlavni(int akreditaceId, int akreditacePoradi) {
        this.akreditaceHlavniPK = new AkreditaceHlavniPK(akreditaceId, akreditacePoradi);
    }

    public AkreditaceHlavniPK getAkreditaceHlavniPK() {
        return akreditaceHlavniPK;
    }

    public void setAkreditaceHlavniPK(AkreditaceHlavniPK akreditaceHlavniPK) {
        this.akreditaceHlavniPK = akreditaceHlavniPK;
    }

    public String getPrideleneCislo() {
        return prideleneCislo;
    }

    public void setPrideleneCislo(String prideleneCislo) {
        this.prideleneCislo = prideleneCislo;
    }

    public String getNazevAkce() {
        return nazevAkce;
    }

    public void setNazevAkce(String nazevAkce) {
        this.nazevAkce = nazevAkce;
    }

    public String getCharkaAkce() {
        return charkaAkce;
    }

    public void setCharkaAkce(String charkaAkce) {
        this.charkaAkce = charkaAkce;
    }

    public String getVzdelavaciCil() {
        return vzdelavaciCil;
    }

    public void setVzdelavaciCil(String vzdelavaciCil) {
        this.vzdelavaciCil = vzdelavaciCil;
    }

    public Integer getHodinovaDotace() {
        return hodinovaDotace;
    }

    public void setHodinovaDotace(Integer hodinovaDotace) {
        this.hodinovaDotace = hodinovaDotace;
    }

    public String getLektoriText() {
        return lektoriText;
    }

    public void setLektoriText(String lektoriText) {
        this.lektoriText = lektoriText;
    }

    public Integer getPocetUcastniku() {
        return pocetUcastniku;
    }

    public void setPocetUcastniku(Integer pocetUcastniku) {
        this.pocetUcastniku = pocetUcastniku;
    }

    public Integer getPocetHranicerent() {
        return pocetHranicerent;
    }

    public void setPocetHranicerent(Integer pocetHranicerent) {
        this.pocetHranicerent = pocetHranicerent;
    }

    public BigDecimal getUcastnickyPoplatek() {
        return ucastnickyPoplatek;
    }

    public void setUcastnickyPoplatek(BigDecimal ucastnickyPoplatek) {
        this.ucastnickyPoplatek = ucastnickyPoplatek;
    }

    public String getUpresneniCilskupiny() {
        return upresneniCilskupiny;
    }

    public void setUpresneniCilskupiny(String upresneniCilskupiny) {
        this.upresneniCilskupiny = upresneniCilskupiny;
    }

    public String getPlanMistokonani() {
        return planMistokonani;
    }

    public void setPlanMistokonani(String planMistokonani) {
        this.planMistokonani = planMistokonani;
    }

    public String getMaterialtechZabezpeceni() {
        return materialtechZabezpeceni;
    }

    public void setMaterialtechZabezpeceni(String materialtechZabezpeceni) {
        this.materialtechZabezpeceni = materialtechZabezpeceni;
    }

    public String getZpusobVyhodnoceni() {
        return zpusobVyhodnoceni;
    }

    public void setZpusobVyhodnoceni(String zpusobVyhodnoceni) {
        this.zpusobVyhodnoceni = zpusobVyhodnoceni;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDalsiUdaje() {
        return dalsiUdaje;
    }

    public void setDalsiUdaje(String dalsiUdaje) {
        this.dalsiUdaje = dalsiUdaje;
    }

    public boolean getAkreditovanoAN() {
        return akreditovanoAN;
    }

    public void setAkreditovanoAN(boolean akreditovanoAN) {
        this.akreditovanoAN = akreditovanoAN;
    }

    public Date getDatumOdeslani() {
        return datumOdeslani;
    }

    public void setDatumOdeslani(Date datumOdeslani) {
        this.datumOdeslani = datumOdeslani;
    }

    public Date getDatumUdeleno() {
        return datumUdeleno;
    }

    public void setDatumUdeleno(Date datumUdeleno) {
        this.datumUdeleno = datumUdeleno;
    }

    public Date getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(Date platnostOd) {
        this.platnostOd = platnostOd;
    }

    public Date getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(Date platnostDo) {
        this.platnostDo = platnostDo;
    }

    public String getAkrUdeleniDetaily() {
        return akrUdeleniDetaily;
    }

    public void setAkrUdeleniDetaily(String akrUdeleniDetaily) {
        this.akrUdeleniDetaily = akrUdeleniDetaily;
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

    public Date getAkreditaceTerminVystupnihoDokladu() {
        return akreditaceTerminVystupnihoDokladu;
    }

    public void setAkreditaceTerminVystupnihoDokladu(Date akreditaceTerminVystupnihoDokladu) {
        this.akreditaceTerminVystupnihoDokladu = akreditaceTerminVystupnihoDokladu;
    }

    @XmlTransient
    public Collection<VazbaAkreditaceUlozisteData> getVazbaAkreditaceUlozisteDataCollection() {
        return vazbaAkreditaceUlozisteDataCollection;
    }

    public void setVazbaAkreditaceUlozisteDataCollection(Collection<VazbaAkreditaceUlozisteData> vazbaAkreditaceUlozisteDataCollection) {
        this.vazbaAkreditaceUlozisteDataCollection = vazbaAkreditaceUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<AkrDalsiCilskup> getAkrDalsiCilskupCollection() {
        return akrDalsiCilskupCollection;
    }

    public void setAkrDalsiCilskupCollection(Collection<AkrDalsiCilskup> akrDalsiCilskupCollection) {
        this.akrDalsiCilskupCollection = akrDalsiCilskupCollection;
    }

    @XmlTransient
    public Collection<AkrKalkulaceNaklady> getAkrKalkulaceNakladyCollection() {
        return akrKalkulaceNakladyCollection;
    }

    public void setAkrKalkulaceNakladyCollection(Collection<AkrKalkulaceNaklady> akrKalkulaceNakladyCollection) {
        this.akrKalkulaceNakladyCollection = akrKalkulaceNakladyCollection;
    }

    @XmlTransient
    public Collection<AkrLektori> getAkrLektoriCollection() {
        return akrLektoriCollection;
    }

    public void setAkrLektoriCollection(Collection<AkrLektori> akrLektoriCollection) {
        this.akrLektoriCollection = akrLektoriCollection;
    }

    @XmlTransient
    public Collection<AkceAkreditace> getAkceAkreditaceCollection() {
        return akceAkreditaceCollection;
    }

    public void setAkceAkreditaceCollection(Collection<AkceAkreditace> akceAkreditaceCollection) {
        this.akceAkreditaceCollection = akceAkreditaceCollection;
    }

    public ZpusobKomunikaceLektor getAkreditaceZpusobKomunikaceLektorId() {
        return akreditaceZpusobKomunikaceLektorId;
    }

    public void setAkreditaceZpusobKomunikaceLektorId(ZpusobKomunikaceLektor akreditaceZpusobKomunikaceLektorId) {
        this.akreditaceZpusobKomunikaceLektorId = akreditaceZpusobKomunikaceLektorId;
    }

    public SazbyDph getSazbaDph() {
        return sazbaDph;
    }

    public void setSazbaDph(SazbyDph sazbaDph) {
        this.sazbaDph = sazbaDph;
    }

    public Osoby getHlavniGarant() {
        return hlavniGarant;
    }

    public void setHlavniGarant(Osoby hlavniGarant) {
        this.hlavniGarant = hlavniGarant;
    }

    public Organizace getMistokonaniOrg() {
        return mistokonaniOrg;
    }

    public void setMistokonaniOrg(Organizace mistokonaniOrg) {
        this.mistokonaniOrg = mistokonaniOrg;
    }

    public Obory getObor() {
        return obor;
    }

    public void setObor(Obory obor) {
        this.obor = obor;
    }

    public CasoveJednotky getTypHodiny() {
        return typHodiny;
    }

    public void setTypHodiny(CasoveJednotky typHodiny) {
        this.typHodiny = typHodiny;
    }

    public AkrOblzarJemne getAkrOblzarJemne() {
        return akrOblzarJemne;
    }

    public void setAkrOblzarJemne(AkrOblzarJemne akrOblzarJemne) {
        this.akrOblzarJemne = akrOblzarJemne;
    }

    public AkrOblzarHrube getPrimOblzarHrube() {
        return primOblzarHrube;
    }

    public void setPrimOblzarHrube(AkrOblzarHrube primOblzarHrube) {
        this.primOblzarHrube = primOblzarHrube;
    }

    public AkrFormyAkce getAkrFormaakce() {
        return akrFormaakce;
    }

    public void setAkrFormaakce(AkrFormyAkce akrFormaakce) {
        this.akrFormaakce = akrFormaakce;
    }

    public AkrCiloveSkupiny getPrimCilskupina() {
        return primCilskupina;
    }

    public void setPrimCilskupina(AkrCiloveSkupiny primCilskupina) {
        this.primCilskupina = primCilskupina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akreditaceHlavniPK != null ? akreditaceHlavniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkreditaceHlavni)) {
            return false;
        }
        AkreditaceHlavni other = (AkreditaceHlavni) object;
        if ((this.akreditaceHlavniPK == null && other.akreditaceHlavniPK != null) || (this.akreditaceHlavniPK != null && !this.akreditaceHlavniPK.equals(other.akreditaceHlavniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkreditaceHlavni[ akreditaceHlavniPK=" + akreditaceHlavniPK + " ]";
    }
    
}
