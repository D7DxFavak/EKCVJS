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
@Table(name = "prihlasky_rozpisy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlaskyRozpisy.findAll", query = "SELECT p FROM PrihlaskyRozpisy p"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByPolozka", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.polozka = :polozka"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByCisloprihlOrganizace", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.cisloprihlOrganizace = :cisloprihlOrganizace"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByCisloprihlOsoba", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.cisloprihlOsoba = :cisloprihlOsoba"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByPrihlasenDodatecne", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.prihlasenDodatecne = :prihlasenDodatecne"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByDatumPrihlasen", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.datumPrihlasen = :datumPrihlasen"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByUhrada", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.uhrada = :uhrada"),
    @NamedQuery(name = "PrihlaskyRozpisy.findBySleva", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.sleva = :sleva"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByHotovost", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.hotovost = :hotovost"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByDatumHotovost", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.datumHotovost = :datumHotovost"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByStvrzenka", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.stvrzenka = :stvrzenka"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByDatumPozvan", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.datumPozvan = :datumPozvan"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByDatumPrezence", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.datumPrezence = :datumPrezence"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByZmenaCp", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.zmenaCp = :zmenaCp"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByKdyVlozeno", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByKdyZmeneno", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByKdoVlozil", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByKdoZmenil", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByPoznamky", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.poznamky = :poznamky"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByUbytovani", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.ubytovani = :ubytovani"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByOsoba", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.osoba = :osoba"),
    @NamedQuery(name = "PrihlaskyRozpisy.findDistinctByObjednavatel", query = "SELECT DISTINCT p.osoba FROM PrihlaskyRozpisy p WHERE p.objednavatelOrg = :objednavatelOrg ORDER BY p.osoba.prijmeni"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByOsobaAktivni", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.osoba = :osoba AND p.stavprihl = :stav1 OR p.stavprihl = :stav2"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByMaxId", query = "SELECT p FROM PrihlaskyRozpisy p ORDER BY p.polozka DESC"),
    @NamedQuery(name = "PrihlaskyRozpisy.findByUbytovaniPoznamky", query = "SELECT p FROM PrihlaskyRozpisy p WHERE p.ubytovaniPoznamky = :ubytovaniPoznamky")})
