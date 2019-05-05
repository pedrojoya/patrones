package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cashdispenser;

// Card inserted and pin entered.
// Friendly so it can be only be used from the package.
class PinState implements State {

    // The cashdispenser has a card inside and valid pin entered
    // and the client tries to insert another card.
    @Override
    public void insertCard(CashDispenser cashDispenser, String cardNumber) {
        throw new IllegalStateException("Error: Ya hay una tarjeta en el cajero");
    }

    // The cashdispenser has a card inside and valid pin entered
    // and the client tries to eject the card.
    @Override
    public void ejectCard(CashDispenser cashDispenser) {
        cashDispenser.moveToNoCardState();
    }

    // The cashdispenser has a card inside and valid pin entered
    // and the client tries to enter another pin.
    @Override
    public void enterPin(CashDispenser cashDispenser, String pin) {
        throw new IllegalStateException("Error: Ya ha introducido el pin");
    }

    // The cashdispenser has a card inside and valid pin entered
    // and the client tries to withdraw cash
    @Override
    public void withdrawCash(CashDispenser cashDispenser, int amount) {
        cashDispenser.withdraw(amount);
    }

    // The cashdispenser has a card inside and valid pin entered
    // and the client tries to deposit cash
    @Override
    public void depositCash(CashDispenser cashDispenser, int amount) {
        cashDispenser.deposit(amount);
    }

}
