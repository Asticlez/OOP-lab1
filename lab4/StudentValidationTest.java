package lab4;

public class StudentValidationTest {
    public static void main(String[] args) {
        UndergradStudent undergrad = new UndergradStudent(0, 0);
        GradStudent grad = new GradStudent(25, 4);
        TestSupport.check(undergrad.revealGrade() == 0, "Initial undergraduate grade");
        TestSupport.check(grad.revealGrade() == 0, "Initial graduate grade");
        UndergradStudent student = new UndergradStudent(19, 3.5);
        student.setCurrentYear(3);
        TestSupport.check(student.revealGrade() == 0, "Year 3");
        student.setCurrentYear(4);
        TestSupport.check(student.revealGrade() == 3.5, "Year 4");
        student.setCurrentYear(5);
        TestSupport.check(student.revealGrade() == 3.5, "Year 5");
        grad.setPassThesis(true);
        TestSupport.check(grad.revealGrade() == 4, "Passed thesis");
        grad.setPassThesis(false);
        TestSupport.check(grad.revealGrade() == 0, "Thesis flag reset");
        PSUStudent[] students = {student, grad};
        for (PSUStudent s : students) {
            s.setAge(30);
            TestSupport.check(s.getAge() == 30, "Inherited age setter");
        }
        double[] invalidGrades = {-0.01, 4.01, Double.NaN,
            Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        for (boolean graduate : new boolean[] {false, true}) {
            reject(graduate, -1, 3);
            for (double gpa : invalidGrades) {
                reject(graduate, 20, gpa);
            }
            create(graduate, 0, 0);
            create(graduate, 0, 4);
        }
        System.out.println("StudentValidationTest passed (both subclasses, age/GPA boundaries,");
        System.out.println("NaN/infinity, year 3/4/5, thesis flag, inherited age methods).");
    }

    private static PSUStudent create(boolean graduate, int age, double gpa) {
        return graduate ? new GradStudent(age, gpa) : new UndergradStudent(age, gpa);
    }

    private static void reject(boolean graduate, int age, double gpa) {
        try {
            create(graduate, age, gpa);
            throw new AssertionError("Invalid student accepted");
        } catch (IllegalArgumentException expected) {
            TestSupport.check(expected.getMessage() != null, "Useful error message");
        }
    }
}
