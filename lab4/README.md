# OOP Lab 4: Abstraction

Java 17 solutions for all four questions, using `package lab4` and the same small `TestSupport.check` style as Lab 2 and Lab 3.

## How to run

Run from the repository root:

```powershell
javac -Xlint:all -d out lab4/*.java
java -cp out lab4.PSUStudentTest
java -cp out lab4.StudentInputTest
java -cp out lab4.StudentValidationTest
java -cp out lab4.TriangleTest
java -cp out lab4.TriangleManagerTest
```

For Q2, enter an integer age and then a GPA, for example `19` and `3.5`. Repeat with `-1` and `3.5`, or `19` and `4.1`, to see the constructor error messages. Non-numeric or missing input also produces a readable error.

## Q1: Abstract class and method

`PSUStudent` stores age and GPA once, provides inherited age methods, and declares abstract `revealGrade()`. Both subclass constructors call `super(age, gpa)`. Undergraduates start in year 1 and reveal their GPA from year 4 onward. Graduates start with `passThesis = false` and reveal their GPA only after passing their thesis.

The PDF's sample has two calls that do not compile: `p1.setCurrentYear(4)` and `p2.setPassThesis(true)`. Their declared type is `PSUStudent`, which does not declare either setter. `PSUStudentTest` retains those parent references and casts them to the known subclass for the two calls. The casts are safe here because each object is created immediately above with that exact type. `revealGrade()` still demonstrates runtime polymorphism through the parent reference.

Expected and verified output:

```text
19
0.0
1.32
25
0.0
2.0
```

## Q2: Exceptions and input validation

Constructor validation is shared in `PSUStudent`, so both subclasses reject negative ages and GPA values outside the inclusive range 0.0 to 4.0. NaN and infinity are also rejected. Age 0 and GPA 0.0 or 4.0 are accepted. Q2 extends the Q1 classes directly.

`StudentInputTest` reads values using `Scanner`, constructs both types for valid input, and catches `IllegalArgumentException` to print its message. An invalid first construction transfers control directly to the catch block; `StudentValidationTest` independently checks invalid constructors for both subclasses. A newly created student's revealed GPA remains 0.0 because neither release condition has been met.

Validation checks also cover year 3/4/5, resetting the thesis flag, and inherited age getters/setters. Constructor validation follows Q2; `setAge` is the ordinary setter requested in Q1.

## Q3: Interface

`Triangle` declares three methods returning `double`. `EquilateralTriangle` and `RightTriangle` implement all three. The demonstration stores both objects in a `Triangle[]` and calls their methods through the interface.

| Triangle | Longest side | Perimeter | Largest angle |
|---|---:|---:|---:|
| Equilateral, side 5 | 5.0 | 15.0 | 60.0 |
| Right, sides 3, 4, 5 | 5.0 | 12.0 | 90.0 |

Side values are stored as specified; the lab does not request geometric input validation. Tests also put the longest side in different constructor positions.

## Q4: Interface with polymorphism and exceptions

`TriangleManager` declares its collection as `List<Triangle>` and chooses `ArrayList` for `true` or `LinkedList` for `false`. The same iteration works for either implementation and compares perimeters through the interface. It returns the original triangle object, chooses the first object in a tie, and returns `null` for an empty list (the PDF does not specify empty-list behavior).

Both list choices are tested for empty and single-element lists, mixed triangle types, tied maximum perimeters, and null rejection. Adding null throws `IllegalArgumentException` with exactly `Triangle cannot be null` and leaves the list unchanged.

## Output and submission

`output/Screenshot*.png` contains terminal screenshots for Q1 through Q4, captured by the student. The Q2 screenshot shows negative-age rejection and valid GPA 4.0 input. `output/*.txt` contains additional captured Java output, including invalid GPA input. The `q*.png` files are images rendered from those text files, following the Lab 3 approach; they are not desktop screenshots. Regenerate only the rendered images with:

```powershell
powershell -ExecutionPolicy Bypass -File lab4/RenderOutput.ps1
```

Q2's saved text runs use piped input; filenames identify valid input, negative age, GPA above 4, and non-numeric input.

The PDF asks for Java files and output screenshots under `lab4`, a GitHub push, and submission of the repository link under Assignment 4 in LMS. Submit the repository link in LMS after pushing. Compiled files and the PDF extraction tool remain in the ignored `out` directory.
