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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "druhy_prihlasek", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DruhyPrihlasek.findAll", query = "SELECT d FROM DruhyPrihlasek d"),
    @NamedQuery(name = "DruhyPrihlasek.findByDruhPrihlId", query = "SELECT d FROM DruhyPrihlasek d WHERE d.druhPrihlId = :druhPrihlId"),
    @NamedQuery(name = "DruhyPrihlasek.findByNazev", query = "SELECT d FROM DruhyPrihlasek d WHERE d.nazev = :nazev"),
    @NamedQuery(name = "DruhyPrihlasek.findBySamoplatce", query = "SELECT d FROM DruhyPrihlasek d WHERE d.samoplatce = :samoplatce"),
    @NamedQuery(name = "DruhyPrihlasek.findByObalkySeskupeni", query = "SELECT d FROM DruhyPrihlasek d WHERE d.obalkySeskupeni = :obalkySeskupeni"),
    @NamedQuery(name = "DruhyPrihlasek.findBySetVychoziDf", query = "SELECT d FROM DruhyPrihlasek d WHERE d.setVychoziDf = :setVychoziDf"),
    @NamedQuery(name = "DruhyPrihlasek.findByPozadDruhprihl", query = "SELECT d FROM DruhyPrihlasek d WHERE d.pozadDruhprihl = :pozadDruhprihl"),
    @NamedQuery(name = "DruhyPrihlasek.findByPoznamky", query = "SELECT d FROM DruhyPrihlasek d WHERE d.poznamky = :poznamky"),
    @NamedQuery(name = "DruhyPrihlasek.findByPoradiVyber", query = "SELECT d FROM DruhyPrihlasek d WHERE d.poradiVyber = :poradiVyber")})
