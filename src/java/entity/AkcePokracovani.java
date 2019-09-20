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
@Table(name = "akce_pokracovani", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkcePokracovani.findAll", query = "SELECT a FROM AkcePokracovani a"),
    @NamedQuery(name = "AkcePokracovani.findByAkceId", query = "SELECT a FROM AkcePokracovani a WHERE a.akcePokracovaniPK.akceId = :akceId"),
    @NamedQuery(name = "AkcePokracovani.findByAkcePokrId", query = "SELECT a FROM AkcePokracovani a WHERE a.akcePokracovaniPK.akcePokrId = :akcePokrId"),
    @NamedQuery(name = "AkcePokracovani.findByAutomatickePrihlaseni", query = "SELECT a FROM AkcePokracovani a WHERE a.automatickePrihlaseni = :automatickePrihlaseni"),
    @NamedQuery(name = "AkcePokracovani.findByKdyVlozeno", query = "SELECT a FROM AkcePokracovani a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkcePokracovani.findByKdyZmeneno", query = "SELECT a FROM AkcePokracovani a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkcePokracovani.findByKdoVlozil", query = "SELECT a FROM AkcePokracovani a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkcePokracovani.findByKdoZmenil", query = "SELECT a FROM AkcePokracovani a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkcePokracovani.findByPoznamky", query = "SELECT a FROM AkcePokracovani a WHERE a.poznamky = :poznamky")})
public class AkcePokracovani implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkcePokracovaniPK akcePokracovaniPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automaticke_prihlaseni")
    private boolean automatickePrihlaseni;
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
    @JoinColumn(name = "akce_pokr_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni1;

    public AkcePokracovani() {
    }

    public AkcePokracovani(AkcePokracovaniPK akcePokracovaniPK) {
        this.akcePokracovaniPK = akcePokracovaniPK;
    }

    public AkcePokracovani(AkcePokracovaniPK akcePokracovaniPK, boolean automatickePrihlaseni) {
        this.akcePokracovaniPK = akcePokracovaniPK;
        this.automatickePrihlaseni = automatickePrihlaseni;
    }

    public AkcePokracovani(int akceId, int akcePokrId) {
        this.akcePokracovaniPK = new AkcePokracovaniPK(akceId, akcePokrId);
    }

    public AkcePokracovaniPK getAkcePokracovaniPK() {
        return akcePokracovaniPK;
    }

    public void setAkcePokracovaniPK(AkcePokracovaniPK akcePokracovaniPK) {
        this.akcePokracovaniPK = akcePokracovaniPK;
    }

    public boolean getAutomatickePrihlaseni() {
        return automatickePrihlaseni;
    }

    public void setAutomatickePrihlaseni(boolean automatickePrihlaseni) {
        this.automatickePrihlaseni = automatickePrihlaseni;
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

    public AkceHlavni getAkceHlavni() {
        return akceHlavni;
    }

    public void setAkceHlavni(AkceHlavni akceHlavni) {
        this.akceHlavni = akceHlavni;
    }

    public AkceHlavni getAkceHlavni1() {
        return akceHlavni1;
    }

    public void setAkceHlavni1(AkceHlavni akceHlavni1) {
        this.akceHlavni1 = akceHlavni1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akcePokracovaniPK != null ? akcePokracovaniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkcePokracovani)) {
            return false;
        }
        AkcePokracovani other = (AkcePokracovani) object;
        if ((this.akcePokracovaniPK == null && other.akcePokracovaniPK != null) || (this.akcePokracovaniPK != null && !this.akcePokracovaniPK.equals(other.akcePokracovaniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkcePokracovani[ akcePokracovaniPK=" + akcePokracovaniPK + " ]";
    }
    
}
