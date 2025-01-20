/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author User
 */
public class VisaCard implements PaymentMethod {

    private int id;
    private static int next = 0;
    private String cardNumber;
    private String threeDigitCode;
    private Date expiryDate;
    private boolean paymentStatus = false;
    double amount;

    public VisaCard() {
    }

    ;

    public VisaCard(String cardNumber, String threeDigitCode, Date expiryDate, double amount) {
        this.id = ++next;
        this.cardNumber = cardNumber;
        this.threeDigitCode = threeDigitCode;
        this.expiryDate = expiryDate;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getThreeDigitCode() {
        return threeDigitCode;
    }

    public void setThreeDigitCode(String threeDigitCode) {
        this.threeDigitCode = threeDigitCode;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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
