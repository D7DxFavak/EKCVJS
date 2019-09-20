/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "druhy_upominek", catalog = "kopernik1", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DruhyUpominek.findAll", query = "SELECT d FROM DruhyUpominek d"),
    @NamedQuery(name = "DruhyUpominek.findByDruhUpomId", query = "SELECT d FROM DruhyUpominek d WHERE d.druhUpomId = :druhUpomId"),
    @NamedQuery(name = "DruhyUpominek.findByNazev", query = "SELECT d FROM DruhyUpominek d WHERE d.nazev = :nazev"),
    @NamedQuery(name = "DruhyUpominek.findByGenerovatPo", query = "SELECT d FROM DruhyUpominek d WHERE d.generovatPo = :generovatPo"),
    @NamedQuery(name = "DruhyUpominek.findByDobaSplatnosti", query = "SELECT d FROM DruhyUpominek d WHERE d.dobaSplatnosti = :dobaSplatnosti"),
    @NamedQuery(name = "DruhyUpominek.findByPoradiUpominky", query = "SELECT d FROM DruhyUpominek d WHERE d.poradiUpominky = :poradiUpominky"),
    @NamedQuery(name = "DruhyUpominek.findByTextHlavicka1", query = "SELECT d FROM DruhyUpominek d WHERE d.textHlavicka1 = :textHlavicka1"),
    @NamedQuery(name = "DruhyUpominek.findByTextHlavicka2", query = "SELECT d FROM DruhyUpominek d WHERE d.textHlavicka2 = :textHlavicka2"),
    @NamedQuery(name = "DruhyUpominek.findByVyrizuje", query = "SELECT d FROM DruhyUpominek d WHERE d.vyrizuje = :vyrizuje"),
    @NamedQuery(name = "DruhyUpominek.findByTextVyrizuje", query = "SELECT d FROM DruhyUpominek d WHERE d.textVyrizuje = :textVyrizuje"),
    @NamedQuery(name = "DruhyUpominek.findByMisto", query = "SELECT d FROM DruhyUpominek d WHERE d.misto = :misto"),
    @NamedQuery(name = "DruhyUpominek.findByVec", query = "SELECT d FROM DruhyUpominek d WHERE d.vec = :vec"),
    @NamedQuery(name = "DruhyUpominek.findByTextPozadavek", query = "SELECT d FROM DruhyUpominek d WHERE d.textPozadavek = :textPozadavek"),
    @NamedQuery(name = "DruhyUpominek.findByTextPozdrav", query = "SELECT d FROM DruhyUpominek d WHERE d.textPozdrav = :textPozdrav"),
    @NamedQuery(name = "DruhyUpominek.findByTextLevyH", query = "SELECT d FROM DruhyUpominek d WHERE d.textLevyH = :textLevyH"),
    @NamedQuery(name = "DruhyUpominek.findByTextLevyD", query = "SELECT d FROM DruhyUpominek d WHERE d.textLevyD = :textLevyD"),
    @NamedQuery(name = "DruhyUpominek.findByTextPravyH", query = "SELECT d FROM DruhyUpominek d WHERE d.textPravyH = :textPravyH"),
    @NamedQuery(name = "DruhyUpominek.findByTextPravyD", query = "SELECT d FROM DruhyUpominek d WHERE d.textPravyD = :textPravyD"),
    @NamedQuery(name = "DruhyUpominek.findByPoznamky", query = "SELECT d FROM DruhyUpominek d WHERE d.poznamky = :poznamky")})
