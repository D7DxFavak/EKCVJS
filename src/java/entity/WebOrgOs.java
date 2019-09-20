/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "web_org_os")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebOrgOs.findAll", query = "SELECT w FROM WebOrgOs w"),
    @NamedQuery(name = "WebOrgOs.findByWebOrgOsOsoba", query = "SELECT w FROM WebOrgOs w WHERE w.webOrgOsPK.webOrgOsOsoba = :webOrgOsOsoba"),
    @NamedQuery(name = "WebOrgOs.findByWebOrgOsOrganizace", query = "SELECT w FROM WebOrgOs w WHERE w.webOrgOsPK.webOrgOsOrganizace = :webOrgOsOrganizace ORDER BY w.webOrgOsOsoba.prijmeni"),
    @NamedQuery(name = "WebOrgOs.findByWebOrgOsDatumVlozeni", query = "SELECT w FROM WebOrgOs w WHERE w.webOrgOsDatumVlozeni = :webOrgOsDatumVlozeni"),
    @NamedQuery(name = "WebOrgOs.findByWebOrgOsPoznamka", query = "SELECT w FROM WebOrgOs w WHERE w.webOrgOsPoznamka = :webOrgOsPoznamka"),
    @NamedQuery(name = "WebOrgOs.findByWebOrgOsAktivni", query = "SELECT w FROM WebOrgOs w WHERE w.webOrgOsAktivni = :webOrgOsAktivni")})
public class WebOrgOs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebOrgOsPK webOrgOsPK;
    @Column(name = "web_org_os_datum_vlozeni")
    @Temporal(TemporalType.DATE)
    private Date webOrgOsDatumVlozeni;
    @Size(max = 500)
    @Column(name = "web_org_os_poznamka")
    private String webOrgOsPoznamka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_org_os_aktivni")
    private boolean webOrgOsAktivni;
    @JoinColumn(name = "web_org_os_osoba", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne
    private Osoby webOrgOsOsoba;
    @JoinColumn(name = "web_org_os_organizace", referencedColumnName = "organizace_id", insertable = false, updatable = false)
    @ManyToOne
    private Organizace webOrgOsOrganizace;
    public WebOrgOs() {
    }

    public WebOrgOs(WebOrgOsPK webOrgOsPK) {
        this.webOrgOsPK = webOrgOsPK;
    }

    public WebOrgOs(WebOrgOsPK webOrgOsPK, boolean webOrgOsAktivni) {
        this.webOrgOsPK = webOrgOsPK;
        this.webOrgOsAktivni = webOrgOsAktivni;
    }

    public WebOrgOs(int webOrgOsOsoba, int webOrgOsOrganizace) {
        this.webOrgOsPK = new WebOrgOsPK(webOrgOsOsoba, webOrgOsOrganizace);
    }

    public WebOrgOsPK getWebOrgOsPK() {
        return webOrgOsPK;
    }

    public void setWebOrgOsPK(WebOrgOsPK webOrgOsPK) {
        this.webOrgOsPK = webOrgOsPK;
    }

    public Date getWebOrgOsDatumVlozeni() {
        return webOrgOsDatumVlozeni;
    }

    public void setWebOrgOsDatumVlozeni(Date webOrgOsDatumVlozeni) {
        this.webOrgOsDatumVlozeni = webOrgOsDatumVlozeni;
    }

    public String getWebOrgOsPoznamka() {
        return webOrgOsPoznamka;
    }

    public void setWebOrgOsPoznamka(String webOrgOsPoznamka) {
        this.webOrgOsPoznamka = webOrgOsPoznamka;
    }

    public boolean getWebOrgOsAktivni() {
        return isWebOrgOsAktivni();
    }

    public void setWebOrgOsAktivni(boolean webOrgOsAktivni) {
        this.webOrgOsAktivni = webOrgOsAktivni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webOrgOsPK != null ? webOrgOsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOrgOs)) {
            return false;
        }
        WebOrgOs other = (WebOrgOs) object;
        if ((this.webOrgOsPK == null && other.webOrgOsPK != null) || (this.webOrgOsPK != null && !this.webOrgOsPK.equals(other.webOrgOsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOrgOs[ webOrgOsPK=" + webOrgOsPK + " ]";
    }

    /**
     * @return the webOrgOsAktivni
     */
    public boolean isWebOrgOsAktivni() {
        return webOrgOsAktivni;
    }

    /**
     * @return the webOrgOsOsoba
     */
    public Osoby getWebOrgOsOsoba() {
        return webOrgOsOsoba;
    }

    /**
     * @param webOrgOsOsoba the webOrgOsOsoba to set
     */
    public void setWebOrgOsOsoba(Osoby webOrgOsOsoba) {
        this.webOrgOsOsoba = webOrgOsOsoba;
    }

    /**
     * @return the webOrgOsOrganizace
     */
    public Organizace getWebOrgOsOrganizace() {
        return webOrgOsOrganizace;
    }

    /**
     * @param webOrgOsOrganizace the webOrgOsOrganizace to set
     */
    public void setWebOrgOsOrganizace(Organizace webOrgOsOrganizace) {
        this.webOrgOsOrganizace = webOrgOsOrganizace;
    }
    
}
