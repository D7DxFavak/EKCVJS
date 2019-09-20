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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_panely", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebPanely.findAll", query = "SELECT w FROM WebPanely w"),
    @NamedQuery(name = "WebPanely.findByWebPanelyId", query = "SELECT w FROM WebPanely w WHERE w.webPanelyId = :webPanelyId"),
    @NamedQuery(name = "WebPanely.findByWebPanelyZalozka", query = "SELECT w FROM WebPanely w WHERE w.webPanelyZalozka = :webPanelyZalozka ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByWebPanelyPanel", query = "SELECT w FROM WebPanely w WHERE w.webPanelyPanel = :webPanelyPanel ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByOdkazKategorie", query = "SELECT w FROM WebPanely w WHERE w.webPanelyOdkaz = :webPanelyOdkaz AND w.webPanelyKategorie = :webPanelyKategorie ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByWebPanelyNazev", query = "SELECT w FROM WebPanely w WHERE w.webPanelyNazev = :webPanelyNazev ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByWebPanelyPopis", query = "SELECT w FROM WebPanely w WHERE w.webPanelyPopis = :webPanelyPopis ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByWebPanelyPoznamky", query = "SELECT w FROM WebPanely w WHERE w.webPanelyPoznamky = :webPanelyPoznamky ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByWebPanelyPoradiVyber", query = "SELECT w FROM WebPanely w WHERE w.webPanelyPoradiVyber = :webPanelyPoradiVyber ORDER BY w.webPanelyPoradiVyber"),
    @NamedQuery(name = "WebPanely.findByWebPanelyOdkaz", query = "SELECT w FROM WebPanely w WHERE w.webPanelyOdkaz = :webPanelyOdkaz ORDER BY w.webPanelyPoradiVyber")})
public class WebPanely implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_panely_id")
    private Integer webPanelyId;    
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_panely_panel")
    private int webPanelyPanel;
    @Size(max = 250)
    @Column(name = "web_panely_nazev")
    private String webPanelyNazev;
    @Size(max = 2147483647)
    @Column(name = "web_panely_popis")
    private String webPanelyPopis;
    @Size(max = 2147483647)
    @Column(name = "web_panely_poznamky")
    private String webPanelyPoznamky;
     @Size(max = 2147483647)
    @Column(name = "web_panely_zalozka")
    private String webPanelyZalozka;
    @Column(name = "web_panely_poradi_vyber")
    private Integer webPanelyPoradiVyber;
    @Size(max = 250)
    @Column(name = "web_panely_odkaz")
    private String webPanelyOdkaz;
    @JoinColumn(name = "web_panely_kategorie", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webPanelyKategorie;

    public WebPanely() {
    }

    public WebPanely(Integer webPanelyId ) {
        this.webPanelyId = webPanelyId;
    }
    

    public Integer getwebPanelyId() {
        return webPanelyId;
    }

    public void setWebPanelyPK(Integer webPanelyId) {
        this.webPanelyId = webPanelyId;
    }

    public int getWebPanelyPanel() {
        return webPanelyPanel;
    }

    public void setWebPanelyPanel(int webPanelyPanel) {
        this.webPanelyPanel = webPanelyPanel;
    }

    public String getWebPanelyNazev() {
        return webPanelyNazev;
    }

    public void setWebPanelyNazev(String webPanelyNazev) {
        this.webPanelyNazev = webPanelyNazev;
    }

    public String getWebPanelyPopis() {
        return webPanelyPopis;
    }

    public void setWebPanelyPopis(String webPanelyPopis) {
        this.webPanelyPopis = webPanelyPopis;
    }

    public String getWebPanelyPoznamky() {
        return webPanelyPoznamky;
    }

    public void setWebPanelyPoznamky(String webPanelyPoznamky) {
        this.webPanelyPoznamky = webPanelyPoznamky;
    }

    public Integer getWebPanelyPoradiVyber() {
        return webPanelyPoradiVyber;
    }

    public void setWebPanelyPoradiVyber(Integer webPanelyPoradiVyber) {
        this.webPanelyPoradiVyber = webPanelyPoradiVyber;
    }

    public String getWebPanelyOdkaz() {
        return webPanelyOdkaz;
    }

    public void setWebPanelyOdkaz(String webPanelyOdkaz) {
        this.webPanelyOdkaz = webPanelyOdkaz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webPanelyId != null ? webPanelyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebPanely)) {
            return false;
        }
        WebPanely other = (WebPanely) object;
        if ((this.webPanelyId == null && other.webPanelyId != null) || (this.webPanelyId != null && !this.webPanelyId.equals(other.webPanelyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebPanely[ webPanelyId=" + webPanelyId + " ]";
    }

    /**
     * @return the webPanelyKategorie
     */
    public WebKategorieZakladni getWebPanelyKategorie() {
        return webPanelyKategorie;
    }

    /**
     * @param webPanelyKategorie the webPanelyKategorie to set
     */
    public void setWebPanelyKategorie(WebKategorieZakladni webPanelyKategorie) {
        this.webPanelyKategorie = webPanelyKategorie;
    }

    /**
     * @return the webPanelyId
     */
    public Integer getWebPanelyId() {
        return webPanelyId;
    }

    /**
     * @param webPanelyId the webPanelyId to set
     */
    public void setWebPanelyId(Integer webPanelyId) {
        this.webPanelyId = webPanelyId;
    }

    /**
     * @return the webPanelyZalozka
     */
    public String getWebPanelyZalozka() {
        return webPanelyZalozka;
    }

    /**
     * @param webPanelyZalozka the webPanelyZalozka to set
     */
    public void setWebPanelyZalozka(String webPanelyZalozka) {
        this.webPanelyZalozka = webPanelyZalozka;
    }

 
}
