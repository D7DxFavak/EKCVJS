/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "akce_pausal_pol", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkcePausalPol.findAll", query = "SELECT a FROM AkcePausalPol a"),
    @NamedQuery(name = "AkcePausalPol.findByAkcePausalPolId", query = "SELECT a FROM AkcePausalPol a WHERE a.akcePausalPolId = :akcePausalPolId"),
    @NamedQuery(name = "AkcePausalPol.findByAkcePausalPolNazev", query = "SELECT a FROM AkcePausalPol a WHERE a.akcePausalPolNazev = :akcePausalPolNazev"),
    @NamedQuery(name = "AkcePausalPol.findByAkcePausalPolPoznamky", query = "SELECT a FROM AkcePausalPol a WHERE a.akcePausalPolPoznamky = :akcePausalPolPoznamky"),
    @NamedQuery(name = "AkcePausalPol.findByAkcePausalPolDruh", query = "SELECT a FROM AkcePausalPol a WHERE a.akcePausalPolDruh = :akcePausalPolDruh"),
    @NamedQuery(name = "AkcePausalPol.findByAkcePausalPolDefSazba", query = "SELECT a FROM AkcePausalPol a WHERE a.akcePausalPolDefSazba = :akcePausalPolDefSazba"),
    @NamedQuery(name = "AkcePausalPol.findByAkcePausalPolCas", query = "SELECT a FROM AkcePausalPol a WHERE a.akcePausalPolCas = :akcePausalPolCas")})
public class AkcePausalPol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_pausal_pol_id")
    private Integer akcePausalPolId;
    @Size(max = 250)
    @Column(name = "akce_pausal_pol_nazev")
    private String akcePausalPolNazev;
    @Size(max = 2147483647)
    @Column(name = "akce_pausal_pol_poznamky")
    private String akcePausalPolPoznamky;
    @Column(name = "akce_pausal_pol_druh")
    private Integer akcePausalPolDruh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "akce_pausal_pol_def_sazba")
    private BigDecimal akcePausalPolDefSazba;
    @Column(name = "akce_pausal_pol_cas")
    private BigDecimal akcePausalPolCas;

    public AkcePausalPol() {
    }

    public AkcePausalPol(Integer akcePausalPolId) {
        this.akcePausalPolId = akcePausalPolId;
    }

    public Integer getAkcePausalPolId() {
        return akcePausalPolId;
    }

    public void setAkcePausalPolId(Integer akcePausalPolId) {
        this.akcePausalPolId = akcePausalPolId;
    }

    public String getAkcePausalPolNazev() {
        return akcePausalPolNazev;
    }

    public void setAkcePausalPolNazev(String akcePausalPolNazev) {
        this.akcePausalPolNazev = akcePausalPolNazev;
    }

    public String getAkcePausalPolPoznamky() {
        return akcePausalPolPoznamky;
    }

    public void setAkcePausalPolPoznamky(String akcePausalPolPoznamky) {
        this.akcePausalPolPoznamky = akcePausalPolPoznamky;
    }

    public Integer getAkcePausalPolDruh() {
        return akcePausalPolDruh;
    }

    public void setAkcePausalPolDruh(Integer akcePausalPolDruh) {
        this.akcePausalPolDruh = akcePausalPolDruh;
    }

    public BigDecimal getAkcePausalPolDefSazba() {
        return akcePausalPolDefSazba;
    }

    public void setAkcePausalPolDefSazba(BigDecimal akcePausalPolDefSazba) {
        this.akcePausalPolDefSazba = akcePausalPolDefSazba;
    }

    public BigDecimal getAkcePausalPolCas() {
        return akcePausalPolCas;
    }

    public void setAkcePausalPolCas(BigDecimal akcePausalPolCas) {
        this.akcePausalPolCas = akcePausalPolCas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akcePausalPolId != null ? akcePausalPolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkcePausalPol)) {
            return false;
        }
        AkcePausalPol other = (AkcePausalPol) object;
        if ((this.akcePausalPolId == null && other.akcePausalPolId != null) || (this.akcePausalPolId != null && !this.akcePausalPolId.equals(other.akcePausalPolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkcePausalPol[ akcePausalPolId=" + akcePausalPolId + " ]";
    }
    
}
