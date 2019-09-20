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
public class KatOrgPolozkyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "katorgtyp_id")
    private int katorgtypId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "katorgpol_id")
    private int katorgpolId;

    public KatOrgPolozkyPK() {
    }

    public KatOrgPolozkyPK(int katorgtypId, int katorgpolId) {
        this.katorgtypId = katorgtypId;
        this.katorgpolId = katorgpolId;
    }

    public int getKatorgtypId() {
        return katorgtypId;
    }

    public void setKatorgtypId(int katorgtypId) {
        this.katorgtypId = katorgtypId;
    }

    public int getKatorgpolId() {
        return katorgpolId;
    }

    public void setKatorgpolId(int katorgpolId) {
        this.katorgpolId = katorgpolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) katorgtypId;
        hash += (int) katorgpolId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatOrgPolozkyPK)) {
            return false;
        }
        KatOrgPolozkyPK other = (KatOrgPolozkyPK) object;
        if (this.katorgtypId != other.katorgtypId) {
            return false;
        }
        if (this.katorgpolId != other.katorgpolId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KatOrgPolozkyPK[ katorgtypId=" + katorgtypId + ", katorgpolId=" + katorgpolId + " ]";
    }
    
}
