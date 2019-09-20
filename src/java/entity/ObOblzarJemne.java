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
@Table(name = "ob_oblzar_jemne", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObOblzarJemne.findAll", query = "SELECT o FROM ObOblzarJemne o"),
    @NamedQuery(name = "ObOblzarJemne.findByOblzarHrubeId", query = "SELECT o FROM ObOblzarJemne o WHERE o.obOblzarJemnePK.oblzarHrubeId = :oblzarHrubeId"),
    @NamedQuery(name = "ObOblzarJemne.findByOblzarJemneId", query = "SELECT o FROM ObOblzarJemne o WHERE o.obOblzarJemnePK.oblzarJemneId = :oblzarJemneId"),
    @NamedQuery(name = "ObOblzarJemne.findByNazev", query = "SELECT o FROM ObOblzarJemne o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "ObOblzarJemne.findByPoznamky", query = "SELECT o FROM ObOblzarJemne o WHERE o.poznamky = :poznamky")})
public class ObOblzarJemne implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObOblzarJemnePK obOblzarJemnePK;
    @Size(max = 200)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "oblzar_hrube_id", referencedColumnName = "oblzar_hrube_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ObOblzarHrube obOblzarHrube;

    public ObOblzarJemne() {
    }

    public ObOblzarJemne(ObOblzarJemnePK obOblzarJemnePK) {
        this.obOblzarJemnePK = obOblzarJemnePK;
    }

    public ObOblzarJemne(int oblzarHrubeId, int oblzarJemneId) {
        this.obOblzarJemnePK = new ObOblzarJemnePK(oblzarHrubeId, oblzarJemneId);
    }

    public ObOblzarJemnePK getObOblzarJemnePK() {
        return obOblzarJemnePK;
    }

    public void setObOblzarJemnePK(ObOblzarJemnePK obOblzarJemnePK) {
        this.obOblzarJemnePK = obOblzarJemnePK;
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

    public ObOblzarHrube getObOblzarHrube() {
        return obOblzarHrube;
    }

    public void setObOblzarHrube(ObOblzarHrube obOblzarHrube) {
        this.obOblzarHrube = obOblzarHrube;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obOblzarJemnePK != null ? obOblzarJemnePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObOblzarJemne)) {
            return false;
        }
        ObOblzarJemne other = (ObOblzarJemne) object;
        if ((this.obOblzarJemnePK == null && other.obOblzarJemnePK != null) || (this.obOblzarJemnePK != null && !this.obOblzarJemnePK.equals(other.obOblzarJemnePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObOblzarJemne[ obOblzarJemnePK=" + obOblzarJemnePK + " ]";
    }
    
}
