/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 7Data Gotzy
 */
@Embeddable
public class OsobyDruhyPrirazeniPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "osoba_id")
    private int osobaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "druhosoby")
    private int druhosoby;

    public OsobyDruhyPrirazeniPK() {
    }

    public OsobyDruhyPrirazeniPK(int osobaId, int druhosoby) {
        this.osobaId = osobaId;
        this.druhosoby = druhosoby;
    }

    public int getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(int osobaId) {
        this.osobaId = osobaId;
    }

    public int getDruhosoby() {
        return druhosoby;
    }

    public void setDruhosoby(int druhosoby) {
        this.druhosoby = druhosoby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) osobaId;
        hash += (int) druhosoby;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyDruhyPrirazeniPK)) {
            return false;
        }
        OsobyDruhyPrirazeniPK other = (OsobyDruhyPrirazeniPK) object;
        if (this.osobaId != other.osobaId) {
            return false;
        }
        if (this.druhosoby != other.druhosoby) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OsobyDruhyPrirazeniPK[ osobaId=" + osobaId + ", druhosoby=" + druhosoby + " ]";
    }
    
}
