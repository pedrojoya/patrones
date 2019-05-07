package es.iessaladillo.pedrojoya.patrones.mvp.ui.login;

import es.iessaladillo.pedrojoya.patrones.mvp.model.login.LoginUseCase;

public class LoginPresenter {

    private final LoginView view;
    private final LoginUseCase useCase;

    public LoginPresenter(LoginView view, LoginUseCase useCase) {
        this.view = view;
        this.useCase = useCase;
    }

    public void login(String username, String password) {
        if (useCase.login(username, password)) {
            view.showSuccessfulLogin(username);
        } else {
            view.showInvalidLogin();
        }
    }

}
