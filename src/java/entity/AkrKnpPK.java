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
public class AkrKnpPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_knt_id")
    private int akrKntId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_knp_id")
    private int akrKnpId;

    public AkrKnpPK() {
    }

    public AkrKnpPK(int akrKntId, int akrKnpId) {
        this.akrKntId = akrKntId;
        this.akrKnpId = akrKnpId;
    }

    public int getAkrKntId() {
        return akrKntId;
    }

    public void setAkrKntId(int akrKntId) {
        this.akrKntId = akrKntId;
    }

    public int getAkrKnpId() {
        return akrKnpId;
    }

    public void setAkrKnpId(int akrKnpId) {
        this.akrKnpId = akrKnpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akrKntId;
        hash += (int) akrKnpId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrKnpPK)) {
            return false;
        }
        AkrKnpPK other = (AkrKnpPK) object;
        if (this.akrKntId != other.akrKntId) {
            return false;
        }
        if (this.akrKnpId != other.akrKnpId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrKnpPK[ akrKntId=" + akrKntId + ", akrKnpId=" + akrKnpId + " ]";
    }
    
}
