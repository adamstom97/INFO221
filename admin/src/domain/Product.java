/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 * A class containing all the information on a single product offered for
 * sale at the shop. 
 * 
 * @author adath325
 * @version 2.0
 */
public class Product implements Comparable<Product>{
    @NotNull(message = "ID must be provided.")
    @NotNegative(message = "ID must be a positive number.")
    private Integer productID;
    
    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min=2, message="Name must contain at least two characters.")
    private String name;
    
    private String description;
    
    @NotNull(message = "Category must be provided.")
    @NotBlank(message = "Category must be provided.")
    private String category;
    
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be a positive number.")
    private Double price;
    
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be a positive number.")
    @Min(value=1, message="Quanity must be greater than zero.")
    private Integer quantity;

    /**
     * A default constructor for the product.
     */
    public Product() {}

    /**
     * A constructor that sets all the product's information.
     * 
     * @param productID     the product's unique ID number
     * @param name          the product's name
     * @param description   a description of the product
     * @param category      the category that the product is in
     * @param price         the standard price of the product
     * @param quantity      the quantity of the product available
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
        return Objects.equals(this.productID, other.productID);
    }

    /**
     * @return productID    {@link Product#productID} 
     */
    public Integer getProductID() {
        return productID;
    }
    
    /**
     * @param productID     {@link Product#productID}
     */
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
