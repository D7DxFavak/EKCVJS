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
import javax.persistence.JoinColumns;
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
@Table(name = "vazba_akreditace_uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaAkreditaceUlozisteData.findAll", query = "SELECT v FROM VazbaAkreditaceUlozisteData v"),
    @NamedQuery(name = "VazbaAkreditaceUlozisteData.findByVazbaOsobyUlozisteDataAkreditaceId", query = "SELECT v FROM VazbaAkreditaceUlozisteData v WHERE v.vazbaAkreditaceUlozisteDataPK.vazbaOsobyUlozisteDataAkreditaceId = :vazbaOsobyUlozisteDataAkreditaceId"),
    @NamedQuery(name = "VazbaAkreditaceUlozisteData.findByVazbaOsobyUlozisteDataAkreditacePoradiId", query = "SELECT v FROM VazbaAkreditaceUlozisteData v WHERE v.vazbaAkreditaceUlozisteDataPK.vazbaOsobyUlozisteDataAkreditacePoradiId = :vazbaOsobyUlozisteDataAkreditacePoradiId"),
    @NamedQuery(name = "VazbaAkreditaceUlozisteData.findByVazbaOsobyUlozisteDataAkreditaceUlozisteId", query = "SELECT v FROM VazbaAkreditaceUlozisteData v WHERE v.vazbaAkreditaceUlozisteDataPK.vazbaOsobyUlozisteDataAkreditaceUlozisteId = :vazbaOsobyUlozisteDataAkreditaceUlozisteId"),
    @NamedQuery(name = "VazbaAkreditaceUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaAkreditaceUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaAkreditaceUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaAkreditaceUlozisteDataPK vazbaAkreditaceUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_osoby_uloziste_data_akreditace_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumns({
        @JoinColumn(name = "vazba_osoby_uloziste_data_akreditace_id", referencedColumnName = "akreditace_id", insertable = false, updatable = false),
        @JoinColumn(name = "vazba_osoby_uloziste_data_akreditace_poradi_id", referencedColumnName = "akreditace_poradi", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AkreditaceHlavni akreditaceHlavni;

    public VazbaAkreditaceUlozisteData() {
    }

    public VazbaAkreditaceUlozisteData(VazbaAkreditaceUlozisteDataPK vazbaAkreditaceUlozisteDataPK) {
        this.vazbaAkreditaceUlozisteDataPK = vazbaAkreditaceUlozisteDataPK;
    }

    public VazbaAkreditaceUlozisteData(int vazbaOsobyUlozisteDataAkreditaceId, int vazbaOsobyUlozisteDataAkreditacePoradiId, int vazbaOsobyUlozisteDataAkreditaceUlozisteId) {
        this.vazbaAkreditaceUlozisteDataPK = new VazbaAkreditaceUlozisteDataPK(vazbaOsobyUlozisteDataAkreditaceId, vazbaOsobyUlozisteDataAkreditacePoradiId, vazbaOsobyUlozisteDataAkreditaceUlozisteId);
    }

    public VazbaAkreditaceUlozisteDataPK getVazbaAkreditaceUlozisteDataPK() {
        return vazbaAkreditaceUlozisteDataPK;
    }

    public void setVazbaAkreditaceUlozisteDataPK(VazbaAkreditaceUlozisteDataPK vazbaAkreditaceUlozisteDataPK) {
        this.vazbaAkreditaceUlozisteDataPK = vazbaAkreditaceUlozisteDataPK;
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

    public AkreditaceHlavni getAkreditaceHlavni() {
        return akreditaceHlavni;
    }

    public void setAkreditaceHlavni(AkreditaceHlavni akreditaceHlavni) {
        this.akreditaceHlavni = akreditaceHlavni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazbaAkreditaceUlozisteDataPK != null ? vazbaAkreditaceUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaAkreditaceUlozisteData)) {
            return false;
        }
        VazbaAkreditaceUlozisteData other = (VazbaAkreditaceUlozisteData) object;
        if ((this.vazbaAkreditaceUlozisteDataPK == null && other.vazbaAkreditaceUlozisteDataPK != null) || (this.vazbaAkreditaceUlozisteDataPK != null && !this.vazbaAkreditaceUlozisteDataPK.equals(other.vazbaAkreditaceUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaAkreditaceUlozisteData[ vazbaAkreditaceUlozisteDataPK=" + vazbaAkreditaceUlozisteDataPK + " ]";
    }
    
}
