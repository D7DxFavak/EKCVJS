/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "druhy_export", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DruhyExport.findAll", query = "SELECT d FROM DruhyExport d"),
    @NamedQuery(name = "DruhyExport.findByDruhyExportId", query = "SELECT d FROM DruhyExport d WHERE d.druhyExportId = :druhyExportId"),
    @NamedQuery(name = "DruhyExport.findByDruhyExportNazev", query = "SELECT d FROM DruhyExport d WHERE d.druhyExportNazev = :druhyExportNazev"),
    @NamedQuery(name = "DruhyExport.findByDruhyExportPopis", query = "SELECT d FROM DruhyExport d WHERE d.druhyExportPopis = :druhyExportPopis"),
    @NamedQuery(name = "DruhyExport.findByDruhyExportPoradiVyber", query = "SELECT d FROM DruhyExport d WHERE d.druhyExportPoradiVyber = :druhyExportPoradiVyber")})
public class DruhyExport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "druhy_export_id")
    private Integer druhyExportId;
    @Size(max = 250)
    @Column(name = "druhy_export_nazev")
    private String druhyExportNazev;
    @Size(max = 2147483647)
    @Column(name = "druhy_export_popis")
    private String druhyExportPopis;
    @Column(name = "druhy_export_poradi_vyber")
    private Integer druhyExportPoradiVyber;

    public DruhyExport() {
    }

    public DruhyExport(Integer druhyExportId) {
        this.druhyExportId = druhyExportId;
    }

    public Integer getDruhyExportId() {
        return druhyExportId;
    }

    public void setDruhyExportId(Integer druhyExportId) {
        this.druhyExportId = druhyExportId;
    }

    public String getDruhyExportNazev() {
        return druhyExportNazev;
    }

    public void setDruhyExportNazev(String druhyExportNazev) {
        this.druhyExportNazev = druhyExportNazev;
    }

    public String getDruhyExportPopis() {
        return druhyExportPopis;
    }

    public void setDruhyExportPopis(String druhyExportPopis) {
        this.druhyExportPopis = druhyExportPopis;
    }

    public Integer getDruhyExportPoradiVyber() {
        return druhyExportPoradiVyber;
    }

    public void setDruhyExportPoradiVyber(Integer druhyExportPoradiVyber) {
        this.druhyExportPoradiVyber = druhyExportPoradiVyber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (druhyExportId != null ? druhyExportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DruhyExport)) {
            return false;
        }
        DruhyExport other = (DruhyExport) object;
        if ((this.druhyExportId == null && other.druhyExportId != null) || (this.druhyExportId != null && !this.druhyExportId.equals(other.druhyExportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DruhyExport[ druhyExportId=" + druhyExportId + " ]";
    }
    
}
