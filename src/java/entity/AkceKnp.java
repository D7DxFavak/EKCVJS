/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_knp", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceKnp.findAll", query = "SELECT a FROM AkceKnp a"),
    @NamedQuery(name = "AkceKnp.findByAkceKntId", query = "SELECT a FROM AkceKnp a WHERE a.akceKnpPK.akceKntId = :akceKntId"),
    @NamedQuery(name = "AkceKnp.findByAkceKnpId", query = "SELECT a FROM AkceKnp a WHERE a.akceKnpPK.akceKnpId = :akceKnpId"),
    @NamedQuery(name = "AkceKnp.findByNazev", query = "SELECT a FROM AkceKnp a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceKnp.findByDefPolCena", query = "SELECT a FROM AkceKnp a WHERE a.defPolCena = :defPolCena"),
    @NamedQuery(name = "AkceKnp.findByTZpusobPlatby", query = "SELECT a FROM AkceKnp a WHERE a.tZpusobPlatby = :tZpusobPlatby"),
    @NamedQuery(name = "AkceKnp.findByTStrucVycet", query = "SELECT a FROM AkceKnp a WHERE a.tStrucVycet = :tStrucVycet"),
    @NamedQuery(name = "AkceKnp.findByTCenaJednotka", query = "SELECT a FROM AkceKnp a WHERE a.tCenaJednotka = :tCenaJednotka"),
    @NamedQuery(name = "AkceKnp.findByTPocetJednotek", query = "SELECT a FROM AkceKnp a WHERE a.tPocetJednotek = :tPocetJednotek"),
    @NamedQuery(name = "AkceKnp.findByPoznamky", query = "SELECT a FROM AkceKnp a WHERE a.poznamky = :poznamky")})
public class AkceKnp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AkceKnpPK akceKnpPK;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "def_pol_cena")
    private BigDecimal defPolCena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_zpusob_platby")
    private boolean tZpusobPlatby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_struc_vycet")
    private boolean tStrucVycet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_cena_jednotka")
    private boolean tCenaJednotka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_pocet_jednotek")
    private boolean tPocetJednotek;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "def_zpusob_platby", referencedColumnName = "forma_platby_id")
    @ManyToOne
    private FormyPlateb defZpusobPlatby;
    @JoinColumn(name = "akce_knt_id", referencedColumnName = "akce_knt_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceKnt akceKnt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceKnp")
    private Collection<AkceKalkulaceNaklady> akceKalkulaceNakladyCollection;

    public AkceKnp() {
    }

    public AkceKnp(AkceKnpPK akceKnpPK) {
        this.akceKnpPK = akceKnpPK;
    }

    public AkceKnp(AkceKnpPK akceKnpPK, boolean tZpusobPlatby, boolean tStrucVycet, boolean tCenaJednotka, boolean tPocetJednotek) {
        this.akceKnpPK = akceKnpPK;
        this.tZpusobPlatby = tZpusobPlatby;
        this.tStrucVycet = tStrucVycet;
        this.tCenaJednotka = tCenaJednotka;
        this.tPocetJednotek = tPocetJednotek;
    }

    public AkceKnp(int akceKntId, int akceKnpId) {
        this.akceKnpPK = new AkceKnpPK(akceKntId, akceKnpId);
    }

    public AkceKnpPK getAkceKnpPK() {
        return akceKnpPK;
    }

    public void setAkceKnpPK(AkceKnpPK akceKnpPK) {
        this.akceKnpPK = akceKnpPK;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public BigDecimal getDefPolCena() {
        return defPolCena;
    }

    public void setDefPolCena(BigDecimal defPolCena) {
        this.defPolCena = defPolCena;
    }

    public boolean getTZpusobPlatby() {
        return tZpusobPlatby;
    }

    public void setTZpusobPlatby(boolean tZpusobPlatby) {
        this.tZpusobPlatby = tZpusobPlatby;
    }

    public boolean getTStrucVycet() {
        return tStrucVycet;
    }

    public void setTStrucVycet(boolean tStrucVycet) {
        this.tStrucVycet = tStrucVycet;
    }

    public boolean getTCenaJednotka() {
        return tCenaJednotka;
    }

    public void setTCenaJednotka(boolean tCenaJednotka) {
        this.tCenaJednotka = tCenaJednotka;
    }

    public boolean getTPocetJednotek() {
        return tPocetJednotek;
    }

    public void setTPocetJednotek(boolean tPocetJednotek) {
        this.tPocetJednotek = tPocetJednotek;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public FormyPlateb getDefZpusobPlatby() {
        return defZpusobPlatby;
    }

    public void setDefZpusobPlatby(FormyPlateb defZpusobPlatby) {
        this.defZpusobPlatby = defZpusobPlatby;
    }

    public AkceKnt getAkceKnt() {
        return akceKnt;
    }

    public void setAkceKnt(AkceKnt akceKnt) {
        this.akceKnt = akceKnt;
    }

    @XmlTransient
    public Collection<AkceKalkulaceNaklady> getAkceKalkulaceNakladyCollection() {
        return akceKalkulaceNakladyCollection;
    }

    public void setAkceKalkulaceNakladyCollection(Collection<AkceKalkulaceNaklady> akceKalkulaceNakladyCollection) {
        this.akceKalkulaceNakladyCollection = akceKalkulaceNakladyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceKnpPK != null ? akceKnpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceKnp)) {
            return false;
        }
        AkceKnp other = (AkceKnp) object;
        if ((this.akceKnpPK == null && other.akceKnpPK != null) || (this.akceKnpPK != null && !this.akceKnpPK.equals(other.akceKnpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceKnp[ akceKnpPK=" + akceKnpPK + " ]";
    }
    
}
