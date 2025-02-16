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
public class VisaCard implements PaymentMethod {

    private String id;
    private String cardNumber;
    private String threeDigitCode;

    public VisaCard() {
        id = IdGenerator.generateId();

    }

    ;

    public VisaCard(String cardNumber, String threeDigitCode) {
        this();
        this.cardNumber = cardNumber;
        this.threeDigitCode = threeDigitCode;
    }

    @Override
    public void pay() {
        //authentication logic (just validation)
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

}
