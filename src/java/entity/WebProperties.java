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
@Table(name = "web_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebProperties.findAll", query = "SELECT w FROM WebProperties w"),
    @NamedQuery(name = "WebProperties.findByWebPropertiesId", query = "SELECT w FROM WebProperties w WHERE w.webPropertiesId = :webPropertiesId"),
    @NamedQuery(name = "WebProperties.findByWebPropertiesNazev", query = "SELECT w FROM WebProperties w WHERE w.webPropertiesNazev = :webPropertiesNazev"),
    @NamedQuery(name = "WebProperties.findByWebPropertiesCzPopis", query = "SELECT w FROM WebProperties w WHERE w.webPropertiesCzPopis = :webPropertiesCzPopis"),
    @NamedQuery(name = "WebProperties.findByWebPropertiesEnPopis", query = "SELECT w FROM WebProperties w WHERE w.webPropertiesEnPopis = :webPropertiesEnPopis"),
    @NamedQuery(name = "WebProperties.findByWebPropertiesDePopis", query = "SELECT w FROM WebProperties w WHERE w.webPropertiesDePopis = :webPropertiesDePopis"),
    @NamedQuery(name = "WebProperties.findByWebPropertiesPoznamky", query = "SELECT w FROM WebProperties w WHERE w.webPropertiesPoznamky = :webPropertiesPoznamky")})
public class WebProperties implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_properties_id")
    private Integer webPropertiesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "web_properties_nazev")
    private String webPropertiesNazev;
    @Size(max = 250)
    @Column(name = "web_properties_cz_popis")
    private String webPropertiesCzPopis;
    @Size(max = 250)
    @Column(name = "web_properties_en_popis")
    private String webPropertiesEnPopis;
    @Size(max = 250)
    @Column(name = "web_properties_de_popis")
    private String webPropertiesDePopis;
    @Size(max = 2147483647)
    @Column(name = "web_properties_poznamky")
    private String webPropertiesPoznamky;

    public WebProperties() {
    }

    public WebProperties(Integer webPropertiesId) {
        this.webPropertiesId = webPropertiesId;
    }

    public WebProperties(Integer webPropertiesId, String webPropertiesNazev) {
        this.webPropertiesId = webPropertiesId;
        this.webPropertiesNazev = webPropertiesNazev;
    }

    public Integer getWebPropertiesId() {
        return webPropertiesId;
    }

    public void setWebPropertiesId(Integer webPropertiesId) {
        this.webPropertiesId = webPropertiesId;
    }

    public String getWebPropertiesNazev() {
        return webPropertiesNazev;
    }

    public void setWebPropertiesNazev(String webPropertiesNazev) {
        this.webPropertiesNazev = webPropertiesNazev;
    }

    public String getWebPropertiesCzPopis() {
        return webPropertiesCzPopis;
    }

    public void setWebPropertiesCzPopis(String webPropertiesCzPopis) {
        this.webPropertiesCzPopis = webPropertiesCzPopis;
    }

    public String getWebPropertiesEnPopis() {
        return webPropertiesEnPopis;
    }

    public void setWebPropertiesEnPopis(String webPropertiesEnPopis) {
        this.webPropertiesEnPopis = webPropertiesEnPopis;
    }

    public String getWebPropertiesDePopis() {
        return webPropertiesDePopis;
    }

    public void setWebPropertiesDePopis(String webPropertiesDePopis) {
        this.webPropertiesDePopis = webPropertiesDePopis;
    }

    public String getWebPropertiesPoznamky() {
        return webPropertiesPoznamky;
    }

    public void setWebPropertiesPoznamky(String webPropertiesPoznamky) {
        this.webPropertiesPoznamky = webPropertiesPoznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webPropertiesId != null ? webPropertiesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebProperties)) {
            return false;
        }
        WebProperties other = (WebProperties) object;
        if ((this.webPropertiesId == null && other.webPropertiesId != null) || (this.webPropertiesId != null && !this.webPropertiesId.equals(other.webPropertiesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebProperties[ webPropertiesId=" + webPropertiesId + " ]";
    }
    
}
