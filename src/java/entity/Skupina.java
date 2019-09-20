/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "skupina", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skupina.findAll", query = "SELECT s FROM Skupina s"),
    @NamedQuery(name = "Skupina.findBySkupinaNazev", query = "SELECT s FROM Skupina s WHERE s.skupinaPK.skupinaNazev = :skupinaNazev"),
    @NamedQuery(name = "Skupina.findByUzivateleJmeno", query = "SELECT s FROM Skupina s WHERE s.skupinaPK.uzivateleJmeno = :uzivateleJmeno")})
public class Skupina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SkupinaPK skupinaPK;
    @JoinColumn(name = "uzivatele_jmeno", referencedColumnName = "uzivatele_jmeno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Uzivatele uzivatele;

    public Skupina() {
    }

    public Skupina(SkupinaPK skupinaPK) {
        this.skupinaPK = skupinaPK;
    }

    public Skupina(String skupinaNazev, String uzivateleJmeno) {
        this.skupinaPK = new SkupinaPK(skupinaNazev, uzivateleJmeno);
    }

    public SkupinaPK getSkupinaPK() {
        return skupinaPK;
    }

    public void setSkupinaPK(SkupinaPK skupinaPK) {
        this.skupinaPK = skupinaPK;
    }

    public Uzivatele getUzivatele() {
        return uzivatele;
    }

    public void setUzivatele(Uzivatele uzivatele) {
        this.uzivatele = uzivatele;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skupinaPK != null ? skupinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skupina)) {
            return false;
        }
        Skupina other = (Skupina) object;
        if ((this.skupinaPK == null && other.skupinaPK != null) || (this.skupinaPK != null && !this.skupinaPK.equals(other.skupinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Skupina[ skupinaPK=" + skupinaPK + " ]";
    }
    
}
