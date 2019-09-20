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
@Table(name = "prospech_znamky", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProspechZnamky.findAll", query = "SELECT p FROM ProspechZnamky p"),
    @NamedQuery(name = "ProspechZnamky.findByProspechZnamkyId", query = "SELECT p FROM ProspechZnamky p WHERE p.prospechZnamkyId = :prospechZnamkyId"),
    @NamedQuery(name = "ProspechZnamky.findByProspechZnamkyNazev", query = "SELECT p FROM ProspechZnamky p WHERE p.prospechZnamkyNazev = :prospechZnamkyNazev"),
    @NamedQuery(name = "ProspechZnamky.findByProspechZnamkyPopis", query = "SELECT p FROM ProspechZnamky p WHERE p.prospechZnamkyPopis = :prospechZnamkyPopis"),
    @NamedQuery(name = "ProspechZnamky.findByProspechZnamkyPoradiVyber", query = "SELECT p FROM ProspechZnamky p WHERE p.prospechZnamkyPoradiVyber = :prospechZnamkyPoradiVyber"),
    @NamedQuery(name = "ProspechZnamky.findByProspechZnamkyPoznamky", query = "SELECT p FROM ProspechZnamky p WHERE p.prospechZnamkyPoznamky = :prospechZnamkyPoznamky")})
public class ProspechZnamky implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prospech_znamky_id")
    private Integer prospechZnamkyId;
    @Size(max = 250)
    @Column(name = "prospech_znamky_nazev")
    private String prospechZnamkyNazev;
    @Size(max = 2147483647)
    @Column(name = "prospech_znamky_popis")
    private String prospechZnamkyPopis;
    @Column(name = "prospech_znamky_poradi_vyber")
    private Integer prospechZnamkyPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "prospech_znamky_poznamky")
    private String prospechZnamkyPoznamky;
    @OneToMany(mappedBy = "prospech1pol")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;
    @OneToMany(mappedBy = "prospech2pol")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection1;
    @OneToMany(mappedBy = "prospechCelk")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection2;

    public ProspechZnamky() {
    }

    public ProspechZnamky(Integer prospechZnamkyId) {
        this.prospechZnamkyId = prospechZnamkyId;
    }

    public Integer getProspechZnamkyId() {
        return prospechZnamkyId;
    }

    public void setProspechZnamkyId(Integer prospechZnamkyId) {
        this.prospechZnamkyId = prospechZnamkyId;
    }

    public String getProspechZnamkyNazev() {
        return prospechZnamkyNazev;
    }

    public void setProspechZnamkyNazev(String prospechZnamkyNazev) {
        this.prospechZnamkyNazev = prospechZnamkyNazev;
    }

    public String getProspechZnamkyPopis() {
        return prospechZnamkyPopis;
    }

    public void setProspechZnamkyPopis(String prospechZnamkyPopis) {
        this.prospechZnamkyPopis = prospechZnamkyPopis;
    }

    public Integer getProspechZnamkyPoradiVyber() {
        return prospechZnamkyPoradiVyber;
    }

    public void setProspechZnamkyPoradiVyber(Integer prospechZnamkyPoradiVyber) {
        this.prospechZnamkyPoradiVyber = prospechZnamkyPoradiVyber;
    }

    public String getProspechZnamkyPoznamky() {
        return prospechZnamkyPoznamky;
    }

    public void setProspechZnamkyPoznamky(String prospechZnamkyPoznamky) {
        this.prospechZnamkyPoznamky = prospechZnamkyPoznamky;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection1() {
        return prihlaskyRozpisyJsCollection1;
    }

    public void setPrihlaskyRozpisyJsCollection1(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection1) {
        this.prihlaskyRozpisyJsCollection1 = prihlaskyRozpisyJsCollection1;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection2() {
        return prihlaskyRozpisyJsCollection2;
    }

    public void setPrihlaskyRozpisyJsCollection2(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection2) {
        this.prihlaskyRozpisyJsCollection2 = prihlaskyRozpisyJsCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prospechZnamkyId != null ? prospechZnamkyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProspechZnamky)) {
            return false;
        }
        ProspechZnamky other = (ProspechZnamky) object;
        if ((this.prospechZnamkyId == null && other.prospechZnamkyId != null) || (this.prospechZnamkyId != null && !this.prospechZnamkyId.equals(other.prospechZnamkyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProspechZnamky[ prospechZnamkyId=" + prospechZnamkyId + " ]";
    }
    
}
