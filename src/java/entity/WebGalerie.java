/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Favak
 */
@Entity
@Table(name = "web_galerie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebGalerie.findAll", query = "SELECT w FROM WebGalerie w  ORDER BY w.webGaleriePoradiVyber"),
    @NamedQuery(name = "WebGalerie.findByWebGalerieId", query = "SELECT w FROM WebGalerie w WHERE w.webGalerieId = :webGalerieId"),
    @NamedQuery(name = "WebGalerie.findByWebGalerieNazev", query = "SELECT w FROM WebGalerie w WHERE w.webGalerieNazev = :webGalerieNazev"),
    @NamedQuery(name = "WebGalerie.findByWebGaleriePopis", query = "SELECT w FROM WebGalerie w WHERE w.webGaleriePopis = :webGaleriePopis"),
    @NamedQuery(name = "WebGalerie.findByWebGaleriePoznamky", query = "SELECT w FROM WebGalerie w WHERE w.webGaleriePoznamky = :webGaleriePoznamky"),
    @NamedQuery(name = "WebGalerie.findByWebGalerieKategorie", query = "SELECT w FROM WebGalerie w WHERE w.webGalerieKategorie = :webGalerieKategorie ORDER BY w.webGaleriePoradiVyber"),
    @NamedQuery(name = "WebGalerie.findByWebGalerieDatumVlozeni", query = "SELECT w FROM WebGalerie w WHERE w.webGalerieDatumVlozeni = :webGalerieDatumVlozeni"),
    @NamedQuery(name = "WebGalerie.findByWebGaleriePoradiVyber", query = "SELECT w FROM WebGalerie w WHERE w.webGaleriePoradiVyber = :webGaleriePoradiVyber")})
public class WebGalerie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_galerie_id")
    private Integer webGalerieId;
    @Size(max = 250)
    @Column(name = "web_galerie_nazev")
    private String webGalerieNazev;
    @Size(max = 2147483647)
    @Column(name = "web_galerie_popis")
    private String webGaleriePopis;
    @Size(max = 2147483647)
    @Column(name = "web_galerie_poznamky")
    private String webGaleriePoznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_galerie_datum_vlozeni")
    @Temporal(TemporalType.DATE)
    private Date webGalerieDatumVlozeni;
    @Column(name = "web_galerie_poradi_vyber")
    private Integer webGaleriePoradiVyber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webGalerie")
    private Collection<VazbaGalerieUloziste> vazbaGalerieUlozisteCollection;
    @JoinColumn(name = "web_galerie_kategorie", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webGalerieKategorie;
    @JoinColumn(name = "web_galerie_vlozil", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby webGalerieVlozil;

    public WebGalerie() {
    }

    public WebGalerie(Integer webGalerieId) {
        this.webGalerieId = webGalerieId;
    }

    public WebGalerie(Integer webGalerieId, Date webGalerieDatumVlozeni) {
        this.webGalerieId = webGalerieId;
        this.webGalerieDatumVlozeni = webGalerieDatumVlozeni;
    }

    public Integer getWebGalerieId() {
        return webGalerieId;
    }

    public void setWebGalerieId(Integer webGalerieId) {
        this.webGalerieId = webGalerieId;
    }

    public String getWebGalerieNazev() {
        return webGalerieNazev;
    }

    public void setWebGalerieNazev(String webGalerieNazev) {
        this.webGalerieNazev = webGalerieNazev;
    }

    public String getWebGaleriePopis() {
        return webGaleriePopis;
    }

    public void setWebGaleriePopis(String webGaleriePopis) {
        this.webGaleriePopis = webGaleriePopis;
    }

    public String getWebGaleriePoznamky() {
        return webGaleriePoznamky;
    }

    public void setWebGaleriePoznamky(String webGaleriePoznamky) {
        this.webGaleriePoznamky = webGaleriePoznamky;
    }

    public Date getWebGalerieDatumVlozeni() {
        return webGalerieDatumVlozeni;
    }

    public void setWebGalerieDatumVlozeni(Date webGalerieDatumVlozeni) {
        this.webGalerieDatumVlozeni = webGalerieDatumVlozeni;
    }

    public Integer getWebGaleriePoradiVyber() {
        return webGaleriePoradiVyber;
    }

    public void setWebGaleriePoradiVyber(Integer webGaleriePoradiVyber) {
        this.webGaleriePoradiVyber = webGaleriePoradiVyber;
    }

    @XmlTransient
    public Collection<VazbaGalerieUloziste> getVazbaGalerieUlozisteCollection() {
        return vazbaGalerieUlozisteCollection;
    }

    public void setVazbaGalerieUlozisteCollection(Collection<VazbaGalerieUloziste> vazbaGalerieUlozisteCollection) {
        this.vazbaGalerieUlozisteCollection = vazbaGalerieUlozisteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webGalerieId != null ? webGalerieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebGalerie)) {
            return false;
        }
        WebGalerie other = (WebGalerie) object;
        if ((this.webGalerieId == null && other.webGalerieId != null) || (this.webGalerieId != null && !this.webGalerieId.equals(other.webGalerieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebGalerie[ webGalerieId=" + webGalerieId + " ]";
    }

    /**
     * @return the webGalerieKategorie
     */
    public WebKategorieZakladni getWebGalerieKategorie() {
        return webGalerieKategorie;
    }

    /**
     * @param webGalerieKategorie the webGalerieKategorie to set
     */
    public void setWebGalerieKategorie(WebKategorieZakladni webGalerieKategorie) {
        this.webGalerieKategorie = webGalerieKategorie;
    }

    /**
     * @return the webGalerieVlozil
     */
    public Osoby getWebGalerieVlozil() {
        return webGalerieVlozil;
    }

    /**
     * @param webGalerieVlozil the webGalerieVlozil to set
     */
    public void setWebGalerieVlozil(Osoby webGalerieVlozil) {
        this.webGalerieVlozil = webGalerieVlozil;
    }
}
