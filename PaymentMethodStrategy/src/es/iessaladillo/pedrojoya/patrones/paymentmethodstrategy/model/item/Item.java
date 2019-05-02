package es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.item;

import java.math.BigDecimal;

@SuppressWarnings("WeakerAccess")
public abstract class Item {

    private String name;
    private BigDecimal price;

    protected Item(String name, float price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("{%s, %.2f}", name, price.floatValue());
    }

}
