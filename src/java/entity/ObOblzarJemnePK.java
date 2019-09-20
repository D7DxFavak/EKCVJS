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
public class ObOblzarJemnePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "oblzar_hrube_id")
    private int oblzarHrubeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oblzar_jemne_id")
    private int oblzarJemneId;

    public ObOblzarJemnePK() {
    }

    public ObOblzarJemnePK(int oblzarHrubeId, int oblzarJemneId) {
        this.oblzarHrubeId = oblzarHrubeId;
        this.oblzarJemneId = oblzarJemneId;
    }

    public int getOblzarHrubeId() {
        return oblzarHrubeId;
    }

    public void setOblzarHrubeId(int oblzarHrubeId) {
        this.oblzarHrubeId = oblzarHrubeId;
    }

    public int getOblzarJemneId() {
        return oblzarJemneId;
    }

    public void setOblzarJemneId(int oblzarJemneId) {
        this.oblzarJemneId = oblzarJemneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) oblzarHrubeId;
        hash += (int) oblzarJemneId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObOblzarJemnePK)) {
            return false;
        }
        ObOblzarJemnePK other = (ObOblzarJemnePK) object;
        if (this.oblzarHrubeId != other.oblzarHrubeId) {
            return false;
        }
        if (this.oblzarJemneId != other.oblzarJemneId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObOblzarJemnePK[ oblzarHrubeId=" + oblzarHrubeId + ", oblzarJemneId=" + oblzarJemneId + " ]";
    }
    
}
