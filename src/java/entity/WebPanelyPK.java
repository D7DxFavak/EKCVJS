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
import javax.validation.constraints.Size;

/**
 *
 * @author 7Data Gotzy
 */
@Embeddable
public class WebPanelyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_panely_id")
    private int webPanelyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "web_panely_zalozka")
    private String webPanelyZalozka;

    public WebPanelyPK() {
    }

    public WebPanelyPK(int webPanelyId, String webPanelyZalozka) {
        this.webPanelyId = webPanelyId;
        this.webPanelyZalozka = webPanelyZalozka;
    }

    public int getWebPanelyId() {
        return webPanelyId;
    }

    public void setWebPanelyId(int webPanelyId) {
        this.webPanelyId = webPanelyId;
    }

    public String getWebPanelyZalozka() {
        return webPanelyZalozka;
    }

    public void setWebPanelyZalozka(String webPanelyZalozka) {
        this.webPanelyZalozka = webPanelyZalozka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webPanelyId;
        hash += (webPanelyZalozka != null ? webPanelyZalozka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebPanelyPK)) {
            return false;
        }
        WebPanelyPK other = (WebPanelyPK) object;
        if (this.webPanelyId != other.webPanelyId) {
            return false;
        }
        if ((this.webPanelyZalozka == null && other.webPanelyZalozka != null) || (this.webPanelyZalozka != null && !this.webPanelyZalozka.equals(other.webPanelyZalozka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebPanelyPK[ webPanelyId=" + webPanelyId + ", webPanelyZalozka=" + webPanelyZalozka + " ]";
    }
    
}
