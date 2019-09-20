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
@Table(name = "uzivatele", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzivatele.findAll", query = "SELECT u FROM Uzivatele u"),
    @NamedQuery(name = "Uzivatele.findByUzivateleJmeno", query = "SELECT u FROM Uzivatele u WHERE u.uzivateleJmeno = :uzivateleJmeno"),
    @NamedQuery(name = "Uzivatele.findByUzivateleOsobyId", query = "SELECT u FROM Uzivatele u WHERE u.uzivateleOsobyId = :uzivateleOsobyId"),
    @NamedQuery(name = "Uzivatele.findByUzivateleOrganizaceId", query = "SELECT u FROM Uzivatele u WHERE u.uzivateleOrganizaceId = :uzivateleOrganizaceId"),
    @NamedQuery(name = "Uzivatele.findByUzivateleHeslo", query = "SELECT u FROM Uzivatele u WHERE u.uzivateleHeslo = :uzivateleHeslo")})
public class Uzivatele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "uzivatele_jmeno")
    private String uzivateleJmeno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "uzivatele_heslo_sha256")
    private String uzivateleHeslo;
    @JoinColumn(name = "uzivatele_osoby_id", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby uzivateleOsobyId;
    @JoinColumn(name = "uzivatele_organizace_id", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace uzivateleOrganizaceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uzivatele")
    private Collection<Skupina> skupinaCollection;

    public Uzivatele() {
    }

    public Uzivatele(String uzivateleJmeno) {
        this.uzivateleJmeno = uzivateleJmeno;
    }

    public Uzivatele(String uzivateleJmeno, String uzivateleHeslo) {
        this.uzivateleJmeno = uzivateleJmeno;
        this.uzivateleHeslo = uzivateleHeslo;
    }

    public String getUzivateleJmeno() {
        return uzivateleJmeno;
    }

    public void setUzivateleJmeno(String uzivateleJmeno) {
        this.uzivateleJmeno = uzivateleJmeno;
    }

    public String getUzivateleHeslo() {
        return uzivateleHeslo;
    }

    public void setUzivateleHeslo(String uzivateleHeslo) {
        this.uzivateleHeslo = uzivateleHeslo;
    }

    public Osoby getUzivateleOsobyId() {
        return uzivateleOsobyId;
    }

    public void setUzivateleOsobyId(Osoby uzivateleOsobyId) {
        this.uzivateleOsobyId = uzivateleOsobyId;
    }

    @XmlTransient
    public Collection<Skupina> getSkupinaCollection() {
        return skupinaCollection;
    }

    public void setSkupinaCollection(Collection<Skupina> skupinaCollection) {
        this.skupinaCollection = skupinaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uzivateleJmeno != null ? uzivateleJmeno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzivatele)) {
            return false;
        }
        Uzivatele other = (Uzivatele) object;
        if ((this.uzivateleJmeno == null && other.uzivateleJmeno != null) || (this.uzivateleJmeno != null && !this.uzivateleJmeno.equals(other.uzivateleJmeno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Uzivatele[ uzivateleJmeno=" + uzivateleJmeno + " ]";
    }

    /**
     * @return the uzivateleOrganizaceId
     */
    public Organizace getUzivateleOrganizaceId() {
        return uzivateleOrganizaceId;
    }

    /**
     * @param uzivateleOrganizaceId the uzivateleOrganizaceId to set
     */
    public void setUzivateleOrganizaceId(Organizace uzivateleOrganizaceId) {
        this.uzivateleOrganizaceId = uzivateleOrganizaceId;
    }
}
