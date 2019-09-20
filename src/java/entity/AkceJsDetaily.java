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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akce_js_detaily", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceJsDetaily.findAll", query = "SELECT a FROM AkceJsDetaily a"),
    @NamedQuery(name = "AkceJsDetaily.findByAkceJsDetailyId", query = "SELECT a FROM AkceJsDetaily a WHERE a.akceJsDetailyId = :akceJsDetailyId"),
    @NamedQuery(name = "AkceJsDetaily.findByAkceJsDetailyHodinTydne", query = "SELECT a FROM AkceJsDetaily a WHERE a.akceJsDetailyHodinTydne = :akceJsDetailyHodinTydne"),
    @NamedQuery(name = "AkceJsDetaily.findByAkceJsDetailyMistoKonani", query = "SELECT a FROM AkceJsDetaily a WHERE a.akceJsDetailyMistoKonani = :akceJsDetailyMistoKonani"),
    @NamedQuery(name = "AkceJsDetaily.findByAkceJsDetailyPoznamky", query = "SELECT a FROM AkceJsDetaily a WHERE a.akceJsDetailyPoznamky = :akceJsDetailyPoznamky")})
public class AkceJsDetaily implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_js_detaily_id")
    private Integer akceJsDetailyId;
    @Column(name = "akce_js_detaily_hodin_tydne")
    private Integer akceJsDetailyHodinTydne;
    @Size(max = 250)
    @Column(name = "akce_js_detaily_misto_konani")
    private String akceJsDetailyMistoKonani;
    @Size(max = 2147483647)
    @Column(name = "akce_js_detaily_poznamky")
    private String akceJsDetailyPoznamky;
    @JoinColumn(name = "akce_js_detaily_delka_kurzu", referencedColumnName = "cisla_slovy_id")
    @ManyToOne
    private CislaSlovy akceJsDetailyDelkaKurzu;
    @JoinColumn(name = "akce_js_detaily_rocnik", referencedColumnName = "cisla_slovy_id")
    @ManyToOne
    private CislaSlovy akceJsDetailyRocnik;
    @JoinColumn(name = "akce_js_detaily_zamereni_kurzu", referencedColumnName = "akce_js_zamereni_kurzu_id")
    @ManyToOne
    private AkceJsZamereniKurzu akceJsDetailyZamereniKurzu;
    @JoinColumn(name = "akce_js_detaily_typ_kurzu", referencedColumnName = "akce_js_typ_kurzu_id")
    @ManyToOne
    private AkceJsTypKurzu akceJsDetailyTypKurzu;
    @JoinColumn(name = "akce_js_detaily_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AkceHlavni akceHlavni;

    public AkceJsDetaily() {
    }

    public AkceJsDetaily(Integer akceJsDetailyId) {
        this.akceJsDetailyId = akceJsDetailyId;
    }

    public Integer getAkceJsDetailyId() {
        return akceJsDetailyId;
    }

    public void setAkceJsDetailyId(Integer akceJsDetailyId) {
        this.akceJsDetailyId = akceJsDetailyId;
    }

    public Integer getAkceJsDetailyHodinTydne() {
        return akceJsDetailyHodinTydne;
    }

    public void setAkceJsDetailyHodinTydne(Integer akceJsDetailyHodinTydne) {
        this.akceJsDetailyHodinTydne = akceJsDetailyHodinTydne;
    }

    public String getAkceJsDetailyMistoKonani() {
        return akceJsDetailyMistoKonani;
    }

    public void setAkceJsDetailyMistoKonani(String akceJsDetailyMistoKonani) {
        this.akceJsDetailyMistoKonani = akceJsDetailyMistoKonani;
    }

    public String getAkceJsDetailyPoznamky() {
        return akceJsDetailyPoznamky;
    }

    public void setAkceJsDetailyPoznamky(String akceJsDetailyPoznamky) {
        this.akceJsDetailyPoznamky = akceJsDetailyPoznamky;
    }

    public CislaSlovy getAkceJsDetailyDelkaKurzu() {
        return akceJsDetailyDelkaKurzu;
    }

    public void setAkceJsDetailyDelkaKurzu(CislaSlovy akceJsDetailyDelkaKurzu) {
        this.akceJsDetailyDelkaKurzu = akceJsDetailyDelkaKurzu;
    }

    public CislaSlovy getAkceJsDetailyRocnik() {
        return akceJsDetailyRocnik;
    }

    public void setAkceJsDetailyRocnik(CislaSlovy akceJsDetailyRocnik) {
        this.akceJsDetailyRocnik = akceJsDetailyRocnik;
    }

    public AkceJsZamereniKurzu getAkceJsDetailyZamereniKurzu() {
        return akceJsDetailyZamereniKurzu;
    }

    public void setAkceJsDetailyZamereniKurzu(AkceJsZamereniKurzu akceJsDetailyZamereniKurzu) {
        this.akceJsDetailyZamereniKurzu = akceJsDetailyZamereniKurzu;
    }

    public AkceJsTypKurzu getAkceJsDetailyTypKurzu() {
        return akceJsDetailyTypKurzu;
    }

    public void setAkceJsDetailyTypKurzu(AkceJsTypKurzu akceJsDetailyTypKurzu) {
        this.akceJsDetailyTypKurzu = akceJsDetailyTypKurzu;
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
        hash += (akceJsDetailyId != null ? akceJsDetailyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceJsDetaily)) {
            return false;
        }
        AkceJsDetaily other = (AkceJsDetaily) object;
        if ((this.akceJsDetailyId == null && other.akceJsDetailyId != null) || (this.akceJsDetailyId != null && !this.akceJsDetailyId.equals(other.akceJsDetailyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceJsDetaily[ akceJsDetailyId=" + akceJsDetailyId + " ]";
    }
    
}
