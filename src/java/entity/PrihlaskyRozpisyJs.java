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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "prihlasky_rozpisy_js", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlaskyRozpisyJs.findAll", query = "SELECT p FROM PrihlaskyRozpisyJs p"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByPolozka", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.polozka = :polozka"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByCisloprihlOrganizace", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.cisloprihlOrganizace = :cisloprihlOrganizace"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByCisloprihlOsoba", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.cisloprihlOsoba = :cisloprihlOsoba"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findBySekundarniJazyk", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.sekundarniJazyk = :sekundarniJazyk"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByProspechPozn", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.prospechPozn = :prospechPozn"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByPrihlasenDodatecne", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.prihlasenDodatecne = :prihlasenDodatecne"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByDatumPrihlasen", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.datumPrihlasen = :datumPrihlasen"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByDatumRezervace", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.datumRezervace = :datumRezervace"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByDatumHotovost", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.datumHotovost = :datumHotovost"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByUhrada", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.uhrada = :uhrada"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findBySleva", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.sleva = :sleva"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByHotovost", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.hotovost = :hotovost"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByStvrzenka", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.stvrzenka = :stvrzenka"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByZmenaCp", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.zmenaCp = :zmenaCp"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByKdyVlozeno", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByKdyZmeneno", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByKdoVlozil", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByKdoZmenil", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByPoznamky", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.poznamky = :poznamky"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByUbytovani", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.ubytovani = :ubytovani"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByOsoba", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.osoba = :osoba"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findDistinctByObjednavatel", query = "SELECT DISTINCT p.osoba FROM PrihlaskyRozpisyJs p WHERE p.objednavatelOrg = :objednavatelOrg ORDER BY p.osoba.prijmeni"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByOsobaAktivni", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.osoba = :osoba AND p.stavprihl = :stav1 OR p.stavprihl = :stav2"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByMaxId", query = "SELECT p FROM PrihlaskyRozpisyJs p ORDER BY p.polozka DESC"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByUbytovaniPoznamky", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.ubytovaniPoznamky = :ubytovaniPoznamky"),
    @NamedQuery(name = "PrihlaskyRozpisyJs.findByJeStudent", query = "SELECT p FROM PrihlaskyRozpisyJs p WHERE p.jeStudent = :jeStudent")})
