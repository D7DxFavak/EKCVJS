/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "uzemnespravni_celky", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UzemnespravniCelky.findAll", query = "SELECT u FROM UzemnespravniCelky u"),
    @NamedQuery(name = "UzemnespravniCelky.findByUzcId", query = "SELECT u FROM UzemnespravniCelky u WHERE u.uzcId = :uzcId"),
    @NamedQuery(name = "UzemnespravniCelky.findByNazev", query = "SELECT u FROM UzemnespravniCelky u WHERE u.nazev = :nazev"),
    @NamedQuery(name = "UzemnespravniCelky.findByPoznamky", query = "SELECT u FROM UzemnespravniCelky u WHERE u.poznamky = :poznamky")})
public class UzemnespravniCelky implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uzc_id")
    private Integer uzcId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(mappedBy = "uzcId")
    private Collection<RegionyOkresy> regionyOkresyCollection;

    public UzemnespravniCelky() {
    }

    public UzemnespravniCelky(Integer uzcId) {
        this.uzcId = uzcId;
    }

    public Integer getUzcId() {
        return uzcId;
    }

    public void setUzcId(Integer uzcId) {
        this.uzcId = uzcId;
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
    public Collection<RegionyOkresy> getRegionyOkresyCollection() {
        return regionyOkresyCollection;
    }

    public void setRegionyOkresyCollection(Collection<RegionyOkresy> regionyOkresyCollection) {
        this.regionyOkresyCollection = regionyOkresyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uzcId != null ? uzcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UzemnespravniCelky)) {
            return false;
        }
        UzemnespravniCelky other = (UzemnespravniCelky) object;
        if ((this.uzcId == null && other.uzcId != null) || (this.uzcId != null && !this.uzcId.equals(other.uzcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UzemnespravniCelky[ uzcId=" + uzcId + " ]";
    }
    
}
