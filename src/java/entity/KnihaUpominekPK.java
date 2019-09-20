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
public class KnihaUpominekPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cislo_faktury")
    private int cisloFaktury;
    @Basic(optional = false)
    @NotNull
    @Column(name = "druh_upominky")
    private int druhUpominky;

    public KnihaUpominekPK() {
    }

    public KnihaUpominekPK(int cisloFaktury, int druhUpominky) {
        this.cisloFaktury = cisloFaktury;
        this.druhUpominky = druhUpominky;
    }

    public int getCisloFaktury() {
        return cisloFaktury;
    }

    public void setCisloFaktury(int cisloFaktury) {
        this.cisloFaktury = cisloFaktury;
    }

    public int getDruhUpominky() {
        return druhUpominky;
    }

    public void setDruhUpominky(int druhUpominky) {
        this.druhUpominky = druhUpominky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cisloFaktury;
        hash += (int) druhUpominky;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnihaUpominekPK)) {
            return false;
        }
        KnihaUpominekPK other = (KnihaUpominekPK) object;
        if (this.cisloFaktury != other.cisloFaktury) {
            return false;
        }
        if (this.druhUpominky != other.druhUpominky) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KnihaUpominekPK[ cisloFaktury=" + cisloFaktury + ", druhUpominky=" + druhUpominky + " ]";
    }
    
}
