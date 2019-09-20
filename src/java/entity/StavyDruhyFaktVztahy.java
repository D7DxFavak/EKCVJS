/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "stavy_druhy_fakt_vztahy", catalog = "kopernik1s", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StavyDruhyFaktVztahy.findAll", query = "SELECT s FROM StavyDruhyFaktVztahy s"),
    @NamedQuery(name = "StavyDruhyFaktVztahy.findByStavPrihlId", query = "SELECT s FROM StavyDruhyFaktVztahy s WHERE s.stavyDruhyFaktVztahyPK.stavPrihlId = :stavPrihlId"),
    @NamedQuery(name = "StavyDruhyFaktVztahy.findByDruhprihlId", query = "SELECT s FROM StavyDruhyFaktVztahy s WHERE s.stavyDruhyFaktVztahyPK.druhprihlId = :druhprihlId"),
    @NamedQuery(name = "StavyDruhyFaktVztahy.findByPovolujeDruhfaktId", query = "SELECT s FROM StavyDruhyFaktVztahy s WHERE s.stavyDruhyFaktVztahyPK.povolujeDruhfaktId = :povolujeDruhfaktId"),
    @NamedQuery(name = "StavyDruhyFaktVztahy.findByJeDefault", query = "SELECT s FROM StavyDruhyFaktVztahy s WHERE s.jeDefault = :jeDefault"),
    @NamedQuery(name = "StavyDruhyFaktVztahy.findByPoznamky", query = "SELECT s FROM StavyDruhyFaktVztahy s WHERE s.poznamky = :poznamky")})
public class StavyDruhyFaktVztahy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavyDruhyFaktVztahyPK stavyDruhyFaktVztahyPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "je_default")
    private boolean jeDefault;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "stav_prihl_id", referencedColumnName = "stav_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StavyPrihlasek stavyPrihlasek;
    @JoinColumn(name = "druhprihl_id", referencedColumnName = "druh_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyPrihlasek druhyPrihlasek;
    @JoinColumn(name = "povoluje_druhfakt_id", referencedColumnName = "druh_faktury_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyFaktur druhyFaktur;

    public StavyDruhyFaktVztahy() {
    }

    public StavyDruhyFaktVztahy(StavyDruhyFaktVztahyPK stavyDruhyFaktVztahyPK) {
        this.stavyDruhyFaktVztahyPK = stavyDruhyFaktVztahyPK;
    }

    public StavyDruhyFaktVztahy(StavyDruhyFaktVztahyPK stavyDruhyFaktVztahyPK, boolean jeDefault) {
        this.stavyDruhyFaktVztahyPK = stavyDruhyFaktVztahyPK;
        this.jeDefault = jeDefault;
    }

    public StavyDruhyFaktVztahy(int stavPrihlId, int druhprihlId, int povolujeDruhfaktId) {
        this.stavyDruhyFaktVztahyPK = new StavyDruhyFaktVztahyPK(stavPrihlId, druhprihlId, povolujeDruhfaktId);
    }

    public StavyDruhyFaktVztahyPK getStavyDruhyFaktVztahyPK() {
        return stavyDruhyFaktVztahyPK;
    }

    public void setStavyDruhyFaktVztahyPK(StavyDruhyFaktVztahyPK stavyDruhyFaktVztahyPK) {
        this.stavyDruhyFaktVztahyPK = stavyDruhyFaktVztahyPK;
    }

    public boolean getJeDefault() {
        return jeDefault;
    }

    public void setJeDefault(boolean jeDefault) {
        this.jeDefault = jeDefault;
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

    public DruhyPrihlasek getDruhyPrihlasek() {
        return druhyPrihlasek;
    }

    public void setDruhyPrihlasek(DruhyPrihlasek druhyPrihlasek) {
        this.druhyPrihlasek = druhyPrihlasek;
    }

    public DruhyFaktur getDruhyFaktur() {
        return druhyFaktur;
    }

    public void setDruhyFaktur(DruhyFaktur druhyFaktur) {
        this.druhyFaktur = druhyFaktur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavyDruhyFaktVztahyPK != null ? stavyDruhyFaktVztahyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavyDruhyFaktVztahy)) {
            return false;
        }
        StavyDruhyFaktVztahy other = (StavyDruhyFaktVztahy) object;
        if ((this.stavyDruhyFaktVztahyPK == null && other.stavyDruhyFaktVztahyPK != null) || (this.stavyDruhyFaktVztahyPK != null && !this.stavyDruhyFaktVztahyPK.equals(other.stavyDruhyFaktVztahyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StavyDruhyFaktVztahy[ stavyDruhyFaktVztahyPK=" + stavyDruhyFaktVztahyPK + " ]";
    }
    
}