public class PrihlaskyRozpisyJs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "polozka")
    private Integer polozka;
    @Column(name = "cisloprihl_organizace")
    private Integer cisloprihlOrganizace;
    @Column(name = "cisloprihl_osoba")
    private Integer cisloprihlOsoba;
    @Column(name = "sekundarni_jazyk")
    private Integer sekundarniJazyk;
    @Size(max = 250)
    @Column(name = "prospech_pozn")
    private String prospechPozn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihlasen_dodatecne")
    private boolean prihlasenDodatecne;
    @Column(name = "datum_prihlasen")
    @Temporal(TemporalType.DATE)
    private Date datumPrihlasen;
    @Column(name = "datum_rezervace")
    @Temporal(TemporalType.DATE)
    private Date datumRezervace;
    @Column(name = "datum_hotovost")
    @Temporal(TemporalType.DATE)
    private Date datumHotovost;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "uhrada")
    private BigDecimal uhrada;
    @Column(name = "sleva")
    private Integer sleva;
    @Column(name = "hotovost")
    private BigDecimal hotovost;
    @Size(max = 50)
    @Column(name = "stvrzenka")
    private String stvrzenka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zmena_cp")
    private boolean zmenaCp;
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
    @Column(name = "ubytovani")
    private Boolean ubytovani;
    @Size(max = 2147483647)
    @Column(name = "ubytovani_poznamky")
    private String ubytovaniPoznamky;
    @Column(name = "je_student")
    private Boolean jeStudent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisyJs")
    private KatalogovyList katalogovyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisyJs")
    private Collection<VyberPrihlaskyJsFakturace> vyberPrihlaskyJsFakturaceCollection;
    @JoinColumn(name = "stavprihl", referencedColumnName = "stav_prihl_id")
    @ManyToOne
    private StavyPrihlasek stavprihl;
    @JoinColumn(name = "prospech_1pol", referencedColumnName = "prospech_znamky_id")
    @ManyToOne
    private ProspechZnamky prospech1pol;
    @JoinColumn(name = "prospech_2pol", referencedColumnName = "prospech_znamky_id")
    @ManyToOne
    private ProspechZnamky prospech2pol;
    @JoinColumn(name = "akce", referencedColumnName = "akce_id")
    @ManyToOne
    private AkceHlavni akce;
    @JoinColumn(name = "druhfakt", referencedColumnName = "druh_faktury_id")
    @ManyToOne
    private DruhyFaktur druhfakt;
    @JoinColumn(name = "druhprihl", referencedColumnName = "druh_prihl_id")
    @ManyToOne
    private DruhyPrihlasek druhprihl;
    @JoinColumn(name = "obdobi", referencedColumnName = "obdobi_id")
    @ManyToOne
    private Obdobi obdobi;
    @JoinColumn(name = "objednavatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace objednavatelOrg;
    @JoinColumn(name = "odberatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace odberatelOrg;
    @JoinColumn(name = "platce_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace platceOrg;
    @JoinColumn(name = "odberatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby odberatelOs;
    @JoinColumn(name = "osoba", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby osoba;
    @JoinColumn(name = "platce_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby platceOs;
    @JoinColumn(name = "objednavatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby objednavatelOs;
    @JoinColumn(name = "prihlaseni_zpusob", referencedColumnName = "prihlasky_druhy_id")
    @ManyToOne
    private PrihlaskyDruhy prihlaseniZpusob;
    @JoinColumn(name = "prospech_celk", referencedColumnName = "prospech_znamky_id")
    @ManyToOne
    private ProspechZnamky prospechCelk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisyJs")
    private Collection<PrihlJsFakturyRozpisy> prihlJsFakturyRozpisyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisyJs")
    private Collection<VazbaPrihlaskyJsUlozisteData> vazbaPrihlaskyJsUlozisteDataCollection;

    public PrihlaskyRozpisyJs() {
    }

    public PrihlaskyRozpisyJs(Integer polozka) {
        this.polozka = polozka;
    }

    public PrihlaskyRozpisyJs(Integer polozka, boolean prihlasenDodatecne, boolean zmenaCp) {
        this.polozka = polozka;
        this.prihlasenDodatecne = prihlasenDodatecne;
        this.zmenaCp = zmenaCp;
    }

    public Integer getPolozka() {
        return polozka;
    }

    public void setPolozka(Integer polozka) {
        this.polozka = polozka;
    }

    public Integer getCisloprihlOrganizace() {
        return cisloprihlOrganizace;
    }

    public void setCisloprihlOrganizace(Integer cisloprihlOrganizace) {
        this.cisloprihlOrganizace = cisloprihlOrganizace;
    }

    public Integer getCisloprihlOsoba() {
        return cisloprihlOsoba;
    }

    public void setCisloprihlOsoba(Integer cisloprihlOsoba) {
        this.cisloprihlOsoba = cisloprihlOsoba;
    }

    public Integer getSekundarniJazyk() {
        return sekundarniJazyk;
    }

    public void setSekundarniJazyk(Integer sekundarniJazyk) {
        this.sekundarniJazyk = sekundarniJazyk;
    }

    public String getProspechPozn() {
        return prospechPozn;
    }

    public void setProspechPozn(String prospechPozn) {
        this.prospechPozn = prospechPozn;
    }

    public boolean getPrihlasenDodatecne() {
        return prihlasenDodatecne;
    }

    public void setPrihlasenDodatecne(boolean prihlasenDodatecne) {
        this.prihlasenDodatecne = prihlasenDodatecne;
    }

    public Date getDatumPrihlasen() {
        return datumPrihlasen;
    }

    public void setDatumPrihlasen(Date datumPrihlasen) {
        this.datumPrihlasen = datumPrihlasen;
    }

    public Date getDatumRezervace() {
        return datumRezervace;
    }

    public void setDatumRezervace(Date datumRezervace) {
        this.datumRezervace = datumRezervace;
    }

    public Date getDatumHotovost() {
        return datumHotovost;
    }

    public void setDatumHotovost(Date datumHotovost) {
        this.datumHotovost = datumHotovost;
    }

    public BigDecimal getUhrada() {
        return uhrada;
    }

    public void setUhrada(BigDecimal uhrada) {
        this.uhrada = uhrada;
    }

    public Integer getSleva() {
        return sleva;
    }

    public void setSleva(Integer sleva) {
        this.sleva = sleva;
    }

    public BigDecimal getHotovost() {
        return hotovost;
    }

    public void setHotovost(BigDecimal hotovost) {
        this.hotovost = hotovost;
    }

    public String getStvrzenka() {
        return stvrzenka;
    }

    public void setStvrzenka(String stvrzenka) {
        this.stvrzenka = stvrzenka;
    }

    public boolean getZmenaCp() {
        return zmenaCp;
    }

    public void setZmenaCp(boolean zmenaCp) {
        this.zmenaCp = zmenaCp;
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

    public Boolean getUbytovani() {
        return ubytovani;
    }

    public void setUbytovani(Boolean ubytovani) {
        this.ubytovani = ubytovani;
    }

    public String getUbytovaniPoznamky() {
        return ubytovaniPoznamky;
    }

    public void setUbytovaniPoznamky(String ubytovaniPoznamky) {
        this.ubytovaniPoznamky = ubytovaniPoznamky;
    }

    public Boolean getJeStudent() {
        return jeStudent;
    }

    public void setJeStudent(Boolean jeStudent) {
        this.jeStudent = jeStudent;
    }

    public KatalogovyList getKatalogovyList() {
        return katalogovyList;
    }

    public void setKatalogovyList(KatalogovyList katalogovyList) {
        this.katalogovyList = katalogovyList;
    }

    @XmlTransient
    public Collection<VyberPrihlaskyJsFakturace> getVyberPrihlaskyJsFakturaceCollection() {
        return vyberPrihlaskyJsFakturaceCollection;
    }

    public void setVyberPrihlaskyJsFakturaceCollection(Collection<VyberPrihlaskyJsFakturace> vyberPrihlaskyJsFakturaceCollection) {
        this.vyberPrihlaskyJsFakturaceCollection = vyberPrihlaskyJsFakturaceCollection;
    }

    public StavyPrihlasek getStavprihl() {
        return stavprihl;
    }

    public void setStavprihl(StavyPrihlasek stavprihl) {
        this.stavprihl = stavprihl;
    }

    public ProspechZnamky getProspech1pol() {
        return prospech1pol;
    }

    public void setProspech1pol(ProspechZnamky prospech1pol) {
        this.prospech1pol = prospech1pol;
    }

    public ProspechZnamky getProspech2pol() {
        return prospech2pol;
    }

    public void setProspech2pol(ProspechZnamky prospech2pol) {
        this.prospech2pol = prospech2pol;
    }

    public AkceHlavni getAkce() {
        return akce;
    }

    public void setAkce(AkceHlavni akce) {
        this.akce = akce;
    }

    public DruhyFaktur getDruhfakt() {
        return druhfakt;
    }

    public void setDruhfakt(DruhyFaktur druhfakt) {
        this.druhfakt = druhfakt;
    }

    public DruhyPrihlasek getDruhprihl() {
        return druhprihl;
    }

    public void setDruhprihl(DruhyPrihlasek druhprihl) {
        this.druhprihl = druhprihl;
    }

    public Obdobi getObdobi() {
        return obdobi;
    }

    public void setObdobi(Obdobi obdobi) {
        this.obdobi = obdobi;
    }

    public Organizace getObjednavatelOrg() {
        return objednavatelOrg;
    }

    public void setObjednavatelOrg(Organizace objednavatelOrg) {
        this.objednavatelOrg = objednavatelOrg;
    }

    public Organizace getOdberatelOrg() {
        return odberatelOrg;
    }

    public void setOdberatelOrg(Organizace odberatelOrg) {
        this.odberatelOrg = odberatelOrg;
    }

    public Organizace getPlatceOrg() {
        return platceOrg;
    }

    public void setPlatceOrg(Organizace platceOrg) {
        this.platceOrg = platceOrg;
    }

    public Osoby getOdberatelOs() {
        return odberatelOs;
    }

    public void setOdberatelOs(Osoby odberatelOs) {
        this.odberatelOs = odberatelOs;
    }

    public Osoby getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoby osoba) {
        this.osoba = osoba;
    }

    public Osoby getPlatceOs() {
        return platceOs;
    }

    public void setPlatceOs(Osoby platceOs) {
        this.platceOs = platceOs;
    }

    public Osoby getObjednavatelOs() {
        return objednavatelOs;
    }

    public void setObjednavatelOs(Osoby objednavatelOs) {
        this.objednavatelOs = objednavatelOs;
    }

    public PrihlaskyDruhy getPrihlaseniZpusob() {
        return prihlaseniZpusob;
    }

    public void setPrihlaseniZpusob(PrihlaskyDruhy prihlaseniZpusob) {
        this.prihlaseniZpusob = prihlaseniZpusob;
    }

    public ProspechZnamky getProspechCelk() {
        return prospechCelk;
    }

    public void setProspechCelk(ProspechZnamky prospechCelk) {
        this.prospechCelk = prospechCelk;
    }

    @XmlTransient
    public Collection<PrihlJsFakturyRozpisy> getPrihlJsFakturyRozpisyCollection() {
        return prihlJsFakturyRozpisyCollection;
    }

    public void setPrihlJsFakturyRozpisyCollection(Collection<PrihlJsFakturyRozpisy> prihlJsFakturyRozpisyCollection) {
        this.prihlJsFakturyRozpisyCollection = prihlJsFakturyRozpisyCollection;
    }

    @XmlTransient
    public Collection<VazbaPrihlaskyJsUlozisteData> getVazbaPrihlaskyJsUlozisteDataCollection() {
        return vazbaPrihlaskyJsUlozisteDataCollection;
    }

    public void setVazbaPrihlaskyJsUlozisteDataCollection(Collection<VazbaPrihlaskyJsUlozisteData> vazbaPrihlaskyJsUlozisteDataCollection) {
        this.vazbaPrihlaskyJsUlozisteDataCollection = vazbaPrihlaskyJsUlozisteDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polozka != null ? polozka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlaskyRozpisyJs)) {
            return false;
        }
        PrihlaskyRozpisyJs other = (PrihlaskyRozpisyJs) object;
        if ((this.polozka == null && other.polozka != null) || (this.polozka != null && !this.polozka.equals(other.polozka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlaskyRozpisyJs[ polozka=" + polozka + " ]";
    }
    
}
