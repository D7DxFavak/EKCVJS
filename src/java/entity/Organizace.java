/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "organizace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizace.findAll", query = "SELECT o FROM Organizace o"),
    @NamedQuery(name = "Organizace.findByMaxId", query = "SELECT o FROM Organizace o ORDER BY o.organizaceId DESC"),
    @NamedQuery(name = "Organizace.findByOrganizaceId", query = "SELECT o FROM Organizace o WHERE o.organizaceId = :organizaceId"),
    @NamedQuery(name = "Organizace.findByNazev", query = "SELECT o FROM Organizace o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "Organizace.findByNazevPlny1", query = "SELECT o FROM Organizace o WHERE o.nazevPlny1 = :nazevPlny1"),
    @NamedQuery(name = "Organizace.findByNazevPlny2", query = "SELECT o FROM Organizace o WHERE o.nazevPlny2 = :nazevPlny2"),
    @NamedQuery(name = "Organizace.findByIzo", query = "SELECT o FROM Organizace o WHERE o.izo = :izo"),
    @NamedQuery(name = "Organizace.findByIco", query = "SELECT o FROM Organizace o WHERE o.ico = :ico"),
    @NamedQuery(name = "Organizace.findByDic", query = "SELECT o FROM Organizace o WHERE o.dic = :dic"),
    @NamedQuery(name = "Organizace.findByNsText", query = "SELECT o FROM Organizace o WHERE o.nsText = :nsText"),
    @NamedQuery(name = "Organizace.findByPosilatNabidku", query = "SELECT o FROM Organizace o WHERE o.posilatNabidku = :posilatNabidku"),
    @NamedQuery(name = "Organizace.findByAdresa", query = "SELECT o FROM Organizace o WHERE o.adresa = :adresa"),
    @NamedQuery(name = "Organizace.findByMesto", query = "SELECT o FROM Organizace o WHERE o.mesto = :mesto"),
    @NamedQuery(name = "Organizace.findByPsc", query = "SELECT o FROM Organizace o WHERE o.psc = :psc"),
    @NamedQuery(name = "Organizace.findByTelefon", query = "SELECT o FROM Organizace o WHERE o.telefon = :telefon"),
    @NamedQuery(name = "Organizace.findByFax", query = "SELECT o FROM Organizace o WHERE o.fax = :fax"),
    @NamedQuery(name = "Organizace.findByEMail", query = "SELECT o FROM Organizace o WHERE lower(o.eMail) like lower(:eMail)"),
    @NamedQuery(name = "Organizace.findByEMailFakturace", query = "SELECT o FROM Organizace o WHERE lower(o.eMailFakturace) like lower(:eMailFakturace)"),
    @NamedQuery(name = "Organizace.findByUrl", query = "SELECT o FROM Organizace o WHERE o.url = :url"),
    @NamedQuery(name = "Organizace.findByBankovniSpojeni", query = "SELECT o FROM Organizace o WHERE o.bankovniSpojeni = :bankovniSpojeni"),
    @NamedQuery(name = "Organizace.findByCisloUctu", query = "SELECT o FROM Organizace o WHERE o.cisloUctu = :cisloUctu"),
    @NamedQuery(name = "Organizace.findByKdyVlozeno", query = "SELECT o FROM Organizace o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "Organizace.findByKdyZmeneno", query = "SELECT o FROM Organizace o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "Organizace.findByKdoVlozil", query = "SELECT o FROM Organizace o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "Organizace.findByKdoZmenil", query = "SELECT o FROM Organizace o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "Organizace.findByPopis", query = "SELECT o FROM Organizace o WHERE o.popis = :popis"),
    @NamedQuery(name = "Organizace.findByPoznamky", query = "SELECT o FROM Organizace o WHERE o.poznamky = :poznamky")})
