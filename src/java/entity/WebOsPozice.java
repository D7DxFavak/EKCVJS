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
@Table(name = "web_os_pozice", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebOsPozice.findAll", query = "SELECT w FROM WebOsPozice w"),
    @NamedQuery(name = "WebOsPozice.findByWebOsPoziceId", query = "SELECT w FROM WebOsPozice w WHERE w.webOsPoziceId = :webOsPoziceId"),
    @NamedQuery(name = "WebOsPozice.findByWebOsPoziceNazev", query = "SELECT w FROM WebOsPozice w WHERE w.webOsPoziceNazev = :webOsPoziceNazev"),
    @NamedQuery(name = "WebOsPozice.findByWebOsPoziceNazevEn", query = "SELECT w FROM WebOsPozice w WHERE w.webOsPoziceNazevEn = :webOsPoziceNazevEn"),
    @NamedQuery(name = "WebOsPozice.findByWebOsPoziceNazevDe", query = "SELECT w FROM WebOsPozice w WHERE w.webOsPoziceNazevDe = :webOsPoziceNazevDe")})
public class WebOsPozice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_os_pozice_id")
    private Integer webOsPoziceId;
    @Size(max = 200)
    @Column(name = "web_os_pozice_nazev")
    private String webOsPoziceNazev;
    @Size(max = 200)
    @Column(name = "web_os_pozice_nazev_en")
    private String webOsPoziceNazevEn;
    @Size(max = 200)
    @Column(name = "web_os_pozice_nazev_de")
    private String webOsPoziceNazevDe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webOsZarazeniPozice")
    private Collection<WebOsZarazeni> webOsZarazeniCollection;

    public WebOsPozice() {
    }

    public WebOsPozice(Integer webOsPoziceId) {
        this.webOsPoziceId = webOsPoziceId;
    }

    public Integer getWebOsPoziceId() {
        return webOsPoziceId;
    }

    public void setWebOsPoziceId(Integer webOsPoziceId) {
        this.webOsPoziceId = webOsPoziceId;
    }

    public String getWebOsPoziceNazev() {
        return webOsPoziceNazev;
    }

    public void setWebOsPoziceNazev(String webOsPoziceNazev) {
        this.webOsPoziceNazev = webOsPoziceNazev;
    }

    public String getWebOsPoziceNazevEn() {
        return webOsPoziceNazevEn;
    }

    public void setWebOsPoziceNazevEn(String webOsPoziceNazevEn) {
        this.webOsPoziceNazevEn = webOsPoziceNazevEn;
    }

    public String getWebOsPoziceNazevDe() {
        return webOsPoziceNazevDe;
    }

    public void setWebOsPoziceNazevDe(String webOsPoziceNazevDe) {
        this.webOsPoziceNazevDe = webOsPoziceNazevDe;
    }

    @XmlTransient
    public Collection<WebOsZarazeni> getWebOsZarazeniCollection() {
        return webOsZarazeniCollection;
    }

    public void setWebOsZarazeniCollection(Collection<WebOsZarazeni> webOsZarazeniCollection) {
        this.webOsZarazeniCollection = webOsZarazeniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webOsPoziceId != null ? webOsPoziceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOsPozice)) {
            return false;
        }
        WebOsPozice other = (WebOsPozice) object;
        if ((this.webOsPoziceId == null && other.webOsPoziceId != null) || (this.webOsPoziceId != null && !this.webOsPoziceId.equals(other.webOsPoziceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOsPozice[ webOsPoziceId=" + webOsPoziceId + " ]";
    }
    
}
