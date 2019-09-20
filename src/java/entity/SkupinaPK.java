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
public class SkupinaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "skupina_nazev")
    private String skupinaNazev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "uzivatele_jmeno")
    private String uzivateleJmeno;

    public SkupinaPK() {
    }

    public SkupinaPK(String skupinaNazev, String uzivateleJmeno) {
        this.skupinaNazev = skupinaNazev;
        this.uzivateleJmeno = uzivateleJmeno;
    }

    public String getSkupinaNazev() {
        return skupinaNazev;
    }

    public void setSkupinaNazev(String skupinaNazev) {
        this.skupinaNazev = skupinaNazev;
    }

    public String getUzivateleJmeno() {
        return uzivateleJmeno;
    }

    public void setUzivateleJmeno(String uzivateleJmeno) {
        this.uzivateleJmeno = uzivateleJmeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skupinaNazev != null ? skupinaNazev.hashCode() : 0);
        hash += (uzivateleJmeno != null ? uzivateleJmeno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkupinaPK)) {
            return false;
        }
        SkupinaPK other = (SkupinaPK) object;
        if ((this.skupinaNazev == null && other.skupinaNazev != null) || (this.skupinaNazev != null && !this.skupinaNazev.equals(other.skupinaNazev))) {
            return false;
        }
        if ((this.uzivateleJmeno == null && other.uzivateleJmeno != null) || (this.uzivateleJmeno != null && !this.uzivateleJmeno.equals(other.uzivateleJmeno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SkupinaPK[ skupinaNazev=" + skupinaNazev + ", uzivateleJmeno=" + uzivateleJmeno + " ]";
    }
    
}
