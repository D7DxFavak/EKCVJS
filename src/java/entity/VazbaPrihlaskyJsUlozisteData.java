/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "vazba_prihlasky_js_uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaPrihlaskyJsUlozisteData.findAll", query = "SELECT v FROM VazbaPrihlaskyJsUlozisteData v"),
    @NamedQuery(name = "VazbaPrihlaskyJsUlozisteData.findByVazbaPrihlaskyJsUlozisteDataPrihlaskyId", query = "SELECT v FROM VazbaPrihlaskyJsUlozisteData v WHERE v.vazbaPrihlaskyJsUlozisteDataPK.vazbaPrihlaskyJsUlozisteDataPrihlaskyId = :vazbaPrihlaskyJsUlozisteDataPrihlaskyId"),
    @NamedQuery(name = "VazbaPrihlaskyJsUlozisteData.findByVazbaPrihlaskyJsUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaPrihlaskyJsUlozisteData v WHERE v.vazbaPrihlaskyJsUlozisteDataPK.vazbaPrihlaskyJsUlozisteDataDataUlozisteId = :vazbaPrihlaskyJsUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaPrihlaskyJsUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaPrihlaskyJsUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaPrihlaskyJsUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaPrihlaskyJsUlozisteDataPK vazbaPrihlaskyJsUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_prihlasky_js_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_prihlasky_js_uloziste_data_prihlasky_id", referencedColumnName = "polozka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrihlaskyRozpisyJs prihlaskyRozpisyJs;

    public VazbaPrihlaskyJsUlozisteData() {
    }

    public VazbaPrihlaskyJsUlozisteData(VazbaPrihlaskyJsUlozisteDataPK vazbaPrihlaskyJsUlozisteDataPK) {
        this.vazbaPrihlaskyJsUlozisteDataPK = vazbaPrihlaskyJsUlozisteDataPK;
    }

    public VazbaPrihlaskyJsUlozisteData(int vazbaPrihlaskyJsUlozisteDataPrihlaskyId, int vazbaPrihlaskyJsUlozisteDataDataUlozisteId) {
        this.vazbaPrihlaskyJsUlozisteDataPK = new VazbaPrihlaskyJsUlozisteDataPK(vazbaPrihlaskyJsUlozisteDataPrihlaskyId, vazbaPrihlaskyJsUlozisteDataDataUlozisteId);
    }

    public VazbaPrihlaskyJsUlozisteDataPK getVazbaPrihlaskyJsUlozisteDataPK() {
        return vazbaPrihlaskyJsUlozisteDataPK;
    }

    public void setVazbaPrihlaskyJsUlozisteDataPK(VazbaPrihlaskyJsUlozisteDataPK vazbaPrihlaskyJsUlozisteDataPK) {
        this.vazbaPrihlaskyJsUlozisteDataPK = vazbaPrihlaskyJsUlozisteDataPK;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public UlozisteData getUlozisteData() {
        return ulozisteData;
    }

    public void setUlozisteData(UlozisteData ulozisteData) {
        this.ulozisteData = ulozisteData;
    }

    public PrihlaskyRozpisyJs getPrihlaskyRozpisyJs() {
        return prihlaskyRozpisyJs;
    }

    public void setPrihlaskyRozpisyJs(PrihlaskyRozpisyJs prihlaskyRozpisyJs) {
        this.prihlaskyRozpisyJs = prihlaskyRozpisyJs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaPrihlaskyJsUlozisteDataPK != null ? vazbaPrihlaskyJsUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaPrihlaskyJsUlozisteData)) {
            return false;
        }
        VazbaPrihlaskyJsUlozisteData other = (VazbaPrihlaskyJsUlozisteData) object;
        if ((this.vazbaPrihlaskyJsUlozisteDataPK == null && other.vazbaPrihlaskyJsUlozisteDataPK != null) || (this.vazbaPrihlaskyJsUlozisteDataPK != null && !this.vazbaPrihlaskyJsUlozisteDataPK.equals(other.vazbaPrihlaskyJsUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaPrihlaskyJsUlozisteData[ vazbaPrihlaskyJsUlozisteDataPK=" + vazbaPrihlaskyJsUlozisteDataPK + " ]";
    }
    
}
