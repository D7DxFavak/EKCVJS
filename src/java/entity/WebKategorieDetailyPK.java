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
public class WebKategorieDetailyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_kategorie_detaily_id")
    private int webKategorieDetailyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_kategorie_detaily_kategorie")
    private int webKategorieDetailyKategorie;

    public WebKategorieDetailyPK() {
    }

    public WebKategorieDetailyPK(int webKategorieDetailyId, int webKategorieDetailyKategorie) {
        this.webKategorieDetailyId = webKategorieDetailyId;
        this.webKategorieDetailyKategorie = webKategorieDetailyKategorie;
    }

    public int getWebKategorieDetailyId() {
        return webKategorieDetailyId;
    }

    public void setWebKategorieDetailyId(int webKategorieDetailyId) {
        this.webKategorieDetailyId = webKategorieDetailyId;
    }

    public int getWebKategorieDetailyKategorie() {
        return webKategorieDetailyKategorie;
    }

    public void setWebKategorieDetailyKategorie(int webKategorieDetailyKategorie) {
        this.webKategorieDetailyKategorie = webKategorieDetailyKategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webKategorieDetailyId;
        hash += (int) webKategorieDetailyKategorie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebKategorieDetailyPK)) {
            return false;
        }
        WebKategorieDetailyPK other = (WebKategorieDetailyPK) object;
        if (this.webKategorieDetailyId != other.webKategorieDetailyId) {
            return false;
        }
        if (this.webKategorieDetailyKategorie != other.webKategorieDetailyKategorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebKategorieDetailyPK[ webKategorieDetailyId=" + webKategorieDetailyId + ", webKategorieDetailyKategorie=" + webKategorieDetailyKategorie + " ]";
    }
    
}
