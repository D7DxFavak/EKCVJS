/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "faktury_uhrady", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FakturyUhrady.findAll", query = "SELECT f FROM FakturyUhrady f"),
    @NamedQuery(name = "FakturyUhrady.findByPoradi", query = "SELECT f FROM FakturyUhrady f WHERE f.poradi = :poradi"),
    @NamedQuery(name = "FakturyUhrady.findByUhrada", query = "SELECT f FROM FakturyUhrady f WHERE f.uhrada = :uhrada"),
    @NamedQuery(name = "FakturyUhrady.findByDatumUhrazeno", query = "SELECT f FROM FakturyUhrady f WHERE f.datumUhrazeno = :datumUhrazeno"),
    @NamedQuery(name = "FakturyUhrady.findByKdyVlozeno", query = "SELECT f FROM FakturyUhrady f WHERE f.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "FakturyUhrady.findByKdyZmeneno", query = "SELECT f FROM FakturyUhrady f WHERE f.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "FakturyUhrady.findByKdoVlozil", query = "SELECT f FROM FakturyUhrady f WHERE f.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "FakturyUhrady.findByKdoZmenil", query = "SELECT f FROM FakturyUhrady f WHERE f.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "FakturyUhrady.findByPoznamky", query = "SELECT f FROM FakturyUhrady f WHERE f.poznamky = :poznamky")})
public class FakturyUhrady implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "poradi")
    private Integer poradi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "uhrada")
    private BigDecimal uhrada;
    @Column(name = "datum_uhrazeno")
    @Temporal(TemporalType.DATE)
    private Date datumUhrazeno;
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
    @JoinColumn(name = "cislo_faktury", referencedColumnName = "cislo_faktury")
    @ManyToOne
    private KnihaFaktur cisloFaktury;
    @JoinColumn(name = "forma_uhrady", referencedColumnName = "forma_uhrady_id")
    @ManyToOne
    private FormyUhrad formaUhrady;

    public FakturyUhrady() {
    }

    public FakturyUhrady(Integer poradi) {
        this.poradi = poradi;
    }

    public Integer getPoradi() {
        return poradi;
    }

    public void setPoradi(Integer poradi) {
        this.poradi = poradi;
    }

    public BigDecimal getUhrada() {
        return uhrada;
    }

    public void setUhrada(BigDecimal uhrada) {
        this.uhrada = uhrada;
    }

    public Date getDatumUhrazeno() {
        return datumUhrazeno;
    }

    public void setDatumUhrazeno(Date datumUhrazeno) {
        this.datumUhrazeno = datumUhrazeno;
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

    public KnihaFaktur getCisloFaktury() {
        return cisloFaktury;
    }

    public void setCisloFaktury(KnihaFaktur cisloFaktury) {
        this.cisloFaktury = cisloFaktury;
    }

    public FormyUhrad getFormaUhrady() {
        return formaUhrady;
    }

    public void setFormaUhrady(FormyUhrad formaUhrady) {
        this.formaUhrady = formaUhrady;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poradi != null ? poradi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FakturyUhrady)) {
            return false;
        }
        FakturyUhrady other = (FakturyUhrady) object;
        if ((this.poradi == null && other.poradi != null) || (this.poradi != null && !this.poradi.equals(other.poradi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FakturyUhrady[ poradi=" + poradi + " ]";
    }
    
}
