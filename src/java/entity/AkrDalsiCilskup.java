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
@Table(name = "akr_dalsi_cilskup", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrDalsiCilskup.findAll", query = "SELECT a FROM AkrDalsiCilskup a"),
    @NamedQuery(name = "AkrDalsiCilskup.findByAkreditaceId", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.akrDalsiCilskupPK.akreditaceId = :akreditaceId"),
    @NamedQuery(name = "AkrDalsiCilskup.findByAkreditacePoradi", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.akrDalsiCilskupPK.akreditacePoradi = :akreditacePoradi"),
    @NamedQuery(name = "AkrDalsiCilskup.findByCilskup", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.akrDalsiCilskupPK.cilskup = :cilskup"),
    @NamedQuery(name = "AkrDalsiCilskup.findByKdyVlozeno", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkrDalsiCilskup.findByKdyZmeneno", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkrDalsiCilskup.findByKdoVlozil", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkrDalsiCilskup.findByKdoZmenil", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkrDalsiCilskup.findByPoznamky", query = "SELECT a FROM AkrDalsiCilskup a WHERE a.poznamky = :poznamky")})
public class AkrDalsiCilskup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkrDalsiCilskupPK akrDalsiCilskupPK;
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
    @JoinColumns({
        @JoinColumn(name = "akreditace_id", referencedColumnName = "akreditace_id", insertable = false, updatable = false),
        @JoinColumn(name = "akreditace_poradi", referencedColumnName = "akreditace_poradi", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AkreditaceHlavni akreditaceHlavni;
    @JoinColumn(name = "cilskup", referencedColumnName = "akr_cilskup_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkrCiloveSkupiny akrCiloveSkupiny;

    public AkrDalsiCilskup() {
    }

    public AkrDalsiCilskup(AkrDalsiCilskupPK akrDalsiCilskupPK) {
        this.akrDalsiCilskupPK = akrDalsiCilskupPK;
    }

    public AkrDalsiCilskup(int akreditaceId, int akreditacePoradi, int cilskup) {
        this.akrDalsiCilskupPK = new AkrDalsiCilskupPK(akreditaceId, akreditacePoradi, cilskup);
    }

    public AkrDalsiCilskupPK getAkrDalsiCilskupPK() {
        return akrDalsiCilskupPK;
    }

    public void setAkrDalsiCilskupPK(AkrDalsiCilskupPK akrDalsiCilskupPK) {
        this.akrDalsiCilskupPK = akrDalsiCilskupPK;
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

    public AkreditaceHlavni getAkreditaceHlavni() {
        return akreditaceHlavni;
    }

    public void setAkreditaceHlavni(AkreditaceHlavni akreditaceHlavni) {
        this.akreditaceHlavni = akreditaceHlavni;
    }

    public AkrCiloveSkupiny getAkrCiloveSkupiny() {
        return akrCiloveSkupiny;
    }

    public void setAkrCiloveSkupiny(AkrCiloveSkupiny akrCiloveSkupiny) {
        this.akrCiloveSkupiny = akrCiloveSkupiny;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrDalsiCilskupPK != null ? akrDalsiCilskupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrDalsiCilskup)) {
            return false;
        }
        AkrDalsiCilskup other = (AkrDalsiCilskup) object;
        if ((this.akrDalsiCilskupPK == null && other.akrDalsiCilskupPK != null) || (this.akrDalsiCilskupPK != null && !this.akrDalsiCilskupPK.equals(other.akrDalsiCilskupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrDalsiCilskup[ akrDalsiCilskupPK=" + akrDalsiCilskupPK + " ]";
    }
    
}
