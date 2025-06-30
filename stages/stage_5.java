import java.util.Scanner;
import java.util.function.Supplier;

public class stage_5 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 5 ===");
        System.out.println("Welcome to Stage 5: Object-Oriented Programming!");
        System.out.println("This stage focuses on classes, objects, inheritance, and interfaces.");
        System.out.println("Think about object interactions and method calls!\n");

        // Execute all questions using the reusable Question class
        executeQuestion(createQuestion1());
        executeQuestion(createQuestion2());
        executeQuestion(createQuestion3());
        executeQuestion(createQuestion4());
        executeQuestion(createQuestion5());
        executeQuestion(createQuestion6());
        executeQuestion(createQuestion7());
        executeQuestion(createQuestion8());
        executeQuestion(createQuestion9());
        executeQuestion(createQuestion10());
        executeQuestion(createQuestion11());
        executeQuestion(createQuestion12());

        // Show final results
        showFinalResults();
    }

    private static void executeQuestion(Question question) {
        totalQuestions++;
        question.execute(scanner, totalQuestions);
        if (question.wasCorrect()) {
            score++;
        }
    }

    private static Question createQuestion1() {
        String[] code = {
                "public class Point {",
                "    private double x;",
                "    private double y;",
                "    public Point(double x, double y){",
                "        this.x = x;",
                "        this.y = y;",
                "    }",
                "    public Point(){",
                "        this(0,0);",
                "    }",
                "    public double getX(){ return this.x; }",
                "}",
                "// Usage:",
                "Point p = new Point();",
                "System.out.println(p.getX());"
        };

        Supplier<String> execution = () -> {
            TestPoint p = new TestPoint();
            return String.valueOf(p.getX());
        };

        String explanation = "Explanation: The default constructor Point() calls this(0,0), which sets x=0 and y=0. So getX() returns 0.0.";

        return new Question("Constructor and Field Access", code, execution, explanation);
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

    private static Question createQuestion2() {
        String[] code = {
                "interface Shape {",
                "    public String name();",
                "    public double area();",
                "}",
                "class Rectangle implements Shape {",
                "    private double height = 4.0;",
                "    private double width = 3.0;",
                "    public String name() { return \"Rectangle\"; }",
                "    public double area() { return height * width; }",
                "}",
                "// Usage:",
                "Shape s = new Rectangle();",
                "System.out.println(s.area());"
        };

        Supplier<String> execution = () -> {
            TestShape s = new TestRectangle();
            return String.valueOf(s.area());
        };

        String explanation = "Explanation: Rectangle implements Shape interface. area() method returns height * width = 4.0 * 3.0 = 12.0.";

        return new Question("Interface Implementation", code, execution, explanation);
    }

    // Additional helper classes for questions 9-12
    interface TestShape {
        String name();

        double area();
    }

    static class TestRectangle implements TestShape {
        protected double height = 4.0;
        protected double width = 3.0;

        public TestRectangle() {
        }

        public TestRectangle(double h, double w) {
            height = h;
            width = w;
        }

        public String name() {
            return "Rectangle";
        }

        public double area() {
            return height * width;
        }

        public String toString() {
            return name() + ", h=" + height + ", w=" + width;
        }
    }

    static class TestSquare extends TestRectangle {
        public TestSquare(double side) {
            super(side, side);
        }

        public String name() {
            return "Square";
        }

        public String toString() {
            return "Square, side=" + width;
        }
    }

    private static Question createQuestion3() {
        String[] code = {
                "public class Student {",
                "    private String fullName;",
                "    private String ID;",
                "    private double avgGrade;",
                "    public Student(String fullName, String ID, double avgGrade) {",
                "        this.fullName = fullName;",
                "        this.ID = ID;",
                "        this.avgGrade = avgGrade;",
                "    }",
                "    public Student(String fullName, String ID) {",
                "        this(fullName, ID, 0.0);",
                "    }",
                "    public double getAvgGrade() { return this.avgGrade; }",
                "}",
                "// Usage:",
                "Student s = new Student(\"John\", \"123\");",
                "System.out.println(s.getAvgGrade());"
        };

        Supplier<String> execution = () -> {
            TestStudent s = new TestStudent("John", "123");
            return String.valueOf(s.getAvgGrade());
        };

        String explanation = "Explanation: The 2-parameter constructor calls this(fullName, ID, 0.0), setting avgGrade to 0.0. So getAvgGrade() returns 0.0.";

        return new Question("Constructor Chaining", code, execution, explanation);
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

    private static Question createQuestion4() {
        String[] code = {
                "public boolean equals(Object other) {",
                "    boolean res = false;",
                "    if(other instanceof Rectangle){",
                "        Rectangle otherRec = (Rectangle) other;",
                "        res = (this.height == otherRec.height &&",
                "               this.width == otherRec.width);",
                "    }",
                "    return res;",
                "}",
                "// Usage:",
                "Rectangle r1 = new Rectangle(5.0, 3.0);",
                "Rectangle r2 = new Rectangle(5.0, 3.0);",
                "System.out.println(r1.equals(r2));"
        };

        Supplier<String> execution = () -> {
            TestRectangle2 r1 = new TestRectangle2(5.0, 3.0);
            TestRectangle2 r2 = new TestRectangle2(5.0, 3.0);
            return String.valueOf(r1.equals(r2));
        };

        String explanation = "Explanation: r2 is instanceof Rectangle, so it gets cast. Both rectangles have height=5.0 and width=3.0, so equals returns true.";

        return new Question("Object Equality and instanceof", code, execution, explanation, "Your guess (true/false): ");
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

    private static Question createQuestion5() {
        String[] code = {
                "public class DynamicArray {",
                "    private Object[] data = new Object[16];",
                "    private int size = 0;",
                "    public void add(Object element){",
                "        data[size] = element;",
                "        size = size + 1;",
                "    }",
                "    public int size(){ return size; }",
                "    public Object get(int index){ return data[index]; }",
                "}",
                "// Usage:",
                "DynamicArray arr = new DynamicArray();",
                "arr.add(\"Hello\");",
                "arr.add(\"World\");",
                "System.out.println(arr.size());"
        };

        Supplier<String> execution = () -> {
            TestDynamicArray arr = new TestDynamicArray();
            arr.add("Hello");
            arr.add("World");
            return String.valueOf(arr.size());
        };

        String explanation = "Explanation: Two elements are added to the dynamic array. Each add() increments size, so after adding \"Hello\" and \"World\", size() returns 2.";

        return new Question("Dynamic Array Operations", code, execution, explanation);
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

    private static Question createQuestion6() {
        String[] code = {
                "class Record<V> {",
                "    private String key;",
                "    private V value;",
                "    public Record(String key, V value) {",
                "        this.key = key; this.value = value;",
                "    }",
                "    public String getKey() { return key; }",
                "    public V getValue() { return value; }",
                "}",
                "class ContactPerson extends Record<String> {",
                "    private String contactType;",
                "    public ContactPerson(String name, String phone, String type) {",
                "        super(name, phone);",
                "        this.contactType = type;",
                "    }",
                "    public String getContactType() { return contactType; }",
                "}",
                "// Usage:",
                "ContactPerson cp = new ContactPerson(\"John\", \"123-456\", \"Friend\");",
                "System.out.println(cp.getValue());"
        };

        Supplier<String> execution = () -> {
            TestContactPerson cp = new TestContactPerson("John", "123-456", "Friend");
            return cp.getValue();
        };

        String explanation = "Explanation: ContactPerson extends Record<String>. super(name, phone) calls Record constructor with key=\"John\", value=\"123-456\". getValue() returns \"123-456\".";

        return new Question("Inheritance and Super Constructor", code, execution, explanation);
    }

    // Helper classes for inheritance simulation
    static class TestRecord<V> {
        private String key;
        private V value;

        public TestRecord(String key, V value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static class TestContactPerson extends TestRecord<String> {
        private String contactType;

        public TestContactPerson(String name, String phone, String type) {
            super(name, phone);
            this.contactType = type;
        }

        public String getContactType() {
            return contactType;
        }
    }

    private static Question createQuestion7() {
        String[] code = {
                "class Record<V> {",
                "    private String key;",
                "    private V value;",
                "    public Record(String key, V value) {",
                "        this.key = key; this.value = value;",
                "    }",
                "    public String toString() {",
                "        return \"[\" + key + \", \" + value + \"]\";",
                "    }",
                "    public boolean equals(Object other) {",
                "        if (other instanceof Record) {",
                "            Record<?> otherRecord = (Record<?>) other;",
                "            return key.equals(otherRecord.key);",
                "        }",
                "        return false;",
                "    }",
                "}",
                "// Usage:",
                "Record<Integer> r1 = new Record<>(\"age\", 25);",
                "Record<String> r2 = new Record<>(\"age\", \"25\");",
                "System.out.println(r1.equals(r2));"
        };

        Supplier<String> execution = () -> {
            TestRecord2<Integer> r1 = new TestRecord2<>("age", 25);
            TestRecord2<String> r2 = new TestRecord2<>("age", "25");
            return String.valueOf(r1.equals(r2));
        };

        String explanation = "Explanation: Both records have key=\"age\". The equals method only compares keys, ignoring the generic value types. So r1.equals(r2) returns true.";

        return new Question("Generic Classes with Type Bounds", code, execution, explanation, "Your guess (true/false): ");
    }

    // Helper class for generic comparison simulation
    static class TestRecord2<V> {
        private String key;
        private V value;

        public TestRecord2(String key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "[" + key + ", " + value + "]";
        }

        public boolean equals(Object other) {
            if (other instanceof TestRecord2) {
                TestRecord2<?> otherRecord = (TestRecord2<?>) other;
                return key.equals(otherRecord.key);
            }
            return false;
        }
    }

    private static Question createQuestion8() {
        String[] code = {
                "class PhoneNumber {",
                "    private String phoneNumber;",
                "    public PhoneNumber(String phoneNumber) {",
                "        if (!isLegal(phoneNumber))",
                "            throw new IllegalArgumentException(\"Invalid phone\");",
                "        this.phoneNumber = phoneNumber;",
                "    }",
                "    private boolean isLegal(String phone) {",
                "        return phone != null && phone.length() == 9 && phone.charAt(0) == '0';",
                "    }",
                "    public String toString() { return phoneNumber; }",
                "}",
                "// Usage:",
                "try {",
                "    PhoneNumber p1 = new PhoneNumber(\"012345678\");",
                "    PhoneNumber p2 = new PhoneNumber(\"123456789\");",
                "    System.out.println(\"Success\");",
                "} catch (IllegalArgumentException e) {",
                "    System.out.println(\"Error\");",
                "}"
        };

        Supplier<String> execution = () -> {
            try {
                TestPhoneNumber p1 = new TestPhoneNumber("012345678");
                TestPhoneNumber p2 = new TestPhoneNumber("123456789");
                return "Success";
            } catch (IllegalArgumentException e) {
                return "Error";
            }
        };

        String explanation = "Explanation: First phone number \"012345678\" is valid (length 9, starts with '0'). Second \"123456789\" is invalid (doesn't start with '0'), so exception is thrown and \"Error\" is printed.";

        return new Question("Input Validation and Encapsulation", code, execution, explanation);
    }

    // Helper class for phone number validation simulation
    static class TestPhoneNumber {
        private String phoneNumber;

        public TestPhoneNumber(String phoneNumber) {
            if (!isLegal(phoneNumber))
                throw new IllegalArgumentException("Invalid phone");
            this.phoneNumber = phoneNumber;
        }

        private boolean isLegal(String phone) {
            return phone != null && phone.length() == 9 && phone.charAt(0) == '0';
        }

        public String toString() {
            return phoneNumber;
        }
    }


    private static Question createQuestion9() {
        String[] code = {
                "interface Shape {",
                "    String name();",
                "    double area();",
                "}",
                "class Rectangle implements Shape {",
                "    private double height = 4.0;",
                "    private double width = 3.0;",
                "    public String name() { return \"Rectangle\"; }",
                "    public double area() { return height * width; }",
                "}",
                "Shape s = new Rectangle();",
                "System.out.println(s.name() + \": \" + s.area());"
        };

        Supplier<String> execution = () -> {
            TestShape s = new TestRectangle();
            return s.name() + ": " + s.area();
        };

        String explanation = "EXPLANATION: The Rectangle class implements the Shape interface. An interface reference (Shape s) can hold objects of implementing classes. When s.name() is called, it executes Rectangle's implementation. When s.area() is called, it calculates 4.0 * 3.0 = 12.0. This demonstrates polymorphism - same interface, different implementations.";

        return new Question("Interface Implementation with Shapes", code, execution, explanation, "Your answer: ");
    }
    private static Question createQuestion10() {
        String[] code = {
                "class Rectangle implements Shape {",
                "    private double height, width;",
                "    public Rectangle(double h, double w) { height = h; width = w; }",
                "    public String name() { return \"Rectangle\"; }",
                "    public double area() { return height * width; }",
                "    public String toString() { return name() + \", h=\" + height + \", w=\" + width; }",
                "}",
                "class Square extends Rectangle {",
                "    public Square(double side) { super(side, side); }",
                "    public String name() { return \"Square\"; }",
                "    public String toString() { return \"Square, side=\" + width; }",
                "}",
                "Rectangle r = new Square(5.0);",
                "System.out.println(r.toString() + \", area=\" + r.area());"
        };

        Supplier<String> execution = () -> {
            TestRectangle r = new TestSquare(5.0);
            return r.toString() + ", area=" + r.area();
        };

        String explanation = "EXPLANATION: Square extends Rectangle and calls super(side, side) in constructor. Rectangle reference r holds a Square object (polymorphism). r.toString() calls Square's overridden toString() method (dynamic dispatch). r.area() calls Rectangle's area() method (inherited, not overridden). The area calculation uses inherited height * width = 5.0 * 5.0 = 25.0.";

        return new Question("Inheritance Hierarchy (Rectangle and Square)", code, execution, explanation, "Your answer: ");
    }

    private static Question createQuestion11() {
        String[] code = {
                "class OrderedPair<T1, T2> {",
                "    private final T1 first;",
                "    private final T2 second;",
                "    public OrderedPair(T1 first, T2 second) {",
                "        this.first = first; this.second = second;",
                "    }",
                "    public String toString() {",
                "        return \"(\" + first + \", \" + second + \")\";",
                "    }",
                "}",
                "OrderedPair<String, Integer> pair1 = new OrderedPair<>(\"Score\", 95);",
                "OrderedPair<Double, String> pair2 = new OrderedPair<>(3.14, \"Pi\");",
                "System.out.println(pair1 + \" - \" + pair2);"
        };

        Supplier<String> execution = () -> {
            TestOrderedPair<String, Integer> pair1 = new TestOrderedPair<>("Score", 95);
            TestOrderedPair<Double, String> pair2 = new TestOrderedPair<>(3.14, "Pi");
            return pair1 + " - " + pair2;
        };

        String explanation = "EXPLANATION: Generic classes allow type parameters (<T1, T2>) for type safety. OrderedPair<String, Integer> creates a pair with String first, Integer second. OrderedPair<Double, String> creates a pair with Double first, String second. toString() is called implicitly when objects are concatenated with strings. The diamond operator <> infers types from the declaration.";

        return new Question("Generic Classes with Complex Types", code, execution, explanation, "Your answer: ");
    }

    private static Question createQuestion12() {
        String[] code = {
                "class Student {",
                "    private String name;",
                "    private final String ID;",
                "    private double avgGrade;",
                "    public Student(String name, String ID, double avgGrade) {",
                "        this.name = name; this.ID = ID; this.avgGrade = avgGrade;",
                "    }",
                "    public void setName(String name) { this.name = name; }",
                "    public void setAvgGrade(double grade) { this.avgGrade = grade; }",
                "    public String toString() { return name + \"(\" + ID + \"): \" + avgGrade; }",
                "}",
                "Student s = new Student(\"Alice\", \"12345\", 85.5);",
                "s.setName(\"Alice Smith\");",
                "s.setAvgGrade(88.0);",
                "System.out.println(s);"
        };

        Supplier<String> execution = () -> {
            TestStudentFinal s = new TestStudentFinal("Alice", "12345", 85.5);
            s.setName("Alice Smith");
            s.setAvgGrade(88.0);
            return s.toString();
        };

        String explanation = "EXPLANATION: The Student class has both mutable (name, avgGrade) and immutable (final ID) fields. Final fields must be initialized in the constructor and cannot be changed later. setName() and setAvgGrade() modify the mutable fields successfully. The ID field remains \"12345\" throughout the object's lifetime. toString() shows the updated name and grade, but original ID.";

        return new Question("Final Fields and Object Immutability", code, execution, explanation, "Your answer: ");
    }

    // Helper classes for simulating the code examples
    static class TestOrderedPair<T1, T2> {
        private final T1 first;
        private final T2 second;

        public TestOrderedPair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static class TestStudentFinal {
        private String name;
        private final String ID;
        private double avgGrade;

        public TestStudentFinal(String name, String ID, double avgGrade) {
            this.name = name;
            this.ID = ID;
            this.avgGrade = avgGrade;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAvgGrade(double grade) {
            this.avgGrade = grade;
        }

        public String toString() {
            return name + "(" + ID + "): " + avgGrade;
        }
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
        System.out.println("• Method overriding and inheritance hierarchies");
        System.out.println("• Generic classes and type parameters");
        System.out.println("• Final fields and object immutability");
        System.out.println("• Shape hierarchies and interface inheritance");

        System.out.println("\nObject-Oriented Debugging Tips:");
        System.out.println("• Trace constructor calls and field initialization");
        System.out.println("• Understand the difference between this() and super()");
        System.out.println("• Remember that interface references can hold implementing objects");
        System.out.println("• Pay attention to instanceof checks before casting");
        System.out.println("• Follow object state changes through method calls");
        System.out.println("• Track dynamic method dispatch in inheritance hierarchies");
        System.out.println("• Understand final fields cannot be modified after initialization");

        System.out.println("\nThese concepts are from your OOP folder!");
        System.out.println("Explore: Point.java, Rectangle.java, Square.java, Student.java, OrderedPair.java");
        System.out.println("Also check: DynamicArray.java, Shape.java, ContactPerson.java, PhoneNumber.java");
        System.out.println("\nCongratulations on mastering comprehensive object-oriented programming!");
        System.out.println("You've conquered: Basic Java → Algorithms → Functions → Recursion → Advanced OOP!");
        System.out.println("\nYou're now ready for advanced Java development and design patterns! 🚀");
    }
}