public class DruhyUpominek implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "druh_upom_id")
    private Integer druhUpomId;
    @Size(max = 50)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "generovat_po")
    private Integer generovatPo;
    @Column(name = "doba_splatnosti")
    private Integer dobaSplatnosti;
    @Column(name = "poradi_upominky")
    private Integer poradiUpominky;
    @Size(max = 200)
    @Column(name = "text_hlavicka_1")
    private String textHlavicka1;
    @Size(max = 200)
    @Column(name = "text_hlavicka_2")
    private String textHlavicka2;
    @Size(max = 50)
    @Column(name = "vyrizuje")
    private String vyrizuje;
    @Size(max = 80)
    @Column(name = "text_vyrizuje")
    private String textVyrizuje;
    @Size(max = 50)
    @Column(name = "misto")
    private String misto;
    @Size(max = 150)
    @Column(name = "vec")
    private String vec;
    @Size(max = 1000)
    @Column(name = "text_pozadavek")
    private String textPozadavek;
    @Size(max = 100)
    @Column(name = "text_pozdrav")
    private String textPozdrav;
    @Size(max = 50)
    @Column(name = "text_levy_h")
    private String textLevyH;
    @Size(max = 50)
    @Column(name = "text_levy_d")
    private String textLevyD;
    @Size(max = 50)
    @Column(name = "text_pravy_h")
    private String textPravyH;
    @Size(max = 50)
    @Column(name = "text_pravy_d")
    private String textPravyD;
    @Size(max = 2147483647)
    @Column(name = "poznamky")
    private String poznamky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druhyUpominek")
    private Collection<KnihaUpominek> knihaUpominekCollection;

    public DruhyUpominek() {
    }

    public DruhyUpominek(Integer druhUpomId) {
        this.druhUpomId = druhUpomId;
    }

    public Integer getDruhUpomId() {
        return druhUpomId;
    }

    public void setDruhUpomId(Integer druhUpomId) {
        this.druhUpomId = druhUpomId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Integer getGenerovatPo() {
        return generovatPo;
    }

    public void setGenerovatPo(Integer generovatPo) {
        this.generovatPo = generovatPo;
    }

    public Integer getDobaSplatnosti() {
        return dobaSplatnosti;
    }

    public void setDobaSplatnosti(Integer dobaSplatnosti) {
        this.dobaSplatnosti = dobaSplatnosti;
    }

    public Integer getPoradiUpominky() {
        return poradiUpominky;
    }

    public void setPoradiUpominky(Integer poradiUpominky) {
        this.poradiUpominky = poradiUpominky;
    }

    public String getTextHlavicka1() {
        return textHlavicka1;
    }

    public void setTextHlavicka1(String textHlavicka1) {
        this.textHlavicka1 = textHlavicka1;
    }

    public String getTextHlavicka2() {
        return textHlavicka2;
    }

    public void setTextHlavicka2(String textHlavicka2) {
        this.textHlavicka2 = textHlavicka2;
    }

    public String getVyrizuje() {
        return vyrizuje;
    }

    public void setVyrizuje(String vyrizuje) {
        this.vyrizuje = vyrizuje;
    }

    public String getTextVyrizuje() {
        return textVyrizuje;
    }

    public void setTextVyrizuje(String textVyrizuje) {
        this.textVyrizuje = textVyrizuje;
    }

    public String getMisto() {
        return misto;
    }

    public void setMisto(String misto) {
        this.misto = misto;
    }

    public String getVec() {
        return vec;
    }

    public void setVec(String vec) {
        this.vec = vec;
    }

    public String getTextPozadavek() {
        return textPozadavek;
    }

    public void setTextPozadavek(String textPozadavek) {
        this.textPozadavek = textPozadavek;
    }

    public String getTextPozdrav() {
        return textPozdrav;
    }

    public void setTextPozdrav(String textPozdrav) {
        this.textPozdrav = textPozdrav;
    }

    public String getTextLevyH() {
        return textLevyH;
    }

    public void setTextLevyH(String textLevyH) {
        this.textLevyH = textLevyH;
    }

    public String getTextLevyD() {
        return textLevyD;
    }

    public void setTextLevyD(String textLevyD) {
        this.textLevyD = textLevyD;
    }

    public String getTextPravyH() {
        return textPravyH;
    }

    public void setTextPravyH(String textPravyH) {
        this.textPravyH = textPravyH;
    }

    public String getTextPravyD() {
        return textPravyD;
    }

    public void setTextPravyD(String textPravyD) {
        this.textPravyD = textPravyD;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    @XmlTransient
    public Collection<KnihaUpominek> getKnihaUpominekCollection() {
        return knihaUpominekCollection;
    }

    public void setKnihaUpominekCollection(Collection<KnihaUpominek> knihaUpominekCollection) {
        this.knihaUpominekCollection = knihaUpominekCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (druhUpomId != null ? druhUpomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DruhyUpominek)) {
            return false;
        }
        DruhyUpominek other = (DruhyUpominek) object;
        if ((this.druhUpomId == null && other.druhUpomId != null) || (this.druhUpomId != null && !this.druhUpomId.equals(other.druhUpomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DruhyUpominek[ druhUpomId=" + druhUpomId + " ]";
    }
    
}
