package lab4;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class StudentInputTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.println("Enter age:");
            int age = scanner.nextInt();
            System.out.println("Enter GPA:");
            double gpa = scanner.nextDouble();
            PSUStudent undergrad = new UndergradStudent(age, gpa);
            PSUStudent grad = new GradStudent(age, gpa);
            System.out.println("Created UndergradStudent: age = " + undergrad.getAge()
                    + ", revealed GPA = " + undergrad.revealGrade());
            System.out.println("Created GradStudent: age = " + grad.getAge()
                    + ", revealed GPA = " + grad.revealGrade());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input: enter an integer age and a numeric GPA");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Invalid input: both age and GPA are required");
        }
    }
}