public class PrihlaskyRozpisy implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihlasen_dodatecne")
    private boolean prihlasenDodatecne;
    @Column(name = "datum_prihlasen")
    @Temporal(TemporalType.DATE)
    private Date datumPrihlasen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "uhrada")
    private BigDecimal uhrada;
    @Column(name = "sleva")
    private Integer sleva;
    @Column(name = "hotovost")
    private BigDecimal hotovost;
    @Column(name = "datum_hotovost")
    @Temporal(TemporalType.DATE)
    private Date datumHotovost;
    @Size(max = 50)
    @Column(name = "stvrzenka")
    private String stvrzenka;
    @Column(name = "datum_pozvan")
    @Temporal(TemporalType.DATE)
    private Date datumPozvan;
    @Column(name = "datum_prezence")
    @Temporal(TemporalType.DATE)
    private Date datumPrezence;
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
    @JoinColumn(name = "platce_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace platceOrg;
    @JoinColumn(name = "objednavatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace objednavatelOrg;
    @JoinColumn(name = "odberatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace odberatelOrg;
    @JoinColumn(name = "osoba", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby osoba;
    @JoinColumn(name = "objednavatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby objednavatelOs;
    @JoinColumn(name = "odberatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby odberatelOs;
    @JoinColumn(name = "platce_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby platceOs;
    @JoinColumn(name = "prihlaseni_zpusob", referencedColumnName = "prihlasky_druhy_id")
    @ManyToOne
    private PrihlaskyDruhy prihlaseniZpusob;
    @JoinColumn(name = "stavprihl", referencedColumnName = "stav_prihl_id")
    @ManyToOne
    private StavyPrihlasek stavprihl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisy")
    private Collection<PrihlFakturyRozpisy> prihlFakturyRozpisyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisy")
    private Collection<VyberPrihlaskyFakturace> vyberPrihlaskyFakturaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisy")
    private Collection<VazbaPrihlaskyUlozisteData> vazbaPrihlaskyUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prihlaskyRozpisy")
    private Collection<PrihlAkceRozpisy> prihlAkceRozpisyCollection;

    public PrihlaskyRozpisy() {
    }

    public PrihlaskyRozpisy(Integer polozka) {
        this.polozka = polozka;
    }

    public PrihlaskyRozpisy(Integer polozka, boolean prihlasenDodatecne, boolean zmenaCp) {
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

    public Date getDatumHotovost() {
        return datumHotovost;
    }

    public void setDatumHotovost(Date datumHotovost) {
        this.datumHotovost = datumHotovost;
    }

    public String getStvrzenka() {
        return stvrzenka;
    }

    public void setStvrzenka(String stvrzenka) {
        this.stvrzenka = stvrzenka;
    }

    public Date getDatumPozvan() {
        return datumPozvan;
    }

    public void setDatumPozvan(Date datumPozvan) {
        this.datumPozvan = datumPozvan;
    }

    public Date getDatumPrezence() {
        return datumPrezence;
    }

    public void setDatumPrezence(Date datumPrezence) {
        this.datumPrezence = datumPrezence;
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

    public Organizace getPlatceOrg() {
        return platceOrg;
    }

    public void setPlatceOrg(Organizace platceOrg) {
        this.platceOrg = platceOrg;
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

    public Osoby getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoby osoba) {
        this.osoba = osoba;
    }

    public Osoby getObjednavatelOs() {
        return objednavatelOs;
    }

    public void setObjednavatelOs(Osoby objednavatelOs) {
        this.objednavatelOs = objednavatelOs;
    }

    public Osoby getOdberatelOs() {
        return odberatelOs;
    }

    public void setOdberatelOs(Osoby odberatelOs) {
        this.odberatelOs = odberatelOs;
    }

    public Osoby getPlatceOs() {
        return platceOs;
    }

    public void setPlatceOs(Osoby platceOs) {
        this.platceOs = platceOs;
    }

    public PrihlaskyDruhy getPrihlaseniZpusob() {
        return prihlaseniZpusob;
    }

    public void setPrihlaseniZpusob(PrihlaskyDruhy prihlaseniZpusob) {
        this.prihlaseniZpusob = prihlaseniZpusob;
    }

    public StavyPrihlasek getStavprihl() {
        return stavprihl;
    }

    public void setStavprihl(StavyPrihlasek stavprihl) {
        this.stavprihl = stavprihl;
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
        if (!(object instanceof PrihlaskyRozpisy)) {
            return false;
        }
        PrihlaskyRozpisy other = (PrihlaskyRozpisy) object;
        if ((this.polozka == null && other.polozka != null) || (this.polozka != null && !this.polozka.equals(other.polozka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlaskyRozpisy[ polozka=" + polozka + " ]";
    }   

    @XmlTransient
    public Collection<PrihlFakturyRozpisy> getPrihlFakturyRozpisyCollection() {
        return prihlFakturyRozpisyCollection;
    }

    public void setPrihlFakturyRozpisyCollection(Collection<PrihlFakturyRozpisy> prihlFakturyRozpisyCollection) {
        this.prihlFakturyRozpisyCollection = prihlFakturyRozpisyCollection;
    }

    @XmlTransient
    public Collection<VyberPrihlaskyFakturace> getVyberPrihlaskyFakturaceCollection() {
        return vyberPrihlaskyFakturaceCollection;
    }

    public void setVyberPrihlaskyFakturaceCollection(Collection<VyberPrihlaskyFakturace> vyberPrihlaskyFakturaceCollection) {
        this.vyberPrihlaskyFakturaceCollection = vyberPrihlaskyFakturaceCollection;
    }

    @XmlTransient
    public Collection<VazbaPrihlaskyUlozisteData> getVazbaPrihlaskyUlozisteDataCollection() {
        return vazbaPrihlaskyUlozisteDataCollection;
    }

    public void setVazbaPrihlaskyUlozisteDataCollection(Collection<VazbaPrihlaskyUlozisteData> vazbaPrihlaskyUlozisteDataCollection) {
        this.vazbaPrihlaskyUlozisteDataCollection = vazbaPrihlaskyUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<PrihlAkceRozpisy> getPrihlAkceRozpisyCollection() {
        return prihlAkceRozpisyCollection;
    }

    public void setPrihlAkceRozpisyCollection(Collection<PrihlAkceRozpisy> prihlAkceRozpisyCollection) {
        this.prihlAkceRozpisyCollection = prihlAkceRozpisyCollection;
    }    
}
