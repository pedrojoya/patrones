package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cashdispenser;

// Card inserted. Pin not entered.
// Friendly so it can be only be used from the package.
class NoPinState implements State {

    // The cashdispenser has a card inside but no pin
    // and the client tries to insert another card.
    @Override
    public void insertCard(CashDispenser cashDispenser, String cardNumber) {
        throw new IllegalStateException("Error: Ya hay una tarjeta en el cajero");
    }

    // The cashdispenser has a card inside but no pin
    // and the client tries to eject the card.
    @Override
    public void ejectCard(CashDispenser cashDispenser) {
        cashDispenser.moveToNoCardState();
    }

    // The cashdispenser has a card inside but no pin
    // and the client tries to enter the pin.
    @Override
    public void enterPin(CashDispenser cashDispenser, String pin) {
        if (!cashDispenser.validatePin(pin)) {
            throw new IllegalArgumentException("Error: Pin no válido");
        }
        cashDispenser.moveToPinState();
    }

    // The cashdispenser has a card inside but no pin
    // and the client tries to withdraw cash.
    @Override
    public void withdrawCash(CashDispenser cashDispenser, int amount) {
        throw new IllegalStateException("Error: Introduzca el pin, por favor");
    }

    // The cashdispenser has a card inside but no pin
    // and the client tries to deposit cash.
    @Override
    public void depositCash(CashDispenser cashDispenser, int amount) {
        throw new IllegalStateException("Error: Introduzca el pin, por favor");
    }

}
