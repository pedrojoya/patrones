package es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model;

import es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.item.Item;
import es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.paymentmethod.PaymentMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ShoppingCart {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Item item : items) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    // Se recibe el método de pago (estrategia de pago) como parámetro.
    public void pay(PaymentMethod paymentMethod){
        BigDecimal total = calculateTotal();
        // Se delega la responsabilidad de pago al método de pago.
        paymentMethod.pay(total);
    }

}