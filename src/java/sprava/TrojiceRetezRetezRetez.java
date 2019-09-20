package sprava;

public class TrojiceRetezRetezRetez {
    
     private String odkaz;
     private String nazev;
     private String popis;
    
    public TrojiceRetezRetezRetez() {
     this.odkaz = "";
     this.nazev = "";
     this.popis = "";
    }

    public TrojiceRetezRetezRetez(String odkaz, String nazev, String popis) {
    this.odkaz = odkaz;
     this.nazev = nazev;
     this.popis = popis;
    }

    /**
     * @return the odkaz
     */
    public String getOdkaz() {
        return odkaz;
    }

    /**
     * @param odkaz the odkaz to set
     */
    public void setOdkaz(String odkaz) {
        this.odkaz = odkaz;
    }

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @param nazev the nazev to set
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * @return the popis
     */
    public String getPopis() {
        return popis;
    }

    /**
     * @param popis the popis to set
     */
    public void setPopis(String popis) {
        this.popis = popis;
    }
    
   
    

} // konec Dvojice
