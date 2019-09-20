/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.jsoup.Jsoup;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_aktuality", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebAktuality.findAll", query = "SELECT w FROM WebAktuality w ORDER BY w.webAktualityDatumVlozeni DESC"),
    @NamedQuery(name = "WebAktuality.findByWebAktualityId", query = "SELECT w FROM WebAktuality w WHERE w.webAktualityPK.webAktualityId = :webAktualityId"),
    @NamedQuery(name = "WebAktuality.findByWebAktualityKategorie", query = "SELECT w FROM WebAktuality w WHERE w.webAktualityPK.webAktualityKategorie = :webAktualityKategorie ORDER BY w.webAktualityDatumVlozeni DESC"),
    @NamedQuery(name = "WebAktuality.findByWebAktualityNazev", query = "SELECT w FROM WebAktuality w WHERE w.webAktualityNazev = :webAktualityNazev"),
    @NamedQuery(name = "WebAktuality.findByWebAktualityPopis", query = "SELECT w FROM WebAktuality w WHERE w.webAktualityPopis = :webAktualityPopis"),
    @NamedQuery(name = "WebAktuality.findByWebAktualityDetailyPoznamky", query = "SELECT w FROM WebAktuality w WHERE w.webAktualityDetailyPoznamky = :webAktualityDetailyPoznamky"),
     @NamedQuery(name = "WebAktuality.findSouhrn", query = "SELECT w FROM WebAktuality w ORDER BY w.webAktualityDatumVlozeni DESC"),
    @NamedQuery(name = "WebAktuality.findByWebAktualityDatumVlozeni", query = "SELECT w FROM WebAktuality w WHERE w.webAktualityDatumVlozeni = :webAktualityDatumVlozeni")})
public class WebAktuality implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebAktualityPK webAktualityPK;
    @Size(max = 250)
    @Column(name = "web_aktuality_nazev")
    private String webAktualityNazev;
    @Size(max = 2147483647)
    @Column(name = "web_aktuality_popis")
    private String webAktualityPopis;
    @Size(max = 2147483647)
    @Column(name = "web_aktuality_poznamky")
    private String webAktualityDetailyPoznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_aktuality_datum_vlozeni")
    @Temporal(TemporalType.DATE)
    private Date webAktualityDatumVlozeni;
    @JoinColumn(name = "web_aktuality_kategorie", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webKategorieZakladni;
    @JoinColumn(name = "web_aktuality_vlozil", referencedColumnName = "osoba_id")
    @ManyToOne
    private Osoby webAktualityVlozil;
    @Transient
    private String webAktualityPopisKratky;

    public WebAktuality() {
    }

    public WebAktuality(WebAktualityPK webAktualityPK) {
        this.webAktualityPK = webAktualityPK;
    }

    public WebAktuality(WebAktualityPK webAktualityPK, Date webAktualityDatumVlozeni) {
        this.webAktualityPK = webAktualityPK;
        this.webAktualityDatumVlozeni = webAktualityDatumVlozeni;
    }

    public WebAktuality(int webAktualityId, int webAktualityKategorie) {
        this.webAktualityPK = new WebAktualityPK(webAktualityId, webAktualityKategorie);
    }

    public WebAktualityPK getWebAktualityPK() {
        return webAktualityPK;
    }

    public void setWebAktualityPK(WebAktualityPK webAktualityPK) {
        this.webAktualityPK = webAktualityPK;
    }

    public String getWebAktualityNazev() {
        return webAktualityNazev;
    }

    public void setWebAktualityNazev(String webAktualityNazev) {
        this.webAktualityNazev = webAktualityNazev;
    }

    public String getWebAktualityPopis() {
        return webAktualityPopis;
    }    
   
    public void setWebAktualityPopis(String webAktualityPopis) {
        this.webAktualityPopis = webAktualityPopis;
    }

    public String getWebAktualityDetailyPoznamky() {
        return webAktualityDetailyPoznamky;
    }

    public void setWebAktualityDetailyPoznamky(String webAktualityDetailyPoznamky) {
        this.webAktualityDetailyPoznamky = webAktualityDetailyPoznamky;
    }

    public Date getWebAktualityDatumVlozeni() {
        return webAktualityDatumVlozeni;
    }

    public void setWebAktualityDatumVlozeni(Date webAktualityDatumVlozeni) {
        this.webAktualityDatumVlozeni = webAktualityDatumVlozeni;
    }

    public WebKategorieZakladni getWebKategorieZakladni() {
        return webKategorieZakladni;
    }

    public void setWebKategorieZakladni(WebKategorieZakladni webKategorieZakladni) {
        this.webKategorieZakladni = webKategorieZakladni;
    }

    public Osoby getWebAktualityVlozil() {
        return webAktualityVlozil;
    }

    public void setWebAktualityVlozil(Osoby webAktualityVlozil) {
        this.webAktualityVlozil = webAktualityVlozil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webAktualityPK != null ? webAktualityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebAktuality)) {
            return false;
        }
        WebAktuality other = (WebAktuality) object;
        if ((this.webAktualityPK == null && other.webAktualityPK != null) || (this.webAktualityPK != null && !this.webAktualityPK.equals(other.webAktualityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebAktuality[ webAktualityPK=" + webAktualityPK + " ]";
    }
    
    public String getWebAktualityPopisKratky() {
        String popisRet = Jsoup.parse(webAktualityPopis).text();       
        if( popisRet.length() > 260) {
            return popisRet.substring(0, 260).substring(0, 1+popisRet.substring(0, 260).lastIndexOf("."));
        } else {
            return popisRet;
        }        
    }

    /**
     * @param webAktualityPopisKratky the webAktualityPopisKratky to set
     */
    public void setWebAktualityPopisKratky(String webAktualityPopisKratky) {
        this.webAktualityPopisKratky = webAktualityPopisKratky;
    }
    
}
