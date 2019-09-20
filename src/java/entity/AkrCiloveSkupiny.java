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
import javax.persistence.OneToOne;
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
@Table(name = "akr_cilove_skupiny", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrCiloveSkupiny.findAll", query = "SELECT a FROM AkrCiloveSkupiny a"),
    @NamedQuery(name = "AkrCiloveSkupiny.findByAkrCilskupId", query = "SELECT a FROM AkrCiloveSkupiny a WHERE a.akrCilskupId = :akrCilskupId"),
    @NamedQuery(name = "AkrCiloveSkupiny.findByNazev", query = "SELECT a FROM AkrCiloveSkupiny a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkrCiloveSkupiny.findByPoznamky", query = "SELECT a FROM AkrCiloveSkupiny a WHERE a.poznamky = :poznamky")})
public class AkrCiloveSkupiny implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_cilskup_id")
    private Integer akrCilskupId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akrCiloveSkupiny")
    private Collection<AkrDalsiCilskup> akrDalsiCilskupCollection;
    @OneToMany(mappedBy = "primCilskupina")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "akrCiloveSkupiny")
    private AkrAkceCilskupVztahy akrAkceCilskupVztahy;

    public AkrCiloveSkupiny() {
    }

    public AkrCiloveSkupiny(Integer akrCilskupId) {
        this.akrCilskupId = akrCilskupId;
    }

    public Integer getAkrCilskupId() {
        return akrCilskupId;
    }

    public void setAkrCilskupId(Integer akrCilskupId) {
        this.akrCilskupId = akrCilskupId;
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
    public Collection<AkrDalsiCilskup> getAkrDalsiCilskupCollection() {
        return akrDalsiCilskupCollection;
    }

    public void setAkrDalsiCilskupCollection(Collection<AkrDalsiCilskup> akrDalsiCilskupCollection) {
        this.akrDalsiCilskupCollection = akrDalsiCilskupCollection;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    public AkrAkceCilskupVztahy getAkrAkceCilskupVztahy() {
        return akrAkceCilskupVztahy;
    }

    public void setAkrAkceCilskupVztahy(AkrAkceCilskupVztahy akrAkceCilskupVztahy) {
        this.akrAkceCilskupVztahy = akrAkceCilskupVztahy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrCilskupId != null ? akrCilskupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrCiloveSkupiny)) {
            return false;
        }
        AkrCiloveSkupiny other = (AkrCiloveSkupiny) object;
        if ((this.akrCilskupId == null && other.akrCilskupId != null) || (this.akrCilskupId != null && !this.akrCilskupId.equals(other.akrCilskupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrCiloveSkupiny[ akrCilskupId=" + akrCilskupId + " ]";
    }
    
}
