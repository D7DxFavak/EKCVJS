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
@Table(name = "vazba_akce_uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaAkceUlozisteData.findAll", query = "SELECT v FROM VazbaAkceUlozisteData v"),
    @NamedQuery(name = "VazbaAkceUlozisteData.findByVazbaOsobyUlozisteDataAkceId", query = "SELECT v FROM VazbaAkceUlozisteData v WHERE v.vazbaAkceUlozisteDataPK.vazbaOsobyUlozisteDataAkceId = :vazbaOsobyUlozisteDataAkceId"),
    @NamedQuery(name = "VazbaAkceUlozisteData.findByVazbaOsobyUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaAkceUlozisteData v WHERE v.vazbaAkceUlozisteDataPK.vazbaOsobyUlozisteDataDataUlozisteId = :vazbaOsobyUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaAkceUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaAkceUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaAkceUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaAkceUlozisteDataPK vazbaAkceUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_osoby_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_osoby_uloziste_data_akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public VazbaAkceUlozisteData() {
    }

    public VazbaAkceUlozisteData(VazbaAkceUlozisteDataPK vazbaAkceUlozisteDataPK) {
        this.vazbaAkceUlozisteDataPK = vazbaAkceUlozisteDataPK;
    }

    public VazbaAkceUlozisteData(int vazbaOsobyUlozisteDataAkceId, int vazbaOsobyUlozisteDataDataUlozisteId) {
        this.vazbaAkceUlozisteDataPK = new VazbaAkceUlozisteDataPK(vazbaOsobyUlozisteDataAkceId, vazbaOsobyUlozisteDataDataUlozisteId);
    }

    public VazbaAkceUlozisteDataPK getVazbaAkceUlozisteDataPK() {
        return vazbaAkceUlozisteDataPK;
    }

    public void setVazbaAkceUlozisteDataPK(VazbaAkceUlozisteDataPK vazbaAkceUlozisteDataPK) {
        this.vazbaAkceUlozisteDataPK = vazbaAkceUlozisteDataPK;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public UlozisteData getUlozisteData() {
        return ulozisteData;
    }

    public void setUlozisteData(UlozisteData ulozisteData) {
        this.ulozisteData = ulozisteData;
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
        hash += (vazbaAkceUlozisteDataPK != null ? vazbaAkceUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaAkceUlozisteData)) {
            return false;
        }
        VazbaAkceUlozisteData other = (VazbaAkceUlozisteData) object;
        if ((this.vazbaAkceUlozisteDataPK == null && other.vazbaAkceUlozisteDataPK != null) || (this.vazbaAkceUlozisteDataPK != null && !this.vazbaAkceUlozisteDataPK.equals(other.vazbaAkceUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaAkceUlozisteData[ vazbaAkceUlozisteDataPK=" + vazbaAkceUlozisteDataPK + " ]";
    }
    
}
