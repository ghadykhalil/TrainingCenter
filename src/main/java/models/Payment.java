/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.paymentMethod;
import helpers.IdGenerator;

/**
 *
 * @author User
 */
public class Payment {

    private String id;
    private double amount;
    private boolean status;
    private paymentMethod paymentMethod;
    private String paymentMethodId;

    public Payment() {
        id = IdGenerator.generateId();
    }

    public Payment(double amount) {
        this();
        this.status = false;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public paymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(paymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;

    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.amount+ " $";
    }

}
