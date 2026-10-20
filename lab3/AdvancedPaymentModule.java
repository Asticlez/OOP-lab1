package lab3;

public class AdvancedPaymentModule extends PaymentModule {
    public AdvancedPaymentModule() {
        super();
    }

    public void payment(Employee[] employees) {
        for (Employee employee : employees) {
            super.payment(employee);
        }
    }
}
