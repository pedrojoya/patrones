package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cashdispenser;

import es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cardvalidator.CardValidator;

import java.util.Objects;

public class CashDispenser {

    // Cache of possible states.
    private final NoCardState noCardState = new NoCardState();
    private final NoPinState noPinState = new NoPinState();
    private final PinState pinState = new PinState();

    private State state;
    private int cash;
    private String cardNumber;
    private final CardValidator cardValidator;

    public CashDispenser(int initialCash, CardValidator cardValidator) {
        this.cash = initialCash;
        this.cardValidator = cardValidator;
        // Initial state.
        state = noCardState;
        validateConstructorArguments();
    }

    public int getCash() {
        return cash;
    }

    private void validateConstructorArguments() {
        Objects.requireNonNull(cardValidator);
        if (cash < 0) {
            throw new IllegalArgumentException("Invalid amount of cash");
        }
    }

    void withdraw(int amount) {
        if (cash >= amount) {
            cash -= amount;
        } else {
            throw new IllegalArgumentException("ERROR: Only " + cash + " available");
        }
    }

    void deposit(int amount) {
        cash += amount;
    }

    boolean validateCard(String cardNumber) {
        return cardValidator.validateCard(cardNumber);
    }

    boolean validatePin(String pin) {
        return cardValidator.validatePin(cardNumber, pin);
    }

    // State transition methods

    void moveToNoPinState(String cardNumber) {
        this.cardNumber = cardNumber;
        state = noPinState;
    }

    void moveToNoCardState() {
        this.cardNumber = null;
        state = noCardState;
    }

    void moveToPinState() {
        state = pinState;
    }

    // Operations

    public void tryInsertCard(String cardNumber) {
        state.insertCard(this, cardNumber);
    }

    public void tryEjectCard() {
        state.ejectCard(this);
    }

    public void tryEnterPin(String pin) {
        state.enterPin(this, pin);
    }

    public void tryWithdrawMoney(int amount) {
        state.withdrawCash(this, amount);
    }

    public void tryDepositMoney(int amount) {
        state.depositCash(this, amount);
    }

}
