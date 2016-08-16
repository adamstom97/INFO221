/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

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
     * A default constructor for the product.
     */
    public Product() {}

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
        return name;
    }
    
    @Override
    public int compareTo(Product other) {
        Integer myID = this.getProductID();
        Integer theirID = other.getProductID();
        return myID.compareTo(theirID);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.productID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
    }

    /**
     * @return productID    {@link Product#productID} 
     */
    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
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
