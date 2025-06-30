import java.util.Scanner;
import java.util.function.Supplier;

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

        // Execute all questions using the Question framework
        executeQuestion(createQuestion1());
        executeQuestion(createQuestion2());
        executeQuestion(createQuestion3());
        executeQuestion(createQuestion4());
        executeQuestion(createQuestion5());
        executeQuestion(createQuestion6());
        executeQuestion(createQuestion7());
        executeQuestion(createQuestion8());

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
                "class Rectangle {",
                "    protected double height, width;",
                "    public Rectangle(double height, double width) {",
                "        this.height = height; this.width = width;",
                "    }",
                "    public double area() { return height * width; }",
                "    public double getWidth() { return width; }",
                "}",
                "class Square extends Rectangle {",
                "    public Square(double side) { super(side, side); }",
                "    public double getSide() { return getWidth(); }",
                "}",
                "// Usage:",
                "Square s = new Square(4.0);",
                "System.out.println(s.area());"
        };

        Supplier<String> execution = () -> {
            TestSquare s = new TestSquare(4.0);
            return String.valueOf(s.area());
        };

        String explanation = "Explanation: Square extends Rectangle. super(side, side) calls Rectangle constructor with height=4.0, width=4.0. area() returns 4.0 * 4.0 = 16.0.";

        return new Question("Inheritance and Super Calls", code, execution, explanation);
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

    private static Question createQuestion2() {
        String[] code = {
                "class Rectangle {",
                "    public String name() { return \"Rectangle\"; }",
                "}",
                "class Square extends Rectangle {",
                "    @Override",
                "    public String name() { return \"Square\"; }",
                "}",
                "// Usage:",
                "Rectangle r = new Square();",
                "System.out.println(r.name());"
        };

        Supplier<String> execution = () -> {
            TestRectangle2 r = new TestSquare2();
            return r.name();
        };

        String explanation = "Explanation: Despite r being declared as Rectangle, it points to a Square object. Due to polymorphism, Square's overridden name() method is called, returning \"Square\".";

        return new Question("Method Overriding and Polymorphism", code, execution, explanation);
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

    private static Question createQuestion3() {
        String[] code = {
                "public class OrderedPair<T1, T2> {",
                "    private final T1 first;",
                "    private final T2 second;",
                "    public OrderedPair(T1 first, T2 second) {",
                "        this.first = first; this.second = second;",
                "    }",
                "    public T1 getFirst() { return this.first; }",
                "    public T2 getSecond() { return this.second; }",
                "}",
                "// Usage:",
                "OrderedPair<String, Integer> pair = new OrderedPair<>(\"Hello\", 42);",
                "System.out.println(pair.getSecond());"
        };

        Supplier<String> execution = () -> {
            TestOrderedPair<String, Integer> pair = new TestOrderedPair<>("Hello", 42);
            return String.valueOf(pair.getSecond());
        };

        String explanation = "Explanation: OrderedPair is parameterized with <String, Integer>. getSecond() returns the Integer value 42.";

        return new Question("Generic Classes and Type Safety", code, execution, explanation);
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

    private static Question createQuestion4() {
        String[] code = {
                "class Link<E> {",
                "    private E data;",
                "    private Link<E> next;",
                "    public Link(E data, Link<E> next) {",
                "        this.data = data; this.next = next;",
                "    }",
                "    public E getData() { return data; }",
                "    public Link<E> getNext() { return next; }",
                "}",
                "// Usage:",
                "Link<String> second = new Link<>(\"World\", null);",
                "Link<String> first = new Link<>(\"Hello\", second);",
                "System.out.println(first.getNext().getData());"
        };

        Supplier<String> execution = () -> {
            TestLink<String> second = new TestLink<>("World", null);
            TestLink<String> first = new TestLink<>("Hello", second);
            return first.getNext().getData();
        };

        String explanation = "Explanation: first.getNext() returns the 'second' link, and second.getData() returns \"World\".";

        return new Question("Linked List Operations", code, execution, explanation);
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

    private static Question createQuestion5() {
        String[] code = {
                "interface List<T> {",
                "    public int size();",
                "    public void add(T element);",
                "}",
                "class LinkedList<T> implements List<T> {",
                "    private int count = 0;",
                "    public int size() { return count; }",
                "    public void add(T element) { count++; }",
                "}",
                "// Usage:",
                "List<String> list = new LinkedList<>();",
                "list.add(\"A\"); list.add(\"B\");",
                "System.out.println(list.size());"
        };

        Supplier<String> execution = () -> {
            TestList<String> list = new TestLinkedList<>();
            list.add("A");
            list.add("B");
            return String.valueOf(list.size());
        };

        String explanation = "Explanation: LinkedList implements List interface. Two elements are added, each incrementing count. size() returns 2.";

        return new Question("Interface Inheritance and Generic Bounds", code, execution, explanation);
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

    private static Question createQuestion6() {
        String[] code = {
                "class BinaryNode<T> {",
                "    protected T data;",
                "    protected BinaryNode<T> left, right;",
                "    public BinaryNode(T element) { this.data = element; }",
                "    public T getData() { return data; }",
                "    public BinaryNode<T> getLeft() { return left; }",
                "    public BinaryNode<T> getRight() { return right; }",
                "    public void setLeft(BinaryNode<T> left) { this.left = left; }",
                "    public void setRight(BinaryNode<T> right) { this.right = right; }",
                "}",
                "// Usage:",
                "BinaryNode<String> root = new BinaryNode<>(\"A\");",
                "root.setLeft(new BinaryNode<>(\"B\"));",
                "root.setRight(new BinaryNode<>(\"C\"));",
                "System.out.println(root.getLeft().getData());"
        };

        Supplier<String> execution = () -> {
            TestBinaryNode<String> root = new TestBinaryNode<>("A");
            root.setLeft(new TestBinaryNode<>("B"));
            root.setRight(new TestBinaryNode<>("C"));
            return root.getLeft().getData();
        };

        String explanation = "Explanation: Binary tree with root 'A', left child 'B', right child 'C'. root.getLeft().getData() returns 'B'.";

        return new Question("Binary Tree Operations", code, execution, explanation);
    }
    
    // Helper class for binary tree simulation
    static class TestBinaryNode<T> {
        protected T data;
        protected TestBinaryNode<T> left, right;
        public TestBinaryNode(T element) { this.data = element; }
        public T getData() { return data; }
        public TestBinaryNode<T> getLeft() { return left; }
        public TestBinaryNode<T> getRight() { return right; }
        public void setLeft(TestBinaryNode<T> left) { this.left = left; }
        public void setRight(TestBinaryNode<T> right) { this.right = right; }
    }
    
    private static Question createQuestion7() {
        String[] code = {
                "interface Stack<T> {",
                "    public boolean isEmpty();",
                "    public T peek();",
                "    public T pop();",
                "    public void push(T element);",
                "}",
                "class StackArray<T> implements Stack<T> {",
                "    private List<T> array = new ArrayList<>();",
                "    public boolean isEmpty() { return array.isEmpty(); }",
                "    public void push(T element) { array.add(element); }",
                "    public T pop() { return array.remove(array.size()-1); }",
                "    public T peek() { return array.get(array.size()-1); }",
                "}",
                "// Usage:",
                "Stack<Integer> stack = new StackArray<>();",
                "stack.push(10); stack.push(20); stack.push(30);",
                "stack.pop();",
                "System.out.println(stack.peek());"
        };

        Supplier<String> execution = () -> {
            TestStack<Integer> stack = new TestStackArray<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.pop();
            return String.valueOf(stack.peek());
        };

        String explanation = "Explanation: Stack follows LIFO (Last In, First Out). After pushing 10,20,30 and popping once, peek() returns 20.";

        return new Question("Stack Implementation", code, execution, explanation);
    }
    
    // Helper interface and class for stack simulation
    interface TestStack<T> {
        public boolean isEmpty();
        public T peek();
        public T pop();
        public void push(T element);
    }
    
    static class TestStackArray<T> implements TestStack<T> {
        private java.util.List<T> array = new java.util.ArrayList<>();
        public boolean isEmpty() { return array.isEmpty(); }
        public void push(T element) { array.add(element); }
        public T pop() { return array.remove(array.size()-1); }
        public T peek() { return array.get(array.size()-1); }
    }
    
    private static Question createQuestion8() {
        String[] code = {
                "class BST {",
                "    private Node root;",
                "    class Node {",
                "        int data; Node left, right;",
                "        Node(int data) { this.data = data; }",
                "    }",
                "    public void insert(int value) {",
                "        root = insertRec(root, value);",
                "    }",
                "    private Node insertRec(Node root, int value) {",
                "        if (root == null) return new Node(value);",
                "        if (value < root.data) root.left = insertRec(root.left, value);",
                "        else root.right = insertRec(root.right, value);",
                "        return root;",
                "    }",
                "    public int findMin() { return findMinRec(root); }",
                "    private int findMinRec(Node node) {",
                "        return node.left == null ? node.data : findMinRec(node.left);",
                "    }",
                "}",
                "// Usage:",
                "BST bst = new BST();",
                "bst.insert(50); bst.insert(30); bst.insert(70); bst.insert(20);",
                "System.out.println(bst.findMin());"
        };

        Supplier<String> execution = () -> {
            TestBST bst = new TestBST();
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            return String.valueOf(bst.findMin());
        };

        String explanation = "Explanation: BST property: left < root < right. Values inserted: 50,30,70,20. Minimum is always leftmost: 20.";

        return new Question("Binary Search Tree", code, execution, explanation);
    }
    
    // Helper class for BST simulation
    static class TestBST {
        private TestBSTNode root;
        
        static class TestBSTNode {
            int data;
            TestBSTNode left, right;
            TestBSTNode(int data) { this.data = data; }
        }
        
        public void insert(int value) {
            root = insertRec(root, value);
        }
        
        private TestBSTNode insertRec(TestBSTNode root, int value) {
            if (root == null) return new TestBSTNode(value);
            if (value < root.data) root.left = insertRec(root.left, value);
            else root.right = insertRec(root.right, value);
            return root;
        }
        
        public int findMin() { return findMinRec(root); }
        
        private int findMinRec(TestBSTNode node) {
            return node.left == null ? node.data : findMinRec(node.left);
        }
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
        }        System.out.println("\nAdvanced concepts covered in Stage 6:");
        System.out.println("• Inheritance hierarchies and super() calls");
        System.out.println("• Method overriding and dynamic dispatch (polymorphism)");
        System.out.println("• Generic classes and type parameters");
        System.out.println("• Generic collections and data structures");
        System.out.println("• Interface inheritance and implementation");
        System.out.println("• Advanced object composition and design patterns");
        System.out.println("• Binary tree operations and node relationships");
        System.out.println("• Stack implementation and LIFO operations");
        System.out.println("• Binary Search Tree properties and algorithms");

        System.out.println("\nAdvanced OOP & Data Structure Debugging Tips:");
        System.out.println("• Understand the difference between compile-time and runtime types");
        System.out.println("• Trace method calls through inheritance hierarchies");
        System.out.println("• Pay attention to which version of an overridden method is called");
        System.out.println("• Remember that generics provide compile-time type safety");
        System.out.println("• Follow object references through linked structures");
        System.out.println("• Understand interface contracts vs. implementation details");
        System.out.println("• Visualize tree structures and node relationships");
        System.out.println("• Remember LIFO for stacks and BST ordering properties");
        System.out.println("• Practice tracing recursive tree operations");

        System.out.println("\nThese advanced patterns are from your OOP and data structure folders!");
        System.out.println("Explore: Square.java, OrderedPair.java, LinkedList.java, BinaryNode.java, Stack.java, BinarySearchTree.java");
        System.out.println("\nYou have now mastered the complete Java programming spectrum!");
        System.out.println("Your journey: Basic Java → Algorithms → Functions → Recursion → OOP → Advanced OOP");
        System.out.println("\n🚀 You're ready for enterprise Java development and advanced software engineering!");
        System.out.println("Consider exploring: Design Patterns, Spring Framework, JavaFX, or Android Development!");
    }
}
