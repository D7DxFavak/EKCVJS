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
@Table(name = "akce_navaznosti", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceNavaznosti.findAll", query = "SELECT a FROM AkceNavaznosti a"),
    @NamedQuery(name = "AkceNavaznosti.findByAkceId", query = "SELECT a FROM AkceNavaznosti a WHERE a.akceNavaznostiPK.akceId = :akceId"),
    @NamedQuery(name = "AkceNavaznosti.findByAkceNavId", query = "SELECT a FROM AkceNavaznosti a WHERE a.akceNavaznostiPK.akceNavId = :akceNavId"),
    @NamedQuery(name = "AkceNavaznosti.findByKdyVlozeno", query = "SELECT a FROM AkceNavaznosti a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceNavaznosti.findByKdyZmeneno", query = "SELECT a FROM AkceNavaznosti a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceNavaznosti.findByKdoVlozil", query = "SELECT a FROM AkceNavaznosti a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceNavaznosti.findByKdoZmenil", query = "SELECT a FROM AkceNavaznosti a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceNavaznosti.findByPoznamky", query = "SELECT a FROM AkceNavaznosti a WHERE a.poznamky = :poznamky")})
public class AkceNavaznosti implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceNavaznostiPK akceNavaznostiPK;
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
    @JoinColumn(name = "akce_nav_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni1;

    public AkceNavaznosti() {
    }

    public AkceNavaznosti(AkceNavaznostiPK akceNavaznostiPK) {
        this.akceNavaznostiPK = akceNavaznostiPK;
    }

    public AkceNavaznosti(int akceId, int akceNavId) {
        this.akceNavaznostiPK = new AkceNavaznostiPK(akceId, akceNavId);
    }

    public AkceNavaznostiPK getAkceNavaznostiPK() {
        return akceNavaznostiPK;
    }

    public void setAkceNavaznostiPK(AkceNavaznostiPK akceNavaznostiPK) {
        this.akceNavaznostiPK = akceNavaznostiPK;
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
        hash += (akceNavaznostiPK != null ? akceNavaznostiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceNavaznosti)) {
            return false;
        }
        AkceNavaznosti other = (AkceNavaznosti) object;
        if ((this.akceNavaznostiPK == null && other.akceNavaznostiPK != null) || (this.akceNavaznostiPK != null && !this.akceNavaznostiPK.equals(other.akceNavaznostiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceNavaznosti[ akceNavaznostiPK=" + akceNavaznostiPK + " ]";
    }
    
}
