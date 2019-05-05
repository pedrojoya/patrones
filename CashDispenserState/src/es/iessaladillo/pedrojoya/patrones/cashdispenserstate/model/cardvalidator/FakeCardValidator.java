package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cardvalidator;

public class FakeCardValidator implements CardValidator {

    @Override
    public boolean validateCard(String cardNumber) {
        return "1234".equals(cardNumber);
    }

    @Override
    public boolean validatePin(String cardNumber, String pin) {
        return "1234".equals(cardNumber) && "1234".equals(pin);
    }

}
