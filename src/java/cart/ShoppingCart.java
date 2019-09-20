/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.AkceHlavni;
import entity.DruhyPrihlasek;
import entity.Obdobi;
import entity.Osoby;
import java.util.*;

/**
 *
 * @author tgiunipero
 */
public class ShoppingCart {

    List<ShoppingCartItem> items;
    int numberOfItems;
    double total;

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        total = 0;
    }

    /**
     * Adds a <code>ShoppingCartItem</code> to the <code>ShoppingCart</code>'s
     * <code>items</code> list. If item of the specified <code>product</code>
     * already exists in shopping cart list, the quantity of that item is
     * incremented.
     *
     * @param product the <code>Product</code> that defines the type of shopping cart item
     * @see ShoppingCartItem
     */
    public synchronized void addItem(AkceHlavni product) {

        boolean newItem = true;

        for (ShoppingCartItem scItem : items) {

            if (scItem.getProduct().getAkceId() == product.getAkceId()) {

                newItem = false;
                scItem.incrementQuantity();
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(product);
            items.add(scItem);
        }
    }
    
    public synchronized void addItem(AkceHlavni product, boolean klientOsoba) {

        boolean newItem = true;

        for (ShoppingCartItem scItem : items) {

            if (scItem.getProduct().getAkceId() == product.getAkceId()) {

                newItem = false;
                scItem.incrementQuantity();
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(product);
            if(klientOsoba) {
                scItem.incrementQuantity();
            }
            items.add(scItem);
        }
    }

    public synchronized void addItem(AkceHlavni product, ArrayList<Osoby> prihlaseni, Obdobi obdobiPrihl, ArrayList<DruhyPrihlasek> druhyPrihlasek) {

        boolean newItem = true;

        for (ShoppingCartItem scItem : items) {

            if (scItem.getProduct().getAkceId() == product.getAkceId()) {

                newItem = false;
                for(Osoby p : prihlaseni) {
                    if(!scItem.getPrihlaseni().contains(p)) {
                        scItem.getPrihlaseni().add(p);
                        scItem.incrementQuantity();
                    }
                }
                //prihlaseni.addAll(scItem.getPrihlaseni());
                //scItem.setPrihlaseni(prihlaseni);

                
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(product, prihlaseni, obdobiPrihl, druhyPrihlasek);
            
            items.add(scItem);
        }
    }

    public synchronized void removeOsoba(AkceHlavni product, Osoby osOdebrat) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().equals(product)) {               
                items.get(i).getPrihlaseni().remove(osOdebrat);
                items.get(i).decrementQuantity();
                /*  for(int j = 0; j < items.get(i).getPrihlaseni().size(); j++) {
                if(items.get(i).getPrihlaseni().get(i).equals(osOdebrat)) {
                
                }
                }*/
            }
        }
    }
    
    public synchronized void removeAkce(AkceHlavni product) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().equals(product)) {               
                items.remove(i);               
            }
        }
    }

    /**
     * Updates the <code>ShoppingCartItem</code> of the specified
     * <code>product</code> to the specified quantity. If '<code>0</code>'
     * is the given quantity, the <code>ShoppingCartItem</code> is removed
     * from the <code>ShoppingCart</code>'s <code>items</code> list.
     *
     * @param product the <code>Product</code> that defines the type of shopping cart item
     * @param quantity the number which the <code>ShoppingCartItem</code> is updated to
     * @see ShoppingCartItem
     */
    public synchronized void update(AkceHlavni product, String quantity) {

        short qty = -1;

        // cast quantity as short
        qty = Short.parseShort(quantity);

        if (qty >= 0) {

            ShoppingCartItem item = null;

            for (ShoppingCartItem scItem : items) {

                if (scItem.getProduct().getAkceId() == product.getAkceId()) {

                    if (qty != 0) {
                        // set item quantity to new value
                        scItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save item and break
                        item = scItem;
                        break;
                    }
                }
            }

            if (item != null) {
                // remove from cart
                items.remove(item);
            }
        }
    }

    /**
     * Returns the list of <code>ShoppingCartItems</code>.
     *
     * @return the <code>items</code> list
     * @see ShoppingCartItem
     */
    public synchronized List<ShoppingCartItem> getItems() {

        return items;
    }

    /**
     * Returns the sum of quantities for all items maintained in shopping cart
     * <code>items</code> list.
     *
     * @return the number of items in shopping cart
     * @see ShoppingCartItem
     */
    public synchronized int getNumberOfItems() {

        numberOfItems = 0;

        for (ShoppingCartItem scItem : items) {

            numberOfItems += scItem.getQuantity();
        }

        return numberOfItems;
    }
    
    public synchronized int getNumberOfProducts() {
        return items.size();
    }

    /**
     * Returns the sum of the product price multiplied by the quantity for all
     * items in shopping cart list. This is the total cost excluding the surcharge.
     *
     * @return the cost of all items times their quantities
     * @see ShoppingCartItem
     */
    public synchronized double getSubtotal() {

        double amount = 0;

        for (ShoppingCartItem scItem : items) {

            AkceHlavni product = (AkceHlavni) scItem.getProduct();
            amount += (scItem.getQuantity() * product.getUcastnickyPoplatek().doubleValue());
        }

        return amount;
    }

    /**
     * Calculates the total cost of the order. This method adds the subtotal to
     * the designated surcharge and sets the <code>total</code> instance variable
     * with the result.
     *
     * @param surcharge the designated surcharge for all orders
     * @see ShoppingCartItem
     */
    public synchronized void calculateTotal(String surcharge) {

        double amount = 0;

        // cast surcharge as double
        double s = Double.parseDouble(surcharge);

        amount = this.getSubtotal();
        amount += s;

        total = amount;
    }

    /**
     * Returns the total cost of the order for the given
     * <code>ShoppingCart</code> instance.
     *
     * @return the cost of all items times their quantities plus surcharge
     */
    public synchronized double getTotal() {

        return total;
    }

    /**
     * Empties the shopping cart. All items are removed from the shopping cart
     * <code>items</code> list, <code>numberOfItems</code> and
     * <code>total</code> are reset to '<code>0</code>'.
     *
     * @see ShoppingCartItem
     */
    public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
}