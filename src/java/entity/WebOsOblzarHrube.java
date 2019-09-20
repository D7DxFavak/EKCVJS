/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_os_oblzar_hrube", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebOsOblzarHrube.findAll", query = "SELECT w FROM WebOsOblzarHrube w ORDER BY w.webPoradiVyber"),
    @NamedQuery(name = "WebOsOblzarHrube.findByWebOblzarHrubeId", query = "SELECT w FROM WebOsOblzarHrube w WHERE w.webOblzarHrubeId = :webOblzarHrubeId"),
    @NamedQuery(name = "WebOsOblzarHrube.findByWebOblzarKategorie", query = "SELECT w FROM WebOsOblzarHrube w WHERE w.webOblzarHrubeKategorie = :webOblzarHrubeKategorie ORDER BY w.webPoradiVyber"),
    @NamedQuery(name = "WebOsOblzarHrube.findByWebNazev", query = "SELECT w FROM WebOsOblzarHrube w WHERE w.webNazev = :webNazev"),
    @NamedQuery(name = "WebOsOblzarHrube.findByWebPoznamky", query = "SELECT w FROM WebOsOblzarHrube w WHERE w.webPoznamky = :webPoznamky"),
    @NamedQuery(name = "WebOsOblzarHrube.findByWebNazevDe", query = "SELECT w FROM WebOsOblzarHrube w WHERE w.webNazevDe = :webNazevDe"),
    @NamedQuery(name = "WebOsOblzarHrube.findByWebNazevEn", query = "SELECT w FROM WebOsOblzarHrube w WHERE w.webNazevEn = :webNazevEn")})
public class WebOsOblzarHrube implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_oblzar_hrube_id")
    private Integer webOblzarHrubeId;
    @Size(max = 200)
    @Column(name = "web_nazev")
    private String webNazev;
    @Size(max = 2147483647)
    @Column(name = "web_poznamky")
    private String webPoznamky;
    @Size(max = 200)
    @Column(name = "web_nazev_de")
    private String webNazevDe;
    @Size(max = 200)
    @Column(name = "web_nazev_en")
    private String webNazevEn;
    @Column(name = "web_poradi_vyber")
    private Integer webPoradiVyber;
    @JoinColumn(name = "web_oblzar_hrube_kategorie", referencedColumnName = "web_kategorie_zakladni_id")
    @ManyToOne(optional = false)
    private WebKategorieZakladni webOblzarHrubeKategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webOblzarHrubeId")
    private Collection<WebOsOblzarJemne> webOsOblzarJemneCollection;

    public WebOsOblzarHrube() {
    }

    public WebOsOblzarHrube(Integer webOblzarHrubeId) {
        this.webOblzarHrubeId = webOblzarHrubeId;
    }

    public Integer getWebOblzarHrubeId() {
        return webOblzarHrubeId;
    }

    public void setWebOblzarHrubeId(Integer webOblzarHrubeId) {
        this.webOblzarHrubeId = webOblzarHrubeId;
    }

    public String getWebNazev() {
        return webNazev;
    }

    public void setWebNazev(String webNazev) {
        this.webNazev = webNazev;
    }

    public String getWebPoznamky() {
        return webPoznamky;
    }

    public void setWebPoznamky(String webPoznamky) {
        this.webPoznamky = webPoznamky;
    }

    public String getWebNazevDe() {
        return webNazevDe;
    }

    public void setWebNazevDe(String webNazevDe) {
        this.webNazevDe = webNazevDe;
    }

    public String getWebNazevEn() {
        return webNazevEn;
    }

    public void setWebNazevEn(String webNazevEn) {
        this.webNazevEn = webNazevEn;
    }
    
    public WebKategorieZakladni getWebOblzarHrubeKategorie() {
        return webOblzarHrubeKategorie;
    }

    public void setWebOblzarHrubeKategorie(WebKategorieZakladni webOblzarHrubeKategorie) {
        this.webOblzarHrubeKategorie = webOblzarHrubeKategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webOblzarHrubeId != null ? webOblzarHrubeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOsOblzarHrube)) {
            return false;
        }
        WebOsOblzarHrube other = (WebOsOblzarHrube) object;
        if ((this.webOblzarHrubeId == null && other.webOblzarHrubeId != null) || (this.webOblzarHrubeId != null && !this.webOblzarHrubeId.equals(other.webOblzarHrubeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOsOblzarHrube[ webOblzarHrubeId=" + webOblzarHrubeId + " ]";
    }

    /**
     * @return the webPoradiVyber
     */
    public Integer getWebPoradiVyber() {
        return webPoradiVyber;
    }

    /**
     * @param webPoradiVyber the webPoradiVyber to set
     */
    public void setWebPoradiVyber(Integer webPoradiVyber) {
        this.webPoradiVyber = webPoradiVyber;
    }

    /**
     * @return the webOsOblzarJemneCollection
     */
    public Collection<WebOsOblzarJemne> getWebOsOblzarJemneCollection() {
        return webOsOblzarJemneCollection;
    }

    /**
     * @param webOsOblzarJemneCollection the webOsOblzarJemneCollection to set
     */
    public void setWebOsOblzarJemneCollection(Collection<WebOsOblzarJemne> webOsOblzarJemneCollection) {
        this.webOsOblzarJemneCollection = webOsOblzarJemneCollection;
    }
}
