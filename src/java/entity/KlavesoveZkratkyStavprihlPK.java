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
import javax.validation.constraints.Size;

/**
 *
 * @author 7Data Gotzy
 */
@Embeddable
public class KlavesoveZkratkyStavprihlPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "uzivatel_nazev")
    private String uzivatelNazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stav_prihl_id")
    private int stavPrihlId;

    public KlavesoveZkratkyStavprihlPK() {
    }

    public KlavesoveZkratkyStavprihlPK(String uzivatelNazev, int stavPrihlId) {
        this.uzivatelNazev = uzivatelNazev;
        this.stavPrihlId = stavPrihlId;
    }

    public String getUzivatelNazev() {
        return uzivatelNazev;
    }

    public void setUzivatelNazev(String uzivatelNazev) {
        this.uzivatelNazev = uzivatelNazev;
    }

    public int getStavPrihlId() {
        return stavPrihlId;
    }

    public void setStavPrihlId(int stavPrihlId) {
        this.stavPrihlId = stavPrihlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uzivatelNazev != null ? uzivatelNazev.hashCode() : 0);
        hash += (int) stavPrihlId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlavesoveZkratkyStavprihlPK)) {
            return false;
        }
        KlavesoveZkratkyStavprihlPK other = (KlavesoveZkratkyStavprihlPK) object;
        if ((this.uzivatelNazev == null && other.uzivatelNazev != null) || (this.uzivatelNazev != null && !this.uzivatelNazev.equals(other.uzivatelNazev))) {
            return false;
        }
        if (this.stavPrihlId != other.stavPrihlId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KlavesoveZkratkyStavprihlPK[ uzivatelNazev=" + uzivatelNazev + ", stavPrihlId=" + stavPrihlId + " ]";
    }
    
}
