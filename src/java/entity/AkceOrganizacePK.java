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
public class AkceOrganizacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizace")
    private int organizace;

    public AkceOrganizacePK() {
    }

    public AkceOrganizacePK(int akceId, int organizace) {
        this.akceId = akceId;
        this.organizace = organizace;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
    }

    public int getOrganizace() {
        return organizace;
    }

    public void setOrganizace(int organizace) {
        this.organizace = organizace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) organizace;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceOrganizacePK)) {
            return false;
        }
        AkceOrganizacePK other = (AkceOrganizacePK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.organizace != other.organizace) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceOrganizacePK[ akceId=" + akceId + ", organizace=" + organizace + " ]";
    }
    
}
