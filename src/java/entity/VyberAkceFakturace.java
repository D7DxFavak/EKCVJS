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
@Table(name = "vyber_akce_fakturace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VyberAkceFakturace.findAll", query = "SELECT v FROM VyberAkceFakturace v"),
    @NamedQuery(name = "VyberAkceFakturace.findByAkce", query = "SELECT v FROM VyberAkceFakturace v WHERE v.vyberAkceFakturacePK.akce = :akce"),
    @NamedQuery(name = "VyberAkceFakturace.findByDruhprihl", query = "SELECT v FROM VyberAkceFakturace v WHERE v.vyberAkceFakturacePK.druhprihl = :druhprihl"),
    @NamedQuery(name = "VyberAkceFakturace.findByFaktDruh", query = "SELECT v FROM VyberAkceFakturace v WHERE v.vyberAkceFakturacePK.faktDruh = :faktDruh"),
    @NamedQuery(name = "VyberAkceFakturace.findByFakturovat", query = "SELECT v FROM VyberAkceFakturace v WHERE v.fakturovat = :fakturovat"),
    @NamedQuery(name = "VyberAkceFakturace.findByKdyVlozeno", query = "SELECT v FROM VyberAkceFakturace v WHERE v.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "VyberAkceFakturace.findByKdyZmeneno", query = "SELECT v FROM VyberAkceFakturace v WHERE v.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "VyberAkceFakturace.findByKdoVlozil", query = "SELECT v FROM VyberAkceFakturace v WHERE v.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "VyberAkceFakturace.findByKdoZmenil", query = "SELECT v FROM VyberAkceFakturace v WHERE v.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "VyberAkceFakturace.findByPoznamky", query = "SELECT v FROM VyberAkceFakturace v WHERE v.poznamky = :poznamky")})
public class VyberAkceFakturace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VyberAkceFakturacePK vyberAkceFakturacePK;
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
    @JoinColumn(name = "druhprihl", referencedColumnName = "druh_prihl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyPrihlasek druhyPrihlasek;
    @JoinColumn(name = "akce", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public VyberAkceFakturace() {
    }

    public VyberAkceFakturace(VyberAkceFakturacePK vyberAkceFakturacePK) {
        this.vyberAkceFakturacePK = vyberAkceFakturacePK;
    }

    public VyberAkceFakturace(VyberAkceFakturacePK vyberAkceFakturacePK, boolean fakturovat) {
        this.vyberAkceFakturacePK = vyberAkceFakturacePK;
        this.fakturovat = fakturovat;
    }

    public VyberAkceFakturace(int akce, int druhprihl, int faktDruh) {
        this.vyberAkceFakturacePK = new VyberAkceFakturacePK(akce, druhprihl, faktDruh);
    }

    public VyberAkceFakturacePK getVyberAkceFakturacePK() {
        return vyberAkceFakturacePK;
    }

    public void setVyberAkceFakturacePK(VyberAkceFakturacePK vyberAkceFakturacePK) {
        this.vyberAkceFakturacePK = vyberAkceFakturacePK;
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

    public DruhyPrihlasek getDruhyPrihlasek() {
        return druhyPrihlasek;
    }

    public void setDruhyPrihlasek(DruhyPrihlasek druhyPrihlasek) {
        this.druhyPrihlasek = druhyPrihlasek;
    }

    public AkceHlavni getAkceHlavni() {
        return akceHlavni;
    }

    public void setAkceHlavni(AkceHlavni akceHlavni) {
        this.akceHlavni = akceHlavni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vyberAkceFakturacePK != null ? vyberAkceFakturacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VyberAkceFakturace)) {
            return false;
        }
        VyberAkceFakturace other = (VyberAkceFakturace) object;
        if ((this.vyberAkceFakturacePK == null && other.vyberAkceFakturacePK != null) || (this.vyberAkceFakturacePK != null && !this.vyberAkceFakturacePK.equals(other.vyberAkceFakturacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VyberAkceFakturace[ vyberAkceFakturacePK=" + vyberAkceFakturacePK + " ]";
    }
    
}
