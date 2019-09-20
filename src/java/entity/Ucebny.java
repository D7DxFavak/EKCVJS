/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ucebny", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ucebny.findAll", query = "SELECT u FROM Ucebny u"),
    @NamedQuery(name = "Ucebny.findByUcebnaId", query = "SELECT u FROM Ucebny u WHERE u.ucebnaId = :ucebnaId"),
    @NamedQuery(name = "Ucebny.findByNazev", query = "SELECT u FROM Ucebny u WHERE u.nazev = :nazev"),
    @NamedQuery(name = "Ucebny.findByPopis", query = "SELECT u FROM Ucebny u WHERE u.popis = :popis"),
    @NamedQuery(name = "Ucebny.findByUmisteniObecne", query = "SELECT u FROM Ucebny u WHERE u.umisteniObecne = :umisteniObecne"),
    @NamedQuery(name = "Ucebny.findByKapacita", query = "SELECT u FROM Ucebny u WHERE u.kapacita = :kapacita"),
    @NamedQuery(name = "Ucebny.findByNajemJednotka", query = "SELECT u FROM Ucebny u WHERE u.najemJednotka = :najemJednotka"),
    @NamedQuery(name = "Ucebny.findByPoznamky", query = "SELECT u FROM Ucebny u WHERE u.poznamky = :poznamky")})
public class Ucebny implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ucebna_id")
    private Integer ucebnaId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Size(max = 2147483647)
    @Column(name = "popis")
    private String popis;
    @Size(max = 100)
    @Column(name = "umisteni_obecne")
    private String umisteniObecne;
    @Column(name = "kapacita")
    private Integer kapacita;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "najem_jednotka")
    private BigDecimal najemJednotka;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(mappedBy = "ucebna")
    private Collection<AkceRozpisy> akceRozpisyCollection;
    @JoinColumn(name = "umisteni_org", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace umisteniOrg;
    @JoinColumn(name = "cas_jednotka", referencedColumnName = "cas_jednotka_id")
    @ManyToOne
    private CasoveJednotky casJednotka;

    public Ucebny() {
    }

    public Ucebny(Integer ucebnaId) {
        this.ucebnaId = ucebnaId;
    }

    public Integer getUcebnaId() {
        return ucebnaId;
    }

    public void setUcebnaId(Integer ucebnaId) {
        this.ucebnaId = ucebnaId;
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

    public String getUmisteniObecne() {
        return umisteniObecne;
    }

    public void setUmisteniObecne(String umisteniObecne) {
        this.umisteniObecne = umisteniObecne;
    }

    public Integer getKapacita() {
        return kapacita;
    }

    public void setKapacita(Integer kapacita) {
        this.kapacita = kapacita;
    }

    public BigDecimal getNajemJednotka() {
        return najemJednotka;
    }

    public void setNajemJednotka(BigDecimal najemJednotka) {
        this.najemJednotka = najemJednotka;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<AkceRozpisy> getAkceRozpisyCollection() {
        return akceRozpisyCollection;
    }

    public void setAkceRozpisyCollection(Collection<AkceRozpisy> akceRozpisyCollection) {
        this.akceRozpisyCollection = akceRozpisyCollection;
    }

    public Organizace getUmisteniOrg() {
        return umisteniOrg;
    }

    public void setUmisteniOrg(Organizace umisteniOrg) {
        this.umisteniOrg = umisteniOrg;
    }

    public CasoveJednotky getCasJednotka() {
        return casJednotka;
    }

    public void setCasJednotka(CasoveJednotky casJednotka) {
        this.casJednotka = casJednotka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ucebnaId != null ? ucebnaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ucebny)) {
            return false;
        }
        Ucebny other = (Ucebny) object;
        if ((this.ucebnaId == null && other.ucebnaId != null) || (this.ucebnaId != null && !this.ucebnaId.equals(other.ucebnaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ucebny[ ucebnaId=" + ucebnaId + " ]";
    }
    
}
