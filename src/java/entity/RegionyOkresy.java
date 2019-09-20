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
@Table(name = "regiony_okresy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegionyOkresy.findAll", query = "SELECT r FROM RegionyOkresy r"),
    @NamedQuery(name = "RegionyOkresy.findByRoId", query = "SELECT r FROM RegionyOkresy r WHERE r.roId = :roId"),
    @NamedQuery(name = "RegionyOkresy.findByNazev", query = "SELECT r FROM RegionyOkresy r WHERE r.nazev = :nazev"),
    @NamedQuery(name = "RegionyOkresy.findByPoznamky", query = "SELECT r FROM RegionyOkresy r WHERE r.poznamky = :poznamky")})
public class RegionyOkresy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ro_id")
    private Integer roId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(mappedBy = "regionOkres")
    private Collection<OrganizaceDalsiKontakty> organizaceDalsiKontaktyCollection;
    @OneToMany(mappedBy = "regionOkres")
    private Collection<Organizace> organizaceCollection;
    @JoinColumn(name = "uzc_id", referencedColumnName = "uzc_id")
    @ManyToOne
    private UzemnespravniCelky uzcId;
    @OneToMany(mappedBy = "regionOkres")
    private Collection<OsobyDalsiKontakty> osobyDalsiKontaktyCollection;
    @OneToMany(mappedBy = "regionOkres")
    private Collection<Osoby> osobyCollection;

    public RegionyOkresy() {
    }

    public RegionyOkresy(Integer roId) {
        this.roId = roId;
    }

    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
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
    public Collection<OrganizaceDalsiKontakty> getOrganizaceDalsiKontaktyCollection() {
        return organizaceDalsiKontaktyCollection;
    }

    public void setOrganizaceDalsiKontaktyCollection(Collection<OrganizaceDalsiKontakty> organizaceDalsiKontaktyCollection) {
        this.organizaceDalsiKontaktyCollection = organizaceDalsiKontaktyCollection;
    }

    @XmlTransient
    public Collection<Organizace> getOrganizaceCollection() {
        return organizaceCollection;
    }

    public void setOrganizaceCollection(Collection<Organizace> organizaceCollection) {
        this.organizaceCollection = organizaceCollection;
    }

    public UzemnespravniCelky getUzcId() {
        return uzcId;
    }

    public void setUzcId(UzemnespravniCelky uzcId) {
        this.uzcId = uzcId;
    }

    @XmlTransient
    public Collection<OsobyDalsiKontakty> getOsobyDalsiKontaktyCollection() {
        return osobyDalsiKontaktyCollection;
    }

    public void setOsobyDalsiKontaktyCollection(Collection<OsobyDalsiKontakty> osobyDalsiKontaktyCollection) {
        this.osobyDalsiKontaktyCollection = osobyDalsiKontaktyCollection;
    }

    @XmlTransient
    public Collection<Osoby> getOsobyCollection() {
        return osobyCollection;
    }

    public void setOsobyCollection(Collection<Osoby> osobyCollection) {
        this.osobyCollection = osobyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roId != null ? roId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionyOkresy)) {
            return false;
        }
        RegionyOkresy other = (RegionyOkresy) object;
        if ((this.roId == null && other.roId != null) || (this.roId != null && !this.roId.equals(other.roId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RegionyOkresy[ roId=" + roId + " ]";
    }
    
}
