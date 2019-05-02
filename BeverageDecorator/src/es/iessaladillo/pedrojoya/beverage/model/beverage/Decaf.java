package es.iessaladillo.pedrojoya.beverage.model.beverage;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class Decaf extends Beverage {

    public Decaf() {
        super("Decaf");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(1.05);
    }

}
