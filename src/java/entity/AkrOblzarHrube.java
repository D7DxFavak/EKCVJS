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
@Table(name = "akr_oblzar_hrube", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrOblzarHrube.findAll", query = "SELECT a FROM AkrOblzarHrube a"),
    @NamedQuery(name = "AkrOblzarHrube.findByOblzarHrubeId", query = "SELECT a FROM AkrOblzarHrube a WHERE a.oblzarHrubeId = :oblzarHrubeId"),
    @NamedQuery(name = "AkrOblzarHrube.findByNazev", query = "SELECT a FROM AkrOblzarHrube a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkrOblzarHrube.findByPoznamky", query = "SELECT a FROM AkrOblzarHrube a WHERE a.poznamky = :poznamky")})
public class AkrOblzarHrube implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "oblzar_hrube_id")
    private Integer oblzarHrubeId;
    @Size(max = 200)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akrOblzarHrube")
    private Collection<AkrOblzarJemne> akrOblzarJemneCollection;
    @OneToMany(mappedBy = "primOblzarHrube")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;

    public AkrOblzarHrube() {
    }

    public AkrOblzarHrube(Integer oblzarHrubeId) {
        this.oblzarHrubeId = oblzarHrubeId;
    }

    public Integer getOblzarHrubeId() {
        return oblzarHrubeId;
    }

    public void setOblzarHrubeId(Integer oblzarHrubeId) {
        this.oblzarHrubeId = oblzarHrubeId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<AkrOblzarJemne> getAkrOblzarJemneCollection() {
        return akrOblzarJemneCollection;
    }

    public void setAkrOblzarJemneCollection(Collection<AkrOblzarJemne> akrOblzarJemneCollection) {
        this.akrOblzarJemneCollection = akrOblzarJemneCollection;
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
        hash += (oblzarHrubeId != null ? oblzarHrubeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrOblzarHrube)) {
            return false;
        }
        AkrOblzarHrube other = (AkrOblzarHrube) object;
        if ((this.oblzarHrubeId == null && other.oblzarHrubeId != null) || (this.oblzarHrubeId != null && !this.oblzarHrubeId.equals(other.oblzarHrubeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrOblzarHrube[ oblzarHrubeId=" + oblzarHrubeId + " ]";
    }
    
}
