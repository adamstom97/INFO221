/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * A class containing all the information on a single customer's account for 
 * the shop.
 * 
 * @author adath325
 * @version 1.0
 */
public class Customer {
    private String userName;
    private String name;
    private String creditCardDetails;
    private String password;

    /**
     * A constructor for the customer.
     * 
     * @param userName          the customer's personal, online username
     * @param name              the customer's name
     * @param creditCardDetails the customer's credit card number
     * @param password          the customer's password
     */
    public Customer(String userName, String name, String creditCardDetails, 
            String password) {
        this.userName = userName;
        this.name = name;
        this.creditCardDetails = creditCardDetails;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "userName=" + userName + ", name=" + name + 
                ", creditCardDetails=" + creditCardDetails + 
                ", password=" + password + '}';
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
}
