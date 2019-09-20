/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "organizace_dalsi_kontakty", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizaceDalsiKontakty.findAll", query = "SELECT o FROM OrganizaceDalsiKontakty o"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByPoradi", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.poradi = :poradi"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByAdresa", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.adresa = :adresa"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByMesto", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.mesto = :mesto"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByPsc", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.psc = :psc"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByTelefon", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.telefon = :telefon"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByFax", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.fax = :fax"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByEMail", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.eMail = :eMail"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByUrl", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.url = :url"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByBankovniSpojeni", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.bankovniSpojeni = :bankovniSpojeni"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByCisloUctu", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.cisloUctu = :cisloUctu"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByKdyVlozeno", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByKdyZmeneno", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByKdoVlozil", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByKdoZmenil", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "OrganizaceDalsiKontakty.findByPoznamky", query = "SELECT o FROM OrganizaceDalsiKontakty o WHERE o.poznamky = :poznamky")})
public class OrganizaceDalsiKontakty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "poradi")
    private Integer poradi;
    @Size(max = 50)
    @Column(name = "adresa")
    private String adresa;
    @Size(max = 50)
    @Column(name = "mesto")
    private String mesto;
    @Size(max = 7)
    @Column(name = "psc")
    private String psc;
    @Size(max = 100)
    @Column(name = "telefon")
    private String telefon;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 400)
    @Column(name = "e_mail")
    private String eMail;
    @Size(max = 200)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "bankovni_spojeni")
    private String bankovniSpojeni;
    @Size(max = 100)
    @Column(name = "cislo_uctu")
    private String cisloUctu;
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
    @JoinColumn(name = "region_okres", referencedColumnName = "ro_id")
    @ManyToOne
    private RegionyOkresy regionOkres;
    @JoinColumn(name = "organizace_id", referencedColumnName = "organizace_id")
    @ManyToOne
    private Organizace organizaceId;

    public OrganizaceDalsiKontakty() {
    }

    public OrganizaceDalsiKontakty(Integer poradi) {
        this.poradi = poradi;
    }

    public Integer getPoradi() {
        return poradi;
    }

    public void setPoradi(Integer poradi) {
        this.poradi = poradi;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBankovniSpojeni() {
        return bankovniSpojeni;
    }

    public void setBankovniSpojeni(String bankovniSpojeni) {
        this.bankovniSpojeni = bankovniSpojeni;
    }

    public String getCisloUctu() {
        return cisloUctu;
    }

    public void setCisloUctu(String cisloUctu) {
        this.cisloUctu = cisloUctu;
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

    public RegionyOkresy getRegionOkres() {
        return regionOkres;
    }

    public void setRegionOkres(RegionyOkresy regionOkres) {
        this.regionOkres = regionOkres;
    }

    public Organizace getOrganizaceId() {
        return organizaceId;
    }

    public void setOrganizaceId(Organizace organizaceId) {
        this.organizaceId = organizaceId;
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
        if (!(object instanceof OrganizaceDalsiKontakty)) {
            return false;
        }
        OrganizaceDalsiKontakty other = (OrganizaceDalsiKontakty) object;
        if ((this.poradi == null && other.poradi != null) || (this.poradi != null && !this.poradi.equals(other.poradi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrganizaceDalsiKontakty[ poradi=" + poradi + " ]";
    }
    
}
