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
@Table(name = "akce_organizace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceOrganizace.findAll", query = "SELECT a FROM AkceOrganizace a"),
    @NamedQuery(name = "AkceOrganizace.findByAkceId", query = "SELECT a FROM AkceOrganizace a WHERE a.akceOrganizacePK.akceId = :akceId"),
    @NamedQuery(name = "AkceOrganizace.findByOrganizace", query = "SELECT a FROM AkceOrganizace a WHERE a.akceOrganizacePK.organizace = :organizace"),
    @NamedQuery(name = "AkceOrganizace.findByKdyVlozeno", query = "SELECT a FROM AkceOrganizace a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceOrganizace.findByKdyZmeneno", query = "SELECT a FROM AkceOrganizace a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceOrganizace.findByKdoVlozil", query = "SELECT a FROM AkceOrganizace a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceOrganizace.findByKdoZmenil", query = "SELECT a FROM AkceOrganizace a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceOrganizace.findByPoznamky", query = "SELECT a FROM AkceOrganizace a WHERE a.poznamky = :poznamky")})
public class AkceOrganizace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceOrganizacePK akceOrganizacePK;
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
    @JoinColumn(name = "organizace", referencedColumnName = "organizace_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organizace organizace1;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceOrganizace() {
    }

    public AkceOrganizace(AkceOrganizacePK akceOrganizacePK) {
        this.akceOrganizacePK = akceOrganizacePK;
    }

    public AkceOrganizace(int akceId, int organizace) {
        this.akceOrganizacePK = new AkceOrganizacePK(akceId, organizace);
    }

    public AkceOrganizacePK getAkceOrganizacePK() {
        return akceOrganizacePK;
    }

    public void setAkceOrganizacePK(AkceOrganizacePK akceOrganizacePK) {
        this.akceOrganizacePK = akceOrganizacePK;
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

    public Organizace getOrganizace1() {
        return organizace1;
    }

    public void setOrganizace1(Organizace organizace1) {
        this.organizace1 = organizace1;
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
        hash += (akceOrganizacePK != null ? akceOrganizacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceOrganizace)) {
            return false;
        }
        AkceOrganizace other = (AkceOrganizace) object;
        if ((this.akceOrganizacePK == null && other.akceOrganizacePK != null) || (this.akceOrganizacePK != null && !this.akceOrganizacePK.equals(other.akceOrganizacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceOrganizace[ akceOrganizacePK=" + akceOrganizacePK + " ]";
    }
    
}
