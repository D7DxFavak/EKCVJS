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
@Table(name = "osoby_druhy_prirazeni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsobyDruhyPrirazeni.findAll", query = "SELECT o FROM OsobyDruhyPrirazeni o"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByOsobaId", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.osobyDruhyPrirazeniPK.osobaId = :osobaId"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByDruhosoby", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.osobyDruhyPrirazeniPK.druhosoby = :druhosoby"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByKdyVlozeno", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByKdyZmeneno", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByKdoVlozil", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByKdoZmenil", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "OsobyDruhyPrirazeni.findByPoznamky", query = "SELECT o FROM OsobyDruhyPrirazeni o WHERE o.poznamky = :poznamky")})
public class OsobyDruhyPrirazeni implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OsobyDruhyPrirazeniPK osobyDruhyPrirazeniPK;
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
    @JoinColumn(name = "druhosoby", referencedColumnName = "druh_osoby_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OsobyDruhy osobyDruhy;
    @JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;

    public OsobyDruhyPrirazeni() {
    }

    public OsobyDruhyPrirazeni(OsobyDruhyPrirazeniPK osobyDruhyPrirazeniPK) {
        this.osobyDruhyPrirazeniPK = osobyDruhyPrirazeniPK;
    }

    public OsobyDruhyPrirazeni(int osobaId, int druhosoby) {
        this.osobyDruhyPrirazeniPK = new OsobyDruhyPrirazeniPK(osobaId, druhosoby);
    }

    public OsobyDruhyPrirazeniPK getOsobyDruhyPrirazeniPK() {
        return osobyDruhyPrirazeniPK;
    }

    public void setOsobyDruhyPrirazeniPK(OsobyDruhyPrirazeniPK osobyDruhyPrirazeniPK) {
        this.osobyDruhyPrirazeniPK = osobyDruhyPrirazeniPK;
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

    public OsobyDruhy getOsobyDruhy() {
        return osobyDruhy;
    }

    public void setOsobyDruhy(OsobyDruhy osobyDruhy) {
        this.osobyDruhy = osobyDruhy;
    }

    public Osoby getOsoby() {
        return osoby;
    }

    public void setOsoby(Osoby osoby) {
        this.osoby = osoby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osobyDruhyPrirazeniPK != null ? osobyDruhyPrirazeniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyDruhyPrirazeni)) {
            return false;
        }
        OsobyDruhyPrirazeni other = (OsobyDruhyPrirazeni) object;
        if ((this.osobyDruhyPrirazeniPK == null && other.osobyDruhyPrirazeniPK != null) || (this.osobyDruhyPrirazeniPK != null && !this.osobyDruhyPrirazeniPK.equals(other.osobyDruhyPrirazeniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OsobyDruhyPrirazeni[ osobyDruhyPrirazeniPK=" + osobyDruhyPrirazeniPK + " ]";
    }
    
}
