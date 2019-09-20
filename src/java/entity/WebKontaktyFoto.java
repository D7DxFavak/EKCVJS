/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_kontakty_foto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebKontaktyFoto.findAll", query = "SELECT w FROM WebKontaktyFoto w"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoId", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoId = :webKontaktyFotoId"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoNazev", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoNazev = :webKontaktyFotoNazev"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoPopis", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoPopis = :webKontaktyFotoPopis"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoPoznamky", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoPoznamky = :webKontaktyFotoPoznamky"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoMd5", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoMd5 = :webKontaktyFotoMd5"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoOsoba", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoOsoba = :webKontaktyFotoOsoba"),
    @NamedQuery(name = "WebKontaktyFoto.findByWebKontaktyFotoVlozeno", query = "SELECT w FROM WebKontaktyFoto w WHERE w.webKontaktyFotoVlozeno = :webKontaktyFotoVlozeno")})
public class WebKontaktyFoto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_kontakty_foto_id")
    private Integer webKontaktyFotoId;
    @Size(max = 250)
    @Column(name = "web_kontakty_foto_nazev")
    private String webKontaktyFotoNazev;
    @Size(max = 2147483647)
    @Column(name = "web_kontakty_foto_popis")
    private String webKontaktyFotoPopis;
    @Lob
    @Column(name = "web_kontakty_foto_data")
    private byte[] webKontaktyFotoData;
    @Size(max = 2147483647)
    @Column(name = "web_kontakty_foto_poznamky")
    private String webKontaktyFotoPoznamky;
    @Size(max = 250)
    @Column(name = "web_kontakty_foto_md5")
    private String webKontaktyFotoMd5;
    @Column(name = "web_kontakty_foto_vlozeno")
    @Temporal(TemporalType.DATE)
    private Date webKontaktyFotoVlozeno;
    @JoinColumn(name = "web_kontakty_foto_osoba", referencedColumnName = "osoba_id")
    @ManyToOne(optional = false)
    private Osoby webKontaktyFotoOsoba;
    
    public WebKontaktyFoto() {
    }

    public WebKontaktyFoto(Integer webKontaktyFotoId) {
        this.webKontaktyFotoId = webKontaktyFotoId;
    }

    public Integer getWebKontaktyFotoId() {
        return webKontaktyFotoId;
    }

    public void setWebKontaktyFotoId(Integer webKontaktyFotoId) {
        this.webKontaktyFotoId = webKontaktyFotoId;
    }

    public String getWebKontaktyFotoNazev() {
        return webKontaktyFotoNazev;
    }

    public void setWebKontaktyFotoNazev(String webKontaktyFotoNazev) {
        this.webKontaktyFotoNazev = webKontaktyFotoNazev;
    }

    public String getWebKontaktyFotoPopis() {
        return webKontaktyFotoPopis;
    }

    public void setWebKontaktyFotoPopis(String webKontaktyFotoPopis) {
        this.webKontaktyFotoPopis = webKontaktyFotoPopis;
    }

    public byte[] getWebKontaktyFotoData() {
        return webKontaktyFotoData;
    }

    public void setWebKontaktyFotoData(byte[] webKontaktyFotoData) {
        this.webKontaktyFotoData = webKontaktyFotoData;
    }

    public String getWebKontaktyFotoPoznamky() {
        return webKontaktyFotoPoznamky;
    }

    public void setWebKontaktyFotoPoznamky(String webKontaktyFotoPoznamky) {
        this.webKontaktyFotoPoznamky = webKontaktyFotoPoznamky;
    }

    public String getWebKontaktyFotoMd5() {
        return webKontaktyFotoMd5;
    }

    public void setWebKontaktyFotoMd5(String webKontaktyFotoMd5) {
        this.webKontaktyFotoMd5 = webKontaktyFotoMd5;
    }

    public Date getWebKontaktyFotoVlozeno() {
        return webKontaktyFotoVlozeno;
    }

    public void setWebKontaktyFotoVlozeno(Date webKontaktyFotoVlozeno) {
        this.webKontaktyFotoVlozeno = webKontaktyFotoVlozeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webKontaktyFotoId != null ? webKontaktyFotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebKontaktyFoto)) {
            return false;
        }
        WebKontaktyFoto other = (WebKontaktyFoto) object;
        if ((this.webKontaktyFotoId == null && other.webKontaktyFotoId != null) || (this.webKontaktyFotoId != null && !this.webKontaktyFotoId.equals(other.webKontaktyFotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebKontaktyFoto[ webKontaktyFotoId=" + webKontaktyFotoId + " ]";
    }

    /**
     * @return the webKontaktyFotoOsoba
     */
    public Osoby getWebKontaktyFotoOsoba() {
        return webKontaktyFotoOsoba;
    }

    /**
     * @param webKontaktyFotoOsoba the webKontaktyFotoOsoba to set
     */
    public void setWebKontaktyFotoOsoba(Osoby webKontaktyFotoOsoba) {
        this.webKontaktyFotoOsoba = webKontaktyFotoOsoba;
    }
    
}
