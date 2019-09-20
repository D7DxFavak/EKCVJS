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
@Table(name = "cisla_slovy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CislaSlovy.findAll", query = "SELECT c FROM CislaSlovy c"),
    @NamedQuery(name = "CislaSlovy.findByCislaSlovyId", query = "SELECT c FROM CislaSlovy c WHERE c.cislaSlovyId = :cislaSlovyId"),
    @NamedQuery(name = "CislaSlovy.findByCislaSlovy1tvar", query = "SELECT c FROM CislaSlovy c WHERE c.cislaSlovy1tvar = :cislaSlovy1tvar"),
    @NamedQuery(name = "CislaSlovy.findByCislaSlovy2tvar", query = "SELECT c FROM CislaSlovy c WHERE c.cislaSlovy2tvar = :cislaSlovy2tvar"),
    @NamedQuery(name = "CislaSlovy.findByCislaSlovy3tvar", query = "SELECT c FROM CislaSlovy c WHERE c.cislaSlovy3tvar = :cislaSlovy3tvar"),
    @NamedQuery(name = "CislaSlovy.findByCislaSlovyPoznamky", query = "SELECT c FROM CislaSlovy c WHERE c.cislaSlovyPoznamky = :cislaSlovyPoznamky")})
public class CislaSlovy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cisla_slovy_id")
    private Integer cislaSlovyId;
    @Size(max = 50)
    @Column(name = "cisla_slovy_1tvar")
    private String cislaSlovy1tvar;
    @Size(max = 50)
    @Column(name = "cisla_slovy_2tvar")
    private String cislaSlovy2tvar;
    @Size(max = 50)
    @Column(name = "cisla_slovy_3tvar")
    private String cislaSlovy3tvar;
    @Size(max = 2147483647)
    @Column(name = "cisla_slovy_poznamky")
    private String cislaSlovyPoznamky;
    @OneToMany(mappedBy = "akceJsDetailyDelkaKurzu")
    private Collection<AkceJsDetaily> akceJsDetailyCollection;
    @OneToMany(mappedBy = "akceJsDetailyRocnik")
    private Collection<AkceJsDetaily> akceJsDetailyCollection1;

    public CislaSlovy() {
    }

    public CislaSlovy(Integer cislaSlovyId) {
        this.cislaSlovyId = cislaSlovyId;
    }

    public Integer getCislaSlovyId() {
        return cislaSlovyId;
    }

    public void setCislaSlovyId(Integer cislaSlovyId) {
        this.cislaSlovyId = cislaSlovyId;
    }

    public String getCislaSlovy1tvar() {
        return cislaSlovy1tvar;
    }

    public void setCislaSlovy1tvar(String cislaSlovy1tvar) {
        this.cislaSlovy1tvar = cislaSlovy1tvar;
    }

    public String getCislaSlovy2tvar() {
        return cislaSlovy2tvar;
    }

    public void setCislaSlovy2tvar(String cislaSlovy2tvar) {
        this.cislaSlovy2tvar = cislaSlovy2tvar;
    }

    public String getCislaSlovy3tvar() {
        return cislaSlovy3tvar;
    }

    public void setCislaSlovy3tvar(String cislaSlovy3tvar) {
        this.cislaSlovy3tvar = cislaSlovy3tvar;
    }

    public String getCislaSlovyPoznamky() {
        return cislaSlovyPoznamky;
    }

    public void setCislaSlovyPoznamky(String cislaSlovyPoznamky) {
        this.cislaSlovyPoznamky = cislaSlovyPoznamky;
    }

    @XmlTransient
    public Collection<AkceJsDetaily> getAkceJsDetailyCollection() {
        return akceJsDetailyCollection;
    }

    public void setAkceJsDetailyCollection(Collection<AkceJsDetaily> akceJsDetailyCollection) {
        this.akceJsDetailyCollection = akceJsDetailyCollection;
    }

    @XmlTransient
    public Collection<AkceJsDetaily> getAkceJsDetailyCollection1() {
        return akceJsDetailyCollection1;
    }

    public void setAkceJsDetailyCollection1(Collection<AkceJsDetaily> akceJsDetailyCollection1) {
        this.akceJsDetailyCollection1 = akceJsDetailyCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cislaSlovyId != null ? cislaSlovyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CislaSlovy)) {
            return false;
        }
        CislaSlovy other = (CislaSlovy) object;
        if ((this.cislaSlovyId == null && other.cislaSlovyId != null) || (this.cislaSlovyId != null && !this.cislaSlovyId.equals(other.cislaSlovyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CislaSlovy[ cislaSlovyId=" + cislaSlovyId + " ]";
    }
    
}
