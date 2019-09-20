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
@Table(name = "akce_cilskup", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceCilskup.findAll", query = "SELECT a FROM AkceCilskup a"),
    @NamedQuery(name = "AkceCilskup.findByAkceId", query = "SELECT a FROM AkceCilskup a WHERE a.akceCilskupPK.akceId = :akceId"),
    @NamedQuery(name = "AkceCilskup.findByCilskup", query = "SELECT a FROM AkceCilskup a WHERE a.akceCilskupPK.cilskup = :cilskup"),
    @NamedQuery(name = "AkceCilskup.findByKdyVlozeno", query = "SELECT a FROM AkceCilskup a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceCilskup.findByKdyZmeneno", query = "SELECT a FROM AkceCilskup a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceCilskup.findByKdoVlozil", query = "SELECT a FROM AkceCilskup a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceCilskup.findByKdoZmenil", query = "SELECT a FROM AkceCilskup a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceCilskup.findByPoznamky", query = "SELECT a FROM AkceCilskup a WHERE a.poznamky = :poznamky"),
    @NamedQuery(name = "AkceCilskup.findByHlavni", query = "SELECT a FROM AkceCilskup a WHERE a.hlavni = :hlavni")})
public class AkceCilskup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceCilskupPK akceCilskupPK;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "hlavni")
    private boolean hlavni;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;
    @JoinColumn(name = "cilskup", referencedColumnName = "akce_cilskup_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceCiloveSkupiny akceCiloveSkupiny;

    public AkceCilskup() {
    }

    public AkceCilskup(AkceCilskupPK akceCilskupPK) {
        this.akceCilskupPK = akceCilskupPK;
    }

    public AkceCilskup(AkceCilskupPK akceCilskupPK, boolean hlavni) {
        this.akceCilskupPK = akceCilskupPK;
        this.hlavni = hlavni;
    }

    public AkceCilskup(int akceId, int cilskup) {
        this.akceCilskupPK = new AkceCilskupPK(akceId, cilskup);
    }

    public AkceCilskupPK getAkceCilskupPK() {
        return akceCilskupPK;
    }

    public void setAkceCilskupPK(AkceCilskupPK akceCilskupPK) {
        this.akceCilskupPK = akceCilskupPK;
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

    public boolean getHlavni() {
        return hlavni;
    }

    public void setHlavni(boolean hlavni) {
        this.hlavni = hlavni;
    }

    public AkceHlavni getAkceHlavni() {
        return akceHlavni;
    }

    public void setAkceHlavni(AkceHlavni akceHlavni) {
        this.akceHlavni = akceHlavni;
    }

    public AkceCiloveSkupiny getAkceCiloveSkupiny() {
        return akceCiloveSkupiny;
    }

    public void setAkceCiloveSkupiny(AkceCiloveSkupiny akceCiloveSkupiny) {
        this.akceCiloveSkupiny = akceCiloveSkupiny;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceCilskupPK != null ? akceCilskupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceCilskup)) {
            return false;
        }
        AkceCilskup other = (AkceCilskup) object;
        if ((this.akceCilskupPK == null && other.akceCilskupPK != null) || (this.akceCilskupPK != null && !this.akceCilskupPK.equals(other.akceCilskupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceCilskup[ akceCilskupPK=" + akceCilskupPK + " ]";
    }
    
}
