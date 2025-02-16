/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helpers.IdGenerator;
import java.util.Date;

/**
 *
 * @author User
 */
enum paymentMethod {
    VisaCard,
    Paypal,
}

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

}
