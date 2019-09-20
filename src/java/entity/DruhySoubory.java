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
@Table(name = "druhy_soubory", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DruhySoubory.findAll", query = "SELECT d FROM DruhySoubory d"),
    @NamedQuery(name = "DruhySoubory.findByDruhySouboryId", query = "SELECT d FROM DruhySoubory d WHERE d.druhySouboryId = :druhySouboryId"),
    @NamedQuery(name = "DruhySoubory.findByDruhySouboryNazev", query = "SELECT d FROM DruhySoubory d WHERE d.druhySouboryNazev = :druhySouboryNazev"),
    @NamedQuery(name = "DruhySoubory.findByDruhySouboryPoznamky", query = "SELECT d FROM DruhySoubory d WHERE d.druhySouboryPoznamky = :druhySouboryPoznamky")})
public class DruhySoubory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "druhy_soubory_id")
    private Integer druhySouboryId;
    @Size(max = 50)
    @Column(name = "druhy_soubory_nazev")
    private String druhySouboryNazev;
    @Size(max = 2147483647)
    @Column(name = "druhy_soubory_poznamky")
    private String druhySouboryPoznamky;

    public DruhySoubory() {
    }

    public DruhySoubory(Integer druhySouboryId) {
        this.druhySouboryId = druhySouboryId;
    }

    public Integer getDruhySouboryId() {
        return druhySouboryId;
    }

    public void setDruhySouboryId(Integer druhySouboryId) {
        this.druhySouboryId = druhySouboryId;
    }

    public String getDruhySouboryNazev() {
        return druhySouboryNazev;
    }

    public void setDruhySouboryNazev(String druhySouboryNazev) {
        this.druhySouboryNazev = druhySouboryNazev;
    }

    public String getDruhySouboryPoznamky() {
        return druhySouboryPoznamky;
    }

    public void setDruhySouboryPoznamky(String druhySouboryPoznamky) {
        this.druhySouboryPoznamky = druhySouboryPoznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (druhySouboryId != null ? druhySouboryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DruhySoubory)) {
            return false;
        }
        DruhySoubory other = (DruhySoubory) object;
        if ((this.druhySouboryId == null && other.druhySouboryId != null) || (this.druhySouboryId != null && !this.druhySouboryId.equals(other.druhySouboryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DruhySoubory[ druhySouboryId=" + druhySouboryId + " ]";
    }
    
}
