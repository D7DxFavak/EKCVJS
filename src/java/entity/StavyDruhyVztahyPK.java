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
public class StavyDruhyVztahyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "stav_prihl_id")
    private int stavPrihlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "povoluje_druhprihl_id")
    private int povolujeDruhprihlId;

    public StavyDruhyVztahyPK() {
    }

    public StavyDruhyVztahyPK(int stavPrihlId, int povolujeDruhprihlId) {
        this.stavPrihlId = stavPrihlId;
        this.povolujeDruhprihlId = povolujeDruhprihlId;
    }

    public int getStavPrihlId() {
        return stavPrihlId;
    }

    public void setStavPrihlId(int stavPrihlId) {
        this.stavPrihlId = stavPrihlId;
    }

    public int getPovolujeDruhprihlId() {
        return povolujeDruhprihlId;
    }

    public void setPovolujeDruhprihlId(int povolujeDruhprihlId) {
        this.povolujeDruhprihlId = povolujeDruhprihlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) stavPrihlId;
        hash += (int) povolujeDruhprihlId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavyDruhyVztahyPK)) {
            return false;
        }
        StavyDruhyVztahyPK other = (StavyDruhyVztahyPK) object;
        if (this.stavPrihlId != other.stavPrihlId) {
            return false;
        }
        if (this.povolujeDruhprihlId != other.povolujeDruhprihlId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StavyDruhyVztahyPK[ stavPrihlId=" + stavPrihlId + ", povolujeDruhprihlId=" + povolujeDruhprihlId + " ]";
    }
    
}
