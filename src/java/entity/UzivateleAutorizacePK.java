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
public class UzivateleAutorizacePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "obor_id")
    private int oborId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "uzivatel_nazev")
    private String uzivatelNazev;

    public UzivateleAutorizacePK() {
    }

    public UzivateleAutorizacePK(int oborId, String uzivatelNazev) {
        this.oborId = oborId;
        this.uzivatelNazev = uzivatelNazev;
    }

    public int getOborId() {
        return oborId;
    }

    public void setOborId(int oborId) {
        this.oborId = oborId;
    }

    public String getUzivatelNazev() {
        return uzivatelNazev;
    }

    public void setUzivatelNazev(String uzivatelNazev) {
        this.uzivatelNazev = uzivatelNazev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) oborId;
        hash += (uzivatelNazev != null ? uzivatelNazev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UzivateleAutorizacePK)) {
            return false;
        }
        UzivateleAutorizacePK other = (UzivateleAutorizacePK) object;
        if (this.oborId != other.oborId) {
            return false;
        }
        if ((this.uzivatelNazev == null && other.uzivatelNazev != null) || (this.uzivatelNazev != null && !this.uzivatelNazev.equals(other.uzivatelNazev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UzivateleAutorizacePK[ oborId=" + oborId + ", uzivatelNazev=" + uzivatelNazev + " ]";
    }
    
}
