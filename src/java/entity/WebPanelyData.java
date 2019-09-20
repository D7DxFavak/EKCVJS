/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_panely_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebPanelyData.findAll", query = "SELECT w FROM WebPanelyData w"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataId", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataId = :webPanelyDataId"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataPanel", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataPanel = :webPanelyDataPanel ORDER BY w.webPanelyDataPoradiVyber", hints =
    @QueryHint(name = "toplink.refresh", value = "true")),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataNazev", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataNazev = :webPanelyDataNazev ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataNazevEn", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataNazevEn = :webPanelyDataNazevEn ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataNazevDe", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataNazevDe = :webPanelyDataNazevDe ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataPopis", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataPopis = :webPanelyDataPopis ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataPopisEn", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataPopisEn = :webPanelyDataPopisEn ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataPopisDe", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataPopisDe = :webPanelyDataPopisDe ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataPoznamky", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataPoznamky = :webPanelyDataPoznamky ORDER BY w.webPanelyDataPoradiVyber"),
    @NamedQuery(name = "WebPanelyData.findByWebPanelyDataPoradiVyber", query = "SELECT w FROM WebPanelyData w WHERE w.webPanelyDataPoradiVyber = :webPanelyDataPoradiVyber ORDER BY w.webPanelyDataPoradiVyber")})
public class WebPanelyData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_panely_data_id")
    private Integer webPanelyDataId;
    @Size(max = 250)
    @Column(name = "web_panely_data_nazev")
    private String webPanelyDataNazev;
    @Size(max = 250)
    @Column(name = "web_panely_data_nazev_en")
    private String webPanelyDataNazevEn;
    @Size(max = 250)
    @Column(name = "web_panely_data_nazev_de")
    private String webPanelyDataNazevDe;
    @Size(max = 2147483647)
    @Column(name = "web_panely_data_popis")
    private String webPanelyDataPopis;
    @Size(max = 2147483647)
    @Column(name = "web_panely_data_popis_en")
    private String webPanelyDataPopisEn;
    @Size(max = 2147483647)
    @Column(name = "web_panely_data_popis_de")
    private String webPanelyDataPopisDe;
    @Size(max = 2147483647)
    @Column(name = "web_panely_data_poznamky")
    private String webPanelyDataPoznamky;
    @Column(name = "web_panely_data_poradi_vyber")
    private Integer webPanelyDataPoradiVyber;
    @JoinColumn(name = "web_panely_data_panel", referencedColumnName = "web_panely_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebPanely webPanelyDataPanel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webPanelyData")
    private Collection<VazbaPanelyDataUloziste> vazbaPanelyDataUlozisteCollection;

    public WebPanelyData() {
    }

    public WebPanelyData(Integer webPanelyDataId) {
        this.webPanelyDataId = webPanelyDataId;
    }

    public Integer getWebPanelyDataId() {
        return webPanelyDataId;
    }

    public void setWebPanelyDataId(Integer webPanelyDataId) {
        this.webPanelyDataId = webPanelyDataId;
    }

    public String getWebPanelyDataNazev() {
        return webPanelyDataNazev;
    }

    public void setWebPanelyDataNazev(String webPanelyDataNazev) {
        this.webPanelyDataNazev = webPanelyDataNazev;
    }

    public String getWebPanelyDataNazevEn() {
        return webPanelyDataNazevEn;
    }

    public void setWebPanelyDataNazevEn(String webPanelyDataNazevEn) {
        this.webPanelyDataNazevEn = webPanelyDataNazevEn;
    }

    public String getWebPanelyDataNazevDe() {
        return webPanelyDataNazevDe;
    }

    public void setWebPanelyDataNazevDe(String webPanelyDataNazevDe) {
        this.webPanelyDataNazevDe = webPanelyDataNazevDe;
    }

    public String getWebPanelyDataPopis() {
        return webPanelyDataPopis;
    }

    public void setWebPanelyDataPopis(String webPanelyDataPopis) {
        this.webPanelyDataPopis = webPanelyDataPopis;
    }

    public String getWebPanelyDataPopisEn() {
        return webPanelyDataPopisEn;
    }

    public void setWebPanelyDataPopisEn(String webPanelyDataPopisEn) {
        this.webPanelyDataPopisEn = webPanelyDataPopisEn;
    }

    public String getWebPanelyDataPopisDe() {
        return webPanelyDataPopisDe;
    }

    public void setWebPanelyDataPopisDe(String webPanelyDataPopisDe) {
        this.webPanelyDataPopisDe = webPanelyDataPopisDe;
    }

    public String getWebPanelyDataPoznamky() {
        return webPanelyDataPoznamky;
    }

    public void setWebPanelyDataPoznamky(String webPanelyDataPoznamky) {
        this.webPanelyDataPoznamky = webPanelyDataPoznamky;
    }

    public Integer getWebPanelyDataPoradiVyber() {
        return webPanelyDataPoradiVyber;
    }

    public void setWebPanelyDataPoradiVyber(Integer webPanelyDataPoradiVyber) {
        this.webPanelyDataPoradiVyber = webPanelyDataPoradiVyber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webPanelyDataId != null ? webPanelyDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebPanelyData)) {
            return false;
        }
        WebPanelyData other = (WebPanelyData) object;
        if ((this.webPanelyDataId == null && other.webPanelyDataId != null) || (this.webPanelyDataId != null && !this.webPanelyDataId.equals(other.webPanelyDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebPanelyData[ webPanelyDataId=" + webPanelyDataId + " ]";
    }

    /**
     * @return the webPanelyDataPanel
     */
    public WebPanely getWebPanelyDataPanel() {
        return webPanelyDataPanel;
    }

    /**
     * @param webPanelyDataPanel the webPanelyDataPanel to set
     */
    public void setWebPanelyDataPanel(WebPanely webPanelyDataPanel) {
        this.webPanelyDataPanel = webPanelyDataPanel;
    }

    public String getPopis(String lang) {
        if (lang.equals("en")) {
            if (webPanelyDataPopisEn != null) {
                return webPanelyDataPopisEn;
            } else {
                return webPanelyDataPopis;
            }
        } else if (lang.equals("de")) {
            if (webPanelyDataPopisDe != null) {
                return webPanelyDataPopisDe;
            } else {
                return webPanelyDataPopis;
            }
        } else {
            return webPanelyDataPopis;
        }
    }

    public String getNazev(String lang) {
        
        if (lang.equals("en")) {

            if (webPanelyDataNazevEn != null) {
               
                return webPanelyDataNazevEn;
            } else {
                return webPanelyDataNazev;
            }
        } else if (lang.equals("de")) {
            if (webPanelyDataNazevDe != null) {
                
                return webPanelyDataNazevDe;
            } else {
                return webPanelyDataNazev;
            }
        } else {
            return webPanelyDataNazev;
        }
    }

    /**
     * @return the vazbaPanelyDataUlozisteCollection
     */
    public Collection<VazbaPanelyDataUloziste> getVazbaPanelyDataUlozisteCollection() {
        return vazbaPanelyDataUlozisteCollection;
    }

    /**
     * @param vazbaPanelyDataUlozisteCollection the vazbaPanelyDataUlozisteCollection to set
     */
    public void setVazbaPanelyDataUlozisteCollection(Collection<VazbaPanelyDataUloziste> vazbaPanelyDataUlozisteCollection) {
        this.vazbaPanelyDataUlozisteCollection = vazbaPanelyDataUlozisteCollection;
    }
}
