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
@Table(name = "uzivatele_autorizace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UzivateleAutorizace.findAll", query = "SELECT u FROM UzivateleAutorizace u"),
    @NamedQuery(name = "UzivateleAutorizace.findByOborId", query = "SELECT u FROM UzivateleAutorizace u WHERE u.uzivateleAutorizacePK.oborId = :oborId"),
    @NamedQuery(name = "UzivateleAutorizace.findByUzivatelNazev", query = "SELECT u FROM UzivateleAutorizace u WHERE u.uzivateleAutorizacePK.uzivatelNazev = :uzivatelNazev"),
    @NamedQuery(name = "UzivateleAutorizace.findBySpravce", query = "SELECT u FROM UzivateleAutorizace u WHERE u.spravce = :spravce"),
    @NamedQuery(name = "UzivateleAutorizace.findByPoznamky", query = "SELECT u FROM UzivateleAutorizace u WHERE u.poznamky = :poznamky")})
public class UzivateleAutorizace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UzivateleAutorizacePK uzivateleAutorizacePK;
    @Column(name = "spravce")
    private Boolean spravce;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "obor_id", referencedColumnName = "obor_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Obory obory;

    public UzivateleAutorizace() {
    }

    public UzivateleAutorizace(UzivateleAutorizacePK uzivateleAutorizacePK) {
        this.uzivateleAutorizacePK = uzivateleAutorizacePK;
    }

    public UzivateleAutorizace(int oborId, String uzivatelNazev) {
        this.uzivateleAutorizacePK = new UzivateleAutorizacePK(oborId, uzivatelNazev);
    }

    public UzivateleAutorizacePK getUzivateleAutorizacePK() {
        return uzivateleAutorizacePK;
    }

    public void setUzivateleAutorizacePK(UzivateleAutorizacePK uzivateleAutorizacePK) {
        this.uzivateleAutorizacePK = uzivateleAutorizacePK;
    }

    public Boolean getSpravce() {
        return spravce;
    }

    public void setSpravce(Boolean spravce) {
        this.spravce = spravce;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public Obory getObory() {
        return obory;
    }

    public void setObory(Obory obory) {
        this.obory = obory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uzivateleAutorizacePK != null ? uzivateleAutorizacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UzivateleAutorizace)) {
            return false;
        }
        UzivateleAutorizace other = (UzivateleAutorizace) object;
        if ((this.uzivateleAutorizacePK == null && other.uzivateleAutorizacePK != null) || (this.uzivateleAutorizacePK != null && !this.uzivateleAutorizacePK.equals(other.uzivateleAutorizacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UzivateleAutorizace[ uzivateleAutorizacePK=" + uzivateleAutorizacePK + " ]";
    }
    
}
