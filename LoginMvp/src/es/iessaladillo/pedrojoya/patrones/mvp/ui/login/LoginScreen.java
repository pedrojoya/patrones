package es.iessaladillo.pedrojoya.patrones.mvp.ui.login;

import es.iessaladillo.pedrojoya.patrones.mvp.model.login.LoginValidator;

import java.util.Scanner;

public class LoginScreen implements LoginView {

    private final LoginPresenter presenter = new LoginPresenter(this, new LoginValidator());
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        showHeader();
        tryLogin();
    }

    private void showHeader() {
        System.out.println("\n********************");
        System.out.println("PANTALLA DE CONEXIÓN");
        System.out.println("********************\n");
    }

    private void tryLogin() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        presenter.login(username, password);
    }

    @Override
    public void showSuccessfulLogin(String username) {
        System.out.println("\nBienvenido, " + username);
    }

    @Override
    public void showInvalidLogin() {
        System.out.println("\nNombre de usuario o contraseña incorrectos");
    }

}
