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
public class VazbaGalerieUlozistePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_galerie_uloziste_galerie")
    private int vazbaGalerieUlozisteGalerie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_galerie_uloziste_uloziste")
    private int vazbaGalerieUlozisteUloziste;

    public VazbaGalerieUlozistePK() {
    }

    public VazbaGalerieUlozistePK(int vazbaGalerieUlozisteGalerie, int vazbaGalerieUlozisteUloziste) {
        this.vazbaGalerieUlozisteGalerie = vazbaGalerieUlozisteGalerie;
        this.vazbaGalerieUlozisteUloziste = vazbaGalerieUlozisteUloziste;
    }

    public int getVazbaGalerieUlozisteGalerie() {
        return vazbaGalerieUlozisteGalerie;
    }

    public void setVazbaGalerieUlozisteGalerie(int vazbaGalerieUlozisteGalerie) {
        this.vazbaGalerieUlozisteGalerie = vazbaGalerieUlozisteGalerie;
    }

    public int getVazbaGalerieUlozisteUloziste() {
        return vazbaGalerieUlozisteUloziste;
    }

    public void setVazbaGalerieUlozisteUloziste(int vazbaGalerieUlozisteUloziste) {
        this.vazbaGalerieUlozisteUloziste = vazbaGalerieUlozisteUloziste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vazbaGalerieUlozisteGalerie;
        hash += (int) vazbaGalerieUlozisteUloziste;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaGalerieUlozistePK)) {
            return false;
        }
        VazbaGalerieUlozistePK other = (VazbaGalerieUlozistePK) object;
        if (this.vazbaGalerieUlozisteGalerie != other.vazbaGalerieUlozisteGalerie) {
            return false;
        }
        if (this.vazbaGalerieUlozisteUloziste != other.vazbaGalerieUlozisteUloziste) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaGalerieUlozistePK[ vazbaGalerieUlozisteGalerie=" + vazbaGalerieUlozisteGalerie + ", vazbaGalerieUlozisteUloziste=" + vazbaGalerieUlozisteUloziste + " ]";
    }
    
}
