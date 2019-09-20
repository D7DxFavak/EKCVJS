/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Transient;
import java.io.Serializable;
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
@Table(name = "osoby", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoby.findAll", query = "SELECT o FROM Osoby o"),
    @NamedQuery(name = "Osoby.findByOsobaId", query = "SELECT o FROM Osoby o WHERE o.osobaId = :osobaId"),
    @NamedQuery(name = "Osoby.findByMaxId", query = "SELECT o FROM Osoby o ORDER BY o.osobaId DESC"),
    @NamedQuery(name = "Osoby.findByTitulPred", query = "SELECT o FROM Osoby o WHERE o.titulPred = :titulPred"),
    @NamedQuery(name = "Osoby.findByJmeno", query = "SELECT o FROM Osoby o WHERE o.jmeno = :jmeno"),
    @NamedQuery(name = "Osoby.findByPrijmeni", query = "SELECT o FROM Osoby o WHERE o.prijmeni = :prijmeni"),
    @NamedQuery(name = "Osoby.findByCeleJmeno", query = "SELECT o FROM Osoby o WHERE o.celeJmeno = :celeJmeno"),
    @NamedQuery(name = "Osoby.findByRodnePrijmeni", query = "SELECT o FROM Osoby o WHERE o.rodnePrijmeni = :rodnePrijmeni"),
    @NamedQuery(name = "Osoby.findByRodneCislo", query = "SELECT o FROM Osoby o WHERE o.rodneCislo = :rodneCislo"),
    @NamedQuery(name = "Osoby.findByDatumNarozeni", query = "SELECT o FROM Osoby o WHERE o.datumNarozeni = :datumNarozeni"),
    @NamedQuery(name = "Osoby.findByMistoNarozeni", query = "SELECT o FROM Osoby o WHERE o.mistoNarozeni = :mistoNarozeni"),
    @NamedQuery(name = "Osoby.findByCisloOp", query = "SELECT o FROM Osoby o WHERE o.cisloOp = :cisloOp"),
    @NamedQuery(name = "Osoby.findByCisloPasu", query = "SELECT o FROM Osoby o WHERE o.cisloPasu = :cisloPasu"),
    @NamedQuery(name = "Osoby.findByNarodnost", query = "SELECT o FROM Osoby o WHERE o.narodnost = :narodnost"),
    @NamedQuery(name = "Osoby.findByStatniPrislusnost", query = "SELECT o FROM Osoby o WHERE o.statniPrislusnost = :statniPrislusnost"),
    @NamedQuery(name = "Osoby.findByDodatekOsoby", query = "SELECT o FROM Osoby o WHERE o.dodatekOsoby = :dodatekOsoby"),
    @NamedQuery(name = "Osoby.findByPosilatNabidku", query = "SELECT o FROM Osoby o WHERE o.posilatNabidku = :posilatNabidku"),
    @NamedQuery(name = "Osoby.findByAdresa", query = "SELECT o FROM Osoby o WHERE o.adresa = :adresa"),
    @NamedQuery(name = "Osoby.findByMesto", query = "SELECT o FROM Osoby o WHERE o.mesto = :mesto"),
    @NamedQuery(name = "Osoby.findByPsc", query = "SELECT o FROM Osoby o WHERE o.psc = :psc"),
    @NamedQuery(name = "Osoby.findByTelefon", query = "SELECT o FROM Osoby o WHERE o.telefon = :telefon"),
    @NamedQuery(name = "Osoby.findByFax", query = "SELECT o FROM Osoby o WHERE o.fax = :fax"),
    @NamedQuery(name = "Osoby.findByEMail", query = "SELECT o FROM Osoby o WHERE lower(o.eMail) like lower(:eMail)"),
    @NamedQuery(name = "Osoby.findByUrl", query = "SELECT o FROM Osoby o WHERE o.url = :url"),
    @NamedQuery(name = "Osoby.findByBankovniSpojeni", query = "SELECT o FROM Osoby o WHERE o.bankovniSpojeni = :bankovniSpojeni"),
    @NamedQuery(name = "Osoby.findByCisloUctu", query = "SELECT o FROM Osoby o WHERE o.cisloUctu = :cisloUctu"),
    @NamedQuery(name = "Osoby.findByKdyVlozeno", query = "SELECT o FROM Osoby o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "Osoby.findByKdyZmeneno", query = "SELECT o FROM Osoby o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "Osoby.findByKdoVlozil", query = "SELECT o FROM Osoby o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "Osoby.findByKdoZmenil", query = "SELECT o FROM Osoby o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "Osoby.findByPoznamky", query = "SELECT o FROM Osoby o WHERE o.poznamky = :poznamky"),
    @NamedQuery(name = "Osoby.findByTitulZa", query = "SELECT o FROM Osoby o WHERE o.titulZa = :titulZa"),
    @NamedQuery(name = "Osoby.findByKodZp", query = "SELECT o FROM Osoby o WHERE o.kodZp = :kodZp")})
