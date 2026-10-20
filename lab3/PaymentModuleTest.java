package lab3;

public class PaymentModuleTest {
    public static void main(String[] args) {
        PaymentModule module = new PaymentModule();
        TestSupport.check(module.getTotalPay() == 0, "Initial total");
        Employee[] employees = {
            new Employee(), new Fulltimer("Alice", 30000),
            new Hourly("Bob", 100, 20), new Manager("Carol", 1000, 10),
            new Manager("Dave", 1000, 11)
        };
        double[] expectedTotals = {0, 30000, 32000, 42000, 64000};
        for (int i = 0; i < employees.length; i++) {
            module.payment(employees[i]);
            TestSupport.check(module.getTotalPay() == expectedTotals[i], "Payment " + i);
            System.out.println(employees[i].getClass().getSimpleName()
                    + ": accumulated pay = " + module.getTotalPay());
        }
        System.out.println("PaymentModuleTest passed (all types and 10/11-year boundary).");
    }
}
