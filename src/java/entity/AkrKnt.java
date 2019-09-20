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
@Table(name = "akr_knt", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrKnt.findAll", query = "SELECT a FROM AkrKnt a"),
    @NamedQuery(name = "AkrKnt.findByAkrKntId", query = "SELECT a FROM AkrKnt a WHERE a.akrKntId = :akrKntId"),
    @NamedQuery(name = "AkrKnt.findByNazev", query = "SELECT a FROM AkrKnt a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkrKnt.findByPoznamky", query = "SELECT a FROM AkrKnt a WHERE a.poznamky = :poznamky")})
public class AkrKnt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_knt_id")
    private Integer akrKntId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akrKnt")
    private Collection<AkrKnp> akrKnpCollection;

    public AkrKnt() {
    }

    public AkrKnt(Integer akrKntId) {
        this.akrKntId = akrKntId;
    }

    public Integer getAkrKntId() {
        return akrKntId;
    }

    public void setAkrKntId(Integer akrKntId) {
        this.akrKntId = akrKntId;
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
    public Collection<AkrKnp> getAkrKnpCollection() {
        return akrKnpCollection;
    }

    public void setAkrKnpCollection(Collection<AkrKnp> akrKnpCollection) {
        this.akrKnpCollection = akrKnpCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrKntId != null ? akrKntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrKnt)) {
            return false;
        }
        AkrKnt other = (AkrKnt) object;
        if ((this.akrKntId == null && other.akrKntId != null) || (this.akrKntId != null && !this.akrKntId.equals(other.akrKntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrKnt[ akrKntId=" + akrKntId + " ]";
    }
    
}
