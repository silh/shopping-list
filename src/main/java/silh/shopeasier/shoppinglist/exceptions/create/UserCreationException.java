package silh.shopeasier.shoppinglist.exceptions.create;

public class UserCreationException extends RuntimeException {
    private static final long serialVersionUID = -1199992659773811764L;

    public UserCreationException(String message) {
        super(message);
    }
}