public class DruhyPrihlasek implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "druh_prihl_id")
    private Integer druhPrihlId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "samoplatce")
    private boolean samoplatce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obalky_seskupeni")
    private boolean obalkySeskupeni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_vychozi_df")
    private boolean setVychoziDf;
    @Column(name = "pozad_druhprihl")
    private Integer pozadDruhprihl;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @OneToMany(mappedBy = "druhprihl")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyPrihlasek")
    private Collection<VyberPrihlaskyJsFakturace> vyberPrihlaskyJsFakturaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyPrihlasek")
    private Collection<VyberPrihlaskyFakturace> vyberPrihlaskyFakturaceCollection;
    @OneToMany(mappedBy = "druhprihl")
    private Collection<KnihaFaktur> knihaFakturCollection;
    @OneToMany(mappedBy = "vychoziDp")
    private Collection<ParametryObecne> parametryObecneCollection;
    @OneToMany(mappedBy = "druhprihl")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyPrihlasek")
    private Collection<VyberAkceFakturace> vyberAkceFakturaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyPrihlasek")
    private Collection<StavyDruhyVztahy> stavyDruhyVztahyCollection;
    @JoinColumn(name = "default_stavprihlasky", referencedColumnName = "stav_prihl_id")
    @ManyToOne
    private StavyPrihlasek defaultStavprihlasky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyPrihlasek")
    private Collection<PrihlDruhyStavyFakturace> prihlDruhyStavyFakturaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyPrihlasek")
    private Collection<StavyDruhyFaktVztahy> stavyDruhyFaktVztahyCollection;

    public DruhyPrihlasek() {
    }

    public DruhyPrihlasek(Integer druhPrihlId) {
        this.druhPrihlId = druhPrihlId;
    }

    public DruhyPrihlasek(Integer druhPrihlId, boolean samoplatce, boolean obalkySeskupeni, boolean setVychoziDf) {
        this.druhPrihlId = druhPrihlId;
        this.samoplatce = samoplatce;
        this.obalkySeskupeni = obalkySeskupeni;
        this.setVychoziDf = setVychoziDf;
    }

    public Integer getDruhPrihlId() {
        return druhPrihlId;
    }

    public void setDruhPrihlId(Integer druhPrihlId) {
        this.druhPrihlId = druhPrihlId;
    }

    public String getNazev() {     
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean getSamoplatce() {
        return samoplatce;
    }

    public void setSamoplatce(boolean samoplatce) {
        this.samoplatce = samoplatce;
    }

    public boolean getObalkySeskupeni() {
        return obalkySeskupeni;
    }

    public void setObalkySeskupeni(boolean obalkySeskupeni) {
        this.obalkySeskupeni = obalkySeskupeni;
    }

    public boolean getSetVychoziDf() {
        return setVychoziDf;
    }

    public void setSetVychoziDf(boolean setVychoziDf) {
        this.setVychoziDf = setVychoziDf;
    }

    public Integer getPozadDruhprihl() {
        return pozadDruhprihl;
    }

    public void setPozadDruhprihl(Integer pozadDruhprihl) {
        this.pozadDruhprihl = pozadDruhprihl;
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
    public Collection<VyberPrihlaskyJsFakturace> getVyberPrihlaskyJsFakturaceCollection() {
        return vyberPrihlaskyJsFakturaceCollection;
    }

    public void setVyberPrihlaskyJsFakturaceCollection(Collection<VyberPrihlaskyJsFakturace> vyberPrihlaskyJsFakturaceCollection) {
        this.vyberPrihlaskyJsFakturaceCollection = vyberPrihlaskyJsFakturaceCollection;
    }

    @XmlTransient
    public Collection<VyberPrihlaskyFakturace> getVyberPrihlaskyFakturaceCollection() {
        return vyberPrihlaskyFakturaceCollection;
    }

    public void setVyberPrihlaskyFakturaceCollection(Collection<VyberPrihlaskyFakturace> vyberPrihlaskyFakturaceCollection) {
        this.vyberPrihlaskyFakturaceCollection = vyberPrihlaskyFakturaceCollection;
    }

    @XmlTransient
    public Collection<KnihaFaktur> getKnihaFakturCollection() {
        return knihaFakturCollection;
    }

    public void setKnihaFakturCollection(Collection<KnihaFaktur> knihaFakturCollection) {
        this.knihaFakturCollection = knihaFakturCollection;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection() {
        return parametryObecneCollection;
    }

    public void setParametryObecneCollection(Collection<ParametryObecne> parametryObecneCollection) {
        this.parametryObecneCollection = parametryObecneCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @XmlTransient
    public Collection<VyberAkceFakturace> getVyberAkceFakturaceCollection() {
        return vyberAkceFakturaceCollection;
    }

    public void setVyberAkceFakturaceCollection(Collection<VyberAkceFakturace> vyberAkceFakturaceCollection) {
        this.vyberAkceFakturaceCollection = vyberAkceFakturaceCollection;
    }

    @XmlTransient
    public Collection<StavyDruhyVztahy> getStavyDruhyVztahyCollection() {
        return stavyDruhyVztahyCollection;
    }

    public void setStavyDruhyVztahyCollection(Collection<StavyDruhyVztahy> stavyDruhyVztahyCollection) {
        this.stavyDruhyVztahyCollection = stavyDruhyVztahyCollection;
    }

    public StavyPrihlasek getDefaultStavprihlasky() {
        return defaultStavprihlasky;
    }

    public void setDefaultStavprihlasky(StavyPrihlasek defaultStavprihlasky) {
        this.defaultStavprihlasky = defaultStavprihlasky;
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
        hash += (druhPrihlId != null ? druhPrihlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DruhyPrihlasek)) {
            return false;
        }
        DruhyPrihlasek other = (DruhyPrihlasek) object;
        if ((this.druhPrihlId == null && other.druhPrihlId != null) || (this.druhPrihlId != null && !this.druhPrihlId.equals(other.druhPrihlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DruhyPrihlasek[ druhPrihlId=" + druhPrihlId + " ]";
    }
    
}
