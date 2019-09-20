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
@Table(name = "statni_prislusnost", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatniPrislusnost.findAll", query = "SELECT s FROM StatniPrislusnost s ORDER BY s.statniPrislusnostPoradiVyber"),
    @NamedQuery(name = "StatniPrislusnost.findByStatniPrislusnostId", query = "SELECT s FROM StatniPrislusnost s WHERE s.statniPrislusnostId = :statniPrislusnostId"),
    @NamedQuery(name = "StatniPrislusnost.findByStatniPrislusnostNazev", query = "SELECT s FROM StatniPrislusnost s WHERE s.statniPrislusnostNazev = :statniPrislusnostNazev"),
    @NamedQuery(name = "StatniPrislusnost.findByStatniPrislusnostPoradiVyber", query = "SELECT s FROM StatniPrislusnost s WHERE s.statniPrislusnostPoradiVyber = :statniPrislusnostPoradiVyber"),
    @NamedQuery(name = "StatniPrislusnost.findByStatniPrislusnostPoznamky", query = "SELECT s FROM StatniPrislusnost s WHERE s.statniPrislusnostPoznamky = :statniPrislusnostPoznamky"),
    @NamedQuery(name = "StatniPrislusnost.findByStatniPrislusnostNazevEn", query = "SELECT s FROM StatniPrislusnost s WHERE s.statniPrislusnostNazevEn = :statniPrislusnostNazevEn"),
    @NamedQuery(name = "StatniPrislusnost.findByStatniPrislusnostNazevDe", query = "SELECT s FROM StatniPrislusnost s WHERE s.statniPrislusnostNazevDe = :statniPrislusnostNazevDe")})
public class StatniPrislusnost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "statni_prislusnost_id")
    private Integer statniPrislusnostId;
    @Size(max = 250)
    @Column(name = "statni_prislusnost_nazev")
    private String statniPrislusnostNazev;
    @Column(name = "statni_prislusnost_poradi_vyber")
    private Integer statniPrislusnostPoradiVyber;
    @Size(max = 2147483647)
    @Column(name = "statni_prislusnost_poznamky")
    private String statniPrislusnostPoznamky;
    @Size(max = 250)
    @Column(name = "statni_prislusnost_nazev_en")
    private String statniPrislusnostNazevEn;
    @Size(max = 250)
    @Column(name = "statni_prislusnost_nazev_de")
    private String statniPrislusnostNazevDe;

    public StatniPrislusnost() {
    }

    public StatniPrislusnost(Integer statniPrislusnostId) {
        this.statniPrislusnostId = statniPrislusnostId;
    }

    public Integer getStatniPrislusnostId() {
        return statniPrislusnostId;
    }

    public void setStatniPrislusnostId(Integer statniPrislusnostId) {
        this.statniPrislusnostId = statniPrislusnostId;
    }

    public String getStatniPrislusnostNazev() {
        return statniPrislusnostNazev;
    }

    public void setStatniPrislusnostNazev(String statniPrislusnostNazev) {
        this.statniPrislusnostNazev = statniPrislusnostNazev;
    }

    public Integer getStatniPrislusnostPoradiVyber() {
        return statniPrislusnostPoradiVyber;
    }

    public void setStatniPrislusnostPoradiVyber(Integer statniPrislusnostPoradiVyber) {
        this.statniPrislusnostPoradiVyber = statniPrislusnostPoradiVyber;
    }

    public String getStatniPrislusnostPoznamky() {
        return statniPrislusnostPoznamky;
    }

    public void setStatniPrislusnostPoznamky(String statniPrislusnostPoznamky) {
        this.statniPrislusnostPoznamky = statniPrislusnostPoznamky;
    }

    public String getStatniPrislusnostNazevEn() {
        return statniPrislusnostNazevEn;
    }

    public void setStatniPrislusnostNazevEn(String statniPrislusnostNazevEn) {
        this.statniPrislusnostNazevEn = statniPrislusnostNazevEn;
    }

    public String getStatniPrislusnostNazevDe() {
        return statniPrislusnostNazevDe;
    }

    public void setStatniPrislusnostNazevDe(String statniPrislusnostNazevDe) {
        this.statniPrislusnostNazevDe = statniPrislusnostNazevDe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statniPrislusnostId != null ? statniPrislusnostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatniPrislusnost)) {
            return false;
        }
        StatniPrislusnost other = (StatniPrislusnost) object;
        if ((this.statniPrislusnostId == null && other.statniPrislusnostId != null) || (this.statniPrislusnostId != null && !this.statniPrislusnostId.equals(other.statniPrislusnostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StatniPrislusnost[ statniPrislusnostId=" + statniPrislusnostId + " ]";
    }
    
}
