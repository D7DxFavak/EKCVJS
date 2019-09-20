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
@Table(name = "stavy_druhy_vztahy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StavyDruhyVztahy.findAll", query = "SELECT s FROM StavyDruhyVztahy s"),
    @NamedQuery(name = "StavyDruhyVztahy.findByStavPrihlId", query = "SELECT s FROM StavyDruhyVztahy s WHERE s.stavyDruhyVztahyPK.stavPrihlId = :stavPrihlId"),
    @NamedQuery(name = "StavyDruhyVztahy.findByPovolujeDruhprihlId", query = "SELECT s FROM StavyDruhyVztahy s WHERE s.stavyDruhyVztahyPK.povolujeDruhprihlId = :povolujeDruhprihlId"),
    @NamedQuery(name = "StavyDruhyVztahy.findByJeDefault", query = "SELECT s FROM StavyDruhyVztahy s WHERE s.jeDefault = :jeDefault"),
    @NamedQuery(name = "StavyDruhyVztahy.findByPoznamky", query = "SELECT s FROM StavyDruhyVztahy s WHERE s.poznamky = :poznamky")})
public class StavyDruhyVztahy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavyDruhyVztahyPK stavyDruhyVztahyPK;
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
    @JoinColumn(name = "povoluje_druhprihl_id", referencedColumnName = "druh_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyPrihlasek druhyPrihlasek;

    public StavyDruhyVztahy() {
    }

    public StavyDruhyVztahy(StavyDruhyVztahyPK stavyDruhyVztahyPK) {
        this.stavyDruhyVztahyPK = stavyDruhyVztahyPK;
    }

    public StavyDruhyVztahy(StavyDruhyVztahyPK stavyDruhyVztahyPK, boolean jeDefault) {
        this.stavyDruhyVztahyPK = stavyDruhyVztahyPK;
        this.jeDefault = jeDefault;
    }

    public StavyDruhyVztahy(int stavPrihlId, int povolujeDruhprihlId) {
        this.stavyDruhyVztahyPK = new StavyDruhyVztahyPK(stavPrihlId, povolujeDruhprihlId);
    }

    public StavyDruhyVztahyPK getStavyDruhyVztahyPK() {
        return stavyDruhyVztahyPK;
    }

    public void setStavyDruhyVztahyPK(StavyDruhyVztahyPK stavyDruhyVztahyPK) {
        this.stavyDruhyVztahyPK = stavyDruhyVztahyPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavyDruhyVztahyPK != null ? stavyDruhyVztahyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavyDruhyVztahy)) {
            return false;
        }
        StavyDruhyVztahy other = (StavyDruhyVztahy) object;
        if ((this.stavyDruhyVztahyPK == null && other.stavyDruhyVztahyPK != null) || (this.stavyDruhyVztahyPK != null && !this.stavyDruhyVztahyPK.equals(other.stavyDruhyVztahyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StavyDruhyVztahy[ stavyDruhyVztahyPK=" + stavyDruhyVztahyPK + " ]";
    }
    
}
