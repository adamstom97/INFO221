/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * A class containing all the information on a single product that the customer 
 * wishes to buy, including how much of it.
 * 
 * @author adath325
 * @version 2.0
 */
public class OrderItem {
    private double quantityPurchased;
    private Product product;

    /**
     * A constructor for the OrderItem.
     * 
     * @param quantityPurchased the amount of the product that the customer 
     *                          wishes to buy
     * @param product           the product that the customer wishes to buy
     */
    public OrderItem(double quantityPurchased, Product product) {
        this.quantityPurchased = quantityPurchased;
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "quantityPurchased=" + quantityPurchased + 
                ", product=" + product + '}';
    }

    /**
     * @return quantityPurchased    {@link OrderItem#quantityPurchased}
     */
    public double getQuantityPurchased() {
        return quantityPurchased;
    }

    /**
     * @param quantityPurchased     {@link OrderItem#quantityPurchased}
     */
    public void setQuantityPurchased(double quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }
    
    /**
     * @return product  {@link OrderItem#product}
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product   {@link OrderItem#product}
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    /**
     * Calculates the total price for the item by multiplying the product's 
     * price by the amount of the product that the customer wishes to buy.
     * 
     * @return the total price of the item
     */
    public double getItemTotal(){
        return quantityPurchased * product.getPrice();
    }
}
