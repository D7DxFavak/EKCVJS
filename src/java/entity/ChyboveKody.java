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
@Table(name = "chybove_kody", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChyboveKody.findAll", query = "SELECT c FROM ChyboveKody c"),
    @NamedQuery(name = "ChyboveKody.findByChybaId", query = "SELECT c FROM ChyboveKody c WHERE c.chybaId = :chybaId"),
    @NamedQuery(name = "ChyboveKody.findByNazev", query = "SELECT c FROM ChyboveKody c WHERE c.nazev = :nazev"),
    @NamedQuery(name = "ChyboveKody.findByPopis", query = "SELECT c FROM ChyboveKody c WHERE c.popis = :popis"),
    @NamedQuery(name = "ChyboveKody.findByMoznaReseni", query = "SELECT c FROM ChyboveKody c WHERE c.moznaReseni = :moznaReseni"),
    @NamedQuery(name = "ChyboveKody.findByPoznamky", query = "SELECT c FROM ChyboveKody c WHERE c.poznamky = :poznamky")})
public class ChyboveKody implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "chyba_id")
    private Integer chybaId;
    @Size(max = 200)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 1000)
    @Column(name = "popis")
    private String popis;
    @Size(max = 2147483647)
    @Column(name = "mozna_reseni")
    private String moznaReseni;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;

    public ChyboveKody() {
    }

    public ChyboveKody(Integer chybaId) {
        this.chybaId = chybaId;
    }

    public Integer getChybaId() {
        return chybaId;
    }

    public void setChybaId(Integer chybaId) {
        this.chybaId = chybaId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getMoznaReseni() {
        return moznaReseni;
    }

    public void setMoznaReseni(String moznaReseni) {
        this.moznaReseni = moznaReseni;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chybaId != null ? chybaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChyboveKody)) {
            return false;
        }
        ChyboveKody other = (ChyboveKody) object;
        if ((this.chybaId == null && other.chybaId != null) || (this.chybaId != null && !this.chybaId.equals(other.chybaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ChyboveKody[ chybaId=" + chybaId + " ]";
    }
    
}
