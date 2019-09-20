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
public class AkceKnpPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_knt_id")
    private int akceKntId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_knp_id")
    private int akceKnpId;

    public AkceKnpPK() {
    }

    public AkceKnpPK(int akceKntId, int akceKnpId) {
        this.akceKntId = akceKntId;
        this.akceKnpId = akceKnpId;
    }

    public int getAkceKntId() {
        return akceKntId;
    }

    public void setAkceKntId(int akceKntId) {
        this.akceKntId = akceKntId;
    }

    public int getAkceKnpId() {
        return akceKnpId;
    }

    public void setAkceKnpId(int akceKnpId) {
        this.akceKnpId = akceKnpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceKntId;
        hash += (int) akceKnpId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKnpPK)) {
            return false;
        }
        AkceKnpPK other = (AkceKnpPK) object;
        if (this.akceKntId != other.akceKntId) {
            return false;
        }
        if (this.akceKnpId != other.akceKnpId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKnpPK[ akceKntId=" + akceKntId + ", akceKnpId=" + akceKnpId + " ]";
    }
    
}
