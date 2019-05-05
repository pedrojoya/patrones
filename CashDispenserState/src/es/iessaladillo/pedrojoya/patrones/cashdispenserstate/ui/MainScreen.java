package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.ui;

import es.iessaladillo.pedrojoya.patrones.cashdispenserstate.utils.ConsoleInput;
import es.iessaladillo.pedrojoya.patrones.cashdispenserstate.utils.menu.Menu;
import es.iessaladillo.pedrojoya.patrones.cashdispenserstate.utils.menu.MenuItem;
import es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cardvalidator.FakeCardValidator;
import es.iessaladillo.pedrojoya.patrones.cashdispenserstate.model.cashdispenser.CashDispenser;

public class MainScreen {

    private static final int EXIT = 6;

    private final CashDispenser cashDispenser;
    private final Menu menu;

    public static void main(String[] args) {
        new MainScreen();
    }

    public MainScreen() {
        cashDispenser = new CashDispenser(200, new FakeCardValidator());
        menu = new Menu("\nCAJERO DE BALDOBANC - OPERACIONES",
                new MenuItem("Insertar tarjeta", this::insertCardOption),
                new MenuItem("Retirar tarjeta", this::removeCardOption),
                new MenuItem("Introducir pin", this::enterPinOption),
                new MenuItem("Sacar dinero", this::withdrawOption),
                new MenuItem("Ingresar dinero", this::depositOption),
                new MenuItem("Salir", this::exitOption));
    }

    public void show() {
        int selectedOption;
        do {
            selectedOption = showAndProcessMenu();
        } while (selectedOption != EXIT);
    }

    private int showAndProcessMenu() {
        System.out.print(menu.toString());
        int option = ConsoleInput.readInt(n -> n > 0 && n <= menu.getSize() - 1);
        menu.processOption(option);
        return option;
    }

    private void insertCardOption() {
        try {
            cashDispenser.tryInsertCard(requestCardNumber());
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    private void removeCardOption() {
        try {
            cashDispenser.tryEjectCard();
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    private void enterPinOption() {
        try {
            cashDispenser.tryEnterPin(requestPin());
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    private void withdrawOption() {
        try {
            int amount = requestWithdrawAmount();
            cashDispenser.tryWithdrawMoney(amount);
            System.out.printf("Retirados %d€\n", amount);
            System.out.printf("Disponibles %d€\n", cashDispenser.getCash());
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    private void depositOption() {
        try {
            int amount = requestDepositAmount();
            cashDispenser.tryDepositMoney(amount);
            System.out.printf("Ingresados %d€\n", amount);
            System.out.printf("Disponibles %d€\n", cashDispenser.getCash());
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    private void exitOption() {
        System.out.println("\nBye bye\n");
    }

    private String requestCardNumber() {
        System.out.print("Número de tarjeta: ");
        return ConsoleInput.readString(s -> !s.isEmpty());
    }

    private String requestPin() {
        System.out.print("Número de pin: ");
        return ConsoleInput.readString(s -> !s.isEmpty());
    }

    private int requestWithdrawAmount() {
        System.out.print("Cantidad que desea sacar: ");
        return ConsoleInput.readInt();
    }

    private int requestDepositAmount() {
        System.out.print("Cantidad que desea ingresar: ");
        return ConsoleInput.readInt();
    }

}
