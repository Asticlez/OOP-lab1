# OOP Lab 3

This lab covers class hierarchy, subtype polymorphism, safe downcasting, and method overloading. The Java files are in this folder and use `package lab3`.

- Q1: `ESportsClub` extends `SportsClub`, starts with one member, and prints `No need to advertise`. Both the class and its advertising method are final.
- Q2: `ClubManagingSystem` manages a `Club[]` and finds total budgets, total members, and the club with the most members.
- Q3: `PaymentModule` accumulates employee payments. Managers with more than 10 years receive twice their computed pay.
- Q4: `AdvancedPaymentModule` overloads `payment` for an `Employee[]`, calling `super.payment` for each employee.

## How to run

With JDK 17 installed, open a terminal in the repository root and run:

```powershell
javac -d out lab3/*.java
java -cp out lab3.ESportsClubTest
java -cp out lab3.ClubManagingSystemTest
java -cp out lab3.PaymentModuleTest
java -cp out lab3.AdvancedPaymentModuleTest
```

Tests use the same `TestSupport.check` style as Lab 2. Checks run without Java's `-ea` option. Actual console output is saved in `output/*.txt`; images rendered from that output are saved in `output/*.png`. Desktop screen capture is unavailable in this environment. For literal screenshots required by the PDF, run the commands above in your terminal and capture each result before submission.

## Results and explanations

### Q1

Both `ESportsClub e = new ESportsClub("Esport", 100)` and `Club c = new ESportsClub("Esport", 100)` have name `Esport`, minimum members 1, and current members 1. The constructor calls `super(c, 1)`, so both member counts start at 1. `advertise()` prints `No need to advertise`, `determineBudget()` returns 1000, and `getName()` returns `Esport`.

An ESportsClub is also a SportsClub and a Club, so the assignment to a Club reference is a valid upcast. Overridden instance methods are selected using the object's runtime type. The tests also check that the name cannot change and that adding four members gives a budget of 5400.

### Q2

| Club | Members | Minimum | Determined budget |
|---|---:|---:|---:|
| Student | 200 | 10 | 200000 |
| Football | 40 | 22 | 41800 |
| RoV | 5 | 1 | 5400 |
| Advertising | 10 | 2 | 10000 |

The highest member club is Student, total budget is 257200, and total members are 255. Constructors start at the minimum; `addMember` adds the difference to reach the PDF's current member counts.

The array stores different Club subclasses through Club references. Each call to `determineBudget()` runs the appropriate implementation without checking the club's type. A public member getter in Club supports all club types; SportsClub explicitly exposes the getter requested in Q1. Empty systems return zero totals and null for the highest club; ties return the first club.

### Q3

The test pays an Employee, a Fulltimer (30000), an Hourly employee (100 x 20), a Manager with 10 years (1000 x 10), and a Manager with 11 years (1000 x 11 x 2). The accumulated total is 64000.

`instanceof Manager` guards the downcast. `getWorkYear()` exposes the required value while keeping the field private. The bonus applies after `Manager.computePay()`, which already multiplies salary by work years. Exactly 10 years does not qualify. The module starts with zero total pay.

### Q4

The array payment produces 64000. An inherited single payment of 1000 brings it to 65000; an empty array leaves it unchanged. Paying the array again brings it to 129000. The overload reuses `super.payment(employee)`, so the manager rule is implemented only once.

## Submission

Keep this entire `lab3` folder, including Java files and output screenshots, in GitHub. Submit the repository link in LMS under **Lab 3: Polymorphism**. Compiled classes belong in the ignored `out` folder.
