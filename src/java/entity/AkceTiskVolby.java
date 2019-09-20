/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_tisk_volby", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceTiskVolby.findAll", query = "SELECT a FROM AkceTiskVolby a"),
    @NamedQuery(name = "AkceTiskVolby.findByTiskVolbaId", query = "SELECT a FROM AkceTiskVolby a WHERE a.tiskVolbaId = :tiskVolbaId"),
    @NamedQuery(name = "AkceTiskVolby.findByNazev", query = "SELECT a FROM AkceTiskVolby a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceTiskVolby.findByTNabidka", query = "SELECT a FROM AkceTiskVolby a WHERE a.tNabidka = :tNabidka"),
    @NamedQuery(name = "AkceTiskVolby.findByTCislo", query = "SELECT a FROM AkceTiskVolby a WHERE a.tCislo = :tCislo"),
    @NamedQuery(name = "AkceTiskVolby.findByTNazev", query = "SELECT a FROM AkceTiskVolby a WHERE a.tNazev = :tNazev"),
    @NamedQuery(name = "AkceTiskVolby.findByTCharakteristiku", query = "SELECT a FROM AkceTiskVolby a WHERE a.tCharakteristiku = :tCharakteristiku"),
    @NamedQuery(name = "AkceTiskVolby.findByTPopis", query = "SELECT a FROM AkceTiskVolby a WHERE a.tPopis = :tPopis"),
    @NamedQuery(name = "AkceTiskVolby.findByTDoporuceno", query = "SELECT a FROM AkceTiskVolby a WHERE a.tDoporuceno = :tDoporuceno"),
    @NamedQuery(name = "AkceTiskVolby.findByTOptimpocet", query = "SELECT a FROM AkceTiskVolby a WHERE a.tOptimpocet = :tOptimpocet"),
    @NamedQuery(name = "AkceTiskVolby.findByTMistokonani", query = "SELECT a FROM AkceTiskVolby a WHERE a.tMistokonani = :tMistokonani"),
    @NamedQuery(name = "AkceTiskVolby.findByTLektory", query = "SELECT a FROM AkceTiskVolby a WHERE a.tLektory = :tLektory"),
    @NamedQuery(name = "AkceTiskVolby.findByTLektorytext", query = "SELECT a FROM AkceTiskVolby a WHERE a.tLektorytext = :tLektorytext"),
    @NamedQuery(name = "AkceTiskVolby.findByTDodatkylektoru", query = "SELECT a FROM AkceTiskVolby a WHERE a.tDodatkylektoru = :tDodatkylektoru"),
    @NamedQuery(name = "AkceTiskVolby.findByTObecnytermin", query = "SELECT a FROM AkceTiskVolby a WHERE a.tObecnytermin = :tObecnytermin"),
    @NamedQuery(name = "AkceTiskVolby.findByTPocethodin", query = "SELECT a FROM AkceTiskVolby a WHERE a.tPocethodin = :tPocethodin"),
    @NamedQuery(name = "AkceTiskVolby.findByTHodinykomentar", query = "SELECT a FROM AkceTiskVolby a WHERE a.tHodinykomentar = :tHodinykomentar"),
    @NamedQuery(name = "AkceTiskVolby.findByTPoplatek", query = "SELECT a FROM AkceTiskVolby a WHERE a.tPoplatek = :tPoplatek"),
    @NamedQuery(name = "AkceTiskVolby.findByTPoplatektext", query = "SELECT a FROM AkceTiskVolby a WHERE a.tPoplatektext = :tPoplatektext"),
    @NamedQuery(name = "AkceTiskVolby.findByTSazbudph", query = "SELECT a FROM AkceTiskVolby a WHERE a.tSazbudph = :tSazbudph"),
    @NamedQuery(name = "AkceTiskVolby.findByTNavaznosti", query = "SELECT a FROM AkceTiskVolby a WHERE a.tNavaznosti = :tNavaznosti"),
    @NamedQuery(name = "AkceTiskVolby.findByTPokracovani", query = "SELECT a FROM AkceTiskVolby a WHERE a.tPokracovani = :tPokracovani"),
    @NamedQuery(name = "AkceTiskVolby.findByTPoznamky", query = "SELECT a FROM AkceTiskVolby a WHERE a.tPoznamky = :tPoznamky"),
    @NamedQuery(name = "AkceTiskVolby.findByTCisloprimoboru", query = "SELECT a FROM AkceTiskVolby a WHERE a.tCisloprimoboru = :tCisloprimoboru"),
    @NamedQuery(name = "AkceTiskVolby.findByTCisladalsichoboru", query = "SELECT a FROM AkceTiskVolby a WHERE a.tCisladalsichoboru = :tCisladalsichoboru"),
    @NamedQuery(name = "AkceTiskVolby.findByPoznamky", query = "SELECT a FROM AkceTiskVolby a WHERE a.poznamky = :poznamky")})
public class AkceTiskVolby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tisk_volba_id")
    private Integer tiskVolbaId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
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
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;

    public AkceTiskVolby() {
    }

    public AkceTiskVolby(Integer tiskVolbaId) {
        this.tiskVolbaId = tiskVolbaId;
    }

    public AkceTiskVolby(Integer tiskVolbaId, boolean tNabidka, boolean tCislo, boolean tNazev, boolean tCharakteristiku, boolean tPopis, boolean tDoporuceno, boolean tOptimpocet, boolean tMistokonani, boolean tLektory, boolean tLektorytext, boolean tDodatkylektoru, boolean tObecnytermin, boolean tPocethodin, boolean tHodinykomentar, boolean tPoplatek, boolean tPoplatektext, boolean tSazbudph, boolean tNavaznosti, boolean tPokracovani, boolean tPoznamky, boolean tCisloprimoboru, boolean tCisladalsichoboru) {
        this.tiskVolbaId = tiskVolbaId;
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

    public Integer getTiskVolbaId() {
        return tiskVolbaId;
    }

    public void setTiskVolbaId(Integer tiskVolbaId) {
        this.tiskVolbaId = tiskVolbaId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
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

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiskVolbaId != null ? tiskVolbaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceTiskVolby)) {
            return false;
        }
        AkceTiskVolby other = (AkceTiskVolby) object;
        if ((this.tiskVolbaId == null && other.tiskVolbaId != null) || (this.tiskVolbaId != null && !this.tiskVolbaId.equals(other.tiskVolbaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceTiskVolby[ tiskVolbaId=" + tiskVolbaId + " ]";
    }
    
}
