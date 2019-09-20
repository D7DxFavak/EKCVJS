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
public class AkceCilskupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cilskup")
    private int cilskup;

    public AkceCilskupPK() {
    }

    public AkceCilskupPK(int akceId, int cilskup) {
        this.akceId = akceId;
        this.cilskup = cilskup;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
    }

    public int getCilskup() {
        return cilskup;
    }

    public void setCilskup(int cilskup) {
        this.cilskup = cilskup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) cilskup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceCilskupPK)) {
            return false;
        }
        AkceCilskupPK other = (AkceCilskupPK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.cilskup != other.cilskup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceCilskupPK[ akceId=" + akceId + ", cilskup=" + cilskup + " ]";
    }
    
}
