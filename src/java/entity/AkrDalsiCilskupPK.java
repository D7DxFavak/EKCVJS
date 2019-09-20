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
public class AkrDalsiCilskupPK implements Serializable {
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
    @Column(name = "cilskup")
    private int cilskup;

    public AkrDalsiCilskupPK() {
    }

    public AkrDalsiCilskupPK(int akreditaceId, int akreditacePoradi, int cilskup) {
        this.akreditaceId = akreditaceId;
        this.akreditacePoradi = akreditacePoradi;
        this.cilskup = cilskup;
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

    public int getCilskup() {
        return cilskup;
    }

    public void setCilskup(int cilskup) {
        this.cilskup = cilskup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akreditaceId;
        hash += (int) akreditacePoradi;
        hash += (int) cilskup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrDalsiCilskupPK)) {
            return false;
        }
        AkrDalsiCilskupPK other = (AkrDalsiCilskupPK) object;
        if (this.akreditaceId != other.akreditaceId) {
            return false;
        }
        if (this.akreditacePoradi != other.akreditacePoradi) {
            return false;
        }
        if (this.cilskup != other.cilskup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrDalsiCilskupPK[ akreditaceId=" + akreditaceId + ", akreditacePoradi=" + akreditacePoradi + ", cilskup=" + cilskup + " ]";
    }
    
}
