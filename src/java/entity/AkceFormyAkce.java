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
@Table(name = "akce_formy_akce", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceFormyAkce.findAll", query = "SELECT a FROM AkceFormyAkce a"),
    @NamedQuery(name = "AkceFormyAkce.findByAkceFormaId", query = "SELECT a FROM AkceFormyAkce a WHERE a.akceFormaId = :akceFormaId"),
    @NamedQuery(name = "AkceFormyAkce.findByNazev", query = "SELECT a FROM AkceFormyAkce a WHERE a.nazev = :nazev"),
    @NamedQuery(name = "AkceFormyAkce.findByCyklicitaAN", query = "SELECT a FROM AkceFormyAkce a WHERE a.cyklicitaAN = :cyklicitaAN"),
    @NamedQuery(name = "AkceFormyAkce.findByPoznamky", query = "SELECT a FROM AkceFormyAkce a WHERE a.poznamky = :poznamky")})
public class AkceFormyAkce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_forma_id")
    private Integer akceFormaId;
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
    @OneToMany(mappedBy = "formaakce")
    private Collection<AkceHlavni> akceHlavniCollection;
    @OneToMany(mappedBy = "akceFormaakce")
    private Collection<AkrAkceFormyVztahy> akrAkceFormyVztahyCollection;

    public AkceFormyAkce() {
    }

    public AkceFormyAkce(Integer akceFormaId) {
        this.akceFormaId = akceFormaId;
    }

    public AkceFormyAkce(Integer akceFormaId, boolean cyklicitaAN) {
        this.akceFormaId = akceFormaId;
        this.cyklicitaAN = cyklicitaAN;
    }

    public Integer getAkceFormaId() {
        return akceFormaId;
    }

    public void setAkceFormaId(Integer akceFormaId) {
        this.akceFormaId = akceFormaId;
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
    public Collection<AkceHlavni> getAkceHlavniCollection() {
        return akceHlavniCollection;
    }

    public void setAkceHlavniCollection(Collection<AkceHlavni> akceHlavniCollection) {
        this.akceHlavniCollection = akceHlavniCollection;
    }

    @XmlTransient
    public Collection<AkrAkceFormyVztahy> getAkrAkceFormyVztahyCollection() {
        return akrAkceFormyVztahyCollection;
    }

    public void setAkrAkceFormyVztahyCollection(Collection<AkrAkceFormyVztahy> akrAkceFormyVztahyCollection) {
        this.akrAkceFormyVztahyCollection = akrAkceFormyVztahyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceFormaId != null ? akceFormaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceFormyAkce)) {
            return false;
        }
        AkceFormyAkce other = (AkceFormyAkce) object;
        if ((this.akceFormaId == null && other.akceFormaId != null) || (this.akceFormaId != null && !this.akceFormaId.equals(other.akceFormaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceFormyAkce[ akceFormaId=" + akceFormaId + " ]";
    }
    
}
