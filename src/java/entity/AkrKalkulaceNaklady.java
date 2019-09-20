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
@Table(name = "akr_kalkulace_naklady", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrKalkulaceNaklady.findAll", query = "SELECT a FROM AkrKalkulaceNaklady a"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByAkreditaceId", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.akrKalkulaceNakladyPK.akreditaceId = :akreditaceId"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByAkreditacePoradi", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.akrKalkulaceNakladyPK.akreditacePoradi = :akreditacePoradi"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByAkrKntId", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.akrKalkulaceNakladyPK.akrKntId = :akrKntId"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByAkrKnpId", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.akrKalkulaceNakladyPK.akrKnpId = :akrKnpId"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByCenaJednotka", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.cenaJednotka = :cenaJednotka"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByPocetJednotek", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.pocetJednotek = :pocetJednotek"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByStrucnyVycet", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.strucnyVycet = :strucnyVycet"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByKladZapor", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.kladZapor = :kladZapor"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByKdyVlozeno", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByKdyZmeneno", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByKdoVlozil", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByKdoZmenil", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkrKalkulaceNaklady.findByPoznamky", query = "SELECT a FROM AkrKalkulaceNaklady a WHERE a.poznamky = :poznamky")})
public class AkrKalkulaceNaklady implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkrKalkulaceNakladyPK akrKalkulaceNakladyPK;
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
        @JoinColumn(name = "akreditace_id", referencedColumnName = "akreditace_id", insertable = false, updatable = false),
        @JoinColumn(name = "akreditace_poradi", referencedColumnName = "akreditace_poradi", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AkreditaceHlavni akreditaceHlavni;
    @JoinColumns({
        @JoinColumn(name = "akr_knt_id", referencedColumnName = "akr_knt_id", insertable = false, updatable = false),
        @JoinColumn(name = "akr_knp_id", referencedColumnName = "akr_knp_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AkrKnp akrKnp;

    public AkrKalkulaceNaklady() {
    }

    public AkrKalkulaceNaklady(AkrKalkulaceNakladyPK akrKalkulaceNakladyPK) {
        this.akrKalkulaceNakladyPK = akrKalkulaceNakladyPK;
    }

    public AkrKalkulaceNaklady(AkrKalkulaceNakladyPK akrKalkulaceNakladyPK, boolean kladZapor) {
        this.akrKalkulaceNakladyPK = akrKalkulaceNakladyPK;
        this.kladZapor = kladZapor;
    }

    public AkrKalkulaceNaklady(int akreditaceId, int akreditacePoradi, int akrKntId, int akrKnpId) {
        this.akrKalkulaceNakladyPK = new AkrKalkulaceNakladyPK(akreditaceId, akreditacePoradi, akrKntId, akrKnpId);
    }

    public AkrKalkulaceNakladyPK getAkrKalkulaceNakladyPK() {
        return akrKalkulaceNakladyPK;
    }

    public void setAkrKalkulaceNakladyPK(AkrKalkulaceNakladyPK akrKalkulaceNakladyPK) {
        this.akrKalkulaceNakladyPK = akrKalkulaceNakladyPK;
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

    public AkreditaceHlavni getAkreditaceHlavni() {
        return akreditaceHlavni;
    }

    public void setAkreditaceHlavni(AkreditaceHlavni akreditaceHlavni) {
        this.akreditaceHlavni = akreditaceHlavni;
    }

    public AkrKnp getAkrKnp() {
        return akrKnp;
    }

    public void setAkrKnp(AkrKnp akrKnp) {
        this.akrKnp = akrKnp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrKalkulaceNakladyPK != null ? akrKalkulaceNakladyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrKalkulaceNaklady)) {
            return false;
        }
        AkrKalkulaceNaklady other = (AkrKalkulaceNaklady) object;
        if ((this.akrKalkulaceNakladyPK == null && other.akrKalkulaceNakladyPK != null) || (this.akrKalkulaceNakladyPK != null && !this.akrKalkulaceNakladyPK.equals(other.akrKalkulaceNakladyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrKalkulaceNaklady[ akrKalkulaceNakladyPK=" + akrKalkulaceNakladyPK + " ]";
    }
    
}
