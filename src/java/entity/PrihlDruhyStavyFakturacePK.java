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
public class PrihlDruhyStavyFakturacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihl_druhy_stavy_fakturace_druh_faktury")
    private int prihlDruhyStavyFakturaceDruhFaktury;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihl_druhy_stavy_fakturace_druh_prihlasky")
    private int prihlDruhyStavyFakturaceDruhPrihlasky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihl_druhy_stavy_fakturace_stav_prihlasky")
    private int prihlDruhyStavyFakturaceStavPrihlasky;

    public PrihlDruhyStavyFakturacePK() {
    }

    public PrihlDruhyStavyFakturacePK(int prihlDruhyStavyFakturaceDruhFaktury, int prihlDruhyStavyFakturaceDruhPrihlasky, int prihlDruhyStavyFakturaceStavPrihlasky) {
        this.prihlDruhyStavyFakturaceDruhFaktury = prihlDruhyStavyFakturaceDruhFaktury;
        this.prihlDruhyStavyFakturaceDruhPrihlasky = prihlDruhyStavyFakturaceDruhPrihlasky;
        this.prihlDruhyStavyFakturaceStavPrihlasky = prihlDruhyStavyFakturaceStavPrihlasky;
    }

    public int getPrihlDruhyStavyFakturaceDruhFaktury() {
        return prihlDruhyStavyFakturaceDruhFaktury;
    }

    public void setPrihlDruhyStavyFakturaceDruhFaktury(int prihlDruhyStavyFakturaceDruhFaktury) {
        this.prihlDruhyStavyFakturaceDruhFaktury = prihlDruhyStavyFakturaceDruhFaktury;
    }

    public int getPrihlDruhyStavyFakturaceDruhPrihlasky() {
        return prihlDruhyStavyFakturaceDruhPrihlasky;
    }

    public void setPrihlDruhyStavyFakturaceDruhPrihlasky(int prihlDruhyStavyFakturaceDruhPrihlasky) {
        this.prihlDruhyStavyFakturaceDruhPrihlasky = prihlDruhyStavyFakturaceDruhPrihlasky;
    }

    public int getPrihlDruhyStavyFakturaceStavPrihlasky() {
        return prihlDruhyStavyFakturaceStavPrihlasky;
    }

    public void setPrihlDruhyStavyFakturaceStavPrihlasky(int prihlDruhyStavyFakturaceStavPrihlasky) {
        this.prihlDruhyStavyFakturaceStavPrihlasky = prihlDruhyStavyFakturaceStavPrihlasky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prihlDruhyStavyFakturaceDruhFaktury;
        hash += (int) prihlDruhyStavyFakturaceDruhPrihlasky;
        hash += (int) prihlDruhyStavyFakturaceStavPrihlasky;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlDruhyStavyFakturacePK)) {
            return false;
        }
        PrihlDruhyStavyFakturacePK other = (PrihlDruhyStavyFakturacePK) object;
        if (this.prihlDruhyStavyFakturaceDruhFaktury != other.prihlDruhyStavyFakturaceDruhFaktury) {
            return false;
        }
        if (this.prihlDruhyStavyFakturaceDruhPrihlasky != other.prihlDruhyStavyFakturaceDruhPrihlasky) {
            return false;
        }
        if (this.prihlDruhyStavyFakturaceStavPrihlasky != other.prihlDruhyStavyFakturaceStavPrihlasky) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlDruhyStavyFakturacePK[ prihlDruhyStavyFakturaceDruhFaktury=" + prihlDruhyStavyFakturaceDruhFaktury + ", prihlDruhyStavyFakturaceDruhPrihlasky=" + prihlDruhyStavyFakturaceDruhPrihlasky + ", prihlDruhyStavyFakturaceStavPrihlasky=" + prihlDruhyStavyFakturaceStavPrihlasky + " ]";
    }
    
}
