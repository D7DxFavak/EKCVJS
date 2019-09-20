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
public class AkceNavaznostiPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_nav_id")
    private int akceNavId;

    public AkceNavaznostiPK() {
    }

    public AkceNavaznostiPK(int akceId, int akceNavId) {
        this.akceId = akceId;
        this.akceNavId = akceNavId;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
    }

    public int getAkceNavId() {
        return akceNavId;
    }

    public void setAkceNavId(int akceNavId) {
        this.akceNavId = akceNavId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) akceNavId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceNavaznostiPK)) {
            return false;
        }
        AkceNavaznostiPK other = (AkceNavaznostiPK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.akceNavId != other.akceNavId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceNavaznostiPK[ akceId=" + akceId + ", akceNavId=" + akceNavId + " ]";
    }
    
}
