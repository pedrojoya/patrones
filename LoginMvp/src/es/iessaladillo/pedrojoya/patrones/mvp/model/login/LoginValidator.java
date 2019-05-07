package es.iessaladillo.pedrojoya.patrones.mvp.model.login;

public class LoginValidator implements LoginUseCase {

    @Override
    public boolean login(String username, String password) {
        // Supongamos que el único usuario valido es:
        // Baldo - 1234
        return "Baldo".equals(username) && "1234".equals(password);
    }

}
