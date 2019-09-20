/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 7Data Gotzy
 */
@Embeddable
public class VazbaFakturyUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_faktury_uloziste_data_faktury_id")
    private int vazbaFakturyUlozisteDataFakturyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_faktury_uloziste_data_data_uloziste_id")
    private int vazbaFakturyUlozisteDataDataUlozisteId;

    public VazbaFakturyUlozisteDataPK() {
    }

    public VazbaFakturyUlozisteDataPK(int vazbaFakturyUlozisteDataFakturyId, int vazbaFakturyUlozisteDataDataUlozisteId) {
        this.vazbaFakturyUlozisteDataFakturyId = vazbaFakturyUlozisteDataFakturyId;
        this.vazbaFakturyUlozisteDataDataUlozisteId = vazbaFakturyUlozisteDataDataUlozisteId;
    }

    public int getVazbaFakturyUlozisteDataFakturyId() {
        return vazbaFakturyUlozisteDataFakturyId;
    }

    public void setVazbaFakturyUlozisteDataFakturyId(int vazbaFakturyUlozisteDataFakturyId) {
        this.vazbaFakturyUlozisteDataFakturyId = vazbaFakturyUlozisteDataFakturyId;
    }

    public int getVazbaFakturyUlozisteDataDataUlozisteId() {
        return vazbaFakturyUlozisteDataDataUlozisteId;
    }

    public void setVazbaFakturyUlozisteDataDataUlozisteId(int vazbaFakturyUlozisteDataDataUlozisteId) {
        this.vazbaFakturyUlozisteDataDataUlozisteId = vazbaFakturyUlozisteDataDataUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaFakturyUlozisteDataFakturyId;
        hash += (int) vazbaFakturyUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaFakturyUlozisteDataPK)) {
            return false;
        }
        VazbaFakturyUlozisteDataPK other = (VazbaFakturyUlozisteDataPK) object;
        if (this.vazbaFakturyUlozisteDataFakturyId != other.vazbaFakturyUlozisteDataFakturyId) {
            return false;
        }
        if (this.vazbaFakturyUlozisteDataDataUlozisteId != other.vazbaFakturyUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaFakturyUlozisteDataPK[ vazbaFakturyUlozisteDataFakturyId=" + vazbaFakturyUlozisteDataFakturyId + ", vazbaFakturyUlozisteDataDataUlozisteId=" + vazbaFakturyUlozisteDataDataUlozisteId + " ]";
    }
    
}
