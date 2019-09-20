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
import javax.persistence.Lob;
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
@Table(name = "uloziste_data_druhy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UlozisteDataDruhy.findAll", query = "SELECT u FROM UlozisteDataDruhy u"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyId", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyId = :ulozisteDataDruhyId"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyNazev", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyNazev = :ulozisteDataDruhyNazev"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyPopis", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyPopis = :ulozisteDataDruhyPopis"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyPoradiVyber", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyPoradiVyber = :ulozisteDataDruhyPoradiVyber"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyPoznamky", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyPoznamky = :ulozisteDataDruhyPoznamky"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyJeDvpp", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyJeDvpp = :ulozisteDataDruhyJeDvpp"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyJeJs", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyJeJs = :ulozisteDataDruhyJeJs"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyJeVystDok", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyJeVystDok = :ulozisteDataDruhyJeVystDok"),
    @NamedQuery(name = "UlozisteDataDruhy.findByUlozisteDataDruhyJeFaktura", query = "SELECT u FROM UlozisteDataDruhy u WHERE u.ulozisteDataDruhyJeFaktura = :ulozisteDataDruhyJeFaktura")})
public class UlozisteDataDruhy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uloziste_data_druhy_id")
    private Integer ulozisteDataDruhyId;
    @Size(max = 250)
    @Column(name = "uloziste_data_druhy_nazev")
    private String ulozisteDataDruhyNazev;
    @Size(max = 2147483647)
    @Column(name = "uloziste_data_druhy_popis")
    private String ulozisteDataDruhyPopis;
    @Lob
    @Column(name = "uloziste_data_druhy_data")
    private byte[] ulozisteDataDruhyData;
    @Column(name = "uloziste_data_druhy_poradi_vyber")
    private Integer ulozisteDataDruhyPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "uloziste_data_druhy_poznamky")
    private String ulozisteDataDruhyPoznamky;
    @Column(name = "uloziste_data_druhy_je_dvpp")
    private Boolean ulozisteDataDruhyJeDvpp;
    @Column(name = "uloziste_data_druhy_je_js")
    private Boolean ulozisteDataDruhyJeJs;
    @Column(name = "uloziste_data_druhy_je_vyst_dok")
    private Boolean ulozisteDataDruhyJeVystDok;
    @Column(name = "uloziste_data_druhy_je_faktura")
    private Boolean ulozisteDataDruhyJeFaktura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteDataDruhId")
    private Collection<UlozisteData> ulozisteDataCollection;

    public UlozisteDataDruhy() {
    }

    public UlozisteDataDruhy(Integer ulozisteDataDruhyId) {
        this.ulozisteDataDruhyId = ulozisteDataDruhyId;
    }

    public Integer getUlozisteDataDruhyId() {
        return ulozisteDataDruhyId;
    }

    public void setUlozisteDataDruhyId(Integer ulozisteDataDruhyId) {
        this.ulozisteDataDruhyId = ulozisteDataDruhyId;
    }

    public String getUlozisteDataDruhyNazev() {
        return ulozisteDataDruhyNazev;
    }

    public void setUlozisteDataDruhyNazev(String ulozisteDataDruhyNazev) {
        this.ulozisteDataDruhyNazev = ulozisteDataDruhyNazev;
    }

    public String getUlozisteDataDruhyPopis() {
        return ulozisteDataDruhyPopis;
    }

    public void setUlozisteDataDruhyPopis(String ulozisteDataDruhyPopis) {
        this.ulozisteDataDruhyPopis = ulozisteDataDruhyPopis;
    }

    public byte[] getUlozisteDataDruhyData() {
        return ulozisteDataDruhyData;
    }

    public void setUlozisteDataDruhyData(byte[] ulozisteDataDruhyData) {
        this.ulozisteDataDruhyData = ulozisteDataDruhyData;
    }

    public Integer getUlozisteDataDruhyPoradiVyber() {
        return ulozisteDataDruhyPoradiVyber;
    }

    public void setUlozisteDataDruhyPoradiVyber(Integer ulozisteDataDruhyPoradiVyber) {
        this.ulozisteDataDruhyPoradiVyber = ulozisteDataDruhyPoradiVyber;
    }

    public String getUlozisteDataDruhyPoznamky() {
        return ulozisteDataDruhyPoznamky;
    }

    public void setUlozisteDataDruhyPoznamky(String ulozisteDataDruhyPoznamky) {
        this.ulozisteDataDruhyPoznamky = ulozisteDataDruhyPoznamky;
    }

    public Boolean getUlozisteDataDruhyJeDvpp() {
        return ulozisteDataDruhyJeDvpp;
    }

    public void setUlozisteDataDruhyJeDvpp(Boolean ulozisteDataDruhyJeDvpp) {
        this.ulozisteDataDruhyJeDvpp = ulozisteDataDruhyJeDvpp;
    }

    public Boolean getUlozisteDataDruhyJeJs() {
        return ulozisteDataDruhyJeJs;
    }

    public void setUlozisteDataDruhyJeJs(Boolean ulozisteDataDruhyJeJs) {
        this.ulozisteDataDruhyJeJs = ulozisteDataDruhyJeJs;
    }

    public Boolean getUlozisteDataDruhyJeVystDok() {
        return ulozisteDataDruhyJeVystDok;
    }

    public void setUlozisteDataDruhyJeVystDok(Boolean ulozisteDataDruhyJeVystDok) {
        this.ulozisteDataDruhyJeVystDok = ulozisteDataDruhyJeVystDok;
    }

    public Boolean getUlozisteDataDruhyJeFaktura() {
        return ulozisteDataDruhyJeFaktura;
    }

    public void setUlozisteDataDruhyJeFaktura(Boolean ulozisteDataDruhyJeFaktura) {
        this.ulozisteDataDruhyJeFaktura = ulozisteDataDruhyJeFaktura;
    }

    @XmlTransient
    public Collection<UlozisteData> getUlozisteDataCollection() {
        return ulozisteDataCollection;
    }

    public void setUlozisteDataCollection(Collection<UlozisteData> ulozisteDataCollection) {
        this.ulozisteDataCollection = ulozisteDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ulozisteDataDruhyId != null ? ulozisteDataDruhyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UlozisteDataDruhy)) {
            return false;
        }
        UlozisteDataDruhy other = (UlozisteDataDruhy) object;
        if ((this.ulozisteDataDruhyId == null && other.ulozisteDataDruhyId != null) || (this.ulozisteDataDruhyId != null && !this.ulozisteDataDruhyId.equals(other.ulozisteDataDruhyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UlozisteDataDruhy[ ulozisteDataDruhyId=" + ulozisteDataDruhyId + " ]";
    }
    
}
