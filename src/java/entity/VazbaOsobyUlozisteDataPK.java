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
public class VazbaOsobyUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_osoba_id")
    private int vazbaOsobyUlozisteDataOsobaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_osoby_uloziste_data_data_uloziste_id")
    private int vazbaOsobyUlozisteDataDataUlozisteId;

    public VazbaOsobyUlozisteDataPK() {
    }

    public VazbaOsobyUlozisteDataPK(int vazbaOsobyUlozisteDataOsobaId, int vazbaOsobyUlozisteDataDataUlozisteId) {
        this.vazbaOsobyUlozisteDataOsobaId = vazbaOsobyUlozisteDataOsobaId;
        this.vazbaOsobyUlozisteDataDataUlozisteId = vazbaOsobyUlozisteDataDataUlozisteId;
    }

    public int getVazbaOsobyUlozisteDataOsobaId() {
        return vazbaOsobyUlozisteDataOsobaId;
    }

    public void setVazbaOsobyUlozisteDataOsobaId(int vazbaOsobyUlozisteDataOsobaId) {
        this.vazbaOsobyUlozisteDataOsobaId = vazbaOsobyUlozisteDataOsobaId;
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
        hash += (int) vazbaOsobyUlozisteDataOsobaId;
        hash += (int) vazbaOsobyUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaOsobyUlozisteDataPK)) {
            return false;
        }
        VazbaOsobyUlozisteDataPK other = (VazbaOsobyUlozisteDataPK) object;
        if (this.vazbaOsobyUlozisteDataOsobaId != other.vazbaOsobyUlozisteDataOsobaId) {
            return false;
        }
        if (this.vazbaOsobyUlozisteDataDataUlozisteId != other.vazbaOsobyUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaOsobyUlozisteDataPK[ vazbaOsobyUlozisteDataOsobaId=" + vazbaOsobyUlozisteDataOsobaId + ", vazbaOsobyUlozisteDataDataUlozisteId=" + vazbaOsobyUlozisteDataDataUlozisteId + " ]";
    }
    
}
