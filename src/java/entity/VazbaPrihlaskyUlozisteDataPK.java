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
public class VazbaPrihlaskyUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_prihlasky_uloziste_data_prihlasky_id")
    private int vazbaPrihlaskyUlozisteDataPrihlaskyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_prihlasky_uloziste_data_data_uloziste_id")
    private int vazbaPrihlaskyUlozisteDataDataUlozisteId;

    public VazbaPrihlaskyUlozisteDataPK() {
    }

    public VazbaPrihlaskyUlozisteDataPK(int vazbaPrihlaskyUlozisteDataPrihlaskyId, int vazbaPrihlaskyUlozisteDataDataUlozisteId) {
        this.vazbaPrihlaskyUlozisteDataPrihlaskyId = vazbaPrihlaskyUlozisteDataPrihlaskyId;
        this.vazbaPrihlaskyUlozisteDataDataUlozisteId = vazbaPrihlaskyUlozisteDataDataUlozisteId;
    }

    public int getVazbaPrihlaskyUlozisteDataPrihlaskyId() {
        return vazbaPrihlaskyUlozisteDataPrihlaskyId;
    }

    public void setVazbaPrihlaskyUlozisteDataPrihlaskyId(int vazbaPrihlaskyUlozisteDataPrihlaskyId) {
        this.vazbaPrihlaskyUlozisteDataPrihlaskyId = vazbaPrihlaskyUlozisteDataPrihlaskyId;
    }

    public int getVazbaPrihlaskyUlozisteDataDataUlozisteId() {
        return vazbaPrihlaskyUlozisteDataDataUlozisteId;
    }

    public void setVazbaPrihlaskyUlozisteDataDataUlozisteId(int vazbaPrihlaskyUlozisteDataDataUlozisteId) {
        this.vazbaPrihlaskyUlozisteDataDataUlozisteId = vazbaPrihlaskyUlozisteDataDataUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaPrihlaskyUlozisteDataPrihlaskyId;
        hash += (int) vazbaPrihlaskyUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaPrihlaskyUlozisteDataPK)) {
            return false;
        }
        VazbaPrihlaskyUlozisteDataPK other = (VazbaPrihlaskyUlozisteDataPK) object;
        if (this.vazbaPrihlaskyUlozisteDataPrihlaskyId != other.vazbaPrihlaskyUlozisteDataPrihlaskyId) {
            return false;
        }
        if (this.vazbaPrihlaskyUlozisteDataDataUlozisteId != other.vazbaPrihlaskyUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaPrihlaskyUlozisteDataPK[ vazbaPrihlaskyUlozisteDataPrihlaskyId=" + vazbaPrihlaskyUlozisteDataPrihlaskyId + ", vazbaPrihlaskyUlozisteDataDataUlozisteId=" + vazbaPrihlaskyUlozisteDataDataUlozisteId + " ]";
    }
    
}