public class Osoby implements Serializable {

    /**
     * @return the gdprZpusob
     */
    public int getGdprZpusob() {
        return gdprZpusob;
    }

    /**
     * @param gdprZpusob the gdprZpusob to set
     */
    public void setGdprZpusob(int gdprZpusob) {
        this.gdprZpusob = gdprZpusob;
    }

    /**
     * @return the gdprPoznamka
     */
    public String getGdprPoznamka() {
        return gdprPoznamka;
    }

    /**
     * @param gdprPoznamka the gdprPoznamka to set
     */
    public void setGdprPoznamka(String gdprPoznamka) {
        this.gdprPoznamka = gdprPoznamka;
    }
    @Column(name = "datum_narozeni")
    @Temporal(TemporalType.DATE)
    private Date datumNarozeni;
    @Column(name = "kdy_vlozeno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyVlozeno;
    @Column(name = "kdy_zmeneno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyZmeneno;    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "osoba_id")
    private Integer osobaId;
    @Size(max = 15)
    @Column(name = "titul_pred")
    private String titulPred;
    @Size(max = 30)
    @Column(name = "jmeno")
    private String jmeno;
    @Size(max = 50)
    @Column(name = "prijmeni")
    private String prijmeni;
    @Size(max = 100)
    @Column(name = "cele_jmeno")
    private String celeJmeno;
    @Size(max = 50)
    @Column(name = "rodne_prijmeni")
    private String rodnePrijmeni;
    @Size(max = 12)
    @Column(name = "rodne_cislo")
    private String rodneCislo;
    @Size(max = 100)
    @Column(name = "misto_narozeni")
    private String mistoNarozeni;
    @Size(max = 50)
    @Column(name = "cislo_op")
    private String cisloOp;
    @Size(max = 50)
    @Column(name = "cislo_pasu")
    private String cisloPasu;
    @Size(max = 100)
    @Column(name = "narodnost")
    private String narodnost;
    @Size(max = 100)
    @Column(name = "statni_prislusnost")
    private String statniPrislusnost;
    @Size(max = 2147483647)
    @Column(name = "dodatek_osoby")
    private String dodatekOsoby;
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
     @Size(max = 100)
    @Column(name = "telefon2")
    private String telefon2;
      @Size(max = 100)
    @Column(name = "telefon3")
    private String telefon3;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 400)
    @Column(name = "e_mail")
    private String eMail;
    @Size(max = 400)
    @Column(name = "e_mail2")
    private String eMail2;
    @Size(max = 400)
    @Column(name = "e_mail3")
    private String eMail3;
    @Size(max = 200)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "bankovni_spojeni")
    private String bankovniSpojeni;
    @Size(max = 100)
    @Column(name = "cislo_uctu")
    private String cisloUctu;
    @Size(max = 100)
    @Column(name = "kdo_vlozil")
    private String kdoVlozil;
    @Size(max = 100)
    @Column(name = "kdo_zmenil")
    private String kdoZmenil;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Size(max = 20)
    @Column(name = "titul_za")
    private String titulZa;
    @Size(max = 25)
    @Column(name = "kod_zp")
    private String kodZp;    
    @NotNull
    @Column(name = "gdpr_udeleno")
    private boolean gdprUdeleno;
    @Column(name = "gdpr_zpusob")
    private int gdprZpusob; 
    @Size(max = 100)
    @Column(name = "gdpr_poznamka")
    private String gdprPoznamka;
    
