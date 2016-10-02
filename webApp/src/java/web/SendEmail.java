package web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DaoException;
import domain.Customer;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import report.Report;

/**
 * A class for sending an email to the customer after their order has been
 * processed, including generating and attaching a PDF receipt to the email.
 * 
 * @author adath325
 * @version 4.0
 */
public class SendEmail extends java.lang.Thread{
    private Customer customer;
    private String orderID;
    
    public SendEmail(Customer customer, String orderID) {
        this.customer = customer;
        this.orderID = orderID;
    }

    @Override
    public void run() {
        String userName = customer.getName();
        String userEmail = customer.getEmail();
        
        Report report = new Report(orderID);
        report.createReport();
        
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("h:/INFO221/reports/receipt.pdf");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("PDF of Order Receipt");
        attachment.setName("Date Receipt");

        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("localhost");
            email.setSmtpPort(2525);
            email.addTo(userEmail, userName);
            email.setFrom("theshop@apache.org", "TheShop.com");
            email.setSubject("Your Order");
            email.setMsg("Hello " + userName + ", thank you for your order!\n"
                    + "A copy of your receipt has been attached to this email "
                    + "for your convenience.\n"
                    + "We hope you visit our site again,\n"
                    + "TheShop.com team");

            email.attach(attachment);

            email.send();
        } catch (EmailException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }
}
