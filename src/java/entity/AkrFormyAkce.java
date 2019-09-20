/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "akr_formy_akce", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrFormyAkce.findAll", query = "SELECT a FROM AkrFormyAkce a"),
    @NamedQuery(name = "AkrFormyAkce.findByAkrFormaId", query = "SELECT a FROM AkrFormyAkce a WHERE a.akrFormaId = :akrFormaId"),
    @NamedQuery(name = "AkrFormyAkce.findByNazev", query = "SELECT a FROM AkrFormyAkce a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkrFormyAkce.findByCyklicitaAN", query = "SELECT a FROM AkrFormyAkce a WHERE a.cyklicitaAN = :cyklicitaAN"),
    @NamedQuery(name = "AkrFormyAkce.findByPoznamky", query = "SELECT a FROM AkrFormyAkce a WHERE a.poznamky = :poznamky")})
public class AkrFormyAkce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_forma_id")
    private Integer akrFormaId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cyklicita_a_n")
    private boolean cyklicitaAN;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(mappedBy = "akrFormaakce")
    private Collection<AkreditaceHlavni> akreditaceHlavniCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "akrFormyAkce")
    private AkrAkceFormyVztahy akrAkceFormyVztahy;

    public AkrFormyAkce() {
    }

    public AkrFormyAkce(Integer akrFormaId) {
        this.akrFormaId = akrFormaId;
    }

    public AkrFormyAkce(Integer akrFormaId, boolean cyklicitaAN) {
        this.akrFormaId = akrFormaId;
        this.cyklicitaAN = cyklicitaAN;
    }

    public Integer getAkrFormaId() {
        return akrFormaId;
    }

    public void setAkrFormaId(Integer akrFormaId) {
        this.akrFormaId = akrFormaId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean getCyklicitaAN() {
        return cyklicitaAN;
    }

    public void setCyklicitaAN(boolean cyklicitaAN) {
        this.cyklicitaAN = cyklicitaAN;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<AkreditaceHlavni> getAkreditaceHlavniCollection() {
        return akreditaceHlavniCollection;
    }

    public void setAkreditaceHlavniCollection(Collection<AkreditaceHlavni> akreditaceHlavniCollection) {
        this.akreditaceHlavniCollection = akreditaceHlavniCollection;
    }

    public AkrAkceFormyVztahy getAkrAkceFormyVztahy() {
        return akrAkceFormyVztahy;
    }

    public void setAkrAkceFormyVztahy(AkrAkceFormyVztahy akrAkceFormyVztahy) {
        this.akrAkceFormyVztahy = akrAkceFormyVztahy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrFormaId != null ? akrFormaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrFormyAkce)) {
            return false;
        }
        AkrFormyAkce other = (AkrFormyAkce) object;
        if ((this.akrFormaId == null && other.akrFormaId != null) || (this.akrFormaId != null && !this.akrFormaId.equals(other.akrFormaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrFormyAkce[ akrFormaId=" + akrFormaId + " ]";
    }
    
}
