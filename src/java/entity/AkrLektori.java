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
import javax.persistence.JoinColumns;
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
@Table(name = "akr_lektori", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrLektori.findAll", query = "SELECT a FROM AkrLektori a"),
    @NamedQuery(name = "AkrLektori.findByAkreditaceId", query = "SELECT a FROM AkrLektori a WHERE a.akrLektoriPK.akreditaceId = :akreditaceId"),
    @NamedQuery(name = "AkrLektori.findByAkreditacePoradi", query = "SELECT a FROM AkrLektori a WHERE a.akrLektoriPK.akreditacePoradi = :akreditacePoradi"),
    @NamedQuery(name = "AkrLektori.findByLektor", query = "SELECT a FROM AkrLektori a WHERE a.akrLektoriPK.lektor = :lektor"),
    @NamedQuery(name = "AkrLektori.findByKdyVlozeno", query = "SELECT a FROM AkrLektori a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkrLektori.findByKdyZmeneno", query = "SELECT a FROM AkrLektori a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkrLektori.findByKdoVlozil", query = "SELECT a FROM AkrLektori a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkrLektori.findByKdoZmenil", query = "SELECT a FROM AkrLektori a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkrLektori.findByPoznamky", query = "SELECT a FROM AkrLektori a WHERE a.poznamky = :poznamky")})
public class AkrLektori implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkrLektoriPK akrLektoriPK;
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
    @JoinColumn(name = "lektor", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;
    @JoinColumns({
        @JoinColumn(name = "akreditace_id", referencedColumnName = "akreditace_id", insertable = false, updatable = false),
        @JoinColumn(name = "akreditace_poradi", referencedColumnName = "akreditace_poradi", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AkreditaceHlavni akreditaceHlavni;

    public AkrLektori() {
    }

    public AkrLektori(AkrLektoriPK akrLektoriPK) {
        this.akrLektoriPK = akrLektoriPK;
    }

    public AkrLektori(int akreditaceId, int akreditacePoradi, int lektor) {
        this.akrLektoriPK = new AkrLektoriPK(akreditaceId, akreditacePoradi, lektor);
    }

    public AkrLektoriPK getAkrLektoriPK() {
        return akrLektoriPK;
    }

    public void setAkrLektoriPK(AkrLektoriPK akrLektoriPK) {
        this.akrLektoriPK = akrLektoriPK;
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

    public AkreditaceHlavni getAkreditaceHlavni() {
        return akreditaceHlavni;
    }

    public void setAkreditaceHlavni(AkreditaceHlavni akreditaceHlavni) {
        this.akreditaceHlavni = akreditaceHlavni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrLektoriPK != null ? akrLektoriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrLektori)) {
            return false;
        }
        AkrLektori other = (AkrLektori) object;
        if ((this.akrLektoriPK == null && other.akrLektoriPK != null) || (this.akrLektoriPK != null && !this.akrLektoriPK.equals(other.akrLektoriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrLektori[ akrLektoriPK=" + akrLektoriPK + " ]";
    }
    
}
