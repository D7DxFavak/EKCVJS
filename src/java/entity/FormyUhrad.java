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
@Table(name = "formy_uhrad", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormyUhrad.findAll", query = "SELECT f FROM FormyUhrad f"),
    @NamedQuery(name = "FormyUhrad.findByFormaUhradyId", query = "SELECT f FROM FormyUhrad f WHERE f.formaUhradyId = :formaUhradyId"),
    @NamedQuery(name = "FormyUhrad.findByNazev", query = "SELECT f FROM FormyUhrad f WHERE f.nazev = :nazev"),
    @NamedQuery(name = "FormyUhrad.findByPoznamky", query = "SELECT f FROM FormyUhrad f WHERE f.poznamky = :poznamky"),
    @NamedQuery(name = "FormyUhrad.findByPoradiVyber", query = "SELECT f FROM FormyUhrad f WHERE f.poradiVyber = :poradiVyber")})
public class FormyUhrad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_uhrady_id")
    private Integer formaUhradyId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @OneToMany(mappedBy = "formaUhrady")
    private Collection<FakturyUhrady> fakturyUhradyCollection;

    public FormyUhrad() {
    }

    public FormyUhrad(Integer formaUhradyId) {
        this.formaUhradyId = formaUhradyId;
    }

    public Integer getFormaUhradyId() {
        return formaUhradyId;
    }

    public void setFormaUhradyId(Integer formaUhradyId) {
        this.formaUhradyId = formaUhradyId;
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

    public Integer getPoradiVyber() {
        return poradiVyber;
    }

    public void setPoradiVyber(Integer poradiVyber) {
        this.poradiVyber = poradiVyber;
    }

    @XmlTransient
    public Collection<FakturyUhrady> getFakturyUhradyCollection() {
        return fakturyUhradyCollection;
    }

    public void setFakturyUhradyCollection(Collection<FakturyUhrady> fakturyUhradyCollection) {
        this.fakturyUhradyCollection = fakturyUhradyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formaUhradyId != null ? formaUhradyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormyUhrad)) {
            return false;
        }
        FormyUhrad other = (FormyUhrad) object;
        if ((this.formaUhradyId == null && other.formaUhradyId != null) || (this.formaUhradyId != null && !this.formaUhradyId.equals(other.formaUhradyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FormyUhrad[ formaUhradyId=" + formaUhradyId + " ]";
    }
    
}
