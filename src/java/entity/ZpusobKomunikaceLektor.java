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
@Table(name = "zpusob_komunikace_lektor", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZpusobKomunikaceLektor.findAll", query = "SELECT z FROM ZpusobKomunikaceLektor z"),
    @NamedQuery(name = "ZpusobKomunikaceLektor.findByZpusobKomunikaceLektorId", query = "SELECT z FROM ZpusobKomunikaceLektor z WHERE z.zpusobKomunikaceLektorId = :zpusobKomunikaceLektorId"),
    @NamedQuery(name = "ZpusobKomunikaceLektor.findByZpusobKomunikaceLektorNazev", query = "SELECT z FROM ZpusobKomunikaceLektor z WHERE z.zpusobKomunikaceLektorNazev = :zpusobKomunikaceLektorNazev"),
    @NamedQuery(name = "ZpusobKomunikaceLektor.findByZpusobKomunikaceLektorPopis", query = "SELECT z FROM ZpusobKomunikaceLektor z WHERE z.zpusobKomunikaceLektorPopis = :zpusobKomunikaceLektorPopis"),
    @NamedQuery(name = "ZpusobKomunikaceLektor.findByZpusobKomunikaceLektorPoradiVyber", query = "SELECT z FROM ZpusobKomunikaceLektor z WHERE z.zpusobKomunikaceLektorPoradiVyber = :zpusobKomunikaceLektorPoradiVyber"),
    @NamedQuery(name = "ZpusobKomunikaceLektor.findByZpusobKomunikaceLektorPoznamky", query = "SELECT z FROM ZpusobKomunikaceLektor z WHERE z.zpusobKomunikaceLektorPoznamky = :zpusobKomunikaceLektorPoznamky")})
public class ZpusobKomunikaceLektor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zpusob_komunikace_lektor_id")
    private Integer zpusobKomunikaceLektorId;
    @Size(max = 250)
    @Column(name = "zpusob_komunikace_lektor_nazev")
    private String zpusobKomunikaceLektorNazev;
    @Size(max = 2147483647)
    @Column(name = "zpusob_komunikace_lektor_popis")
    private String zpusobKomunikaceLektorPopis;
    @Column(name = "zpusob_komunikace_lektor_poradi_vyber")
    private Integer zpusobKomunikaceLektorPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "zpusob_komunikace_lektor_poznamky")
    private String zpusobKomunikaceLektorPoznamky;
    @OneToMany(mappedBy = "akceZpusobKomunikaceLektorId")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(mappedBy = "akreditaceZpusobKomunikaceLektorId")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;

    public ZpusobKomunikaceLektor() {
    }

    public ZpusobKomunikaceLektor(Integer zpusobKomunikaceLektorId) {
        this.zpusobKomunikaceLektorId = zpusobKomunikaceLektorId;
    }

    public Integer getZpusobKomunikaceLektorId() {
        return zpusobKomunikaceLektorId;
    }

    public void setZpusobKomunikaceLektorId(Integer zpusobKomunikaceLektorId) {
        this.zpusobKomunikaceLektorId = zpusobKomunikaceLektorId;
    }

    public String getZpusobKomunikaceLektorNazev() {
        return zpusobKomunikaceLektorNazev;
    }

    public void setZpusobKomunikaceLektorNazev(String zpusobKomunikaceLektorNazev) {
        this.zpusobKomunikaceLektorNazev = zpusobKomunikaceLektorNazev;
    }

    public String getZpusobKomunikaceLektorPopis() {
        return zpusobKomunikaceLektorPopis;
    }

    public void setZpusobKomunikaceLektorPopis(String zpusobKomunikaceLektorPopis) {
        this.zpusobKomunikaceLektorPopis = zpusobKomunikaceLektorPopis;
    }

    public Integer getZpusobKomunikaceLektorPoradiVyber() {
        return zpusobKomunikaceLektorPoradiVyber;
    }

    public void setZpusobKomunikaceLektorPoradiVyber(Integer zpusobKomunikaceLektorPoradiVyber) {
        this.zpusobKomunikaceLektorPoradiVyber = zpusobKomunikaceLektorPoradiVyber;
    }

    public String getZpusobKomunikaceLektorPoznamky() {
        return zpusobKomunikaceLektorPoznamky;
    }

    public void setZpusobKomunikaceLektorPoznamky(String zpusobKomunikaceLektorPoznamky) {
        this.zpusobKomunikaceLektorPoznamky = zpusobKomunikaceLektorPoznamky;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zpusobKomunikaceLektorId != null ? zpusobKomunikaceLektorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZpusobKomunikaceLektor)) {
            return false;
        }
        ZpusobKomunikaceLektor other = (ZpusobKomunikaceLektor) object;
        if ((this.zpusobKomunikaceLektorId == null && other.zpusobKomunikaceLektorId != null) || (this.zpusobKomunikaceLektorId != null && !this.zpusobKomunikaceLektorId.equals(other.zpusobKomunikaceLektorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ZpusobKomunikaceLektor[ zpusobKomunikaceLektorId=" + zpusobKomunikaceLektorId + " ]";
    }
    
}
