package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cashdispenser;

// Card not inserted.
// Friendly so it can be only be used from the package.
class NoCardState implements State {

    // The cashdispenser has no card and the client tries to insert a card.
    @Override
    public void insertCard(CashDispenser cashDispenser, String cardNumber) {
        if (!cashDispenser.validateCard(cardNumber)) {
            throw new IllegalArgumentException("Error: Tarjeta no válida");
        }
        cashDispenser.moveToNoPinState(cardNumber);
    }

    // The cashdispenser has no card and the client tries to remove a card.
    @Override
    public void ejectCard(CashDispenser cashDispenser) {
        throw new IllegalStateException("Error: Inserte una tarjeta, por favor");
    }

    // The cashdispenser has no card and the client tries to enter pin.
    @Override
    public void enterPin(CashDispenser cashDispenser, String pin) {
        throw new IllegalStateException("Error: Inserte una tarjeta, por favor");
    }

    // The cashdispenser has no card and the client tries to withdraw cash.
    @Override
    public void withdrawCash(CashDispenser cashDispenser, int amount) {
        throw new IllegalStateException("Error: Inserte una tarjeta, por favor");
    }

    // The cashdispenser has no card and the client tries to deposit cash.
    @Override
    public void depositCash(CashDispenser cashDispenser, int amount) {
        throw new IllegalStateException("Error: Inserte una tarjeta, por favor");
    }

}
