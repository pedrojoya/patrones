package es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.paymentmethod;

import java.math.BigDecimal;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class ByCreditCard implements PaymentMethod {

    private final String cardHolderName;
    private final String cardNumber;
    private final String cardCvv;
    private final String cardGoodThru;

    public ByCreditCard(String cardHolderName, String cardNumber, String cardCvv, String cardGoodThru) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cardCvv = cardCvv;
        this.cardGoodThru = cardGoodThru;
        checkValidCreditCard();
    }

    @Override
    public void pay(BigDecimal charge) {
        System.out.printf("%.2f pagados mediante tarjeta de crédito", charge.floatValue());
    }

    @SuppressWarnings("EmptyMethod")
    private void checkValidCreditCard() {
        // ...
    }

}