public class Organizace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizace_id")
    private Integer organizaceId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 50)
    @Column(name = "nazev_plny_1")
    private String nazevPlny1;
    @Size(max = 50)
    @Column(name = "nazev_plny_2")
    private String nazevPlny2;
    @Size(max = 20)
    @Column(name = "izo")
    private String izo;
    @Size(max = 20)
    @Column(name = "ico")
    private String ico;
    @Size(max = 20)
    @Column(name = "dic")
    private String dic;
    @Size(max = 1000)
    @Column(name = "ns_text")
    private String nsText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posilat_nabidku")
    private boolean posilatNabidku;
    @Size(max = 50)
    @Column(name = "adresa")
    private String adresa;
    @Size(max = 50)
    @Column(name = "mesto")
    private String mesto;
    @Size(max = 7)
    @Column(name = "psc")
    private String psc;
    @Size(max = 100)
    @Column(name = "telefon")
    private String telefon;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 400)
    @Column(name = "e_mail")
    private String eMail;
    @Size(max = 200)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "bankovni_spojeni")
    private String bankovniSpojeni;
    @Size(max = 100)
    @Column(name = "cislo_uctu")
    private String cisloUctu;
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
    @Column(name = "popis")
    private String popis;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avizo_email_pozvanky")
    private boolean avizoEmailPozvanky;
    @Size(max = 400)
    @Column(name = "e_mail_fakturace")
    private String eMailFakturace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizace1")
    private Collection<NabidkyOrganizace> nabidkyOrganizaceCollection;
    @OneToMany(mappedBy = "organizaceId")
    private Collection<OrganizaceDalsiKontakty> organizaceDalsiKontaktyCollection;
    @OneToMany(mappedBy = "platceOrg")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @OneToMany(mappedBy = "objednavatelOrg")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection1;
    @OneToMany(mappedBy = "odberatelOrg")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection2;
    @OneToMany(mappedBy = "dodavatelOrg")
    private Collection<KnihaFaktur> knihaFakturCollection;
    @OneToMany(mappedBy = "objednavatelOrg")
    private Collection<KnihaFaktur> knihaFakturCollection1;
    @OneToMany(mappedBy = "platceOrg")
    private Collection<KnihaFaktur> knihaFakturCollection2;
    @OneToMany(mappedBy = "odberatelOrg")
    private Collection<KnihaFaktur> knihaFakturCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizace")
    private Collection<OsobyOrganizace> osobyOrganizaceCollection;
    @OneToMany(mappedBy = "dodavatelOrg")
    private Collection<ParametryObecne> parametryObecneCollection;
    @OneToMany(mappedBy = "uzivatelOrg")
    private Collection<ParametryObecne> parametryObecneCollection1;
    @JoinColumn(name = "region_okres", referencedColumnName = "ro_id")
    @ManyToOne
    private RegionyOkresy regionOkres;
    @OneToMany(mappedBy = "nadrazenySubjekt")
    private Collection<Organizace> organizaceCollection;
    @JoinColumn(name = "nadrazeny_subjekt", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace nadrazenySubjekt;
    @JoinColumn(name = "katorgtyp", referencedColumnName = "katorgtyp_id", insertable = false, updatable = false)
    @ManyToOne
    private KatOrgTypy katorgtyp;
    @JoinColumns({
        @JoinColumn(name = "katorgtyp", referencedColumnName = "katorgtyp_id"),
        @JoinColumn(name = "katorgpol", referencedColumnName = "katorgpol_id")})
    @ManyToOne
    private KatOrgPolozky katOrgPolozky;
    @OneToMany(mappedBy = "objednavatelOrg")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;
    @OneToMany(mappedBy = "odberatelOrg")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection1;
    @OneToMany(mappedBy = "platceOrg")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection2;
    @OneToMany(mappedBy = "organizace")
    private Collection<AkceRozpisy> akceRozpisyCollection;
    @OneToMany(mappedBy = "mistokonaniOrg")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;
    @OneToMany(mappedBy = "umisteniOrg")
    private Collection<Ucebny> ucebnyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizace1")
    private Collection<AkceOrganizace> akceOrganizaceCollection;

    public Organizace() {
    }

    public Organizace(Integer organizaceId) {
        this.organizaceId = organizaceId;
    }

    public Organizace(Integer organizaceId, boolean posilatNabidku) {
        this.organizaceId = organizaceId;
        this.posilatNabidku = posilatNabidku;
    }

    public Integer getOrganizaceId() {
        return organizaceId;
    }

    public void setOrganizaceId(Integer organizaceId) {
        this.organizaceId = organizaceId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getNazevPlny1() {
        return nazevPlny1;
    }

    public void setNazevPlny1(String nazevPlny1) {
        this.nazevPlny1 = nazevPlny1;
    }

    public String getNazevPlny2() {
        return nazevPlny2;
    }

    public void setNazevPlny2(String nazevPlny2) {
        this.nazevPlny2 = nazevPlny2;
    }

    public String getIzo() {
        return izo;
    }

    public void setIzo(String izo) {
        this.izo = izo;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getNsText() {
        return nsText;
    }

    public void setNsText(String nsText) {
        this.nsText = nsText;
    }

    public boolean getPosilatNabidku() {
        return posilatNabidku;
    }

    public void setPosilatNabidku(boolean posilatNabidku) {
        this.posilatNabidku = posilatNabidku;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        if (psc != null) {
            if (psc.length() == 6) {
                this.psc = psc;
            } else if (psc.length() == 5) {
                this.psc = psc.substring(0, 3) + " " + psc.substring(3, 5);
            }
        } else {
            this.psc = null;
        }

    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBankovniSpojeni() {
        return bankovniSpojeni;
    }

    public void setBankovniSpojeni(String bankovniSpojeni) {
        this.bankovniSpojeni = bankovniSpojeni;
    }

    public String getCisloUctu() {
        return cisloUctu;
    }

    public void setCisloUctu(String cisloUctu) {
        this.cisloUctu = cisloUctu;
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

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<NabidkyOrganizace> getNabidkyOrganizaceCollection() {
        return nabidkyOrganizaceCollection;
    }

    public void setNabidkyOrganizaceCollection(Collection<NabidkyOrganizace> nabidkyOrganizaceCollection) {
        this.nabidkyOrganizaceCollection = nabidkyOrganizaceCollection;
    }

    @XmlTransient
    public Collection<OrganizaceDalsiKontakty> getOrganizaceDalsiKontaktyCollection() {
        return organizaceDalsiKontaktyCollection;
    }

    public void setOrganizaceDalsiKontaktyCollection(Collection<OrganizaceDalsiKontakty> organizaceDalsiKontaktyCollection) {
        this.organizaceDalsiKontaktyCollection = organizaceDalsiKontaktyCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection() {
        return prihlaskyRozpisyCollection;
    }

    public void setPrihlaskyRozpisyCollection(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection) {
        this.prihlaskyRozpisyCollection = prihlaskyRozpisyCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection1() {
        return prihlaskyRozpisyCollection1;
    }

    public void setPrihlaskyRozpisyCollection1(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection1) {
        this.prihlaskyRozpisyCollection1 = prihlaskyRozpisyCollection1;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection2() {
        return prihlaskyRozpisyCollection2;
    }

    public void setPrihlaskyRozpisyCollection2(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection2) {
        this.prihlaskyRozpisyCollection2 = prihlaskyRozpisyCollection2;
    }

    @XmlTransient
    public Collection<KnihaFaktur> getKnihaFakturCollection() {
        return knihaFakturCollection;
    }

    public void setKnihaFakturCollection(Collection<KnihaFaktur> knihaFakturCollection) {
        this.knihaFakturCollection = knihaFakturCollection;
    }

    @XmlTransient
    public Collection<KnihaFaktur> getKnihaFakturCollection1() {
        return knihaFakturCollection1;
    }

    public void setKnihaFakturCollection1(Collection<KnihaFaktur> knihaFakturCollection1) {
        this.knihaFakturCollection1 = knihaFakturCollection1;
    }

    @XmlTransient
    public Collection<KnihaFaktur> getKnihaFakturCollection2() {
        return knihaFakturCollection2;
    }

    public void setKnihaFakturCollection2(Collection<KnihaFaktur> knihaFakturCollection2) {
        this.knihaFakturCollection2 = knihaFakturCollection2;
    }

    @XmlTransient
    public Collection<KnihaFaktur> getKnihaFakturCollection3() {
        return knihaFakturCollection3;
    }

    public void setKnihaFakturCollection3(Collection<KnihaFaktur> knihaFakturCollection3) {
        this.knihaFakturCollection3 = knihaFakturCollection3;
    }

    @XmlTransient
    public Collection<OsobyOrganizace> getOsobyOrganizaceCollection() {
        return osobyOrganizaceCollection;
    }

    public void setOsobyOrganizaceCollection(Collection<OsobyOrganizace> osobyOrganizaceCollection) {
        this.osobyOrganizaceCollection = osobyOrganizaceCollection;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection() {
        return parametryObecneCollection;
    }

    public void setParametryObecneCollection(Collection<ParametryObecne> parametryObecneCollection) {
        this.parametryObecneCollection = parametryObecneCollection;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection1() {
        return parametryObecneCollection1;
    }

    public void setParametryObecneCollection1(Collection<ParametryObecne> parametryObecneCollection1) {
        this.parametryObecneCollection1 = parametryObecneCollection1;
    }

    public RegionyOkresy getRegionOkres() {
        return regionOkres;
    }

    public void setRegionOkres(RegionyOkresy regionOkres) {
        this.regionOkres = regionOkres;
    }

    @XmlTransient
    public Collection<Organizace> getOrganizaceCollection() {
        return organizaceCollection;
    }

    public void setOrganizaceCollection(Collection<Organizace> organizaceCollection) {
        this.organizaceCollection = organizaceCollection;
    }

    public Organizace getNadrazenySubjekt() {
        return nadrazenySubjekt;
    }

    public void setNadrazenySubjekt(Organizace nadrazenySubjekt) {
        this.nadrazenySubjekt = nadrazenySubjekt;
    }

    public KatOrgTypy getKatorgtyp() {
        return katorgtyp;
    }

    public void setKatorgtyp(KatOrgTypy katorgtyp) {
        this.katorgtyp = katorgtyp;
    }

    public KatOrgPolozky getKatOrgPolozky() {
        return katOrgPolozky;
    }

    public void setKatOrgPolozky(KatOrgPolozky katOrgPolozky) {
        this.katOrgPolozky = katOrgPolozky;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection1() {
        return prihlaskyRozpisyJsCollection1;
    }

    public void setPrihlaskyRozpisyJsCollection1(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection1) {
        this.prihlaskyRozpisyJsCollection1 = prihlaskyRozpisyJsCollection1;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection2() {
        return prihlaskyRozpisyJsCollection2;
    }

    public void setPrihlaskyRozpisyJsCollection2(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection2) {
        this.prihlaskyRozpisyJsCollection2 = prihlaskyRozpisyJsCollection2;
    }

    @XmlTransient
    public Collection<AkceRozpisy> getAkceRozpisyCollection() {
        return akceRozpisyCollection;
    }

    public void setAkceRozpisyCollection(Collection<AkceRozpisy> akceRozpisyCollection) {
        this.akceRozpisyCollection = akceRozpisyCollection;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    @XmlTransient
    public Collection<Ucebny> getUcebnyCollection() {
        return ucebnyCollection;
    }

    public void setUcebnyCollection(Collection<Ucebny> ucebnyCollection) {
        this.ucebnyCollection = ucebnyCollection;
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
        hash += (organizaceId != null ? organizaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizace)) {
            return false;
        }
        Organizace other = (Organizace) object;
        if ((this.organizaceId == null && other.organizaceId != null) || (this.organizaceId != null && !this.organizaceId.equals(other.organizaceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Organizace[ organizaceId=" + organizaceId + " ]";
    }

    /**
     * @return the avizoEmailPozvanky
     */
    public boolean isAvizoEmailPozvanky() {
        return avizoEmailPozvanky;
    }

    /**
     * @param avizoEmailPozvanky the avizoEmailPozvanky to set
     */
    public void setAvizoEmailPozvanky(boolean avizoEmailPozvanky) {
        this.avizoEmailPozvanky = avizoEmailPozvanky;
    }

    /**
     * @return the eMailFakturace
     */
    public String geteMailFakturace() {
        return eMailFakturace;
    }

    /**
     * @param eMailFakturace the eMailFakturace to set
     */
    public void seteMailFakturace(String eMailFakturace) {
        this.eMailFakturace = eMailFakturace;
    }
}
