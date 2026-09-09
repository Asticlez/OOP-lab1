public class EmployeeTeam {
    private Employee boss;
    private Employee employee;

    public EmployeeTeam(Employee boss, Employee employee) {
        this.boss = boss;
        this.employee = employee;
    }

    private void printDetails(Employee person) {
        System.out.printf("%s %s: monthly salary %.2f%n",
                person.getFirstName(), person.getLastName(), person.getMonthlySalary());
    }

    public void printEmployeeDetails() {
        printDetails(employee);
    }

    public void printAllEmployeesDetails() {
        printDetails(boss);
        printEmployeeDetails();
    }

    public void updateSalaryOfEmployee(String firstname, double newSalary) {
        // Independent checks ensure both people are updated if their names match.
        if (boss.getFirstName().equals(firstname)) {
            boss.setMonthlySalary(newSalary);
        }
        if (employee.getFirstName().equals(firstname)) {
            employee.setMonthlySalary(newSalary);
        }
    }

    public void giveRaiseToAllEmployees() {
        boss.giveRaise();
        employee.giveRaise();
    }
}
