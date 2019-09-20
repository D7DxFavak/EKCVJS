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
@Table(name = "akce_kalkulace_pol", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKalkulacePol.findAll", query = "SELECT a FROM AkceKalkulacePol a"),
    @NamedQuery(name = "AkceKalkulacePol.findByAkceKalkulacePolId", query = "SELECT a FROM AkceKalkulacePol a WHERE a.akceKalkulacePolId = :akceKalkulacePolId"),
    @NamedQuery(name = "AkceKalkulacePol.findByAkceKalkulacePolNazev", query = "SELECT a FROM AkceKalkulacePol a WHERE a.akceKalkulacePolNazev = :akceKalkulacePolNazev"),
    @NamedQuery(name = "AkceKalkulacePol.findByAkceKalkulacePolPoradi", query = "SELECT a FROM AkceKalkulacePol a WHERE a.akceKalkulacePolPoradi = :akceKalkulacePolPoradi"),
    @NamedQuery(name = "AkceKalkulacePol.findByAkceKalkulacePolPoznamky", query = "SELECT a FROM AkceKalkulacePol a WHERE a.akceKalkulacePolPoznamky = :akceKalkulacePolPoznamky")})
public class AkceKalkulacePol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_pol_id")
    private Integer akceKalkulacePolId;
    @Size(max = 250)
    @Column(name = "akce_kalkulace_pol_nazev")
    private String akceKalkulacePolNazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_pol_poradi")
    private int akceKalkulacePolPoradi;
    @Size(max = 2147483647)
    @Column(name = "akce_kalkulace_pol_poznamky")
    private String akceKalkulacePolPoznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKalkulacePol")
    private Collection<AkceKalkulaceVazbaSestava> akceKalkulaceVazbaSestavaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKalkulacePol")
    private Collection<AkceKalkulace> akceKalkulaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKalkulacePol")
    private Collection<AkceVyuctovani> akceVyuctovaniCollection;
    @JoinColumn(name = "akce_kalkulace_pol_druh", referencedColumnName = "akce_kalkulace_pol_druh_id")
    @ManyToOne(optional = false)
    private AkceKalkulacePolDruh akceKalkulacePolDruh;

    public AkceKalkulacePol() {
    }

    public AkceKalkulacePol(Integer akceKalkulacePolId) {
        this.akceKalkulacePolId = akceKalkulacePolId;
    }

    public AkceKalkulacePol(Integer akceKalkulacePolId, int akceKalkulacePolPoradi) {
        this.akceKalkulacePolId = akceKalkulacePolId;
        this.akceKalkulacePolPoradi = akceKalkulacePolPoradi;
    }

    public Integer getAkceKalkulacePolId() {
        return akceKalkulacePolId;
    }

    public void setAkceKalkulacePolId(Integer akceKalkulacePolId) {
        this.akceKalkulacePolId = akceKalkulacePolId;
    }

    public String getAkceKalkulacePolNazev() {
        return akceKalkulacePolNazev;
    }

    public void setAkceKalkulacePolNazev(String akceKalkulacePolNazev) {
        this.akceKalkulacePolNazev = akceKalkulacePolNazev;
    }

    public int getAkceKalkulacePolPoradi() {
        return akceKalkulacePolPoradi;
    }

    public void setAkceKalkulacePolPoradi(int akceKalkulacePolPoradi) {
        this.akceKalkulacePolPoradi = akceKalkulacePolPoradi;
    }

    public String getAkceKalkulacePolPoznamky() {
        return akceKalkulacePolPoznamky;
    }

    public void setAkceKalkulacePolPoznamky(String akceKalkulacePolPoznamky) {
        this.akceKalkulacePolPoznamky = akceKalkulacePolPoznamky;
    }

    @XmlTransient
    public Collection<AkceKalkulaceVazbaSestava> getAkceKalkulaceVazbaSestavaCollection() {
        return akceKalkulaceVazbaSestavaCollection;
    }

    public void setAkceKalkulaceVazbaSestavaCollection(Collection<AkceKalkulaceVazbaSestava> akceKalkulaceVazbaSestavaCollection) {
        this.akceKalkulaceVazbaSestavaCollection = akceKalkulaceVazbaSestavaCollection;
    }

    @XmlTransient
    public Collection<AkceKalkulace> getAkceKalkulaceCollection() {
        return akceKalkulaceCollection;
    }

    public void setAkceKalkulaceCollection(Collection<AkceKalkulace> akceKalkulaceCollection) {
        this.akceKalkulaceCollection = akceKalkulaceCollection;
    }

    @XmlTransient
    public Collection<AkceVyuctovani> getAkceVyuctovaniCollection() {
        return akceVyuctovaniCollection;
    }

    public void setAkceVyuctovaniCollection(Collection<AkceVyuctovani> akceVyuctovaniCollection) {
        this.akceVyuctovaniCollection = akceVyuctovaniCollection;
    }

    public AkceKalkulacePolDruh getAkceKalkulacePolDruh() {
        return akceKalkulacePolDruh;
    }

    public void setAkceKalkulacePolDruh(AkceKalkulacePolDruh akceKalkulacePolDruh) {
        this.akceKalkulacePolDruh = akceKalkulacePolDruh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceKalkulacePolId != null ? akceKalkulacePolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulacePol)) {
            return false;
        }
        AkceKalkulacePol other = (AkceKalkulacePol) object;
        if ((this.akceKalkulacePolId == null && other.akceKalkulacePolId != null) || (this.akceKalkulacePolId != null && !this.akceKalkulacePolId.equals(other.akceKalkulacePolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulacePol[ akceKalkulacePolId=" + akceKalkulacePolId + " ]";
    }
    
}
