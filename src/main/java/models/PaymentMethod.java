/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public interface PaymentMethod {

    void pay();

    boolean getPaymentStatus();

    void setPaymentStatus(boolean paymentStatus);

    double getAmount();

    void setAmount(double amount);

}
