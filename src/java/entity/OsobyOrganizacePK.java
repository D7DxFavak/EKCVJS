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
public class OsobyOrganizacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "osoba_id")
    private int osobaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizace_id")
    private int organizaceId;

    public OsobyOrganizacePK() {
    }

    public OsobyOrganizacePK(int osobaId, int organizaceId) {
        this.osobaId = osobaId;
        this.organizaceId = organizaceId;
    }

    public int getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(int osobaId) {
        this.osobaId = osobaId;
    }

    public int getOrganizaceId() {
        return organizaceId;
    }

    public void setOrganizaceId(int organizaceId) {
        this.organizaceId = organizaceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) osobaId;
        hash += (int) organizaceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyOrganizacePK)) {
            return false;
        }
        OsobyOrganizacePK other = (OsobyOrganizacePK) object;
        if (this.osobaId != other.osobaId) {
            return false;
        }
        if (this.organizaceId != other.organizaceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OsobyOrganizacePK[ osobaId=" + osobaId + ", organizaceId=" + organizaceId + " ]";
    }
    
}
