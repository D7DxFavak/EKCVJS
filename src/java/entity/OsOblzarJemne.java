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
@Table(name = "os_oblzar_jemne", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsOblzarJemne.findAll", query = "SELECT o FROM OsOblzarJemne o"),
    @NamedQuery(name = "OsOblzarJemne.findByOblzarHrubeId", query = "SELECT o FROM OsOblzarJemne o WHERE o.osOblzarJemnePK.oblzarHrubeId = :oblzarHrubeId"),
    @NamedQuery(name = "OsOblzarJemne.findByOblzarJemneId", query = "SELECT o FROM OsOblzarJemne o WHERE o.osOblzarJemnePK.oblzarJemneId = :oblzarJemneId"),
    @NamedQuery(name = "OsOblzarJemne.findByNazev", query = "SELECT o FROM OsOblzarJemne o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "OsOblzarJemne.findByPoznamky", query = "SELECT o FROM OsOblzarJemne o WHERE o.poznamky = :poznamky")})
public class OsOblzarJemne implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OsOblzarJemnePK osOblzarJemnePK;
    @Size(max = 200)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "oblzar_hrube_id", referencedColumnName = "oblzar_hrube_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OsOblzarHrube osOblzarHrube;

    public OsOblzarJemne() {
    }

    public OsOblzarJemne(OsOblzarJemnePK osOblzarJemnePK) {
        this.osOblzarJemnePK = osOblzarJemnePK;
    }

    public OsOblzarJemne(int oblzarHrubeId, int oblzarJemneId) {
        this.osOblzarJemnePK = new OsOblzarJemnePK(oblzarHrubeId, oblzarJemneId);
    }

    public OsOblzarJemnePK getOsOblzarJemnePK() {
        return osOblzarJemnePK;
    }

    public void setOsOblzarJemnePK(OsOblzarJemnePK osOblzarJemnePK) {
        this.osOblzarJemnePK = osOblzarJemnePK;
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

    public OsOblzarHrube getOsOblzarHrube() {
        return osOblzarHrube;
    }

    public void setOsOblzarHrube(OsOblzarHrube osOblzarHrube) {
        this.osOblzarHrube = osOblzarHrube;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osOblzarJemnePK != null ? osOblzarJemnePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsOblzarJemne)) {
            return false;
        }
        OsOblzarJemne other = (OsOblzarJemne) object;
        if ((this.osOblzarJemnePK == null && other.osOblzarJemnePK != null) || (this.osOblzarJemnePK != null && !this.osOblzarJemnePK.equals(other.osOblzarJemnePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OsOblzarJemne[ osOblzarJemnePK=" + osOblzarJemnePK + " ]";
    }
    
}
