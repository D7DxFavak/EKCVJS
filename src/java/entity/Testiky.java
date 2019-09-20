/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "testiky", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testiky.findAll", query = "SELECT t FROM Testiky t"),
    @NamedQuery(name = "Testiky.findByTId", query = "SELECT t FROM Testiky t WHERE t.tId = :tId"),
    @NamedQuery(name = "Testiky.findByDatum", query = "SELECT t FROM Testiky t WHERE t.datum = :datum"),
    @NamedQuery(name = "Testiky.findByDatumcas", query = "SELECT t FROM Testiky t WHERE t.datumcas = :datumcas"),
    @NamedQuery(name = "Testiky.findByRc", query = "SELECT t FROM Testiky t WHERE t.rc = :rc")})
public class Testiky implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_id")
    private Integer tId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumcas")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumcas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rc")
    private String rc;

    public Testiky() {
    }

    public Testiky(Integer tId) {
        this.tId = tId;
    }

    public Testiky(Integer tId, Date datum, Date datumcas, String rc) {
        this.tId = tId;
        this.datum = datum;
        this.datumcas = datumcas;
        this.rc = rc;
    }

    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getDatumcas() {
        return datumcas;
    }

    public void setDatumcas(Date datumcas) {
        this.datumcas = datumcas;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tId != null ? tId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testiky)) {
            return false;
        }
        Testiky other = (Testiky) object;
        if ((this.tId == null && other.tId != null) || (this.tId != null && !this.tId.equals(other.tId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Testiky[ tId=" + tId + " ]";
    }
    
}
