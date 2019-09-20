/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "obory_skupiny", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OborySkupiny.findAll", query = "SELECT o FROM OborySkupiny o"),
    @NamedQuery(name = "OborySkupiny.findByOborySkupinyId", query = "SELECT o FROM OborySkupiny o WHERE o.oborySkupinyId = :oborySkupinyId"),
    @NamedQuery(name = "OborySkupiny.findByOborySkupinyNazev", query = "SELECT o FROM OborySkupiny o WHERE o.oborySkupinyNazev = :oborySkupinyNazev"),
    @NamedQuery(name = "OborySkupiny.findByOborySkupinyPopis", query = "SELECT o FROM OborySkupiny o WHERE o.oborySkupinyPopis = :oborySkupinyPopis"),
    @NamedQuery(name = "OborySkupiny.findByOborySkupinyPoznamky", query = "SELECT o FROM OborySkupiny o WHERE o.oborySkupinyPoznamky = :oborySkupinyPoznamky")})
public class OborySkupiny implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "obory_skupiny_id")
    private Integer oborySkupinyId;
    @Size(max = 100)
    @Column(name = "obory_skupiny_nazev")
    private String oborySkupinyNazev;
    @Size(max = 2147483647)
    @Column(name = "obory_skupiny_popis")
    private String oborySkupinyPopis;
    @Size(max = 2147483647)
    @Column(name = "obory_skupiny_poznamky")
    private String oborySkupinyPoznamky;
    @JoinColumn(name = "obory_skupiny_vychozi_obdobi", referencedColumnName = "obdobi_id")
    @ManyToOne
    private Obdobi oborySkupinyVychoziObdobi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oborySkupiny")
    private Collection<OboryVazbySkupiny> oboryVazbySkupinyCollection;

    public OborySkupiny() {
    }

    public OborySkupiny(Integer oborySkupinyId) {
        this.oborySkupinyId = oborySkupinyId;
    }

    public Integer getOborySkupinyId() {
        return oborySkupinyId;
    }

    public void setOborySkupinyId(Integer oborySkupinyId) {
        this.oborySkupinyId = oborySkupinyId;
    }

    public String getOborySkupinyNazev() {
        return oborySkupinyNazev;
    }

    public void setOborySkupinyNazev(String oborySkupinyNazev) {
        this.oborySkupinyNazev = oborySkupinyNazev;
    }

    public String getOborySkupinyPopis() {
        return oborySkupinyPopis;
    }

    public void setOborySkupinyPopis(String oborySkupinyPopis) {
        this.oborySkupinyPopis = oborySkupinyPopis;
    }

    public String getOborySkupinyPoznamky() {
        return oborySkupinyPoznamky;
    }

    public void setOborySkupinyPoznamky(String oborySkupinyPoznamky) {
        this.oborySkupinyPoznamky = oborySkupinyPoznamky;
    }

    @XmlTransient
    public Collection<OboryVazbySkupiny> getOboryVazbySkupinyCollection() {
        return oboryVazbySkupinyCollection;
    }

    public void setOboryVazbySkupinyCollection(Collection<OboryVazbySkupiny> oboryVazbySkupinyCollection) {
        this.oboryVazbySkupinyCollection = oboryVazbySkupinyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oborySkupinyId != null ? oborySkupinyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OborySkupiny)) {
            return false;
        }
        OborySkupiny other = (OborySkupiny) object;
        if ((this.oborySkupinyId == null && other.oborySkupinyId != null) || (this.oborySkupinyId != null && !this.oborySkupinyId.equals(other.oborySkupinyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OborySkupiny[ oborySkupinyId=" + oborySkupinyId + " ]";
    }

    /**
     * @return the oborySkupinyVychoziObdobi
     */
    public Obdobi getOborySkupinyVychoziObdobi() {
        return oborySkupinyVychoziObdobi;
    }

    /**
     * @param oborySkupinyVychoziObdobi the oborySkupinyVychoziObdobi to set
     */
    public void setOborySkupinyVychoziObdobi(Obdobi oborySkupinyVychoziObdobi) {
        this.oborySkupinyVychoziObdobi = oborySkupinyVychoziObdobi;
    }
    
}
