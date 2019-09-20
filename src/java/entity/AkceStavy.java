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
@Table(name = "akce_stavy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceStavy.findAll", query = "SELECT a FROM AkceStavy a"),
    @NamedQuery(name = "AkceStavy.findByStavAkceId", query = "SELECT a FROM AkceStavy a WHERE a.stavAkceId = :stavAkceId"),
    @NamedQuery(name = "AkceStavy.findByNazev", query = "SELECT a FROM AkceStavy a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceStavy.findByUModprihl", query = "SELECT a FROM AkceStavy a WHERE a.uModprihl = :uModprihl"),
    @NamedQuery(name = "AkceStavy.findByUPridprihl", query = "SELECT a FROM AkceStavy a WHERE a.uPridprihl = :uPridprihl"),
    @NamedQuery(name = "AkceStavy.findByUzavreno", query = "SELECT a FROM AkceStavy a WHERE a.uzavreno = :uzavreno"),    
    @NamedQuery(name = "AkceStavy.findByPoznamky", query = "SELECT a FROM AkceStavy a WHERE a.poznamky = :poznamky")})
public class AkceStavy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "stav_akce_id")
    private Integer stavAkceId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_modprihl")
    private boolean uModprihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_pridprihl")
    private boolean uPridprihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eshop_uzavren")
    private boolean eshopUzavren;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uzavreno")
    private boolean uzavreno;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceStavy")
    private Collection<AkcePrihlStavyVztahy> akcePrihlStavyVztahyCollection;
    @OneToMany(mappedBy = "stavAkce")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(mappedBy = "vychoziStavakce")
    private Collection<ParametryObecne> parametryObecneCollection;

    public AkceStavy() {
    }

    public AkceStavy(Integer stavAkceId) {
        this.stavAkceId = stavAkceId;
    }

    public AkceStavy(Integer stavAkceId, boolean uModprihl, boolean uPridprihl, boolean uzavreno) {
        this.stavAkceId = stavAkceId;
        this.uModprihl = uModprihl;
        this.uPridprihl = uPridprihl;
        this.uzavreno = uzavreno;
    }

    public Integer getStavAkceId() {
        return stavAkceId;
    }

    public void setStavAkceId(Integer stavAkceId) {
        this.stavAkceId = stavAkceId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean getUModprihl() {
        return uModprihl;
    }

    public void setUModprihl(boolean uModprihl) {
        this.uModprihl = uModprihl;
    }

    public boolean getUPridprihl() {
        return uPridprihl;
    }

    public void setUPridprihl(boolean uPridprihl) {
        this.uPridprihl = uPridprihl;
    }

    public boolean getUzavreno() {
        return uzavreno;
    }

    public void setUzavreno(boolean uzavreno) {
        this.uzavreno = uzavreno;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<AkcePrihlStavyVztahy> getAkcePrihlStavyVztahyCollection() {
        return akcePrihlStavyVztahyCollection;
    }

    public void setAkcePrihlStavyVztahyCollection(Collection<AkcePrihlStavyVztahy> akcePrihlStavyVztahyCollection) {
        this.akcePrihlStavyVztahyCollection = akcePrihlStavyVztahyCollection;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection() {
        return parametryObecneCollection;
    }

    public void setParametryObecneCollection(Collection<ParametryObecne> parametryObecneCollection) {
        this.parametryObecneCollection = parametryObecneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavAkceId != null ? stavAkceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceStavy)) {
            return false;
        }
        AkceStavy other = (AkceStavy) object;
        if ((this.stavAkceId == null && other.stavAkceId != null) || (this.stavAkceId != null && !this.stavAkceId.equals(other.stavAkceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceStavy[ stavAkceId=" + stavAkceId + " ]";
    }

    /**
     * @return the eshopUzavren
     */
    public boolean isEshopUzavren() {
        return eshopUzavren;
    }

    /**
     * @param eshopUzavren the eshopUzavren to set
     */
    public void setEshopUzavren(boolean eshopUzavren) {
        this.eshopUzavren = eshopUzavren;
    }
}
