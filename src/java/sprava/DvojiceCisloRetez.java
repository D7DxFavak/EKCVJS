package sprava;

public class DvojiceCisloRetez {
    
     private String retez;
     private int cislo;
    
    public DvojiceCisloRetez() {
     this.cislo = 0;
     this.retez = "";
    }

    public DvojiceCisloRetez(int cislo, String retez) {
     this.cislo = cislo;
     this.retez = retez;
    }
    
    public String toString() {
     return getRetez();
    }
    
    public int cislo() {
     return getCislo();
    }

    /**
     * @return the retez
     */
    public String getRetez() {
        return retez;
    }

    /**
     * @return the cislo
     */
    public int getCislo() {
        return cislo;
    }

} // konec Dvojice
