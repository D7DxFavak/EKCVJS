/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Favak
 */
@Entity
@Table(name = "vazba_web_kategorie_uloziste_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaWebKategorieUlozisteData.findAll", query = "SELECT v FROM VazbaWebKategorieUlozisteData v"),
    @NamedQuery(name = "VazbaWebKategorieUlozisteData.findByVazbaWebKategorieUlozisteDataWebKategorieId", query = "SELECT v FROM VazbaWebKategorieUlozisteData v WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId"),
    @NamedQuery(name = "VazbaWebKategorieUlozisteData.findByVazbaWebKategorieUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaWebKategorieUlozisteData v WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataDataUlozisteId = :vazbaWebKategorieUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaWebKategorieUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaWebKategorieUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaWebKategorieUlozisteData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaWebKategorieUlozisteDataPK vazbaWebKategorieUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_web_kategorie_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_web_kategorie_uloziste_data_web_kategorie_id", referencedColumnName = "web_kategorie_zakladni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebKategorieZakladni webKategorieId;

    public VazbaWebKategorieUlozisteData() {
    }

    public VazbaWebKategorieUlozisteData(VazbaWebKategorieUlozisteDataPK vazbaWebKategorieUlozisteDataPK) {
        this.vazbaWebKategorieUlozisteDataPK = vazbaWebKategorieUlozisteDataPK;
    }

    public VazbaWebKategorieUlozisteData(int vazbaWebKategorieUlozisteDataWebKategorieId, int vazbaWebKategorieUlozisteDataDataUlozisteId) {
        this.vazbaWebKategorieUlozisteDataPK = new VazbaWebKategorieUlozisteDataPK(vazbaWebKategorieUlozisteDataWebKategorieId, vazbaWebKategorieUlozisteDataDataUlozisteId);
    }

    public VazbaWebKategorieUlozisteDataPK getVazbaWebKategorieUlozisteDataPK() {
        return vazbaWebKategorieUlozisteDataPK;
    }

    public void setVazbaWebKategorieUlozisteDataPK(VazbaWebKategorieUlozisteDataPK vazbaWebKategorieUlozisteDataPK) {
        this.vazbaWebKategorieUlozisteDataPK = vazbaWebKategorieUlozisteDataPK;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaWebKategorieUlozisteDataPK != null ? vazbaWebKategorieUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaWebKategorieUlozisteData)) {
            return false;
        }
        VazbaWebKategorieUlozisteData other = (VazbaWebKategorieUlozisteData) object;
        if ((this.vazbaWebKategorieUlozisteDataPK == null && other.vazbaWebKategorieUlozisteDataPK != null) || (this.vazbaWebKategorieUlozisteDataPK != null && !this.vazbaWebKategorieUlozisteDataPK.equals(other.vazbaWebKategorieUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaWebKategorieUlozisteData[ vazbaWebKategorieUlozisteDataPK=" + vazbaWebKategorieUlozisteDataPK + " ]";
    }

    /**
     * @return the ulozisteData
     */
    public UlozisteData getUlozisteData() {
        return ulozisteData;
    }

    /**
     * @param ulozisteData the ulozisteData to set
     */
    public void setUlozisteData(UlozisteData ulozisteData) {
        this.ulozisteData = ulozisteData;
    }

    /**
     * @return the webKategorieId
     */
    public WebKategorieZakladni getWebKategorieId() {
        return webKategorieId;
    }

    /**
     * @param webKategorieId the webKategorieId to set
     */
    public void setWebKategorieId(WebKategorieZakladni webKategorieId) {
        this.webKategorieId = webKategorieId;
    }
}
