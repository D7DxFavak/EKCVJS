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
public class AkceKalkulaceVazbaSestavaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_vazba_sestava_id")
    private int akceKalkulaceVazbaSestavaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_kalkulace_vazba_sestava_pol_id")
    private int akceKalkulaceVazbaSestavaPolId;

    public AkceKalkulaceVazbaSestavaPK() {
    }

    public AkceKalkulaceVazbaSestavaPK(int akceKalkulaceVazbaSestavaId, int akceKalkulaceVazbaSestavaPolId) {
        this.akceKalkulaceVazbaSestavaId = akceKalkulaceVazbaSestavaId;
        this.akceKalkulaceVazbaSestavaPolId = akceKalkulaceVazbaSestavaPolId;
    }

    public int getAkceKalkulaceVazbaSestavaId() {
        return akceKalkulaceVazbaSestavaId;
    }

    public void setAkceKalkulaceVazbaSestavaId(int akceKalkulaceVazbaSestavaId) {
        this.akceKalkulaceVazbaSestavaId = akceKalkulaceVazbaSestavaId;
    }

    public int getAkceKalkulaceVazbaSestavaPolId() {
        return akceKalkulaceVazbaSestavaPolId;
    }

    public void setAkceKalkulaceVazbaSestavaPolId(int akceKalkulaceVazbaSestavaPolId) {
        this.akceKalkulaceVazbaSestavaPolId = akceKalkulaceVazbaSestavaPolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceKalkulaceVazbaSestavaId;
        hash += (int) akceKalkulaceVazbaSestavaPolId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulaceVazbaSestavaPK)) {
            return false;
        }
        AkceKalkulaceVazbaSestavaPK other = (AkceKalkulaceVazbaSestavaPK) object;
        if (this.akceKalkulaceVazbaSestavaId != other.akceKalkulaceVazbaSestavaId) {
            return false;
        }
        if (this.akceKalkulaceVazbaSestavaPolId != other.akceKalkulaceVazbaSestavaPolId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulaceVazbaSestavaPK[ akceKalkulaceVazbaSestavaId=" + akceKalkulaceVazbaSestavaId + ", akceKalkulaceVazbaSestavaPolId=" + akceKalkulaceVazbaSestavaPolId + " ]";
    }
    
}
