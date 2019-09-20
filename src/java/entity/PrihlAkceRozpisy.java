/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "prihl_akce_rozpisy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlAkceRozpisy.findAll", query = "SELECT p FROM PrihlAkceRozpisy p"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByPolozkaPrihl", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.prihlAkceRozpisyPK.polozkaPrihl = :polozkaPrihl"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByPolozkaAt", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.prihlAkceRozpisyPK.polozkaAt = :polozkaAt"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByKdyVlozeno", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByKdyZmeneno", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByKdoVlozil", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByKdoZmenil", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "PrihlAkceRozpisy.findByPoznamky", query = "SELECT p FROM PrihlAkceRozpisy p WHERE p.poznamky = :poznamky")})
public class PrihlAkceRozpisy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrihlAkceRozpisyPK prihlAkceRozpisyPK;
    @Column(name = "kdy_vlozeno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyVlozeno;
    @Column(name = "kdy_zmeneno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyZmeneno;
    @Size(max = 100)
    @Column(name = "kdo_vlozil")
    private String kdoVlozil;
    @Size(max = 100)
    @Column(name = "kdo_zmenil")
    private String kdoZmenil;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "polozka_prihl", referencedColumnName = "polozka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrihlaskyRozpisy prihlaskyRozpisy;
    @JoinColumn(name = "polozka_at", referencedColumnName = "polozka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceRozpisy akceRozpisy;

    public PrihlAkceRozpisy() {
    }

    public PrihlAkceRozpisy(PrihlAkceRozpisyPK prihlAkceRozpisyPK) {
        this.prihlAkceRozpisyPK = prihlAkceRozpisyPK;
    }

    public PrihlAkceRozpisy(int polozkaPrihl, int polozkaAt) {
        this.prihlAkceRozpisyPK = new PrihlAkceRozpisyPK(polozkaPrihl, polozkaAt);
    }

    public PrihlAkceRozpisyPK getPrihlAkceRozpisyPK() {
        return prihlAkceRozpisyPK;
    }

    public void setPrihlAkceRozpisyPK(PrihlAkceRozpisyPK prihlAkceRozpisyPK) {
        this.prihlAkceRozpisyPK = prihlAkceRozpisyPK;
    }

    public Date getKdyVlozeno() {
        return kdyVlozeno;
    }

    public void setKdyVlozeno(Date kdyVlozeno) {
        this.kdyVlozeno = kdyVlozeno;
    }

    public Date getKdyZmeneno() {
        return kdyZmeneno;
    }

    public void setKdyZmeneno(Date kdyZmeneno) {
        this.kdyZmeneno = kdyZmeneno;
    }

    public String getKdoVlozil() {
        return kdoVlozil;
    }

    public void setKdoVlozil(String kdoVlozil) {
        this.kdoVlozil = kdoVlozil;
    }

    public String getKdoZmenil() {
        return kdoZmenil;
    }

    public void setKdoZmenil(String kdoZmenil) {
        this.kdoZmenil = kdoZmenil;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public PrihlaskyRozpisy getPrihlaskyRozpisy() {
        return prihlaskyRozpisy;
    }

    public void setPrihlaskyRozpisy(PrihlaskyRozpisy prihlaskyRozpisy) {
        this.prihlaskyRozpisy = prihlaskyRozpisy;
    }

    public AkceRozpisy getAkceRozpisy() {
        return akceRozpisy;
    }

    public void setAkceRozpisy(AkceRozpisy akceRozpisy) {
        this.akceRozpisy = akceRozpisy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prihlAkceRozpisyPK != null ? prihlAkceRozpisyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlAkceRozpisy)) {
            return false;
        }
        PrihlAkceRozpisy other = (PrihlAkceRozpisy) object;
        if ((this.prihlAkceRozpisyPK == null && other.prihlAkceRozpisyPK != null) || (this.prihlAkceRozpisyPK != null && !this.prihlAkceRozpisyPK.equals(other.prihlAkceRozpisyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlAkceRozpisy[ prihlAkceRozpisyPK=" + prihlAkceRozpisyPK + " ]";
    }
    
}
