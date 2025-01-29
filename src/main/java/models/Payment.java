/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;
import java.util.Date;

/**
 *
 * @author User
 */
public class Payment {

    private String id;
    private double amount;
    private boolean status;
    private Date paymentDate;

    public Payment() {
        id = IdGenerator.generateId();
    }

    public Payment(double amount, boolean status, Date paymentDate) {
        this();
        this.amount = amount;
        this.status = false;
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}
