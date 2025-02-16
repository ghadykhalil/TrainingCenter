/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helpers.IdGenerator;

/**
 *
 * @author User
 */
public class Paypal implements PaymentMethod {

    private String id;
    private String username;
    private String password;

    public Paypal() {
        id = IdGenerator.generateId();

    }

    public Paypal(String username, String password, boolean paymentStatus, double amount) {
        this();
        this.username = username;
        this.password = password;
    }

    @Override
    public void pay() {
        //authentication logic (just validation)
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

}
