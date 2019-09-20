/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "kniha_faktur", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnihaFaktur.findAll", query = "SELECT k FROM KnihaFaktur k"),
    @NamedQuery(name = "KnihaFaktur.findByCisloFaktury", query = "SELECT k FROM KnihaFaktur k WHERE k.cisloFaktury = :cisloFaktury"),
    @NamedQuery(name = "KnihaFaktur.findByFakturovano", query = "SELECT k FROM KnihaFaktur k WHERE k.fakturovano = :fakturovano"),
    @NamedQuery(name = "KnihaFaktur.findByDatumVystaveni", query = "SELECT k FROM KnihaFaktur k WHERE k.datumVystaveni = :datumVystaveni"),
    @NamedQuery(name = "KnihaFaktur.findByDatumSplatnosti", query = "SELECT k FROM KnihaFaktur k WHERE k.datumSplatnosti = :datumSplatnosti"),
    @NamedQuery(name = "KnihaFaktur.findByDatumZdanPlneni", query = "SELECT k FROM KnihaFaktur k WHERE k.datumZdanPlneni = :datumZdanPlneni"),
    @NamedQuery(name = "KnihaFaktur.findByDodatekText", query = "SELECT k FROM KnihaFaktur k WHERE k.dodatekText = :dodatekText"),
    @NamedQuery(name = "KnihaFaktur.findByStornovano", query = "SELECT k FROM KnihaFaktur k WHERE k.stornovano = :stornovano"),
    @NamedQuery(name = "KnihaFaktur.findByDatumStornovano", query = "SELECT k FROM KnihaFaktur k WHERE k.datumStornovano = :datumStornovano"),
    @NamedQuery(name = "KnihaFaktur.findByArchivaceText", query = "SELECT k FROM KnihaFaktur k WHERE k.archivaceText = :archivaceText"),
    @NamedQuery(name = "KnihaFaktur.findByKdyZaslano", query = "SELECT k FROM KnihaFaktur k WHERE k.kdyZaslano = :kdyZaslano"),
    @NamedQuery(name = "KnihaFaktur.findByKdyVlozeno", query = "SELECT k FROM KnihaFaktur k WHERE k.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "KnihaFaktur.findByKdyZmeneno", query = "SELECT k FROM KnihaFaktur k WHERE k.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "KnihaFaktur.findByKdoVlozil", query = "SELECT k FROM KnihaFaktur k WHERE k.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "KnihaFaktur.findByKdoZmenil", query = "SELECT k FROM KnihaFaktur k WHERE k.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "KnihaFaktur.findByPoznamky", query = "SELECT k FROM KnihaFaktur k WHERE k.poznamky = :poznamky")})
