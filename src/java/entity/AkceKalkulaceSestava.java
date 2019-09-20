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
@Table(name = "akce_kalkulace_sestava", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKalkulaceSestava.findAll", query = "SELECT a FROM AkceKalkulaceSestava a"),
    @NamedQuery(name = "AkceKalkulaceSestava.findByAkceKalkulaceSestavaId", query = "SELECT a FROM AkceKalkulaceSestava a WHERE a.akceKalkulaceSestavaId = :akceKalkulaceSestavaId"),
    @NamedQuery(name = "AkceKalkulaceSestava.findByAkceKalkulaceSestavaNazev", query = "SELECT a FROM AkceKalkulaceSestava a WHERE a.akceKalkulaceSestavaNazev = :akceKalkulaceSestavaNazev"),
    @NamedQuery(name = "AkceKalkulaceSestava.findByAkceKalkulaceSestavaPoznamky", query = "SELECT a FROM AkceKalkulaceSestava a WHERE a.akceKalkulaceSestavaPoznamky = :akceKalkulaceSestavaPoznamky")})
public class AkceKalkulaceSestava implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_sestava_id")
    private Integer akceKalkulaceSestavaId;
    @Size(max = 250)
    @Column(name = "akce_kalkulace_sestava_nazev")
    private String akceKalkulaceSestavaNazev;
    @Size(max = 2147483647)
    @Column(name = "akce_kalkulace_sestava_poznamky")
    private String akceKalkulaceSestavaPoznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKalkulaceSestava")
    private Collection<AkceKalkulaceVazbaSestava> akceKalkulaceVazbaSestavaCollection;

    public AkceKalkulaceSestava() {
    }

    public AkceKalkulaceSestava(Integer akceKalkulaceSestavaId) {
        this.akceKalkulaceSestavaId = akceKalkulaceSestavaId;
    }

    public Integer getAkceKalkulaceSestavaId() {
        return akceKalkulaceSestavaId;
    }

    public void setAkceKalkulaceSestavaId(Integer akceKalkulaceSestavaId) {
        this.akceKalkulaceSestavaId = akceKalkulaceSestavaId;
    }

    public String getAkceKalkulaceSestavaNazev() {
        return akceKalkulaceSestavaNazev;
    }

    public void setAkceKalkulaceSestavaNazev(String akceKalkulaceSestavaNazev) {
        this.akceKalkulaceSestavaNazev = akceKalkulaceSestavaNazev;
    }

    public String getAkceKalkulaceSestavaPoznamky() {
        return akceKalkulaceSestavaPoznamky;
    }

    public void setAkceKalkulaceSestavaPoznamky(String akceKalkulaceSestavaPoznamky) {
        this.akceKalkulaceSestavaPoznamky = akceKalkulaceSestavaPoznamky;
    }

    @XmlTransient
    public Collection<AkceKalkulaceVazbaSestava> getAkceKalkulaceVazbaSestavaCollection() {
        return akceKalkulaceVazbaSestavaCollection;
    }

    public void setAkceKalkulaceVazbaSestavaCollection(Collection<AkceKalkulaceVazbaSestava> akceKalkulaceVazbaSestavaCollection) {
        this.akceKalkulaceVazbaSestavaCollection = akceKalkulaceVazbaSestavaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceKalkulaceSestavaId != null ? akceKalkulaceSestavaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulaceSestava)) {
            return false;
        }
        AkceKalkulaceSestava other = (AkceKalkulaceSestava) object;
        if ((this.akceKalkulaceSestavaId == null && other.akceKalkulaceSestavaId != null) || (this.akceKalkulaceSestavaId != null && !this.akceKalkulaceSestavaId.equals(other.akceKalkulaceSestavaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulaceSestava[ akceKalkulaceSestavaId=" + akceKalkulaceSestavaId + " ]";
    }
    
}
