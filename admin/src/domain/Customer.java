/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;
import net.sf.oval.constraint.HasSubstring;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * A class containing all the information on a single customer's account for the
 * shop.
 *
 * @author adath325
 * @version 4.0
 */
public class Customer implements Comparable<Customer>{
    @NotNull(message = "A username must be provided.")
    @NotBlank(message = "A username must be provided.")
    @Length(min=2, message="A username must contain at least two characters.")
    private String userName;
    
    @NotNull(message = "A name must be provided.")
    @NotBlank(message = "A name must be provided.")
    @Length(min=2, message="A name must contain at least two characters.")
    private String name;
    
    @NotNull(message = "An email address must be provided.")
    @NotBlank(message = "An email address must be provided.")
    @HasSubstring(value="@", message="Please enter an actual email address.")
    private String email;
    
    @NotNull(message = "An address must be provided.")
    @NotBlank(message = "An address must be provided.")
    private String address;
    
    @NotNull(message = "Credit Card details must be provided.")
    @NotBlank(message = "Credit Card details must be provided.")
    private String creditCardDetails;
    
    @NotNull(message = "A password must be provided.")
    @NotBlank(message = "A password must be provided.")
    private String password;

    /**
     * A constructor for the customer.
     *
     * @param userName the customer's personal, online username
     * @param name the customer's name
     * @param email
     * @param address
     * @param creditCardDetails the customer's credit card number
     * @param password the customer's password
     */
    public Customer(String userName, String name, String email, String address,
            String creditCardDetails, String password) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.address = address;
        this.creditCardDetails = creditCardDetails;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "userName=" + userName + ", name=" + name + 
                ", email=" + email + ", address=" + address + 
                ", creditCardDetails=" + creditCardDetails + ", password=" + 
                password + '}';
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
        final Customer other = (Customer) obj;
        return Objects.equals(this.userName+this.password, 
                other.userName+other.password);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userName);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    /**
     * @return userName {@link Customer#userName}
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName {@link Customer#userName}
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return name {@link Customer#name}
     */
    public String getName() {
        return name;
    }

    /**
     * @param name {@link Customer#name}
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return creditCardDetails {@link Customer#creditCardDetails}
     */
    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    /**
     * @param creditCardDetails {@link Customer#creditCardDetails}
     */
    public void setCreditCardDetails(String creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    /**
     * @return password {@link Customer#password}
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password {@link Customer#password}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(Customer other) {
        String myUserName = this.getUserName();
        String theirUserName = other.getUserName();
        return myUserName.compareTo(theirUserName);
    }
}
