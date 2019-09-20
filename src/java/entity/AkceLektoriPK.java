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
public class AkceLektoriPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_lektor")
    private int akceLektor;

    public AkceLektoriPK() {
    }

    public AkceLektoriPK(int akceId, int akceLektor) {
        this.akceId = akceId;
        this.akceLektor = akceLektor;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
    }

    public int getAkceLektor() {
        return akceLektor;
    }

    public void setAkceLektor(int akceLektor) {
        this.akceLektor = akceLektor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) akceLektor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceLektoriPK)) {
            return false;
        }
        AkceLektoriPK other = (AkceLektoriPK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.akceLektor != other.akceLektor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceLektoriPK[ akceId=" + akceId + ", akceLektor=" + akceLektor + " ]";
    }
    
}
