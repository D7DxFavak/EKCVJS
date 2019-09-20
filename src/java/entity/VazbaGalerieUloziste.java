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
@Table(name = "vazba_galerie_uloziste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaGalerieUloziste.findAll", query = "SELECT v FROM VazbaGalerieUloziste v"),
    @NamedQuery(name = "VazbaGalerieUloziste.findByVazbaGalerieUlozisteGalerie", query = "SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozistePK.vazbaGalerieUlozisteGalerie = :vazbaGalerieUlozisteGalerie"),
    @NamedQuery(name = "VazbaGalerieUloziste.findByVazbaGalerieUlozisteUloziste", query = "SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozistePK.vazbaGalerieUlozisteUloziste = :vazbaGalerieUlozisteUloziste"),
    @NamedQuery(name = "VazbaGalerieUloziste.findByVazbaGalerieUlozistePoradiVyber", query = "SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozistePoradiVyber = :vazbaGalerieUlozistePoradiVyber"),
    @NamedQuery(name = "VazbaGalerieUloziste.findByVazbaGalerieUlozistePoznamky", query = "SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozistePoznamky = :vazbaGalerieUlozistePoznamky"),
    @NamedQuery(name = "VazbaGalerieUloziste.findByVazbaGalerieUlozisteUvodni", query = "SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozisteUvodni = :vazbaGalerieUlozisteUvodni")})
public class VazbaGalerieUloziste implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaGalerieUlozistePK vazbaGalerieUlozistePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_galerie_uloziste_poradi_vyber")
    private int vazbaGalerieUlozistePoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "vazba_galerie_uloziste_poznamky")
    private String vazbaGalerieUlozistePoznamky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vazba_galerie_uloziste_uvodni")
    private boolean vazbaGalerieUlozisteUvodni;  
    @JoinColumn(name = "vazba_galerie_uloziste_uloziste", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData vazbaGalerieUlozisteUloziste;
    @JoinColumn(name = "vazba_galerie_uloziste_nahled", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData vazbaGalerieUlozisteNahled;
    @JoinColumn(name = "vazba_galerie_uloziste_galerie", referencedColumnName = "web_galerie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebGalerie webGalerie;

    public VazbaGalerieUloziste() {
    }

    public VazbaGalerieUloziste(VazbaGalerieUlozistePK vazbaGalerieUlozistePK) {
        this.vazbaGalerieUlozistePK = vazbaGalerieUlozistePK;
    }

    public VazbaGalerieUloziste(VazbaGalerieUlozistePK vazbaGalerieUlozistePK, int vazbaGalerieUlozistePoradiVyber, boolean vazbaGalerieUlozisteUvodni) {
        this.vazbaGalerieUlozistePK = vazbaGalerieUlozistePK;
        this.vazbaGalerieUlozistePoradiVyber = vazbaGalerieUlozistePoradiVyber;
        this.vazbaGalerieUlozisteUvodni = vazbaGalerieUlozisteUvodni;
    }

    public VazbaGalerieUloziste(int vazbaGalerieUlozisteGalerie, int vazbaGalerieUlozisteUloziste) {
        this.vazbaGalerieUlozistePK = new VazbaGalerieUlozistePK(vazbaGalerieUlozisteGalerie, vazbaGalerieUlozisteUloziste);
    }

    public VazbaGalerieUlozistePK getVazbaGalerieUlozistePK() {
        return vazbaGalerieUlozistePK;
    }

    public void setVazbaGalerieUlozistePK(VazbaGalerieUlozistePK vazbaGalerieUlozistePK) {
        this.vazbaGalerieUlozistePK = vazbaGalerieUlozistePK;
    }

    public int getVazbaGalerieUlozistePoradiVyber() {
        return vazbaGalerieUlozistePoradiVyber;
    }

    public void setVazbaGalerieUlozistePoradiVyber(int vazbaGalerieUlozistePoradiVyber) {
        this.vazbaGalerieUlozistePoradiVyber = vazbaGalerieUlozistePoradiVyber;
    }

    public String getVazbaGalerieUlozistePoznamky() {
        return vazbaGalerieUlozistePoznamky;
    }

    public void setVazbaGalerieUlozistePoznamky(String vazbaGalerieUlozistePoznamky) {
        this.vazbaGalerieUlozistePoznamky = vazbaGalerieUlozistePoznamky;
    }

    public boolean getVazbaGalerieUlozisteUvodni() {
        return isVazbaGalerieUlozisteUvodni();
    }

    public void setVazbaGalerieUlozisteUvodni(boolean vazbaGalerieUlozisteUvodni) {
        this.vazbaGalerieUlozisteUvodni = vazbaGalerieUlozisteUvodni;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaGalerieUlozistePK != null ? vazbaGalerieUlozistePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaGalerieUloziste)) {
            return false;
        }
        VazbaGalerieUloziste other = (VazbaGalerieUloziste) object;
        if ((this.vazbaGalerieUlozistePK == null && other.vazbaGalerieUlozistePK != null) || (this.vazbaGalerieUlozistePK != null && !this.vazbaGalerieUlozistePK.equals(other.vazbaGalerieUlozistePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaGalerieUloziste[ vazbaGalerieUlozistePK=" + vazbaGalerieUlozistePK + " ]";
    }

    /**
     * @return the vazbaGalerieUlozisteUvodni
     */
    public boolean isVazbaGalerieUlozisteUvodni() {
        return vazbaGalerieUlozisteUvodni;
    }

    /**
     * @return the vazbaGalerieUlozisteUloziste
     */
    public UlozisteData getVazbaGalerieUlozisteUloziste() {
        return vazbaGalerieUlozisteUloziste;
    }

    /**
     * @param vazbaGalerieUlozisteUloziste the vazbaGalerieUlozisteUloziste to set
     */
    public void setVazbaGalerieUlozisteUloziste(UlozisteData vazbaGalerieUlozisteUloziste) {
        this.vazbaGalerieUlozisteUloziste = vazbaGalerieUlozisteUloziste;
    }

    /**
     * @return the webGalerie
     */
    public WebGalerie getWebGalerie() {
        return webGalerie;
    }

    /**
     * @param webGalerie the webGalerie to set
     */
    public void setWebGalerie(WebGalerie webGalerie) {
        this.webGalerie = webGalerie;
    }

    /**
     * @return the vazbaGalerieUlozisteNahled
     */
    public UlozisteData getVazbaGalerieUlozisteNahled() {
        return vazbaGalerieUlozisteNahled;
    }

    /**
     * @param vazbaGalerieUlozisteNahled the vazbaGalerieUlozisteNahled to set
     */
    public void setVazbaGalerieUlozisteNahled(UlozisteData vazbaGalerieUlozisteNahled) {
        this.vazbaGalerieUlozisteNahled = vazbaGalerieUlozisteNahled;
    }
    
}
