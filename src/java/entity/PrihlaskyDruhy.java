/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "prihlasky_druhy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlaskyDruhy.findAll", query = "SELECT p FROM PrihlaskyDruhy p"),
    @NamedQuery(name = "PrihlaskyDruhy.findByPrihlaskyDruhyId", query = "SELECT p FROM PrihlaskyDruhy p WHERE p.prihlaskyDruhyId = :prihlaskyDruhyId"),
    @NamedQuery(name = "PrihlaskyDruhy.findByPrihlaskyDruhyNazev", query = "SELECT p FROM PrihlaskyDruhy p WHERE p.prihlaskyDruhyNazev = :prihlaskyDruhyNazev"),
    @NamedQuery(name = "PrihlaskyDruhy.findByPrihlaskyDruhyPopis", query = "SELECT p FROM PrihlaskyDruhy p WHERE p.prihlaskyDruhyPopis = :prihlaskyDruhyPopis"),
    @NamedQuery(name = "PrihlaskyDruhy.findByPrihlaskyDruhyPoradiVyber", query = "SELECT p FROM PrihlaskyDruhy p WHERE p.prihlaskyDruhyPoradiVyber = :prihlaskyDruhyPoradiVyber"),
    @NamedQuery(name = "PrihlaskyDruhy.findByPrihlaskyDruhyPoznamky", query = "SELECT p FROM PrihlaskyDruhy p WHERE p.prihlaskyDruhyPoznamky = :prihlaskyDruhyPoznamky")})
public class PrihlaskyDruhy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prihlasky_druhy_id")
    private Integer prihlaskyDruhyId;
    @Size(max = 250)
    @Column(name = "prihlasky_druhy_nazev")
    private String prihlaskyDruhyNazev;
    @Size(max = 2147483647)
    @Column(name = "prihlasky_druhy_popis")
    private String prihlaskyDruhyPopis;
    @Column(name = "prihlasky_druhy_poradi_vyber")
    private Integer prihlaskyDruhyPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "prihlasky_druhy_poznamky")
    private String prihlaskyDruhyPoznamky;
    @OneToMany(mappedBy = "prihlaseniZpusob")
    private Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection;
    @OneToMany(mappedBy = "prihlaseniZpusob")
    private Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection;

    public PrihlaskyDruhy() {
    }

    public PrihlaskyDruhy(Integer prihlaskyDruhyId) {
        this.prihlaskyDruhyId = prihlaskyDruhyId;
    }

    public Integer getPrihlaskyDruhyId() {
        return prihlaskyDruhyId;
    }

    public void setPrihlaskyDruhyId(Integer prihlaskyDruhyId) {
        this.prihlaskyDruhyId = prihlaskyDruhyId;
    }

    public String getPrihlaskyDruhyNazev() {
        return prihlaskyDruhyNazev;
    }

    public void setPrihlaskyDruhyNazev(String prihlaskyDruhyNazev) {
        this.prihlaskyDruhyNazev = prihlaskyDruhyNazev;
    }

    public String getPrihlaskyDruhyPopis() {
        return prihlaskyDruhyPopis;
    }

    public void setPrihlaskyDruhyPopis(String prihlaskyDruhyPopis) {
        this.prihlaskyDruhyPopis = prihlaskyDruhyPopis;
    }

    public Integer getPrihlaskyDruhyPoradiVyber() {
        return prihlaskyDruhyPoradiVyber;
    }

    public void setPrihlaskyDruhyPoradiVyber(Integer prihlaskyDruhyPoradiVyber) {
        this.prihlaskyDruhyPoradiVyber = prihlaskyDruhyPoradiVyber;
    }

    public String getPrihlaskyDruhyPoznamky() {
        return prihlaskyDruhyPoznamky;
    }

    public void setPrihlaskyDruhyPoznamky(String prihlaskyDruhyPoznamky) {
        this.prihlaskyDruhyPoznamky = prihlaskyDruhyPoznamky;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisy> getPrihlaskyRozpisyCollection() {
        return prihlaskyRozpisyCollection;
    }

    public void setPrihlaskyRozpisyCollection(Collection<PrihlaskyRozpisy> prihlaskyRozpisyCollection) {
        this.prihlaskyRozpisyCollection = prihlaskyRozpisyCollection;
    }

    @XmlTransient
    public Collection<PrihlaskyRozpisyJs> getPrihlaskyRozpisyJsCollection() {
        return prihlaskyRozpisyJsCollection;
    }

    public void setPrihlaskyRozpisyJsCollection(Collection<PrihlaskyRozpisyJs> prihlaskyRozpisyJsCollection) {
        this.prihlaskyRozpisyJsCollection = prihlaskyRozpisyJsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prihlaskyDruhyId != null ? prihlaskyDruhyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlaskyDruhy)) {
            return false;
        }
        PrihlaskyDruhy other = (PrihlaskyDruhy) object;
        if ((this.prihlaskyDruhyId == null && other.prihlaskyDruhyId != null) || (this.prihlaskyDruhyId != null && !this.prihlaskyDruhyId.equals(other.prihlaskyDruhyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlaskyDruhy[ prihlaskyDruhyId=" + prihlaskyDruhyId + " ]";
    }
    
}
