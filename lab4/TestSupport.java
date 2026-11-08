package lab4;

final class TestSupport {
    private TestSupport() {
    }

    static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
