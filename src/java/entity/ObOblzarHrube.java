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
@Table(name = "ob_oblzar_hrube", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObOblzarHrube.findAll", query = "SELECT o FROM ObOblzarHrube o"),
    @NamedQuery(name = "ObOblzarHrube.findByOblzarHrubeId", query = "SELECT o FROM ObOblzarHrube o WHERE o.oblzarHrubeId = :oblzarHrubeId"),
    @NamedQuery(name = "ObOblzarHrube.findByNazev", query = "SELECT o FROM ObOblzarHrube o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "ObOblzarHrube.findByPoznamky", query = "SELECT o FROM ObOblzarHrube o WHERE o.poznamky = :poznamky")})
public class ObOblzarHrube implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obOblzarHrube")
    private Collection<ObOblzarJemne> obOblzarJemneCollection;

    public ObOblzarHrube() {
    }

    public ObOblzarHrube(Integer oblzarHrubeId) {
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
    public Collection<ObOblzarJemne> getObOblzarJemneCollection() {
        return obOblzarJemneCollection;
    }

    public void setObOblzarJemneCollection(Collection<ObOblzarJemne> obOblzarJemneCollection) {
        this.obOblzarJemneCollection = obOblzarJemneCollection;
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
        if (!(object instanceof ObOblzarHrube)) {
            return false;
        }
        ObOblzarHrube other = (ObOblzarHrube) object;
        if ((this.oblzarHrubeId == null && other.oblzarHrubeId != null) || (this.oblzarHrubeId != null && !this.oblzarHrubeId.equals(other.oblzarHrubeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObOblzarHrube[ oblzarHrubeId=" + oblzarHrubeId + " ]";
    }
    
}
