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
 * @author Favak
 */
@Embeddable
public class VazbaOrganizaceUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_organizace_uloziste_data_organizace_id")
    private int vazbaOrganizaceUlozisteDataOrganizaceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_organizace_uloziste_data_data_uloziste_id")
    private int vazbaOrganizaceUlozisteDataDataUlozisteId;

    public VazbaOrganizaceUlozisteDataPK() {
    }

    public VazbaOrganizaceUlozisteDataPK(int vazbaOrganizaceUlozisteDataOrganizaceId, int vazbaOrganizaceUlozisteDataDataUlozisteId) {
        this.vazbaOrganizaceUlozisteDataOrganizaceId = vazbaOrganizaceUlozisteDataOrganizaceId;
        this.vazbaOrganizaceUlozisteDataDataUlozisteId = vazbaOrganizaceUlozisteDataDataUlozisteId;
    }

    public int getVazbaOrganizaceUlozisteDataOrganizaceId() {
        return vazbaOrganizaceUlozisteDataOrganizaceId;
    }

    public void setVazbaOrganizaceUlozisteDataOrganizaceId(int vazbaOrganizaceUlozisteDataOrganizaceId) {
        this.vazbaOrganizaceUlozisteDataOrganizaceId = vazbaOrganizaceUlozisteDataOrganizaceId;
    }

    public int getVazbaOrganizaceUlozisteDataDataUlozisteId() {
        return vazbaOrganizaceUlozisteDataDataUlozisteId;
    }

    public void setVazbaOrganizaceUlozisteDataDataUlozisteId(int vazbaOrganizaceUlozisteDataDataUlozisteId) {
        this.vazbaOrganizaceUlozisteDataDataUlozisteId = vazbaOrganizaceUlozisteDataDataUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaOrganizaceUlozisteDataOrganizaceId;
        hash += (int) vazbaOrganizaceUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaOrganizaceUlozisteDataPK)) {
            return false;
        }
        VazbaOrganizaceUlozisteDataPK other = (VazbaOrganizaceUlozisteDataPK) object;
        if (this.vazbaOrganizaceUlozisteDataOrganizaceId != other.vazbaOrganizaceUlozisteDataOrganizaceId) {
            return false;
        }
        if (this.vazbaOrganizaceUlozisteDataDataUlozisteId != other.vazbaOrganizaceUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaOrganizaceUlozisteDataPK[ vazbaOrganizaceUlozisteDataOrganizaceId=" + vazbaOrganizaceUlozisteDataOrganizaceId + ", vazbaOrganizaceUlozisteDataDataUlozisteId=" + vazbaOrganizaceUlozisteDataDataUlozisteId + " ]";
    }
    
}
