package es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.paymentmethod;

import java.math.BigDecimal;

@SuppressWarnings("FieldCanBeLocal")
public class ByPaypal implements PaymentMethod {

    @SuppressWarnings("unused")
    private final String paypalUsername;
    @SuppressWarnings("unused")
    private final String paypalPassword;

    public ByPaypal(String paypalUsername, String paypalPassword) {
        this.paypalUsername = paypalUsername;
        this.paypalPassword = paypalPassword;
        checkValidPaypalAccount();
    }

    @Override
    public void pay(BigDecimal charge) {
        System.out.printf("%.2f pagados mediante Paypal", charge.floatValue());
    }

    @SuppressWarnings("EmptyMethod")
    private void checkValidPaypalAccount() {
        // ...
    }

}