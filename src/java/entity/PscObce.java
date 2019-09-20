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
@Table(name = "psc_obce", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PscObce.findAll", query = "SELECT p FROM PscObce p"),
    @NamedQuery(name = "PscObce.findByPscObceId", query = "SELECT p FROM PscObce p WHERE p.pscObceId = :pscObceId"),
    @NamedQuery(name = "PscObce.findByPscObcePsc", query = "SELECT p FROM PscObce p WHERE p.pscObcePsc = :pscObcePsc"),
    @NamedQuery(name = "PscObce.findByPscObceObec", query = "SELECT p FROM PscObce p WHERE p.pscObceObec = :pscObceObec"),
    @NamedQuery(name = "PscObce.findByPscObcePoznamka", query = "SELECT p FROM PscObce p WHERE p.pscObcePoznamka = :pscObcePoznamka")})
public class PscObce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "psc_obce_id")
    private Integer pscObceId;
    @Size(max = 7)
    @Column(name = "psc_obce_psc")
    private String pscObcePsc;
    @Size(max = 50)
    @Column(name = "psc_obce_obec")
    private String pscObceObec;
    @Size(max = 2147483647)
    @Column(name = "psc_obce_poznamka")
    private String pscObcePoznamka;

    public PscObce() {
    }

    public PscObce(Integer pscObceId) {
        this.pscObceId = pscObceId;
    }

    public Integer getPscObceId() {
        return pscObceId;
    }

    public void setPscObceId(Integer pscObceId) {
        this.pscObceId = pscObceId;
    }

    public String getPscObcePsc() {
        return pscObcePsc;
    }

    public void setPscObcePsc(String pscObcePsc) {
        this.pscObcePsc = pscObcePsc;
    }

    public String getPscObceObec() {
        return pscObceObec;
    }

    public void setPscObceObec(String pscObceObec) {
        this.pscObceObec = pscObceObec;
    }

    public String getPscObcePoznamka() {
        return pscObcePoznamka;
    }

    public void setPscObcePoznamka(String pscObcePoznamka) {
        this.pscObcePoznamka = pscObcePoznamka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pscObceId != null ? pscObceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PscObce)) {
            return false;
        }
        PscObce other = (PscObce) object;
        if ((this.pscObceId == null && other.pscObceId != null) || (this.pscObceId != null && !this.pscObceId.equals(other.pscObceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PscObce[ pscObceId=" + pscObceId + " ]";
    }
    
}
