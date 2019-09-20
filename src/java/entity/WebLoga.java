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
@Table(name = "web_loga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebLoga.findAll", query = "SELECT w FROM WebLoga w"),
    @NamedQuery(name = "WebLoga.findByWebLogaId", query = "SELECT w FROM WebLoga w WHERE w.webLogaId = :webLogaId"),
    @NamedQuery(name = "WebLoga.findByWebLogaPoradiVyber", query = "SELECT w FROM WebLoga w WHERE w.webLogaPoradiVyber = :webLogaPoradiVyber"),
    @NamedQuery(name = "WebLoga.findByWebLogaOdkaz", query = "SELECT w FROM WebLoga w WHERE w.webLogaOdkaz = :webLogaOdkaz"),
    @NamedQuery(name = "WebLoga.findByWebLogaPopis", query = "SELECT w FROM WebLoga w WHERE w.webLogaPopis = :webLogaPopis"),
    @NamedQuery(name = "WebLoga.findByWebLogaZobrazOdkaz", query = "SELECT w FROM WebLoga w WHERE w.webLogaZobrazOdkaz = :webLogaZobrazOdkaz"),
    @NamedQuery(name = "WebLoga.findByWebLogaZobrazPopis", query = "SELECT w FROM WebLoga w WHERE w.webLogaZobrazPopis = :webLogaZobrazPopis"),
    @NamedQuery(name = "WebLoga.findByWebLogaUlozisteDruh", query = "SELECT w FROM WebLoga w WHERE w.webLogaUlozisteDruh.ulozisteDataDruhyId = :ulozisteDataDruhyId ORDER BY w.webLogaPoradiVyber"),
    @NamedQuery(name = "WebLoga.findByWebLogaUlozisteDataId", query = "SELECT w FROM WebLoga w WHERE w.webLogaUlozisteData.ulozisteDataId = :ulozisteDataId"),
    @NamedQuery(name = "WebLoga.findByWebLogaZobrazLogo", query = "SELECT w FROM WebLoga w WHERE w.webLogaZobrazLogo = :webLogaZobrazLogo")})
public class WebLoga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_loga_id")
    private Integer webLogaId;
    @Column(name = "web_loga_poradi_vyber")
    private Integer webLogaPoradiVyber;
    @Size(max = 200)
    @Column(name = "web_loga_odkaz")
    private String webLogaOdkaz;
    @Size(max = 200)
    @Column(name = "web_loga_popis")
    private String webLogaPopis;
    @Column(name = "web_loga_zobraz_odkaz")
    private Boolean webLogaZobrazOdkaz;
    @Column(name = "web_loga_zobraz_popis")
    private Boolean webLogaZobrazPopis;
    @Column(name = "web_loga_zobraz_logo")
    private Boolean webLogaZobrazLogo;
    @JoinColumn(name = "web_loga_uloziste_data", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData webLogaUlozisteData;
     @JoinColumn(name = "web_loga_uloziste_druh", referencedColumnName = "uloziste_data_druhy_id")
    @ManyToOne(optional = false)
    private UlozisteDataDruhy webLogaUlozisteDruh;

    public WebLoga() {
    }

    public WebLoga(Integer webLogaId) {
        this.webLogaId = webLogaId;
    }

    public Integer getWebLogaId() {
        return webLogaId;
    }

    public void setWebLogaId(Integer webLogaId) {
        this.webLogaId = webLogaId;
    }

    public Integer getWebLogaPoradiVyber() {
        return webLogaPoradiVyber;
    }

    public void setWebLogaPoradiVyber(Integer webLogaPoradiVyber) {
        this.webLogaPoradiVyber = webLogaPoradiVyber;
    }

    public String getWebLogaOdkaz() {
        return webLogaOdkaz;
    }

    public void setWebLogaOdkaz(String webLogaOdkaz) {
        this.webLogaOdkaz = webLogaOdkaz;
    }

    public String getWebLogaPopis() {
        return webLogaPopis;
    }

    public void setWebLogaPopis(String webLogaPopis) {
        this.webLogaPopis = webLogaPopis;
    }

    public Boolean getWebLogaZobrazOdkaz() {
        return webLogaZobrazOdkaz;
    }

    public void setWebLogaZobrazOdkaz(Boolean webLogaZobrazOdkaz) {
        this.webLogaZobrazOdkaz = webLogaZobrazOdkaz;
    }

    public Boolean getWebLogaZobrazPopis() {
        return webLogaZobrazPopis;
    }

    public void setWebLogaZobrazPopis(Boolean webLogaZobrazPopis) {
        this.webLogaZobrazPopis = webLogaZobrazPopis;
    }

    public Boolean getWebLogaZobrazLogo() {
        return webLogaZobrazLogo;
    }

    public void setWebLogaZobrazLogo(Boolean webLogaZobrazLogo) {
        this.webLogaZobrazLogo = webLogaZobrazLogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webLogaId != null ? webLogaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebLoga)) {
            return false;
        }
        WebLoga other = (WebLoga) object;
        if ((this.webLogaId == null && other.webLogaId != null) || (this.webLogaId != null && !this.webLogaId.equals(other.webLogaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebLoga[ webLogaId=" + webLogaId + " ]";
    }

    /**
     * @return the webLogaUlozisteData
     */
    public UlozisteData getWebLogaUlozisteData() {
        return webLogaUlozisteData;
    }

    /**
     * @param webLogaUlozisteData the webLogaUlozisteData to set
     */
    public void setWebLogaUlozisteData(UlozisteData webLogaUlozisteData) {
        this.webLogaUlozisteData = webLogaUlozisteData;
    }

    /**
     * @return the webLogaUlozisteDruh
     */
    public UlozisteDataDruhy getWebLogaUlozisteDruh() {
        return webLogaUlozisteDruh;
    }

    /**
     * @param webLogaUlozisteDruh the webLogaUlozisteDruh to set
     */
    public void setWebLogaUlozisteDruh(UlozisteDataDruhy webLogaUlozisteDruh) {
        this.webLogaUlozisteDruh = webLogaUlozisteDruh;
    }
}
