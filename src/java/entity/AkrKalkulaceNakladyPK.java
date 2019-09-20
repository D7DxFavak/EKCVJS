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
public class AkrKalkulaceNakladyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akreditace_id")
    private int akreditaceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akreditace_poradi")
    private int akreditacePoradi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_knt_id")
    private int akrKntId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_knp_id")
    private int akrKnpId;

    public AkrKalkulaceNakladyPK() {
    }

    public AkrKalkulaceNakladyPK(int akreditaceId, int akreditacePoradi, int akrKntId, int akrKnpId) {
        this.akreditaceId = akreditaceId;
        this.akreditacePoradi = akreditacePoradi;
        this.akrKntId = akrKntId;
        this.akrKnpId = akrKnpId;
    }

    public int getAkreditaceId() {
        return akreditaceId;
    }

    public void setAkreditaceId(int akreditaceId) {
        this.akreditaceId = akreditaceId;
    }

    public int getAkreditacePoradi() {
        return akreditacePoradi;
    }

    public void setAkreditacePoradi(int akreditacePoradi) {
        this.akreditacePoradi = akreditacePoradi;
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
        hash += (int) akreditaceId;
        hash += (int) akreditacePoradi;
        hash += (int) akrKntId;
        hash += (int) akrKnpId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrKalkulaceNakladyPK)) {
            return false;
        }
        AkrKalkulaceNakladyPK other = (AkrKalkulaceNakladyPK) object;
        if (this.akreditaceId != other.akreditaceId) {
            return false;
        }
        if (this.akreditacePoradi != other.akreditacePoradi) {
            return false;
        }
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
        return "entity.AkrKalkulaceNakladyPK[ akreditaceId=" + akreditaceId + ", akreditacePoradi=" + akreditacePoradi + ", akrKntId=" + akrKntId + ", akrKnpId=" + akrKnpId + " ]";
    }
    
}
