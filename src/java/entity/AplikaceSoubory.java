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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "aplikace_soubory", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplikaceSoubory.findAll", query = "SELECT a FROM AplikaceSoubory a"),
    @NamedQuery(name = "AplikaceSoubory.findByAplikaceSouboryNazev", query = "SELECT a FROM AplikaceSoubory a WHERE a.aplikaceSouboryNazev = :aplikaceSouboryNazev"),
    @NamedQuery(name = "AplikaceSoubory.findByAplikaceSouboryHashMd5", query = "SELECT a FROM AplikaceSoubory a WHERE a.aplikaceSouboryHashMd5 = :aplikaceSouboryHashMd5")})
public class AplikaceSoubory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "aplikace_soubory_nazev")
    private String aplikaceSouboryNazev;
    @Size(max = 250)
    @Column(name = "aplikace_soubory_hash_md5")
    private String aplikaceSouboryHashMd5;
    @Lob
    @Column(name = "aplikace_soubory_data")
    private byte[] aplikaceSouboryData;

    public AplikaceSoubory() {
    }

    public AplikaceSoubory(String aplikaceSouboryNazev) {
        this.aplikaceSouboryNazev = aplikaceSouboryNazev;
    }

    public String getAplikaceSouboryNazev() {
        return aplikaceSouboryNazev;
    }

    public void setAplikaceSouboryNazev(String aplikaceSouboryNazev) {
        this.aplikaceSouboryNazev = aplikaceSouboryNazev;
    }

    public String getAplikaceSouboryHashMd5() {
        return aplikaceSouboryHashMd5;
    }

    public void setAplikaceSouboryHashMd5(String aplikaceSouboryHashMd5) {
        this.aplikaceSouboryHashMd5 = aplikaceSouboryHashMd5;
    }

    public byte[] getAplikaceSouboryData() {
        return aplikaceSouboryData;
    }

    public void setAplikaceSouboryData(byte[] aplikaceSouboryData) {
        this.aplikaceSouboryData = aplikaceSouboryData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aplikaceSouboryNazev != null ? aplikaceSouboryNazev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplikaceSoubory)) {
            return false;
        }
        AplikaceSoubory other = (AplikaceSoubory) object;
        if ((this.aplikaceSouboryNazev == null && other.aplikaceSouboryNazev != null) || (this.aplikaceSouboryNazev != null && !this.aplikaceSouboryNazev.equals(other.aplikaceSouboryNazev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AplikaceSoubory[ aplikaceSouboryNazev=" + aplikaceSouboryNazev + " ]";
    }
    
}
