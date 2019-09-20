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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "akr_akce_cilskup_vztahy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrAkceCilskupVztahy.findAll", query = "SELECT a FROM AkrAkceCilskupVztahy a"),
    @NamedQuery(name = "AkrAkceCilskupVztahy.findByAkrCilskup", query = "SELECT a FROM AkrAkceCilskupVztahy a WHERE a.akrCilskup = :akrCilskup"),
    @NamedQuery(name = "AkrAkceCilskupVztahy.findByPoznamky", query = "SELECT a FROM AkrAkceCilskupVztahy a WHERE a.poznamky = :poznamky")})
public class AkrAkceCilskupVztahy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_cilskup")
    private Integer akrCilskup;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "akr_cilskup", referencedColumnName = "akr_cilskup_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AkrCiloveSkupiny akrCiloveSkupiny;
    @JoinColumn(name = "akce_cilskup", referencedColumnName = "akce_cilskup_id")
    @ManyToOne
    private AkceCiloveSkupiny akceCilskup;

    public AkrAkceCilskupVztahy() {
    }

    public AkrAkceCilskupVztahy(Integer akrCilskup) {
        this.akrCilskup = akrCilskup;
    }

    public Integer getAkrCilskup() {
        return akrCilskup;
    }

    public void setAkrCilskup(Integer akrCilskup) {
        this.akrCilskup = akrCilskup;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public AkrCiloveSkupiny getAkrCiloveSkupiny() {
        return akrCiloveSkupiny;
    }

    public void setAkrCiloveSkupiny(AkrCiloveSkupiny akrCiloveSkupiny) {
        this.akrCiloveSkupiny = akrCiloveSkupiny;
    }

    public AkceCiloveSkupiny getAkceCilskup() {
        return akceCilskup;
    }

    public void setAkceCilskup(AkceCiloveSkupiny akceCilskup) {
        this.akceCilskup = akceCilskup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrCilskup != null ? akrCilskup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrAkceCilskupVztahy)) {
            return false;
        }
        AkrAkceCilskupVztahy other = (AkrAkceCilskupVztahy) object;
        if ((this.akrCilskup == null && other.akrCilskup != null) || (this.akrCilskup != null && !this.akrCilskup.equals(other.akrCilskup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrAkceCilskupVztahy[ akrCilskup=" + akrCilskup + " ]";
    }
    
}
