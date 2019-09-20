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
@Table(name = "akce_js_zamereni_kurzu", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceJsZamereniKurzu.findAll", query = "SELECT a FROM AkceJsZamereniKurzu a"),
    @NamedQuery(name = "AkceJsZamereniKurzu.findByAkceJsZamereniKurzuId", query = "SELECT a FROM AkceJsZamereniKurzu a WHERE a.akceJsZamereniKurzuId = :akceJsZamereniKurzuId"),
    @NamedQuery(name = "AkceJsZamereniKurzu.findByAkceJsZamereniKurzuNazev", query = "SELECT a FROM AkceJsZamereniKurzu a WHERE a.akceJsZamereniKurzuNazev = :akceJsZamereniKurzuNazev"),
    @NamedQuery(name = "AkceJsZamereniKurzu.findByAkceJsZamereniKurzu1tvar", query = "SELECT a FROM AkceJsZamereniKurzu a WHERE a.akceJsZamereniKurzu1tvar = :akceJsZamereniKurzu1tvar"),
    @NamedQuery(name = "AkceJsZamereniKurzu.findByAkceJsZamereniKurzuPoznamky", query = "SELECT a FROM AkceJsZamereniKurzu a WHERE a.akceJsZamereniKurzuPoznamky = :akceJsZamereniKurzuPoznamky")})
public class AkceJsZamereniKurzu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_js_zamereni_kurzu_id")
    private Integer akceJsZamereniKurzuId;
    @Size(max = 50)
    @Column(name = "akce_js_zamereni_kurzu_nazev")
    private String akceJsZamereniKurzuNazev;
    @Size(max = 50)
    @Column(name = "akce_js_zamereni_kurzu_1tvar")
    private String akceJsZamereniKurzu1tvar;
    @Size(max = 2147483647)
    @Column(name = "akce_js_zamereni_kurzu_poznamky")
    private String akceJsZamereniKurzuPoznamky;
    @OneToMany(mappedBy = "akceJsDetailyZamereniKurzu")
    private Collection<AkceJsDetaily> akceJsDetailyCollection;

    public AkceJsZamereniKurzu() {
    }

    public AkceJsZamereniKurzu(Integer akceJsZamereniKurzuId) {
        this.akceJsZamereniKurzuId = akceJsZamereniKurzuId;
    }

    public Integer getAkceJsZamereniKurzuId() {
        return akceJsZamereniKurzuId;
    }

    public void setAkceJsZamereniKurzuId(Integer akceJsZamereniKurzuId) {
        this.akceJsZamereniKurzuId = akceJsZamereniKurzuId;
    }

    public String getAkceJsZamereniKurzuNazev() {
        return akceJsZamereniKurzuNazev;
    }

    public void setAkceJsZamereniKurzuNazev(String akceJsZamereniKurzuNazev) {
        this.akceJsZamereniKurzuNazev = akceJsZamereniKurzuNazev;
    }

    public String getAkceJsZamereniKurzu1tvar() {
        return akceJsZamereniKurzu1tvar;
    }

    public void setAkceJsZamereniKurzu1tvar(String akceJsZamereniKurzu1tvar) {
        this.akceJsZamereniKurzu1tvar = akceJsZamereniKurzu1tvar;
    }

    public String getAkceJsZamereniKurzuPoznamky() {
        return akceJsZamereniKurzuPoznamky;
    }

    public void setAkceJsZamereniKurzuPoznamky(String akceJsZamereniKurzuPoznamky) {
        this.akceJsZamereniKurzuPoznamky = akceJsZamereniKurzuPoznamky;
    }

    @XmlTransient
    public Collection<AkceJsDetaily> getAkceJsDetailyCollection() {
        return akceJsDetailyCollection;
    }

    public void setAkceJsDetailyCollection(Collection<AkceJsDetaily> akceJsDetailyCollection) {
        this.akceJsDetailyCollection = akceJsDetailyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akceJsZamereniKurzuId != null ? akceJsZamereniKurzuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceJsZamereniKurzu)) {
            return false;
        }
        AkceJsZamereniKurzu other = (AkceJsZamereniKurzu) object;
        if ((this.akceJsZamereniKurzuId == null && other.akceJsZamereniKurzuId != null) || (this.akceJsZamereniKurzuId != null && !this.akceJsZamereniKurzuId.equals(other.akceJsZamereniKurzuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceJsZamereniKurzu[ akceJsZamereniKurzuId=" + akceJsZamereniKurzuId + " ]";
    }
    
}
