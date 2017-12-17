package silh.shopeasier.shoppinglist.exceptions.create;

public class LoginTooLongException extends UserCreationException {
    private static final long serialVersionUID = -9174434772462921510L;

    private static final String DEFAULT_MESSAGE = "Login is too long.";

    public LoginTooLongException() {
        super(DEFAULT_MESSAGE);
    }

    public LoginTooLongException(String message) {
        super(message);
    }
}
