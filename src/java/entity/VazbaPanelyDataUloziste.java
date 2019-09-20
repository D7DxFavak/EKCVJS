/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Favak
 */
@Entity
@Table(name = "vazba_panely_data_uloziste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaPanelyDataUloziste.findAll", query = "SELECT v FROM VazbaPanelyDataUloziste v"),
    @NamedQuery(name = "VazbaPanelyDataUloziste.findByVazbaPanelyDataUlozistePanelData", query = "SELECT v FROM VazbaPanelyDataUloziste v WHERE v.vazbaPanelyDataUlozistePK.vazbaPanelyDataUlozistePanelData = :vazbaPanelyDataUlozistePanelData"),
    @NamedQuery(name = "VazbaPanelyDataUloziste.findByVazbaPanelyDataUlozisteUloziste", query = "SELECT v FROM VazbaPanelyDataUloziste v WHERE v.vazbaPanelyDataUlozistePK.vazbaPanelyDataUlozisteUloziste = :vazbaPanelyDataUlozisteUloziste"),
    @NamedQuery(name = "VazbaPanelyDataUloziste.findByVazbaPanelyDataUlozistePoradiVyber", query = "SELECT v FROM VazbaPanelyDataUloziste v WHERE v.vazbaPanelyDataUlozistePoradiVyber = :vazbaPanelyDataUlozistePoradiVyber"),
    @NamedQuery(name = "VazbaPanelyDataUloziste.findByVazbaPanelyDataUlozistePoznamky", query = "SELECT v FROM VazbaPanelyDataUloziste v WHERE v.vazbaPanelyDataUlozistePoznamky = :vazbaPanelyDataUlozistePoznamky")})
public class VazbaPanelyDataUloziste implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaPanelyDataUlozistePK vazbaPanelyDataUlozistePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_panely_data_uloziste_poradi_vyber")
    private int vazbaPanelyDataUlozistePoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "vazba_panely_data_uloziste_poznamky")
    private String vazbaPanelyDataUlozistePoznamky;
    @JoinColumn(name = "vazba_panely_data_uloziste_uloziste", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_panely_data_uloziste_panel_data", referencedColumnName = "web_panely_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebPanelyData webPanelyData;

    public VazbaPanelyDataUloziste() {
    }

    public VazbaPanelyDataUloziste(VazbaPanelyDataUlozistePK vazbaPanelyDataUlozistePK) {
        this.vazbaPanelyDataUlozistePK = vazbaPanelyDataUlozistePK;
    }

    public VazbaPanelyDataUloziste(VazbaPanelyDataUlozistePK vazbaPanelyDataUlozistePK, int vazbaPanelyDataUlozistePoradiVyber) {
        this.vazbaPanelyDataUlozistePK = vazbaPanelyDataUlozistePK;
        this.vazbaPanelyDataUlozistePoradiVyber = vazbaPanelyDataUlozistePoradiVyber;
    }

    public VazbaPanelyDataUloziste(int vazbaPanelyDataUlozistePanelData, int vazbaPanelyDataUlozisteUloziste) {
        this.vazbaPanelyDataUlozistePK = new VazbaPanelyDataUlozistePK(vazbaPanelyDataUlozistePanelData, vazbaPanelyDataUlozisteUloziste);
    }

    public VazbaPanelyDataUlozistePK getVazbaPanelyDataUlozistePK() {
        return vazbaPanelyDataUlozistePK;
    }

    public void setVazbaPanelyDataUlozistePK(VazbaPanelyDataUlozistePK vazbaPanelyDataUlozistePK) {
        this.vazbaPanelyDataUlozistePK = vazbaPanelyDataUlozistePK;
    }

    public int getVazbaPanelyDataUlozistePoradiVyber() {
        return vazbaPanelyDataUlozistePoradiVyber;
    }

    public void setVazbaPanelyDataUlozistePoradiVyber(int vazbaPanelyDataUlozistePoradiVyber) {
        this.vazbaPanelyDataUlozistePoradiVyber = vazbaPanelyDataUlozistePoradiVyber;
    }

    public String getVazbaPanelyDataUlozistePoznamky() {
        return vazbaPanelyDataUlozistePoznamky;
    }

    public void setVazbaPanelyDataUlozistePoznamky(String vazbaPanelyDataUlozistePoznamky) {
        this.vazbaPanelyDataUlozistePoznamky = vazbaPanelyDataUlozistePoznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaPanelyDataUlozistePK != null ? vazbaPanelyDataUlozistePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaPanelyDataUloziste)) {
            return false;
        }
        VazbaPanelyDataUloziste other = (VazbaPanelyDataUloziste) object;
        if ((this.vazbaPanelyDataUlozistePK == null && other.vazbaPanelyDataUlozistePK != null) || (this.vazbaPanelyDataUlozistePK != null && !this.vazbaPanelyDataUlozistePK.equals(other.vazbaPanelyDataUlozistePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaPanelyDataUloziste[ vazbaPanelyDataUlozistePK=" + vazbaPanelyDataUlozistePK + " ]";
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
     * @return the webPanelyData
     */
    public WebPanelyData getWebPanelyData() {
        return webPanelyData;
    }

    /**
     * @param webPanelyData the webPanelyData to set
     */
    public void setWebPanelyData(WebPanelyData webPanelyData) {
        this.webPanelyData = webPanelyData;
    }
    
}
