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
public class VyberAkceFakturacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce")
    private int akce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "druhprihl")
    private int druhprihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fakt_druh")
    private int faktDruh;

    public VyberAkceFakturacePK() {
    }

    public VyberAkceFakturacePK(int akce, int druhprihl, int faktDruh) {
        this.akce = akce;
        this.druhprihl = druhprihl;
        this.faktDruh = faktDruh;
    }

    public int getAkce() {
        return akce;
    }

    public void setAkce(int akce) {
        this.akce = akce;
    }

    public int getDruhprihl() {
        return druhprihl;
    }

    public void setDruhprihl(int druhprihl) {
        this.druhprihl = druhprihl;
    }

    public int getFaktDruh() {
        return faktDruh;
    }

    public void setFaktDruh(int faktDruh) {
        this.faktDruh = faktDruh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) akce;
        hash += (int) druhprihl;
        hash += (int) faktDruh;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VyberAkceFakturacePK)) {
            return false;
        }
        VyberAkceFakturacePK other = (VyberAkceFakturacePK) object;
        if (this.akce != other.akce) {
            return false;
        }
        if (this.druhprihl != other.druhprihl) {
            return false;
        }
        if (this.faktDruh != other.faktDruh) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VyberAkceFakturacePK[ akce=" + akce + ", druhprihl=" + druhprihl + ", faktDruh=" + faktDruh + " ]";
    }
    
}
