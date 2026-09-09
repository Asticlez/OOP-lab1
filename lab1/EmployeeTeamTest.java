public class EmployeeTeamTest {
    public static void main(String[] args) {
        Employee boss = new Employee("Oak", "Wong", 5000);
        Employee employee = new Employee("Two", "Tan", 2000);
        EmployeeTeam team = new EmployeeTeam(boss, employee);

        System.out.println("Employee only:");
        team.printEmployeeDetails();
        System.out.println("Whole team:");
        team.printAllEmployeesDetails();

        team.updateSalaryOfEmployee(new String("Two"), 2500);
        assert employee.getMonthlySalary() == 2500;
        assert boss.getMonthlySalary() == 5000;
        team.updateSalaryOfEmployee("Oak", 6000);
        assert boss.getMonthlySalary() == 6000;
        assert employee.getMonthlySalary() == 2500;

        team.updateSalaryOfEmployee("Two", 0);
        team.updateSalaryOfEmployee("Oak", -100);
        team.updateSalaryOfEmployee("Unknown", 9000);
        assert employee.getMonthlySalary() == 2500;
        assert boss.getMonthlySalary() == 6000;

        team.giveRaiseToAllEmployees();
        System.out.println("After 10% raise:");
        team.printAllEmployeesDetails();
        assert Math.abs(boss.getMonthlySalary() - 6600) < 0.000001;
        assert Math.abs(employee.getMonthlySalary() - 2750) < 0.000001;

        employee.setFirstName("Oak");
        team.updateSalaryOfEmployee("Oak", 7000);
        assert boss.getMonthlySalary() == 7000;
        assert employee.getMonthlySalary() == 7000;
        System.out.println("After updating both matching first names:");
        team.printAllEmployeesDetails();
        System.out.println("EmployeeTeam tests completed.");
    }
}