public class KnihaFaktur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cislo_faktury")
    private Integer cisloFaktury;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fakturovano")
    private BigDecimal fakturovano;
    @Column(name = "datum_vystaveni")
    @Temporal(TemporalType.DATE)
    private Date datumVystaveni;
    @Column(name = "datum_splatnosti")
    @Temporal(TemporalType.DATE)
    private Date datumSplatnosti;
    @Column(name = "datum_zdan_plneni")
    @Temporal(TemporalType.DATE)
    private Date datumZdanPlneni;
    @Size(max = 2147483647)
    @Column(name = "dodatek_text")
    private String dodatekText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stornovano")
    private boolean stornovano;
    @Column(name = "datum_stornovano")
    @Temporal(TemporalType.DATE)
    private Date datumStornovano;
    @Size(max = 2147483647)
    @Column(name = "archivace_text")
    private String archivaceText;
    @Column(name = "kdy_zaslano")
    @Temporal(TemporalType.DATE)
    private Date kdyZaslano;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "knihaFaktur")
    private Collection<PrihlFakturyRozpisy> prihlFakturyRozpisyCollection;
    @JoinColumn(name = "odberatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby odberatelOs;
    @JoinColumn(name = "objednavatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby objednavatelOs;
    @JoinColumn(name = "dodavatel_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby dodavatelOs;
    @JoinColumn(name = "platce_os", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby platceOs;
    @JoinColumn(name = "dodavatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace dodavatelOrg;
    @JoinColumn(name = "objednavatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace objednavatelOrg;
    @JoinColumn(name = "platce_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace platceOrg;
    @JoinColumn(name = "odberatel_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace odberatelOrg;
    @JoinColumn(name = "druhprihl", referencedColumnName = "druh_prihl_id")
    @ManyToOne
    private DruhyPrihlasek druhprihl;
    @JoinColumn(name = "druhfakt", referencedColumnName = "druh_faktury_id")
    @ManyToOne
    private DruhyFaktur druhfakt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "knihaFaktur")
    private Collection<PrihlJsFakturyRozpisy> prihlJsFakturyRozpisyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "knihaFaktur")
    private Collection<VazbaFakturyUlozisteData> vazbaFakturyUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "knihaFaktur")
    private Collection<KnihaUpominek> knihaUpominekCollection;
    @OneToMany(mappedBy = "cisloFaktury")
    private Collection<FakturyUhrady> fakturyUhradyCollection;
    @Transient
    private BigDecimal uhrazeno;
    @Transient
    private boolean existujePDF;

    public KnihaFaktur() {
    }

    public KnihaFaktur(Integer cisloFaktury) {
        this.cisloFaktury = cisloFaktury;
    }

    public KnihaFaktur(Integer cisloFaktury, boolean stornovano) {
        this.cisloFaktury = cisloFaktury;
        this.stornovano = stornovano;
    }

    public Integer getCisloFaktury() {
        return cisloFaktury;
    }

    public void setCisloFaktury(Integer cisloFaktury) {
        this.cisloFaktury = cisloFaktury;
    }

    public BigDecimal getFakturovano() {
        return fakturovano;
    }

    public void setFakturovano(BigDecimal fakturovano) {
        this.fakturovano = fakturovano;
    }

    public Date getDatumVystaveni() {
        return datumVystaveni;
    }

    public void setDatumVystaveni(Date datumVystaveni) {
        this.datumVystaveni = datumVystaveni;
    }

    public Date getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(Date datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    public Date getDatumZdanPlneni() {
        return datumZdanPlneni;
    }

    public void setDatumZdanPlneni(Date datumZdanPlneni) {
        this.datumZdanPlneni = datumZdanPlneni;
    }

    public String getDodatekText() {
        return dodatekText;
    }

    public void setDodatekText(String dodatekText) {
        this.dodatekText = dodatekText;
    }

    public boolean getStornovano() {
        return stornovano;
    }

    public void setStornovano(boolean stornovano) {
        this.stornovano = stornovano;
    }

    public Date getDatumStornovano() {
        return datumStornovano;
    }

    public void setDatumStornovano(Date datumStornovano) {
        this.datumStornovano = datumStornovano;
    }

    public String getArchivaceText() {
        return archivaceText;
    }

    public void setArchivaceText(String archivaceText) {
        this.archivaceText = archivaceText;
    }

    public Date getKdyZaslano() {
        return kdyZaslano;
    }

    public void setKdyZaslano(Date kdyZaslano) {
        this.kdyZaslano = kdyZaslano;
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

    @XmlTransient
    public Collection<PrihlFakturyRozpisy> getPrihlFakturyRozpisyCollection() {
        return prihlFakturyRozpisyCollection;
    }

    public void setPrihlFakturyRozpisyCollection(Collection<PrihlFakturyRozpisy> prihlFakturyRozpisyCollection) {
        this.prihlFakturyRozpisyCollection = prihlFakturyRozpisyCollection;
    }

    public Osoby getOdberatelOs() {
        return odberatelOs;
    }

    public void setOdberatelOs(Osoby odberatelOs) {
        this.odberatelOs = odberatelOs;
    }

    public Osoby getObjednavatelOs() {
        return objednavatelOs;
    }

    public void setObjednavatelOs(Osoby objednavatelOs) {
        this.objednavatelOs = objednavatelOs;
    }

    public Osoby getDodavatelOs() {
        return dodavatelOs;
    }

    public void setDodavatelOs(Osoby dodavatelOs) {
        this.dodavatelOs = dodavatelOs;
    }

    public Osoby getPlatceOs() {
        return platceOs;
    }

    public void setPlatceOs(Osoby platceOs) {
        this.platceOs = platceOs;
    }

    public Organizace getDodavatelOrg() {
        return dodavatelOrg;
    }

    public void setDodavatelOrg(Organizace dodavatelOrg) {
        this.dodavatelOrg = dodavatelOrg;
    }

    public Organizace getObjednavatelOrg() {
        return objednavatelOrg;
    }

    public void setObjednavatelOrg(Organizace objednavatelOrg) {
        this.objednavatelOrg = objednavatelOrg;
    }

    public Organizace getPlatceOrg() {
        return platceOrg;
    }

    public void setPlatceOrg(Organizace platceOrg) {
        this.platceOrg = platceOrg;
    }

    public Organizace getOdberatelOrg() {
        return odberatelOrg;
    }

    public void setOdberatelOrg(Organizace odberatelOrg) {
        this.odberatelOrg = odberatelOrg;
    }

    public DruhyPrihlasek getDruhprihl() {
        return druhprihl;
    }

    public void setDruhprihl(DruhyPrihlasek druhprihl) {
        this.druhprihl = druhprihl;
    }

    public DruhyFaktur getDruhfakt() {
        return druhfakt;
    }

    public void setDruhfakt(DruhyFaktur druhfakt) {
        this.druhfakt = druhfakt;
    }

    @XmlTransient
    public Collection<PrihlJsFakturyRozpisy> getPrihlJsFakturyRozpisyCollection() {
        return prihlJsFakturyRozpisyCollection;
    }

    public void setPrihlJsFakturyRozpisyCollection(Collection<PrihlJsFakturyRozpisy> prihlJsFakturyRozpisyCollection) {
        this.prihlJsFakturyRozpisyCollection = prihlJsFakturyRozpisyCollection;
    }

    @XmlTransient
    public Collection<VazbaFakturyUlozisteData> getVazbaFakturyUlozisteDataCollection() {
        return vazbaFakturyUlozisteDataCollection;
    }

    public void setVazbaFakturyUlozisteDataCollection(Collection<VazbaFakturyUlozisteData> vazbaFakturyUlozisteDataCollection) {
        this.vazbaFakturyUlozisteDataCollection = vazbaFakturyUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<KnihaUpominek> getKnihaUpominekCollection() {
        return knihaUpominekCollection;
    }

    public void setKnihaUpominekCollection(Collection<KnihaUpominek> knihaUpominekCollection) {
        this.knihaUpominekCollection = knihaUpominekCollection;
    }

    @XmlTransient
    public Collection<FakturyUhrady> getFakturyUhradyCollection() {
        return fakturyUhradyCollection;
    }

    public void setFakturyUhradyCollection(Collection<FakturyUhrady> fakturyUhradyCollection) {
        this.fakturyUhradyCollection = fakturyUhradyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cisloFaktury != null ? cisloFaktury.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnihaFaktur)) {
            return false;
        }
        KnihaFaktur other = (KnihaFaktur) object;
        if ((this.cisloFaktury == null && other.cisloFaktury != null) || (this.cisloFaktury != null && !this.cisloFaktury.equals(other.cisloFaktury))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KnihaFaktur[ cisloFaktury=" + cisloFaktury + " ]";
    }

    /**
     * @return the uhrazeno
     */
    public BigDecimal getUhrazeno() {
        return uhrazeno;
    }

    /**
     * @param uhrazeno the uhrazeno to set
     */
    public void setUhrazeno(BigDecimal uhrazeno) {
        this.uhrazeno = uhrazeno;
    }

    /**
     * @return the existujePDF
     */
    public boolean isExistujePDF() {
        return existujePDF;
    }

    /**
     * @param existujePDF the existujePDF to set
     */
    public void setExistujePDF(boolean existujePDF) {
        this.existujePDF = existujePDF;
    }
    
}
