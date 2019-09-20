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
public class VazbaPanelyDataUlozistePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_panely_data_uloziste_panel_data")
    private int vazbaPanelyDataUlozistePanelData;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_panely_data_uloziste_uloziste")
    private int vazbaPanelyDataUlozisteUloziste;

    public VazbaPanelyDataUlozistePK() {
    }

    public VazbaPanelyDataUlozistePK(int vazbaPanelyDataUlozistePanelData, int vazbaPanelyDataUlozisteUloziste) {
        this.vazbaPanelyDataUlozistePanelData = vazbaPanelyDataUlozistePanelData;
        this.vazbaPanelyDataUlozisteUloziste = vazbaPanelyDataUlozisteUloziste;
    }

    public int getVazbaPanelyDataUlozistePanelData() {
        return vazbaPanelyDataUlozistePanelData;
    }

    public void setVazbaPanelyDataUlozistePanelData(int vazbaPanelyDataUlozistePanelData) {
        this.vazbaPanelyDataUlozistePanelData = vazbaPanelyDataUlozistePanelData;
    }

    public int getVazbaPanelyDataUlozisteUloziste() {
        return vazbaPanelyDataUlozisteUloziste;
    }

    public void setVazbaPanelyDataUlozisteUloziste(int vazbaPanelyDataUlozisteUloziste) {
        this.vazbaPanelyDataUlozisteUloziste = vazbaPanelyDataUlozisteUloziste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaPanelyDataUlozistePanelData;
        hash += (int) vazbaPanelyDataUlozisteUloziste;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaPanelyDataUlozistePK)) {
            return false;
        }
        VazbaPanelyDataUlozistePK other = (VazbaPanelyDataUlozistePK) object;
        if (this.vazbaPanelyDataUlozistePanelData != other.vazbaPanelyDataUlozistePanelData) {
            return false;
        }
        if (this.vazbaPanelyDataUlozisteUloziste != other.vazbaPanelyDataUlozisteUloziste) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaPanelyDataUlozistePK[ vazbaPanelyDataUlozistePanelData=" + vazbaPanelyDataUlozistePanelData + ", vazbaPanelyDataUlozisteUloziste=" + vazbaPanelyDataUlozisteUloziste + " ]";
    }
    
}
