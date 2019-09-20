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
public class AkcePokracovaniPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_pokr_id")
    private int akcePokrId;

    public AkcePokracovaniPK() {
    }

    public AkcePokracovaniPK(int akceId, int akcePokrId) {
        this.akceId = akceId;
        this.akcePokrId = akcePokrId;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
    }

    public int getAkcePokrId() {
        return akcePokrId;
    }

    public void setAkcePokrId(int akcePokrId) {
        this.akcePokrId = akcePokrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) akcePokrId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkcePokracovaniPK)) {
            return false;
        }
        AkcePokracovaniPK other = (AkcePokracovaniPK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.akcePokrId != other.akcePokrId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkcePokracovaniPK[ akceId=" + akceId + ", akcePokrId=" + akcePokrId + " ]";
    }
    
}
