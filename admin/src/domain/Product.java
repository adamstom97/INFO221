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
public class Product implements Comparable<Product>{
    private Integer productID;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer quantity;

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
    public Product(Integer productID, String name, String description, 
            String category, Double price, Integer quantity) {
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
    
    @Override
    public int compareTo(Product other) {
        String myName = this.getName();
        String theirName = other.getName();
        return myName.compareTo(theirName);
    }

    /**
     * @return productID    {@link Product#productID} 
     */
    public Integer getProductID() {
        return productID;
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
    public Double getPrice() {
        return price;
    }

    /**
     * @param price     {@link Product#price}
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return quantity {@link Product#quantity}
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity  {@link Product#quantity}
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
