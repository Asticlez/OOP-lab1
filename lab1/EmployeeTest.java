public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee("Alex", "Lee");
        printDetails(employee);
        assert employee.getMonthlySalary() == 0;

        employee.setFirstName("Sam");
        employee.setLastName("Chen");
        employee.setMonthlySalary(3000);
        printDetails(employee);
        assert employee.getFirstName().equals("Sam");
        assert employee.getLastName().equals("Chen");
        assert employee.getMonthlySalary() == 3000;

        employee.setMonthlySalary(0);
        assert employee.getMonthlySalary() == 3000;
        employee.setMonthlySalary(-100);
        assert employee.getMonthlySalary() == 3000;
        assert new Employee("Pat", "Kim", -100).getMonthlySalary() == 0;

        Employee first = new Employee("Oak", "Wong", 2000);
        Employee second = new Employee("Two", "Tan", 4000);
        System.out.println("Before 10% raise:");
        printYearlySalary(first);
        printYearlySalary(second);
        assert first.getYearlySalary() == 24000;
        assert second.getYearlySalary() == 48000;

        first.giveRaise();
        second.giveRaise();
        System.out.println("After 10% raise:");
        printYearlySalary(first);
        printYearlySalary(second);
        assert Math.abs(first.getYearlySalary() - 26400) < 0.000001;
        assert Math.abs(second.getYearlySalary() - 52800) < 0.000001;
        System.out.println("Employee tests completed.");
    }

    private static void printDetails(Employee employee) {
        System.out.printf("%s %s: monthly salary %.2f%n",
                employee.getFirstName(), employee.getLastName(), employee.getMonthlySalary());
    }

    private static void printYearlySalary(Employee employee) {
        System.out.printf("%s %s: yearly salary %.2f%n",
                employee.getFirstName(), employee.getLastName(), employee.getYearlySalary());
    }
}
