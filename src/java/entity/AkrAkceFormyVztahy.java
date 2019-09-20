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
@Table(name = "akr_akce_formy_vztahy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkrAkceFormyVztahy.findAll", query = "SELECT a FROM AkrAkceFormyVztahy a"),
    @NamedQuery(name = "AkrAkceFormyVztahy.findByAkrFormaakce", query = "SELECT a FROM AkrAkceFormyVztahy a WHERE a.akrFormaakce = :akrFormaakce"),
    @NamedQuery(name = "AkrAkceFormyVztahy.findByPoznamky", query = "SELECT a FROM AkrAkceFormyVztahy a WHERE a.poznamky = :poznamky")})
public class AkrAkceFormyVztahy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akr_formaakce")
    private Integer akrFormaakce;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "akr_formaakce", referencedColumnName = "akr_forma_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AkrFormyAkce akrFormyAkce;
    @JoinColumn(name = "akce_formaakce", referencedColumnName = "akce_forma_id")
    @ManyToOne
    private AkceFormyAkce akceFormaakce;

    public AkrAkceFormyVztahy() {
    }

    public AkrAkceFormyVztahy(Integer akrFormaakce) {
        this.akrFormaakce = akrFormaakce;
    }

    public Integer getAkrFormaakce() {
        return akrFormaakce;
    }

    public void setAkrFormaakce(Integer akrFormaakce) {
        this.akrFormaakce = akrFormaakce;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public AkrFormyAkce getAkrFormyAkce() {
        return akrFormyAkce;
    }

    public void setAkrFormyAkce(AkrFormyAkce akrFormyAkce) {
        this.akrFormyAkce = akrFormyAkce;
    }

    public AkceFormyAkce getAkceFormaakce() {
        return akceFormaakce;
    }

    public void setAkceFormaakce(AkceFormyAkce akceFormaakce) {
        this.akceFormaakce = akceFormaakce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akrFormaakce != null ? akrFormaakce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkrAkceFormyVztahy)) {
            return false;
        }
        AkrAkceFormyVztahy other = (AkrAkceFormyVztahy) object;
        if ((this.akrFormaakce == null && other.akrFormaakce != null) || (this.akrFormaakce != null && !this.akrFormaakce.equals(other.akrFormaakce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkrAkceFormyVztahy[ akrFormaakce=" + akrFormaakce + " ]";
    }
    
}
