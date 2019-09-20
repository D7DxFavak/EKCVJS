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
public class AkceKalkulaceNakladyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_knt_id")
    private int akceKntId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_knp_id")
    private int akceKnpId;

    public AkceKalkulaceNakladyPK() {
    }

    public AkceKalkulaceNakladyPK(int akceId, int akceKntId, int akceKnpId) {
        this.akceId = akceId;
        this.akceKntId = akceKntId;
        this.akceKnpId = akceKnpId;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
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
        hash += (int) akceId;
        hash += (int) akceKntId;
        hash += (int) akceKnpId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulaceNakladyPK)) {
            return false;
        }
        AkceKalkulaceNakladyPK other = (AkceKalkulaceNakladyPK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
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
        return "entity.AkceKalkulaceNakladyPK[ akceId=" + akceId + ", akceKntId=" + akceKntId + ", akceKnpId=" + akceKnpId + " ]";
    }
    
}
