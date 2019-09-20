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
public class VazbaAkreditaceUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_akreditace_id")
    private int vazbaOsobyUlozisteDataAkreditaceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_akreditace_poradi_id")
    private int vazbaOsobyUlozisteDataAkreditacePoradiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_akreditace_uloziste_id")
    private int vazbaOsobyUlozisteDataAkreditaceUlozisteId;

    public VazbaAkreditaceUlozisteDataPK() {
    }

    public VazbaAkreditaceUlozisteDataPK(int vazbaOsobyUlozisteDataAkreditaceId, int vazbaOsobyUlozisteDataAkreditacePoradiId, int vazbaOsobyUlozisteDataAkreditaceUlozisteId) {
        this.vazbaOsobyUlozisteDataAkreditaceId = vazbaOsobyUlozisteDataAkreditaceId;
        this.vazbaOsobyUlozisteDataAkreditacePoradiId = vazbaOsobyUlozisteDataAkreditacePoradiId;
        this.vazbaOsobyUlozisteDataAkreditaceUlozisteId = vazbaOsobyUlozisteDataAkreditaceUlozisteId;
    }

    public int getVazbaOsobyUlozisteDataAkreditaceId() {
        return vazbaOsobyUlozisteDataAkreditaceId;
    }

    public void setVazbaOsobyUlozisteDataAkreditaceId(int vazbaOsobyUlozisteDataAkreditaceId) {
        this.vazbaOsobyUlozisteDataAkreditaceId = vazbaOsobyUlozisteDataAkreditaceId;
    }

    public int getVazbaOsobyUlozisteDataAkreditacePoradiId() {
        return vazbaOsobyUlozisteDataAkreditacePoradiId;
    }

    public void setVazbaOsobyUlozisteDataAkreditacePoradiId(int vazbaOsobyUlozisteDataAkreditacePoradiId) {
        this.vazbaOsobyUlozisteDataAkreditacePoradiId = vazbaOsobyUlozisteDataAkreditacePoradiId;
    }

    public int getVazbaOsobyUlozisteDataAkreditaceUlozisteId() {
        return vazbaOsobyUlozisteDataAkreditaceUlozisteId;
    }

    public void setVazbaOsobyUlozisteDataAkreditaceUlozisteId(int vazbaOsobyUlozisteDataAkreditaceUlozisteId) {
        this.vazbaOsobyUlozisteDataAkreditaceUlozisteId = vazbaOsobyUlozisteDataAkreditaceUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaOsobyUlozisteDataAkreditaceId;
        hash += (int) vazbaOsobyUlozisteDataAkreditacePoradiId;
        hash += (int) vazbaOsobyUlozisteDataAkreditaceUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaAkreditaceUlozisteDataPK)) {
            return false;
        }
        VazbaAkreditaceUlozisteDataPK other = (VazbaAkreditaceUlozisteDataPK) object;
        if (this.vazbaOsobyUlozisteDataAkreditaceId != other.vazbaOsobyUlozisteDataAkreditaceId) {
            return false;
        }
        if (this.vazbaOsobyUlozisteDataAkreditacePoradiId != other.vazbaOsobyUlozisteDataAkreditacePoradiId) {
            return false;
        }
        if (this.vazbaOsobyUlozisteDataAkreditaceUlozisteId != other.vazbaOsobyUlozisteDataAkreditaceUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaAkreditaceUlozisteDataPK[ vazbaOsobyUlozisteDataAkreditaceId=" + vazbaOsobyUlozisteDataAkreditaceId + ", vazbaOsobyUlozisteDataAkreditacePoradiId=" + vazbaOsobyUlozisteDataAkreditacePoradiId + ", vazbaOsobyUlozisteDataAkreditaceUlozisteId=" + vazbaOsobyUlozisteDataAkreditaceUlozisteId + " ]";
    }
    
}
