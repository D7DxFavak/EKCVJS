/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_kategorie_detaily", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebKategorieDetaily.findAll", query = "SELECT w FROM WebKategorieDetaily w"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyId", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyPK.webKategorieDetailyId = :webKategorieDetailyId"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyKategorie", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyPK.webKategorieDetailyKategorie = :webKategorieDetailyKategorie"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyNazev", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyNazev = :webKategorieDetailyNazev"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyPopis", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyPopis = :webKategorieDetailyPopis"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyPoznamky", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyPoznamky = :webKategorieDetailyPoznamky"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyPoradiVyber", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyPoradiVyber = :webKategorieDetailyPoradiVyber"),
    @NamedQuery(name = "WebKategorieDetaily.findByWebKategorieDetailyOdkaz", query = "SELECT w FROM WebKategorieDetaily w WHERE w.webKategorieDetailyOdkaz = :webKategorieDetailyOdkaz")})
public class WebKategorieDetaily implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebKategorieDetailyPK webKategorieDetailyPK;
    @Size(max = 250)
    @Column(name = "web_kategorie_detaily_nazev")
    private String webKategorieDetailyNazev;
    @Size(max = 2147483647)
    @Column(name = "web_kategorie_detaily_popis")
    private String webKategorieDetailyPopis;
    @Size(max = 2147483647)
    @Column(name = "web_kategorie_detaily_poznamky")
    private String webKategorieDetailyPoznamky;
    @Column(name = "web_kategorie_detaily_poradi_vyber")
    private Integer webKategorieDetailyPoradiVyber;
    @Size(max = 250)
    @Column(name = "web_kategorie_detaily_odkaz")
    private String webKategorieDetailyOdkaz;
    @JoinColumn(name = "web_kategorie_detaily_kategorie", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webKategorieZakladni;

    public WebKategorieDetaily() {
    }

    public WebKategorieDetaily(WebKategorieDetailyPK webKategorieDetailyPK) {
        this.webKategorieDetailyPK = webKategorieDetailyPK;
    }

    public WebKategorieDetaily(int webKategorieDetailyId, int webKategorieDetailyKategorie) {
        this.webKategorieDetailyPK = new WebKategorieDetailyPK(webKategorieDetailyId, webKategorieDetailyKategorie);
    }

    public WebKategorieDetailyPK getWebKategorieDetailyPK() {
        return webKategorieDetailyPK;
    }

    public void setWebKategorieDetailyPK(WebKategorieDetailyPK webKategorieDetailyPK) {
        this.webKategorieDetailyPK = webKategorieDetailyPK;
    }

    public String getWebKategorieDetailyNazev() {
        return webKategorieDetailyNazev;
    }

    public void setWebKategorieDetailyNazev(String webKategorieDetailyNazev) {
        this.webKategorieDetailyNazev = webKategorieDetailyNazev;
    }

    public String getWebKategorieDetailyPopis() {
        return webKategorieDetailyPopis;
    }

    public void setWebKategorieDetailyPopis(String webKategorieDetailyPopis) {
        this.webKategorieDetailyPopis = webKategorieDetailyPopis;
    }

    public String getWebKategorieDetailyPoznamky() {
        return webKategorieDetailyPoznamky;
    }

    public void setWebKategorieDetailyPoznamky(String webKategorieDetailyPoznamky) {
        this.webKategorieDetailyPoznamky = webKategorieDetailyPoznamky;
    }

    public Integer getWebKategorieDetailyPoradiVyber() {
        return webKategorieDetailyPoradiVyber;
    }

    public void setWebKategorieDetailyPoradiVyber(Integer webKategorieDetailyPoradiVyber) {
        this.webKategorieDetailyPoradiVyber = webKategorieDetailyPoradiVyber;
    }

    public String getWebKategorieDetailyOdkaz() {
        return webKategorieDetailyOdkaz;
    }

    public void setWebKategorieDetailyOdkaz(String webKategorieDetailyOdkaz) {
        this.webKategorieDetailyOdkaz = webKategorieDetailyOdkaz;
    }

    public WebKategorieZakladni getWebKategorieZakladni() {
        return webKategorieZakladni;
    }

    public void setWebKategorieZakladni(WebKategorieZakladni webKategorieZakladni) {
        this.webKategorieZakladni = webKategorieZakladni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webKategorieDetailyPK != null ? webKategorieDetailyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebKategorieDetaily)) {
            return false;
        }
        WebKategorieDetaily other = (WebKategorieDetaily) object;
        if ((this.webKategorieDetailyPK == null && other.webKategorieDetailyPK != null) || (this.webKategorieDetailyPK != null && !this.webKategorieDetailyPK.equals(other.webKategorieDetailyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebKategorieDetaily[ webKategorieDetailyPK=" + webKategorieDetailyPK + " ]";
    }
    
}
