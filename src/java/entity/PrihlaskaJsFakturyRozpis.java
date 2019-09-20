/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 7Data Gotzy
 */
@Entity
@Table(name = "prihlaska_js_faktury_rozpis", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findAll", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p"),
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findByPolozkaPrihl", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p WHERE p.polozkaPrihl = :polozkaPrihl"),
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findByCisloFaktury", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p WHERE p.cisloFaktury = :cisloFaktury"),
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findByFakturaDruh", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p WHERE p.fakturaDruh = :fakturaDruh"),
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findByCastkaPrihl", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p WHERE p.castkaPrihl = :castkaPrihl"),
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findByStornovano", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p WHERE p.stornovano = :stornovano"),
    @NamedQuery(name = "PrihlaskaJsFakturyRozpis.findByZakazModifikaceprihlasky", query = "SELECT p FROM PrihlaskaJsFakturyRozpis p WHERE p.zakazModifikaceprihlasky = :zakazModifikaceprihlasky")})
public class PrihlaskaJsFakturyRozpis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrihlJsFakturyRozpisyPK prihlJsFakturyRozpisyPK;
    @Column(name = "polozka_prihl")
    private Integer polozkaPrihl;
    @Column(name = "cislo_faktury")
    private Integer cisloFaktury;
    @Column(name = "faktura_druh")
    private Integer fakturaDruh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "castka_prihl")
    private BigDecimal castkaPrihl;
    @Column(name = "stornovano")
    private Boolean stornovano;
    @Column(name = "zakaz_modifikaceprihlasky")
    private Boolean zakazModifikaceprihlasky;

    public PrihlaskaJsFakturyRozpis() {
    }

    public Integer getPolozkaPrihl() {
        return polozkaPrihl;
    }

    public void setPolozkaPrihl(Integer polozkaPrihl) {
        this.polozkaPrihl = polozkaPrihl;
    }

    public Integer getCisloFaktury() {
        return cisloFaktury;
    }

    public void setCisloFaktury(Integer cisloFaktury) {
        this.cisloFaktury = cisloFaktury;
    }

    public Integer getFakturaDruh() {
        return fakturaDruh;
    }

    public void setFakturaDruh(Integer fakturaDruh) {
        this.fakturaDruh = fakturaDruh;
    }

    public BigDecimal getCastkaPrihl() {
        return castkaPrihl;
    }

    public void setCastkaPrihl(BigDecimal castkaPrihl) {
        this.castkaPrihl = castkaPrihl;
    }

    public Boolean getStornovano() {
        return stornovano;
    }

    public void setStornovano(Boolean stornovano) {
        this.stornovano = stornovano;
    }

    public Boolean getZakazModifikaceprihlasky() {
        return zakazModifikaceprihlasky;
    }

    public void setZakazModifikaceprihlasky(Boolean zakazModifikaceprihlasky) {
        this.zakazModifikaceprihlasky = zakazModifikaceprihlasky;
    }
    
}
