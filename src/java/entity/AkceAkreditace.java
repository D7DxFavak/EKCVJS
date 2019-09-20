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
@Table(name = "akce_akreditace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceAkreditace.findAll", query = "SELECT a FROM AkceAkreditace a"),
    @NamedQuery(name = "AkceAkreditace.findByAkceId", query = "SELECT a FROM AkceAkreditace a WHERE a.akceAkreditacePK.akceId = :akceId"),
    @NamedQuery(name = "AkceAkreditace.findByAkreditaceId", query = "SELECT a FROM AkceAkreditace a WHERE a.akceAkreditacePK.akreditaceId = :akreditaceId"),
    @NamedQuery(name = "AkceAkreditace.findByAkreditacePoradi", query = "SELECT a FROM AkceAkreditace a WHERE a.akceAkreditacePK.akreditacePoradi = :akreditacePoradi"),
    @NamedQuery(name = "AkceAkreditace.findByKdyVlozeno", query = "SELECT a FROM AkceAkreditace a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceAkreditace.findByKdyZmeneno", query = "SELECT a FROM AkceAkreditace a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceAkreditace.findByKdoVlozil", query = "SELECT a FROM AkceAkreditace a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceAkreditace.findByKdoZmenil", query = "SELECT a FROM AkceAkreditace a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceAkreditace.findByPoznamky", query = "SELECT a FROM AkceAkreditace a WHERE a.poznamky = :poznamky")})
public class AkceAkreditace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceAkreditacePK akceAkreditacePK;
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
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceAkreditace() {
    }

    public AkceAkreditace(AkceAkreditacePK akceAkreditacePK) {
        this.akceAkreditacePK = akceAkreditacePK;
    }

    public AkceAkreditace(int akceId, int akreditaceId, int akreditacePoradi) {
        this.akceAkreditacePK = new AkceAkreditacePK(akceId, akreditaceId, akreditacePoradi);
    }

    public AkceAkreditacePK getAkceAkreditacePK() {
        return akceAkreditacePK;
    }

    public void setAkceAkreditacePK(AkceAkreditacePK akceAkreditacePK) {
        this.akceAkreditacePK = akceAkreditacePK;
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

    public AkceHlavni getAkceHlavni() {
        return akceHlavni;
    }

    public void setAkceHlavni(AkceHlavni akceHlavni) {
        this.akceHlavni = akceHlavni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceAkreditacePK != null ? akceAkreditacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceAkreditace)) {
            return false;
        }
        AkceAkreditace other = (AkceAkreditace) object;
        if ((this.akceAkreditacePK == null && other.akceAkreditacePK != null) || (this.akceAkreditacePK != null && !this.akceAkreditacePK.equals(other.akceAkreditacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceAkreditace[ akceAkreditacePK=" + akceAkreditacePK + " ]";
    }
    
}
