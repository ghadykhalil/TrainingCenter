package controllers;

import enums.paymentMethod;
import models.Paypal;
import models.VisaCard;
import models.PaymentMethod;

public class PaymentMethodFactory {

    // Method to create PaymentMethod objects based on the type
    public static PaymentMethod createPaymentMethod(paymentMethod paymentMethod, String username, String password, String cardNumber, String threeDigitCode) {
        switch (paymentMethod) {
            case Paypal:
                return new Paypal(username, password);
            case VisaCard:
                return new VisaCard(cardNumber, threeDigitCode);
            default:
                throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
        }
    }
}
