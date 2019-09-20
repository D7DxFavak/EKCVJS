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
@Table(name = "casove_jednotky", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoveJednotky.findAll", query = "SELECT c FROM CasoveJednotky c"),
    @NamedQuery(name = "CasoveJednotky.findByCasJednotkaId", query = "SELECT c FROM CasoveJednotky c WHERE c.casJednotkaId = :casJednotkaId"),
    @NamedQuery(name = "CasoveJednotky.findByNazev", query = "SELECT c FROM CasoveJednotky c WHERE c.nazev = :nazev"),
    @NamedQuery(name = "CasoveJednotky.findByDobaTrvaniMin", query = "SELECT c FROM CasoveJednotky c WHERE c.dobaTrvaniMin = :dobaTrvaniMin"),
    @NamedQuery(name = "CasoveJednotky.findByOficialniOznaceni", query = "SELECT c FROM CasoveJednotky c WHERE c.oficialniOznaceni = :oficialniOznaceni"),
    @NamedQuery(name = "CasoveJednotky.findByPoznamky", query = "SELECT c FROM CasoveJednotky c WHERE c.poznamky = :poznamky")})
public class CasoveJednotky implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cas_jednotka_id")
    private Integer casJednotkaId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "doba_trvani_min")
    private Integer dobaTrvaniMin;
    @Size(max = 100)
    @Column(name = "oficialni_oznaceni")
    private String oficialniOznaceni;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(mappedBy = "typHodiny")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(mappedBy = "typHodiny")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;
    @OneToMany(mappedBy = "casJednotka")
    private Collection<Ucebny> ucebnyCollection;

    public CasoveJednotky() {
    }

    public CasoveJednotky(Integer casJednotkaId) {
        this.casJednotkaId = casJednotkaId;
    }

    public Integer getCasJednotkaId() {
        return casJednotkaId;
    }

    public void setCasJednotkaId(Integer casJednotkaId) {
        this.casJednotkaId = casJednotkaId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Integer getDobaTrvaniMin() {
        return dobaTrvaniMin;
    }

    public void setDobaTrvaniMin(Integer dobaTrvaniMin) {
        this.dobaTrvaniMin = dobaTrvaniMin;
    }

    public String getOficialniOznaceni() {
        return oficialniOznaceni;
    }

    public void setOficialniOznaceni(String oficialniOznaceni) {
        this.oficialniOznaceni = oficialniOznaceni;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
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

    @XmlTransient
    public Collection<Ucebny> getUcebnyCollection() {
        return ucebnyCollection;
    }

    public void setUcebnyCollection(Collection<Ucebny> ucebnyCollection) {
        this.ucebnyCollection = ucebnyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casJednotkaId != null ? casJednotkaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoveJednotky)) {
            return false;
        }
        CasoveJednotky other = (CasoveJednotky) object;
        if ((this.casJednotkaId == null && other.casJednotkaId != null) || (this.casJednotkaId != null && !this.casJednotkaId.equals(other.casJednotkaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CasoveJednotky[ casJednotkaId=" + casJednotkaId + " ]";
    }
    
}
