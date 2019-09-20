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
public class OboryVazbySkupinyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "obory_vazby_skupiny_obory_id")
    private int oboryVazbySkupinyOboryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obory_vazby_skupiny_obory_skupiny_id")
    private int oboryVazbySkupinyOborySkupinyId;

    public OboryVazbySkupinyPK() {
    }

    public OboryVazbySkupinyPK(int oboryVazbySkupinyOboryId, int oboryVazbySkupinyOborySkupinyId) {
        this.oboryVazbySkupinyOboryId = oboryVazbySkupinyOboryId;
        this.oboryVazbySkupinyOborySkupinyId = oboryVazbySkupinyOborySkupinyId;
    }

    public int getOboryVazbySkupinyOboryId() {
        return oboryVazbySkupinyOboryId;
    }

    public void setOboryVazbySkupinyOboryId(int oboryVazbySkupinyOboryId) {
        this.oboryVazbySkupinyOboryId = oboryVazbySkupinyOboryId;
    }

    public int getOboryVazbySkupinyOborySkupinyId() {
        return oboryVazbySkupinyOborySkupinyId;
    }

    public void setOboryVazbySkupinyOborySkupinyId(int oboryVazbySkupinyOborySkupinyId) {
        this.oboryVazbySkupinyOborySkupinyId = oboryVazbySkupinyOborySkupinyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) oboryVazbySkupinyOboryId;
        hash += (int) oboryVazbySkupinyOborySkupinyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OboryVazbySkupinyPK)) {
            return false;
        }
        OboryVazbySkupinyPK other = (OboryVazbySkupinyPK) object;
        if (this.oboryVazbySkupinyOboryId != other.oboryVazbySkupinyOboryId) {
            return false;
        }
        if (this.oboryVazbySkupinyOborySkupinyId != other.oboryVazbySkupinyOborySkupinyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OboryVazbySkupinyPK[ oboryVazbySkupinyOboryId=" + oboryVazbySkupinyOboryId + ", oboryVazbySkupinyOborySkupinyId=" + oboryVazbySkupinyOborySkupinyId + " ]";
    }
    
}
