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
public class OboryMetodickySborPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "obor_id")
    private int oborId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obormetodik")
    private int obormetodik;

    public OboryMetodickySborPK() {
    }

    public OboryMetodickySborPK(int oborId, int obormetodik) {
        this.oborId = oborId;
        this.obormetodik = obormetodik;
    }

    public int getOborId() {
        return oborId;
    }

    public void setOborId(int oborId) {
        this.oborId = oborId;
    }

    public int getObormetodik() {
        return obormetodik;
    }

    public void setObormetodik(int obormetodik) {
        this.obormetodik = obormetodik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) oborId;
        hash += (int) obormetodik;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OboryMetodickySborPK)) {
            return false;
        }
        OboryMetodickySborPK other = (OboryMetodickySborPK) object;
        if (this.oborId != other.oborId) {
            return false;
        }
        if (this.obormetodik != other.obormetodik) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OboryMetodickySborPK[ oborId=" + oborId + ", obormetodik=" + obormetodik + " ]";
    }
    
}
