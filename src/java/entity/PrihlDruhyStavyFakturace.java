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
@Table(name = "prihl_druhy_stavy_fakturace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlDruhyStavyFakturace.findAll", query = "SELECT p FROM PrihlDruhyStavyFakturace p"),
    @NamedQuery(name = "PrihlDruhyStavyFakturace.findByPrihlDruhyStavyFakturaceDruhFaktury", query = "SELECT p FROM PrihlDruhyStavyFakturace p WHERE p.prihlDruhyStavyFakturacePK.prihlDruhyStavyFakturaceDruhFaktury = :prihlDruhyStavyFakturaceDruhFaktury"),
    @NamedQuery(name = "PrihlDruhyStavyFakturace.findByPrihlDruhyStavyFakturaceDruhPrihlasky", query = "SELECT p FROM PrihlDruhyStavyFakturace p WHERE p.prihlDruhyStavyFakturacePK.prihlDruhyStavyFakturaceDruhPrihlasky = :prihlDruhyStavyFakturaceDruhPrihlasky"),
    @NamedQuery(name = "PrihlDruhyStavyFakturace.findByPrihlDruhyStavyFakturaceStavPrihlasky", query = "SELECT p FROM PrihlDruhyStavyFakturace p WHERE p.prihlDruhyStavyFakturacePK.prihlDruhyStavyFakturaceStavPrihlasky = :prihlDruhyStavyFakturaceStavPrihlasky"),
    @NamedQuery(name = "PrihlDruhyStavyFakturace.findByPoznamky", query = "SELECT p FROM PrihlDruhyStavyFakturace p WHERE p.poznamky = :poznamky")})
public class PrihlDruhyStavyFakturace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrihlDruhyStavyFakturacePK prihlDruhyStavyFakturacePK;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "prihl_druhy_stavy_fakturace_stav_prihlasky", referencedColumnName = "stav_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StavyPrihlasek stavyPrihlasek;
    @JoinColumn(name = "prihl_druhy_stavy_fakturace_druh_prihlasky", referencedColumnName = "druh_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyPrihlasek druhyPrihlasek;
    @JoinColumn(name = "prihl_druhy_stavy_fakturace_druh_faktury", referencedColumnName = "druh_faktury_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyFaktur druhyFaktur;

    public PrihlDruhyStavyFakturace() {
    }

    public PrihlDruhyStavyFakturace(PrihlDruhyStavyFakturacePK prihlDruhyStavyFakturacePK) {
        this.prihlDruhyStavyFakturacePK = prihlDruhyStavyFakturacePK;
    }

    public PrihlDruhyStavyFakturace(int prihlDruhyStavyFakturaceDruhFaktury, int prihlDruhyStavyFakturaceDruhPrihlasky, int prihlDruhyStavyFakturaceStavPrihlasky) {
        this.prihlDruhyStavyFakturacePK = new PrihlDruhyStavyFakturacePK(prihlDruhyStavyFakturaceDruhFaktury, prihlDruhyStavyFakturaceDruhPrihlasky, prihlDruhyStavyFakturaceStavPrihlasky);
    }

    public PrihlDruhyStavyFakturacePK getPrihlDruhyStavyFakturacePK() {
        return prihlDruhyStavyFakturacePK;
    }

    public void setPrihlDruhyStavyFakturacePK(PrihlDruhyStavyFakturacePK prihlDruhyStavyFakturacePK) {
        this.prihlDruhyStavyFakturacePK = prihlDruhyStavyFakturacePK;
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
        hash += (prihlDruhyStavyFakturacePK != null ? prihlDruhyStavyFakturacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlDruhyStavyFakturace)) {
            return false;
        }
        PrihlDruhyStavyFakturace other = (PrihlDruhyStavyFakturace) object;
        if ((this.prihlDruhyStavyFakturacePK == null && other.prihlDruhyStavyFakturacePK != null) || (this.prihlDruhyStavyFakturacePK != null && !this.prihlDruhyStavyFakturacePK.equals(other.prihlDruhyStavyFakturacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlDruhyStavyFakturace[ prihlDruhyStavyFakturacePK=" + prihlDruhyStavyFakturacePK + " ]";
    }
    
}
