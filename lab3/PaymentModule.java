package lab3;

public class PaymentModule {
    private double totalPay;

    public PaymentModule() {
        totalPay = 0;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void payment(Employee employee) {
        double pay = employee.computePay();
        // Check the runtime type before downcasting.
        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            if (manager.getWorkYear() > 10) {
                pay *= 2;
            }
        }
        totalPay += pay;
    }
}
