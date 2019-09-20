/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_rozpisy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceRozpisy.findAll", query = "SELECT a FROM AkceRozpisy a"),
    @NamedQuery(name = "AkceRozpisy.findByPolozka", query = "SELECT a FROM AkceRozpisy a WHERE a.polozka = :polozka"),
    @NamedQuery(name = "AkceRozpisy.findByPoradiTermin", query = "SELECT a FROM AkceRozpisy a WHERE a.poradiTermin = :poradiTermin"),
    @NamedQuery(name = "AkceRozpisy.findByPoradiKonani", query = "SELECT a FROM AkceRozpisy a WHERE a.poradiKonani = :poradiKonani"),
    @NamedQuery(name = "AkceRozpisy.findByDatum", query = "SELECT a FROM AkceRozpisy a WHERE a.datum = :datum"),
    @NamedQuery(name = "AkceRozpisy.findByCasOd", query = "SELECT a FROM AkceRozpisy a WHERE a.casOd = :casOd"),
    @NamedQuery(name = "AkceRozpisy.findByCasDo", query = "SELECT a FROM AkceRozpisy a WHERE a.casDo = :casDo"),
    @NamedQuery(name = "AkceRozpisy.findByMistoObecne", query = "SELECT a FROM AkceRozpisy a WHERE a.mistoObecne = :mistoObecne"),
    @NamedQuery(name = "AkceRozpisy.findByHlavniSidlo", query = "SELECT a FROM AkceRozpisy a WHERE a.hlavniSidlo = :hlavniSidlo"),
    @NamedQuery(name = "AkceRozpisy.findByKdyVlozeno", query = "SELECT a FROM AkceRozpisy a WHERE a.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "AkceRozpisy.findByKdyZmeneno", query = "SELECT a FROM AkceRozpisy a WHERE a.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "AkceRozpisy.findByKdoVlozil", query = "SELECT a FROM AkceRozpisy a WHERE a.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "AkceRozpisy.findByKdoZmenil", query = "SELECT a FROM AkceRozpisy a WHERE a.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "AkceRozpisy.findByPoznamky", query = "SELECT a FROM AkceRozpisy a WHERE a.poznamky = :poznamky")})
public class AkceRozpisy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "polozka")
    private Integer polozka;
    @Column(name = "poradi_termin")
    private Integer poradiTermin;
    @Column(name = "poradi_konani")
    private Integer poradiKonani;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "cas_od")
    @Temporal(TemporalType.TIME)
    private Date casOd;
    @Column(name = "cas_do")
    @Temporal(TemporalType.TIME)
    private Date casDo;
    @Size(max = 100)
    @Column(name = "misto_obecne")
    private String mistoObecne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hlavni_sidlo")
    private boolean hlavniSidlo;
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
    @JoinColumn(name = "ucebna", referencedColumnName = "ucebna_id")
    @ManyToOne
    private Ucebny ucebna;
    @JoinColumn(name = "organizace", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace organizace;
    @JoinColumn(name = "akce_id", referencedColumnName = "akce_id")
    @ManyToOne
    private AkceHlavni akceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akceRozpisy")
    private Collection<PrihlAkceRozpisy> prihlAkceRozpisyCollection;

    public AkceRozpisy() {
    }

    public AkceRozpisy(Integer polozka) {
        this.polozka = polozka;
    }

    public AkceRozpisy(Integer polozka, boolean hlavniSidlo) {
        this.polozka = polozka;
        this.hlavniSidlo = hlavniSidlo;
    }

    public Integer getPolozka() {
        return polozka;
    }

    public void setPolozka(Integer polozka) {
        this.polozka = polozka;
    }

    public Integer getPoradiTermin() {
        return poradiTermin;
    }

    public void setPoradiTermin(Integer poradiTermin) {
        this.poradiTermin = poradiTermin;
    }

    public Integer getPoradiKonani() {
        return poradiKonani;
    }

    public void setPoradiKonani(Integer poradiKonani) {
        this.poradiKonani = poradiKonani;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getCasOd() {
        return casOd;
    }

    public void setCasOd(Date casOd) {
        this.casOd = casOd;
    }

    public Date getCasDo() {
        return casDo;
    }

    public void setCasDo(Date casDo) {
        this.casDo = casDo;
    }

    public String getMistoObecne() {
        return mistoObecne;
    }

    public void setMistoObecne(String mistoObecne) {
        this.mistoObecne = mistoObecne;
    }

    public boolean getHlavniSidlo() {
        return hlavniSidlo;
    }

    public void setHlavniSidlo(boolean hlavniSidlo) {
        this.hlavniSidlo = hlavniSidlo;
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

    public Ucebny getUcebna() {
        return ucebna;
    }

    public void setUcebna(Ucebny ucebna) {
        this.ucebna = ucebna;
    }

    public Organizace getOrganizace() {
        return organizace;
    }

    public void setOrganizace(Organizace organizace) {
        this.organizace = organizace;
    }

    public AkceHlavni getAkceId() {
        return akceId;
    }

    public void setAkceId(AkceHlavni akceId) {
        this.akceId = akceId;
    }

    @XmlTransient
    public Collection<PrihlAkceRozpisy> getPrihlAkceRozpisyCollection() {
        return prihlAkceRozpisyCollection;
    }

    public void setPrihlAkceRozpisyCollection(Collection<PrihlAkceRozpisy> prihlAkceRozpisyCollection) {
        this.prihlAkceRozpisyCollection = prihlAkceRozpisyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polozka != null ? polozka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceRozpisy)) {
            return false;
        }
        AkceRozpisy other = (AkceRozpisy) object;
        if ((this.polozka == null && other.polozka != null) || (this.polozka != null && !this.polozka.equals(other.polozka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceRozpisy[ polozka=" + polozka + " ]";
    }
    
}
