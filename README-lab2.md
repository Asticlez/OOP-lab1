# OOP Lab 2

This lab covers enums, encapsulation, and inheritance. The Java files are in `lab2`.

- Q1: A card has a rank and suit. `CardUtil` checks if it is the ace of spades.
- Q2: Football and basketball players share a `Player` class. Each game adds 90 or 48 minutes. Basketball players can also change their jersey number.
- Q3: Sports and marketing clubs extend `Club`. Sports clubs keep their name and get a bonus for extra members. Marketing clubs can spend their budget if enough is left.
- Q4: `Child` and `Parent` extend `Person`. `Father` and `Mother` extend `Parent` and add `Mr.` or `Ms.` before their first name.

## How to run

With a JDK installed, open a terminal in this folder and run:

```powershell
javac -d out lab2/*.java
java -cp out lab2.CardUtilTest
java -cp out lab2.PlayerTest
java -cp out lab2.PlayerBehaviorTest
java -cp out lab2.ClubTest
java -cp out lab2.PersonTest
```

`PlayerTest` runs the example from the PDF. The other tests check things like repeated games, invalid cards, club budgets, and family relationships. Tested with Java 17.

## A few notes about Q4

- The diagram says `getWife(): Wife`, but it only defines `Mother`, so `getWife()` returns `Mother`.
- Father and Mother start with 0 money because their constructors have no money argument.
- Names start empty. Guardian, child, and spouse references start as `null` unless supplied. Creating a Father stores his wife but does not set her husband field.
- A few extra getters let the tests check the child's age, height, and weight, and the parent's money.
