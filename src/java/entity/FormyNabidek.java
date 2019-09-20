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
@Table(name = "formy_nabidek", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormyNabidek.findAll", query = "SELECT f FROM FormyNabidek f"),
    @NamedQuery(name = "FormyNabidek.findByFormaId", query = "SELECT f FROM FormyNabidek f WHERE f.formaId = :formaId"),
    @NamedQuery(name = "FormyNabidek.findByNazev", query = "SELECT f FROM FormyNabidek f WHERE f.nazev = :nazev"),
    @NamedQuery(name = "FormyNabidek.findByPoznamky", query = "SELECT f FROM FormyNabidek f WHERE f.poznamky = :poznamky")})
public class FormyNabidek implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_id")
    private Integer formaId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formyNabidek")
    private Collection<NabidkyOrganizace> nabidkyOrganizaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formyNabidek")
    private Collection<NabidkyOsoby> nabidkyOsobyCollection;

    public FormyNabidek() {
    }

    public FormyNabidek(Integer formaId) {
        this.formaId = formaId;
    }

    public Integer getFormaId() {
        return formaId;
    }

    public void setFormaId(Integer formaId) {
        this.formaId = formaId;
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
    public Collection<NabidkyOrganizace> getNabidkyOrganizaceCollection() {
        return nabidkyOrganizaceCollection;
    }

    public void setNabidkyOrganizaceCollection(Collection<NabidkyOrganizace> nabidkyOrganizaceCollection) {
        this.nabidkyOrganizaceCollection = nabidkyOrganizaceCollection;
    }

    @XmlTransient
    public Collection<NabidkyOsoby> getNabidkyOsobyCollection() {
        return nabidkyOsobyCollection;
    }

    public void setNabidkyOsobyCollection(Collection<NabidkyOsoby> nabidkyOsobyCollection) {
        this.nabidkyOsobyCollection = nabidkyOsobyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formaId != null ? formaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormyNabidek)) {
            return false;
        }
        FormyNabidek other = (FormyNabidek) object;
        if ((this.formaId == null && other.formaId != null) || (this.formaId != null && !this.formaId.equals(other.formaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FormyNabidek[ formaId=" + formaId + " ]";
    }
    
}
