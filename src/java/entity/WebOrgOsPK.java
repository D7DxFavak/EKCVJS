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
public class WebOrgOsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_org_os_osoba")
    private int webOrgOsOsoba;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_org_os_organizace")
    private int webOrgOsOrganizace;

    public WebOrgOsPK() {
    }

    public WebOrgOsPK(int webOrgOsOsoba, int webOrgOsOrganizace) {
        this.webOrgOsOsoba = webOrgOsOsoba;
        this.webOrgOsOrganizace = webOrgOsOrganizace;
    }

    public int getWebOrgOsOsoba() {
        return webOrgOsOsoba;
    }

    public void setWebOrgOsOsoba(int webOrgOsOsoba) {
        this.webOrgOsOsoba = webOrgOsOsoba;
    }

    public int getWebOrgOsOrganizace() {
        return webOrgOsOrganizace;
    }

    public void setWebOrgOsOrganizace(int webOrgOsOrganizace) {
        this.webOrgOsOrganizace = webOrgOsOrganizace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webOrgOsOsoba;
        hash += (int) webOrgOsOrganizace;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebOrgOsPK)) {
            return false;
        }
        WebOrgOsPK other = (WebOrgOsPK) object;
        if (this.webOrgOsOsoba != other.webOrgOsOsoba) {
            return false;
        }
        if (this.webOrgOsOrganizace != other.webOrgOsOrganizace) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebOrgOsPK[ webOrgOsOsoba=" + webOrgOsOsoba + ", webOrgOsOrganizace=" + webOrgOsOrganizace + " ]";
    }
    
}
