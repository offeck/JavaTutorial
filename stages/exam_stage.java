import java.util.*;
import java.util.function.Supplier;

public class exam_stage {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - EXAM STAGE ===");
        System.out.println("Welcome! These questions are inspired by the intro221a exam.");
        System.out.println();

        executeQuestion(createQuestion1());
        executeQuestion(createQuestion2());
        executeQuestion(createQuestion3());
        executeQuestion(createQuestion4());

        String[] concepts = {
                "Graph partitions and edge checks",
                "Balanced parentheses using counters",
                "String-based number calculations",
                "Circular buffer insertion and removal"
        };

        String[] tips = {
                "Watch indices carefully when validating data",
                "Use counters instead of building strings when possible",
                "Remember carry values in numeric algorithms",
                "Modulo arithmetic is useful for circular structures"
        };

        Question.showFinalResults(score, totalQuestions, "EXAM STAGE", concepts, tips,
                "These problems mirror concepts from the exam solutions.",
                new String[] { "" }, new String[] {},
                "Great job working through these past exam topics!");
    }

    private static void executeQuestion(Question q) {
        totalQuestions++;
        q.execute(scanner, totalQuestions);
        if (q.wasCorrect()) {
            score++;
        }
    }

    private static Question createQuestion1() {
        String[] code = {
                "java.util.Set<Integer> setA = new java.util.HashSet<Integer>();",
                "setA.add(0); setA.add(2);",
                "java.util.Set<Integer> setB = new java.util.HashSet<Integer>();",
                "setB.add(1);",
                "Edge[] edges = { new Edge(0,1), new Edge(1,2) };",
                "System.out.println(runAlgorithm(3, setA, setB, edges));"
        };

        Supplier<String> exec = () -> {
            java.util.Set<Integer> setA = new java.util.HashSet<Integer>();
            setA.add(0);
            setA.add(2);

            java.util.Set<Integer> setB = new java.util.HashSet<Integer>();
            setB.add(1);

            Edge[] edges = { new Edge(0, 1), new Edge(1, 2) };
            boolean result = runAlgorithm(3, setA, setB, edges);
            return String.valueOf(result);
        };

        String explanation = "EXPLANATION: isPartition verifies that the two sets contain all vertices exactly once. " +
                "runAlgorithm then checks every edge connects vertices from different sets. " +
                "Here all conditions hold so the result is true.";

        return new Question("Graph Partition Validation", code, exec, explanation);
    }

    private static Question createQuestion2() {
        String[] code = {
                "String s = \"(()())\";",
                "System.out.println(isBalanced(s));"
        };

        Supplier<String> exec = () -> {
            String s = "(()())";
            boolean result = isBalanced(s);
            return String.valueOf(result);
        };

        String explanation = "EXPLANATION: Using a counter for open parentheses, " +
                "the string never becomes negative and ends at zero, so it is balanced.";

        return new Question("Balanced Parentheses", code, exec, explanation);
    }

    private static Question createQuestion3() {
        String[] code = {
                "String s = \"129\";",
                "System.out.println(decimalAddDigit(s, 5));"
        };

        Supplier<String> exec = () -> decimalAddDigit("129", 5);

        String explanation = "EXPLANATION: Add 5 to the first digit with carry propagation: " +
                "9+5=14 so write 4 and carry 1; next digit 2+1=3; final digit 1 gives 134.";

        return new Question("Add Digit Recursively", code, exec, explanation);
    }

    private static Question createQuestion4() {
        String[] code = {
                "Buffer<Integer> buf = new Buffer<>(3);",
                "buf.insert(1);",
                "buf.insert(2);",
                "buf.insert(3);",
                "System.out.println(buf.remove());",
                "buf.insert(4);",
                "System.out.println(buf.remove());"
        };

        Supplier<String> exec = () -> {
            Buffer<Integer> buf = new Buffer<>(3);
            buf.insert(1);
            buf.insert(2);
            buf.insert(3);
            int r1 = buf.remove();
            buf.insert(4);
            int r2 = buf.remove();
            return r1 + "," + r2;
        };

        String explanation = "EXPLANATION: The buffer stores up to the capacity in a circular array. " +
                "After inserting 1,2,3 the buffer is full. remove() returns the oldest value 1. " +
                "Inserting 4 adds to the free slot; next remove() returns 2.";

        return new Question("Circular Buffer Operations", code, exec, explanation,
                "Your answer (comma separated): ");
    }

    // ===== Helper methods and classes =====

    private static boolean isPartition(int n, java.util.Set<Integer> a, java.util.Set<Integer> b) {
        if (a.size() + b.size() != n)
            return false;
        boolean[] seen = new boolean[n];
        for (int e : a) {
            if (e < 0 || e >= n || seen[e])
                return false;
            seen[e] = true;
        }
        for (int e : b) {
            if (e < 0 || e >= n || seen[e])
                return false;
            seen[e] = true;
        }
        return true;
    }

    private static boolean runAlgorithm(int n, java.util.Set<Integer> a, java.util.Set<Integer> b, Edge[] edges) {
        if (!isPartition(n, a, b))
            return false;
        boolean[] partition = new boolean[n];
        for (int v : b)
            partition[v] = true;
        for (Edge e : edges) {
            if (partition[e.left] == partition[e.right])
                return false;
        }
        return true;
    }

    private static boolean isBalanced(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    private static String decimalAddDigit(String s, int digit) {
        return decimalAddDigit(s, digit, 0);
    }

    private static String decimalAddDigit(String s, int digit, int carry) {
        if (s.isEmpty())
            return "" + (digit + carry);
        int sum = (s.charAt(0) - '0') + digit + carry;
        int newDigit = sum % 10;
        int newCarry = sum / 10;
        return newDigit + decimalAddDigit(s.substring(1), 0, newCarry);
    }

    static class Buffer<E> {
        private Object[] elements;
        private int size;
        private int index;

        Buffer(int capacity) {
            elements = new Object[capacity];
            size = 0;
            index = 0;
        }

        void insert(E element) {
            elements[index] = element;
            index = (index + 1) % elements.length;
            if (size < elements.length)
                size++;
        }

        @SuppressWarnings("unchecked")
        E remove() {
            if (size == 0)
                throw new NoSuchElementException();
            int len = elements.length;
            int removeIndex = (len - size + index) % len;
            E removed = (E) elements[removeIndex];
            size--;
            return removed;
        }
    }

    static class Edge {
        int left;
        int right;

        Edge(int l, int r) {
            left = l;
            right = r;
        }
    }
}
