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
@Table(name = "nabidky_organizace", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NabidkyOrganizace.findAll", query = "SELECT n FROM NabidkyOrganizace n"),
    @NamedQuery(name = "NabidkyOrganizace.findByOrganizace", query = "SELECT n FROM NabidkyOrganizace n WHERE n.nabidkyOrganizacePK.organizace = :organizace"),
    @NamedQuery(name = "NabidkyOrganizace.findByFormaNabidky", query = "SELECT n FROM NabidkyOrganizace n WHERE n.nabidkyOrganizacePK.formaNabidky = :formaNabidky"),
    @NamedQuery(name = "NabidkyOrganizace.findByDatumPoslOdeslani", query = "SELECT n FROM NabidkyOrganizace n WHERE n.datumPoslOdeslani = :datumPoslOdeslani"),
    @NamedQuery(name = "NabidkyOrganizace.findByPlatnostDo", query = "SELECT n FROM NabidkyOrganizace n WHERE n.platnostDo = :platnostDo"),
    @NamedQuery(name = "NabidkyOrganizace.findByKdyVlozeno", query = "SELECT n FROM NabidkyOrganizace n WHERE n.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "NabidkyOrganizace.findByKdyZmeneno", query = "SELECT n FROM NabidkyOrganizace n WHERE n.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "NabidkyOrganizace.findByKdoVlozil", query = "SELECT n FROM NabidkyOrganizace n WHERE n.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "NabidkyOrganizace.findByKdoZmenil", query = "SELECT n FROM NabidkyOrganizace n WHERE n.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "NabidkyOrganizace.findByPoznamky", query = "SELECT n FROM NabidkyOrganizace n WHERE n.poznamky = :poznamky")})
public class NabidkyOrganizace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NabidkyOrganizacePK nabidkyOrganizacePK;
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
    @JoinColumn(name = "organizace", referencedColumnName = "organizace_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organizace organizace1;
    @JoinColumn(name = "forma_nabidky", referencedColumnName = "forma_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FormyNabidek formyNabidek;

    public NabidkyOrganizace() {
    }

    public NabidkyOrganizace(NabidkyOrganizacePK nabidkyOrganizacePK) {
        this.nabidkyOrganizacePK = nabidkyOrganizacePK;
    }

    public NabidkyOrganizace(int organizace, int formaNabidky) {
        this.nabidkyOrganizacePK = new NabidkyOrganizacePK(organizace, formaNabidky);
    }

    public NabidkyOrganizacePK getNabidkyOrganizacePK() {
        return nabidkyOrganizacePK;
    }

    public void setNabidkyOrganizacePK(NabidkyOrganizacePK nabidkyOrganizacePK) {
        this.nabidkyOrganizacePK = nabidkyOrganizacePK;
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

    public Organizace getOrganizace1() {
        return organizace1;
    }

    public void setOrganizace1(Organizace organizace1) {
        this.organizace1 = organizace1;
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
        hash += (nabidkyOrganizacePK != null ? nabidkyOrganizacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NabidkyOrganizace)) {
            return false;
        }
        NabidkyOrganizace other = (NabidkyOrganizace) object;
        if ((this.nabidkyOrganizacePK == null && other.nabidkyOrganizacePK != null) || (this.nabidkyOrganizacePK != null && !this.nabidkyOrganizacePK.equals(other.nabidkyOrganizacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NabidkyOrganizace[ nabidkyOrganizacePK=" + nabidkyOrganizacePK + " ]";
    }
    
}
