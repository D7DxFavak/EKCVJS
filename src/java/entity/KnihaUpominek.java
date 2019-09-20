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
@Table(name = "kniha_upominek", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnihaUpominek.findAll", query = "SELECT k FROM KnihaUpominek k"),
    @NamedQuery(name = "KnihaUpominek.findByCisloFaktury", query = "SELECT k FROM KnihaUpominek k WHERE k.knihaUpominekPK.cisloFaktury = :cisloFaktury"),
    @NamedQuery(name = "KnihaUpominek.findByDruhUpominky", query = "SELECT k FROM KnihaUpominek k WHERE k.knihaUpominekPK.druhUpominky = :druhUpominky"),
    @NamedQuery(name = "KnihaUpominek.findByDatumVystaveni", query = "SELECT k FROM KnihaUpominek k WHERE k.datumVystaveni = :datumVystaveni"),
    @NamedQuery(name = "KnihaUpominek.findByDatumSplatnosti", query = "SELECT k FROM KnihaUpominek k WHERE k.datumSplatnosti = :datumSplatnosti"),
    @NamedQuery(name = "KnihaUpominek.findBySumaUhrad", query = "SELECT k FROM KnihaUpominek k WHERE k.sumaUhrad = :sumaUhrad"),
    @NamedQuery(name = "KnihaUpominek.findByKdyZaslano", query = "SELECT k FROM KnihaUpominek k WHERE k.kdyZaslano = :kdyZaslano"),
    @NamedQuery(name = "KnihaUpominek.findByKdyVlozeno", query = "SELECT k FROM KnihaUpominek k WHERE k.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "KnihaUpominek.findByKdyZmeneno", query = "SELECT k FROM KnihaUpominek k WHERE k.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "KnihaUpominek.findByKdoVlozil", query = "SELECT k FROM KnihaUpominek k WHERE k.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "KnihaUpominek.findByKdoZmenil", query = "SELECT k FROM KnihaUpominek k WHERE k.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "KnihaUpominek.findByPoznamky", query = "SELECT k FROM KnihaUpominek k WHERE k.poznamky = :poznamky")})
public class KnihaUpominek implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KnihaUpominekPK knihaUpominekPK;
    @Column(name = "datum_vystaveni")
    @Temporal(TemporalType.DATE)
    private Date datumVystaveni;
    @Column(name = "datum_splatnosti")
    @Temporal(TemporalType.DATE)
    private Date datumSplatnosti;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "suma_uhrad")
    private BigDecimal sumaUhrad;
    @Column(name = "kdy_zaslano")
    @Temporal(TemporalType.DATE)
    private Date kdyZaslano;
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
    @JoinColumn(name = "cislo_faktury", referencedColumnName = "cislo_faktury", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KnihaFaktur knihaFaktur;
    @JoinColumn(name = "druh_upominky", referencedColumnName = "druh_upom_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DruhyUpominek druhyUpominek;

    public KnihaUpominek() {
    }

    public KnihaUpominek(KnihaUpominekPK knihaUpominekPK) {
        this.knihaUpominekPK = knihaUpominekPK;
    }

    public KnihaUpominek(int cisloFaktury, int druhUpominky) {
        this.knihaUpominekPK = new KnihaUpominekPK(cisloFaktury, druhUpominky);
    }

    public KnihaUpominekPK getKnihaUpominekPK() {
        return knihaUpominekPK;
    }

    public void setKnihaUpominekPK(KnihaUpominekPK knihaUpominekPK) {
        this.knihaUpominekPK = knihaUpominekPK;
    }

    public Date getDatumVystaveni() {
        return datumVystaveni;
    }

    public void setDatumVystaveni(Date datumVystaveni) {
        this.datumVystaveni = datumVystaveni;
    }

    public Date getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(Date datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    public BigDecimal getSumaUhrad() {
        return sumaUhrad;
    }

    public void setSumaUhrad(BigDecimal sumaUhrad) {
        this.sumaUhrad = sumaUhrad;
    }

    public Date getKdyZaslano() {
        return kdyZaslano;
    }

    public void setKdyZaslano(Date kdyZaslano) {
        this.kdyZaslano = kdyZaslano;
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

    public KnihaFaktur getKnihaFaktur() {
        return knihaFaktur;
    }

    public void setKnihaFaktur(KnihaFaktur knihaFaktur) {
        this.knihaFaktur = knihaFaktur;
    }

    public DruhyUpominek getDruhyUpominek() {
        return druhyUpominek;
    }

    public void setDruhyUpominek(DruhyUpominek druhyUpominek) {
        this.druhyUpominek = druhyUpominek;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (knihaUpominekPK != null ? knihaUpominekPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnihaUpominek)) {
            return false;
        }
        KnihaUpominek other = (KnihaUpominek) object;
        if ((this.knihaUpominekPK == null && other.knihaUpominekPK != null) || (this.knihaUpominekPK != null && !this.knihaUpominekPK.equals(other.knihaUpominekPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KnihaUpominek[ knihaUpominekPK=" + knihaUpominekPK + " ]";
    }
    
}
