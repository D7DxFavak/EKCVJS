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
@Table(name = "akce_prihl_stavy_vztahy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkcePrihlStavyVztahy.findAll", query = "SELECT a FROM AkcePrihlStavyVztahy a"),
    @NamedQuery(name = "AkcePrihlStavyVztahy.findByStavAkceId", query = "SELECT a FROM AkcePrihlStavyVztahy a WHERE a.akcePrihlStavyVztahyPK.stavAkceId = :stavAkceId"),
    @NamedQuery(name = "AkcePrihlStavyVztahy.findByPovolujeStavprihl", query = "SELECT a FROM AkcePrihlStavyVztahy a WHERE a.akcePrihlStavyVztahyPK.povolujeStavprihl = :povolujeStavprihl"),
    @NamedQuery(name = "AkcePrihlStavyVztahy.findByPoznamky", query = "SELECT a FROM AkcePrihlStavyVztahy a WHERE a.poznamky = :poznamky")})
public class AkcePrihlStavyVztahy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkcePrihlStavyVztahyPK akcePrihlStavyVztahyPK;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "povoluje_stavprihl", referencedColumnName = "stav_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StavyPrihlasek stavyPrihlasek;
    @JoinColumn(name = "stav_akce_id", referencedColumnName = "stav_akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceStavy akceStavy;

    public AkcePrihlStavyVztahy() {
    }

    public AkcePrihlStavyVztahy(AkcePrihlStavyVztahyPK akcePrihlStavyVztahyPK) {
        this.akcePrihlStavyVztahyPK = akcePrihlStavyVztahyPK;
    }

    public AkcePrihlStavyVztahy(int stavAkceId, int povolujeStavprihl) {
        this.akcePrihlStavyVztahyPK = new AkcePrihlStavyVztahyPK(stavAkceId, povolujeStavprihl);
    }

    public AkcePrihlStavyVztahyPK getAkcePrihlStavyVztahyPK() {
        return akcePrihlStavyVztahyPK;
    }

    public void setAkcePrihlStavyVztahyPK(AkcePrihlStavyVztahyPK akcePrihlStavyVztahyPK) {
        this.akcePrihlStavyVztahyPK = akcePrihlStavyVztahyPK;
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

    public AkceStavy getAkceStavy() {
        return akceStavy;
    }

    public void setAkceStavy(AkceStavy akceStavy) {
        this.akceStavy = akceStavy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akcePrihlStavyVztahyPK != null ? akcePrihlStavyVztahyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkcePrihlStavyVztahy)) {
            return false;
        }
        AkcePrihlStavyVztahy other = (AkcePrihlStavyVztahy) object;
        if ((this.akcePrihlStavyVztahyPK == null && other.akcePrihlStavyVztahyPK != null) || (this.akcePrihlStavyVztahyPK != null && !this.akcePrihlStavyVztahyPK.equals(other.akcePrihlStavyVztahyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkcePrihlStavyVztahy[ akcePrihlStavyVztahyPK=" + akcePrihlStavyVztahyPK + " ]";
    }
    
}
