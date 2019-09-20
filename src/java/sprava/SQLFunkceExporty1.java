// SQL Funkce Exporty

package sprava;

import java.sql.*;
import java.util.*;


public class SQLFunkceExporty1
{
 private static Vector v;
 private static java.text.DateFormat df = java.text.DateFormat.getDateInstance();

 private static java.text.NumberFormat nf;



 //vraci vektor retezcu pro export dat dokladu
 //v poradi cislo, nazev, datum_vystaveni, datum_zdp, datum_splatnosti
 protected static Vector getVektorDatExportDokladu1(String polozky) {
  Vector navrat = new Vector();

  navrat.add("cislo\tnazev\tcastka\tdatum_vystaveni\tdatum_zdanitelneho_plneni\tdatum_splatnosti");

  if(!polozky.equalsIgnoreCase("")) {
   try {
     ResultSet q = PripojeniDB.dotazS (
      "SELECT doklady_evidence_cislo, doklady_evidence_nazev, COALESCE(zfdata.suma_md, 0) AS castka, " +
      "to_char(doklady_evidence_datum_vystaveni, 'DD.MM.YYYY'), to_char(doklady_evidence_datum_zdanitelneho_plneni, 'DD.MM.YYYY'), to_char(doklady_evidence_datum_splatnosti, 'DD.MM.YYYY') " +
      "FROM spolecne.doklady_evidence " +
      "LEFT OUTER JOIN " +
      "(" +
      "SELECT zauctovaci_fronta_vychozi_doklad_id AS zfdokladid, sum(zauctovaci_fronta_castka_md) AS suma_md " +
      "FROM ucetnictvi.zauctovaci_fronta " +
      "WHERE zauctovaci_fronta_ucetni_zaznam_druh_id IN (60,40) "+
      "GROUP BY zauctovaci_fronta_vychozi_doklad_id " +
      ") AS zfdata " +
      "ON " +
      "(doklady_evidence_id = zfdata.zfdokladid) " +
      "WHERE doklady_evidence_id IN (" + polozky + ") " +
      "ORDER BY doklady_evidence_nazev, doklady_evidence_datum_vystaveni"
      );
      q.last();
      if(q.getRow() > 0) {
      q.beforeFirst();
       while(q.next()) {
       navrat.add(q.getString(1) + "\t" + q.getString(2) + "\t" + q.getString(3) + "\t" + q.getString(4) + "\t" + q.getString(5) + "\t" + q.getString(6));
       }//konec while
      }//konec if q.getRow() > 0
    } // konec try
    catch (Exception e) {
     PripojeniDB.vyjimkaS(e);
    } // konec catch
    finally {
     return navrat;
    }
  }//konec if polozky
  else//pokud jsou prazdne polozky, navrat pouze hlavicku dat
   return navrat;

 }//konec getVektorDatExportDokladu1


 //vraci vektor retezcu pro export dat bankovnich transakci
 //v poradi popis, castka, datum_zauctovani, VS, KS, SS
 protected static Vector getVektorDatExportBT1(String polozky) {
  Vector navrat = new Vector();

  navrat.add("popis_transakce\tcastka\tdatum_zauctovani\tvariabilni_symbol\tkonstantni_symbol\tspecificky_symbol");

  if(!polozky.equalsIgnoreCase("")) {
   try {
     ResultSet q = PripojeniDB.dotazS (
      "SELECT bankovni_ucty_transakce_popis, bankovni_ucty_transakce_castka, " +
      "to_char(bankovni_ucty_transakce_datum_zauctovani, 'DD.MM.YYYY'), " +
      "bankovni_ucty_transakce_variabilni_symbol, bankovni_ucty_transakce_konstantni_symbol, bankovni_ucty_transakce_specificky_symbol " +
      "FROM bankovnictvi.bankovni_ucty_transakce " +
      "WHERE bankovni_ucty_transakce_id IN (" + polozky + ") " +
      "ORDER BY bankovni_ucty_transakce_datum_zauctovani"
      );
      q.last();
      if(q.getRow() > 0) {
      q.beforeFirst();
       while(q.next()) {
       navrat.add(q.getString(1) + "\t" + q.getString(2) + "\t" + q.getString(3) + "\t" + q.getString(4) + "\t" + q.getString(5) + "\t" + q.getString(6));
       }//konec while
      }//konec if q.getRow() > 0
    } // konec try
    catch (Exception e) {
     PripojeniDB.vyjimkaS(e);
    } // konec catch
    finally {
     return navrat;
    }
  }//konec if polozky
  else//pokud jsou prazdne polozky, navrat pouze hlavicku dat
   return navrat;

 }//konec getVektorDatExportBT1



}// Konec SQLFunkceExporty1
