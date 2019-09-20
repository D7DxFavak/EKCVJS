/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "prihl_faktury_rozpisy", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlFakturyRozpisy.findAll", query = "SELECT p FROM PrihlFakturyRozpisy p"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByPolozkaPrihl", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.prihlFakturyRozpisyPK.polozkaPrihl = :polozkaPrihl"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByCisloFaktury", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.prihlFakturyRozpisyPK.cisloFaktury = :cisloFaktury"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByCastkaPrihl", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.castkaPrihl = :castkaPrihl"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByKdyVlozeno", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByKdyZmeneno", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByKdoVlozil", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByKdoZmenil", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "PrihlFakturyRozpisy.findByPoznamky", query = "SELECT p FROM PrihlFakturyRozpisy p WHERE p.poznamky = :poznamky")})
public class PrihlFakturyRozpisy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrihlFakturyRozpisyPK prihlFakturyRozpisyPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "castka_prihl")
    private BigDecimal castkaPrihl;
    @Column(name = "kdy_vlozeno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyVlozeno;
    @Column(name = "kdy_zmeneno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kdyZmeneno;
    @Size(max = 100)
    @Column(name = "kdo_vlozil")
    private String kdoVlozil;
    @Size(max = 100)
    @Column(name = "kdo_zmenil")
    private String kdoZmenil;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @JoinColumn(name = "polozka_prihl", referencedColumnName = "polozka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrihlaskyRozpisy prihlaskyRozpisy;
    @JoinColumn(name = "cislo_faktury", referencedColumnName = "cislo_faktury", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KnihaFaktur knihaFaktur;

    public PrihlFakturyRozpisy() {
    }

    public PrihlFakturyRozpisy(PrihlFakturyRozpisyPK prihlFakturyRozpisyPK) {
        this.prihlFakturyRozpisyPK = prihlFakturyRozpisyPK;
    }

    public PrihlFakturyRozpisy(int polozkaPrihl, int cisloFaktury) {
        this.prihlFakturyRozpisyPK = new PrihlFakturyRozpisyPK(polozkaPrihl, cisloFaktury);
    }

    public PrihlFakturyRozpisyPK getPrihlFakturyRozpisyPK() {
        return prihlFakturyRozpisyPK;
    }

    public void setPrihlFakturyRozpisyPK(PrihlFakturyRozpisyPK prihlFakturyRozpisyPK) {
        this.prihlFakturyRozpisyPK = prihlFakturyRozpisyPK;
    }

    public BigDecimal getCastkaPrihl() {
        return castkaPrihl;
    }

    public void setCastkaPrihl(BigDecimal castkaPrihl) {
        this.castkaPrihl = castkaPrihl;
    }

    public Date getKdyVlozeno() {
        return kdyVlozeno;
    }

    public void setKdyVlozeno(Date kdyVlozeno) {
        this.kdyVlozeno = kdyVlozeno;
    }

    public Date getKdyZmeneno() {
        return kdyZmeneno;
    }

    public void setKdyZmeneno(Date kdyZmeneno) {
        this.kdyZmeneno = kdyZmeneno;
    }

    public String getKdoVlozil() {
        return kdoVlozil;
    }

    public void setKdoVlozil(String kdoVlozil) {
        this.kdoVlozil = kdoVlozil;
    }

    public String getKdoZmenil() {
        return kdoZmenil;
    }

    public void setKdoZmenil(String kdoZmenil) {
        this.kdoZmenil = kdoZmenil;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public PrihlaskyRozpisy getPrihlaskyRozpisy() {
        return prihlaskyRozpisy;
    }

    public void setPrihlaskyRozpisy(PrihlaskyRozpisy prihlaskyRozpisy) {
        this.prihlaskyRozpisy = prihlaskyRozpisy;
    }

    public KnihaFaktur getKnihaFaktur() {
        return knihaFaktur;
    }

    public void setKnihaFaktur(KnihaFaktur knihaFaktur) {
        this.knihaFaktur = knihaFaktur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prihlFakturyRozpisyPK != null ? prihlFakturyRozpisyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrihlFakturyRozpisy)) {
            return false;
        }
        PrihlFakturyRozpisy other = (PrihlFakturyRozpisy) object;
        if ((this.prihlFakturyRozpisyPK == null && other.prihlFakturyRozpisyPK != null) || (this.prihlFakturyRozpisyPK != null && !this.prihlFakturyRozpisyPK.equals(other.prihlFakturyRozpisyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrihlFakturyRozpisy[ prihlFakturyRozpisyPK=" + prihlFakturyRozpisyPK + " ]";
    }
    
}
