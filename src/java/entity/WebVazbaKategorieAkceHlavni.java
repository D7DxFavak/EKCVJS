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
@Table(name = "web_vazba_kategorie_akce_hlavni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebVazbaKategorieAkceHlavni.findAll", query = "SELECT w FROM WebVazbaKategorieAkceHlavni w"),
    @NamedQuery(name = "WebVazbaKategorieAkceHlavni.findByWebVazbaKategorieAkceHlavniKategorieId", query = "SELECT w FROM WebVazbaKategorieAkceHlavni w WHERE w.webVazbaKategorieAkceHlavniPK.webVazbaKategorieAkceHlavniKategorieId = :webVazbaKategorieAkceHlavniKategorieId"),
    @NamedQuery(name = "WebVazbaKategorieAkceHlavni.findByWebVazbaKategorieAkceHlavniAkceId", query = "SELECT w FROM WebVazbaKategorieAkceHlavni w WHERE w.webVazbaKategorieAkceHlavniPK.webVazbaKategorieAkceHlavniAkceId = :webVazbaKategorieAkceHlavniAkceId"),
    @NamedQuery(name = "WebVazbaKategorieAkceHlavni.findByWebVazbaKategorieAkceHlavniPoznamky", query = "SELECT w FROM WebVazbaKategorieAkceHlavni w WHERE w.webVazbaKategorieAkceHlavniPoznamky = :webVazbaKategorieAkceHlavniPoznamky")})
public class WebVazbaKategorieAkceHlavni implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebVazbaKategorieAkceHlavniPK webVazbaKategorieAkceHlavniPK;
    @Size(max = 250)
    @Column(name = "web_vazba_kategorie_akce_hlavni_poznamky")
    private String webVazbaKategorieAkceHlavniPoznamky;
    @JoinColumn(name = "web_vazba_kategorie_akce_hlavni_kategorie_id", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webKategorieZakladni;
    @JoinColumn(name = "web_vazba_kategorie_akce_hlavni_akce_id", referencedColumnName = "akce_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AkceHlavni akceHlavni;

    public WebVazbaKategorieAkceHlavni() {
    }

    public WebVazbaKategorieAkceHlavni(WebVazbaKategorieAkceHlavniPK webVazbaKategorieAkceHlavniPK) {
        this.webVazbaKategorieAkceHlavniPK = webVazbaKategorieAkceHlavniPK;
    }

    public WebVazbaKategorieAkceHlavni(int webVazbaKategorieAkceHlavniKategorieId, int webVazbaKategorieAkceHlavniAkceId) {
        this.webVazbaKategorieAkceHlavniPK = new WebVazbaKategorieAkceHlavniPK(webVazbaKategorieAkceHlavniKategorieId, webVazbaKategorieAkceHlavniAkceId);
    }

    public WebVazbaKategorieAkceHlavniPK getWebVazbaKategorieAkceHlavniPK() {
        return webVazbaKategorieAkceHlavniPK;
    }

    public void setWebVazbaKategorieAkceHlavniPK(WebVazbaKategorieAkceHlavniPK webVazbaKategorieAkceHlavniPK) {
        this.webVazbaKategorieAkceHlavniPK = webVazbaKategorieAkceHlavniPK;
    }

    public String getWebVazbaKategorieAkceHlavniPoznamky() {
        return webVazbaKategorieAkceHlavniPoznamky;
    }

    public void setWebVazbaKategorieAkceHlavniPoznamky(String webVazbaKategorieAkceHlavniPoznamky) {
        this.webVazbaKategorieAkceHlavniPoznamky = webVazbaKategorieAkceHlavniPoznamky;
    }

    public WebKategorieZakladni getWebKategorieZakladni() {
        return webKategorieZakladni;
    }

    public void setWebKategorieZakladni(WebKategorieZakladni webKategorieZakladni) {
        this.webKategorieZakladni = webKategorieZakladni;
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
        hash += (webVazbaKategorieAkceHlavniPK != null ? webVazbaKategorieAkceHlavniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebVazbaKategorieAkceHlavni)) {
            return false;
        }
        WebVazbaKategorieAkceHlavni other = (WebVazbaKategorieAkceHlavni) object;
        if ((this.webVazbaKategorieAkceHlavniPK == null && other.webVazbaKategorieAkceHlavniPK != null) || (this.webVazbaKategorieAkceHlavniPK != null && !this.webVazbaKategorieAkceHlavniPK.equals(other.webVazbaKategorieAkceHlavniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebVazbaKategorieAkceHlavni[ webVazbaKategorieAkceHlavniPK=" + webVazbaKategorieAkceHlavniPK + " ]";
    }
    
}
