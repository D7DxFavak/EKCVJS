/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "osoby_druhy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsobyDruhy.findAll", query = "SELECT o FROM OsobyDruhy o"),
    @NamedQuery(name = "OsobyDruhy.findByDruhOsobyId", query = "SELECT o FROM OsobyDruhy o WHERE o.druhOsobyId = :druhOsobyId"),
    @NamedQuery(name = "OsobyDruhy.findByNazev", query = "SELECT o FROM OsobyDruhy o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "OsobyDruhy.findByVyzCelejmeno", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzCelejmeno = :vyzCelejmeno"),
    @NamedQuery(name = "OsobyDruhy.findByVyzRodprijmeni", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzRodprijmeni = :vyzRodprijmeni"),
    @NamedQuery(name = "OsobyDruhy.findByVyzRodcislo", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzRodcislo = :vyzRodcislo"),
    @NamedQuery(name = "OsobyDruhy.findByVyzDatumnarozeni", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzDatumnarozeni = :vyzDatumnarozeni"),
    @NamedQuery(name = "OsobyDruhy.findByVyzMistonarozeni", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzMistonarozeni = :vyzMistonarozeni"),
    @NamedQuery(name = "OsobyDruhy.findByVyzCisloop", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzCisloop = :vyzCisloop"),
    @NamedQuery(name = "OsobyDruhy.findByVyzCislopasu", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzCislopasu = :vyzCislopasu"),
    @NamedQuery(name = "OsobyDruhy.findByVyzNarodnost", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzNarodnost = :vyzNarodnost"),
    @NamedQuery(name = "OsobyDruhy.findByVyzStatprislusnost", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzStatprislusnost = :vyzStatprislusnost"),
    @NamedQuery(name = "OsobyDruhy.findByVyzStruczivotopis", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzStruczivotopis = :vyzStruczivotopis"),
    @NamedQuery(name = "OsobyDruhy.findByVyzPlnykontakt", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzPlnykontakt = :vyzPlnykontakt"),
    @NamedQuery(name = "OsobyDruhy.findByVyzRegionokres", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzRegionokres = :vyzRegionokres"),
    @NamedQuery(name = "OsobyDruhy.findByVyzBankkontakt", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzBankkontakt = :vyzBankkontakt"),
    @NamedQuery(name = "OsobyDruhy.findByVyzPrislusnostorg", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzPrislusnostorg = :vyzPrislusnostorg"),
    @NamedQuery(name = "OsobyDruhy.findByVyzOblzar", query = "SELECT o FROM OsobyDruhy o WHERE o.vyzOblzar = :vyzOblzar"),
    @NamedQuery(name = "OsobyDruhy.findByPoznamky", query = "SELECT o FROM OsobyDruhy o WHERE o.poznamky = :poznamky")})
public class OsobyDruhy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "druh_osoby_id")
    private Integer druhOsobyId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_celejmeno")
    private boolean vyzCelejmeno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_rodprijmeni")
    private boolean vyzRodprijmeni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_rodcislo")
    private boolean vyzRodcislo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_datumnarozeni")
    private boolean vyzDatumnarozeni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_mistonarozeni")
    private boolean vyzMistonarozeni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_cisloop")
    private boolean vyzCisloop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_cislopasu")
    private boolean vyzCislopasu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_narodnost")
    private boolean vyzNarodnost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_statprislusnost")
    private boolean vyzStatprislusnost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_struczivotopis")
    private boolean vyzStruczivotopis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_plnykontakt")
    private boolean vyzPlnykontakt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_regionokres")
    private boolean vyzRegionokres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_bankkontakt")
    private boolean vyzBankkontakt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_prislusnostorg")
    private boolean vyzPrislusnostorg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyz_oblzar")
    private boolean vyzOblzar;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osobyDruhy")
    private Collection<OsobyDruhyPrirazeni> osobyDruhyPrirazeniCollection;
    @OneToMany(mappedBy = "druhLektor")
    private Collection<ParametryObecne> parametryObecneCollection;
    @OneToMany(mappedBy = "druhKlient")
    private Collection<ParametryObecne> parametryObecneCollection1;
    @OneToMany(mappedBy = "druhGarant")
    private Collection<ParametryObecne> parametryObecneCollection2;
    @OneToMany(mappedBy = "druhMetodik")
    private Collection<ParametryObecne> parametryObecneCollection3;
    @OneToMany(mappedBy = "druhExtprac")
    private Collection<ParametryObecne> parametryObecneCollection4;

    public OsobyDruhy() {
    }

    public OsobyDruhy(Integer druhOsobyId) {
        this.druhOsobyId = druhOsobyId;
    }

    public OsobyDruhy(Integer druhOsobyId, boolean vyzCelejmeno, boolean vyzRodprijmeni, boolean vyzRodcislo, boolean vyzDatumnarozeni, boolean vyzMistonarozeni, boolean vyzCisloop, boolean vyzCislopasu, boolean vyzNarodnost, boolean vyzStatprislusnost, boolean vyzStruczivotopis, boolean vyzPlnykontakt, boolean vyzRegionokres, boolean vyzBankkontakt, boolean vyzPrislusnostorg, boolean vyzOblzar) {
        this.druhOsobyId = druhOsobyId;
        this.vyzCelejmeno = vyzCelejmeno;
        this.vyzRodprijmeni = vyzRodprijmeni;
        this.vyzRodcislo = vyzRodcislo;
        this.vyzDatumnarozeni = vyzDatumnarozeni;
        this.vyzMistonarozeni = vyzMistonarozeni;
        this.vyzCisloop = vyzCisloop;
        this.vyzCislopasu = vyzCislopasu;
        this.vyzNarodnost = vyzNarodnost;
        this.vyzStatprislusnost = vyzStatprislusnost;
        this.vyzStruczivotopis = vyzStruczivotopis;
        this.vyzPlnykontakt = vyzPlnykontakt;
        this.vyzRegionokres = vyzRegionokres;
        this.vyzBankkontakt = vyzBankkontakt;
        this.vyzPrislusnostorg = vyzPrislusnostorg;
        this.vyzOblzar = vyzOblzar;
    }

    public Integer getDruhOsobyId() {
        return druhOsobyId;
    }

    public void setDruhOsobyId(Integer druhOsobyId) {
        this.druhOsobyId = druhOsobyId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean getVyzCelejmeno() {
        return vyzCelejmeno;
    }

    public void setVyzCelejmeno(boolean vyzCelejmeno) {
        this.vyzCelejmeno = vyzCelejmeno;
    }

    public boolean getVyzRodprijmeni() {
        return vyzRodprijmeni;
    }

    public void setVyzRodprijmeni(boolean vyzRodprijmeni) {
        this.vyzRodprijmeni = vyzRodprijmeni;
    }

    public boolean getVyzRodcislo() {
        return vyzRodcislo;
    }

    public void setVyzRodcislo(boolean vyzRodcislo) {
        this.vyzRodcislo = vyzRodcislo;
    }

    public boolean getVyzDatumnarozeni() {
        return vyzDatumnarozeni;
    }

    public void setVyzDatumnarozeni(boolean vyzDatumnarozeni) {
        this.vyzDatumnarozeni = vyzDatumnarozeni;
    }

    public boolean getVyzMistonarozeni() {
        return vyzMistonarozeni;
    }

    public void setVyzMistonarozeni(boolean vyzMistonarozeni) {
        this.vyzMistonarozeni = vyzMistonarozeni;
    }

    public boolean getVyzCisloop() {
        return vyzCisloop;
    }

    public void setVyzCisloop(boolean vyzCisloop) {
        this.vyzCisloop = vyzCisloop;
    }

    public boolean getVyzCislopasu() {
        return vyzCislopasu;
    }

    public void setVyzCislopasu(boolean vyzCislopasu) {
        this.vyzCislopasu = vyzCislopasu;
    }

    public boolean getVyzNarodnost() {
        return vyzNarodnost;
    }

    public void setVyzNarodnost(boolean vyzNarodnost) {
        this.vyzNarodnost = vyzNarodnost;
    }

    public boolean getVyzStatprislusnost() {
        return vyzStatprislusnost;
    }

    public void setVyzStatprislusnost(boolean vyzStatprislusnost) {
        this.vyzStatprislusnost = vyzStatprislusnost;
    }

    public boolean getVyzStruczivotopis() {
        return vyzStruczivotopis;
    }

    public void setVyzStruczivotopis(boolean vyzStruczivotopis) {
        this.vyzStruczivotopis = vyzStruczivotopis;
    }

    public boolean getVyzPlnykontakt() {
        return vyzPlnykontakt;
    }

    public void setVyzPlnykontakt(boolean vyzPlnykontakt) {
        this.vyzPlnykontakt = vyzPlnykontakt;
    }

    public boolean getVyzRegionokres() {
        return vyzRegionokres;
    }

    public void setVyzRegionokres(boolean vyzRegionokres) {
        this.vyzRegionokres = vyzRegionokres;
    }

    public boolean getVyzBankkontakt() {
        return vyzBankkontakt;
    }

    public void setVyzBankkontakt(boolean vyzBankkontakt) {
        this.vyzBankkontakt = vyzBankkontakt;
    }

    public boolean getVyzPrislusnostorg() {
        return vyzPrislusnostorg;
    }

    public void setVyzPrislusnostorg(boolean vyzPrislusnostorg) {
        this.vyzPrislusnostorg = vyzPrislusnostorg;
    }

    public boolean getVyzOblzar() {
        return vyzOblzar;
    }

    public void setVyzOblzar(boolean vyzOblzar) {
        this.vyzOblzar = vyzOblzar;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
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
    public Collection<ParametryObecne> getParametryObecneCollection2() {
        return parametryObecneCollection2;
    }

    public void setParametryObecneCollection2(Collection<ParametryObecne> parametryObecneCollection2) {
        this.parametryObecneCollection2 = parametryObecneCollection2;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection3() {
        return parametryObecneCollection3;
    }

    public void setParametryObecneCollection3(Collection<ParametryObecne> parametryObecneCollection3) {
        this.parametryObecneCollection3 = parametryObecneCollection3;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection4() {
        return parametryObecneCollection4;
    }

    public void setParametryObecneCollection4(Collection<ParametryObecne> parametryObecneCollection4) {
        this.parametryObecneCollection4 = parametryObecneCollection4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (druhOsobyId != null ? druhOsobyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyDruhy)) {
            return false;
        }
        OsobyDruhy other = (OsobyDruhy) object;
        if ((this.druhOsobyId == null && other.druhOsobyId != null) || (this.druhOsobyId != null && !this.druhOsobyId.equals(other.druhOsobyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OsobyDruhy[ druhOsobyId=" + druhOsobyId + " ]";
    }
    
}
