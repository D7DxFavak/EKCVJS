/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "sazby_dph", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SazbyDph.findAll", query = "SELECT s FROM SazbyDph s"),
    @NamedQuery(name = "SazbyDph.findBySazbaDphId", query = "SELECT s FROM SazbyDph s WHERE s.sazbaDphId = :sazbaDphId"),
    @NamedQuery(name = "SazbyDph.findByNazev", query = "SELECT s FROM SazbyDph s WHERE s.nazev = :nazev"),
    @NamedQuery(name = "SazbyDph.findBySazbaProcent", query = "SELECT s FROM SazbyDph s WHERE s.sazbaProcent = :sazbaProcent"),
    @NamedQuery(name = "SazbyDph.findByPoznamky", query = "SELECT s FROM SazbyDph s WHERE s.poznamky = :poznamky"),
    @NamedQuery(name = "SazbyDph.findByPoradiVyber", query = "SELECT s FROM SazbyDph s WHERE s.poradiVyber = :poradiVyber"),
    @NamedQuery(name = "SazbyDph.findByKoeficient1", query = "SELECT s FROM SazbyDph s WHERE s.koeficient1 = :koeficient1"),
    @NamedQuery(name = "SazbyDph.findByKoeficient2", query = "SELECT s FROM SazbyDph s WHERE s.koeficient2 = :koeficient2")})
public class SazbyDph implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sazba_dph_id")
    private Integer sazbaDphId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sazba_procent")
    private BigDecimal sazbaProcent;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @Column(name = "koeficient1")
    private BigDecimal koeficient1;
    @Column(name = "koeficient2")
    private BigDecimal koeficient2;
    @OneToMany(mappedBy = "sazbaDph")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(mappedBy = "sazbaDph")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;

    public SazbyDph() {
    }

    public SazbyDph(Integer sazbaDphId) {
        this.sazbaDphId = sazbaDphId;
    }

    public Integer getSazbaDphId() {
        return sazbaDphId;
    }

    public void setSazbaDphId(Integer sazbaDphId) {
        this.sazbaDphId = sazbaDphId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public BigDecimal getSazbaProcent() {
        return sazbaProcent;
    }

    public void setSazbaProcent(BigDecimal sazbaProcent) {
        this.sazbaProcent = sazbaProcent;
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

    public BigDecimal getKoeficient1() {
        return koeficient1;
    }

    public void setKoeficient1(BigDecimal koeficient1) {
        this.koeficient1 = koeficient1;
    }

    public BigDecimal getKoeficient2() {
        return koeficient2;
    }

    public void setKoeficient2(BigDecimal koeficient2) {
        this.koeficient2 = koeficient2;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sazbaDphId != null ? sazbaDphId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SazbyDph)) {
            return false;
        }
        SazbyDph other = (SazbyDph) object;
        if ((this.sazbaDphId == null && other.sazbaDphId != null) || (this.sazbaDphId != null && !this.sazbaDphId.equals(other.sazbaDphId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SazbyDph[ sazbaDphId=" + sazbaDphId + " ]";
    }
    
}
