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
public class AkceDalsiOboryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dalsiobor")
    private int dalsiobor;

    public AkceDalsiOboryPK() {
    }

    public AkceDalsiOboryPK(int akceId, int dalsiobor) {
        this.akceId = akceId;
        this.dalsiobor = dalsiobor;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
    }

    public int getDalsiobor() {
        return dalsiobor;
    }

    public void setDalsiobor(int dalsiobor) {
        this.dalsiobor = dalsiobor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) dalsiobor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceDalsiOboryPK)) {
            return false;
        }
        AkceDalsiOboryPK other = (AkceDalsiOboryPK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.dalsiobor != other.dalsiobor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceDalsiOboryPK[ akceId=" + akceId + ", dalsiobor=" + dalsiobor + " ]";
    }
    
}
