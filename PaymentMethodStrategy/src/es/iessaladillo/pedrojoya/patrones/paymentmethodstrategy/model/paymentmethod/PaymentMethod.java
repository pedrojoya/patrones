package es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.paymentmethod;

import java.math.BigDecimal;

public interface PaymentMethod {
    void pay(BigDecimal price);
}
