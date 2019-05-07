package es.iessaladillo.pedrojoya.patrones.mvp.model.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LoginValidatorTest {

    private static final String CORRECT_USERNAME = "Baldo";
    private static final String CORRECT_PASSWORD = "1234";
    private static final String WRONG_USERNAME = "test";
    private static final String WRONG_PASSWORD = "test";

    private LoginValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new LoginValidator();
    }

    @Test
    public void testCorrectLogin() {
        // Given
        // Nothing given
        // When
        boolean validated = validator.login(CORRECT_USERNAME, CORRECT_PASSWORD);
        // Then
        assertTrue(validated);
    }

    @Test
    public void testWrongLogin() {
        // Given
        // Nothing given
        // When
        boolean validated = validator.login(WRONG_USERNAME, WRONG_PASSWORD);
        // Then
        assertFalse(validated);
    }

}