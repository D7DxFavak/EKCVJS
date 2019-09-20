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
public class KatalogovyListPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "katalogovy_list_id")
    private int katalogovyListId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "katalogovy_list_prihlasky_id")
    private int katalogovyListPrihlaskyId;

    public KatalogovyListPK() {
    }

    public KatalogovyListPK(int katalogovyListId, int katalogovyListPrihlaskyId) {
        this.katalogovyListId = katalogovyListId;
        this.katalogovyListPrihlaskyId = katalogovyListPrihlaskyId;
    }

    public int getKatalogovyListId() {
        return katalogovyListId;
    }

    public void setKatalogovyListId(int katalogovyListId) {
        this.katalogovyListId = katalogovyListId;
    }

    public int getKatalogovyListPrihlaskyId() {
        return katalogovyListPrihlaskyId;
    }

    public void setKatalogovyListPrihlaskyId(int katalogovyListPrihlaskyId) {
        this.katalogovyListPrihlaskyId = katalogovyListPrihlaskyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) katalogovyListId;
        hash += (int) katalogovyListPrihlaskyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatalogovyListPK)) {
            return false;
        }
        KatalogovyListPK other = (KatalogovyListPK) object;
        if (this.katalogovyListId != other.katalogovyListId) {
            return false;
        }
        if (this.katalogovyListPrihlaskyId != other.katalogovyListPrihlaskyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KatalogovyListPK[ katalogovyListId=" + katalogovyListId + ", katalogovyListPrihlaskyId=" + katalogovyListPrihlaskyId + " ]";
    }
    
}
