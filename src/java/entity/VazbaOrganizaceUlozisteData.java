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
@Table(name = "vazba_organizace_uloziste_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VazbaOrganizaceUlozisteData.findAll", query = "SELECT v FROM VazbaOrganizaceUlozisteData v"),
    @NamedQuery(name = "VazbaOrganizaceUlozisteData.findByVazbaOrganizaceUlozisteDataOrganizaceId", query = "SELECT v FROM VazbaOrganizaceUlozisteData v WHERE v.vazbaOrganizaceUlozisteDataPK.vazbaOrganizaceUlozisteDataOrganizaceId = :vazbaOrganizaceUlozisteDataOrganizaceId"),
    @NamedQuery(name = "VazbaOrganizaceUlozisteData.findByVazbaOrganizaceUlozisteDataDataUlozisteId", query = "SELECT v FROM VazbaOrganizaceUlozisteData v WHERE v.vazbaOrganizaceUlozisteDataPK.vazbaOrganizaceUlozisteDataDataUlozisteId = :vazbaOrganizaceUlozisteDataDataUlozisteId"),
    @NamedQuery(name = "VazbaOrganizaceUlozisteData.findByPoznamky", query = "SELECT v FROM VazbaOrganizaceUlozisteData v WHERE v.poznamky = :poznamky")})
public class VazbaOrganizaceUlozisteData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazbaOrganizaceUlozisteDataPK vazbaOrganizaceUlozisteDataPK;
    @Size(max = 250)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "vazba_organizace_uloziste_data_data_uloziste_id", referencedColumnName = "uloziste_data_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UlozisteData ulozisteData;
    @JoinColumn(name = "vazba_organizace_uloziste_data_organizace_id", referencedColumnName = "organizace_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organizace organizace;

    public VazbaOrganizaceUlozisteData() {
    }

    public VazbaOrganizaceUlozisteData(VazbaOrganizaceUlozisteDataPK vazbaOrganizaceUlozisteDataPK) {
        this.vazbaOrganizaceUlozisteDataPK = vazbaOrganizaceUlozisteDataPK;
    }

    public VazbaOrganizaceUlozisteData(int vazbaOrganizaceUlozisteDataOrganizaceId, int vazbaOrganizaceUlozisteDataDataUlozisteId) {
        this.vazbaOrganizaceUlozisteDataPK = new VazbaOrganizaceUlozisteDataPK(vazbaOrganizaceUlozisteDataOrganizaceId, vazbaOrganizaceUlozisteDataDataUlozisteId);
    }

    public VazbaOrganizaceUlozisteDataPK getVazbaOrganizaceUlozisteDataPK() {
        return vazbaOrganizaceUlozisteDataPK;
    }

    public void setVazbaOrganizaceUlozisteDataPK(VazbaOrganizaceUlozisteDataPK vazbaOrganizaceUlozisteDataPK) {
        this.vazbaOrganizaceUlozisteDataPK = vazbaOrganizaceUlozisteDataPK;
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
        hash += (vazbaOrganizaceUlozisteDataPK != null ? vazbaOrganizaceUlozisteDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazbaOrganizaceUlozisteData)) {
            return false;
        }
        VazbaOrganizaceUlozisteData other = (VazbaOrganizaceUlozisteData) object;
        if ((this.vazbaOrganizaceUlozisteDataPK == null && other.vazbaOrganizaceUlozisteDataPK != null) || (this.vazbaOrganizaceUlozisteDataPK != null && !this.vazbaOrganizaceUlozisteDataPK.equals(other.vazbaOrganizaceUlozisteDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VazbaOrganizaceUlozisteData[ vazbaOrganizaceUlozisteDataPK=" + vazbaOrganizaceUlozisteDataPK + " ]";
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
     * @return the organizace
     */
    public Organizace getOrganizace() {
        return organizace;
    }

    /**
     * @param organizace the organizace to set
     */
    public void setOrganizace(Organizace organizace) {
        this.organizace = organizace;
    }
    
}
