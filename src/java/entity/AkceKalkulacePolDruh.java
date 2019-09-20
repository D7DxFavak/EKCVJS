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
@Table(name = "akce_kalkulace_pol_druh", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKalkulacePolDruh.findAll", query = "SELECT a FROM AkceKalkulacePolDruh a"),
    @NamedQuery(name = "AkceKalkulacePolDruh.findByAkceKalkulacePolDruhId", query = "SELECT a FROM AkceKalkulacePolDruh a WHERE a.akceKalkulacePolDruhId = :akceKalkulacePolDruhId"),
    @NamedQuery(name = "AkceKalkulacePolDruh.findByAkceKalkulacePolDruhNazev", query = "SELECT a FROM AkceKalkulacePolDruh a WHERE a.akceKalkulacePolDruhNazev = :akceKalkulacePolDruhNazev"),
    @NamedQuery(name = "AkceKalkulacePolDruh.findByAkceKalkulacePolDruhPoznamky", query = "SELECT a FROM AkceKalkulacePolDruh a WHERE a.akceKalkulacePolDruhPoznamky = :akceKalkulacePolDruhPoznamky"),
    @NamedQuery(name = "AkceKalkulacePolDruh.findByAkceKalkulacePolDruhJeDotace", query = "SELECT a FROM AkceKalkulacePolDruh a WHERE a.akceKalkulacePolDruhJeDotace = :akceKalkulacePolDruhJeDotace")})
public class AkceKalkulacePolDruh implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_pol_druh_id")
    private Integer akceKalkulacePolDruhId;
    @Size(max = 250)
    @Column(name = "akce_kalkulace_pol_druh_nazev")
    private String akceKalkulacePolDruhNazev;
    @Size(max = 2147483647)
    @Column(name = "akce_kalkulace_pol_druh_poznamky")
    private String akceKalkulacePolDruhPoznamky;
    @Column(name = "akce_kalkulace_pol_druh_je_dotace")
    private Boolean akceKalkulacePolDruhJeDotace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKalkulacePolDruh")
    private Collection<AkceKalkulacePol> akceKalkulacePolCollection;

    public AkceKalkulacePolDruh() {
    }

    public AkceKalkulacePolDruh(Integer akceKalkulacePolDruhId) {
        this.akceKalkulacePolDruhId = akceKalkulacePolDruhId;
    }

    public Integer getAkceKalkulacePolDruhId() {
        return akceKalkulacePolDruhId;
    }

    public void setAkceKalkulacePolDruhId(Integer akceKalkulacePolDruhId) {
        this.akceKalkulacePolDruhId = akceKalkulacePolDruhId;
    }

    public String getAkceKalkulacePolDruhNazev() {
        return akceKalkulacePolDruhNazev;
    }

    public void setAkceKalkulacePolDruhNazev(String akceKalkulacePolDruhNazev) {
        this.akceKalkulacePolDruhNazev = akceKalkulacePolDruhNazev;
    }

    public String getAkceKalkulacePolDruhPoznamky() {
        return akceKalkulacePolDruhPoznamky;
    }

    public void setAkceKalkulacePolDruhPoznamky(String akceKalkulacePolDruhPoznamky) {
        this.akceKalkulacePolDruhPoznamky = akceKalkulacePolDruhPoznamky;
    }

    public Boolean getAkceKalkulacePolDruhJeDotace() {
        return akceKalkulacePolDruhJeDotace;
    }

    public void setAkceKalkulacePolDruhJeDotace(Boolean akceKalkulacePolDruhJeDotace) {
        this.akceKalkulacePolDruhJeDotace = akceKalkulacePolDruhJeDotace;
    }

    @XmlTransient
    public Collection<AkceKalkulacePol> getAkceKalkulacePolCollection() {
        return akceKalkulacePolCollection;
    }

    public void setAkceKalkulacePolCollection(Collection<AkceKalkulacePol> akceKalkulacePolCollection) {
        this.akceKalkulacePolCollection = akceKalkulacePolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceKalkulacePolDruhId != null ? akceKalkulacePolDruhId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulacePolDruh)) {
            return false;
        }
        AkceKalkulacePolDruh other = (AkceKalkulacePolDruh) object;
        if ((this.akceKalkulacePolDruhId == null && other.akceKalkulacePolDruhId != null) || (this.akceKalkulacePolDruhId != null && !this.akceKalkulacePolDruhId.equals(other.akceKalkulacePolDruhId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulacePolDruh[ akceKalkulacePolDruhId=" + akceKalkulacePolDruhId + " ]";
    }
    
}
