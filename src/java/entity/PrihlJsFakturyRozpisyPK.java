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
public class PrihlJsFakturyRozpisyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "polozka_prihl")
    private int polozkaPrihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cislo_faktury")
    private int cisloFaktury;

    public PrihlJsFakturyRozpisyPK() {
    }

    public PrihlJsFakturyRozpisyPK(int polozkaPrihl, int cisloFaktury) {
        this.polozkaPrihl = polozkaPrihl;
        this.cisloFaktury = cisloFaktury;
    }

    public int getPolozkaPrihl() {
        return polozkaPrihl;
    }

    public void setPolozkaPrihl(int polozkaPrihl) {
        this.polozkaPrihl = polozkaPrihl;
    }

    public int getCisloFaktury() {
        return cisloFaktury;
    }

    public void setCisloFaktury(int cisloFaktury) {
        this.cisloFaktury = cisloFaktury;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) polozkaPrihl;
        hash += (int) cisloFaktury;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlJsFakturyRozpisyPK)) {
            return false;
        }
        PrihlJsFakturyRozpisyPK other = (PrihlJsFakturyRozpisyPK) object;
        if (this.polozkaPrihl != other.polozkaPrihl) {
            return false;
        }
        if (this.cisloFaktury != other.cisloFaktury) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlJsFakturyRozpisyPK[ polozkaPrihl=" + polozkaPrihl + ", cisloFaktury=" + cisloFaktury + " ]";
    }
    
}
