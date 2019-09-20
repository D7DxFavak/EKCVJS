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
@Table(name = "vazba_prihlasky_uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaPrihlaskyUlozisteData.findAll", query = "SELECT v FROM VazbaPrihlaskyUlozisteData v"),
    @NamedQuery(name = "VazbaPrihlaskyUlozisteData.findByVazbaPrihlaskyUlozisteDataPrihlaskyId", query = "SELECT v FROM VazbaPrihlaskyUlozisteData v WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataPrihlaskyId = :vazbaPrihlaskyUlozisteDataPrihlaskyId"),
    @NamedQuery(name = "VazbaPrihlaskyUlozisteData.findByVazbaPrihlaskyUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaPrihlaskyUlozisteData v WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataDataUlozisteId = :vazbaPrihlaskyUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaPrihlaskyUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaPrihlaskyUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaPrihlaskyUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaPrihlaskyUlozisteDataPK vazbaPrihlaskyUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_prihlasky_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_prihlasky_uloziste_data_prihlasky_id", referencedColumnName = "polozka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrihlaskyRozpisy prihlaskyRozpisy;

    public VazbaPrihlaskyUlozisteData() {
    }

    public VazbaPrihlaskyUlozisteData(VazbaPrihlaskyUlozisteDataPK vazbaPrihlaskyUlozisteDataPK) {
        this.vazbaPrihlaskyUlozisteDataPK = vazbaPrihlaskyUlozisteDataPK;
    }

    public VazbaPrihlaskyUlozisteData(int vazbaPrihlaskyUlozisteDataPrihlaskyId, int vazbaPrihlaskyUlozisteDataDataUlozisteId) {
        this.vazbaPrihlaskyUlozisteDataPK = new VazbaPrihlaskyUlozisteDataPK(vazbaPrihlaskyUlozisteDataPrihlaskyId, vazbaPrihlaskyUlozisteDataDataUlozisteId);
    }

    public VazbaPrihlaskyUlozisteDataPK getVazbaPrihlaskyUlozisteDataPK() {
        return vazbaPrihlaskyUlozisteDataPK;
    }

    public void setVazbaPrihlaskyUlozisteDataPK(VazbaPrihlaskyUlozisteDataPK vazbaPrihlaskyUlozisteDataPK) {
        this.vazbaPrihlaskyUlozisteDataPK = vazbaPrihlaskyUlozisteDataPK;
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

    public PrihlaskyRozpisy getPrihlaskyRozpisy() {
        return prihlaskyRozpisy;
    }

    public void setPrihlaskyRozpisy(PrihlaskyRozpisy prihlaskyRozpisy) {
        this.prihlaskyRozpisy = prihlaskyRozpisy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaPrihlaskyUlozisteDataPK != null ? vazbaPrihlaskyUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaPrihlaskyUlozisteData)) {
            return false;
        }
        VazbaPrihlaskyUlozisteData other = (VazbaPrihlaskyUlozisteData) object;
        if ((this.vazbaPrihlaskyUlozisteDataPK == null && other.vazbaPrihlaskyUlozisteDataPK != null) || (this.vazbaPrihlaskyUlozisteDataPK != null && !this.vazbaPrihlaskyUlozisteDataPK.equals(other.vazbaPrihlaskyUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaPrihlaskyUlozisteData[ vazbaPrihlaskyUlozisteDataPK=" + vazbaPrihlaskyUlozisteDataPK + " ]";
    }
    
}
