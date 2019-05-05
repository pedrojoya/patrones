package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cardvalidator;

public interface CardValidator {

    boolean validateCard(String cardNumber);
    boolean validatePin(String cardNumber, String pin);

}
