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
public class AkceVyuctovaniPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_vyuctovani_id")
    private int akceVyuctovaniId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_vyuctovani_pid")
    private int akceVyuctovaniPid;

    public AkceVyuctovaniPK() {
    }

    public AkceVyuctovaniPK(int akceVyuctovaniId, int akceVyuctovaniPid) {
        this.akceVyuctovaniId = akceVyuctovaniId;
        this.akceVyuctovaniPid = akceVyuctovaniPid;
    }

    public int getAkceVyuctovaniId() {
        return akceVyuctovaniId;
    }

    public void setAkceVyuctovaniId(int akceVyuctovaniId) {
        this.akceVyuctovaniId = akceVyuctovaniId;
    }

    public int getAkceVyuctovaniPid() {
        return akceVyuctovaniPid;
    }

    public void setAkceVyuctovaniPid(int akceVyuctovaniPid) {
        this.akceVyuctovaniPid = akceVyuctovaniPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceVyuctovaniId;
        hash += (int) akceVyuctovaniPid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceVyuctovaniPK)) {
            return false;
        }
        AkceVyuctovaniPK other = (AkceVyuctovaniPK) object;
        if (this.akceVyuctovaniId != other.akceVyuctovaniId) {
            return false;
        }
        if (this.akceVyuctovaniPid != other.akceVyuctovaniPid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceVyuctovaniPK[ akceVyuctovaniId=" + akceVyuctovaniId + ", akceVyuctovaniPid=" + akceVyuctovaniPid + " ]";
    }
    
}
