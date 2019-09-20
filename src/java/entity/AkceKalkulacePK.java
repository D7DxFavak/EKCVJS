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
public class AkceKalkulacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_id")
    private int akceKalkulaceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_pid")
    private int akceKalkulacePid;

    public AkceKalkulacePK() {
    }

    public AkceKalkulacePK(int akceKalkulaceId, int akceKalkulacePid) {
        this.akceKalkulaceId = akceKalkulaceId;
        this.akceKalkulacePid = akceKalkulacePid;
    }

    public int getAkceKalkulaceId() {
        return akceKalkulaceId;
    }

    public void setAkceKalkulaceId(int akceKalkulaceId) {
        this.akceKalkulaceId = akceKalkulaceId;
    }

    public int getAkceKalkulacePid() {
        return akceKalkulacePid;
    }

    public void setAkceKalkulacePid(int akceKalkulacePid) {
        this.akceKalkulacePid = akceKalkulacePid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceKalkulaceId;
        hash += (int) akceKalkulacePid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulacePK)) {
            return false;
        }
        AkceKalkulacePK other = (AkceKalkulacePK) object;
        if (this.akceKalkulaceId != other.akceKalkulaceId) {
            return false;
        }
        if (this.akceKalkulacePid != other.akceKalkulacePid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulacePK[ akceKalkulaceId=" + akceKalkulaceId + ", akceKalkulacePid=" + akceKalkulacePid + " ]";
    }
    
}
