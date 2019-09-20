/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "uloziste_data", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UlozisteData.findAll", query = "SELECT u FROM UlozisteData u"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataId", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataId = :ulozisteDataId"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataNazev", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataNazev = :ulozisteDataNazev"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataPopis", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataPopis = :ulozisteDataPopis"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataPoznamky", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataPoznamky = :ulozisteDataPoznamky"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataMd5", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataMd5 = :ulozisteDataMd5"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataCislo", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataCislo = :ulozisteDataCislo"),
    @NamedQuery(name = "UlozisteData.findByUlozisteDataVlozeno", query = "SELECT u FROM UlozisteData u WHERE u.ulozisteDataVlozeno = :ulozisteDataVlozeno")})
public class UlozisteData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uloziste_data_id")
    private Integer ulozisteDataId;
    @Size(max = 250)
    @Column(name = "uloziste_data_nazev")
    private String ulozisteDataNazev;
    @Size(max = 2147483647)
    @Column(name = "uloziste_data_popis")
    private String ulozisteDataPopis;
    @Lob
    @Column(name = "uloziste_data_data")
    private byte[] ulozisteDataData;
    @Size(max = 2147483647)
    @Column(name = "uloziste_data_poznamky")
    private String ulozisteDataPoznamky;
    @Size(max = 250)
    @Column(name = "uloziste_data_md5")
    private String ulozisteDataMd5;
    @Column(name = "uloziste_data_cislo")
    private BigInteger ulozisteDataCislo;
    @Column(name = "uloziste_data_vlozeno")
    @Temporal(TemporalType.DATE)
    private Date ulozisteDataVlozeno;
    @JoinColumn(name = "uloziste_data_druh_id", referencedColumnName = "uloziste_data_druhy_id")
    @ManyToOne(optional = false)
    private UlozisteDataDruhy ulozisteDataDruhId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteData")
    private Collection<VazbaAkreditaceUlozisteData> vazbaAkreditaceUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteData")
    private Collection<VazbaOsobyUlozisteData> vazbaOsobyUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteData")
    private Collection<VazbaPrihlaskyUlozisteData> vazbaPrihlaskyUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteData")
    private Collection<VazbaFakturyUlozisteData> vazbaFakturyUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteData")
    private Collection<VazbaAkceUlozisteData> vazbaAkceUlozisteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ulozisteData")
    private Collection<VazbaPrihlaskyJsUlozisteData> vazbaPrihlaskyJsUlozisteDataCollection;
    @Transient
    private String ulozisteDataTyp;

    public UlozisteData() {
    }

    public UlozisteData(Integer ulozisteDataId) {
        this.ulozisteDataId = ulozisteDataId;
    }

    public Integer getUlozisteDataId() {
        return ulozisteDataId;
    }

    public void setUlozisteDataId(Integer ulozisteDataId) {
        this.ulozisteDataId = ulozisteDataId;
    }

    public String getUlozisteDataNazev() {
        return ulozisteDataNazev;
    }

    public void setUlozisteDataNazev(String ulozisteDataNazev) {
        this.ulozisteDataNazev = ulozisteDataNazev;
    }

    public String getUlozisteDataPopis() {
        return ulozisteDataPopis;
    }

    public void setUlozisteDataPopis(String ulozisteDataPopis) {
        this.ulozisteDataPopis = ulozisteDataPopis;
    }

    public byte[] getUlozisteDataData() {        
        return ulozisteDataData;
    }

    public void setUlozisteDataData(byte[] ulozisteDataData) {
        this.ulozisteDataData = ulozisteDataData;
    }

    public String getUlozisteDataPoznamky() {        
        return ulozisteDataPoznamky;
    }

    public void setUlozisteDataPoznamky(String ulozisteDataPoznamky) {
        this.ulozisteDataPoznamky = ulozisteDataPoznamky;
    }

    public String getUlozisteDataMd5() {
        return ulozisteDataMd5;
    }

    public void setUlozisteDataMd5(String ulozisteDataMd5) {
        this.ulozisteDataMd5 = ulozisteDataMd5;
    }

    public BigInteger getUlozisteDataCislo() {
        return ulozisteDataCislo;
    }

    public void setUlozisteDataCislo(BigInteger ulozisteDataCislo) {
        this.ulozisteDataCislo = ulozisteDataCislo;
    }

    public Date getUlozisteDataVlozeno() {
        return ulozisteDataVlozeno;
    }

    public void setUlozisteDataVlozeno(Date ulozisteDataVlozeno) {
        this.ulozisteDataVlozeno = ulozisteDataVlozeno;
    }

    public UlozisteDataDruhy getUlozisteDataDruhId() {
        return ulozisteDataDruhId;
    }

    public void setUlozisteDataDruhId(UlozisteDataDruhy ulozisteDataDruhId) {
        this.ulozisteDataDruhId = ulozisteDataDruhId;
    }

    @XmlTransient
    public Collection<VazbaAkreditaceUlozisteData> getVazbaAkreditaceUlozisteDataCollection() {
        return vazbaAkreditaceUlozisteDataCollection;
    }

    public void setVazbaAkreditaceUlozisteDataCollection(Collection<VazbaAkreditaceUlozisteData> vazbaAkreditaceUlozisteDataCollection) {
        this.vazbaAkreditaceUlozisteDataCollection = vazbaAkreditaceUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<VazbaOsobyUlozisteData> getVazbaOsobyUlozisteDataCollection() {
        return vazbaOsobyUlozisteDataCollection;
    }

    public void setVazbaOsobyUlozisteDataCollection(Collection<VazbaOsobyUlozisteData> vazbaOsobyUlozisteDataCollection) {
        this.vazbaOsobyUlozisteDataCollection = vazbaOsobyUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<VazbaPrihlaskyUlozisteData> getVazbaPrihlaskyUlozisteDataCollection() {
        return vazbaPrihlaskyUlozisteDataCollection;
    }

    public void setVazbaPrihlaskyUlozisteDataCollection(Collection<VazbaPrihlaskyUlozisteData> vazbaPrihlaskyUlozisteDataCollection) {
        this.vazbaPrihlaskyUlozisteDataCollection = vazbaPrihlaskyUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<VazbaFakturyUlozisteData> getVazbaFakturyUlozisteDataCollection() {
        return vazbaFakturyUlozisteDataCollection;
    }

    public void setVazbaFakturyUlozisteDataCollection(Collection<VazbaFakturyUlozisteData> vazbaFakturyUlozisteDataCollection) {
        this.vazbaFakturyUlozisteDataCollection = vazbaFakturyUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<VazbaAkceUlozisteData> getVazbaAkceUlozisteDataCollection() {
        return vazbaAkceUlozisteDataCollection;
    }

    public void setVazbaAkceUlozisteDataCollection(Collection<VazbaAkceUlozisteData> vazbaAkceUlozisteDataCollection) {
        this.vazbaAkceUlozisteDataCollection = vazbaAkceUlozisteDataCollection;
    }

    @XmlTransient
    public Collection<VazbaPrihlaskyJsUlozisteData> getVazbaPrihlaskyJsUlozisteDataCollection() {
        return vazbaPrihlaskyJsUlozisteDataCollection;
    }

    public void setVazbaPrihlaskyJsUlozisteDataCollection(Collection<VazbaPrihlaskyJsUlozisteData> vazbaPrihlaskyJsUlozisteDataCollection) {
        this.vazbaPrihlaskyJsUlozisteDataCollection = vazbaPrihlaskyJsUlozisteDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ulozisteDataId != null ? ulozisteDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UlozisteData)) {
            return false;
        }
        UlozisteData other = (UlozisteData) object;
        if ((this.ulozisteDataId == null && other.ulozisteDataId != null) || (this.ulozisteDataId != null && !this.ulozisteDataId.equals(other.ulozisteDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UlozisteData[ ulozisteDataId=" + ulozisteDataId + " ]";
    }

    public String getVelikost() {
        long velikost = ulozisteDataData.length;
        if (velikost > (1024 * 1024)) {
            return (velikost / (1024 * 1024)) + " MB";
        } else if (velikost > (1024)) {
            return (velikost / 1024) + " kB";
        } else {
            return velikost + " B";
        }
    }

    /**
     * @return the ulozisteDataTyp
     */
    public String getUlozisteDataTyp() {
        return ulozisteDataNazev.substring(ulozisteDataNazev.indexOf(".") + 1);
    }

    /**
     * @param ulozisteDataTyp the ulozisteDataTyp to set
     */
    public void setUlozisteDataTyp(String ulozisteDataTyp) {
        this.ulozisteDataTyp = ulozisteDataTyp;
    }
}
