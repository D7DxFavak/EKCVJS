/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "obdobi", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obdobi.findAll", query = "SELECT o FROM Obdobi o"),
    @NamedQuery(name = "Obdobi.findWeb", query = "SELECT o FROM Obdobi o WHERE o.obdobiNaWeb =:obdobiNaWeb ORDER BY o.poradiVyber"),
    @NamedQuery(name = "Obdobi.findByObdobiId", query = "SELECT o FROM Obdobi o WHERE o.obdobiId = :obdobiId"),
    @NamedQuery(name = "Obdobi.findByNazev", query = "SELECT o FROM Obdobi o WHERE o.nazev = :nazev"),
    @NamedQuery(name = "Obdobi.findByDatumTrvaniOd", query = "SELECT o FROM Obdobi o WHERE o.datumTrvaniOd = :datumTrvaniOd"),
    @NamedQuery(name = "Obdobi.findByDatumTrvaniDo", query = "SELECT o FROM Obdobi o WHERE o.datumTrvaniDo = :datumTrvaniDo"),
    @NamedQuery(name = "Obdobi.findByPoznamky", query = "SELECT o FROM Obdobi o WHERE o.poznamky = :poznamky"),
    @NamedQuery(name = "Obdobi.findByPoradiVyber", query = "SELECT o FROM Obdobi o WHERE o.poradiVyber = :poradiVyber"),
    @NamedQuery(name = "Obdobi.findByObdobiSkolniRok", query = "SELECT o FROM Obdobi o WHERE o.obdobiSkolniRok = :obdobiSkolniRok")})
public class Obdobi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "obdobi_id")
    private Integer obdobiId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "datum_trvani_od")
    @Temporal(TemporalType.DATE)
    private Date datumTrvaniOd;
    @Column(name = "datum_trvani_do")
    @Temporal(TemporalType.DATE)
    private Date datumTrvaniDo;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "poradi_vyber")
    private Integer poradiVyber;
    @Size(max = 50)
    @Column(name = "obdobi_skolni_rok")
    private String obdobiSkolniRok;
    @Column(name = "obdobi_na_web")
    private Boolean obdobiNaWeb;
    @OneToMany(mappedBy = "obdobi")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @OneToMany(mappedBy = "akceObdobi")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(mappedBy = "aktualniObdobi")
    private Collection<ParametryObecne> parametryObecneCollection;
    @OneToMany(mappedBy = "obdobi")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;

    public Obdobi() {
    }

    public Obdobi(Integer obdobiId) {
        this.obdobiId = obdobiId;
    }

    public Integer getObdobiId() {
        return obdobiId;
    }

    public void setObdobiId(Integer obdobiId) {
        this.obdobiId = obdobiId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Date getDatumTrvaniOd() {
        return datumTrvaniOd;
    }

    public void setDatumTrvaniOd(Date datumTrvaniOd) {
        this.datumTrvaniOd = datumTrvaniOd;
    }

    public Date getDatumTrvaniDo() {
        return datumTrvaniDo;
    }

    public void setDatumTrvaniDo(Date datumTrvaniDo) {
        this.datumTrvaniDo = datumTrvaniDo;
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

    public String getObdobiSkolniRok() {
        return obdobiSkolniRok;
    }

    public void setObdobiSkolniRok(String obdobiSkolniRok) {
        this.obdobiSkolniRok = obdobiSkolniRok;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection() {
        return prihlaskyRozpisyCollection;
    }

    public void setPrihlaskyRozpisyCollection(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection) {
        this.prihlaskyRozpisyCollection = prihlaskyRozpisyCollection;
    }

    @XmlTransient
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @XmlTransient
    public Collection<ParametryObecne> getParametryObecneCollection() {
        return parametryObecneCollection;
    }

    public void setParametryObecneCollection(Collection<ParametryObecne> parametryObecneCollection) {
        this.parametryObecneCollection = parametryObecneCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obdobiId != null ? obdobiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obdobi)) {
            return false;
        }
        Obdobi other = (Obdobi) object;
        if ((this.obdobiId == null && other.obdobiId != null) || (this.obdobiId != null && !this.obdobiId.equals(other.obdobiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Obdobi[ obdobiId=" + obdobiId + " ]";
    }

    /**
     * @return the obdobiNaWeb
     */
    public Boolean getObdobiNaWeb() {
        return obdobiNaWeb;
    }

    /**
     * @param obdobiNaWeb the obdobiNaWeb to set
     */
    public void setObdobiNaWeb(Boolean obdobiNaWeb) {
        this.obdobiNaWeb = obdobiNaWeb;
    }
}
