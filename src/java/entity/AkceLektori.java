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
@Table(name = "akce_lektori", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceLektori.findAll", query = "SELECT a FROM AkceLektori a"),
    @NamedQuery(name = "AkceLektori.findByAkceId", query = "SELECT a FROM AkceLektori a WHERE a.akceLektoriPK.akceId = :akceId"),
    @NamedQuery(name = "AkceLektori.findByAkceLektor", query = "SELECT a FROM AkceLektori a WHERE a.akceLektoriPK.akceLektor = :akceLektor"),
    @NamedQuery(name = "AkceLektori.findByKdyVlozeno", query = "SELECT a FROM AkceLektori a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceLektori.findByKdyZmeneno", query = "SELECT a FROM AkceLektori a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceLektori.findByKdoVlozil", query = "SELECT a FROM AkceLektori a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceLektori.findByKdoZmenil", query = "SELECT a FROM AkceLektori a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceLektori.findByPoznamky", query = "SELECT a FROM AkceLektori a WHERE a.poznamky = :poznamky")})
public class AkceLektori implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceLektoriPK akceLektoriPK;
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
    @JoinColumn(name = "akce_lektor", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceLektori() {
    }

    public AkceLektori(AkceLektoriPK akceLektoriPK) {
        this.akceLektoriPK = akceLektoriPK;
    }

    public AkceLektori(int akceId, int akceLektor) {
        this.akceLektoriPK = new AkceLektoriPK(akceId, akceLektor);
    }

    public AkceLektoriPK getAkceLektoriPK() {
        return akceLektoriPK;
    }

    public void setAkceLektoriPK(AkceLektoriPK akceLektoriPK) {
        this.akceLektoriPK = akceLektoriPK;
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

    public Osoby getOsoby() {
        return osoby;
    }

    public void setOsoby(Osoby osoby) {
        this.osoby = osoby;
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
        hash += (akceLektoriPK != null ? akceLektoriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceLektori)) {
            return false;
        }
        AkceLektori other = (AkceLektori) object;
        if ((this.akceLektoriPK == null && other.akceLektoriPK != null) || (this.akceLektoriPK != null && !this.akceLektoriPK.equals(other.akceLektoriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceLektori[ akceLektoriPK=" + akceLektoriPK + " ]";
    }
    
}
