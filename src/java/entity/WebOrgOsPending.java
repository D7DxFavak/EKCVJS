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
@Table(name = "web_org_os_pending")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebOrgOsPending.findAll", query = "SELECT w FROM WebOrgOsPending w"),
    @NamedQuery(name = "WebOrgOsPending.findByWebOrgOsPendingOsoba", query = "SELECT w FROM WebOrgOsPending w WHERE w.webOrgOsPendingPK.webOrgOsPendingOsoba = :webOrgOsPendingOsoba"),
    @NamedQuery(name = "WebOrgOsPending.findByWebOrgOsPendingOrganizace", query = "SELECT w FROM WebOrgOsPending w WHERE w.webOrgOsPendingPK.webOrgOsPendingOrganizace = :webOrgOsPendingOrganizace ORDER BY w.webOrgOsPendingOsoba.prijmeni"),
    @NamedQuery(name = "WebOrgOsPending.findByWebOrgOsPendingDatumVlozeni", query = "SELECT w FROM WebOrgOsPending w WHERE w.webOrgOsPendingDatumVlozeni = :webOrgOsPendingDatumVlozeni"),
    @NamedQuery(name = "WebOrgOsPending.findByWebOrgOsPendingPoznamka", query = "SELECT w FROM WebOrgOsPending w WHERE w.webOrgOsPendingPoznamka = :webOrgOsPendingPoznamka"),
    @NamedQuery(name = "WebOrgOsPending.findByWebOrgOsPendingAktivni", query = "SELECT w FROM WebOrgOsPending w WHERE w.webOrgOsPendingAktivni = :webOrgOsPendingAktivni")})
public class WebOrgOsPending implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebOrgOsPendingPK webOrgOsPendingPK;
    @Column(name = "web_org_os_pending_datum_vlozeni")
    @Temporal(TemporalType.DATE)
    private Date webOrgOsPendingDatumVlozeni;
    @Size(max = 500)
    @Column(name = "web_org_os_pending_poznamka")
    private String webOrgOsPendingPoznamka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_org_os_pending_aktivni")
    private boolean webOrgOsPendingAktivni;
    @JoinColumn(name = "web_org_os_pending_osoba", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne
    private Osoby webOrgOsPendingOsoba;
    @JoinColumn(name = "web_org_os_pending_organizace", referencedColumnName = "organizace_id", insertable = false, updatable = false)
    @ManyToOne
    private Organizace webOrgOsPendingOrganizace;
    public WebOrgOsPending() {
    }

    public WebOrgOsPending(WebOrgOsPendingPK webOrgOsPK) {
        this.webOrgOsPendingPK = webOrgOsPK;
    }

    public WebOrgOsPending(WebOrgOsPendingPK webOrgOsPK, boolean webOrgOsAktivni) {
        this.webOrgOsPendingPK = webOrgOsPK;
        this.webOrgOsPendingAktivni = webOrgOsAktivni;
    }

    public WebOrgOsPending(int webOrgOsOsoba, int webOrgOsOrganizace) {
        this.webOrgOsPendingPK = new WebOrgOsPendingPK(webOrgOsOsoba, webOrgOsOrganizace);
    }

    public WebOrgOsPendingPK getWebOrgOsPK() {
        return webOrgOsPendingPK;
    }

    public void setWebOrgOsPK(WebOrgOsPendingPK webOrgOsPK) {
        this.webOrgOsPendingPK = webOrgOsPK;
    }

    public Date getWebOrgOsDatumVlozeni() {
        return webOrgOsPendingDatumVlozeni;
    }

    public void setWebOrgOsDatumVlozeni(Date webOrgOsDatumVlozeni) {
        this.webOrgOsPendingDatumVlozeni = webOrgOsDatumVlozeni;
    }

    public String getWebOrgOsPoznamka() {
        return webOrgOsPendingPoznamka;
    }

    public void setWebOrgOsPoznamka(String webOrgOsPoznamka) {
        this.webOrgOsPendingPoznamka = webOrgOsPoznamka;
    }

    public boolean getWebOrgOsAktivni() {
        return isWebOrgOsAktivni();
    }

    public void setWebOrgOsAktivni(boolean webOrgOsAktivni) {
        this.webOrgOsPendingAktivni = webOrgOsAktivni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webOrgOsPendingPK != null ? webOrgOsPendingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOrgOsPending)) {
            return false;
        }
        WebOrgOsPending other = (WebOrgOsPending) object;
        if ((this.webOrgOsPendingPK == null && other.webOrgOsPendingPK != null) || (this.webOrgOsPendingPK != null && !this.webOrgOsPendingPK.equals(other.webOrgOsPendingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOrgOsPending[ webOrgOsPendingPK=" + webOrgOsPendingPK + " ]";
    }

    /**
     * @return the webOrgOsAktivni
     */
    public boolean isWebOrgOsAktivni() {
        return webOrgOsPendingAktivni;
    }

    /**
     * @return the webOrgOsOsoba
     */
    public Osoby getWebOrgOsOsoba() {
        return webOrgOsPendingOsoba;
    }

    /**
     * @param webOrgOsOsoba the webOrgOsOsoba to set
     */
    public void setWebOrgOsOsoba(Osoby webOrgOsOsoba) {
        this.webOrgOsPendingOsoba = webOrgOsOsoba;
    }

    /**
     * @return the webOrgOsOrganizace
     */
    public Organizace getWebOrgOsOrganizace() {
        return webOrgOsPendingOrganizace;
    }

    /**
     * @param webOrgOsOrganizace the webOrgOsOrganizace to set
     */
    public void setWebOrgOsOrganizace(Organizace webOrgOsOrganizace) {
        this.webOrgOsPendingOrganizace = webOrgOsOrganizace;
    }
    
}
