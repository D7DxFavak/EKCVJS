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
@Table(name = "mesice_slovy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MesiceSlovy.findAll", query = "SELECT m FROM MesiceSlovy m"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovyId", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovyId = :mesiceSlovyId"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy1pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy1pad = :mesiceSlovy1pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy2pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy2pad = :mesiceSlovy2pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy3pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy3pad = :mesiceSlovy3pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy4pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy4pad = :mesiceSlovy4pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy5pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy5pad = :mesiceSlovy5pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy6pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy6pad = :mesiceSlovy6pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovy7pad", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovy7pad = :mesiceSlovy7pad"),
    @NamedQuery(name = "MesiceSlovy.findByMesiceSlovyPoznamky", query = "SELECT m FROM MesiceSlovy m WHERE m.mesiceSlovyPoznamky = :mesiceSlovyPoznamky")})
public class MesiceSlovy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mesice_slovy_id")
    private Integer mesiceSlovyId;
    @Size(max = 50)
    @Column(name = "mesice_slovy_1pad")
    private String mesiceSlovy1pad;
    @Size(max = 50)
    @Column(name = "mesice_slovy_2pad")
    private String mesiceSlovy2pad;
    @Size(max = 50)
    @Column(name = "mesice_slovy_3pad")
    private String mesiceSlovy3pad;
    @Size(max = 50)
    @Column(name = "mesice_slovy_4pad")
    private String mesiceSlovy4pad;
    @Size(max = 50)
    @Column(name = "mesice_slovy_5pad")
    private String mesiceSlovy5pad;
    @Size(max = 50)
    @Column(name = "mesice_slovy_6pad")
    private String mesiceSlovy6pad;
    @Size(max = 50)
    @Column(name = "mesice_slovy_7pad")
    private String mesiceSlovy7pad;
    @Size(max = 2147483647)
    @Column(name = "mesice_slovy_poznamky")
    private String mesiceSlovyPoznamky;

    public MesiceSlovy() {
    }

    public MesiceSlovy(Integer mesiceSlovyId) {
        this.mesiceSlovyId = mesiceSlovyId;
    }

    public Integer getMesiceSlovyId() {
        return mesiceSlovyId;
    }

    public void setMesiceSlovyId(Integer mesiceSlovyId) {
        this.mesiceSlovyId = mesiceSlovyId;
    }

    public String getMesiceSlovy1pad() {
        return mesiceSlovy1pad;
    }

    public void setMesiceSlovy1pad(String mesiceSlovy1pad) {
        this.mesiceSlovy1pad = mesiceSlovy1pad;
    }

    public String getMesiceSlovy2pad() {
        return mesiceSlovy2pad;
    }

    public void setMesiceSlovy2pad(String mesiceSlovy2pad) {
        this.mesiceSlovy2pad = mesiceSlovy2pad;
    }

    public String getMesiceSlovy3pad() {
        return mesiceSlovy3pad;
    }

    public void setMesiceSlovy3pad(String mesiceSlovy3pad) {
        this.mesiceSlovy3pad = mesiceSlovy3pad;
    }

    public String getMesiceSlovy4pad() {
        return mesiceSlovy4pad;
    }

    public void setMesiceSlovy4pad(String mesiceSlovy4pad) {
        this.mesiceSlovy4pad = mesiceSlovy4pad;
    }

    public String getMesiceSlovy5pad() {
        return mesiceSlovy5pad;
    }

    public void setMesiceSlovy5pad(String mesiceSlovy5pad) {
        this.mesiceSlovy5pad = mesiceSlovy5pad;
    }

    public String getMesiceSlovy6pad() {
        return mesiceSlovy6pad;
    }

    public void setMesiceSlovy6pad(String mesiceSlovy6pad) {
        this.mesiceSlovy6pad = mesiceSlovy6pad;
    }

    public String getMesiceSlovy7pad() {
        return mesiceSlovy7pad;
    }

    public void setMesiceSlovy7pad(String mesiceSlovy7pad) {
        this.mesiceSlovy7pad = mesiceSlovy7pad;
    }

    public String getMesiceSlovyPoznamky() {
        return mesiceSlovyPoznamky;
    }

    public void setMesiceSlovyPoznamky(String mesiceSlovyPoznamky) {
        this.mesiceSlovyPoznamky = mesiceSlovyPoznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mesiceSlovyId != null ? mesiceSlovyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesiceSlovy)) {
            return false;
        }
        MesiceSlovy other = (MesiceSlovy) object;
        if ((this.mesiceSlovyId == null && other.mesiceSlovyId != null) || (this.mesiceSlovyId != null && !this.mesiceSlovyId.equals(other.mesiceSlovyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MesiceSlovy[ mesiceSlovyId=" + mesiceSlovyId + " ]";
    }
    
}
