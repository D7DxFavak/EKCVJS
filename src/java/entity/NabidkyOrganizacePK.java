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
public class NabidkyOrganizacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizace")
    private int organizace;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_nabidky")
    private int formaNabidky;

    public NabidkyOrganizacePK() {
    }

    public NabidkyOrganizacePK(int organizace, int formaNabidky) {
        this.organizace = organizace;
        this.formaNabidky = formaNabidky;
    }

    public int getOrganizace() {
        return organizace;
    }

    public void setOrganizace(int organizace) {
        this.organizace = organizace;
    }

    public int getFormaNabidky() {
        return formaNabidky;
    }

    public void setFormaNabidky(int formaNabidky) {
        this.formaNabidky = formaNabidky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) organizace;
        hash += (int) formaNabidky;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NabidkyOrganizacePK)) {
            return false;
        }
        NabidkyOrganizacePK other = (NabidkyOrganizacePK) object;
        if (this.organizace != other.organizace) {
            return false;
        }
        if (this.formaNabidky != other.formaNabidky) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NabidkyOrganizacePK[ organizace=" + organizace + ", formaNabidky=" + formaNabidky + " ]";
    }
    
}
