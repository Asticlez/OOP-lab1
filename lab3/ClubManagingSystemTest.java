package lab3;

public class ClubManagingSystemTest {
    public static void main(String[] args) {
        Club[] clubs = {
            new Club("Student", 10),
            new SportsClub("Football", 22),
            new ESportsClub("RoV", 1),
            new MarketingClub("Advertising", 2, 100)
        };
        clubs[0].addMember(190);
        clubs[1].addMember(18);
        clubs[2].addMember(4);
        clubs[3].addMember(8);
        ClubManagingSystem system = new ClubManagingSystem(clubs);
        TestSupport.check(system.getHighestMemberClub() == clubs[0], "Highest member club");
        TestSupport.check(system.determineAllBudget() == 257200, "Polymorphic budget sum");
        TestSupport.check(system.getAllMembers() == 255, "Total members");
        System.out.println("Highest member club: " + system.getHighestMemberClub().getName());
        System.out.println("Total budget: " + system.determineAllBudget());
        System.out.println("Total members: " + system.getAllMembers());
        ClubManagingSystem empty = new ClubManagingSystem(new Club[0]);
        TestSupport.check(empty.getHighestMemberClub() == null, "Empty highest club");
        TestSupport.check(empty.determineAllBudget() == 0 && empty.getAllMembers() == 0,
                "Empty totals");
        ClubManagingSystem tie = new ClubManagingSystem(new Club[] {
            new Club("First", 2), new Club("Second", 2)
        });
        TestSupport.check(tie.getHighestMemberClub().getName().equals("First"), "First wins tie");
        System.out.println("ClubManagingSystemTest passed (PDF data, empty list and ties).");
    }
}
