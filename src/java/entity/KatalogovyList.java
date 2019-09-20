/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "katalogovy_list", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatalogovyList.findAll", query = "SELECT k FROM KatalogovyList k"),
    @NamedQuery(name = "KatalogovyList.findByKatalogovyListId", query = "SELECT k FROM KatalogovyList k WHERE k.katalogovyListPK.katalogovyListId = :katalogovyListId"),
    @NamedQuery(name = "KatalogovyList.findByKatalogovyListPrihlaskyId", query = "SELECT k FROM KatalogovyList k WHERE k.katalogovyListPK.katalogovyListPrihlaskyId = :katalogovyListPrihlaskyId"),
    @NamedQuery(name = "KatalogovyList.findByKatalogovyListPoradi", query = "SELECT k FROM KatalogovyList k WHERE k.katalogovyListPoradi = :katalogovyListPoradi"),
    @NamedQuery(name = "KatalogovyList.findByKatalogovyListDatumOsvedceni", query = "SELECT k FROM KatalogovyList k WHERE k.katalogovyListDatumOsvedceni = :katalogovyListDatumOsvedceni"),
    @NamedQuery(name = "KatalogovyList.findByKatalogovyListPoznamky", query = "SELECT k FROM KatalogovyList k WHERE k.katalogovyListPoznamky = :katalogovyListPoznamky")})
public class KatalogovyList implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KatalogovyListPK katalogovyListPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "katalogovy_list_poradi")
    private int katalogovyListPoradi;
    @Column(name = "katalogovy_list_datum_osvedceni")
    @Temporal(TemporalType.DATE)
    private Date katalogovyListDatumOsvedceni;
    @Size(max = 250)
    @Column(name = "katalogovy_list_poznamky")
    private String katalogovyListPoznamky;
    @JoinColumn(name = "katalogovy_list_prihlasky_id", referencedColumnName = "polozka", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PrihlaskyRozpisyJs prihlaskyRozpisyJs;

    public KatalogovyList() {
    }

    public KatalogovyList(KatalogovyListPK katalogovyListPK) {
        this.katalogovyListPK = katalogovyListPK;
    }

    public KatalogovyList(KatalogovyListPK katalogovyListPK, int katalogovyListPoradi) {
        this.katalogovyListPK = katalogovyListPK;
        this.katalogovyListPoradi = katalogovyListPoradi;
    }

    public KatalogovyList(int katalogovyListId, int katalogovyListPrihlaskyId) {
        this.katalogovyListPK = new KatalogovyListPK(katalogovyListId, katalogovyListPrihlaskyId);
    }

    public KatalogovyListPK getKatalogovyListPK() {
        return katalogovyListPK;
    }

    public void setKatalogovyListPK(KatalogovyListPK katalogovyListPK) {
        this.katalogovyListPK = katalogovyListPK;
    }

    public int getKatalogovyListPoradi() {
        return katalogovyListPoradi;
    }

    public void setKatalogovyListPoradi(int katalogovyListPoradi) {
        this.katalogovyListPoradi = katalogovyListPoradi;
    }

    public Date getKatalogovyListDatumOsvedceni() {
        return katalogovyListDatumOsvedceni;
    }

    public void setKatalogovyListDatumOsvedceni(Date katalogovyListDatumOsvedceni) {
        this.katalogovyListDatumOsvedceni = katalogovyListDatumOsvedceni;
    }

    public String getKatalogovyListPoznamky() {
        return katalogovyListPoznamky;
    }

    public void setKatalogovyListPoznamky(String katalogovyListPoznamky) {
        this.katalogovyListPoznamky = katalogovyListPoznamky;
    }

    public PrihlaskyRozpisyJs getPrihlaskyRozpisyJs() {
        return prihlaskyRozpisyJs;
    }

    public void setPrihlaskyRozpisyJs(PrihlaskyRozpisyJs prihlaskyRozpisyJs) {
        this.prihlaskyRozpisyJs = prihlaskyRozpisyJs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (katalogovyListPK != null ? katalogovyListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatalogovyList)) {
            return false;
        }
        KatalogovyList other = (KatalogovyList) object;
        if ((this.katalogovyListPK == null && other.katalogovyListPK != null) || (this.katalogovyListPK != null && !this.katalogovyListPK.equals(other.katalogovyListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KatalogovyList[ katalogovyListPK=" + katalogovyListPK + " ]";
    }
    
}
