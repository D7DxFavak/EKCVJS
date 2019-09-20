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
@Table(name = "akce_cilove_skupiny", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceCiloveSkupiny.findAll", query = "SELECT a FROM AkceCiloveSkupiny a"),
    @NamedQuery(name = "AkceCiloveSkupiny.findByAkceCilskupId", query = "SELECT a FROM AkceCiloveSkupiny a WHERE a.akceCilskupId = :akceCilskupId"),
    @NamedQuery(name = "AkceCiloveSkupiny.findByNazev", query = "SELECT a FROM AkceCiloveSkupiny a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceCiloveSkupiny.findByPoznamky", query = "SELECT a FROM AkceCiloveSkupiny a WHERE a.poznamky = :poznamky")})
public class AkceCiloveSkupiny implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_cilskup_id")
    private Integer akceCilskupId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceCiloveSkupiny")
    private Collection<AkceCilskup> akceCilskupCollection;
    @OneToMany(mappedBy = "akceCilskup")
    private Collection<AkrAkceCilskupVztahy> akrAkceCilskupVztahyCollection;

    public AkceCiloveSkupiny() {
    }

    public AkceCiloveSkupiny(Integer akceCilskupId) {
        this.akceCilskupId = akceCilskupId;
    }

    public Integer getAkceCilskupId() {
        return akceCilskupId;
    }

    public void setAkceCilskupId(Integer akceCilskupId) {
        this.akceCilskupId = akceCilskupId;
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
    public Collection<AkceCilskup> getAkceCilskupCollection() {
        return akceCilskupCollection;
    }

    public void setAkceCilskupCollection(Collection<AkceCilskup> akceCilskupCollection) {
        this.akceCilskupCollection = akceCilskupCollection;
    }

    @XmlTransient
    public Collection<AkrAkceCilskupVztahy> getAkrAkceCilskupVztahyCollection() {
        return akrAkceCilskupVztahyCollection;
    }

    public void setAkrAkceCilskupVztahyCollection(Collection<AkrAkceCilskupVztahy> akrAkceCilskupVztahyCollection) {
        this.akrAkceCilskupVztahyCollection = akrAkceCilskupVztahyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceCilskupId != null ? akceCilskupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceCiloveSkupiny)) {
            return false;
        }
        AkceCiloveSkupiny other = (AkceCiloveSkupiny) object;
        if ((this.akceCilskupId == null && other.akceCilskupId != null) || (this.akceCilskupId != null && !this.akceCilskupId.equals(other.akceCilskupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceCiloveSkupiny[ akceCilskupId=" + akceCilskupId + " ]";
    }
    
}
