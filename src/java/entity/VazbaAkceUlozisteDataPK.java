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
public class VazbaAkceUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_akce_id")
    private int vazbaOsobyUlozisteDataAkceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_data_uloziste_id")
    private int vazbaOsobyUlozisteDataDataUlozisteId;

    public VazbaAkceUlozisteDataPK() {
    }

    public VazbaAkceUlozisteDataPK(int vazbaOsobyUlozisteDataAkceId, int vazbaOsobyUlozisteDataDataUlozisteId) {
        this.vazbaOsobyUlozisteDataAkceId = vazbaOsobyUlozisteDataAkceId;
        this.vazbaOsobyUlozisteDataDataUlozisteId = vazbaOsobyUlozisteDataDataUlozisteId;
    }

    public int getVazbaOsobyUlozisteDataAkceId() {
        return vazbaOsobyUlozisteDataAkceId;
    }

    public void setVazbaOsobyUlozisteDataAkceId(int vazbaOsobyUlozisteDataAkceId) {
        this.vazbaOsobyUlozisteDataAkceId = vazbaOsobyUlozisteDataAkceId;
    }

    public int getVazbaOsobyUlozisteDataDataUlozisteId() {
        return vazbaOsobyUlozisteDataDataUlozisteId;
    }

    public void setVazbaOsobyUlozisteDataDataUlozisteId(int vazbaOsobyUlozisteDataDataUlozisteId) {
        this.vazbaOsobyUlozisteDataDataUlozisteId = vazbaOsobyUlozisteDataDataUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaOsobyUlozisteDataAkceId;
        hash += (int) vazbaOsobyUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaAkceUlozisteDataPK)) {
            return false;
        }
        VazbaAkceUlozisteDataPK other = (VazbaAkceUlozisteDataPK) object;
        if (this.vazbaOsobyUlozisteDataAkceId != other.vazbaOsobyUlozisteDataAkceId) {
            return false;
        }
        if (this.vazbaOsobyUlozisteDataDataUlozisteId != other.vazbaOsobyUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaAkceUlozisteDataPK[ vazbaOsobyUlozisteDataAkceId=" + vazbaOsobyUlozisteDataAkceId + ", vazbaOsobyUlozisteDataDataUlozisteId=" + vazbaOsobyUlozisteDataDataUlozisteId + " ]";
    }
    
}
