/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "obory_metodicky_sbor", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OboryMetodickySbor.findAll", query = "SELECT o FROM OboryMetodickySbor o"),
    @NamedQuery(name = "OboryMetodickySbor.findByOborId", query = "SELECT o FROM OboryMetodickySbor o WHERE o.oboryMetodickySborPK.oborId = :oborId"),
    @NamedQuery(name = "OboryMetodickySbor.findByObormetodik", query = "SELECT o FROM OboryMetodickySbor o WHERE o.oboryMetodickySborPK.obormetodik = :obormetodik"),
    @NamedQuery(name = "OboryMetodickySbor.findByKdyVlozeno", query = "SELECT o FROM OboryMetodickySbor o WHERE o.kdyVlozeno = :kdyVlozeno"),
    @NamedQuery(name = "OboryMetodickySbor.findByKdyZmeneno", query = "SELECT o FROM OboryMetodickySbor o WHERE o.kdyZmeneno = :kdyZmeneno"),
    @NamedQuery(name = "OboryMetodickySbor.findByKdoVlozil", query = "SELECT o FROM OboryMetodickySbor o WHERE o.kdoVlozil = :kdoVlozil"),
    @NamedQuery(name = "OboryMetodickySbor.findByKdoZmenil", query = "SELECT o FROM OboryMetodickySbor o WHERE o.kdoZmenil = :kdoZmenil"),
    @NamedQuery(name = "OboryMetodickySbor.findByPoznamky", query = "SELECT o FROM OboryMetodickySbor o WHERE o.poznamky = :poznamky")})
public class OboryMetodickySbor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OboryMetodickySborPK oboryMetodickySborPK;
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
    @JoinColumn(name = "obormetodik", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;
    @JoinColumn(name = "obor_id", referencedColumnName = "obor_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Obory obory;

    public OboryMetodickySbor() {
    }

    public OboryMetodickySbor(OboryMetodickySborPK oboryMetodickySborPK) {
        this.oboryMetodickySborPK = oboryMetodickySborPK;
    }

    public OboryMetodickySbor(int oborId, int obormetodik) {
        this.oboryMetodickySborPK = new OboryMetodickySborPK(oborId, obormetodik);
    }

    public OboryMetodickySborPK getOboryMetodickySborPK() {
        return oboryMetodickySborPK;
    }

    public void setOboryMetodickySborPK(OboryMetodickySborPK oboryMetodickySborPK) {
        this.oboryMetodickySborPK = oboryMetodickySborPK;
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

    public Osoby getOsoby() {
        return osoby;
    }

    public void setOsoby(Osoby osoby) {
        this.osoby = osoby;
    }

    public Obory getObory() {
        return obory;
    }

    public void setObory(Obory obory) {
        this.obory = obory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oboryMetodickySborPK != null ? oboryMetodickySborPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OboryMetodickySbor)) {
            return false;
        }
        OboryMetodickySbor other = (OboryMetodickySbor) object;
        if ((this.oboryMetodickySborPK == null && other.oboryMetodickySborPK != null) || (this.oboryMetodickySborPK != null && !this.oboryMetodickySborPK.equals(other.oboryMetodickySborPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OboryMetodickySbor[ oboryMetodickySborPK=" + oboryMetodickySborPK + " ]";
    }
    
}
