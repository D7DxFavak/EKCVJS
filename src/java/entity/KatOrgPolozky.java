/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kat_org_polozky", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatOrgPolozky.findAll", query = "SELECT k FROM KatOrgPolozky k"),
    @NamedQuery(name = "KatOrgPolozky.findByKatorgtypId", query = "SELECT k FROM KatOrgPolozky k WHERE k.katOrgPolozkyPK.katorgtypId = :katorgtypId"),
    @NamedQuery(name = "KatOrgPolozky.findByKatorgpolId", query = "SELECT k FROM KatOrgPolozky k WHERE k.katOrgPolozkyPK.katorgpolId = :katorgpolId"),
     @NamedQuery(name = "KatOrgPolozky.findById", query = "SELECT k FROM KatOrgPolozky k WHERE k.katOrgPolozkyPK.katorgpolId = :katorgpolId AND k.katOrgPolozkyPK.katorgtypId = :katorgtypId"),
    @NamedQuery(name = "KatOrgPolozky.findByNazev", query = "SELECT k FROM KatOrgPolozky k WHERE k.nazev = :nazev"),
    @NamedQuery(name = "KatOrgPolozky.findByVyzadIzo", query = "SELECT k FROM KatOrgPolozky k WHERE k.vyzadIzo = :vyzadIzo"),
    @NamedQuery(name = "KatOrgPolozky.findByVyzadIco", query = "SELECT k FROM KatOrgPolozky k WHERE k.vyzadIco = :vyzadIco"),
    @NamedQuery(name = "KatOrgPolozky.findByVyzadDic", query = "SELECT k FROM KatOrgPolozky k WHERE k.vyzadDic = :vyzadDic"),
    @NamedQuery(name = "KatOrgPolozky.findByVyzadNs", query = "SELECT k FROM KatOrgPolozky k WHERE k.vyzadNs = :vyzadNs"),
    @NamedQuery(name = "KatOrgPolozky.findByVyzadBankkontakt", query = "SELECT k FROM KatOrgPolozky k WHERE k.vyzadBankkontakt = :vyzadBankkontakt"),
    @NamedQuery(name = "KatOrgPolozky.findByPoznamky", query = "SELECT k FROM KatOrgPolozky k WHERE k.poznamky = :poznamky")})
public class KatOrgPolozky implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KatOrgPolozkyPK katOrgPolozkyPK;
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
    @JoinColumn(name = "katorgtyp_id", referencedColumnName = "katorgtyp_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KatOrgTypy katOrgTypy;
    @OneToMany(mappedBy = "katOrgPolozky")
    private Collection<Organizace> organizaceCollection;

    public KatOrgPolozky() {
    }

    public KatOrgPolozky(KatOrgPolozkyPK katOrgPolozkyPK) {
        this.katOrgPolozkyPK = katOrgPolozkyPK;
    }

    public KatOrgPolozky(KatOrgPolozkyPK katOrgPolozkyPK, boolean vyzadIzo, boolean vyzadIco, boolean vyzadDic, boolean vyzadNs, boolean vyzadBankkontakt) {
        this.katOrgPolozkyPK = katOrgPolozkyPK;
        this.vyzadIzo = vyzadIzo;
        this.vyzadIco = vyzadIco;
        this.vyzadDic = vyzadDic;
        this.vyzadNs = vyzadNs;
        this.vyzadBankkontakt = vyzadBankkontakt;
    }

    public KatOrgPolozky(int katorgtypId, int katorgpolId) {
        this.katOrgPolozkyPK = new KatOrgPolozkyPK(katorgtypId, katorgpolId);
    }

    public KatOrgPolozkyPK getKatOrgPolozkyPK() {
        return katOrgPolozkyPK;
    }

    public void setKatOrgPolozkyPK(KatOrgPolozkyPK katOrgPolozkyPK) {
        this.katOrgPolozkyPK = katOrgPolozkyPK;
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

    public KatOrgTypy getKatOrgTypy() {
        return katOrgTypy;
    }

    public void setKatOrgTypy(KatOrgTypy katOrgTypy) {
        this.katOrgTypy = katOrgTypy;
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
        hash += (katOrgPolozkyPK != null ? katOrgPolozkyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatOrgPolozky)) {
            return false;
        }
        KatOrgPolozky other = (KatOrgPolozky) object;
        if ((this.katOrgPolozkyPK == null && other.katOrgPolozkyPK != null) || (this.katOrgPolozkyPK != null && !this.katOrgPolozkyPK.equals(other.katOrgPolozkyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KatOrgPolozky[ katOrgPolozkyPK=" + katOrgPolozkyPK + " ]";
    }
    
}
