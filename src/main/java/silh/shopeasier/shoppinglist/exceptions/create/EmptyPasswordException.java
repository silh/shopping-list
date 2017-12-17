package silh.shopeasier.shoppinglist.exceptions.create;

public class EmptyPasswordException extends UserCreationException {
    private static final long serialVersionUID = -230905071774162714L;

    private static final String DEFAULT_MESSAGE = "Password cannot be empty";

    public EmptyPasswordException() {
        super(DEFAULT_MESSAGE);
    }
}
