package lab4;

public class GradStudent extends PSUStudent {
    private boolean passThesis;

    public GradStudent(int age, double gpa) {
        super(age, gpa);
        passThesis = false;
    }

    public void setPassThesis(boolean passThesis) {
        this.passThesis = passThesis;
    }

    @Override
    public double revealGrade() {
        return passThesis ? gpa : 0.0d;
    }
}
