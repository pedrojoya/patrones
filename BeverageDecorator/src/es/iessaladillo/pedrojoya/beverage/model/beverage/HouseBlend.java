package es.iessaladillo.pedrojoya.beverage.model.beverage;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class HouseBlend extends Beverage {

    public HouseBlend() {
        super("House blend coffee");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(0.89);
    }

}
