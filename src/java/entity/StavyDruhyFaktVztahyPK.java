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
public class StavyDruhyFaktVztahyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "stav_prihl_id")
    private int stavPrihlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "druhprihl_id")
    private int druhprihlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "povoluje_druhfakt_id")
    private int povolujeDruhfaktId;

    public StavyDruhyFaktVztahyPK() {
    }

    public StavyDruhyFaktVztahyPK(int stavPrihlId, int druhprihlId, int povolujeDruhfaktId) {
        this.stavPrihlId = stavPrihlId;
        this.druhprihlId = druhprihlId;
        this.povolujeDruhfaktId = povolujeDruhfaktId;
    }

    public int getStavPrihlId() {
        return stavPrihlId;
    }

    public void setStavPrihlId(int stavPrihlId) {
        this.stavPrihlId = stavPrihlId;
    }

    public int getDruhprihlId() {
        return druhprihlId;
    }

    public void setDruhprihlId(int druhprihlId) {
        this.druhprihlId = druhprihlId;
    }

    public int getPovolujeDruhfaktId() {
        return povolujeDruhfaktId;
    }

    public void setPovolujeDruhfaktId(int povolujeDruhfaktId) {
        this.povolujeDruhfaktId = povolujeDruhfaktId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) stavPrihlId;
        hash += (int) druhprihlId;
        hash += (int) povolujeDruhfaktId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavyDruhyFaktVztahyPK)) {
            return false;
        }
        StavyDruhyFaktVztahyPK other = (StavyDruhyFaktVztahyPK) object;
        if (this.stavPrihlId != other.stavPrihlId) {
            return false;
        }
        if (this.druhprihlId != other.druhprihlId) {
            return false;
        }
        if (this.povolujeDruhfaktId != other.povolujeDruhfaktId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StavyDruhyFaktVztahyPK[ stavPrihlId=" + stavPrihlId + ", druhprihlId=" + druhprihlId + ", povolujeDruhfaktId=" + povolujeDruhfaktId + " ]";
    }
    
}
