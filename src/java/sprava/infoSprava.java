/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sprava;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 7Data Gotzy
 */
public class infoSprava {

    private String jmeno;
    private String adresa;
    private String mesto;
    private String psc;
    private String telefon;
    private String email;
    private boolean novyKlient = false;
    private boolean ziskatSmlouva = false;
    private boolean ziskatDoklad = false;
    private boolean ziskatSmlouvaPujcka = false;
    private String cisloSmlouva;
    private String cisloDoklad;
    private String cisloSmlouvaPujcka;
    private int idKlienta = -1;
    private int idDokladu = -1;
    private int idKlientInfo = -1;
    private ArrayList<DvojiceCisloRetez> arAP;
    private ArrayList<TridaRozhrani> arRoz;
    private TridaRozhrani tRoz;
    private DvojiceCisloRetez dcr;
    private boolean nactenaData = false;
    private boolean nactenaDataRoz = false;
    private int vybranyBod = 1;
    private String infoAP = "";

    public ArrayList<DvojiceCisloRetez> getAPlist() {
        
        arAP = new ArrayList<DvojiceCisloRetez>();
        try {
            ResultSet data = PripojeniDB.dotazS("SELECT id, nazev "
                    + "FROM pristup_bod ORDER BY nazev");
            while (data.next()) {
                dcr = new DvojiceCisloRetez(data.getInt(1), data.getString(2));
                arAP.add(dcr);

            }
            data.close();
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            
            nactenaData = true;
            return arAP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public ArrayList<TridaRozhrani> getRozlist() {
        arRoz = new ArrayList<TridaRozhrani>();
        try {
            ResultSet data = PripojeniDB.dotazS("SELECT rozhrani_nazev, "
                    + "pristup_bod_rozhrani_nazev, zabezpeceni_nazev, "
                    + "pristup_bod_rozhrani_zabezpeceni_klic "
                    + "FROM pristup_bod_rozhrani "
                    + "CROSS JOIN rozhrani "
                    + "CROSS JOIN zabezpeceni "
                    + "WHERE pristup_bod_rozhrani_druh = rozhrani_id "
                    + "AND pristup_bod_rozhrani_zabezpeceni = zabezpeceni_id "
                    + "AND pristup_bod_rozhrani_bod_id = " + vybranyBod + " "
                    + "ORDER BY pristup_bod_rozhrani_poradi_id");
            while (data.next()) {
                tRoz = new TridaRozhrani();
                tRoz.setRozhrani(data.getString(1));
                tRoz.setNazev(data.getString(2));
                tRoz.setDruhZabezp(data.getString(3));
                tRoz.setKlicZabezp((data.getString(4) == null) ? "" : data.getString(4)); 
                arRoz.add(tRoz);
            }
            data.close();
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            nactenaDataRoz = true;
            return arRoz;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<TridaRozhrani> getRozlist(int idBod) {
        arRoz = new ArrayList<TridaRozhrani>();
        try {
            ResultSet data = PripojeniDB.dotazS("SELECT rozhrani_nazev, "
                    + "pristup_bod_rozhrani_nazev, zabezpeceni_nazev, "
                    + "pristup_bod_rozhrani_zabezpeceni_klic "
                    + "FROM pristup_bod_rozhrani "
                    + "CROSS JOIN rozhrani "
                    + "CROSS JOIN zabezpeceni "
                    + "WHERE pristup_bod_rozhrani_druh = rozhrani_id "
                    + "AND pristup_bod_rozhrani_zabezpeceni = zabezpeceni_id "
                    + "AND pristup_bod_rozhrani_bod_id = " + idBod + " "
                    + "ORDER BY pristup_bod_rozhrani_poradi_id");
            while (data.next()) {
                tRoz = new TridaRozhrani();
                tRoz.setRozhrani(data.getString(1));
                tRoz.setNazev(data.getString(2));
                tRoz.setDruhZabezp(data.getString(3));
                tRoz.setKlicZabezp((data.getString(4) == null) ? "" : data.getString(4)); 
                arRoz.add(tRoz);
            }
            data.close();
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            nactenaDataRoz = true;
            return arRoz;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<TridaRozhrani> getRozlist(String idBod) {
        if (idBod != null) {
            arRoz = new ArrayList<TridaRozhrani>();
            try {
                ResultSet data = PripojeniDB.dotazS("SELECT rozhrani_nazev, "
                        + "pristup_bod_rozhrani_nazev, zabezpeceni_nazev, "
                        + "pristup_bod_rozhrani_zabezpeceni_klic "
                        + "FROM pristup_bod_rozhrani "
                        + "CROSS JOIN rozhrani "
                        + "CROSS JOIN zabezpeceni "
                        + "WHERE pristup_bod_rozhrani_druh = rozhrani_id "
                        + "AND pristup_bod_rozhrani_zabezpeceni = zabezpeceni_id "
                        + "AND pristup_bod_rozhrani_bod_id = " + idBod + " "
                        + "ORDER BY pristup_bod_rozhrani_poradi_id");
                while (data.next()) {
                    tRoz = new TridaRozhrani();
                    tRoz.setRozhrani(data.getString(1));
                    tRoz.setNazev(data.getString(2));
                    tRoz.setDruhZabezp(data.getString(3));
                    tRoz.setKlicZabezp((data.getString(4) == null) ? "" : data.getString(4));  
                    arRoz.add(tRoz);
                }
                data.close();
                PripojeniDB.rs.close();
                PripojeniDB.pstmt.close();
                PripojeniDB.con.close();
                nactenaDataRoz = true;


                return arRoz;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

    }

    public int getAPsize() {
        if (nactenaData == false) {
            getAPlist();
        }
        return arAP.size();
    }

    public int getRozSize() {
        if (nactenaDataRoz == false) {
            getAPlist();
        }
        return arRoz.size();
    }

    public String getAPjednotlive(int index) {
        if (nactenaData == false) {
            getAPlist();
        }
        return arAP.get(index).toString();
    }

    public int getAPjednotliveInt(int index) {
        if (nactenaData == false) {
            getAPlist();
        }
        return arAP.get(index).cislo();
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        if (isNovyKlient() == true) {
            try {
                DvojiceCisloCislo cc = SQLFunkceObecne2.insert2CC(
                        "SELECT * FROM spolecne.subjekty_trhu_insert ("
                        + TextFunkce1.osetriZapisTextDB1(new String(jmeno.getBytes("ISO-8859-1"), "UTF-8")) + ", "
                        + null + ", "
                        + TextFunkce1.osetriZapisIntKeyDB1(6) + ", "
                        + null + ", "
                        + null + ", "
                        + false + ", "
                        + TextFunkce1.osetriZapisTextDB1(new String(adresa.getBytes("ISO-8859-1"), "UTF-8")) + ", "
                        + TextFunkce1.osetriZapisTextDB1(new String(mesto.getBytes("ISO-8859-1"), "UTF-8")) + ", "
                        + TextFunkce1.osetriZapisTextDB1(psc) + ", "
                        + TextFunkce1.osetriZapisIntKeyDB1(10) + ", "
                        + ((telefon == null) ? "NULL, " : TextFunkce1.osetriZapisTextDB1(telefon) + ", ")
                        + null + ", "
                        + ((email == null) ? "NULL, " : TextFunkce1.osetriZapisTextDB1(email) + ", ")
                        + null + ", "
                        + null + ", "
                        + TextFunkce1.osetriZapisTextDB1("Vloženo z WEBU")
                        + ")");
                idKlienta = cc.c1;
                PripojeniDB.rs.close();
                PripojeniDB.pstmt.close();
                PripojeniDB.con.close();


                int a = PripojeniDB.dotazIUD("INSERT INTO klienti.klienti_info("
                        + "klienti_info_id, klienti_info_subjekty_trhu_id, klienti_info_shaping_id, "
                        + "klienti_info_interval_placeni, klienti_info_datum_platnost_od, "
                        + "klienti_info_datum_upozorneni, klienti_info_text_upozorneni, "
                        + "klienti_info_poznamky)"
                        + " VALUES ("
                        + "(SELECT COALESCE(MAX(klienti_info_id)+1,1) FROM klienti.klienti_info), "
                        + idKlienta + ", "
                        + "-1, 10, null, null, null, null)");


                ResultSet smlouva = PripojeniDB.dotazS("SELECT COALESCE(MAX(klienti_info_id),1) FROM klienti.klienti_info");
                while (smlouva.next()) {
                    idKlientInfo = smlouva.getInt(1);
                }
                smlouva.close();
                PripojeniDB.rs.close();
                PripojeniDB.pstmt.close();
                PripojeniDB.con.close();
                return new String(jmeno.getBytes("ISO-8859-1"), "UTF-8");
            } catch (Exception e) {
                return ("Chyba nelze ulozit zakaznika : " + e.toString());
            }

            //return jmeno;
        } else {
            try {
                return new String(jmeno.getBytes("ISO-8859-1"), "UTF-8");
            } catch (Exception e) {
                return ("Chyba formatovani : " + e.toString());
            }
        }
    }

    /**
     * @param jmeno the jmeno to set
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * @return the adresa
     */
    public String getAdresa() {
        try {
            return new String(adresa.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return ("error" + adresa);
        }
        ///return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * @return the mesto
     */
    public String getMesto() {
        try {
            return new String(mesto.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return ("error" + mesto);
        }
    }

    /**
     * @param mesto the mesto to set
     */
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    /**
     * @return the psc
     */
    public String getPsc() {
        try {
            return new String(psc.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return ("error" + psc);
        }
    }

    /**
     * @param psc the psc to set
     */
    public void setPsc(String psc) {
        this.psc = psc;
    }

    /**
     * @return the ziskatSmlouva
     */
    public boolean isZiskatSmlouva() {
        return ziskatSmlouva;
    }

    /**
     * @param ziskatSmlouva the ziskatSmlouva to set
     */
    public void setZiskatSmlouva(boolean ziskatSmlouva) {
        this.ziskatSmlouva = ziskatSmlouva;
    }

    /**
     * @return the ziskatDoklad
     */
    public boolean isZiskatDoklad() {
        return ziskatDoklad;
    }

    /**
     * @param ziskatDoklad the ziskatDoklad to set
     */
    public void setZiskatDoklad(boolean ziskatDoklad) {
        this.ziskatDoklad = ziskatDoklad;
    }

    /**
     * @return the ziskatSmlouvaPujcka
     */
    public boolean isZiskatSmlouvaPujcka() {
        return ziskatSmlouvaPujcka;
    }

    /**
     * @param ziskatSmlouvaPujcka the ziskatSmlouvaPujcka to set
     */
    public void setZiskatSmlouvaPujcka(boolean ziskatSmlouvaPujcka) {
        this.ziskatSmlouvaPujcka = ziskatSmlouvaPujcka;
    }

    /**
     * @return the cisloSmlouva
     */
    public String getCisloSmlouva() {
        try {
            DvojiceCisloCislo cc = SQLFunkceObecne2.insert2CC(
                    "SELECT * FROM spolecne.doklady_evidence_insert_smlouvy ("
                    + TextFunkce1.osetriZapisTextDB1(new String(jmeno.getBytes("ISO-8859-1"), "UTF-8")
                    + ", " + new String(adresa.getBytes("ISO-8859-1"), "UTF-8")
                    + ", " + new String(mesto.getBytes("ISO-8859-1"), "UTF-8")) + ", "
                    + TextFunkce1.osetriZapisIntKeyDB1(2) + ", NULL, "
                    //+ TextFunkce1.osetriZapisTextDB1(jTextFieldZuctovaciObdobi.getText().trim()) + ", " // asi takle zatim
                    + TextFunkce1.osetriZapisIntKeyDB1(2) + ", current_date, NULL, NULL, NULL, "
                    + " NULL, NULL, FALSE, NULL, NULL )");
            idDokladu = cc.c1;
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if ((idDokladu > -1) && (idKlientInfo > -1)) {
                int u = PripojeniDB.dotazIUD("INSERT INTO klienti.vazba_klienti_doklady "
                        + "(vazba_klienti_doklady_doklady_id, "
                        + "vazba_klienti_doklady_klient_id, "
                        + "vazba_klienti_doklady_poznamky) "
                        + "VALUES("
                        + idDokladu + ", "
                        + idKlientInfo + ", "
                        + "'synchronizace WEB')");
                PripojeniDB.rs.close();
                PripojeniDB.pstmt.close();
                PripojeniDB.con.close();
            }
            idDokladu = -1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            ResultSet smlouva = PripojeniDB.dotazS("SELECT doklady_evidence_cislo FROM  spolecne.doklady_evidence "
                    + "WHERE doklady_evidence_druh_id = 2 "
                    + "ORDER BY doklady_evidence_cislo DESC LIMIT 1");
            while (smlouva.next()) {

                cisloSmlouva = smlouva.getString(1);
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            return (cisloSmlouva);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }

    }

    /**
     * @param cisloSmlouva the cisloSmlouva to set
     */
    public void setCisloSmlouva(String cisloSmlouva) {
        this.cisloSmlouva = cisloSmlouva;
    }

    /**
     * @return the cisloDoklad
     */
    public String getCisloDoklad() {
        try {
            DvojiceCisloCislo cc = SQLFunkceObecne2.insert2CC(
                    "SELECT * FROM spolecne.doklady_evidence_insert1 ("
                    + TextFunkce1.osetriZapisTextDB1(new String(jmeno.getBytes("ISO-8859-1"), "UTF-8")
                    + ", " + new String(adresa.getBytes("ISO-8859-1"), "UTF-8")
                    + ", " + new String(mesto.getBytes("ISO-8859-1"), "UTF-8")) + ", "
                    + TextFunkce1.osetriZapisIntKeyDB1(7) + ", NULL, "
                    //+ TextFunkce1.osetriZapisTextDB1(jTextFieldZuctovaciObdobi.getText().trim()) + ", " // asi takle zatim
                    + TextFunkce1.osetriZapisIntKeyDB1(2) + ", current_date, NULL, NULL, NULL, "
                    + " NULL, NULL, FALSE, NULL, NULL )");
            idDokladu = cc.c1;
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if ((idDokladu > -1) && (idKlientInfo > -1)) {
                int u = PripojeniDB.dotazIUD("INSERT INTO klienti.vazba_klienti_doklady "
                        + "(vazba_klienti_doklady_doklady_id, "
                        + "vazba_klienti_doklady_klient_id, "
                        + "vazba_klienti_doklady_poznamky) "
                        + "VALUES("
                        + idDokladu + ", "
                        + idKlientInfo + ", "
                        + "'synchronizace WEB')");
            }
            idDokladu = -1;
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }



        try {


            ResultSet smlouva = PripojeniDB.dotazS("SELECT doklady_evidence_cislo FROM  spolecne.doklady_evidence "
                    + "WHERE doklady_evidence_druh_id = 7 "
                    + "ORDER BY doklady_evidence_cislo DESC LIMIT 1");
            while (smlouva.next()) {

                cisloDoklad = smlouva.getString(1);
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            return (cisloDoklad);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    /**
     * @param cisloDoklad the cisloDoklad to set
     */
    public void setCisloDoklad(String cisloDoklad) {
        this.cisloDoklad = cisloDoklad;
    }

    /**
     * @return the cisloSmlouvaPujcka
     */
    public String getCisloSmlouvaPujcka() {
        try {
            DvojiceCisloCislo cc = SQLFunkceObecne2.insert2CC(
                    "SELECT * FROM spolecne.doklady_evidence_insert_smlouvy ("
                    + TextFunkce1.osetriZapisTextDB1(new String(jmeno.getBytes("ISO-8859-1"), "UTF-8")
                    + ", " + new String(adresa.getBytes("ISO-8859-1"), "UTF-8")
                    + ", " + new String(mesto.getBytes("ISO-8859-1"), "UTF-8")) + ", "
                    + TextFunkce1.osetriZapisIntKeyDB1(1000) + ", NULL, "
                    //+ TextFunkce1.osetriZapisTextDB1(jTextFieldZuctovaciObdobi.getText().trim()) + ", " // asi takle zatim
                    + TextFunkce1.osetriZapisIntKeyDB1(2) + ", current_date, NULL, NULL, NULL, "
                    + " NULL, NULL, FALSE, NULL, NULL )");
            idDokladu = cc.c1;
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if ((idDokladu > -1) && (idKlientInfo > -1)) {
                int u = PripojeniDB.dotazIUD("INSERT INTO klienti.vazba_klienti_doklady "
                        + "(vazba_klienti_doklady_doklady_id, "
                        + "vazba_klienti_doklady_klient_id, "
                        + "vazba_klienti_doklady_poznamky) "
                        + "VALUES("
                        + idDokladu + ", "
                        + idKlientInfo + ", "
                        + "'synchronizace WEB')");
            }
            idDokladu = -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            ResultSet smlouva = PripojeniDB.dotazS("SELECT doklady_evidence_cislo FROM  spolecne.doklady_evidence "
                    + "WHERE doklady_evidence_druh_id = 1000 "
                    + "ORDER BY doklady_evidence_cislo DESC LIMIT 1");
            while (smlouva.next()) {

                cisloSmlouva = smlouva.getString(1);
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            return (cisloSmlouva);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    /**
     * @param cisloSmlouvaPujcka the cisloSmlouvaPujcka to set
     */
    public void setCisloSmlouvaPujcka(String cisloSmlouvaPujcka) {
        this.cisloSmlouvaPujcka = cisloSmlouvaPujcka;
    }

    /**
     * @return the novyKlient
     */
    public boolean isNovyKlient() {
        return novyKlient;
    }

    /**
     * @param novyKlient the novyKlient to set
     */
    public void setNovyKlient(boolean novyKlient) {
        this.novyKlient = novyKlient;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the vybranyBod
     */
    public int getVybranyBod() {
        return vybranyBod;
    }

    /**
     * @param vybranyBod the vybranyBod to set
     */
    public void setVybranyBod(int vybranyBod) {
        this.vybranyBod = vybranyBod;
    }

    /**
     * @return the infoAP
     */
    /*public String getInfoAP() {
    return infoAP;
    }*/
    public String getInfoAP() {
        try {
            ResultSet iAP = PripojeniDB.dotazS("SELECT nazev, vazba_pristup_bod_ip_ip "
                    + "FROM pristup_bod "
                    + "CROSS JOIN vazba_pristup_bod_ip "
                    + "WHERE vazba_pristup_bod_ip_id = id "
                    + "AND id = " + vybranyBod);
            while (iAP.next()) {
                infoAP = " : " + iAP.getString(1) + " , IP : " + iAP.getString(2);
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
            return infoAP;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * @param infoAP the infoAP to set
     */
    public void setInfoAP(String infoAP) {
        this.infoAP = infoAP;
    }
}
