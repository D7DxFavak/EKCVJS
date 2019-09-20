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
@Table(name = "ucebny_alokace_druhy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UcebnyAlokaceDruhy.findAll", query = "SELECT u FROM UcebnyAlokaceDruhy u"),
    @NamedQuery(name = "UcebnyAlokaceDruhy.findByAlokaceId", query = "SELECT u FROM UcebnyAlokaceDruhy u WHERE u.alokaceId = :alokaceId"),
    @NamedQuery(name = "UcebnyAlokaceDruhy.findByNazev", query = "SELECT u FROM UcebnyAlokaceDruhy u WHERE u.nazev = :nazev"),
    @NamedQuery(name = "UcebnyAlokaceDruhy.findByPoznamky", query = "SELECT u FROM UcebnyAlokaceDruhy u WHERE u.poznamky = :poznamky")})
public class UcebnyAlokaceDruhy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alokace_id")
    private Integer alokaceId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;

    public UcebnyAlokaceDruhy() {
    }

    public UcebnyAlokaceDruhy(Integer alokaceId) {
        this.alokaceId = alokaceId;
    }

    public Integer getAlokaceId() {
        return alokaceId;
    }

    public void setAlokaceId(Integer alokaceId) {
        this.alokaceId = alokaceId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
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
        hash += (alokaceId != null ? alokaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UcebnyAlokaceDruhy)) {
            return false;
        }
        UcebnyAlokaceDruhy other = (UcebnyAlokaceDruhy) object;
        if ((this.alokaceId == null && other.alokaceId != null) || (this.alokaceId != null && !this.alokaceId.equals(other.alokaceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UcebnyAlokaceDruhy[ alokaceId=" + alokaceId + " ]";
    }
    
}
