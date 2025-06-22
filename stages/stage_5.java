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
        question4();        // Question 5: Dynamic array operations
        question5();
        
        // Question 6: Inheritance and super constructor
        question6();
        
        // Question 7: Generic classes with inheritance
        question7();
          // Question 8: Method validation and encapsulation
        question8();
        
        // Question 9: Interface implementation with shapes
        question9();
        
        // Question 10: Inheritance hierarchy (Rectangle and Square)
        question10();
        
        // Question 11: Generic classes with complex types
        question11();
        
        // Question 12: Final fields and object immutability
        question12();

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

    // Additional helper classes for questions 9-12
    interface TestShape {
        String name();
        double area();
    }
    
    static class TestRectangle implements TestShape {
        protected double height = 4.0;
        protected double width = 3.0;
        
        public TestRectangle() {}
        
        public TestRectangle(double h, double w) {
            height = h;
            width = w;
        }
        
        public String name() { return "Rectangle"; }
        public double area() { return height * width; }
        public String toString() { return name() + ", h=" + height + ", w=" + width; }
    }
    
    static class TestSquare extends TestRectangle {
        public TestSquare(double side) { 
            super(side, side); 
        }
        public String name() { return "Square"; }
        public String toString() { return "Square, side=" + width; }
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

    private static void question6() {
        totalQuestions++;
        System.out.println("\nQUESTION 6: Inheritance and Super Constructor");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Record<V> {");
        System.out.println("    private String key;");
        System.out.println("    private V value;");
        System.out.println("    public Record(String key, V value) {");
        System.out.println("        this.key = key; this.value = value;");
        System.out.println("    }");
        System.out.println("    public String getKey() { return key; }");
        System.out.println("    public V getValue() { return value; }");
        System.out.println("}");
        System.out.println("class ContactPerson extends Record<String> {");
        System.out.println("    private String contactType;");
        System.out.println("    public ContactPerson(String name, String phone, String type) {");
        System.out.println("        super(name, phone);");
        System.out.println("        this.contactType = type;");
        System.out.println("    }");
        System.out.println("    public String getContactType() { return contactType; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("ContactPerson cp = new ContactPerson(\"John\", \"123-456\", \"Friend\");");
        System.out.println("System.out.println(cp.getValue());");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from ContactPerson.java and Record.java logic
        TestContactPerson cp = new TestContactPerson("John", "123-456", "Friend");
        String result = cp.getValue();
        String actualOutput = result;
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: ContactPerson extends Record<String>. super(name, phone) calls Record constructor with key=\"John\", value=\"123-456\". getValue() returns \"123-456\".");
    }
    
    // Helper classes for inheritance simulation
    static class TestRecord<V> {
        private String key;
        private V value;
        public TestRecord(String key, V value) {
            this.key = key; this.value = value;
        }
        public String getKey() { return key; }
        public V getValue() { return value; }
    }
    
    static class TestContactPerson extends TestRecord<String> {
        private String contactType;
        public TestContactPerson(String name, String phone, String type) {
            super(name, phone);
            this.contactType = type;
        }
        public String getContactType() { return contactType; }
    }
    
    private static void question7() {
        totalQuestions++;
        System.out.println("\nQUESTION 7: Generic Classes with Type Bounds");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Record<V> {");
        System.out.println("    private String key;");
        System.out.println("    private V value;");
        System.out.println("    public Record(String key, V value) {");
        System.out.println("        this.key = key; this.value = value;");
        System.out.println("    }");
        System.out.println("    public String toString() {");
        System.out.println("        return \"[\" + key + \", \" + value + \"]\";");
        System.out.println("    }");
        System.out.println("    public boolean equals(Object other) {");
        System.out.println("        if (other instanceof Record) {");
        System.out.println("            Record<?> otherRecord = (Record<?>) other;");
        System.out.println("            return key.equals(otherRecord.key);");
        System.out.println("        }");
        System.out.println("        return false;");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Record<Integer> r1 = new Record<>(\"age\", 25);");
        System.out.println("Record<String> r2 = new Record<>(\"age\", \"25\");");
        System.out.println("System.out.println(r1.equals(r2));");
        System.out.println("---");
        
        System.out.print("Your guess (true/false): ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from Record.java logic
        TestRecord2<Integer> r1 = new TestRecord2<>("age", 25);
        TestRecord2<String> r2 = new TestRecord2<>("age", "25");
        boolean result = r1.equals(r2);
        String actualOutput = String.valueOf(result);
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: Both records have key=\"age\". The equals method only compares keys, ignoring the generic value types. So r1.equals(r2) returns true.");
    }
    
    // Helper class for generic comparison simulation
    static class TestRecord2<V> {
        private String key;
        private V value;
        public TestRecord2(String key, V value) {
            this.key = key; this.value = value;
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
    
    private static void question8() {
        totalQuestions++;
        System.out.println("\nQUESTION 8: Input Validation and Encapsulation");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class PhoneNumber {");
        System.out.println("    private String phoneNumber;");
        System.out.println("    public PhoneNumber(String phoneNumber) {");
        System.out.println("        if (!isLegal(phoneNumber))");
        System.out.println("            throw new IllegalArgumentException(\"Invalid phone\");");
        System.out.println("        this.phoneNumber = phoneNumber;");
        System.out.println("    }");
        System.out.println("    private boolean isLegal(String phone) {");
        System.out.println("        return phone != null && phone.length() == 9 && phone.charAt(0) == '0';");
        System.out.println("    }");
        System.out.println("    public String toString() { return phoneNumber; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("try {");
        System.out.println("    PhoneNumber p1 = new PhoneNumber(\"012345678\");");
        System.out.println("    PhoneNumber p2 = new PhoneNumber(\"123456789\");");
        System.out.println("    System.out.println(\"Success\");");
        System.out.println("} catch (IllegalArgumentException e) {");
        System.out.println("    System.out.println(\"Error\");");
        System.out.println("}");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from PhoneNumber.java logic
        String actualOutput;
        try {
            TestPhoneNumber p1 = new TestPhoneNumber("012345678"); // valid: length 9, starts with '0'
            TestPhoneNumber p2 = new TestPhoneNumber("123456789"); // invalid: doesn't start with '0'
            actualOutput = "Success";
        } catch (IllegalArgumentException e) {
            actualOutput = "Error";
        }
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: First phone number \"012345678\" is valid (length 9, starts with '0'). Second \"123456789\" is invalid (doesn't start with '0'), so exception is thrown and \"Error\" is printed.");
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
        public String toString() { return phoneNumber; }
    }

    private static void question9() {
        totalQuestions++;
        System.out.println("QUESTION 9: Interface Implementation with Shapes");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("interface Shape {");
        System.out.println("    String name();");
        System.out.println("    double area();");
        System.out.println("}");
        System.out.println("class Rectangle implements Shape {");
        System.out.println("    private double height = 4.0;");
        System.out.println("    private double width = 3.0;");
        System.out.println("    public String name() { return \"Rectangle\"; }");
        System.out.println("    public double area() { return height * width; }");
        System.out.println("}");
        System.out.println("Shape s = new Rectangle();");
        System.out.println("System.out.println(s.name() + \": \" + s.area());");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim();

        // Simulate the actual execution
        TestShape s = new TestRectangle();
        String actualOutput = s.name() + ": " + s.area();

        String explanation = """
                EXPLANATION:
                • The Rectangle class implements the Shape interface
                • An interface reference (Shape s) can hold objects of implementing classes
                • When s.name() is called, it executes Rectangle's implementation
                • When s.area() is called, it calculates 4.0 * 3.0 = 12.0
                • This demonstrates polymorphism - same interface, different implementations
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Great understanding of interfaces and polymorphism!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question10() {
        totalQuestions++;
        System.out.println("QUESTION 10: Inheritance Hierarchy (Rectangle and Square)");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Rectangle implements Shape {");
        System.out.println("    private double height, width;");
        System.out.println("    public Rectangle(double h, double w) { height = h; width = w; }");
        System.out.println("    public String name() { return \"Rectangle\"; }");
        System.out.println("    public double area() { return height * width; }");
        System.out.println("    public String toString() { return name() + \", h=\" + height + \", w=\" + width; }");
        System.out.println("}");
        System.out.println("class Square extends Rectangle {");
        System.out.println("    public Square(double side) { super(side, side); }");
        System.out.println("    public String name() { return \"Square\"; }");
        System.out.println("    public String toString() { return \"Square, side=\" + width; }");
        System.out.println("}");
        System.out.println("Rectangle r = new Square(5.0);");
        System.out.println("System.out.println(r.toString() + \", area=\" + r.area());");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim();

        // Simulate the actual execution
        TestRectangle r = new TestSquare(5.0);
        String actualOutput = r.toString() + ", area=" + r.area();

        String explanation = """
                EXPLANATION:
                • Square extends Rectangle and calls super(side, side) in constructor
                • Rectangle reference r holds a Square object (polymorphism)
                • r.toString() calls Square's overridden toString() method (dynamic dispatch)
                • r.area() calls Rectangle's area() method (inherited, not overridden)
                • The area calculation uses inherited height * width = 5.0 * 5.0 = 25.0
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Excellent understanding of inheritance and method overriding!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question11() {
        totalQuestions++;
        System.out.println("QUESTION 11: Generic Classes with Complex Types");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class OrderedPair<T1, T2> {");
        System.out.println("    private final T1 first;");
        System.out.println("    private final T2 second;");
        System.out.println("    public OrderedPair(T1 first, T2 second) {");
        System.out.println("        this.first = first; this.second = second;");
        System.out.println("    }");
        System.out.println("    public String toString() {");
        System.out.println("        return \"(\" + first + \", \" + second + \")\";");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("OrderedPair<String, Integer> pair1 = new OrderedPair<>(\"Score\", 95);");
        System.out.println("OrderedPair<Double, String> pair2 = new OrderedPair<>(3.14, \"Pi\");");
        System.out.println("System.out.println(pair1 + \" - \" + pair2);");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim();

        // Simulate the actual execution
        TestOrderedPair<String, Integer> pair1 = new TestOrderedPair<>("Score", 95);
        TestOrderedPair<Double, String> pair2 = new TestOrderedPair<>(3.14, "Pi");
        String actualOutput = pair1 + " - " + pair2;

        String explanation = """
                EXPLANATION:
                • Generic classes allow type parameters (<T1, T2>) for type safety
                • OrderedPair<String, Integer> creates a pair with String first, Integer second
                • OrderedPair<Double, String> creates a pair with Double first, String second
                • toString() is called implicitly when objects are concatenated with strings
                • The diamond operator <> infers types from the declaration
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Wonderful understanding of generics and type parameters!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question12() {
        totalQuestions++;
        System.out.println("QUESTION 12: Final Fields and Object Immutability");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Student {");
        System.out.println("    private String name;");
        System.out.println("    private final String ID;");
        System.out.println("    private double avgGrade;");
        System.out.println("    public Student(String name, String ID, double avgGrade) {");
        System.out.println("        this.name = name; this.ID = ID; this.avgGrade = avgGrade;");
        System.out.println("    }");
        System.out.println("    public void setName(String name) { this.name = name; }");
        System.out.println("    public void setAvgGrade(double grade) { this.avgGrade = grade; }");
        System.out.println("    public String toString() { return name + \"(\" + ID + \"): \" + avgGrade; }");
        System.out.println("}");
        System.out.println("Student s = new Student(\"Alice\", \"12345\", 85.5);");
        System.out.println("s.setName(\"Alice Smith\");");
        System.out.println("s.setAvgGrade(88.0);");
        System.out.println("System.out.println(s);");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim();

        // Simulate the actual execution
        TestStudentFinal s = new TestStudentFinal("Alice", "12345", 85.5);
        s.setName("Alice Smith");
        s.setAvgGrade(88.0);
        String actualOutput = s.toString();

        String explanation = """
                EXPLANATION:
                • The Student class has both mutable (name, avgGrade) and immutable (final ID) fields
                • Final fields must be initialized in the constructor and cannot be changed later
                • setName() and setAvgGrade() modify the mutable fields successfully
                • The ID field remains "12345" throughout the object's lifetime
                • toString() shows the updated name and grade, but original ID
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Perfect understanding of final fields and object mutability!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    // Helper classes for simulating the code examples
    static class TestOrderedPair<T1, T2> {
        private final T1 first;
        private final T2 second;
        public TestOrderedPair(T1 first, T2 second) {
            this.first = first; this.second = second;
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
        
        public void setName(String name) { this.name = name; }
        public void setAvgGrade(double grade) { this.avgGrade = grade; }
        public String toString() { return name + "(" + ID + "): " + avgGrade; }
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
        }        System.out.println("\nKey concepts covered in Stage 5:");
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
