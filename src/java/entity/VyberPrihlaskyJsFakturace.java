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
@Table(name = "vyber_prihlasky_js_fakturace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findAll", query = "SELECT v FROM VyberPrihlaskyJsFakturace v"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByPrihlPolozka", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.vyberPrihlaskyJsFakturacePK.prihlPolozka = :prihlPolozka"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByDruhprihl", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.vyberPrihlaskyJsFakturacePK.druhprihl = :druhprihl"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByFaktDruh", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.vyberPrihlaskyJsFakturacePK.faktDruh = :faktDruh"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByFakturovat", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.fakturovat = :fakturovat"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByKdyVlozeno", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByKdyZmeneno", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByKdoVlozil", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByKdoZmenil", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "VyberPrihlaskyJsFakturace.findByPoznamky", query = "SELECT v FROM VyberPrihlaskyJsFakturace v WHERE v.poznamky = :poznamky")})
public class VyberPrihlaskyJsFakturace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VyberPrihlaskyJsFakturacePK vyberPrihlaskyJsFakturacePK;
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
    private PrihlaskyRozpisyJs prihlaskyRozpisyJs;
    @JoinColumn(name = "druhprihl", referencedColumnName = "druh_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyPrihlasek druhyPrihlasek;

    public VyberPrihlaskyJsFakturace() {
    }

    public VyberPrihlaskyJsFakturace(VyberPrihlaskyJsFakturacePK vyberPrihlaskyJsFakturacePK) {
        this.vyberPrihlaskyJsFakturacePK = vyberPrihlaskyJsFakturacePK;
    }

    public VyberPrihlaskyJsFakturace(VyberPrihlaskyJsFakturacePK vyberPrihlaskyJsFakturacePK, boolean fakturovat) {
        this.vyberPrihlaskyJsFakturacePK = vyberPrihlaskyJsFakturacePK;
        this.fakturovat = fakturovat;
    }

    public VyberPrihlaskyJsFakturace(int prihlPolozka, int druhprihl, int faktDruh) {
        this.vyberPrihlaskyJsFakturacePK = new VyberPrihlaskyJsFakturacePK(prihlPolozka, druhprihl, faktDruh);
    }

    public VyberPrihlaskyJsFakturacePK getVyberPrihlaskyJsFakturacePK() {
        return vyberPrihlaskyJsFakturacePK;
    }

    public void setVyberPrihlaskyJsFakturacePK(VyberPrihlaskyJsFakturacePK vyberPrihlaskyJsFakturacePK) {
        this.vyberPrihlaskyJsFakturacePK = vyberPrihlaskyJsFakturacePK;
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

    public PrihlaskyRozpisyJs getPrihlaskyRozpisyJs() {
        return prihlaskyRozpisyJs;
    }

    public void setPrihlaskyRozpisyJs(PrihlaskyRozpisyJs prihlaskyRozpisyJs) {
        this.prihlaskyRozpisyJs = prihlaskyRozpisyJs;
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
        hash += (vyberPrihlaskyJsFakturacePK != null ? vyberPrihlaskyJsFakturacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VyberPrihlaskyJsFakturace)) {
            return false;
        }
        VyberPrihlaskyJsFakturace other = (VyberPrihlaskyJsFakturace) object;
        if ((this.vyberPrihlaskyJsFakturacePK == null && other.vyberPrihlaskyJsFakturacePK != null) || (this.vyberPrihlaskyJsFakturacePK != null && !this.vyberPrihlaskyJsFakturacePK.equals(other.vyberPrihlaskyJsFakturacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VyberPrihlaskyJsFakturace[ vyberPrihlaskyJsFakturacePK=" + vyberPrihlaskyJsFakturacePK + " ]";
    }
    
}
