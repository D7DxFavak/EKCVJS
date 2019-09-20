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
@Table(name = "akce_dalsi_obory", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceDalsiObory.findAll", query = "SELECT a FROM AkceDalsiObory a"),
    @NamedQuery(name = "AkceDalsiObory.findByAkceId", query = "SELECT a FROM AkceDalsiObory a WHERE a.akceDalsiOboryPK.akceId = :akceId"),
    @NamedQuery(name = "AkceDalsiObory.findByDalsiobor", query = "SELECT a FROM AkceDalsiObory a WHERE a.akceDalsiOboryPK.dalsiobor = :dalsiobor"),
    @NamedQuery(name = "AkceDalsiObory.findByKdyVlozeno", query = "SELECT a FROM AkceDalsiObory a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceDalsiObory.findByKdyZmeneno", query = "SELECT a FROM AkceDalsiObory a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceDalsiObory.findByKdoVlozil", query = "SELECT a FROM AkceDalsiObory a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceDalsiObory.findByKdoZmenil", query = "SELECT a FROM AkceDalsiObory a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceDalsiObory.findByPoznamky", query = "SELECT a FROM AkceDalsiObory a WHERE a.poznamky = :poznamky")})
public class AkceDalsiObory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceDalsiOboryPK akceDalsiOboryPK;
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
    @JoinColumn(name = "dalsiobor", referencedColumnName = "obor_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Obory obory;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceDalsiObory() {
    }

    public AkceDalsiObory(AkceDalsiOboryPK akceDalsiOboryPK) {
        this.akceDalsiOboryPK = akceDalsiOboryPK;
    }

    public AkceDalsiObory(int akceId, int dalsiobor) {
        this.akceDalsiOboryPK = new AkceDalsiOboryPK(akceId, dalsiobor);
    }

    public AkceDalsiOboryPK getAkceDalsiOboryPK() {
        return akceDalsiOboryPK;
    }

    public void setAkceDalsiOboryPK(AkceDalsiOboryPK akceDalsiOboryPK) {
        this.akceDalsiOboryPK = akceDalsiOboryPK;
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

    public Obory getObory() {
        return obory;
    }

    public void setObory(Obory obory) {
        this.obory = obory;
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
        hash += (akceDalsiOboryPK != null ? akceDalsiOboryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceDalsiObory)) {
            return false;
        }
        AkceDalsiObory other = (AkceDalsiObory) object;
        if ((this.akceDalsiOboryPK == null && other.akceDalsiOboryPK != null) || (this.akceDalsiOboryPK != null && !this.akceDalsiOboryPK.equals(other.akceDalsiOboryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceDalsiObory[ akceDalsiOboryPK=" + akceDalsiOboryPK + " ]";
    }
    
}
