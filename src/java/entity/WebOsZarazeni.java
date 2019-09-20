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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_os_zarazeni", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebOsZarazeni.findAll", query = "SELECT w FROM WebOsZarazeni w"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniEmail", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniEmail = :webOsZarazeniEmail"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniTelefon1", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniTelefon1 = :webOsZarazeniTelefon1"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniTelefon2", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniTelefon2 = :webOsZarazeniTelefon2"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniPoradi", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniPoradi = :webOsZarazeniPoradi"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniOsoba", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniOsoba = :webOsZarazeniOsoba"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniOblzarJemna", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniOblzarJemna = :webOsZarazeniOblzarJemna ORDER BY w.webOsZarazeniPoradi"),
    @NamedQuery(name = "WebOsZarazeni.findByWebOsZarazeniId", query = "SELECT w FROM WebOsZarazeni w WHERE w.webOsZarazeniId = :webOsZarazeniId")})
public class WebOsZarazeni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "web_os_zarazeni_email")
    private Integer webOsZarazeniEmail;
    @Column(name = "web_os_zarazeni_telefon1")
    private Integer webOsZarazeniTelefon1;
    @Column(name = "web_os_zarazeni_telefon2")
    private Integer webOsZarazeniTelefon2;
    @Column(name = "web_os_zarazeni_poradi")    
    private Integer webOsZarazeniPoradi;
    @Column(name = "web_os_zarazeni_popis")
    private String webOsZarazeniPopis;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_os_zarazeni_id")
    private Integer webOsZarazeniId;
    @JoinColumn(name = "web_os_zarazeni_pozice", referencedColumnName = "web_os_pozice_id")
    @ManyToOne(optional = false)
    private WebOsPozice webOsZarazeniPozice;
    @JoinColumn(name = "web_os_zarazeni_oblzar_jemna", referencedColumnName = "web_oblzar_jemne_id")
    @ManyToOne(optional = false)
    private WebOsOblzarJemne webOsZarazeniOblzarJemna;
    @JoinColumn(name = "web_os_zarazeni_osoba", referencedColumnName = "osoba_id")
    @ManyToOne(optional = false)
    private Osoby webOsZarazeniOsoba;

    public WebOsZarazeni() {
    }

    public WebOsZarazeni(Integer webOsZarazeniId) {
        this.webOsZarazeniId = webOsZarazeniId;
    }

    public Integer getWebOsZarazeniEmail() {
        return webOsZarazeniEmail;
    }

    public void setWebOsZarazeniEmail(Integer webOsZarazeniEmail) {
        this.webOsZarazeniEmail = webOsZarazeniEmail;
    }

    public Integer getWebOsZarazeniTelefon1() {
        return webOsZarazeniTelefon1;
    }

    public void setWebOsZarazeniTelefon1(Integer webOsZarazeniTelefon1) {
        this.webOsZarazeniTelefon1 = webOsZarazeniTelefon1;
    }

    public Integer getWebOsZarazeniTelefon2() {
        return webOsZarazeniTelefon2;
    }

    public void setWebOsZarazeniTelefon2(Integer webOsZarazeniTelefon2) {
        this.webOsZarazeniTelefon2 = webOsZarazeniTelefon2;
    }

    public Integer getWebOsZarazeniPoradi() {
        return webOsZarazeniPoradi;
    }

    public void setWebOsZarazeniPoradi(Integer webOsZarazeniPoradi) {
        this.webOsZarazeniPoradi = webOsZarazeniPoradi;
    }

    public Integer getWebOsZarazeniId() {
        return webOsZarazeniId;
    }

    public void setWebOsZarazeniId(Integer webOsZarazeniId) {
        this.webOsZarazeniId = webOsZarazeniId;
    }

    public WebOsPozice getWebOsZarazeniPozice() {
        return webOsZarazeniPozice;
    }

    public void setWebOsZarazeniPozice(WebOsPozice webOsZarazeniPozice) {
        this.webOsZarazeniPozice = webOsZarazeniPozice;
    }

    public WebOsOblzarJemne getWebOsZarazeniOblzarJemna() {
        return webOsZarazeniOblzarJemna;
    }

    public void setWebOsZarazeniOblzarJemna(WebOsOblzarJemne webOsZarazeniOblzarJemna) {
        this.webOsZarazeniOblzarJemna = webOsZarazeniOblzarJemna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webOsZarazeniId != null ? webOsZarazeniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOsZarazeni)) {
            return false;
        }
        WebOsZarazeni other = (WebOsZarazeni) object;
        if ((this.webOsZarazeniId == null && other.webOsZarazeniId != null) || (this.webOsZarazeniId != null && !this.webOsZarazeniId.equals(other.webOsZarazeniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOsZarazeni[ webOsZarazeniId=" + webOsZarazeniId + " ]";
    }

    /**
     * @return the webOsZarazeniOsoba
     */
    public Osoby getWebOsZarazeniOsoba() {
        return webOsZarazeniOsoba;
    }

    /**
     * @param webOsZarazeniOsoba the webOsZarazeniOsoba to set
     */
    public void setWebOsZarazeniOsoba(Osoby webOsZarazeniOsoba) {
        this.webOsZarazeniOsoba = webOsZarazeniOsoba;
    }

    /**
     * @return the webOsZarazeniPopis
     */
    public String getWebOsZarazeniPopis() {
        return webOsZarazeniPopis;
    }

    /**
     * @param webOsZarazeniPopis the webOsZarazeniPopis to set
     */
    public void setWebOsZarazeniPopis(String webOsZarazeniPopis) {
        this.webOsZarazeniPopis = webOsZarazeniPopis;
    }
}
