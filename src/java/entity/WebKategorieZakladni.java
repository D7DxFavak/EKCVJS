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
@Table(name = "web_kategorie_zakladni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebKategorieZakladni.findAll", query = "SELECT w FROM WebKategorieZakladni w"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniId", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniId = :webKategorieZakladniId"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniNazev", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniNazev = :webKategorieZakladniNazev"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniPopis", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniPopis = :webKategorieZakladniPopis"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniPrimarni", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniPrimarni = :webKategorieZakladniPrimarni"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniPoznamky", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniPoznamky = :webKategorieZakladniPoznamky"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniPoradiVyber", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniPoradiVyber = :webKategorieZakladniPoradiVyber"),
    @NamedQuery(name = "WebKategorieZakladni.findByWebKategorieZakladniOdkaz", query = "SELECT w FROM WebKategorieZakladni w WHERE w.webKategorieZakladniOdkaz = :webKategorieZakladniOdkaz")})
public class WebKategorieZakladni implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_kategorie_zakladni_id")
    private Integer webKategorieZakladniId;
    @Size(max = 250)
    @Column(name = "web_kategorie_zakladni_nazev")
    private String webKategorieZakladniNazev;
    @Size(max = 2147483647)
    @Column(name = "web_kategorie_zakladni_popis")
    private String webKategorieZakladniPopis;
    @Column(name = "web_kategorie_zakladni_primarni")
    private Boolean webKategorieZakladniPrimarni;
    @Size(max = 2147483647)
    @Column(name = "web_kategorie_zakladni_poznamky")
    private String webKategorieZakladniPoznamky;
    @Column(name = "web_kategorie_zakladni_poradi_vyber")
    private Integer webKategorieZakladniPoradiVyber;
    @Size(max = 250)
    @Column(name = "web_kategorie_zakladni_odkaz")
    private String webKategorieZakladniOdkaz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webKategorieZakladni")
    private Collection<WebKategorieDetaily> webKategorieDetailyCollection;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webKategorieZakladni")
    private Collection<WebAktuality> webAktualityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webKategorieZakladni")
    private Collection<WebVazbaKategorieAkceHlavni> webVazbaKategorieAkceHlavniCollection;

    public WebKategorieZakladni() {
    }

    public WebKategorieZakladni(Integer webKategorieZakladniId) {
        this.webKategorieZakladniId = webKategorieZakladniId;
    }

    public Integer getWebKategorieZakladniId() {
        return webKategorieZakladniId;
    }

    public void setWebKategorieZakladniId(Integer webKategorieZakladniId) {
        this.webKategorieZakladniId = webKategorieZakladniId;
    }

    public String getWebKategorieZakladniNazev() {
        return webKategorieZakladniNazev;
    }

    public void setWebKategorieZakladniNazev(String webKategorieZakladniNazev) {
        this.webKategorieZakladniNazev = webKategorieZakladniNazev;
    }

    public String getWebKategorieZakladniPopis() {
        return webKategorieZakladniPopis;
    }

    public void setWebKategorieZakladniPopis(String webKategorieZakladniPopis) {
        this.webKategorieZakladniPopis = webKategorieZakladniPopis;
    }

    public Boolean getWebKategorieZakladniPrimarni() {
        return webKategorieZakladniPrimarni;
    }

    public void setWebKategorieZakladniPrimarni(Boolean webKategorieZakladniPrimarni) {
        this.webKategorieZakladniPrimarni = webKategorieZakladniPrimarni;
    }

    public String getWebKategorieZakladniPoznamky() {
        return webKategorieZakladniPoznamky;
    }

    public void setWebKategorieZakladniPoznamky(String webKategorieZakladniPoznamky) {
        this.webKategorieZakladniPoznamky = webKategorieZakladniPoznamky;
    }

    public Integer getWebKategorieZakladniPoradiVyber() {
        return webKategorieZakladniPoradiVyber;
    }

    public void setWebKategorieZakladniPoradiVyber(Integer webKategorieZakladniPoradiVyber) {
        this.webKategorieZakladniPoradiVyber = webKategorieZakladniPoradiVyber;
    }

    public String getWebKategorieZakladniOdkaz() {
        return webKategorieZakladniOdkaz;
    }

    public void setWebKategorieZakladniOdkaz(String webKategorieZakladniOdkaz) {
        this.webKategorieZakladniOdkaz = webKategorieZakladniOdkaz;
    }

    @XmlTransient
    public Collection<WebKategorieDetaily> getWebKategorieDetailyCollection() {
        return webKategorieDetailyCollection;
    }

    public void setWebKategorieDetailyCollection(Collection<WebKategorieDetaily> webKategorieDetailyCollection) {
        this.webKategorieDetailyCollection = webKategorieDetailyCollection;
    }

    @XmlTransient
    public Collection<WebAktuality> getWebAktualityCollection() {
        return webAktualityCollection;
    }

    public void setWebAktualityCollection(Collection<WebAktuality> webAktualityCollection) {
        this.webAktualityCollection = webAktualityCollection;
    }

    @XmlTransient
    public Collection<WebVazbaKategorieAkceHlavni> getWebVazbaKategorieAkceHlavniCollection() {
        return webVazbaKategorieAkceHlavniCollection;
    }

    public void setWebVazbaKategorieAkceHlavniCollection(Collection<WebVazbaKategorieAkceHlavni> webVazbaKategorieAkceHlavniCollection) {
        this.webVazbaKategorieAkceHlavniCollection = webVazbaKategorieAkceHlavniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webKategorieZakladniId != null ? webKategorieZakladniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebKategorieZakladni)) {
            return false;
        }
        WebKategorieZakladni other = (WebKategorieZakladni) object;
        if ((this.webKategorieZakladniId == null && other.webKategorieZakladniId != null) || (this.webKategorieZakladniId != null && !this.webKategorieZakladniId.equals(other.webKategorieZakladniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebKategorieZakladni[ webKategorieZakladniId=" + webKategorieZakladniId + " ]";
    }
    
}
