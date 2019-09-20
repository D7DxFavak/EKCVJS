/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.AkceHlavni;
import entity.DruhyPrihlasek;
import entity.Obdobi;
import entity.Osoby;
import java.util.ArrayList;

/**
 *
 * @author tgiunipero
 */
public class ShoppingCartItem {

    AkceHlavni product;
    private ArrayList<Osoby> prihlaseni;
    private Obdobi obdobiPrihl;
    private ArrayList<DruhyPrihlasek> druhyPrihlasek;
    int quantity;

    public ShoppingCartItem(AkceHlavni product) {
        this.product = product;
        quantity = 0;//TODO : bylo 1
    }
    
    public ShoppingCartItem(AkceHlavni product, ArrayList<Osoby> prihlaseni, Obdobi obdobiPrihl, ArrayList<DruhyPrihlasek> druhyPrihlasek) {
        this.product = product;
        this.prihlaseni = prihlaseni;
        this.obdobiPrihl = obdobiPrihl;
        this.druhyPrihlasek = druhyPrihlasek;
        quantity = prihlaseni.size();
    }

    public AkceHlavni getProduct() {
        return product;
    }
    
     public ArrayList<Osoby> getPrihlaseni() {
        return prihlaseni;
    }

    public void setPrihlaseni(ArrayList<Osoby> prihlaseni) {
        this.prihlaseni = prihlaseni;
        this.quantity = prihlaseni.size();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * product.getUcastnickyPoplatek().doubleValue());
        return amount;
    }

    /**
     * @return the obdobiPrihl
     */
    public Obdobi getObdobiPrihl() {
        return obdobiPrihl;
    }

    /**
     * @param obdobiPrihl the obdobiPrihl to set
     */
    public void setObdobiPrihl(Obdobi obdobiPrihl) {
        this.obdobiPrihl = obdobiPrihl;
    }

    /**
     * @return the druhyPrihlasek
     */
    public ArrayList<DruhyPrihlasek> getDruhyPrihlasek() {
        return druhyPrihlasek;
    }

    /**
     * @param druhyPrihlasek the druhyPrihlasek to set
     */
    public void setDruhyPrihlasek(ArrayList<DruhyPrihlasek> druhyPrihlasek) {
        this.druhyPrihlasek = druhyPrihlasek;
    }
    
    public DruhyPrihlasek getDruhPrihlaskyAktualni(int id) {
        return druhyPrihlasek.get(id);
    }   
    
}