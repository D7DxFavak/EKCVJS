/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_oblzar_jemne", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceOblzarJemne.findAll", query = "SELECT a FROM AkceOblzarJemne a"),
    @NamedQuery(name = "AkceOblzarJemne.findByOblzarHrubeId", query = "SELECT a FROM AkceOblzarJemne a WHERE a.akceOblzarJemnePK.oblzarHrubeId = :oblzarHrubeId"),
    @NamedQuery(name = "AkceOblzarJemne.findByOblzarJemneId", query = "SELECT a FROM AkceOblzarJemne a WHERE a.akceOblzarJemnePK.oblzarJemneId = :oblzarJemneId"),
    @NamedQuery(name = "AkceOblzarJemne.findByNazev", query = "SELECT a FROM AkceOblzarJemne a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceOblzarJemne.findByPoznamky", query = "SELECT a FROM AkceOblzarJemne a WHERE a.poznamky = :poznamky")})
public class AkceOblzarJemne implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceOblzarJemnePK akceOblzarJemnePK;
    @Size(max = 200)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "oblzar_hrube_id", referencedColumnName = "oblzar_hrube_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceOblzarHrube akceOblzarHrube;

    public AkceOblzarJemne() {
    }

    public AkceOblzarJemne(AkceOblzarJemnePK akceOblzarJemnePK) {
        this.akceOblzarJemnePK = akceOblzarJemnePK;
    }

    public AkceOblzarJemne(int oblzarHrubeId, int oblzarJemneId) {
        this.akceOblzarJemnePK = new AkceOblzarJemnePK(oblzarHrubeId, oblzarJemneId);
    }

    public AkceOblzarJemnePK getAkceOblzarJemnePK() {
        return akceOblzarJemnePK;
    }

    public void setAkceOblzarJemnePK(AkceOblzarJemnePK akceOblzarJemnePK) {
        this.akceOblzarJemnePK = akceOblzarJemnePK;
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

    public AkceOblzarHrube getAkceOblzarHrube() {
        return akceOblzarHrube;
    }

    public void setAkceOblzarHrube(AkceOblzarHrube akceOblzarHrube) {
        this.akceOblzarHrube = akceOblzarHrube;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceOblzarJemnePK != null ? akceOblzarJemnePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceOblzarJemne)) {
            return false;
        }
        AkceOblzarJemne other = (AkceOblzarJemne) object;
        if ((this.akceOblzarJemnePK == null && other.akceOblzarJemnePK != null) || (this.akceOblzarJemnePK != null && !this.akceOblzarJemnePK.equals(other.akceOblzarJemnePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceOblzarJemne[ akceOblzarJemnePK=" + akceOblzarJemnePK + " ]";
    }
    
}
