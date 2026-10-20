package lab3;

public class AdvancedPaymentModuleTest {
    public static void main(String[] args) {
        AdvancedPaymentModule module = new AdvancedPaymentModule();
        Employee[] employees = {
            new Fulltimer("Alice", 30000), new Hourly("Bob", 100, 20),
            new Manager("Carol", 1000, 10), new Manager("Dave", 1000, 11)
        };
        module.payment(employees);
        TestSupport.check(module.getTotalPay() == 64000, "Array payment and manager bonus");
        System.out.println("After array payment: " + module.getTotalPay());
        module.payment(new Fulltimer("Eve", 1000));
        TestSupport.check(module.getTotalPay() == 65000, "Inherited single payment");
        System.out.println("After single payment: " + module.getTotalPay());
        module.payment(new Employee[0]);
        TestSupport.check(module.getTotalPay() == 65000, "Empty array preserves total");
        module.payment(employees);
        TestSupport.check(module.getTotalPay() == 129000, "Repeated array accumulates");
        System.out.println("After repeated array: " + module.getTotalPay());
        System.out.println("AdvancedPaymentModuleTest passed (both overloads and accumulation).");
    }
}
