/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "vazba_osoby_login", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaOsobyLogin.findAll", query = "SELECT v FROM VazbaOsobyLogin v"),
    @NamedQuery(name = "VazbaOsobyLogin.findByVazbaLogin", query = "SELECT v FROM VazbaOsobyLogin v WHERE v.vazbaLogin = :vazbaLogin"),
    @NamedQuery(name = "VazbaOsobyLogin.findByVazbaOsobaId", query = "SELECT v FROM VazbaOsobyLogin v WHERE v.vazbaOsobaId = :vazbaOsobaId"),
    @NamedQuery(name = "VazbaOsobyLogin.findByPoznamky", query = "SELECT v FROM VazbaOsobyLogin v WHERE v.poznamky = :poznamky")})
public class VazbaOsobyLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "vazba_login")
    private String vazbaLogin;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_osoba_id", referencedColumnName = "osoba_id")
    @ManyToOne(optional = false)
    private Osoby vazbaOsobaId;

    public VazbaOsobyLogin() {
    }

    public VazbaOsobyLogin(String vazbaLogin) {
        this.vazbaLogin = vazbaLogin;
    }

    public String getVazbaLogin() {
        return vazbaLogin;
    }

    public void setVazbaLogin(String vazbaLogin) {
        this.vazbaLogin = vazbaLogin;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public Osoby getVazbaOsobaId() {
        return vazbaOsobaId;
    }

    public void setVazbaOsobaId(Osoby vazbaOsobaId) {
        this.vazbaOsobaId = vazbaOsobaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaLogin != null ? vazbaLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaOsobyLogin)) {
            return false;
        }
        VazbaOsobyLogin other = (VazbaOsobyLogin) object;
        if ((this.vazbaLogin == null && other.vazbaLogin != null) || (this.vazbaLogin != null && !this.vazbaLogin.equals(other.vazbaLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaOsobyLogin[ vazbaLogin=" + vazbaLogin + " ]";
    }
    
}
