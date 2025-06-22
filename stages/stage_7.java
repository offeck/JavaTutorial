import java.util.Scanner;

public class stage_7 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 7 ===");
        System.out.println("Welcome to Stage 7: Advanced Data Structures!");
        System.out.println(
                "This stage focuses on abstract data types, interfaces, and complex data structure implementations.");
        System.out.println("Master the art of stacks, queues, sets, and advanced collections!\n");

        // Question 1: Stack operations with LIFO behavior
        question1();

        // Question 2: Queue implementation using two stacks
        question2();

        // Question 3: Set operations and uniqueness
        question3();

        // Question 4: Dynamic array resizing
        question4();

        // Question 5: Iterator pattern implementation
        question5();

        // Question 6: Abstract data type polymorphism
        question6();

        // Question 7: Complex queue operations
        question7();

        // Question 8: Generic type safety and bounds
        question8();

        // Show final results
        showFinalResults();
    }

    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1: Stack LIFO Operations");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("Stack<String> stack = new StackAsDynamicArray<>();");
        System.out.println("stack.push(\"first\");");
        System.out.println("stack.push(\"second\");");
        System.out.println("stack.push(\"third\");");
        System.out.println("System.out.println(stack.pop());");
        System.out.println("System.out.println(stack.peek());");
        System.out.println("stack.push(\"fourth\");");
        System.out.println("System.out.println(stack.pop());");
        System.out.println("System.out.println(stack.pop());");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestStack<String> stack = new TestStack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        String result1 = stack.pop();
        String result2 = stack.peek();
        stack.push("fourth");
        String result3 = stack.pop();
        String result4 = stack.pop();
        String actualOutput = result1 + "," + result2 + "," + result3 + "," + result4;

        String explanation = """
                EXPLANATION:
                • Stack follows LIFO (Last In, First Out) principle
                • push() adds elements to the top of the stack
                • pop() removes and returns the top element
                • peek() returns the top element without removing it
                • Order: push "first", push "second", push "third"
                • pop() returns "third", peek() shows "second" (still on stack)
                • push "fourth", pop() returns "fourth", pop() returns "second"
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Perfect understanding of stack operations!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question2() {
        totalQuestions++;
        System.out.println("QUESTION 2: Queue Using Two Stacks");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("// Queue implemented using two stacks");
        System.out.println("Queue<Integer> queue = new QueueAs2Stacks<>();");
        System.out.println("queue.enqueue(10);");
        System.out.println("queue.enqueue(20);");
        System.out.println("queue.enqueue(30);");
        System.out.println("System.out.println(queue.dequeue());");
        System.out.println("queue.enqueue(40);");
        System.out.println("System.out.println(queue.dequeue());");
        System.out.println("System.out.println(queue.peek());");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestQueueAs2Stacks<Integer> queue = new TestQueueAs2Stacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        int result1 = queue.dequeue();
        queue.enqueue(40);
        int result2 = queue.dequeue();
        int result3 = queue.peek();
        String actualOutput = result1 + "," + result2 + "," + result3;

        String explanation = """
                EXPLANATION:
                • Queue follows FIFO (First In, First Out) principle
                • QueueAs2Stacks uses two stacks to simulate queue behavior
                • enqueue() moves all elements to auxiliary stack, adds new element, moves back
                • This ensures the first element added is always at the top of main stack
                • dequeue() removes from main stack (which has oldest element on top)
                • Order: enqueue 10,20,30 → dequeue 10 → enqueue 40 → dequeue 20 → peek 30
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Excellent understanding of queue implementation!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question3() {
        totalQuestions++;
        System.out.println("QUESTION 3: Set Operations and Uniqueness");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("Set<String> set = new SetAsLinkedList<>();");
        System.out.println("System.out.println(set.add(\"apple\"));");
        System.out.println("System.out.println(set.add(\"banana\"));");
        System.out.println("System.out.println(set.add(\"apple\"));");
        System.out.println("System.out.println(set.size());");
        System.out.println("System.out.println(set.contains(\"banana\"));");
        System.out.println("System.out.println(set.remove(\"apple\"));");
        System.out.println("System.out.println(set.size());");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestSet<String> set = new TestSet<>();
        boolean result1 = set.add("apple");
        boolean result2 = set.add("banana");
        boolean result3 = set.add("apple");
        int result4 = set.size();
        boolean result5 = set.contains("banana");
        boolean result6 = set.remove("apple");
        int result7 = set.size();
        String actualOutput = result1 + "," + result2 + "," + result3 + "," +
                result4 + "," + result5 + "," + result6 + "," + result7;

        String explanation = """
                EXPLANATION:
                • Set is a collection that contains no duplicate elements
                • add() returns true if element was added, false if already present
                • Sets maintain uniqueness - adding "apple" twice only stores it once
                • contains() checks if element exists in the set
                • remove() returns true if element was removed, false if not found
                • size() returns the number of unique elements in the set
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Great understanding of set uniqueness properties!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question4() {
        totalQuestions++;
        System.out.println("QUESTION 4: Dynamic Array Resizing");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("List<Integer> list = new DynamicArray<>(2); // initial capacity 2");
        System.out.println("list.add(10);");
        System.out.println("list.add(20);");
        System.out.println("System.out.println(\"Size: \" + list.size());");
        System.out.println("list.add(30); // triggers resize");
        System.out.println("list.add(40);");
        System.out.println("System.out.println(\"Size: \" + list.size());");
        System.out.println("System.out.println(list.get(0) + \",\" + list.get(3));");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestDynamicArray<Integer> list = new TestDynamicArray<>(2);
        list.add(10);
        list.add(20);
        String result1 = "Size: " + list.size();
        list.add(30); // triggers resize
        list.add(40);
        String result2 = "Size: " + list.size();
        String result3 = list.get(0) + "," + list.get(3);
        String actualOutput = result1 + "," + result2 + "," + result3;

        String explanation = """
                EXPLANATION:
                • DynamicArray starts with initial capacity but can grow as needed
                • When capacity is exceeded, array is resized (usually doubled)
                • Elements are copied to new larger array, maintaining order
                • get() accesses elements by index (0-based)
                • Dynamic resizing allows unlimited additions while maintaining O(1) access
                • This is the foundation of ArrayList and similar collections
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Excellent understanding of dynamic array behavior!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question5() {
        totalQuestions++;
        System.out.println("QUESTION 5: Iterator Pattern Implementation");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("List<String> list = new DynamicArray<>();");
        System.out.println("list.add(\"A\");");
        System.out.println("list.add(\"B\");");
        System.out.println("list.add(\"C\");");
        System.out.println("Iterator<String> iter = list.iterator();");
        System.out.println("while(iter.hasNext()) {");
        System.out.println("    System.out.print(iter.next());");
        System.out.println("}");
        System.out.println("System.out.println();");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestDynamicArray<String> list = new TestDynamicArray<>(10);
        list.add("A");
        list.add("B");
        list.add("C");
        String actualOutput = "";
        for (int i = 0; i < list.size(); i++) {
            actualOutput += list.get(i);
        }

        String explanation = """
                EXPLANATION:
                • Iterator pattern provides a way to traverse collections without exposing structure
                • hasNext() returns true if there are more elements to iterate over
                • next() returns the next element and advances the iterator position
                • Iterator moves through elements in order: A, B, C
                • This pattern is fundamental to Java's for-each loops and collection traversal
                • Allows uniform access to different data structures (arrays, linked lists, etc.)
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Perfect understanding of iterator pattern!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question6() {
        totalQuestions++;
        System.out.println("QUESTION 6: Abstract Data Type Polymorphism");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("Queue<Integer> q1 = new QueueAsLinkedList<>();");
        System.out.println("Queue<Integer> q2 = new QueueAs2Stacks<>();");
        System.out.println("q1.enqueue(5);");
        System.out.println("q2.enqueue(5);");
        System.out.println("q1.enqueue(10);");
        System.out.println("q2.enqueue(10);");
        System.out.println("System.out.println(q1.dequeue() == q2.dequeue());");
        System.out.println("System.out.println(q1.peek() == q2.peek());");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestQueueAs2Stacks<Integer> q1 = new TestQueueAs2Stacks<>();
        TestQueueAs2Stacks<Integer> q2 = new TestQueueAs2Stacks<>();
        q1.enqueue(5);
        q2.enqueue(5);
        q1.enqueue(10);
        q2.enqueue(10);
        boolean result1 = (q1.dequeue().equals(q2.dequeue()));
        boolean result2 = (q1.peek().equals(q2.peek()));
        String actualOutput = result1 + "," + result2;

        String explanation = """
                EXPLANATION:
                • Both classes implement the same Queue interface with identical behavior
                • Abstract data types define what operations do, not how they're implemented
                • QueueAsLinkedList and QueueAs2Stacks have different internal implementations
                • But both follow FIFO ordering, so they produce identical results
                • This demonstrates polymorphism - same interface, different implementations
                • Client code works with either implementation transparently
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Excellent understanding of polymorphism and ADTs!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question7() {
        totalQuestions++;
        System.out.println("QUESTION 7: Complex Queue Operations");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("Queue<String> queue = new QueueAsLinkedList<>();");
        System.out.println("queue.enqueue(\"task1\");");
        System.out.println("queue.enqueue(\"task2\");");
        System.out.println("queue.enqueue(\"task3\");");
        System.out.println("System.out.println(\"Processing: \" + queue.dequeue());");
        System.out.println("queue.enqueue(\"task4\");");
        System.out.println("System.out.println(\"Next: \" + queue.peek());");
        System.out.println("System.out.println(\"Processing: \" + queue.dequeue());");
        System.out.println("System.out.println(\"Remaining: \" + (queue.isEmpty() ? 0 : \"some\"));");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestQueueAs2Stacks<String> queue = new TestQueueAs2Stacks<>();
        queue.enqueue("task1");
        queue.enqueue("task2");
        queue.enqueue("task3");
        String result1 = "Processing: " + queue.dequeue();
        queue.enqueue("task4");
        String result2 = "Next: " + queue.peek();
        String result3 = "Processing: " + queue.dequeue();
        String result4 = "Remaining: " + (queue.isEmpty() ? 0 : "some");
        String actualOutput = result1 + "," + result2 + "," + result3 + "," + result4;

        String explanation = """
                EXPLANATION:
                • Queue simulates a task processing system with FIFO ordering
                • enqueue() adds tasks to the back of the queue
                • dequeue() removes and processes tasks from the front
                • peek() shows the next task without removing it
                • After processing task1 and task2, task3 and task4 remain in queue
                • isEmpty() would return false since tasks remain, so output is "some"
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Outstanding understanding of queue applications!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void question8() {
        totalQuestions++;
        System.out.println("QUESTION 8: Generic Type Safety and Bounds");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("Stack<Integer> intStack = new StackAsDynamicArray<>();");
        System.out.println("Stack<String> strStack = new StackAsDynamicArray<>();");
        System.out.println("intStack.push(42);");
        System.out.println("strStack.push(\"hello\");");
        System.out.println("intStack.push(24);");
        System.out.println("strStack.push(\"world\");");
        System.out.println("System.out.println(intStack.pop() + strStack.pop());");
        System.out.println("System.out.println(intStack.peek() + \" \" + strStack.peek());");
        System.out.println("---");

        System.out.print("Your answer (separate lines with commas): ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        TestStack<Integer> intStack = new TestStack<>();
        TestStack<String> strStack = new TestStack<>();
        intStack.push(42);
        strStack.push("hello");
        intStack.push(24);
        strStack.push("world");
        String result1 = intStack.pop() + strStack.pop();
        String result2 = intStack.peek() + " " + strStack.peek();
        String actualOutput = result1 + "," + result2;

        String explanation = """
                EXPLANATION:
                • Generics provide compile-time type safety for collections
                • Stack<Integer> can only store Integer objects
                • Stack<String> can only store String objects
                • Type parameters prevent ClassCastException at runtime
                • String concatenation: integer 24 + string "world" = "24world"
                • Both stacks maintain their LIFO ordering independently
                • This demonstrates how generics enable type-safe collections
                """;

        System.out.println("Expected output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("CORRECT! Perfect mastery of generics and type safety!");
            score++;
        } else {
            System.out.println("Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showFinalResults() {
        System.out.println("\n=== STAGE 7 COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("Outstanding! You have mastered advanced data structures!");
        } else if (percentage >= 60) {
            System.out.println("Great work! You're developing strong data structure skills!");
        } else {
            System.out.println("Keep practicing! Advanced data structures require deep understanding!");
        }

        System.out.println("\nKey concepts covered in Stage 7:");
        System.out.println("• Abstract Data Types (ADTs) and interface design");
        System.out.println("• Stack implementation with LIFO behavior");
        System.out.println("• Queue implementations using different underlying structures");
        System.out.println("• Set operations and uniqueness constraints");
        System.out.println("• Dynamic array resizing and memory management");
        System.out.println("• Iterator pattern for collection traversal");
        System.out.println("• Polymorphism in data structure implementations");
        System.out.println("• Generic type safety and parameterized collections");

        System.out.println("\nAdvanced Data Structure Tips:");
        System.out.println("• Understand the contract of each ADT (Stack, Queue, Set, List)");
        System.out.println("• Know when to use each data structure based on access patterns");
        System.out.println("• Master the difference between interface and implementation");
        System.out.println("• Practice tracing through complex operations step by step");
        System.out.println("• Understand how generics provide compile-time type safety");
        System.out.println("• Learn to analyze time and space complexity of operations");

        System.out.println("\nThese concepts are from your oop abstract data structures folder!");
        System.out.println("Explore: Stack.java, Queue.java, Set.java, DynamicArray.java");
        System.out.println("Advanced: QueueAs2Stacks.java, Iterator implementations");
        System.out.println("\nCongratulations on mastering advanced Java data structures!");
        System.out.println("You're now ready for algorithm design and complex system architecture!");
    } // Helper classes for simulating the data structure examples

    static class TestStack<T> {
        private Object[] data;
        private int size;
        private int capacity;

        public TestStack() {
            capacity = 10;
            data = new Object[capacity];
            size = 0;
        }

        public void push(T element) {
            if (size >= capacity) {
                // Resize if needed
                Object[] newData = new Object[capacity * 2];
                for (int i = 0; i < size; i++) {
                    newData[i] = data[i];
                }
                data = newData;
                capacity *= 2;
            }
            data[size] = element;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty())
                throw new RuntimeException("Stack is empty");
            size--;
            return (T) data[size];
        }

        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty())
                throw new RuntimeException("Stack is empty");
            return (T) data[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    static class TestQueueAs2Stacks<T> {
        private TestStack<T> stack1;
        private TestStack<T> stack2;

        public TestQueueAs2Stacks() {
            stack1 = new TestStack<>();
            stack2 = new TestStack<>();
        }

        public void enqueue(T element) {
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            // Push new element to stack1
            stack1.push(element);
            // Move all elements back from stack2 to stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public T dequeue() {
            if (isEmpty())
                throw new RuntimeException("Queue is empty");
            return stack1.pop();
        }

        public T peek() {
            if (isEmpty())
                throw new RuntimeException("Queue is empty");
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    static class TestSet<T> {
        private Object[] data;
        private int size;
        private int capacity;

        public TestSet() {
            capacity = 10;
            data = new Object[capacity];
            size = 0;
        }

        public boolean add(T element) {
            if (contains(element)) {
                return false; // Already exists
            }
            if (size >= capacity) {
                // Resize if needed
                Object[] newData = new Object[capacity * 2];
                for (int i = 0; i < size; i++) {
                    newData[i] = data[i];
                }
                data = newData;
                capacity *= 2;
            }
            data[size] = element;
            size++;
            return true;
        }

        @SuppressWarnings("unchecked")
        public boolean contains(T element) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(element)) {
                    return true;
                }
            }
            return false;
        }

        @SuppressWarnings("unchecked")
        public boolean remove(T element) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(element)) {
                    // Shift elements left
                    for (int j = i; j < size - 1; j++) {
                        data[j] = data[j + 1];
                    }
                    size--;
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    static class TestDynamicArray<T> {
        private Object[] data;
        private int size;
        private int capacity;

        public TestDynamicArray(int initialCapacity) {
            capacity = initialCapacity;
            data = new Object[capacity];
            size = 0;
        }

        public void add(T element) {
            if (size >= capacity) {
                // Resize - double the capacity
                Object[] newData = new Object[capacity * 2];
                for (int i = 0; i < size; i++) {
                    newData[i] = data[i];
                }
                data = newData;
                capacity *= 2;
            }
            data[size] = element;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return (T) data[index];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
