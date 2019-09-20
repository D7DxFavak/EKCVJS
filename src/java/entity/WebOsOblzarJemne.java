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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "web_os_oblzar_jemne", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebOsOblzarJemne.findAll", query = "SELECT w FROM WebOsOblzarJemne w ORDER BY w.webPoradiVyber"),
    @NamedQuery(name = "WebOsOblzarJemne.findByWebOblzarJemneId", query = "SELECT w FROM WebOsOblzarJemne w WHERE w.webOblzarJemneId = :webOblzarJemneId"),
    @NamedQuery(name = "WebOsOblzarJemne.findByWebOblzarHrubeId", query = "SELECT w FROM WebOsOblzarJemne w WHERE w.webOblzarHrubeId = :webOblzarHrubeId ORDER BY w.webPoradiVyber"),
    @NamedQuery(name = "WebOsOblzarJemne.findByWebNazev", query = "SELECT w FROM WebOsOblzarJemne w WHERE w.webNazev = :webNazev"),
    @NamedQuery(name = "WebOsOblzarJemne.findByWebPoznamky", query = "SELECT w FROM WebOsOblzarJemne w WHERE w.webPoznamky = :webPoznamky"),
    @NamedQuery(name = "WebOsOblzarJemne.findByWebNazevDe", query = "SELECT w FROM WebOsOblzarJemne w WHERE w.webNazevDe = :webNazevDe"),
    @NamedQuery(name = "WebOsOblzarJemne.findByWebNazevEn", query = "SELECT w FROM WebOsOblzarJemne w WHERE w.webNazevEn = :webNazevEn")})
public class WebOsOblzarJemne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_oblzar_jemne_id")
    private Integer webOblzarJemneId;
    @Size(max = 200)
    @Column(name = "web_nazev")
    private String webNazev;
    @Size(max = 2147483647)
    @Column(name = "web_poznamky")
    private String webPoznamky;
    @Size(max = 200)
    @Column(name = "web_nazev_de")
    private String webNazevDe;
    @Size(max = 200)
    @Column(name = "web_nazev_en")
    private String webNazevEn;   
    @Column(name = "web_poradi_vyber")
    private Integer webPoradiVyber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webOsZarazeniOblzarJemna")
    private Collection<WebOsZarazeni> webOsZarazeniCollection;
    @JoinColumn(name = "web_oblzar_hrube_id", referencedColumnName = "web_oblzar_hrube_id")
    @ManyToOne(optional = false)
    private WebOsOblzarHrube webOblzarHrubeId;

    public WebOsOblzarJemne() {
    }

    public WebOsOblzarJemne(Integer webOblzarJemneId) {
        this.webOblzarJemneId = webOblzarJemneId;
    }

    public Integer getWebOblzarJemneId() {
        return webOblzarJemneId;
    }

    public void setWebOblzarJemneId(Integer webOblzarJemneId) {
        this.webOblzarJemneId = webOblzarJemneId;
    }

    public String getWebNazev() {
        return webNazev;
    }

    public void setWebNazev(String webNazev) {
        this.webNazev = webNazev;
    }

    public String getWebPoznamky() {
        return webPoznamky;
    }

    public void setWebPoznamky(String webPoznamky) {
        this.webPoznamky = webPoznamky;
    }

    public String getWebNazevDe() {
        return webNazevDe;
    }

    public void setWebNazevDe(String webNazevDe) {
        this.webNazevDe = webNazevDe;
    }

    public String getWebNazevEn() {
        return webNazevEn;
    }

    public void setWebNazevEn(String webNazevEn) {
        this.webNazevEn = webNazevEn;
    }

    @XmlTransient
    public Collection<WebOsZarazeni> getWebOsZarazeniCollection() {
        return webOsZarazeniCollection;
    }

    public void setWebOsZarazeniCollection(Collection<WebOsZarazeni> webOsZarazeniCollection) {
        this.webOsZarazeniCollection = webOsZarazeniCollection;
    }

    public WebOsOblzarHrube getWebOblzarHrubeId() {
        return webOblzarHrubeId;
    }

    public void setWebOblzarHrubeId(WebOsOblzarHrube webOblzarHrubeId) {
        this.webOblzarHrubeId = webOblzarHrubeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webOblzarJemneId != null ? webOblzarJemneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOsOblzarJemne)) {
            return false;
        }
        WebOsOblzarJemne other = (WebOsOblzarJemne) object;
        if ((this.webOblzarJemneId == null && other.webOblzarJemneId != null) || (this.webOblzarJemneId != null && !this.webOblzarJemneId.equals(other.webOblzarJemneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOsOblzarJemne[ webOblzarJemneId=" + webOblzarJemneId + " ]";
    }

    /**
     * @return the webPoradiVyber
     */
    public Integer getWebPoradiVyber() {
        return webPoradiVyber;
    }

    /**
     * @param webPoradiVyber the webPoradiVyber to set
     */
    public void setWebPoradiVyber(Integer webPoradiVyber) {
        this.webPoradiVyber = webPoradiVyber;
    }
    
}
