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
public class VazbaPrihlaskyJsUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_prihlasky_js_uloziste_data_prihlasky_id")
    private int vazbaPrihlaskyJsUlozisteDataPrihlaskyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_prihlasky_js_uloziste_data_data_uloziste_id")
    private int vazbaPrihlaskyJsUlozisteDataDataUlozisteId;

    public VazbaPrihlaskyJsUlozisteDataPK() {
    }

    public VazbaPrihlaskyJsUlozisteDataPK(int vazbaPrihlaskyJsUlozisteDataPrihlaskyId, int vazbaPrihlaskyJsUlozisteDataDataUlozisteId) {
        this.vazbaPrihlaskyJsUlozisteDataPrihlaskyId = vazbaPrihlaskyJsUlozisteDataPrihlaskyId;
        this.vazbaPrihlaskyJsUlozisteDataDataUlozisteId = vazbaPrihlaskyJsUlozisteDataDataUlozisteId;
    }

    public int getVazbaPrihlaskyJsUlozisteDataPrihlaskyId() {
        return vazbaPrihlaskyJsUlozisteDataPrihlaskyId;
    }

    public void setVazbaPrihlaskyJsUlozisteDataPrihlaskyId(int vazbaPrihlaskyJsUlozisteDataPrihlaskyId) {
        this.vazbaPrihlaskyJsUlozisteDataPrihlaskyId = vazbaPrihlaskyJsUlozisteDataPrihlaskyId;
    }

    public int getVazbaPrihlaskyJsUlozisteDataDataUlozisteId() {
        return vazbaPrihlaskyJsUlozisteDataDataUlozisteId;
    }

    public void setVazbaPrihlaskyJsUlozisteDataDataUlozisteId(int vazbaPrihlaskyJsUlozisteDataDataUlozisteId) {
        this.vazbaPrihlaskyJsUlozisteDataDataUlozisteId = vazbaPrihlaskyJsUlozisteDataDataUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaPrihlaskyJsUlozisteDataPrihlaskyId;
        hash += (int) vazbaPrihlaskyJsUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaPrihlaskyJsUlozisteDataPK)) {
            return false;
        }
        VazbaPrihlaskyJsUlozisteDataPK other = (VazbaPrihlaskyJsUlozisteDataPK) object;
        if (this.vazbaPrihlaskyJsUlozisteDataPrihlaskyId != other.vazbaPrihlaskyJsUlozisteDataPrihlaskyId) {
            return false;
        }
        if (this.vazbaPrihlaskyJsUlozisteDataDataUlozisteId != other.vazbaPrihlaskyJsUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaPrihlaskyJsUlozisteDataPK[ vazbaPrihlaskyJsUlozisteDataPrihlaskyId=" + vazbaPrihlaskyJsUlozisteDataPrihlaskyId + ", vazbaPrihlaskyJsUlozisteDataDataUlozisteId=" + vazbaPrihlaskyJsUlozisteDataDataUlozisteId + " ]";
    }
    
}
