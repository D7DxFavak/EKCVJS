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
@Table(name = "kat_org_typy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatOrgTypy.findAll", query = "SELECT k FROM KatOrgTypy k"),
    @NamedQuery(name = "KatOrgTypy.findByKatorgtypId", query = "SELECT k FROM KatOrgTypy k WHERE k.katorgtypId = :katorgtypId"),
    @NamedQuery(name = "KatOrgTypy.findByNazev", query = "SELECT k FROM KatOrgTypy k WHERE k.nazev = :nazev"),
    @NamedQuery(name = "KatOrgTypy.findByVyzadIzo", query = "SELECT k FROM KatOrgTypy k WHERE k.vyzadIzo = :vyzadIzo"),
    @NamedQuery(name = "KatOrgTypy.findByVyzadIco", query = "SELECT k FROM KatOrgTypy k WHERE k.vyzadIco = :vyzadIco"),
    @NamedQuery(name = "KatOrgTypy.findByVyzadDic", query = "SELECT k FROM KatOrgTypy k WHERE k.vyzadDic = :vyzadDic"),
    @NamedQuery(name = "KatOrgTypy.findByVyzadNs", query = "SELECT k FROM KatOrgTypy k WHERE k.vyzadNs = :vyzadNs"),
    @NamedQuery(name = "KatOrgTypy.findByVyzadBankkontakt", query = "SELECT k FROM KatOrgTypy k WHERE k.vyzadBankkontakt = :vyzadBankkontakt"),
    @NamedQuery(name = "KatOrgTypy.findByPoznamky", query = "SELECT k FROM KatOrgTypy k WHERE k.poznamky = :poznamky")})
public class KatOrgTypy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "katorgtyp_id")
    private Integer katorgtypId;
    @Size(max = 100)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyzad_izo")
    private boolean vyzadIzo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyzad_ico")
    private boolean vyzadIco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyzad_dic")
    private boolean vyzadDic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyzad_ns")
    private boolean vyzadNs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vyzad_bankkontakt")
    private boolean vyzadBankkontakt;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "katOrgTypy")
    private Collection<KatOrgPolozky> katOrgPolozkyCollection;
    @OneToMany(mappedBy = "katorgtyp")
    private Collection<Organizace> organizaceCollection;

    public KatOrgTypy() {
    }

    public KatOrgTypy(Integer katorgtypId) {
        this.katorgtypId = katorgtypId;
    }

    public KatOrgTypy(Integer katorgtypId, boolean vyzadIzo, boolean vyzadIco, boolean vyzadDic, boolean vyzadNs, boolean vyzadBankkontakt) {
        this.katorgtypId = katorgtypId;
        this.vyzadIzo = vyzadIzo;
        this.vyzadIco = vyzadIco;
        this.vyzadDic = vyzadDic;
        this.vyzadNs = vyzadNs;
        this.vyzadBankkontakt = vyzadBankkontakt;
    }

    public Integer getKatorgtypId() {
        return katorgtypId;
    }

    public void setKatorgtypId(Integer katorgtypId) {
        this.katorgtypId = katorgtypId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean getVyzadIzo() {
        return vyzadIzo;
    }

    public void setVyzadIzo(boolean vyzadIzo) {
        this.vyzadIzo = vyzadIzo;
    }

    public boolean getVyzadIco() {
        return vyzadIco;
    }

    public void setVyzadIco(boolean vyzadIco) {
        this.vyzadIco = vyzadIco;
    }

    public boolean getVyzadDic() {
        return vyzadDic;
    }

    public void setVyzadDic(boolean vyzadDic) {
        this.vyzadDic = vyzadDic;
    }

    public boolean getVyzadNs() {
        return vyzadNs;
    }

    public void setVyzadNs(boolean vyzadNs) {
        this.vyzadNs = vyzadNs;
    }

    public boolean getVyzadBankkontakt() {
        return vyzadBankkontakt;
    }

    public void setVyzadBankkontakt(boolean vyzadBankkontakt) {
        this.vyzadBankkontakt = vyzadBankkontakt;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<KatOrgPolozky> getKatOrgPolozkyCollection() {
        return katOrgPolozkyCollection;
    }

    public void setKatOrgPolozkyCollection(Collection<KatOrgPolozky> katOrgPolozkyCollection) {
        this.katOrgPolozkyCollection = katOrgPolozkyCollection;
    }

    @XmlTransient
    public Collection<Organizace> getOrganizaceCollection() {
        return organizaceCollection;
    }

    public void setOrganizaceCollection(Collection<Organizace> organizaceCollection) {
        this.organizaceCollection = organizaceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (katorgtypId != null ? katorgtypId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatOrgTypy)) {
            return false;
        }
        KatOrgTypy other = (KatOrgTypy) object;
        if ((this.katorgtypId == null && other.katorgtypId != null) || (this.katorgtypId != null && !this.katorgtypId.equals(other.katorgtypId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KatOrgTypy[ katorgtypId=" + katorgtypId + " ]";
    }
    
}
