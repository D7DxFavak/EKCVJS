/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "vyber_prihlasky_fakturace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VyberPrihlaskyFakturace.findAll", query = "SELECT v FROM VyberPrihlaskyFakturace v"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByPrihlPolozka", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.vyberPrihlaskyFakturacePK.prihlPolozka = :prihlPolozka"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByDruhprihl", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.vyberPrihlaskyFakturacePK.druhprihl = :druhprihl"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByFaktDruh", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.vyberPrihlaskyFakturacePK.faktDruh = :faktDruh"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByFakturovat", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.fakturovat = :fakturovat"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByKdyVlozeno", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByKdyZmeneno", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByKdoVlozil", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByKdoZmenil", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "VyberPrihlaskyFakturace.findByPoznamky", query = "SELECT v FROM VyberPrihlaskyFakturace v WHERE v.poznamky = :poznamky")})
public class VyberPrihlaskyFakturace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VyberPrihlaskyFakturacePK vyberPrihlaskyFakturacePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fakturovat")
    private boolean fakturovat;
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
    @JoinColumn(name = "prihl_polozka", referencedColumnName = "polozka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrihlaskyRozpisy prihlaskyRozpisy;
    @JoinColumn(name = "druhprihl", referencedColumnName = "druh_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyPrihlasek druhyPrihlasek;

    public VyberPrihlaskyFakturace() {
    }

    public VyberPrihlaskyFakturace(VyberPrihlaskyFakturacePK vyberPrihlaskyFakturacePK) {
        this.vyberPrihlaskyFakturacePK = vyberPrihlaskyFakturacePK;
    }

    public VyberPrihlaskyFakturace(VyberPrihlaskyFakturacePK vyberPrihlaskyFakturacePK, boolean fakturovat) {
        this.vyberPrihlaskyFakturacePK = vyberPrihlaskyFakturacePK;
        this.fakturovat = fakturovat;
    }

    public VyberPrihlaskyFakturace(int prihlPolozka, int druhprihl, int faktDruh) {
        this.vyberPrihlaskyFakturacePK = new VyberPrihlaskyFakturacePK(prihlPolozka, druhprihl, faktDruh);
    }

    public VyberPrihlaskyFakturacePK getVyberPrihlaskyFakturacePK() {
        return vyberPrihlaskyFakturacePK;
    }

    public void setVyberPrihlaskyFakturacePK(VyberPrihlaskyFakturacePK vyberPrihlaskyFakturacePK) {
        this.vyberPrihlaskyFakturacePK = vyberPrihlaskyFakturacePK;
    }

    public boolean getFakturovat() {
        return fakturovat;
    }

    public void setFakturovat(boolean fakturovat) {
        this.fakturovat = fakturovat;
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

    public DruhyPrihlasek getDruhyPrihlasek() {
        return druhyPrihlasek;
    }

    public void setDruhyPrihlasek(DruhyPrihlasek druhyPrihlasek) {
        this.druhyPrihlasek = druhyPrihlasek;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vyberPrihlaskyFakturacePK != null ? vyberPrihlaskyFakturacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VyberPrihlaskyFakturace)) {
            return false;
        }
        VyberPrihlaskyFakturace other = (VyberPrihlaskyFakturace) object;
        if ((this.vyberPrihlaskyFakturacePK == null && other.vyberPrihlaskyFakturacePK != null) || (this.vyberPrihlaskyFakturacePK != null && !this.vyberPrihlaskyFakturacePK.equals(other.vyberPrihlaskyFakturacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VyberPrihlaskyFakturace[ vyberPrihlaskyFakturacePK=" + vyberPrihlaskyFakturacePK + " ]";
    }
    
}
