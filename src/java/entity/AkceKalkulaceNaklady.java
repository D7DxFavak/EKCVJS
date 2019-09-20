/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_kalkulace_naklady", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKalkulaceNaklady.findAll", query = "SELECT a FROM AkceKalkulaceNaklady a"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByAkceId", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.akceKalkulaceNakladyPK.akceId = :akceId"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByAkceKntId", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.akceKalkulaceNakladyPK.akceKntId = :akceKntId"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByAkceKnpId", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.akceKalkulaceNakladyPK.akceKnpId = :akceKnpId"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByCenaJednotka", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.cenaJednotka = :cenaJednotka"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByPocetJednotek", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.pocetJednotek = :pocetJednotek"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByStrucnyVycet", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.strucnyVycet = :strucnyVycet"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByKladZapor", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.kladZapor = :kladZapor"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByKdyVlozeno", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByKdyZmeneno", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByKdoVlozil", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByKdoZmenil", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceKalkulaceNaklady.findByPoznamky", query = "SELECT a FROM AkceKalkulaceNaklady a WHERE a.poznamky = :poznamky")})
public class AkceKalkulaceNaklady implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceKalkulaceNakladyPK akceKalkulaceNakladyPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena_jednotka")
    private BigDecimal cenaJednotka;
    @Column(name = "pocet_jednotek")
    private Integer pocetJednotek;
    @Size(max = 2147483647)
    @Column(name = "strucny_vycet")
    private String strucnyVycet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "klad_zapor")
    private boolean kladZapor;
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
    @JoinColumn(name = "zpusob_platby", referencedColumnName = "forma_platby_id")
    @ManyToOne
    private FormyPlateb zpusobPlatby;
    @JoinColumns({
        @JoinColumn(name = "akce_knt_id", referencedColumnName = "akce_knt_id", insertable = false, updatable = false),
        @JoinColumn(name = "akce_knp_id", referencedColumnName = "akce_knp_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AkceKnp akceKnp;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceKalkulaceNaklady() {
    }

    public AkceKalkulaceNaklady(AkceKalkulaceNakladyPK akceKalkulaceNakladyPK) {
        this.akceKalkulaceNakladyPK = akceKalkulaceNakladyPK;
    }

    public AkceKalkulaceNaklady(AkceKalkulaceNakladyPK akceKalkulaceNakladyPK, boolean kladZapor) {
        this.akceKalkulaceNakladyPK = akceKalkulaceNakladyPK;
        this.kladZapor = kladZapor;
    }

    public AkceKalkulaceNaklady(int akceId, int akceKntId, int akceKnpId) {
        this.akceKalkulaceNakladyPK = new AkceKalkulaceNakladyPK(akceId, akceKntId, akceKnpId);
    }

    public AkceKalkulaceNakladyPK getAkceKalkulaceNakladyPK() {
        return akceKalkulaceNakladyPK;
    }

    public void setAkceKalkulaceNakladyPK(AkceKalkulaceNakladyPK akceKalkulaceNakladyPK) {
        this.akceKalkulaceNakladyPK = akceKalkulaceNakladyPK;
    }

    public BigDecimal getCenaJednotka() {
        return cenaJednotka;
    }

    public void setCenaJednotka(BigDecimal cenaJednotka) {
        this.cenaJednotka = cenaJednotka;
    }

    public Integer getPocetJednotek() {
        return pocetJednotek;
    }

    public void setPocetJednotek(Integer pocetJednotek) {
        this.pocetJednotek = pocetJednotek;
    }

    public String getStrucnyVycet() {
        return strucnyVycet;
    }

    public void setStrucnyVycet(String strucnyVycet) {
        this.strucnyVycet = strucnyVycet;
    }

    public boolean getKladZapor() {
        return kladZapor;
    }

    public void setKladZapor(boolean kladZapor) {
        this.kladZapor = kladZapor;
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

    public FormyPlateb getZpusobPlatby() {
        return zpusobPlatby;
    }

    public void setZpusobPlatby(FormyPlateb zpusobPlatby) {
        this.zpusobPlatby = zpusobPlatby;
    }

    public AkceKnp getAkceKnp() {
        return akceKnp;
    }

    public void setAkceKnp(AkceKnp akceKnp) {
        this.akceKnp = akceKnp;
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
        hash += (akceKalkulaceNakladyPK != null ? akceKalkulaceNakladyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKalkulaceNaklady)) {
            return false;
        }
        AkceKalkulaceNaklady other = (AkceKalkulaceNaklady) object;
        if ((this.akceKalkulaceNakladyPK == null && other.akceKalkulaceNakladyPK != null) || (this.akceKalkulaceNakladyPK != null && !this.akceKalkulaceNakladyPK.equals(other.akceKalkulaceNakladyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKalkulaceNaklady[ akceKalkulaceNakladyPK=" + akceKalkulaceNakladyPK + " ]";
    }
    
}
