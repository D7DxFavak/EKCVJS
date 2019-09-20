/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.WebProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 7Data Gotzy
 */
public class Resource {

    private String lang;
    private ArrayList<WebProperties> zdroj; 

    public Resource(String lang, List<WebProperties> zdroj) {
        this.lang = lang;
        this.zdroj = new ArrayList<WebProperties>(zdroj);
    }

    /**
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    public String nazev(String nazev) {
        String retVal = "";
      
        for (int i = 0; i < zdroj.size(); i++) {
            if (zdroj.get(i).getWebPropertiesNazev().equals(nazev)) {
                if (lang.equals("cs")) {
                    retVal = zdroj.get(i).getWebPropertiesCzPopis();
                } else if (lang.equals("en")) {
                    retVal = zdroj.get(i).getWebPropertiesEnPopis();
                } else {
                    retVal = zdroj.get(i).getWebPropertiesDePopis();
                }
            }
        }
        if (retVal == null) {
            retVal = nazev;
        } else {
            if (retVal.isEmpty()) {
                retVal = nazev;
            }
        }
        return retVal;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * @return the zdroj
     */
    public List<WebProperties> getZdroj() {
        return zdroj;
    }

    /**
     * @param zdroj the zdroj to set
     */
    public void setZdroj(List<WebProperties> zdroj) {
        this.zdroj = new ArrayList<WebProperties>(zdroj);
    }
    
}
