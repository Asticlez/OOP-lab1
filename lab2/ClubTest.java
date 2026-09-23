package lab2;

public class ClubTest {
    public static void main(String[] args) {
        Club base = new Club("Reading", 2);
        TestSupport.check(base.determineBudget() == 2000, "Base initial budget");
        base.addMember(1);
        base.changeName("Books");
        TestSupport.check(base.determineBudget() == 3000, "Base member budget");
        TestSupport.check(base.getName().equals("Books"), "Base name change");

        // Calling overridden methods through Club demonstrates polymorphism.
        Club sports = new SportsClub("Football", 10);
        TestSupport.check(sports.determineBudget() == 10000, "Initial sports budget");
        sports.addMember(3);
        TestSupport.check(sports.determineBudget() == 13300, "Sports member bonus");
        sports.changeName("Basketball");
        TestSupport.check(sports.getName().equals("Football"), "Sports name stays unchanged");
        sports.advertise();

        MarketingClub marketing = new MarketingClub("Marketing", 5, 1500);
        TestSupport.check(marketing.determineBudget() == 0, "Budget above 1000");
        TestSupport.check(!marketing.useBudget(1501), "Overspending must fail");
        TestSupport.check(marketing.useBudget(499), "Valid deduction");
        TestSupport.check(marketing.determineBudget() == 0, "Boundary: remaining 1001");
        TestSupport.check(marketing.useBudget(1), "Deduct to boundary");
        TestSupport.check(marketing.determineBudget() == 5000, "Boundary: remaining 1000");
        marketing.addMember(2);
        TestSupport.check(marketing.determineBudget() == 7000, "Inherited member behavior");
        TestSupport.check(marketing.useBudget(1), "Deduct below boundary");
        TestSupport.check(marketing.determineBudget() == 7000, "Boundary: remaining 999");
        TestSupport.check(!marketing.useBudget(1000), "Failed deduction preserves 999");
        TestSupport.check(marketing.useBudget(999), "Exact balance may be spent");
        TestSupport.check(!marketing.useBudget(1), "Cannot spend from zero");
        TestSupport.check(marketing.useBudget(0), "Zero deduction succeeds");
        marketing.changeName("Creative Marketing");
        TestSupport.check(marketing.getName().equals("Creative Marketing"),
                "Marketing allows name changes");
        marketing.advertise();
        System.out.println("ClubTest passed (names, budgets, deductions and boundaries).");
    }
}
