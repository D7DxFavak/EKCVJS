/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "akce_rezim_zverejneni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceRezimZverejneni.findAll", query = "SELECT a FROM AkceRezimZverejneni a"),
    @NamedQuery(name = "AkceRezimZverejneni.findByAkceRezimZverejneniId", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.akceRezimZverejneniId = :akceRezimZverejneniId"),
    @NamedQuery(name = "AkceRezimZverejneni.findByAkceRezimZverejneniNazev", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.akceRezimZverejneniNazev = :akceRezimZverejneniNazev"),
    @NamedQuery(name = "AkceRezimZverejneni.findByAkceRezimZverejneniPopis", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.akceRezimZverejneniPopis = :akceRezimZverejneniPopis"),
    @NamedQuery(name = "AkceRezimZverejneni.findByAkceRezimZverejneniSestavaText", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.akceRezimZverejneniSestavaText = :akceRezimZverejneniSestavaText"),
    @NamedQuery(name = "AkceRezimZverejneni.findByAkceRezimZverejneniPoradiVyber", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.akceRezimZverejneniPoradiVyber = :akceRezimZverejneniPoradiVyber"),
    @NamedQuery(name = "AkceRezimZverejneni.findByAkceRezimZverejneniPoznamky", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.akceRezimZverejneniPoznamky = :akceRezimZverejneniPoznamky"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTNabidka", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tNabidka = :tNabidka"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTCislo", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tCislo = :tCislo"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTNazev", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tNazev = :tNazev"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTCharakteristiku", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tCharakteristiku = :tCharakteristiku"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTPopis", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tPopis = :tPopis"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTDoporuceno", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tDoporuceno = :tDoporuceno"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTOptimpocet", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tOptimpocet = :tOptimpocet"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTMistokonani", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tMistokonani = :tMistokonani"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTLektory", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tLektory = :tLektory"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTLektorytext", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tLektorytext = :tLektorytext"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTDodatkylektoru", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tDodatkylektoru = :tDodatkylektoru"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTObecnytermin", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tObecnytermin = :tObecnytermin"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTPocethodin", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tPocethodin = :tPocethodin"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTHodinykomentar", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tHodinykomentar = :tHodinykomentar"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTPoplatek", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tPoplatek = :tPoplatek"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTPoplatektext", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tPoplatektext = :tPoplatektext"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTSazbudph", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tSazbudph = :tSazbudph"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTNavaznosti", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tNavaznosti = :tNavaznosti"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTPokracovani", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tPokracovani = :tPokracovani"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTPoznamky", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tPoznamky = :tPoznamky"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTCisloprimoboru", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tCisloprimoboru = :tCisloprimoboru"),
    @NamedQuery(name = "AkceRezimZverejneni.findByTCisladalsichoboru", query = "SELECT a FROM AkceRezimZverejneni a WHERE a.tCisladalsichoboru = :tCisladalsichoboru")})
public class AkceRezimZverejneni implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_rezim_zverejneni_id")
    private Integer akceRezimZverejneniId;
    @Size(max = 250)
    @Column(name = "akce_rezim_zverejneni_nazev")
    private String akceRezimZverejneniNazev;
    @Size(max = 2147483647)
    @Column(name = "akce_rezim_zverejneni_popis")
    private String akceRezimZverejneniPopis;
    @Size(max = 2147483647)
    @Column(name = "akce_rezim_zverejneni_sestava_text")
    private String akceRezimZverejneniSestavaText;
    @Lob
    @Column(name = "akce_rezim_zverejneni_sestava_data")
    private byte[] akceRezimZverejneniSestavaData;
    @Column(name = "akce_rezim_zverejneni_poradi_vyber")
    private Integer akceRezimZverejneniPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "akce_rezim_zverejneni_poznamky")
    private String akceRezimZverejneniPoznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_nabidka")
    private boolean tNabidka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_cislo")
    private boolean tCislo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_nazev")
    private boolean tNazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_charakteristiku")
    private boolean tCharakteristiku;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_popis")
    private boolean tPopis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_doporuceno")
    private boolean tDoporuceno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_optimpocet")
    private boolean tOptimpocet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_mistokonani")
    private boolean tMistokonani;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_lektory")
    private boolean tLektory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_lektorytext")
    private boolean tLektorytext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_dodatkylektoru")
    private boolean tDodatkylektoru;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_obecnytermin")
    private boolean tObecnytermin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_pocethodin")
    private boolean tPocethodin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_hodinykomentar")
    private boolean tHodinykomentar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_poplatek")
    private boolean tPoplatek;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_poplatektext")
    private boolean tPoplatektext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_sazbudph")
    private boolean tSazbudph;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_navaznosti")
    private boolean tNavaznosti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_pokracovani")
    private boolean tPokracovani;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_poznamky")
    private boolean tPoznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_cisloprimoboru")
    private boolean tCisloprimoboru;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_cisladalsichoboru")
    private boolean tCisladalsichoboru;
    @OneToMany(mappedBy = "akceRezimZverejneniId")
    private Collection<AkceHlavni> akceHlavniCollection;

    public AkceRezimZverejneni() {
    }

    public AkceRezimZverejneni(Integer akceRezimZverejneniId) {
        this.akceRezimZverejneniId = akceRezimZverejneniId;
    }

    public AkceRezimZverejneni(Integer akceRezimZverejneniId, boolean tNabidka, boolean tCislo, boolean tNazev, boolean tCharakteristiku, boolean tPopis, boolean tDoporuceno, boolean tOptimpocet, boolean tMistokonani, boolean tLektory, boolean tLektorytext, boolean tDodatkylektoru, boolean tObecnytermin, boolean tPocethodin, boolean tHodinykomentar, boolean tPoplatek, boolean tPoplatektext, boolean tSazbudph, boolean tNavaznosti, boolean tPokracovani, boolean tPoznamky, boolean tCisloprimoboru, boolean tCisladalsichoboru) {
        this.akceRezimZverejneniId = akceRezimZverejneniId;
        this.tNabidka = tNabidka;
        this.tCislo = tCislo;
        this.tNazev = tNazev;
        this.tCharakteristiku = tCharakteristiku;
        this.tPopis = tPopis;
        this.tDoporuceno = tDoporuceno;
        this.tOptimpocet = tOptimpocet;
        this.tMistokonani = tMistokonani;
        this.tLektory = tLektory;
        this.tLektorytext = tLektorytext;
        this.tDodatkylektoru = tDodatkylektoru;
        this.tObecnytermin = tObecnytermin;
        this.tPocethodin = tPocethodin;
        this.tHodinykomentar = tHodinykomentar;
        this.tPoplatek = tPoplatek;
        this.tPoplatektext = tPoplatektext;
        this.tSazbudph = tSazbudph;
        this.tNavaznosti = tNavaznosti;
        this.tPokracovani = tPokracovani;
        this.tPoznamky = tPoznamky;
        this.tCisloprimoboru = tCisloprimoboru;
        this.tCisladalsichoboru = tCisladalsichoboru;
    }

    public Integer getAkceRezimZverejneniId() {
        return akceRezimZverejneniId;
    }

    public void setAkceRezimZverejneniId(Integer akceRezimZverejneniId) {
        this.akceRezimZverejneniId = akceRezimZverejneniId;
    }

    public String getAkceRezimZverejneniNazev() {
        return akceRezimZverejneniNazev;
    }

    public void setAkceRezimZverejneniNazev(String akceRezimZverejneniNazev) {
        this.akceRezimZverejneniNazev = akceRezimZverejneniNazev;
    }

    public String getAkceRezimZverejneniPopis() {
        return akceRezimZverejneniPopis;
    }

    public void setAkceRezimZverejneniPopis(String akceRezimZverejneniPopis) {
        this.akceRezimZverejneniPopis = akceRezimZverejneniPopis;
    }

    public String getAkceRezimZverejneniSestavaText() {
        return akceRezimZverejneniSestavaText;
    }

    public void setAkceRezimZverejneniSestavaText(String akceRezimZverejneniSestavaText) {
        this.akceRezimZverejneniSestavaText = akceRezimZverejneniSestavaText;
    }

    public byte[] getAkceRezimZverejneniSestavaData() {
        return akceRezimZverejneniSestavaData;
    }

    public void setAkceRezimZverejneniSestavaData(byte[] akceRezimZverejneniSestavaData) {
        this.akceRezimZverejneniSestavaData = akceRezimZverejneniSestavaData;
    }

    public Integer getAkceRezimZverejneniPoradiVyber() {
        return akceRezimZverejneniPoradiVyber;
    }

    public void setAkceRezimZverejneniPoradiVyber(Integer akceRezimZverejneniPoradiVyber) {
        this.akceRezimZverejneniPoradiVyber = akceRezimZverejneniPoradiVyber;
    }

    public String getAkceRezimZverejneniPoznamky() {
        return akceRezimZverejneniPoznamky;
    }

    public void setAkceRezimZverejneniPoznamky(String akceRezimZverejneniPoznamky) {
        this.akceRezimZverejneniPoznamky = akceRezimZverejneniPoznamky;
    }

    public boolean getTNabidka() {
        return tNabidka;
    }

    public void setTNabidka(boolean tNabidka) {
        this.tNabidka = tNabidka;
    }

    public boolean getTCislo() {
        return tCislo;
    }

    public void setTCislo(boolean tCislo) {
        this.tCislo = tCislo;
    }

    public boolean getTNazev() {
        return tNazev;
    }

    public void setTNazev(boolean tNazev) {
        this.tNazev = tNazev;
    }

    public boolean getTCharakteristiku() {
        return tCharakteristiku;
    }

    public void setTCharakteristiku(boolean tCharakteristiku) {
        this.tCharakteristiku = tCharakteristiku;
    }

    public boolean getTPopis() {
        return tPopis;
    }

    public void setTPopis(boolean tPopis) {
        this.tPopis = tPopis;
    }

    public boolean getTDoporuceno() {
        return tDoporuceno;
    }

    public void setTDoporuceno(boolean tDoporuceno) {
        this.tDoporuceno = tDoporuceno;
    }

    public boolean getTOptimpocet() {
        return tOptimpocet;
    }

    public void setTOptimpocet(boolean tOptimpocet) {
        this.tOptimpocet = tOptimpocet;
    }

    public boolean getTMistokonani() {
        return tMistokonani;
    }

    public void setTMistokonani(boolean tMistokonani) {
        this.tMistokonani = tMistokonani;
    }

    public boolean getTLektory() {
        return tLektory;
    }

    public void setTLektory(boolean tLektory) {
        this.tLektory = tLektory;
    }

    public boolean getTLektorytext() {
        return tLektorytext;
    }

    public void setTLektorytext(boolean tLektorytext) {
        this.tLektorytext = tLektorytext;
    }

    public boolean getTDodatkylektoru() {
        return tDodatkylektoru;
    }

    public void setTDodatkylektoru(boolean tDodatkylektoru) {
        this.tDodatkylektoru = tDodatkylektoru;
    }

    public boolean getTObecnytermin() {
        return tObecnytermin;
    }

    public void setTObecnytermin(boolean tObecnytermin) {
        this.tObecnytermin = tObecnytermin;
    }

    public boolean getTPocethodin() {
        return tPocethodin;
    }

    public void setTPocethodin(boolean tPocethodin) {
        this.tPocethodin = tPocethodin;
    }

    public boolean getTHodinykomentar() {
        return tHodinykomentar;
    }

    public void setTHodinykomentar(boolean tHodinykomentar) {
        this.tHodinykomentar = tHodinykomentar;
    }

    public boolean getTPoplatek() {
        return tPoplatek;
    }

    public void setTPoplatek(boolean tPoplatek) {
        this.tPoplatek = tPoplatek;
    }

    public boolean getTPoplatektext() {
        return tPoplatektext;
    }

    public void setTPoplatektext(boolean tPoplatektext) {
        this.tPoplatektext = tPoplatektext;
    }

    public boolean getTSazbudph() {
        return tSazbudph;
    }

    public void setTSazbudph(boolean tSazbudph) {
        this.tSazbudph = tSazbudph;
    }

    public boolean getTNavaznosti() {
        return tNavaznosti;
    }

    public void setTNavaznosti(boolean tNavaznosti) {
        this.tNavaznosti = tNavaznosti;
    }

    public boolean getTPokracovani() {
        return tPokracovani;
    }

    public void setTPokracovani(boolean tPokracovani) {
        this.tPokracovani = tPokracovani;
    }

    public boolean getTPoznamky() {
        return tPoznamky;
    }

    public void setTPoznamky(boolean tPoznamky) {
        this.tPoznamky = tPoznamky;
    }

    public boolean getTCisloprimoboru() {
        return tCisloprimoboru;
    }

    public void setTCisloprimoboru(boolean tCisloprimoboru) {
        this.tCisloprimoboru = tCisloprimoboru;
    }

    public boolean getTCisladalsichoboru() {
        return tCisladalsichoboru;
    }

    public void setTCisladalsichoboru(boolean tCisladalsichoboru) {
        this.tCisladalsichoboru = tCisladalsichoboru;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceRezimZverejneniId != null ? akceRezimZverejneniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceRezimZverejneni)) {
            return false;
        }
        AkceRezimZverejneni other = (AkceRezimZverejneni) object;
        if ((this.akceRezimZverejneniId == null && other.akceRezimZverejneniId != null) || (this.akceRezimZverejneniId != null && !this.akceRezimZverejneniId.equals(other.akceRezimZverejneniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceRezimZverejneni[ akceRezimZverejneniId=" + akceRezimZverejneniId + " ]";
    }
    
}
