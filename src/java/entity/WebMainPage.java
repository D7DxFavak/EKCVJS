/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Favak
 */
@Entity
@Table(name = "web_main_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebMainPage.findAll", query = "SELECT w FROM WebMainPage w ORDER BY w.webMainPagePoradiVyber"),
    @NamedQuery(name = "WebMainPage.findByWebMainPageId", query = "SELECT w FROM WebMainPage w WHERE w.webMainPageId = :webMainPageId"),
    @NamedQuery(name = "WebMainPage.findByWebMainPageNazev", query = "SELECT w FROM WebMainPage w WHERE w.webMainPageNazev = :webMainPageNazev"),
    @NamedQuery(name = "WebMainPage.findByWebMainPageNazevEn", query = "SELECT w FROM WebMainPage w WHERE w.webMainPageNazevEn = :webMainPageNazevEn"),
    @NamedQuery(name = "WebMainPage.findByWebMainPageNazevDe", query = "SELECT w FROM WebMainPage w WHERE w.webMainPageNazevDe = :webMainPageNazevDe"),
    @NamedQuery(name = "WebMainPage.findByWebMainPagePopis", query = "SELECT w FROM WebMainPage w WHERE w.webMainPagePopis = :webMainPagePopis"),
    @NamedQuery(name = "WebMainPage.findByWebMainPagePopisEn", query = "SELECT w FROM WebMainPage w WHERE w.webMainPagePopisEn = :webMainPagePopisEn"),
    @NamedQuery(name = "WebMainPage.findByWebMainPagePopisDe", query = "SELECT w FROM WebMainPage w WHERE w.webMainPagePopisDe = :webMainPagePopisDe"),
    @NamedQuery(name = "WebMainPage.findByWebMainPagePoznamky", query = "SELECT w FROM WebMainPage w WHERE w.webMainPagePoznamky = :webMainPagePoznamky"),
    @NamedQuery(name = "WebMainPage.findByWebMainPagePoradiVyber", query = "SELECT w FROM WebMainPage w WHERE w.webMainPagePoradiVyber = :webMainPagePoradiVyber")})
public class WebMainPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_main_page_id")
    private Integer webMainPageId;
    @Size(max = 250)
    @Column(name = "web_main_page_nazev")
    private String webMainPageNazev;
    @Size(max = 250)
    @Column(name = "web_main_page_nazev_en")
    private String webMainPageNazevEn;
    @Size(max = 250)
    @Column(name = "web_main_page_nazev_de")
    private String webMainPageNazevDe;
    @Size(max = 2147483647)
    @Column(name = "web_main_page_popis")
    private String webMainPagePopis;
    @Size(max = 2147483647)
    @Column(name = "web_main_page_popis_en")
    private String webMainPagePopisEn;
    @Size(max = 2147483647)
    @Column(name = "web_main_page_popis_de")
    private String webMainPagePopisDe;
    @Size(max = 2147483647)
    @Column(name = "web_main_page_poznamky")
    private String webMainPagePoznamky;
    @Column(name = "web_main_page_poradi_vyber")
    private Integer webMainPagePoradiVyber;   
    @JoinColumn(name = "web_main_page_kategorie", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webMainPageKategorie;

    public WebMainPage() {
    }

    public WebMainPage(Integer webMainPageId) {
        this.webMainPageId = webMainPageId;
    }

    public Integer getWebMainPageId() {
        return webMainPageId;
    }

    public void setWebMainPageId(Integer webMainPageId) {
        this.webMainPageId = webMainPageId;
    }

    public String getWebMainPageNazev() {
        return webMainPageNazev;
    }

    public void setWebMainPageNazev(String webMainPageNazev) {
        this.webMainPageNazev = webMainPageNazev;
    }

    public String getWebMainPageNazevEn() {
        return webMainPageNazevEn;
    }

    public void setWebMainPageNazevEn(String webMainPageNazevEn) {
        this.webMainPageNazevEn = webMainPageNazevEn;
    }

    public String getWebMainPageNazevDe() {
        return webMainPageNazevDe;
    }

    public void setWebMainPageNazevDe(String webMainPageNazevDe) {
        this.webMainPageNazevDe = webMainPageNazevDe;
    }

    public String getWebMainPagePopis() {
        return webMainPagePopis;
    }

    public void setWebMainPagePopis(String webMainPagePopis) {
        this.webMainPagePopis = webMainPagePopis;
    }

    public String getWebMainPagePopisEn() {
        return webMainPagePopisEn;
    }

    public void setWebMainPagePopisEn(String webMainPagePopisEn) {
        this.webMainPagePopisEn = webMainPagePopisEn;
    }

    public String getWebMainPagePopisDe() {
        return webMainPagePopisDe;
    }

    public void setWebMainPagePopisDe(String webMainPagePopisDe) {
        this.webMainPagePopisDe = webMainPagePopisDe;
    }

    public String getWebMainPagePoznamky() {
        return webMainPagePoznamky;
    }

    public void setWebMainPagePoznamky(String webMainPagePoznamky) {
        this.webMainPagePoznamky = webMainPagePoznamky;
    }

    public Integer getWebMainPagePoradiVyber() {
        return webMainPagePoradiVyber;
    }

    public void setWebMainPagePoradiVyber(Integer webMainPagePoradiVyber) {
        this.webMainPagePoradiVyber = webMainPagePoradiVyber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webMainPageId != null ? webMainPageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebMainPage)) {
            return false;
        }
        WebMainPage other = (WebMainPage) object;
        if ((this.webMainPageId == null && other.webMainPageId != null) || (this.webMainPageId != null && !this.webMainPageId.equals(other.webMainPageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebMainPage[ webMainPageId=" + webMainPageId + " ]";
    }
   
    /**
     * @return the webMainPageKategorie
     */
    public WebKategorieZakladni getWebMainPageKategorie() {
        return webMainPageKategorie;
    }

    /**
     * @param webMainPageKategorie the webMainPageKategorie to set
     */
    public void setWebMainPageKategorie(WebKategorieZakladni webMainPageKategorie) {
        this.webMainPageKategorie = webMainPageKategorie;
    }
    
    public String getPopis(String lang) {
        if(lang.equals("en")) {
             if(webMainPagePopisEn != null ) {
                return webMainPagePopisEn;
            } else {
                return webMainPagePopis;
            }
        } else if(lang.equals("de")) {
            if(webMainPagePopisDe != null ) {
                return webMainPagePopisDe;
            } else {
                return webMainPagePopis;
            }
        } else {
            return webMainPagePopis;
        }        
    }
     
    public String getNazev(String lang) {
        if(lang.equals("en")) {             
             if(webMainPageNazev != null ) {
                return webMainPageNazevEn;
            } else {
                return webMainPageNazev;
            }
        } else if(lang.equals("de")) {
            if(webMainPageNazevDe != null ) {
               return webMainPageNazevDe;
            } else {
                return webMainPageNazev;
            }
        } else {
            return webMainPageNazev;
        } 
    }
}
