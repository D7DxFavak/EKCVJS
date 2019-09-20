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
@Table(name = "uzivatele_special_autorizace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UzivateleSpecialAutorizace.findAll", query = "SELECT u FROM UzivateleSpecialAutorizace u"),
    @NamedQuery(name = "UzivateleSpecialAutorizace.findByUzivatelNazev", query = "SELECT u FROM UzivateleSpecialAutorizace u WHERE u.uzivatelNazev = :uzivatelNazev"),
    @NamedQuery(name = "UzivateleSpecialAutorizace.findBySpravceOboru", query = "SELECT u FROM UzivateleSpecialAutorizace u WHERE u.spravceOboru = :spravceOboru"),
    @NamedQuery(name = "UzivateleSpecialAutorizace.findByPoznamky", query = "SELECT u FROM UzivateleSpecialAutorizace u WHERE u.poznamky = :poznamky")})
public class UzivateleSpecialAutorizace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "uzivatel_nazev")
    private String uzivatelNazev;
    @Column(name = "spravce_oboru")
    private Boolean spravceOboru;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;

    public UzivateleSpecialAutorizace() {
    }

    public UzivateleSpecialAutorizace(String uzivatelNazev) {
        this.uzivatelNazev = uzivatelNazev;
    }

    public String getUzivatelNazev() {
        return uzivatelNazev;
    }

    public void setUzivatelNazev(String uzivatelNazev) {
        this.uzivatelNazev = uzivatelNazev;
    }

    public Boolean getSpravceOboru() {
        return spravceOboru;
    }

    public void setSpravceOboru(Boolean spravceOboru) {
        this.spravceOboru = spravceOboru;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uzivatelNazev != null ? uzivatelNazev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UzivateleSpecialAutorizace)) {
            return false;
        }
        UzivateleSpecialAutorizace other = (UzivateleSpecialAutorizace) object;
        if ((this.uzivatelNazev == null && other.uzivatelNazev != null) || (this.uzivatelNazev != null && !this.uzivatelNazev.equals(other.uzivatelNazev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UzivateleSpecialAutorizace[ uzivatelNazev=" + uzivatelNazev + " ]";
    }
    
}
