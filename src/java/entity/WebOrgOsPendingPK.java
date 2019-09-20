/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 7Data Gotzy
 */
@Embeddable
public class WebOrgOsPendingPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_org_os_pending_osoba")
    private int webOrgOsPendingOsoba;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_org_os_pending_organizace")
    private int webOrgOsPendingOrganizace;

    public WebOrgOsPendingPK() {
    }

    public WebOrgOsPendingPK(int webOrgOsOsoba, int webOrgOsOrganizace) {
        this.webOrgOsPendingOsoba = webOrgOsOsoba;
        this.webOrgOsPendingOrganizace = webOrgOsOrganizace;
    }

    public int getWebOrgOsOsoba() {
        return webOrgOsPendingOsoba;
    }

    public void setWebOrgOsOsoba(int webOrgOsOsoba) {
        this.webOrgOsPendingOsoba = webOrgOsOsoba;
    }

    public int getWebOrgOsOrganizace() {
        return webOrgOsPendingOrganizace;
    }

    public void setWebOrgOsOrganizace(int webOrgOsOrganizace) {
        this.webOrgOsPendingOrganizace = webOrgOsOrganizace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webOrgOsPendingOsoba;
        hash += (int) webOrgOsPendingOrganizace;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOrgOsPendingPK)) {
            return false;
        }
        WebOrgOsPendingPK other = (WebOrgOsPendingPK) object;
        if (this.webOrgOsPendingOsoba != other.webOrgOsPendingOsoba) {
            return false;
        }
        if (this.webOrgOsPendingOrganizace != other.webOrgOsPendingOrganizace) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOrgOsPendingPK[ webOrgOsPendingOsoba=" + webOrgOsPendingOsoba + ", webOrgOsPendingOrganizace=" + webOrgOsPendingOrganizace + " ]";
    }
    
}