    @OneToMany(mappedBy = "osoba")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @OneToMany(mappedBy = "objednavatelOs")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection1;
    @OneToMany(mappedBy = "odberatelOs")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection2;
    @OneToMany(mappedBy = "platceOs")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection3;
    @OneToMany(mappedBy = "hlavniGarant")
    private Collection<Obory> oboryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<VazbaOsobyUlozisteData> vazbaOsobyUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<AkrLektori> akrLektoriCollection;
    @OneToMany(mappedBy = "odberatelOs")
    private Collection<KnihaFaktur> knihaFakturCollection;
    @OneToMany(mappedBy = "objednavatelOs")
    private Collection<KnihaFaktur> knihaFakturCollection1;
    @OneToMany(mappedBy = "dodavatelOs")
    private Collection<KnihaFaktur> knihaFakturCollection2;
    @OneToMany(mappedBy = "platceOs")
    private Collection<KnihaFaktur> knihaFakturCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<OsobyOrganizace> osobyOrganizaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<OsobyDruhyPrirazeni> osobyDruhyPrirazeniCollection;
    @OneToMany(mappedBy = "dodavatelOs")
    private Collection<ParametryObecne> parametryObecneCollection;
    @OneToMany(mappedBy = "uzivatelOs")
    private Collection<ParametryObecne> parametryObecneCollection1;
    @OneToMany(mappedBy = "odberatelOs")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;
    @OneToMany(mappedBy = "osoba")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection1;
    @OneToMany(mappedBy = "platceOs")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection2;
    @OneToMany(mappedBy = "objednavatelOs")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<OboryMetodickySbor> oboryMetodickySborCollection;
    @OneToMany(mappedBy = "osobaId")
    private Collection<OsobyDalsiKontakty> osobyDalsiKontaktyCollection;
    @JoinColumn(name = "region_okres", referencedColumnName = "ro_id")
    @ManyToOne
    private RegionyOkresy regionOkres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<NabidkyOsoby> nabidkyOsobyCollection;
    @OneToMany(mappedBy = "webAktualityVlozil")
    private Collection<WebAktuality> webAktualityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vazbaOsobaId")
    private Collection<VazbaOsobyLogin> vazbaOsobyLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<AkceLektori> akceLektoriCollection;
    @OneToMany(mappedBy = "hlavniGarant")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;
    @OneToMany(mappedBy = "uzivateleOsobyId")
    private Collection<Uzivatele> uzivateleCollection;
    @Transient
    private boolean vyber;
    public Osoby() {
        this.gdprUdeleno = false;
        this.gdprZpusob = 50;
    }

    public Osoby(Integer osobaId) {
        this.osobaId = osobaId;
    }

    public Osoby(Integer osobaId, boolean posilatNabidku) {
        this.osobaId = osobaId;
        this.posilatNabidku = posilatNabidku;
    }

    public Integer getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(Integer osobaId) {
        this.osobaId = osobaId;
    }

    public String getTitulPred() {
        return titulPred;
    }

