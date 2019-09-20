/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "klavesove_zkratky_stavprihl", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KlavesoveZkratkyStavprihl.findAll", query = "SELECT k FROM KlavesoveZkratkyStavprihl k"),
    @NamedQuery(name = "KlavesoveZkratkyStavprihl.findByUzivatelNazev", query = "SELECT k FROM KlavesoveZkratkyStavprihl k WHERE k.klavesoveZkratkyStavprihlPK.uzivatelNazev = :uzivatelNazev"),
    @NamedQuery(name = "KlavesoveZkratkyStavprihl.findByStavPrihlId", query = "SELECT k FROM KlavesoveZkratkyStavprihl k WHERE k.klavesoveZkratkyStavprihlPK.stavPrihlId = :stavPrihlId"),
    @NamedQuery(name = "KlavesoveZkratkyStavprihl.findByZkratka", query = "SELECT k FROM KlavesoveZkratkyStavprihl k WHERE k.zkratka = :zkratka"),
    @NamedQuery(name = "KlavesoveZkratkyStavprihl.findByPoznamky", query = "SELECT k FROM KlavesoveZkratkyStavprihl k WHERE k.poznamky = :poznamky")})
public class KlavesoveZkratkyStavprihl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KlavesoveZkratkyStavprihlPK klavesoveZkratkyStavprihlPK;
    @Column(name = "zkratka")
    private Character zkratka;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "stav_prihl_id", referencedColumnName = "stav_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StavyPrihlasek stavyPrihlasek;

    public KlavesoveZkratkyStavprihl() {
    }

    public KlavesoveZkratkyStavprihl(KlavesoveZkratkyStavprihlPK klavesoveZkratkyStavprihlPK) {
        this.klavesoveZkratkyStavprihlPK = klavesoveZkratkyStavprihlPK;
    }

    public KlavesoveZkratkyStavprihl(String uzivatelNazev, int stavPrihlId) {
        this.klavesoveZkratkyStavprihlPK = new KlavesoveZkratkyStavprihlPK(uzivatelNazev, stavPrihlId);
    }

    public KlavesoveZkratkyStavprihlPK getKlavesoveZkratkyStavprihlPK() {
        return klavesoveZkratkyStavprihlPK;
    }

    public void setKlavesoveZkratkyStavprihlPK(KlavesoveZkratkyStavprihlPK klavesoveZkratkyStavprihlPK) {
        this.klavesoveZkratkyStavprihlPK = klavesoveZkratkyStavprihlPK;
    }

    public Character getZkratka() {
        return zkratka;
    }

    public void setZkratka(Character zkratka) {
        this.zkratka = zkratka;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public StavyPrihlasek getStavyPrihlasek() {
        return stavyPrihlasek;
    }

    public void setStavyPrihlasek(StavyPrihlasek stavyPrihlasek) {
        this.stavyPrihlasek = stavyPrihlasek;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klavesoveZkratkyStavprihlPK != null ? klavesoveZkratkyStavprihlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlavesoveZkratkyStavprihl)) {
            return false;
        }
        KlavesoveZkratkyStavprihl other = (KlavesoveZkratkyStavprihl) object;
        if ((this.klavesoveZkratkyStavprihlPK == null && other.klavesoveZkratkyStavprihlPK != null) || (this.klavesoveZkratkyStavprihlPK != null && !this.klavesoveZkratkyStavprihlPK.equals(other.klavesoveZkratkyStavprihlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KlavesoveZkratkyStavprihl[ klavesoveZkratkyStavprihlPK=" + klavesoveZkratkyStavprihlPK + " ]";
    }
    
}
