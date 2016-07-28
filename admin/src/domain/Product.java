/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * A class containing all the information on a single product offered for
 * sale at the shop. 
 * 
 * @author adath325
 * @version 1.0
 */
public class Product {
    private int productID;
    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;

    /**
     * A constructor for the product.
     * 
     * @param productID     a unique ID for the product
     * @param name          the product's name
     * @param description   a description of the product
     * @param category      the category that the product belongs to
     * @param price         how much the product costs, each
     * @param quantity      the amount of the product available for sale
     */
    public Product(int productID, String name, String description, 
            String category, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "* Product " + productID + ": " + name + ", " + description + 
                "; " + category + "; $" + String.format("%.2f", price) + 
                "; " + quantity + " in stock.";
    }

    /**
     * @return productID    {@link Product#productID} 
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID     {@link Product#productID}
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return name {@link Product#name}
     */
    public String getName() {
        return name;
    }

    /**
     * @param name  {@link Product#name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description  {@link Product#description}
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description   {@link Product#description}
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return category {@link Product#category}
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category  {@link Product#category}
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return price    {@link Product#price}
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price     {@link Product#price}
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return quantity {@link Product#quantity}
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity  {@link Product#quantity}
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
