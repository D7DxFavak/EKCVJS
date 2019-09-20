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
public class VyberPrihlaskyJsFakturacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihl_polozka")
    private int prihlPolozka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "druhprihl")
    private int druhprihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fakt_druh")
    private int faktDruh;

    public VyberPrihlaskyJsFakturacePK() {
    }

    public VyberPrihlaskyJsFakturacePK(int prihlPolozka, int druhprihl, int faktDruh) {
        this.prihlPolozka = prihlPolozka;
        this.druhprihl = druhprihl;
        this.faktDruh = faktDruh;
    }

    public int getPrihlPolozka() {
        return prihlPolozka;
    }

    public void setPrihlPolozka(int prihlPolozka) {
        this.prihlPolozka = prihlPolozka;
    }

    public int getDruhprihl() {
        return druhprihl;
    }

    public void setDruhprihl(int druhprihl) {
        this.druhprihl = druhprihl;
    }

    public int getFaktDruh() {
        return faktDruh;
    }

    public void setFaktDruh(int faktDruh) {
        this.faktDruh = faktDruh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prihlPolozka;
        hash += (int) druhprihl;
        hash += (int) faktDruh;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VyberPrihlaskyJsFakturacePK)) {
            return false;
        }
        VyberPrihlaskyJsFakturacePK other = (VyberPrihlaskyJsFakturacePK) object;
        if (this.prihlPolozka != other.prihlPolozka) {
            return false;
        }
        if (this.druhprihl != other.druhprihl) {
            return false;
        }
        if (this.faktDruh != other.faktDruh) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VyberPrihlaskyJsFakturacePK[ prihlPolozka=" + prihlPolozka + ", druhprihl=" + druhprihl + ", faktDruh=" + faktDruh + " ]";
    }
    
}
