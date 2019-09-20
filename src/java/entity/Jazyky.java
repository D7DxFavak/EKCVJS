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
@Table(name = "jazyky", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jazyky.findAll", query = "SELECT j FROM Jazyky j"),
    @NamedQuery(name = "Jazyky.findByJazykyId", query = "SELECT j FROM Jazyky j WHERE j.jazykyId = :jazykyId"),
    @NamedQuery(name = "Jazyky.findByJazykyNazev", query = "SELECT j FROM Jazyky j WHERE j.jazykyNazev = :jazykyNazev"),
    @NamedQuery(name = "Jazyky.findByJazykyPopis", query = "SELECT j FROM Jazyky j WHERE j.jazykyPopis = :jazykyPopis"),
    @NamedQuery(name = "Jazyky.findByJazykyPrimarni", query = "SELECT j FROM Jazyky j WHERE j.jazykyPrimarni = :jazykyPrimarni"),
    @NamedQuery(name = "Jazyky.findByJazykyPoznamky", query = "SELECT j FROM Jazyky j WHERE j.jazykyPoznamky = :jazykyPoznamky"),
    @NamedQuery(name = "Jazyky.findByJazykyPoradiVyber", query = "SELECT j FROM Jazyky j WHERE j.jazykyPoradiVyber = :jazykyPoradiVyber"),
    @NamedQuery(name = "Jazyky.findByJazyky1tvar", query = "SELECT j FROM Jazyky j WHERE j.jazyky1tvar = :jazyky1tvar")})
public class Jazyky implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "jazyky_id")
    private Integer jazykyId;
    @Size(max = 250)
    @Column(name = "jazyky_nazev")
    private String jazykyNazev;
    @Size(max = 2147483647)
    @Column(name = "jazyky_popis")
    private String jazykyPopis;
    @Column(name = "jazyky_primarni")
    private Boolean jazykyPrimarni;
    @Size(max = 2147483647)
    @Column(name = "jazyky_poznamky")
    private String jazykyPoznamky;
    @Column(name = "jazyky_poradi_vyber")
    private Integer jazykyPoradiVyber;
    @Size(max = 250)
    @Column(name = "jazyky_1tvar")
    private String jazyky1tvar;
    @OneToMany(mappedBy = "oborJazykId")
    private Collection<Obory> oboryCollection;
    @OneToMany(mappedBy = "akceJazykId")
    private Collection<AkceHlavni> akceHlavniCollection;

    public Jazyky() {
    }

    public Jazyky(Integer jazykyId) {
        this.jazykyId = jazykyId;
    }

    public Integer getJazykyId() {
        return jazykyId;
    }

    public void setJazykyId(Integer jazykyId) {
        this.jazykyId = jazykyId;
    }

    public String getJazykyNazev() {
        return jazykyNazev;
    }

    public void setJazykyNazev(String jazykyNazev) {
        this.jazykyNazev = jazykyNazev;
    }

    public String getJazykyPopis() {
        return jazykyPopis;
    }

    public void setJazykyPopis(String jazykyPopis) {
        this.jazykyPopis = jazykyPopis;
    }

    public Boolean getJazykyPrimarni() {
        return jazykyPrimarni;
    }

    public void setJazykyPrimarni(Boolean jazykyPrimarni) {
        this.jazykyPrimarni = jazykyPrimarni;
    }

    public String getJazykyPoznamky() {
        return jazykyPoznamky;
    }

    public void setJazykyPoznamky(String jazykyPoznamky) {
        this.jazykyPoznamky = jazykyPoznamky;
    }

    public Integer getJazykyPoradiVyber() {
        return jazykyPoradiVyber;
    }

    public void setJazykyPoradiVyber(Integer jazykyPoradiVyber) {
        this.jazykyPoradiVyber = jazykyPoradiVyber;
    }

    public String getJazyky1tvar() {
        return jazyky1tvar;
    }

    public void setJazyky1tvar(String jazyky1tvar) {
        this.jazyky1tvar = jazyky1tvar;
    }

    @XmlTransient
    public Collection<Obory> getOboryCollection() {
        return oboryCollection;
    }

    public void setOboryCollection(Collection<Obory> oboryCollection) {
        this.oboryCollection = oboryCollection;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jazykyId != null ? jazykyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jazyky)) {
            return false;
        }
        Jazyky other = (Jazyky) object;
        if ((this.jazykyId == null && other.jazykyId != null) || (this.jazykyId != null && !this.jazykyId.equals(other.jazykyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Jazyky[ jazykyId=" + jazykyId + " ]";
    }
}
