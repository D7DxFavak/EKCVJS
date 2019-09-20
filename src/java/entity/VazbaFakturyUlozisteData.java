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
@Table(name = "vazba_faktury_uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaFakturyUlozisteData.findAll", query = "SELECT v FROM VazbaFakturyUlozisteData v"),
    @NamedQuery(name = "VazbaFakturyUlozisteData.findByVazbaFakturyUlozisteDataFakturyId", query = "SELECT v FROM VazbaFakturyUlozisteData v WHERE v.vazbaFakturyUlozisteDataPK.vazbaFakturyUlozisteDataFakturyId = :vazbaFakturyUlozisteDataFakturyId"),
    @NamedQuery(name = "VazbaFakturyUlozisteData.findByVazbaFakturyUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaFakturyUlozisteData v WHERE v.vazbaFakturyUlozisteDataPK.vazbaFakturyUlozisteDataDataUlozisteId = :vazbaFakturyUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaFakturyUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaFakturyUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaFakturyUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaFakturyUlozisteDataPK vazbaFakturyUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_faktury_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_faktury_uloziste_data_faktury_id", referencedColumnName = "cislo_faktury", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KnihaFaktur knihaFaktur;

    public VazbaFakturyUlozisteData() {
    }

    public VazbaFakturyUlozisteData(VazbaFakturyUlozisteDataPK vazbaFakturyUlozisteDataPK) {
        this.vazbaFakturyUlozisteDataPK = vazbaFakturyUlozisteDataPK;
    }

    public VazbaFakturyUlozisteData(int vazbaFakturyUlozisteDataFakturyId, int vazbaFakturyUlozisteDataDataUlozisteId) {
        this.vazbaFakturyUlozisteDataPK = new VazbaFakturyUlozisteDataPK(vazbaFakturyUlozisteDataFakturyId, vazbaFakturyUlozisteDataDataUlozisteId);
    }

    public VazbaFakturyUlozisteDataPK getVazbaFakturyUlozisteDataPK() {
        return vazbaFakturyUlozisteDataPK;
    }

    public void setVazbaFakturyUlozisteDataPK(VazbaFakturyUlozisteDataPK vazbaFakturyUlozisteDataPK) {
        this.vazbaFakturyUlozisteDataPK = vazbaFakturyUlozisteDataPK;
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

    public KnihaFaktur getKnihaFaktur() {
        return knihaFaktur;
    }

    public void setKnihaFaktur(KnihaFaktur knihaFaktur) {
        this.knihaFaktur = knihaFaktur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaFakturyUlozisteDataPK != null ? vazbaFakturyUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaFakturyUlozisteData)) {
            return false;
        }
        VazbaFakturyUlozisteData other = (VazbaFakturyUlozisteData) object;
        if ((this.vazbaFakturyUlozisteDataPK == null && other.vazbaFakturyUlozisteDataPK != null) || (this.vazbaFakturyUlozisteDataPK != null && !this.vazbaFakturyUlozisteDataPK.equals(other.vazbaFakturyUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaFakturyUlozisteData[ vazbaFakturyUlozisteDataPK=" + vazbaFakturyUlozisteDataPK + " ]";
    }
    
}
