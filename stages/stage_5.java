import java.util.Scanner;

public class stage_5 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 5 ===");
        System.out.println("Welcome to Stage 5: Object-Oriented Programming!");
        System.out.println("This stage focuses on classes, objects, inheritance, and interfaces.");
        System.out.println("Think about object interactions and method calls!\n");

        // Question 1: Constructor and field access
        question1();

        // Question 2: Interface implementation
        question2();

        // Question 3: Method overriding and inheritance
        question3();

        // Question 4: Object comparison and equals
        question4();

        // Question 5: Dynamic array operations
        question5();

        // Show final results
        showFinalResults();
    }

    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1: Constructor and Field Access");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public class Point {");
        System.out.println("    private double x;");
        System.out.println("    private double y;");
        System.out.println("    public Point(double x, double y){");
        System.out.println("        this.x = x;");
        System.out.println("        this.y = y;");
        System.out.println("    }");
        System.out.println("    public Point(){");
        System.out.println("        this(0,0);");
        System.out.println("    }");
        System.out.println("    public double getX(){ return this.x; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Point p = new Point();");
        System.out.println("System.out.println(p.getX());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Point.java logic
        TestPoint p = new TestPoint();
        double result = p.getX();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: The default constructor Point() calls this(0,0), which sets x=0 and y=0. So getX() returns 0.0.");
    }

    // Helper class for Point simulation
    static class TestPoint {
        private double x;
        private double y;

        public TestPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public TestPoint() {
            this(0, 0);
        }

        public double getX() {
            return this.x;
        }
    }

    private static void question2() {
        totalQuestions++;
        System.out.println("\nQUESTION 2: Interface Implementation");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("interface Shape {");
        System.out.println("    public String name();");
        System.out.println("    public double area();");
        System.out.println("}");
        System.out.println("class Rectangle implements Shape {");
        System.out.println("    private double height = 4.0;");
        System.out.println("    private double width = 3.0;");
        System.out.println("    public String name() { return \"Rectangle\"; }");
        System.out.println("    public double area() { return height * width; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Shape s = new Rectangle();");
        System.out.println("System.out.println(s.area());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Rectangle.java logic
        TestShape s = new TestRectangle();
        double result = s.area();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Rectangle implements Shape interface. area() method returns height * width = 4.0 * 3.0 = 12.0.");
    }

    // Helper interface and class for Shape simulation
    interface TestShape {
        public String name();

        public double area();
    }

    static class TestRectangle implements TestShape {
        private double height = 4.0;
        private double width = 3.0;

        public String name() {
            return "Rectangle";
        }

        public double area() {
            return height * width;
        }
    }

    private static void question3() {
        totalQuestions++;
        System.out.println("\nQUESTION 3: Constructor Chaining");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public class Student {");
        System.out.println("    private String fullName;");
        System.out.println("    private String ID;");
        System.out.println("    private double avgGrade;");
        System.out.println("    public Student(String fullName, String ID, double avgGrade) {");
        System.out.println("        this.fullName = fullName;");
        System.out.println("        this.ID = ID;");
        System.out.println("        this.avgGrade = avgGrade;");
        System.out.println("    }");
        System.out.println("    public Student(String fullName, String ID) {");
        System.out.println("        this(fullName, ID, 0.0);");
        System.out.println("    }");
        System.out.println("    public double getAvgGrade() { return this.avgGrade; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Student s = new Student(\"John\", \"123\");");
        System.out.println("System.out.println(s.getAvgGrade());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Student.java logic
        TestStudent s = new TestStudent("John", "123");
        double result = s.getAvgGrade();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: The 2-parameter constructor calls this(fullName, ID, 0.0), setting avgGrade to 0.0. So getAvgGrade() returns 0.0.");
    }

    // Helper class for Student simulation
    static class TestStudent {
        private String fullName;
        private String ID;
        private double avgGrade;

        public TestStudent(String fullName, String ID, double avgGrade) {
            this.fullName = fullName;
            this.ID = ID;
            this.avgGrade = avgGrade;
        }

        public TestStudent(String fullName, String ID) {
            this(fullName, ID, 0.0);
        }

        public double getAvgGrade() {
            return this.avgGrade;
        }
    }

    private static void question4() {
        totalQuestions++;
        System.out.println("\nQUESTION 4: Object Equality and instanceof");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public boolean equals(Object other) {");
        System.out.println("    boolean res = false;");
        System.out.println("    if(other instanceof Rectangle){");
        System.out.println("        Rectangle otherRec = (Rectangle) other;");
        System.out.println("        res = (this.height == otherRec.height &&");
        System.out.println("               this.width == otherRec.width);");
        System.out.println("    }");
        System.out.println("    return res;");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Rectangle r1 = new Rectangle(5.0, 3.0);");
        System.out.println("Rectangle r2 = new Rectangle(5.0, 3.0);");
        System.out.println("System.out.println(r1.equals(r2));");
        System.out.println("---");

        System.out.print("Your guess (true/false): ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Rectangle.java logic
        TestRectangle2 r1 = new TestRectangle2(5.0, 3.0);
        TestRectangle2 r2 = new TestRectangle2(5.0, 3.0);
        boolean result = r1.equals(r2);
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: r2 is instanceof Rectangle, so it gets cast. Both rectangles have height=5.0 and width=3.0, so equals returns true.");
    }

    // Helper class for Rectangle equality simulation
    static class TestRectangle2 {
        private double height;
        private double width;

        public TestRectangle2(double height, double width) {
            this.height = height;
            this.width = width;
        }

        public boolean equals(Object other) {
            boolean res = false;
            if (other instanceof TestRectangle2) {
                TestRectangle2 otherRec = (TestRectangle2) other;
                res = (this.height == otherRec.height && this.width == otherRec.width);
            }
            return res;
        }
    }

    private static void question5() {
        totalQuestions++;
        System.out.println("\nQUESTION 5: Dynamic Array Operations");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public class DynamicArray {");
        System.out.println("    private Object[] data = new Object[16];");
        System.out.println("    private int size = 0;");
        System.out.println("    public void add(Object element){");
        System.out.println("        data[size] = element;");
        System.out.println("        size = size + 1;");
        System.out.println("    }");
        System.out.println("    public int size(){ return size; }");
        System.out.println("    public Object get(int index){ return data[index]; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("DynamicArray arr = new DynamicArray();");
        System.out.println("arr.add(\"Hello\");");
        System.out.println("arr.add(\"World\");");
        System.out.println("System.out.println(arr.size());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from DynamicArray.java logic
        TestDynamicArray arr = new TestDynamicArray();
        arr.add("Hello");
        arr.add("World");
        int result = arr.size();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Two elements are added to the dynamic array. Each add() increments size, so after adding \"Hello\" and \"World\", size() returns 2.");
    }

    // Helper class for DynamicArray simulation
    static class TestDynamicArray {
        private Object[] data = new Object[16];
        private int size = 0;

        public void add(Object element) {
            data[size] = element;
            size = size + 1;
        }

        public int size() {
            return size;
        }

        public Object get(int index) {
            return data[index];
        }
    }

    private static void checkAnswer(String userGuess, String actualOutput, String explanation) {
        System.out.println("\nActual output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Excellent object-oriented understanding!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showFinalResults() {
        System.out.println("\n=== STAGE 5 COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("🎉 Outstanding! You have mastered object-oriented programming!");
        } else if (percentage >= 60) {
            System.out.println("👍 Great work! You're developing strong OOP skills!");
        } else {
            System.out.println(
                    "🤔 Keep practicing! OOP concepts take time to master - they're a fundamental shift in thinking!");
        }

        System.out.println("\nKey concepts covered in Stage 5:");
        System.out.println("• Class constructors and constructor chaining");
        System.out.println("• Private fields and public methods (encapsulation)");
        System.out.println("• Interface implementation and polymorphism");
        System.out.println("• Object equality and instanceof operator");
        System.out.println("• Dynamic data structures and object collections");
        System.out.println("• Method overriding and object-oriented design");

        System.out.println("\nObject-Oriented Debugging Tips:");
        System.out.println("• Trace constructor calls and field initialization");
        System.out.println("• Understand the difference between this() and super()");
        System.out.println("• Remember that interface references can hold implementing objects");
        System.out.println("• Pay attention to instanceof checks before casting");
        System.out.println("• Follow object state changes through method calls");

        System.out.println("\nThese concepts are from your OOP folder!");
        System.out.println("Explore: Point.java, Rectangle.java, Student.java, DynamicArray.java, Shape.java");
        System.out.println("\nCongratulations on mastering the complete Java progression!");
        System.out.println("You've conquered: Basic Java → Algorithms → Functions → Recursion → OOP!");
        System.out.println("\nYou're now ready for advanced Java development! 🚀");
    }
}
