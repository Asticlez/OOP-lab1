package lab2;

// Small test helper: checks always run, without needing Java's -ea option.
final class TestSupport {
    private TestSupport() {
    }

    static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
