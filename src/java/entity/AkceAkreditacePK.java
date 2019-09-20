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
public class AkceAkreditacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_id")
    private int akceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akreditace_id")
    private int akreditaceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akreditace_poradi")
    private int akreditacePoradi;

    public AkceAkreditacePK() {
    }

    public AkceAkreditacePK(int akceId, int akreditaceId, int akreditacePoradi) {
        this.akceId = akceId;
        this.akreditaceId = akreditaceId;
        this.akreditacePoradi = akreditacePoradi;
    }

    public int getAkceId() {
        return akceId;
    }

    public void setAkceId(int akceId) {
        this.akceId = akceId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akceId;
        hash += (int) akreditaceId;
        hash += (int) akreditacePoradi;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceAkreditacePK)) {
            return false;
        }
        AkceAkreditacePK other = (AkceAkreditacePK) object;
        if (this.akceId != other.akceId) {
            return false;
        }
        if (this.akreditaceId != other.akreditaceId) {
            return false;
        }
        if (this.akreditacePoradi != other.akreditacePoradi) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceAkreditacePK[ akceId=" + akceId + ", akreditaceId=" + akreditaceId + ", akreditacePoradi=" + akreditacePoradi + " ]";
    }
    
}
