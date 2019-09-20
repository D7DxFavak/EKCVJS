/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "akce_vyuctovani", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceVyuctovani.findAll", query = "SELECT a FROM AkceVyuctovani a"),
    @NamedQuery(name = "AkceVyuctovani.findByAkceVyuctovaniId", query = "SELECT a FROM AkceVyuctovani a WHERE a.akceVyuctovaniPK.akceVyuctovaniId = :akceVyuctovaniId"),
    @NamedQuery(name = "AkceVyuctovani.findByAkceVyuctovaniPid", query = "SELECT a FROM AkceVyuctovani a WHERE a.akceVyuctovaniPK.akceVyuctovaniPid = :akceVyuctovaniPid"),
    @NamedQuery(name = "AkceVyuctovani.findByAkceVyuctovaniJednHodnota", query = "SELECT a FROM AkceVyuctovani a WHERE a.akceVyuctovaniJednHodnota = :akceVyuctovaniJednHodnota"),
    @NamedQuery(name = "AkceVyuctovani.findByAkceVyuctovaniCelkHodnota", query = "SELECT a FROM AkceVyuctovani a WHERE a.akceVyuctovaniCelkHodnota = :akceVyuctovaniCelkHodnota"),
    @NamedQuery(name = "AkceVyuctovani.findByAkceVyuctovaniPoznamky", query = "SELECT a FROM AkceVyuctovani a WHERE a.akceVyuctovaniPoznamky = :akceVyuctovaniPoznamky")})
public class AkceVyuctovani implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceVyuctovaniPK akceVyuctovaniPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "akce_vyuctovani_jedn_hodnota")
    private BigDecimal akceVyuctovaniJednHodnota;
    @Column(name = "akce_vyuctovani_celk_hodnota")
    private BigDecimal akceVyuctovaniCelkHodnota;
    @Size(max = 2147483647)
    @Column(name = "akce_vyuctovani_poznamky")
    private String akceVyuctovaniPoznamky;
    @JoinColumn(name = "akce_vyuctovani_pid", referencedColumnName = "akce_kalkulace_pol_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceKalkulacePol akceKalkulacePol;
    @JoinColumn(name = "akce_vyuctovani_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceVyuctovani() {
    }

    public AkceVyuctovani(AkceVyuctovaniPK akceVyuctovaniPK) {
        this.akceVyuctovaniPK = akceVyuctovaniPK;
    }

    public AkceVyuctovani(int akceVyuctovaniId, int akceVyuctovaniPid) {
        this.akceVyuctovaniPK = new AkceVyuctovaniPK(akceVyuctovaniId, akceVyuctovaniPid);
    }

    public AkceVyuctovaniPK getAkceVyuctovaniPK() {
        return akceVyuctovaniPK;
    }

    public void setAkceVyuctovaniPK(AkceVyuctovaniPK akceVyuctovaniPK) {
        this.akceVyuctovaniPK = akceVyuctovaniPK;
    }

    public BigDecimal getAkceVyuctovaniJednHodnota() {
        return akceVyuctovaniJednHodnota;
    }

    public void setAkceVyuctovaniJednHodnota(BigDecimal akceVyuctovaniJednHodnota) {
        this.akceVyuctovaniJednHodnota = akceVyuctovaniJednHodnota;
    }

    public BigDecimal getAkceVyuctovaniCelkHodnota() {
        return akceVyuctovaniCelkHodnota;
    }

    public void setAkceVyuctovaniCelkHodnota(BigDecimal akceVyuctovaniCelkHodnota) {
        this.akceVyuctovaniCelkHodnota = akceVyuctovaniCelkHodnota;
    }

    public String getAkceVyuctovaniPoznamky() {
        return akceVyuctovaniPoznamky;
    }

    public void setAkceVyuctovaniPoznamky(String akceVyuctovaniPoznamky) {
        this.akceVyuctovaniPoznamky = akceVyuctovaniPoznamky;
    }

    public AkceKalkulacePol getAkceKalkulacePol() {
        return akceKalkulacePol;
    }

    public void setAkceKalkulacePol(AkceKalkulacePol akceKalkulacePol) {
        this.akceKalkulacePol = akceKalkulacePol;
    }

    public AkceHlavni getAkceHlavni() {
        return akceHlavni;
    }

    public void setAkceHlavni(AkceHlavni akceHlavni) {
        this.akceHlavni = akceHlavni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceVyuctovaniPK != null ? akceVyuctovaniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceVyuctovani)) {
            return false;
        }
        AkceVyuctovani other = (AkceVyuctovani) object;
        if ((this.akceVyuctovaniPK == null && other.akceVyuctovaniPK != null) || (this.akceVyuctovaniPK != null && !this.akceVyuctovaniPK.equals(other.akceVyuctovaniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceVyuctovani[ akceVyuctovaniPK=" + akceVyuctovaniPK + " ]";
    }
    
}
