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
public class NabidkyOsobyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "osoba")
    private int osoba;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_nabidky")
    private int formaNabidky;

    public NabidkyOsobyPK() {
    }

    public NabidkyOsobyPK(int osoba, int formaNabidky) {
        this.osoba = osoba;
        this.formaNabidky = formaNabidky;
    }

    public int getOsoba() {
        return osoba;
    }

    public void setOsoba(int osoba) {
        this.osoba = osoba;
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
        hash += (int) osoba;
        hash += (int) formaNabidky;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NabidkyOsobyPK)) {
            return false;
        }
        NabidkyOsobyPK other = (NabidkyOsobyPK) object;
        if (this.osoba != other.osoba) {
            return false;
        }
        if (this.formaNabidky != other.formaNabidky) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NabidkyOsobyPK[ osoba=" + osoba + ", formaNabidky=" + formaNabidky + " ]";
    }
    
}
