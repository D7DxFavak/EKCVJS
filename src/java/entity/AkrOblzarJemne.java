/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akr_oblzar_jemne", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrOblzarJemne.findAll", query = "SELECT a FROM AkrOblzarJemne a"),
    @NamedQuery(name = "AkrOblzarJemne.findByOblzarHrubeId", query = "SELECT a FROM AkrOblzarJemne a WHERE a.akrOblzarJemnePK.oblzarHrubeId = :oblzarHrubeId"),
    @NamedQuery(name = "AkrOblzarJemne.findByOblzarJemneId", query = "SELECT a FROM AkrOblzarJemne a WHERE a.akrOblzarJemnePK.oblzarJemneId = :oblzarJemneId"),
    @NamedQuery(name = "AkrOblzarJemne.findByNazev", query = "SELECT a FROM AkrOblzarJemne a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkrOblzarJemne.findByPoznamky", query = "SELECT a FROM AkrOblzarJemne a WHERE a.poznamky = :poznamky")})
public class AkrOblzarJemne implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkrOblzarJemnePK akrOblzarJemnePK;
    @Size(max = 200)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "oblzar_hrube_id", referencedColumnName = "oblzar_hrube_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkrOblzarHrube akrOblzarHrube;
    @OneToMany(mappedBy = "akrOblzarJemne")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;

    public AkrOblzarJemne() {
    }

    public AkrOblzarJemne(AkrOblzarJemnePK akrOblzarJemnePK) {
        this.akrOblzarJemnePK = akrOblzarJemnePK;
    }

    public AkrOblzarJemne(int oblzarHrubeId, int oblzarJemneId) {
        this.akrOblzarJemnePK = new AkrOblzarJemnePK(oblzarHrubeId, oblzarJemneId);
    }

    public AkrOblzarJemnePK getAkrOblzarJemnePK() {
        return akrOblzarJemnePK;
    }

    public void setAkrOblzarJemnePK(AkrOblzarJemnePK akrOblzarJemnePK) {
        this.akrOblzarJemnePK = akrOblzarJemnePK;
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

    public AkrOblzarHrube getAkrOblzarHrube() {
        return akrOblzarHrube;
    }

    public void setAkrOblzarHrube(AkrOblzarHrube akrOblzarHrube) {
        this.akrOblzarHrube = akrOblzarHrube;
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
        hash += (akrOblzarJemnePK != null ? akrOblzarJemnePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrOblzarJemne)) {
            return false;
        }
        AkrOblzarJemne other = (AkrOblzarJemne) object;
        if ((this.akrOblzarJemnePK == null && other.akrOblzarJemnePK != null) || (this.akrOblzarJemnePK != null && !this.akrOblzarJemnePK.equals(other.akrOblzarJemnePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrOblzarJemne[ akrOblzarJemnePK=" + akrOblzarJemnePK + " ]";
    }
    
}
