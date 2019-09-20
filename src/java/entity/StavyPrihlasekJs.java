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
@Table(name = "stavy_prihlasek_js", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StavyPrihlasekJs.findAll", query = "SELECT s FROM StavyPrihlasekJs s"),
    @NamedQuery(name = "StavyPrihlasekJs.findByStavPrihlId", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.stavPrihlId = :stavPrihlId"),
    @NamedQuery(name = "StavyPrihlasekJs.findByNazev", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.nazev = :nazev"),
    @NamedQuery(name = "StavyPrihlasekJs.findByDefUhrada", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.defUhrada = :defUhrada"),
    @NamedQuery(name = "StavyPrihlasekJs.findByFixUhradu", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.fixUhradu = :fixUhradu"),
    @NamedQuery(name = "StavyPrihlasekJs.findBySetDefUhradu", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.setDefUhradu = :setDefUhradu"),
    @NamedQuery(name = "StavyPrihlasekJs.findByDefSleva", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.defSleva = :defSleva"),
    @NamedQuery(name = "StavyPrihlasekJs.findByFixSlevu", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.fixSlevu = :fixSlevu"),
    @NamedQuery(name = "StavyPrihlasekJs.findBySetDefSlevu", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.setDefSlevu = :setDefSlevu"),
    @NamedQuery(name = "StavyPrihlasekJs.findByDefHotovost", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.defHotovost = :defHotovost"),
    @NamedQuery(name = "StavyPrihlasekJs.findByFixHotovost", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.fixHotovost = :fixHotovost"),
    @NamedQuery(name = "StavyPrihlasekJs.findBySetDefHotovost", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.setDefHotovost = :setDefHotovost"),
    @NamedQuery(name = "StavyPrihlasekJs.findByStav", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.stav = :stav"),
    @NamedQuery(name = "StavyPrihlasekJs.findByVazanoPrihlaska", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.vazanoPrihlaska = :vazanoPrihlaska"),
    @NamedQuery(name = "StavyPrihlasekJs.findBySetVychoziDp", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.setVychoziDp = :setVychoziDp"),
    @NamedQuery(name = "StavyPrihlasekJs.findBySetVychoziDf", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.setVychoziDf = :setVychoziDf"),
    @NamedQuery(name = "StavyPrihlasekJs.findByFakturaText", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.fakturaText = :fakturaText"),
    @NamedQuery(name = "StavyPrihlasekJs.findByPoznamky", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.poznamky = :poznamky"),
    @NamedQuery(name = "StavyPrihlasekJs.findByPoradiVyber", query = "SELECT s FROM StavyPrihlasekJs s WHERE s.poradiVyber = :poradiVyber")})
public class StavyPrihlasekJs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "stav_prihl_id")
    private Integer stavPrihlId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "def_uhrada")
    private Integer defUhrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fix_uhradu")
    private boolean fixUhradu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_def_uhradu")
    private boolean setDefUhradu;
    @Column(name = "def_sleva")
    private Integer defSleva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fix_slevu")
    private boolean fixSlevu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_def_slevu")
    private boolean setDefSlevu;
    @Column(name = "def_hotovost")
    private Integer defHotovost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fix_hotovost")
    private boolean fixHotovost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_def_hotovost")
    private boolean setDefHotovost;
    @Column(name = "stav")
    private Integer stav;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazano_prihlaska")
    private boolean vazanoPrihlaska;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_vychozi_dp")
    private boolean setVychoziDp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_vychozi_df")
    private boolean setVychoziDf;
    @Size(max = 20)
    @Column(name = "faktura_text")
    private String fakturaText;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;

    public StavyPrihlasekJs() {
    }

    public StavyPrihlasekJs(Integer stavPrihlId) {
        this.stavPrihlId = stavPrihlId;
    }

    public StavyPrihlasekJs(Integer stavPrihlId, boolean fixUhradu, boolean setDefUhradu, boolean fixSlevu, boolean setDefSlevu, boolean fixHotovost, boolean setDefHotovost, boolean vazanoPrihlaska, boolean setVychoziDp, boolean setVychoziDf) {
        this.stavPrihlId = stavPrihlId;
        this.fixUhradu = fixUhradu;
        this.setDefUhradu = setDefUhradu;
        this.fixSlevu = fixSlevu;
        this.setDefSlevu = setDefSlevu;
        this.fixHotovost = fixHotovost;
        this.setDefHotovost = setDefHotovost;
        this.vazanoPrihlaska = vazanoPrihlaska;
        this.setVychoziDp = setVychoziDp;
        this.setVychoziDf = setVychoziDf;
    }

    public Integer getStavPrihlId() {
        return stavPrihlId;
    }

    public void setStavPrihlId(Integer stavPrihlId) {
        this.stavPrihlId = stavPrihlId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Integer getDefUhrada() {
        return defUhrada;
    }

    public void setDefUhrada(Integer defUhrada) {
        this.defUhrada = defUhrada;
    }

    public boolean getFixUhradu() {
        return fixUhradu;
    }

    public void setFixUhradu(boolean fixUhradu) {
        this.fixUhradu = fixUhradu;
    }

    public boolean getSetDefUhradu() {
        return setDefUhradu;
    }

    public void setSetDefUhradu(boolean setDefUhradu) {
        this.setDefUhradu = setDefUhradu;
    }

    public Integer getDefSleva() {
        return defSleva;
    }

    public void setDefSleva(Integer defSleva) {
        this.defSleva = defSleva;
    }

    public boolean getFixSlevu() {
        return fixSlevu;
    }

    public void setFixSlevu(boolean fixSlevu) {
        this.fixSlevu = fixSlevu;
    }

    public boolean getSetDefSlevu() {
        return setDefSlevu;
    }

    public void setSetDefSlevu(boolean setDefSlevu) {
        this.setDefSlevu = setDefSlevu;
    }

    public Integer getDefHotovost() {
        return defHotovost;
    }

    public void setDefHotovost(Integer defHotovost) {
        this.defHotovost = defHotovost;
    }

    public boolean getFixHotovost() {
        return fixHotovost;
    }

    public void setFixHotovost(boolean fixHotovost) {
        this.fixHotovost = fixHotovost;
    }

    public boolean getSetDefHotovost() {
        return setDefHotovost;
    }

    public void setSetDefHotovost(boolean setDefHotovost) {
        this.setDefHotovost = setDefHotovost;
    }

    public Integer getStav() {
        return stav;
    }

    public void setStav(Integer stav) {
        this.stav = stav;
    }

    public boolean getVazanoPrihlaska() {
        return vazanoPrihlaska;
    }

    public void setVazanoPrihlaska(boolean vazanoPrihlaska) {
        this.vazanoPrihlaska = vazanoPrihlaska;
    }

    public boolean getSetVychoziDp() {
        return setVychoziDp;
    }

    public void setSetVychoziDp(boolean setVychoziDp) {
        this.setVychoziDp = setVychoziDp;
    }

    public boolean getSetVychoziDf() {
        return setVychoziDf;
    }

    public void setSetVychoziDf(boolean setVychoziDf) {
        this.setVychoziDf = setVychoziDf;
    }

    public String getFakturaText() {
        return fakturaText;
    }

    public void setFakturaText(String fakturaText) {
        this.fakturaText = fakturaText;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public Integer getPoradiVyber() {
        return poradiVyber;
    }

    public void setPoradiVyber(Integer poradiVyber) {
        this.poradiVyber = poradiVyber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavPrihlId != null ? stavPrihlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavyPrihlasekJs)) {
            return false;
        }
        StavyPrihlasekJs other = (StavyPrihlasekJs) object;
        if ((this.stavPrihlId == null && other.stavPrihlId != null) || (this.stavPrihlId != null && !this.stavPrihlId.equals(other.stavPrihlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StavyPrihlasekJs[ stavPrihlId=" + stavPrihlId + " ]";
    }
    
}
