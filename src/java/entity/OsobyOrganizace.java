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
@Table(name = "osoby_organizace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsobyOrganizace.findAll", query = "SELECT o FROM OsobyOrganizace o"),
    @NamedQuery(name = "OsobyOrganizace.findByOsobaId", query = "SELECT o FROM OsobyOrganizace o WHERE o.osobyOrganizacePK.osobaId = :osobaId"),
    @NamedQuery(name = "OsobyOrganizace.findByOrganizaceId", query = "SELECT o FROM OsobyOrganizace o WHERE o.osobyOrganizacePK.organizaceId = :organizaceId"),
    @NamedQuery(name = "OsobyOrganizace.findByKdyVlozeno", query = "SELECT o FROM OsobyOrganizace o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "OsobyOrganizace.findByKdyZmeneno", query = "SELECT o FROM OsobyOrganizace o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "OsobyOrganizace.findByKdoVlozil", query = "SELECT o FROM OsobyOrganizace o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "OsobyOrganizace.findByKdoZmenil", query = "SELECT o FROM OsobyOrganizace o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "OsobyOrganizace.findByPoznamky", query = "SELECT o FROM OsobyOrganizace o WHERE o.poznamky = :poznamky")})
public class OsobyOrganizace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OsobyOrganizacePK osobyOrganizacePK;
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
    @JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;
    @JoinColumn(name = "organizace_id", referencedColumnName = "organizace_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organizace organizace;

    public OsobyOrganizace() {
    }

    public OsobyOrganizace(OsobyOrganizacePK osobyOrganizacePK) {
        this.osobyOrganizacePK = osobyOrganizacePK;
    }

    public OsobyOrganizace(int osobaId, int organizaceId) {
        this.osobyOrganizacePK = new OsobyOrganizacePK(osobaId, organizaceId);
    }

    public OsobyOrganizacePK getOsobyOrganizacePK() {
        return osobyOrganizacePK;
    }

    public void setOsobyOrganizacePK(OsobyOrganizacePK osobyOrganizacePK) {
        this.osobyOrganizacePK = osobyOrganizacePK;
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

    public Organizace getOrganizace() {
        return organizace;
    }

    public void setOrganizace(Organizace organizace) {
        this.organizace = organizace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osobyOrganizacePK != null ? osobyOrganizacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyOrganizace)) {
            return false;
        }
        OsobyOrganizace other = (OsobyOrganizace) object;
        if ((this.osobyOrganizacePK == null && other.osobyOrganizacePK != null) || (this.osobyOrganizacePK != null && !this.osobyOrganizacePK.equals(other.osobyOrganizacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OsobyOrganizace[ osobyOrganizacePK=" + osobyOrganizacePK + " ]";
    }
    
}
