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
@Table(name = "vazba_osoby_uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaOsobyUlozisteData.findAll", query = "SELECT v FROM VazbaOsobyUlozisteData v"),
    @NamedQuery(name = "VazbaOsobyUlozisteData.findByVazbaOsobyUlozisteDataOsobaId", query = "SELECT v FROM VazbaOsobyUlozisteData v WHERE v.vazbaOsobyUlozisteDataPK.vazbaOsobyUlozisteDataOsobaId = :vazbaOsobyUlozisteDataOsobaId"),
    @NamedQuery(name = "VazbaOsobyUlozisteData.findByVazbaOsobyUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaOsobyUlozisteData v WHERE v.vazbaOsobyUlozisteDataPK.vazbaOsobyUlozisteDataDataUlozisteId = :vazbaOsobyUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaOsobyUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaOsobyUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaOsobyUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaOsobyUlozisteDataPK vazbaOsobyUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_osoby_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_osoby_uloziste_data_osoba_id", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;

    public VazbaOsobyUlozisteData() {
    }

    public VazbaOsobyUlozisteData(VazbaOsobyUlozisteDataPK vazbaOsobyUlozisteDataPK) {
        this.vazbaOsobyUlozisteDataPK = vazbaOsobyUlozisteDataPK;
    }

    public VazbaOsobyUlozisteData(int vazbaOsobyUlozisteDataOsobaId, int vazbaOsobyUlozisteDataDataUlozisteId) {
        this.vazbaOsobyUlozisteDataPK = new VazbaOsobyUlozisteDataPK(vazbaOsobyUlozisteDataOsobaId, vazbaOsobyUlozisteDataDataUlozisteId);
    }

    public VazbaOsobyUlozisteDataPK getVazbaOsobyUlozisteDataPK() {
        return vazbaOsobyUlozisteDataPK;
    }

    public void setVazbaOsobyUlozisteDataPK(VazbaOsobyUlozisteDataPK vazbaOsobyUlozisteDataPK) {
        this.vazbaOsobyUlozisteDataPK = vazbaOsobyUlozisteDataPK;
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

    public Osoby getOsoby() {
        return osoby;
    }

    public void setOsoby(Osoby osoby) {
        this.osoby = osoby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaOsobyUlozisteDataPK != null ? vazbaOsobyUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaOsobyUlozisteData)) {
            return false;
        }
        VazbaOsobyUlozisteData other = (VazbaOsobyUlozisteData) object;
        if ((this.vazbaOsobyUlozisteDataPK == null && other.vazbaOsobyUlozisteDataPK != null) || (this.vazbaOsobyUlozisteDataPK != null && !this.vazbaOsobyUlozisteDataPK.equals(other.vazbaOsobyUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaOsobyUlozisteData[ vazbaOsobyUlozisteDataPK=" + vazbaOsobyUlozisteDataPK + " ]";
    }
    
}
