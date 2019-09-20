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
public class WebVazbaKategorieAkceHlavniPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_vazba_kategorie_akce_hlavni_kategorie_id")
    private int webVazbaKategorieAkceHlavniKategorieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web_vazba_kategorie_akce_hlavni_akce_id")
    private int webVazbaKategorieAkceHlavniAkceId;

    public WebVazbaKategorieAkceHlavniPK() {
    }

    public WebVazbaKategorieAkceHlavniPK(int webVazbaKategorieAkceHlavniKategorieId, int webVazbaKategorieAkceHlavniAkceId) {
        this.webVazbaKategorieAkceHlavniKategorieId = webVazbaKategorieAkceHlavniKategorieId;
        this.webVazbaKategorieAkceHlavniAkceId = webVazbaKategorieAkceHlavniAkceId;
    }

    public int getWebVazbaKategorieAkceHlavniKategorieId() {
        return webVazbaKategorieAkceHlavniKategorieId;
    }

    public void setWebVazbaKategorieAkceHlavniKategorieId(int webVazbaKategorieAkceHlavniKategorieId) {
        this.webVazbaKategorieAkceHlavniKategorieId = webVazbaKategorieAkceHlavniKategorieId;
    }

    public int getWebVazbaKategorieAkceHlavniAkceId() {
        return webVazbaKategorieAkceHlavniAkceId;
    }

    public void setWebVazbaKategorieAkceHlavniAkceId(int webVazbaKategorieAkceHlavniAkceId) {
        this.webVazbaKategorieAkceHlavniAkceId = webVazbaKategorieAkceHlavniAkceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webVazbaKategorieAkceHlavniKategorieId;
        hash += (int) webVazbaKategorieAkceHlavniAkceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebVazbaKategorieAkceHlavniPK)) {
            return false;
        }
        WebVazbaKategorieAkceHlavniPK other = (WebVazbaKategorieAkceHlavniPK) object;
        if (this.webVazbaKategorieAkceHlavniKategorieId != other.webVazbaKategorieAkceHlavniKategorieId) {
            return false;
        }
        if (this.webVazbaKategorieAkceHlavniAkceId != other.webVazbaKategorieAkceHlavniAkceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebVazbaKategorieAkceHlavniPK[ webVazbaKategorieAkceHlavniKategorieId=" + webVazbaKategorieAkceHlavniKategorieId + ", webVazbaKategorieAkceHlavniAkceId=" + webVazbaKategorieAkceHlavniAkceId + " ]";
    }
    
}
