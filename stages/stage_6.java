import java.util.Scanner;

public class stage_6 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 6 ===");
        System.out.println("Welcome to Stage 6: Advanced OOP & Inheritance!");
        System.out.println(
                "This stage focuses on inheritance, polymorphism, generics, and advanced object interactions.");
        System.out.println("Think about method overriding, super calls, and dynamic dispatch!\n");

        // Question 1: Inheritance and super calls
        question1();

        // Question 2: Method overriding and polymorphism
        question2();

        // Question 3: Generic classes and type safety
        question3();

        // Question 4: Linked list operations
        question4();

        // Question 5: Interface inheritance and generic wildcards
        question5();

        // Show final results
        showFinalResults();
    }

    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1: Inheritance and Super Calls");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Rectangle {");
        System.out.println("    protected double height, width;");
        System.out.println("    public Rectangle(double height, double width) {");
        System.out.println("        this.height = height; this.width = width;");
        System.out.println("    }");
        System.out.println("    public double area() { return height * width; }");
        System.out.println("    public double getWidth() { return width; }");
        System.out.println("}");
        System.out.println("class Square extends Rectangle {");
        System.out.println("    public Square(double side) { super(side, side); }");
        System.out.println("    public double getSide() { return getWidth(); }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Square s = new Square(4.0);");
        System.out.println("System.out.println(s.area());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Square.java and Rectangle.java logic
        TestSquare s = new TestSquare(4.0);
        double result = s.area();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Square extends Rectangle. super(side, side) calls Rectangle constructor with height=4.0, width=4.0. area() returns 4.0 * 4.0 = 16.0.");
    }

    // Helper classes for inheritance simulation
    static class TestRectangle {
        protected double height, width;

        public TestRectangle(double height, double width) {
            this.height = height;
            this.width = width;
        }

        public double area() {
            return height * width;
        }

        public double getWidth() {
            return width;
        }
    }

    static class TestSquare extends TestRectangle {
        public TestSquare(double side) {
            super(side, side);
        }

        public double getSide() {
            return getWidth();
        }
    }

    private static void question2() {
        totalQuestions++;
        System.out.println("\nQUESTION 2: Method Overriding and Polymorphism");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Rectangle {");
        System.out.println("    public String name() { return \"Rectangle\"; }");
        System.out.println("}");
        System.out.println("class Square extends Rectangle {");
        System.out.println("    @Override");
        System.out.println("    public String name() { return \"Square\"; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Rectangle r = new Square();");
        System.out.println("System.out.println(r.name());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution demonstrating polymorphism
        TestRectangle2 r = new TestSquare2();
        String result = r.name();
        String actualOutput = result;

        checkAnswer(userGuess, actualOutput,
                "Explanation: Despite r being declared as Rectangle, it points to a Square object. Due to polymorphism, Square's overridden name() method is called, returning \"Square\".");
    }

    // Helper classes for polymorphism simulation
    static class TestRectangle2 {
        public String name() {
            return "Rectangle";
        }
    }

    static class TestSquare2 extends TestRectangle2 {
        @Override
        public String name() {
            return "Square";
        }
    }

    private static void question3() {
        totalQuestions++;
        System.out.println("\nQUESTION 3: Generic Classes and Type Safety");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public class OrderedPair<T1, T2> {");
        System.out.println("    private final T1 first;");
        System.out.println("    private final T2 second;");
        System.out.println("    public OrderedPair(T1 first, T2 second) {");
        System.out.println("        this.first = first; this.second = second;");
        System.out.println("    }");
        System.out.println("    public T1 getFirst() { return this.first; }");
        System.out.println("    public T2 getSecond() { return this.second; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("OrderedPair<String, Integer> pair = new OrderedPair<>(\"Hello\", 42);");
        System.out.println("System.out.println(pair.getSecond());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from OrderedPair.java logic
        TestOrderedPair<String, Integer> pair = new TestOrderedPair<>("Hello", 42);
        Integer result = pair.getSecond();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: OrderedPair is parameterized with <String, Integer>. getSecond() returns the Integer value 42.");
    }

    // Helper class for generics simulation
    static class TestOrderedPair<T1, T2> {
        private final T1 first;
        private final T2 second;

        public TestOrderedPair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return this.first;
        }

        public T2 getSecond() {
            return this.second;
        }
    }

    private static void question4() {
        totalQuestions++;
        System.out.println("\nQUESTION 4: Linked List Operations");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("class Link<E> {");
        System.out.println("    private E data;");
        System.out.println("    private Link<E> next;");
        System.out.println("    public Link(E data, Link<E> next) {");
        System.out.println("        this.data = data; this.next = next;");
        System.out.println("    }");
        System.out.println("    public E getData() { return data; }");
        System.out.println("    public Link<E> getNext() { return next; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("Link<String> second = new Link<>(\"World\", null);");
        System.out.println("Link<String> first = new Link<>(\"Hello\", second);");
        System.out.println("System.out.println(first.getNext().getData());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Link.java logic
        TestLink<String> second = new TestLink<>("World", null);
        TestLink<String> first = new TestLink<>("Hello", second);
        String result = first.getNext().getData();
        String actualOutput = result;

        checkAnswer(userGuess, actualOutput,
                "Explanation: first.getNext() returns the 'second' link, and second.getData() returns \"World\".");
    }

    // Helper class for linked list simulation
    static class TestLink<E> {
        private E data;
        private TestLink<E> next;

        public TestLink(E data, TestLink<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public TestLink<E> getNext() {
            return next;
        }
    }

    private static void question5() {
        totalQuestions++;
        System.out.println("\nQUESTION 5: Interface Inheritance and Generic Bounds");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("interface List<T> {");
        System.out.println("    public int size();");
        System.out.println("    public void add(T element);");
        System.out.println("}");
        System.out.println("class LinkedList<T> implements List<T> {");
        System.out.println("    private int count = 0;");
        System.out.println("    public int size() { return count; }");
        System.out.println("    public void add(T element) { count++; }");
        System.out.println("}");
        System.out.println("// Usage:");
        System.out.println("List<String> list = new LinkedList<>();");
        System.out.println("list.add(\"A\"); list.add(\"B\");");
        System.out.println("System.out.println(list.size());");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from List.java and LinkedList.java logic
        TestList<String> list = new TestLinkedList<>();
        list.add("A");
        list.add("B");
        int result = list.size();
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: LinkedList implements List interface. Two elements are added, each incrementing count. size() returns 2.");
    }

    // Helper interface and class for interface inheritance simulation
    interface TestList<T> {
        public int size();

        public void add(T element);
    }

    static class TestLinkedList<T> implements TestList<T> {
        private int count = 0;

        public int size() {
            return count;
        }

        public void add(T element) {
            count++;
        }
    }

    private static void checkAnswer(String userGuess, String actualOutput, String explanation) {
        System.out.println("\nActual output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Masterful understanding of advanced OOP!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showFinalResults() {
        System.out.println("\n=== STAGE 6 COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("🎉 PHENOMENAL! You have achieved mastery of advanced object-oriented programming!");
        } else if (percentage >= 60) {
            System.out.println("👍 Excellent work! You're demonstrating sophisticated OOP understanding!");
        } else {
            System.out.println(
                    "🤔 Keep practicing! Advanced OOP is challenging - you're tackling professional-level concepts!");
        }

        System.out.println("\nAdvanced concepts covered in Stage 6:");
        System.out.println("• Inheritance hierarchies and super() calls");
        System.out.println("• Method overriding and dynamic dispatch (polymorphism)");
        System.out.println("• Generic classes and type parameters");
        System.out.println("• Generic collections and data structures");
        System.out.println("• Interface inheritance and implementation");
        System.out.println("• Advanced object composition and design patterns");

        System.out.println("\nAdvanced OOP Debugging Tips:");
        System.out.println("• Understand the difference between compile-time and runtime types");
        System.out.println("• Trace method calls through inheritance hierarchies");
        System.out.println("• Pay attention to which version of an overridden method is called");
        System.out.println("• Remember that generics provide compile-time type safety");
        System.out.println("• Follow object references through linked structures");
        System.out.println("• Understand interface contracts vs. implementation details");

        System.out.println("\nThese advanced patterns are from your OOP folder!");
        System.out.println("Explore: Square.java, OrderedPair.java, LinkedList.java, Link.java, List.java");
        System.out.println("\nYou have now mastered the complete Java programming spectrum!");
        System.out.println("Your journey: Basic Java → Algorithms → Functions → Recursion → OOP → Advanced OOP");
        System.out.println("\n🚀 You're ready for enterprise Java development and advanced software engineering!");
        System.out.println("Consider exploring: Design Patterns, Spring Framework, JavaFX, or Android Development!");
    }
}
