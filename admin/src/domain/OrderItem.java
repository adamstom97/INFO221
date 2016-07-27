/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author adath325
 */
public class OrderItem {
    private double quantityPurchased;
    private double purchasePrice;

    public double getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(double quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public double getItemTotal(){
        return quantityPurchased * purchasePrice;
    }
}
