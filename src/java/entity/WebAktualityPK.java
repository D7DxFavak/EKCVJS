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
public class WebAktualityPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_aktuality_id")
    private int webAktualityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_aktuality_kategorie")
    private int webAktualityKategorie;

    public WebAktualityPK() {
    }

    public WebAktualityPK(int webAktualityId, int webAktualityKategorie) {
        this.webAktualityId = webAktualityId;
        this.webAktualityKategorie = webAktualityKategorie;
    }

    public int getWebAktualityId() {
        return webAktualityId;
    }

    public void setWebAktualityId(int webAktualityId) {
        this.webAktualityId = webAktualityId;
    }

    public int getWebAktualityKategorie() {
        return webAktualityKategorie;
    }

    public void setWebAktualityKategorie(int webAktualityKategorie) {
        this.webAktualityKategorie = webAktualityKategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webAktualityId;
        hash += (int) webAktualityKategorie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebAktualityPK)) {
            return false;
        }
        WebAktualityPK other = (WebAktualityPK) object;
        if (this.webAktualityId != other.webAktualityId) {
            return false;
        }
        if (this.webAktualityKategorie != other.webAktualityKategorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebAktualityPK[ webAktualityId=" + webAktualityId + ", webAktualityKategorie=" + webAktualityKategorie + " ]";
    }
    
}
