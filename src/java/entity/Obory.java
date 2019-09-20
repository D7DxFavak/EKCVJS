/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "obory", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obory.findAll", query = "SELECT o FROM Obory o"),
    @NamedQuery(name = "Obory.findByOborId", query = "SELECT o FROM Obory o WHERE o.oborId = :oborId"),
    @NamedQuery(name = "Obory.findByNazev", query = "SELECT o FROM Obory o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "Obory.findByPopis", query = "SELECT o FROM Obory o WHERE o.popis = :popis"),
    @NamedQuery(name = "Obory.findByTextNabidka", query = "SELECT o FROM Obory o WHERE o.textNabidka = :textNabidka"),
    @NamedQuery(name = "Obory.findByKdyVlozeno", query = "SELECT o FROM Obory o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "Obory.findByKdyZmeneno", query = "SELECT o FROM Obory o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "Obory.findByKdoVlozil", query = "SELECT o FROM Obory o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "Obory.findByKdoZmenil", query = "SELECT o FROM Obory o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "Obory.findByPoradiVyber", query = "SELECT o FROM Obory o WHERE o.poradiVyber = :poradiVyber"),
    @NamedQuery(name = "Obory.findByPoznamky", query = "SELECT o FROM Obory o WHERE o.poznamky = :poznamky"),
    @NamedQuery(name = "Obory.findByOborCislo", query = "SELECT o FROM Obory o WHERE o.oborCislo = :oborCislo"),
    @NamedQuery(name = "Obory.findByOborRocnik", query = "SELECT o FROM Obory o WHERE o.oborRocnik = :oborRocnik"),
    @NamedQuery(name = "Obory.findByOborTyp", query = "SELECT o FROM Obory o WHERE o.oborTyp = :oborTyp"),
    @NamedQuery(name = "Obory.findByOborZamereni", query = "SELECT o FROM Obory o WHERE o.oborZamereni = :oborZamereni"),
    @NamedQuery(name = "Obory.findByOborPocetLet", query = "SELECT o FROM Obory o WHERE o.oborPocetLet = :oborPocetLet"),
    @NamedQuery(name = "Obory.findByOborAktivni", query = "SELECT o FROM Obory o WHERE o.oborAktivni = :oborAktivni")})
public class Obory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "obor_id")
    private Integer oborId;
    @Size(max = 100)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "popis")
    private String popis;
    @Size(max = 2147483647)
    @Column(name = "text_nabidka")
    private String textNabidka;
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
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Size(max = 4)
    @Column(name = "obor_cislo")
    private String oborCislo;
    @Column(name = "obor_rocnik")
    private Integer oborRocnik;
    @Size(max = 250)
    @Column(name = "obor_typ")
    private String oborTyp;
    @Size(max = 250)
    @Column(name = "obor_zamereni")
    private String oborZamereni;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "obor_pocet_let")
    private BigDecimal oborPocetLet;
    @Column(name = "obor_aktivni")
    private Boolean oborAktivni;
    @JoinColumn(name = "hlavni_garant", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby hlavniGarant;
    @JoinColumn(name = "obor_jazyk_id", referencedColumnName = "jazyky_id")
    @ManyToOne
    private Jazyky oborJazykId;
    @OneToMany(mappedBy = "primObor")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obory")
    private Collection<OboryMetodickySbor> oboryMetodickySborCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obory")
    private Collection<UzivateleAutorizace> uzivateleAutorizaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obory")
    private Collection<OboryVazbySkupiny> oboryVazbySkupinyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obory")
    private Collection<AkceDalsiObory> akceDalsiOboryCollection;
    @OneToMany(mappedBy = "obor")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;

    public Obory() {
    }

    public Obory(Integer oborId) {
        this.oborId = oborId;
    }

    public Integer getOborId() {
        return oborId;
    }

    public void setOborId(Integer oborId) {
        this.oborId = oborId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getTextNabidka() {
        return textNabidka;
    }

    public void setTextNabidka(String textNabidka) {
        this.textNabidka = textNabidka;
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

    public Integer getPoradiVyber() {
        return poradiVyber;
    }

    public void setPoradiVyber(Integer poradiVyber) {
        this.poradiVyber = poradiVyber;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public String getOborCislo() {
        return oborCislo;
    }

    public void setOborCislo(String oborCislo) {
        this.oborCislo = oborCislo;
    }

    public Integer getOborRocnik() {
        return oborRocnik;
    }

    public void setOborRocnik(Integer oborRocnik) {
        this.oborRocnik = oborRocnik;
    }

    public String getOborTyp() {
        return oborTyp;
    }

    public void setOborTyp(String oborTyp) {
        this.oborTyp = oborTyp;
    }

    public String getOborZamereni() {
        return oborZamereni;
    }

    public void setOborZamereni(String oborZamereni) {
        this.oborZamereni = oborZamereni;
    }

    public BigDecimal getOborPocetLet() {
        return oborPocetLet;
    }

    public void setOborPocetLet(BigDecimal oborPocetLet) {
        this.oborPocetLet = oborPocetLet;
    }

    public Boolean getOborAktivni() {
        return oborAktivni;
    }

    public void setOborAktivni(Boolean oborAktivni) {
        this.oborAktivni = oborAktivni;
    }

    public Osoby getHlavniGarant() {
        return hlavniGarant;
    }

    public void setHlavniGarant(Osoby hlavniGarant) {
        this.hlavniGarant = hlavniGarant;
    }

    public Jazyky getOborJazykId() {
        return oborJazykId;
    }

    public void setOborJazykId(Jazyky oborJazykId) {
        this.oborJazykId = oborJazykId;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @XmlTransient
    public Collection<OboryMetodickySbor> getOboryMetodickySborCollection() {
        return oboryMetodickySborCollection;
    }

    public void setOboryMetodickySborCollection(Collection<OboryMetodickySbor> oboryMetodickySborCollection) {
        this.oboryMetodickySborCollection = oboryMetodickySborCollection;
    }

    @XmlTransient
    public Collection<UzivateleAutorizace> getUzivateleAutorizaceCollection() {
        return uzivateleAutorizaceCollection;
    }

    public void setUzivateleAutorizaceCollection(Collection<UzivateleAutorizace> uzivateleAutorizaceCollection) {
        this.uzivateleAutorizaceCollection = uzivateleAutorizaceCollection;
    }

    @XmlTransient
    public Collection<OboryVazbySkupiny> getOboryVazbySkupinyCollection() {
        return oboryVazbySkupinyCollection;
    }

    public void setOboryVazbySkupinyCollection(Collection<OboryVazbySkupiny> oboryVazbySkupinyCollection) {
        this.oboryVazbySkupinyCollection = oboryVazbySkupinyCollection;
    }

    @XmlTransient
    public Collection<AkceDalsiObory> getAkceDalsiOboryCollection() {
        return akceDalsiOboryCollection;
    }

    public void setAkceDalsiOboryCollection(Collection<AkceDalsiObory> akceDalsiOboryCollection) {
        this.akceDalsiOboryCollection = akceDalsiOboryCollection;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oborId != null ? oborId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obory)) {
            return false;
        }
        Obory other = (Obory) object;
        if ((this.oborId == null && other.oborId != null) || (this.oborId != null && !this.oborId.equals(other.oborId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Obory[ oborId=" + oborId + " ]";
    }
    
}
