package silh.shopeasier.shoppinglist.exceptions.create;

public class EmptyLoginException extends UserCreationException {
    private static final long serialVersionUID = -1811476810291625818L;

    private static final String DEFAULT_MESSAGE = "Login cannot be empty";

    public EmptyLoginException() {
        super(DEFAULT_MESSAGE);
    }
}
