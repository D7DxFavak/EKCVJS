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
public class VazbaWebKategorieUlozisteDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_web_kategorie_uloziste_data_web_kategorie_id")
    private int vazbaWebKategorieUlozisteDataWebKategorieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_web_kategorie_uloziste_data_data_uloziste_id")
    private int vazbaWebKategorieUlozisteDataDataUlozisteId;

    public VazbaWebKategorieUlozisteDataPK() {
    }

    public VazbaWebKategorieUlozisteDataPK(int vazbaWebKategorieUlozisteDataWebKategorieId, int vazbaWebKategorieUlozisteDataDataUlozisteId) {
        this.vazbaWebKategorieUlozisteDataWebKategorieId = vazbaWebKategorieUlozisteDataWebKategorieId;
        this.vazbaWebKategorieUlozisteDataDataUlozisteId = vazbaWebKategorieUlozisteDataDataUlozisteId;
    }

    public int getVazbaWebKategorieUlozisteDataWebKategorieId() {
        return vazbaWebKategorieUlozisteDataWebKategorieId;
    }

    public void setVazbaWebKategorieUlozisteDataWebKategorieId(int vazbaWebKategorieUlozisteDataWebKategorieId) {
        this.vazbaWebKategorieUlozisteDataWebKategorieId = vazbaWebKategorieUlozisteDataWebKategorieId;
    }

    public int getVazbaWebKategorieUlozisteDataDataUlozisteId() {
        return vazbaWebKategorieUlozisteDataDataUlozisteId;
    }

    public void setVazbaWebKategorieUlozisteDataDataUlozisteId(int vazbaWebKategorieUlozisteDataDataUlozisteId) {
        this.vazbaWebKategorieUlozisteDataDataUlozisteId = vazbaWebKategorieUlozisteDataDataUlozisteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaWebKategorieUlozisteDataWebKategorieId;
        hash += (int) vazbaWebKategorieUlozisteDataDataUlozisteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaWebKategorieUlozisteDataPK)) {
            return false;
        }
        VazbaWebKategorieUlozisteDataPK other = (VazbaWebKategorieUlozisteDataPK) object;
        if (this.vazbaWebKategorieUlozisteDataWebKategorieId != other.vazbaWebKategorieUlozisteDataWebKategorieId) {
            return false;
        }
        if (this.vazbaWebKategorieUlozisteDataDataUlozisteId != other.vazbaWebKategorieUlozisteDataDataUlozisteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaWebKategorieUlozisteDataPK[ vazbaWebKategorieUlozisteDataWebKategorieId=" + vazbaWebKategorieUlozisteDataWebKategorieId + ", vazbaWebKategorieUlozisteDataDataUlozisteId=" + vazbaWebKategorieUlozisteDataDataUlozisteId + " ]";
    }
    
}
