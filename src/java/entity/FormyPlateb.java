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
@Table(name = "formy_plateb", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormyPlateb.findAll", query = "SELECT f FROM FormyPlateb f"),
    @NamedQuery(name = "FormyPlateb.findByFormaPlatbyId", query = "SELECT f FROM FormyPlateb f WHERE f.formaPlatbyId = :formaPlatbyId"),
    @NamedQuery(name = "FormyPlateb.findByNazev", query = "SELECT f FROM FormyPlateb f WHERE f.nazev = :nazev"),
    @NamedQuery(name = "FormyPlateb.findByPoznamky", query = "SELECT f FROM FormyPlateb f WHERE f.poznamky = :poznamky"),
    @NamedQuery(name = "FormyPlateb.findByPoradiVyber", query = "SELECT f FROM FormyPlateb f WHERE f.poradiVyber = :poradiVyber")})
public class FormyPlateb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_platby_id")
    private Integer formaPlatbyId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @OneToMany(mappedBy = "zpusobPlatby")
    private Collection<AkrKalkulaceNaklady> akrKalkulaceNakladyCollection;
    @OneToMany(mappedBy = "defZpusobPlatby")
    private Collection<AkceKnp> akceKnpCollection;
    @OneToMany(mappedBy = "defZpusobPlatby")
    private Collection<AkrKnp> akrKnpCollection;
    @OneToMany(mappedBy = "zpusobPlatby")
    private Collection<AkceKalkulaceNaklady> akceKalkulaceNakladyCollection;

    public FormyPlateb() {
    }

    public FormyPlateb(Integer formaPlatbyId) {
        this.formaPlatbyId = formaPlatbyId;
    }

    public Integer getFormaPlatbyId() {
        return formaPlatbyId;
    }

    public void setFormaPlatbyId(Integer formaPlatbyId) {
        this.formaPlatbyId = formaPlatbyId;
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
    public Collection<AkrKalkulaceNaklady> getAkrKalkulaceNakladyCollection() {
        return akrKalkulaceNakladyCollection;
    }

    public void setAkrKalkulaceNakladyCollection(Collection<AkrKalkulaceNaklady> akrKalkulaceNakladyCollection) {
        this.akrKalkulaceNakladyCollection = akrKalkulaceNakladyCollection;
    }

    @XmlTransient
    public Collection<AkceKnp> getAkceKnpCollection() {
        return akceKnpCollection;
    }

    public void setAkceKnpCollection(Collection<AkceKnp> akceKnpCollection) {
        this.akceKnpCollection = akceKnpCollection;
    }

    @XmlTransient
    public Collection<AkrKnp> getAkrKnpCollection() {
        return akrKnpCollection;
    }

    public void setAkrKnpCollection(Collection<AkrKnp> akrKnpCollection) {
        this.akrKnpCollection = akrKnpCollection;
    }

    @XmlTransient
    public Collection<AkceKalkulaceNaklady> getAkceKalkulaceNakladyCollection() {
        return akceKalkulaceNakladyCollection;
    }

    public void setAkceKalkulaceNakladyCollection(Collection<AkceKalkulaceNaklady> akceKalkulaceNakladyCollection) {
        this.akceKalkulaceNakladyCollection = akceKalkulaceNakladyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formaPlatbyId != null ? formaPlatbyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormyPlateb)) {
            return false;
        }
        FormyPlateb other = (FormyPlateb) object;
        if ((this.formaPlatbyId == null && other.formaPlatbyId != null) || (this.formaPlatbyId != null && !this.formaPlatbyId.equals(other.formaPlatbyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FormyPlateb[ formaPlatbyId=" + formaPlatbyId + " ]";
    }
    
}
