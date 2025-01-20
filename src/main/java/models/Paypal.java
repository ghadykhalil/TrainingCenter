/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Paypal implements PaymentMethod {

    private int id;
    private static int next = 0;
    private String username;
    private String password;
    private boolean paymentStatus;
    private double amount;

    public Paypal() {
    }

    public Paypal(String username, String password, boolean paymentStatus, double amount) {
        this.id = ++next;
        this.username = username;
        this.password = password;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    @Override
    public void pay() {
        //authentication logic (just validation)
    }

    @Override
    public boolean getPaymentStatus() {
        return this.paymentStatus;
    }

    @Override
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
