package lab3;

public class ESportsClubTest {
    public static void main(String[] args) {
        ESportsClub e = new ESportsClub("Esport", 100);
        Club c = new ESportsClub("Esport", 100);
        showClub(e);
        showClub(c);
        e.changeName("New name");
        TestSupport.check(e.getName().equals("Esport"), "Sports name stays unchanged");
        e.addMember(4);
        TestSupport.check(e.getNumMember() == 5, "Inherited addMember");
        TestSupport.check(e.determineBudget() == 5400, "Inherited sports bonus");
        System.out.println("ESportsClubTest passed (constructors, overriding and Club references).");
    }

    private static void showClub(Club club) {
        TestSupport.check(club.getName().equals("Esport"), "Initial name");
        TestSupport.check(club.getMinNumMember() == 1, "Minimum ignores input 100");
        TestSupport.check(club.getNumMember() == 1, "Initial members match minimum");
        TestSupport.check(club.determineBudget() == 1000, "Initial budget");
        System.out.println("Name: " + club.getName() + ", members: " + club.getNumMember()
                + ", minimum: " + club.getMinNumMember());
        club.advertise();
        System.out.println("Budget: " + club.determineBudget());
    }
}
