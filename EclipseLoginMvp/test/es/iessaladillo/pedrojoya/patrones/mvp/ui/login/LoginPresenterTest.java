package es.iessaladillo.pedrojoya.patrones.mvp.ui.login;

import org.junit.Test;

import es.iessaladillo.pedrojoya.patrones.mvp.model.login.LoginUseCase;
import org.junit.Before;

import static org.mockito.Mockito.*;

public class LoginPresenterTest {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private LoginView view;
    private LoginUseCase useCase;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = mock(LoginView.class);
        useCase = mock(LoginUseCase.class);
        presenter = new LoginPresenter(view, useCase);
    }

    @Test
    public void testSucessfulLogin() {
        // Given
        when(useCase.login(USERNAME, PASSWORD)).thenReturn(true);
        // When
        presenter.login(USERNAME, PASSWORD);
        // Then
        verify(useCase).login(USERNAME, PASSWORD);
        verify(view).showSuccessfulLogin(USERNAME);
    }

    @Test
    public void testInvalidLogin() {
        // Given
        when(useCase.login(USERNAME, PASSWORD)).thenReturn(false);
        // When
        presenter.login(USERNAME, PASSWORD);
        // Then
        verify(useCase).login(USERNAME, PASSWORD);
        verify(view).showInvalidLogin();
    }

}