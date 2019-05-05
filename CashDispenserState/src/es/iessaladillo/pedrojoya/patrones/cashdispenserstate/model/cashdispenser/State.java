package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cashdispenser;

// Friendly so it can be only be used from the package.
interface State {

    void insertCard(CashDispenser cashDispenser, String cardNumber);
    void ejectCard(CashDispenser cashDispenser);
    void enterPin(CashDispenser cashDispenser, String pin);
    void withdrawCash(CashDispenser cashDispenser, int amount);
    void depositCash(CashDispenser cashDispenser, int amount);

}
