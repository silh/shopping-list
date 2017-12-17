package silh.shopeasier.shoppinglist.utils;

import java.util.function.Supplier;

public class Utils {
    private Utils() {
    }

    public static void checkAndThrow(boolean expression, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (expression) {
            throw exceptionSupplier.get();
        }
    }
}
