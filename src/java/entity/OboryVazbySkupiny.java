/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "obory_vazby_skupiny", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OboryVazbySkupiny.findAll", query = "SELECT o FROM OboryVazbySkupiny o"),
    @NamedQuery(name = "OboryVazbySkupiny.findByOboryVazbySkupinyOboryId", query = "SELECT o FROM OboryVazbySkupiny o WHERE o.oboryVazbySkupinyPK.oboryVazbySkupinyOboryId = :oboryVazbySkupinyOboryId"),
    @NamedQuery(name = "OboryVazbySkupiny.findByOboryVazbySkupinyOborySkupinyId", query = "SELECT o FROM OboryVazbySkupiny o WHERE o.oboryVazbySkupinyPK.oboryVazbySkupinyOborySkupinyId = :oboryVazbySkupinyOborySkupinyId ORDER BY o.oboryVazbySkupinyPK.oboryVazbySkupinyOboryId"),
    @NamedQuery(name = "OboryVazbySkupiny.findByOboryVazbySkupinyPoznamky", query = "SELECT o FROM OboryVazbySkupiny o WHERE o.oboryVazbySkupinyPoznamky = :oboryVazbySkupinyPoznamky")})
public class OboryVazbySkupiny implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OboryVazbySkupinyPK oboryVazbySkupinyPK;
    @Size(max = 2147483647)
    @Column(name = "obory_vazby_skupiny_poznamky")
    private String oboryVazbySkupinyPoznamky;
    @JoinColumn(name = "obory_vazby_skupiny_obory_skupiny_id", referencedColumnName = "obory_skupiny_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OborySkupiny oborySkupiny;
    @JoinColumn(name = "obory_vazby_skupiny_obory_id", referencedColumnName = "obor_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Obory obory;

    public OboryVazbySkupiny() {
    }

    public OboryVazbySkupiny(OboryVazbySkupinyPK oboryVazbySkupinyPK) {
        this.oboryVazbySkupinyPK = oboryVazbySkupinyPK;
    }

    public OboryVazbySkupiny(int oboryVazbySkupinyOboryId, int oboryVazbySkupinyOborySkupinyId) {
        this.oboryVazbySkupinyPK = new OboryVazbySkupinyPK(oboryVazbySkupinyOboryId, oboryVazbySkupinyOborySkupinyId);
    }

    public OboryVazbySkupinyPK getOboryVazbySkupinyPK() {
        return oboryVazbySkupinyPK;
    }

    public void setOboryVazbySkupinyPK(OboryVazbySkupinyPK oboryVazbySkupinyPK) {
        this.oboryVazbySkupinyPK = oboryVazbySkupinyPK;
    }

    public String getOboryVazbySkupinyPoznamky() {
        return oboryVazbySkupinyPoznamky;
    }

    public void setOboryVazbySkupinyPoznamky(String oboryVazbySkupinyPoznamky) {
        this.oboryVazbySkupinyPoznamky = oboryVazbySkupinyPoznamky;
    }

    public OborySkupiny getOborySkupiny() {
        return oborySkupiny;
    }

    public void setOborySkupiny(OborySkupiny oborySkupiny) {
        this.oborySkupiny = oborySkupiny;
    }

    public Obory getObory() {
        return obory;
    }

    public void setObory(Obory obory) {
        this.obory = obory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oboryVazbySkupinyPK != null ? oboryVazbySkupinyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OboryVazbySkupiny)) {
            return false;
        }
        OboryVazbySkupiny other = (OboryVazbySkupiny) object;
        if ((this.oboryVazbySkupinyPK == null && other.oboryVazbySkupinyPK != null) || (this.oboryVazbySkupinyPK != null && !this.oboryVazbySkupinyPK.equals(other.oboryVazbySkupinyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OboryVazbySkupiny[ oboryVazbySkupinyPK=" + oboryVazbySkupinyPK + " ]";
    }
    
}
