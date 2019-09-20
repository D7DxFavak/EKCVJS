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
@Table(name = "akce_kalkulace_vazba_sestava", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKalkulaceVazbaSestava.findAll", query = "SELECT a FROM AkceKalkulaceVazbaSestava a"),
    @NamedQuery(name = "AkceKalkulaceVazbaSestava.findByAkceKalkulaceVazbaSestavaId", query = "SELECT a FROM AkceKalkulaceVazbaSestava a WHERE a.akceKalkulaceVazbaSestavaPK.akceKalkulaceVazbaSestavaId = :akceKalkulaceVazbaSestavaId"),
    @NamedQuery(name = "AkceKalkulaceVazbaSestava.findByAkceKalkulaceVazbaSestavaPolId", query = "SELECT a FROM AkceKalkulaceVazbaSestava a WHERE a.akceKalkulaceVazbaSestavaPK.akceKalkulaceVazbaSestavaPolId = :akceKalkulaceVazbaSestavaPolId"),
    @NamedQuery(name = "AkceKalkulaceVazbaSestava.findByAkceKalkulaceSestavaVazbaPoznamky", query = "SELECT a FROM AkceKalkulaceVazbaSestava a WHERE a.akceKalkulaceSestavaVazbaPoznamky = :akceKalkulaceSestavaVazbaPoznamky")})
public class AkceKalkulaceVazbaSestava implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceKalkulaceVazbaSestavaPK akceKalkulaceVazbaSestavaPK;
    @Size(max = 2147483647)
    @Column(name = "akce_kalkulace_sestava_vazba_poznamky")
    private String akceKalkulaceSestavaVazbaPoznamky;
    @JoinColumn(name = "akce_kalkulace_vazba_sestava_id", referencedColumnName = "akce_kalkulace_sestava_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceKalkulaceSestava akceKalkulaceSestava;
    @JoinColumn(name = "akce_kalkulace_vazba_sestava_pol_id", referencedColumnName = "akce_kalkulace_pol_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceKalkulacePol akceKalkulacePol;

    public AkceKalkulaceVazbaSestava() {
    }

    public AkceKalkulaceVazbaSestava(AkceKalkulaceVazbaSestavaPK akceKalkulaceVazbaSestavaPK) {
        this.akceKalkulaceVazbaSestavaPK = akceKalkulaceVazbaSestavaPK;
    }

    public AkceKalkulaceVazbaSestava(int akceKalkulaceVazbaSestavaId, int akceKalkulaceVazbaSestavaPolId) {
        this.akceKalkulaceVazbaSestavaPK = new AkceKalkulaceVazbaSestavaPK(akceKalkulaceVazbaSestavaId, akceKalkulaceVazbaSestavaPolId);
    }

    public AkceKalkulaceVazbaSestavaPK getAkceKalkulaceVazbaSestavaPK() {
        return akceKalkulaceVazbaSestavaPK;
    }

    public void setAkceKalkulaceVazbaSestavaPK(AkceKalkulaceVazbaSestavaPK akceKalkulaceVazbaSestavaPK) {
        this.akceKalkulaceVazbaSestavaPK = akceKalkulaceVazbaSestavaPK;
    }

    public String getAkceKalkulaceSestavaVazbaPoznamky() {
        return akceKalkulaceSestavaVazbaPoznamky;
    }

    public void setAkceKalkulaceSestavaVazbaPoznamky(String akceKalkulaceSestavaVazbaPoznamky) {
        this.akceKalkulaceSestavaVazbaPoznamky = akceKalkulaceSestavaVazbaPoznamky;
    }

    public AkceKalkulaceSestava getAkceKalkulaceSestava() {
        return akceKalkulaceSestava;
    }

    public void setAkceKalkulaceSestava(AkceKalkulaceSestava akceKalkulaceSestava) {
        this.akceKalkulaceSestava = akceKalkulaceSestava;
    }

    public AkceKalkulacePol getAkceKalkulacePol() {
        return akceKalkulacePol;
    }

    public void setAkceKalkulacePol(AkceKalkulacePol akceKalkulacePol) {
        this.akceKalkulacePol = akceKalkulacePol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceKalkulaceVazbaSestavaPK != null ? akceKalkulaceVazbaSestavaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulaceVazbaSestava)) {
            return false;
        }
        AkceKalkulaceVazbaSestava other = (AkceKalkulaceVazbaSestava) object;
        if ((this.akceKalkulaceVazbaSestavaPK == null && other.akceKalkulaceVazbaSestavaPK != null) || (this.akceKalkulaceVazbaSestavaPK != null && !this.akceKalkulaceVazbaSestavaPK.equals(other.akceKalkulaceVazbaSestavaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulaceVazbaSestava[ akceKalkulaceVazbaSestavaPK=" + akceKalkulaceVazbaSestavaPK + " ]";
    }
    
}
