/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Favak
 */
@Entity
@Table(name = "narodnost", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Narodnost.findAll", query = "SELECT n FROM Narodnost n ORDER BY n.narodnostPoradiVyber"),
    @NamedQuery(name = "Narodnost.findByNarodnostId", query = "SELECT n FROM Narodnost n WHERE n.narodnostId = :narodnostId"),
    @NamedQuery(name = "Narodnost.findByNarodnostNazev", query = "SELECT n FROM Narodnost n WHERE n.narodnostNazev = :narodnostNazev"),
    @NamedQuery(name = "Narodnost.findByNarodnostPoradiVyber", query = "SELECT n FROM Narodnost n WHERE n.narodnostPoradiVyber = :narodnostPoradiVyber"),
    @NamedQuery(name = "Narodnost.findByNarodnostPoznamky", query = "SELECT n FROM Narodnost n WHERE n.narodnostPoznamky = :narodnostPoznamky"),
    @NamedQuery(name = "Narodnost.findByNarodnostNazevEn", query = "SELECT n FROM Narodnost n WHERE n.narodnostNazevEn = :narodnostNazevEn"),
    @NamedQuery(name = "Narodnost.findByNarodnostNazevDe", query = "SELECT n FROM Narodnost n WHERE n.narodnostNazevDe = :narodnostNazevDe")})
public class Narodnost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "narodnost_id")
    private Integer narodnostId;
    @Size(max = 250)
    @Column(name = "narodnost_nazev")
    private String narodnostNazev;
    @Column(name = "narodnost_poradi_vyber")
    private Integer narodnostPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "narodnost_poznamky")
    private String narodnostPoznamky;
    @Size(max = 250)
    @Column(name = "narodnost_nazev_en")
    private String narodnostNazevEn;
    @Size(max = 250)
    @Column(name = "narodnost_nazev_de")
    private String narodnostNazevDe;

    public Narodnost() {
    }

    public Narodnost(Integer narodnostId) {
        this.narodnostId = narodnostId;
    }

    public Integer getNarodnostId() {
        return narodnostId;
    }

    public void setNarodnostId(Integer narodnostId) {
        this.narodnostId = narodnostId;
    }

    public String getNarodnostNazev() {
        return narodnostNazev;
    }

    public void setNarodnostNazev(String narodnostNazev) {
        this.narodnostNazev = narodnostNazev;
    }

    public Integer getNarodnostPoradiVyber() {
        return narodnostPoradiVyber;
    }

    public void setNarodnostPoradiVyber(Integer narodnostPoradiVyber) {
        this.narodnostPoradiVyber = narodnostPoradiVyber;
    }

    public String getNarodnostPoznamky() {
        return narodnostPoznamky;
    }

    public void setNarodnostPoznamky(String narodnostPoznamky) {
        this.narodnostPoznamky = narodnostPoznamky;
    }

    public String getNarodnostNazevEn() {
        return narodnostNazevEn;
    }

    public void setNarodnostNazevEn(String narodnostNazevEn) {
        this.narodnostNazevEn = narodnostNazevEn;
    }

    public String getNarodnostNazevDe() {
        return narodnostNazevDe;
    }

    public void setNarodnostNazevDe(String narodnostNazevDe) {
        this.narodnostNazevDe = narodnostNazevDe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (narodnostId != null ? narodnostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Narodnost)) {
            return false;
        }
        Narodnost other = (Narodnost) object;
        if ((this.narodnostId == null && other.narodnostId != null) || (this.narodnostId != null && !this.narodnostId.equals(other.narodnostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Narodnost[ narodnostId=" + narodnostId + " ]";
    }
    
}