    public void setTitulPred(String titulPred) {
        this.titulPred = titulPred;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getRodnePrijmeni() {
        return rodnePrijmeni;
    }

    public void setRodnePrijmeni(String rodnePrijmeni) {
        this.rodnePrijmeni = rodnePrijmeni;
    }

    public String getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

    public Date getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(Date datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getMistoNarozeni() {
        return mistoNarozeni;
    }

    public void setMistoNarozeni(String mistoNarozeni) {
        this.mistoNarozeni = mistoNarozeni;
    }

    public String getCisloOp() {
        return cisloOp;
    }

    public void setCisloOp(String cisloOp) {
        this.cisloOp = cisloOp;
    }

    public String getCisloPasu() {
        return cisloPasu;
    }

    public void setCisloPasu(String cisloPasu) {
        this.cisloPasu = cisloPasu;
    }

    public String getNarodnost() {
        return narodnost;
    }

    public void setNarodnost(String narodnost) {
        this.narodnost = narodnost;
    }

    public String getStatniPrislusnost() {
        return statniPrislusnost;
    }

    public void setStatniPrislusnost(String statniPrislusnost) {
        this.statniPrislusnost = statniPrislusnost;
    }

    public String getDodatekOsoby() {
        return dodatekOsoby;
    }

    public void setDodatekOsoby(String dodatekOsoby) {
        this.dodatekOsoby = dodatekOsoby;
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

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public String getTitulZa() {
        return titulZa;
    }

    public void setTitulZa(String titulZa) {
        this.titulZa = titulZa;
    }

    public String getKodZp() {
        return kodZp;
    }

    public void setKodZp(String kodZp) {
        this.kodZp = kodZp;
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
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection3() {
        return prihlaskyRozpisyCollection3;
    }

    public void setPrihlaskyRozpisyCollection3(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection3) {
        this.prihlaskyRozpisyCollection3 = prihlaskyRozpisyCollection3;
    }

    @XmlTransient
    public Collection<Obory> getOboryCollection() {
        return oboryCollection;
    }

    public void setOboryCollection(Collection<Obory> oboryCollection) {
        this.oboryCollection = oboryCollection;
    }

    @XmlTransient
    public Collection<VazbaOsobyUlozisteData> getVazbaOsobyUlozisteDataCollection() {
        return vazbaOsobyUlozisteDataCollection;
    }

    public void setVazbaOsobyUlozisteDataCollection(Collection<VazbaOsobyUlozisteData> vazbaOsobyUlozisteDataCollection) {
        this.vazbaOsobyUlozisteDataCollection = vazbaOsobyUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<AkrLektori> getAkrLektoriCollection() {
        return akrLektoriCollection;
    }

    public void setAkrLektoriCollection(Collection<AkrLektori> akrLektoriCollection) {
        this.akrLektoriCollection = akrLektoriCollection;
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
    public Collection<OsobyDruhyPrirazeni> getOsobyDruhyPrirazeniCollection() {
        return osobyDruhyPrirazeniCollection;
    }

    public void setOsobyDruhyPrirazeniCollection(Collection<OsobyDruhyPrirazeni> osobyDruhyPrirazeniCollection) {
        this.osobyDruhyPrirazeniCollection = osobyDruhyPrirazeniCollection;
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
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection3() {
        return prihlaskyRozpisyJsCollection3;
    }

    public void setPrihlaskyRozpisyJsCollection3(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection3) {
        this.prihlaskyRozpisyJsCollection3 = prihlaskyRozpisyJsCollection3;
    }

    @XmlTransient
    public Collection<OboryMetodickySbor> getOboryMetodickySborCollection() {
        return oboryMetodickySborCollection;
    }

    public void setOboryMetodickySborCollection(Collection<OboryMetodickySbor> oboryMetodickySborCollection) {
        this.oboryMetodickySborCollection = oboryMetodickySborCollection;
    }

    @XmlTransient
    public Collection<OsobyDalsiKontakty> getOsobyDalsiKontaktyCollection() {
        return osobyDalsiKontaktyCollection;
    }

    public void setOsobyDalsiKontaktyCollection(Collection<OsobyDalsiKontakty> osobyDalsiKontaktyCollection) {
        this.osobyDalsiKontaktyCollection = osobyDalsiKontaktyCollection;
    }

    public RegionyOkresy getRegionOkres() {
        return regionOkres;
    }

    public void setRegionOkres(RegionyOkresy regionOkres) {
        this.regionOkres = regionOkres;
    }

    @XmlTransient
    public Collection<NabidkyOsoby> getNabidkyOsobyCollection() {
        return nabidkyOsobyCollection;
    }

    public void setNabidkyOsobyCollection(Collection<NabidkyOsoby> nabidkyOsobyCollection) {
        this.nabidkyOsobyCollection = nabidkyOsobyCollection;
    }

    @XmlTransient
    public Collection<WebAktuality> getWebAktualityCollection() {
        return webAktualityCollection;
    }

    public void setWebAktualityCollection(Collection<WebAktuality> webAktualityCollection) {
        this.webAktualityCollection = webAktualityCollection;
    }

    @XmlTransient
    public Collection<VazbaOsobyLogin> getVazbaOsobyLoginCollection() {
        return vazbaOsobyLoginCollection;
    }

    public void setVazbaOsobyLoginCollection(Collection<VazbaOsobyLogin> vazbaOsobyLoginCollection) {
        this.vazbaOsobyLoginCollection = vazbaOsobyLoginCollection;
    }

    @XmlTransient
    public Collection<AkceLektori> getAkceLektoriCollection() {
        return akceLektoriCollection;
    }

    public void setAkceLektoriCollection(Collection<AkceLektori> akceLektoriCollection) {
        this.akceLektoriCollection = akceLektoriCollection;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    @XmlTransient
    public Collection<Uzivatele> getUzivateleCollection() {
        return uzivateleCollection;
    }

    public void setUzivateleCollection(Collection<Uzivatele> uzivateleCollection) {
        this.uzivateleCollection = uzivateleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osobaId != null ? osobaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoby)) {
            return false;
        }
        Osoby other = (Osoby) object;
        if ((this.osobaId == null && other.osobaId != null) || (this.osobaId != null && !this.osobaId.equals(other.osobaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Osoby[ osobaId=" + osobaId + " ]";
    }    

   /**
     * @return the telefon2
     */
    public String getTelefon2() {
        return telefon2;
    }

    /**
     * @param telefon2 the telefon2 to set
     */
    public void setTelefon2(String telefon2) {
        this.telefon2 = telefon2;
    }

    /**
     * @return the telefon3
     */
    public String getTelefon3() {
        return telefon3;
    }

    /**
     * @param telefon3 the telefon3 to set
     */
    public void setTelefon3(String telefon3) {
        this.telefon3 = telefon3;
    }

    /**
     * @return the eMail2
     */
    public String getEmail2() {
        return eMail2;
    }

    /**
     * @param eMail2 the eMail2 to set
     */
    public void setEmail2(String eMail2) {
        this.eMail2 = eMail2;
    }

    /**
     * @return the email3
     */
    public String getEmail3() {
        return eMail3;
    }

    /**
     * @param email3 the email3 to set
     */
    public void setEmail3(String eMail3) {
        this.eMail3 = eMail3;
    }

    /**
     * @return the vyber
     */
    public boolean isVyber() {
        return vyber;
    }

    /**
     * @param vyber the vyber to set
     */
    public void setVyber(boolean vyber) {
        this.vyber = vyber;
    }

    /**
     * @return the gdprUdeleno
     */
    public boolean isGdprUdeleno() {
        return gdprUdeleno;
    }

    /**
     * @param gdprUdeleno the gdprUdeleno to set
     */
    public void setGdprUdeleno(boolean gdprUdeleno) {
        this.gdprUdeleno = gdprUdeleno;
    }
    
}
