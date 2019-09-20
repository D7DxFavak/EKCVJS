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
@Table(name = "akce_knt", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKnt.findAll", query = "SELECT a FROM AkceKnt a"),
    @NamedQuery(name = "AkceKnt.findByAkceKntId", query = "SELECT a FROM AkceKnt a WHERE a.akceKntId = :akceKntId"),
    @NamedQuery(name = "AkceKnt.findByNazev", query = "SELECT a FROM AkceKnt a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceKnt.findByPoznamky", query = "SELECT a FROM AkceKnt a WHERE a.poznamky = :poznamky")})
public class AkceKnt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_knt_id")
    private Integer akceKntId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKnt")
    private Collection<AkceKnp> akceKnpCollection;

    public AkceKnt() {
    }

    public AkceKnt(Integer akceKntId) {
        this.akceKntId = akceKntId;
    }

    public Integer getAkceKntId() {
        return akceKntId;
    }

    public void setAkceKntId(Integer akceKntId) {
        this.akceKntId = akceKntId;
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
    public Collection<AkceKnp> getAkceKnpCollection() {
        return akceKnpCollection;
    }

    public void setAkceKnpCollection(Collection<AkceKnp> akceKnpCollection) {
        this.akceKnpCollection = akceKnpCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceKntId != null ? akceKntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKnt)) {
            return false;
        }
        AkceKnt other = (AkceKnt) object;
        if ((this.akceKntId == null && other.akceKntId != null) || (this.akceKntId != null && !this.akceKntId.equals(other.akceKntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKnt[ akceKntId=" + akceKntId + " ]";
    }
    
}
