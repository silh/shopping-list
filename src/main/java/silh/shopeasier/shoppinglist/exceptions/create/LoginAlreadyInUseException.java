package silh.shopeasier.shoppinglist.exceptions.create;

public class LoginAlreadyInUseException extends UserCreationException {
    private static final long serialVersionUID = 7508076590883573914L;

    private static final String LOGIN_IN_USE_MESSAGE_TEMPLATE = "Login %s is already in use";

    public LoginAlreadyInUseException(String login) {
        super(String.format(LOGIN_IN_USE_MESSAGE_TEMPLATE, login));
    }
}
