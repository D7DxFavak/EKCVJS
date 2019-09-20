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
@Table(name = "akce_kalkulace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKalkulace.findAll", query = "SELECT a FROM AkceKalkulace a"),
    @NamedQuery(name = "AkceKalkulace.findByAkceKalkulaceId", query = "SELECT a FROM AkceKalkulace a WHERE a.akceKalkulacePK.akceKalkulaceId = :akceKalkulaceId"),
    @NamedQuery(name = "AkceKalkulace.findByAkceKalkulacePid", query = "SELECT a FROM AkceKalkulace a WHERE a.akceKalkulacePK.akceKalkulacePid = :akceKalkulacePid"),
    @NamedQuery(name = "AkceKalkulace.findByAkceKalkulaceJednHodnota", query = "SELECT a FROM AkceKalkulace a WHERE a.akceKalkulaceJednHodnota = :akceKalkulaceJednHodnota"),
    @NamedQuery(name = "AkceKalkulace.findByAkceKalkulaceCelkHodnota", query = "SELECT a FROM AkceKalkulace a WHERE a.akceKalkulaceCelkHodnota = :akceKalkulaceCelkHodnota"),
    @NamedQuery(name = "AkceKalkulace.findByAkceKalkulacePoznamky", query = "SELECT a FROM AkceKalkulace a WHERE a.akceKalkulacePoznamky = :akceKalkulacePoznamky")})
public class AkceKalkulace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceKalkulacePK akceKalkulacePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "akce_kalkulace_jedn_hodnota")
    private BigDecimal akceKalkulaceJednHodnota;
    @Column(name = "akce_kalkulace_celk_hodnota")
    private BigDecimal akceKalkulaceCelkHodnota;
    @Size(max = 2147483647)
    @Column(name = "akce_kalkulace_poznamky")
    private String akceKalkulacePoznamky;
    @JoinColumn(name = "akce_kalkulace_pid", referencedColumnName = "akce_kalkulace_pol_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceKalkulacePol akceKalkulacePol;
    @JoinColumn(name = "akce_kalkulace_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceKalkulace() {
    }

    public AkceKalkulace(AkceKalkulacePK akceKalkulacePK) {
        this.akceKalkulacePK = akceKalkulacePK;
    }

    public AkceKalkulace(int akceKalkulaceId, int akceKalkulacePid) {
        this.akceKalkulacePK = new AkceKalkulacePK(akceKalkulaceId, akceKalkulacePid);
    }

    public AkceKalkulacePK getAkceKalkulacePK() {
        return akceKalkulacePK;
    }

    public void setAkceKalkulacePK(AkceKalkulacePK akceKalkulacePK) {
        this.akceKalkulacePK = akceKalkulacePK;
    }

    public BigDecimal getAkceKalkulaceJednHodnota() {
        return akceKalkulaceJednHodnota;
    }

    public void setAkceKalkulaceJednHodnota(BigDecimal akceKalkulaceJednHodnota) {
        this.akceKalkulaceJednHodnota = akceKalkulaceJednHodnota;
    }

    public BigDecimal getAkceKalkulaceCelkHodnota() {
        return akceKalkulaceCelkHodnota;
    }

    public void setAkceKalkulaceCelkHodnota(BigDecimal akceKalkulaceCelkHodnota) {
        this.akceKalkulaceCelkHodnota = akceKalkulaceCelkHodnota;
    }

    public String getAkceKalkulacePoznamky() {
        return akceKalkulacePoznamky;
    }

    public void setAkceKalkulacePoznamky(String akceKalkulacePoznamky) {
        this.akceKalkulacePoznamky = akceKalkulacePoznamky;
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
        hash += (akceKalkulacePK != null ? akceKalkulacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulace)) {
            return false;
        }
        AkceKalkulace other = (AkceKalkulace) object;
        if ((this.akceKalkulacePK == null && other.akceKalkulacePK != null) || (this.akceKalkulacePK != null && !this.akceKalkulacePK.equals(other.akceKalkulacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulace[ akceKalkulacePK=" + akceKalkulacePK + " ]";
    }
    
}
