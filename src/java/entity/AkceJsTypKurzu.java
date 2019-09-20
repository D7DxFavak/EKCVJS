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
@Table(name = "akce_js_typ_kurzu", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkceJsTypKurzu.findAll", query = "SELECT a FROM AkceJsTypKurzu a"),
    @NamedQuery(name = "AkceJsTypKurzu.findByAkceJsTypKurzuId", query = "SELECT a FROM AkceJsTypKurzu a WHERE a.akceJsTypKurzuId = :akceJsTypKurzuId"),
    @NamedQuery(name = "AkceJsTypKurzu.findByAkceJsTypKurzuNazev", query = "SELECT a FROM AkceJsTypKurzu a WHERE a.akceJsTypKurzuNazev = :akceJsTypKurzuNazev"),
    @NamedQuery(name = "AkceJsTypKurzu.findByAkceJsTypKurzu1tvar", query = "SELECT a FROM AkceJsTypKurzu a WHERE a.akceJsTypKurzu1tvar = :akceJsTypKurzu1tvar"),
    @NamedQuery(name = "AkceJsTypKurzu.findByAkceJsTypKurzuPoradiVyber", query = "SELECT a FROM AkceJsTypKurzu a WHERE a.akceJsTypKurzuPoradiVyber = :akceJsTypKurzuPoradiVyber"),
    @NamedQuery(name = "AkceJsTypKurzu.findByAkceJsTypKurzuPoznamky", query = "SELECT a FROM AkceJsTypKurzu a WHERE a.akceJsTypKurzuPoznamky = :akceJsTypKurzuPoznamky")})
public class AkceJsTypKurzu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_js_typ_kurzu_id")
    private Integer akceJsTypKurzuId;
    @Size(max = 50)
    @Column(name = "akce_js_typ_kurzu_nazev")
    private String akceJsTypKurzuNazev;
    @Size(max = 50)
    @Column(name = "akce_js_typ_kurzu_1tvar")
    private String akceJsTypKurzu1tvar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akce_js_typ_kurzu_poradi_vyber")
    private int akceJsTypKurzuPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "akce_js_typ_kurzu_poznamky")
    private String akceJsTypKurzuPoznamky;
    @OneToMany(mappedBy = "akceJsDetailyTypKurzu")
    private Collection<AkceJsDetaily> akceJsDetailyCollection;

    public AkceJsTypKurzu() {
    }

    public AkceJsTypKurzu(Integer akceJsTypKurzuId) {
        this.akceJsTypKurzuId = akceJsTypKurzuId;
    }

    public AkceJsTypKurzu(Integer akceJsTypKurzuId, int akceJsTypKurzuPoradiVyber) {
        this.akceJsTypKurzuId = akceJsTypKurzuId;
        this.akceJsTypKurzuPoradiVyber = akceJsTypKurzuPoradiVyber;
    }

    public Integer getAkceJsTypKurzuId() {
        return akceJsTypKurzuId;
    }

    public void setAkceJsTypKurzuId(Integer akceJsTypKurzuId) {
        this.akceJsTypKurzuId = akceJsTypKurzuId;
    }

    public String getAkceJsTypKurzuNazev() {
        return akceJsTypKurzuNazev;
    }

    public void setAkceJsTypKurzuNazev(String akceJsTypKurzuNazev) {
        this.akceJsTypKurzuNazev = akceJsTypKurzuNazev;
    }

    public String getAkceJsTypKurzu1tvar() {
        return akceJsTypKurzu1tvar;
    }

    public void setAkceJsTypKurzu1tvar(String akceJsTypKurzu1tvar) {
        this.akceJsTypKurzu1tvar = akceJsTypKurzu1tvar;
    }

    public int getAkceJsTypKurzuPoradiVyber() {
        return akceJsTypKurzuPoradiVyber;
    }

    public void setAkceJsTypKurzuPoradiVyber(int akceJsTypKurzuPoradiVyber) {
        this.akceJsTypKurzuPoradiVyber = akceJsTypKurzuPoradiVyber;
    }

    public String getAkceJsTypKurzuPoznamky() {
        return akceJsTypKurzuPoznamky;
    }

    public void setAkceJsTypKurzuPoznamky(String akceJsTypKurzuPoznamky) {
        this.akceJsTypKurzuPoznamky = akceJsTypKurzuPoznamky;
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
        hash += (akceJsTypKurzuId != null ? akceJsTypKurzuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkceJsTypKurzu)) {
            return false;
        }
        AkceJsTypKurzu other = (AkceJsTypKurzu) object;
        if ((this.akceJsTypKurzuId == null && other.akceJsTypKurzuId != null) || (this.akceJsTypKurzuId != null && !this.akceJsTypKurzuId.equals(other.akceJsTypKurzuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AkceJsTypKurzu[ akceJsTypKurzuId=" + akceJsTypKurzuId + " ]";
    }
    
}
