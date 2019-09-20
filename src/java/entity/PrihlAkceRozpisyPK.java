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
public class PrihlAkceRozpisyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "polozka_prihl")
    private int polozkaPrihl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "polozka_at")
    private int polozkaAt;

    public PrihlAkceRozpisyPK() {
    }

    public PrihlAkceRozpisyPK(int polozkaPrihl, int polozkaAt) {
        this.polozkaPrihl = polozkaPrihl;
        this.polozkaAt = polozkaAt;
    }

    public int getPolozkaPrihl() {
        return polozkaPrihl;
    }

    public void setPolozkaPrihl(int polozkaPrihl) {
        this.polozkaPrihl = polozkaPrihl;
    }

    public int getPolozkaAt() {
        return polozkaAt;
    }

    public void setPolozkaAt(int polozkaAt) {
        this.polozkaAt = polozkaAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) polozkaPrihl;
        hash += (int) polozkaAt;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlAkceRozpisyPK)) {
            return false;
        }
        PrihlAkceRozpisyPK other = (PrihlAkceRozpisyPK) object;
        if (this.polozkaPrihl != other.polozkaPrihl) {
            return false;
        }
        if (this.polozkaAt != other.polozkaAt) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlAkceRozpisyPK[ polozkaPrihl=" + polozkaPrihl + ", polozkaAt=" + polozkaAt + " ]";
    }
    
}
