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
public class AkcePrihlStavyVztahyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "stav_akce_id")
    private int stavAkceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "povoluje_stavprihl")
    private int povolujeStavprihl;

    public AkcePrihlStavyVztahyPK() {
    }

    public AkcePrihlStavyVztahyPK(int stavAkceId, int povolujeStavprihl) {
        this.stavAkceId = stavAkceId;
        this.povolujeStavprihl = povolujeStavprihl;
    }

    public int getStavAkceId() {
        return stavAkceId;
    }

    public void setStavAkceId(int stavAkceId) {
        this.stavAkceId = stavAkceId;
    }

    public int getPovolujeStavprihl() {
        return povolujeStavprihl;
    }

    public void setPovolujeStavprihl(int povolujeStavprihl) {
        this.povolujeStavprihl = povolujeStavprihl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) stavAkceId;
        hash += (int) povolujeStavprihl;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkcePrihlStavyVztahyPK)) {
            return false;
        }
        AkcePrihlStavyVztahyPK other = (AkcePrihlStavyVztahyPK) object;
        if (this.stavAkceId != other.stavAkceId) {
            return false;
        }
        if (this.povolujeStavprihl != other.povolujeStavprihl) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkcePrihlStavyVztahyPK[ stavAkceId=" + stavAkceId + ", povolujeStavprihl=" + povolujeStavprihl + " ]";
    }
    
}
