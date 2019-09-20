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
@Table(name = "dokumenty_druhy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DokumentyDruhy.findAll", query = "SELECT d FROM DokumentyDruhy d"),
    @NamedQuery(name = "DokumentyDruhy.findByDokumentyDruhyId", query = "SELECT d FROM DokumentyDruhy d WHERE d.dokumentyDruhyId = :dokumentyDruhyId"),
    @NamedQuery(name = "DokumentyDruhy.findByDokumentyDruhyNazev", query = "SELECT d FROM DokumentyDruhy d WHERE d.dokumentyDruhyNazev = :dokumentyDruhyNazev"),
    @NamedQuery(name = "DokumentyDruhy.findByDokumentyDruhyPopis", query = "SELECT d FROM DokumentyDruhy d WHERE d.dokumentyDruhyPopis = :dokumentyDruhyPopis"),
    @NamedQuery(name = "DokumentyDruhy.findByDokumentyDruhySestavaText", query = "SELECT d FROM DokumentyDruhy d WHERE d.dokumentyDruhySestavaText = :dokumentyDruhySestavaText"),
    @NamedQuery(name = "DokumentyDruhy.findByDokumentyDruhyPoradiVyber", query = "SELECT d FROM DokumentyDruhy d WHERE d.dokumentyDruhyPoradiVyber = :dokumentyDruhyPoradiVyber"),
    @NamedQuery(name = "DokumentyDruhy.findByDokumentyDruhyPoznamky", query = "SELECT d FROM DokumentyDruhy d WHERE d.dokumentyDruhyPoznamky = :dokumentyDruhyPoznamky")})
public class DokumentyDruhy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dokumenty_druhy_id")
    private Integer dokumentyDruhyId;
    @Size(max = 250)
    @Column(name = "dokumenty_druhy_nazev")
    private String dokumentyDruhyNazev;
    @Size(max = 2147483647)
    @Column(name = "dokumenty_druhy_popis")
    private String dokumentyDruhyPopis;
    @Size(max = 2147483647)
    @Column(name = "dokumenty_druhy_sestava_text")
    private String dokumentyDruhySestavaText;
    @Lob
    @Column(name = "dokumenty_druhy_sestava_data")
    private byte[] dokumentyDruhySestavaData;
    @Column(name = "dokumenty_druhy_poradi_vyber")
    private Integer dokumentyDruhyPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "dokumenty_druhy_poznamky")
    private String dokumentyDruhyPoznamky;

    public DokumentyDruhy() {
    }

    public DokumentyDruhy(Integer dokumentyDruhyId) {
        this.dokumentyDruhyId = dokumentyDruhyId;
    }

    public Integer getDokumentyDruhyId() {
        return dokumentyDruhyId;
    }

    public void setDokumentyDruhyId(Integer dokumentyDruhyId) {
        this.dokumentyDruhyId = dokumentyDruhyId;
    }

    public String getDokumentyDruhyNazev() {
        return dokumentyDruhyNazev;
    }

    public void setDokumentyDruhyNazev(String dokumentyDruhyNazev) {
        this.dokumentyDruhyNazev = dokumentyDruhyNazev;
    }

    public String getDokumentyDruhyPopis() {
        return dokumentyDruhyPopis;
    }

    public void setDokumentyDruhyPopis(String dokumentyDruhyPopis) {
        this.dokumentyDruhyPopis = dokumentyDruhyPopis;
    }

    public String getDokumentyDruhySestavaText() {
        return dokumentyDruhySestavaText;
    }

    public void setDokumentyDruhySestavaText(String dokumentyDruhySestavaText) {
        this.dokumentyDruhySestavaText = dokumentyDruhySestavaText;
    }

    public byte[] getDokumentyDruhySestavaData() {
        return dokumentyDruhySestavaData;
    }

    public void setDokumentyDruhySestavaData(byte[] dokumentyDruhySestavaData) {
        this.dokumentyDruhySestavaData = dokumentyDruhySestavaData;
    }

    public Integer getDokumentyDruhyPoradiVyber() {
        return dokumentyDruhyPoradiVyber;
    }

    public void setDokumentyDruhyPoradiVyber(Integer dokumentyDruhyPoradiVyber) {
        this.dokumentyDruhyPoradiVyber = dokumentyDruhyPoradiVyber;
    }

    public String getDokumentyDruhyPoznamky() {
        return dokumentyDruhyPoznamky;
    }

    public void setDokumentyDruhyPoznamky(String dokumentyDruhyPoznamky) {
        this.dokumentyDruhyPoznamky = dokumentyDruhyPoznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dokumentyDruhyId != null ? dokumentyDruhyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DokumentyDruhy)) {
            return false;
        }
        DokumentyDruhy other = (DokumentyDruhy) object;
        if ((this.dokumentyDruhyId == null && other.dokumentyDruhyId != null) || (this.dokumentyDruhyId != null && !this.dokumentyDruhyId.equals(other.dokumentyDruhyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DokumentyDruhy[ dokumentyDruhyId=" + dokumentyDruhyId + " ]";
    }
    
}
