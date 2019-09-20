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
@Table(name = "nabidky_osoby", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NabidkyOsoby.findAll", query = "SELECT n FROM NabidkyOsoby n"),
    @NamedQuery(name = "NabidkyOsoby.findByOsoba", query = "SELECT n FROM NabidkyOsoby n WHERE n.nabidkyOsobyPK.osoba = :osoba"),
    @NamedQuery(name = "NabidkyOsoby.findByFormaNabidky", query = "SELECT n FROM NabidkyOsoby n WHERE n.nabidkyOsobyPK.formaNabidky = :formaNabidky"),
    @NamedQuery(name = "NabidkyOsoby.findByDatumPoslOdeslani", query = "SELECT n FROM NabidkyOsoby n WHERE n.datumPoslOdeslani = :datumPoslOdeslani"),
    @NamedQuery(name = "NabidkyOsoby.findByPlatnostDo", query = "SELECT n FROM NabidkyOsoby n WHERE n.platnostDo = :platnostDo"),
    @NamedQuery(name = "NabidkyOsoby.findByKdyVlozeno", query = "SELECT n FROM NabidkyOsoby n WHERE n.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "NabidkyOsoby.findByKdyZmeneno", query = "SELECT n FROM NabidkyOsoby n WHERE n.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "NabidkyOsoby.findByKdoVlozil", query = "SELECT n FROM NabidkyOsoby n WHERE n.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "NabidkyOsoby.findByKdoZmenil", query = "SELECT n FROM NabidkyOsoby n WHERE n.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "NabidkyOsoby.findByPoznamky", query = "SELECT n FROM NabidkyOsoby n WHERE n.poznamky = :poznamky")})
public class NabidkyOsoby implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NabidkyOsobyPK nabidkyOsobyPK;
    @Column(name = "datum_posl_odeslani")
    @Temporal(TemporalType.DATE)
    private Date datumPoslOdeslani;
    @Column(name = "platnost_do")
    @Temporal(TemporalType.DATE)
    private Date platnostDo;
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
    @JoinColumn(name = "osoba", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;
    @JoinColumn(name = "forma_nabidky", referencedColumnName = "forma_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FormyNabidek formyNabidek;

    public NabidkyOsoby() {
    }

    public NabidkyOsoby(NabidkyOsobyPK nabidkyOsobyPK) {
        this.nabidkyOsobyPK = nabidkyOsobyPK;
    }

    public NabidkyOsoby(int osoba, int formaNabidky) {
        this.nabidkyOsobyPK = new NabidkyOsobyPK(osoba, formaNabidky);
    }

    public NabidkyOsobyPK getNabidkyOsobyPK() {
        return nabidkyOsobyPK;
    }

    public void setNabidkyOsobyPK(NabidkyOsobyPK nabidkyOsobyPK) {
        this.nabidkyOsobyPK = nabidkyOsobyPK;
    }

    public Date getDatumPoslOdeslani() {
        return datumPoslOdeslani;
    }

    public void setDatumPoslOdeslani(Date datumPoslOdeslani) {
        this.datumPoslOdeslani = datumPoslOdeslani;
    }

    public Date getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(Date platnostDo) {
        this.platnostDo = platnostDo;
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

    public FormyNabidek getFormyNabidek() {
        return formyNabidek;
    }

    public void setFormyNabidek(FormyNabidek formyNabidek) {
        this.formyNabidek = formyNabidek;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nabidkyOsobyPK != null ? nabidkyOsobyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NabidkyOsoby)) {
            return false;
        }
        NabidkyOsoby other = (NabidkyOsoby) object;
        if ((this.nabidkyOsobyPK == null && other.nabidkyOsobyPK != null) || (this.nabidkyOsobyPK != null && !this.nabidkyOsobyPK.equals(other.nabidkyOsobyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NabidkyOsoby[ nabidkyOsobyPK=" + nabidkyOsobyPK + " ]";
    }
    
}
