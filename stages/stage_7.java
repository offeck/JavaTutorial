import java.util.Scanner;
import java.util.function.Supplier;

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

        // Create and execute all questions
        executeQuestion(createQuestion1());
        executeQuestion(createQuestion2());
        executeQuestion(createQuestion3());
        executeQuestion(createQuestion4());
        executeQuestion(createQuestion5());
        executeQuestion(createQuestion6());
        executeQuestion(createQuestion7());
        executeQuestion(createQuestion8());

        // Show final results
        String[] keyConcepts = {
                "Abstract Data Types (ADTs) and interface design",
                "Stack implementation with LIFO behavior",
                "Queue implementations using different underlying structures",
                "Set operations and uniqueness constraints",
                "Dynamic array resizing and memory management",
                "Iterator pattern for collection traversal",
                "Polymorphism in data structure implementations",
                "Generic type safety and parameterized collections"
        };

        String[] tips = {
                "Understand the contract of each ADT (Stack, Queue, Set, List)",
                "Know when to use each data structure based on access patterns",
                "Master the difference between interface and implementation",
                "Practice tracing through complex operations step by step",
                "Understand how generics provide compile-time type safety",
                "Learn to analyze time and space complexity of operations"
        };

        String[] exploreFiles = {
                "Stack.java", "Queue.java", "Set.java", "DynamicArray.java"
        };

        String[] advancedFiles = {
                "QueueAs2Stacks.java", "Iterator implementations"
        };

        Question.showFinalResults(score, totalQuestions, "STAGE 7", keyConcepts, tips,
                "These concepts are from your oop abstract data structures folder!",
                exploreFiles, advancedFiles,
                "Congratulations on mastering advanced Java data structures!\nYou're now ready for algorithm design and complex system architecture!");
    }

    private static void executeQuestion(Question question) {
        totalQuestions++;
        question.execute(scanner, totalQuestions);
        // Score is updated within the Question class
        if (question.wasCorrect()) {
            score++;
        }
    }

    private static Question createQuestion1() {
        String[] code = {
                "Stack<String> stack = new StackAsDynamicArray<>();",
                "stack.push(\"first\");",
                "stack.push(\"second\");",
                "stack.push(\"third\");",
                "System.out.println(stack.pop());",
                "System.out.println(stack.peek());",
                "stack.push(\"fourth\");",
                "System.out.println(stack.pop());",
                "System.out.println(stack.pop());"
        };

        Supplier<String> execution = () -> {
            TestStack<String> stack = new TestStack<>();
            stack.push("first");
            stack.push("second");
            stack.push("third");
            String result1 = stack.pop();
            String result2 = stack.peek();
            stack.push("fourth");
            String result3 = stack.pop();
            String result4 = stack.pop();
            return result1 + "," + result2 + "," + result3 + "," + result4;
        };

        String explanation = "EXPLANATION: Stack follows LIFO (Last In, First Out) principle. push() adds elements to the top, pop() removes and returns the top element, peek() returns the top element without removing it. Order: push \"first\", push \"second\", push \"third\" → pop() returns \"third\", peek() shows \"second\" (still on stack) → push \"fourth\", pop() returns \"fourth\", pop() returns \"second\".";

        return new Question("Stack LIFO Operations", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    private static Question createQuestion2() {
        String[] code = {
                "// Queue implemented using two stacks",
                "Queue<Integer> queue = new QueueAs2Stacks<>();",
                "queue.enqueue(10);",
                "queue.enqueue(20);",
                "queue.enqueue(30);",
                "System.out.println(queue.dequeue());",
                "queue.enqueue(40);",
                "System.out.println(queue.dequeue());",
                "System.out.println(queue.peek());"
        };

        Supplier<String> execution = () -> {
            TestQueueAs2Stacks<Integer> queue = new TestQueueAs2Stacks<>();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            int result1 = queue.dequeue();
            queue.enqueue(40);
            int result2 = queue.dequeue();
            int result3 = queue.peek();
            return result1 + "," + result2 + "," + result3;
        };

        String explanation = "EXPLANATION: Queue follows FIFO (First In, First Out) principle. QueueAs2Stacks uses two stacks to simulate queue behavior. enqueue() moves all elements to auxiliary stack, adds new element, moves back. This ensures the first element added is always at the top of main stack. dequeue() removes from main stack (which has oldest element on top). Order: enqueue 10,20,30 → dequeue 10 → enqueue 40 → dequeue 20 → peek 30.";

        return new Question("Queue Using Two Stacks", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    private static Question createQuestion3() {
        String[] code = {
                "Set<String> set = new SetAsLinkedList<>();",
                "System.out.println(set.add(\"apple\"));",
                "System.out.println(set.add(\"banana\"));",
                "System.out.println(set.add(\"apple\"));",
                "System.out.println(set.size());",
                "System.out.println(set.contains(\"banana\"));",
                "System.out.println(set.remove(\"apple\"));",
                "System.out.println(set.size());"
        };

        Supplier<String> execution = () -> {
            TestSet<String> set = new TestSet<>();
            boolean result1 = set.add("apple");
            boolean result2 = set.add("banana");
            boolean result3 = set.add("apple");
            int result4 = set.size();
            boolean result5 = set.contains("banana");
            boolean result6 = set.remove("apple");
            int result7 = set.size();
            return result1 + "," + result2 + "," + result3 + "," +
                    result4 + "," + result5 + "," + result6 + "," + result7;
        };

        String explanation = "EXPLANATION: Set is a collection that contains no duplicate elements. add() returns true if element was added, false if already present. Sets maintain uniqueness - adding \"apple\" twice only stores it once. contains() checks if element exists in the set. remove() returns true if element was removed, false if not found. size() returns the number of unique elements in the set.";

        return new Question("Set Operations and Uniqueness", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    private static Question createQuestion4() {
        String[] code = {
                "List<Integer> list = new DynamicArray<>(2); // initial capacity 2",
                "list.add(10);",
                "list.add(20);",
                "System.out.println(\"Size: \" + list.size());",
                "list.add(30); // triggers resize",
                "list.add(40);",
                "System.out.println(\"Size: \" + list.size());",
                "System.out.println(list.get(0) + \",\" + list.get(3));"
        };

        Supplier<String> execution = () -> {
            TestDynamicArray<Integer> list = new TestDynamicArray<>(2);
            list.add(10);
            list.add(20);
            String result1 = "Size: " + list.size();
            list.add(30);
            list.add(40);
            String result2 = "Size: " + list.size();
            String result3 = list.get(0) + "," + list.get(3);
            return result1 + "," + result2 + "," + result3;
        };

        String explanation = "EXPLANATION: DynamicArray starts with initial capacity but can grow as needed. When capacity is exceeded, array is resized (usually doubled). Elements are copied to new larger array, maintaining order. get() accesses elements by index (0-based). Dynamic resizing allows unlimited additions while maintaining O(1) access. This is the foundation of ArrayList and similar collections.";

        return new Question("Dynamic Array Resizing", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    private static Question createQuestion5() {
        String[] code = {
                "List<String> list = new DynamicArray<>();",
                "list.add(\"A\");",
                "list.add(\"B\");",
                "list.add(\"C\");",
                "Iterator<String> iter = list.iterator();",
                "while(iter.hasNext()) {",
                "    System.out.print(iter.next());",
                "}",
                "System.out.println();"
        };

        Supplier<String> execution = () -> {
            TestDynamicArray<String> list = new TestDynamicArray<>(10);
            list.add("A");
            list.add("B");
            list.add("C");
            String actualOutput = "";
            for (int i = 0; i < list.size(); i++) {
                actualOutput += list.get(i);
            }
            return actualOutput;
        };

        String explanation = "EXPLANATION: Iterator pattern provides a way to traverse collections without exposing structure. hasNext() returns true if there are more elements to iterate over. next() returns the next element and advances the iterator position. Iterator moves through elements in order: A, B, C. This pattern is fundamental to Java's for-each loops and collection traversal. Allows uniform access to different data structures (arrays, linked lists, etc.).";

        return new Question("Iterator Pattern Implementation", code, execution, explanation);
    }

    private static Question createQuestion6() {
        String[] code = {
                "Queue<Integer> q1 = new QueueAsLinkedList<>();",
                "Queue<Integer> q2 = new QueueAs2Stacks<>();",
                "q1.enqueue(5);",
                "q2.enqueue(5);",
                "q1.enqueue(10);",
                "q2.enqueue(10);",
                "System.out.println(q1.dequeue() == q2.dequeue());",
                "System.out.println(q1.peek() == q2.peek());"
        };

        Supplier<String> execution = () -> {
            TestQueueAs2Stacks<Integer> q1 = new TestQueueAs2Stacks<>();
            TestQueueAs2Stacks<Integer> q2 = new TestQueueAs2Stacks<>();
            q1.enqueue(5);
            q2.enqueue(5);
            q1.enqueue(10);
            q2.enqueue(10);
            boolean result1 = (q1.dequeue().equals(q2.dequeue()));
            boolean result2 = (q1.peek().equals(q2.peek()));
            return result1 + "," + result2;
        };

        String explanation = "EXPLANATION: Both classes implement the same Queue interface with identical behavior. Abstract data types define what operations do, not how they're implemented. QueueAsLinkedList and QueueAs2Stacks have different internal implementations. But both follow FIFO ordering, so they produce identical results. This demonstrates polymorphism - same interface, different implementations. Client code works with either implementation transparently.";

        return new Question("Abstract Data Type Polymorphism", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    private static Question createQuestion7() {
        String[] code = {
                "Queue<String> queue = new QueueAsLinkedList<>();",
                "queue.enqueue(\"task1\");",
                "queue.enqueue(\"task2\");",
                "queue.enqueue(\"task3\");",
                "System.out.println(\"Processing: \" + queue.dequeue());",
                "queue.enqueue(\"task4\");",
                "System.out.println(\"Next: \" + queue.peek());",
                "System.out.println(\"Processing: \" + queue.dequeue());",
                "System.out.println(\"Remaining: \" + (queue.isEmpty() ? 0 : \"some\"));"
        };

        Supplier<String> execution = () -> {
            TestQueueAs2Stacks<String> queue = new TestQueueAs2Stacks<>();
            queue.enqueue("task1");
            queue.enqueue("task2");
            queue.enqueue("task3");
            String result1 = "Processing: " + queue.dequeue();
            queue.enqueue("task4");
            String result2 = "Next: " + queue.peek();
            String result3 = "Processing: " + queue.dequeue();
            String result4 = "Remaining: " + (queue.isEmpty() ? 0 : "some");
            return result1 + "," + result2 + "," + result3 + "," + result4;
        };

        String explanation = "EXPLANATION: Queue simulates a task processing system with FIFO ordering. enqueue() adds tasks to the back of the queue. dequeue() removes and processes tasks from the front. peek() shows the next task without removing it. After processing task1 and task2, task3 and task4 remain in queue. isEmpty() would return false since tasks remain, so output is \"some\".";

        return new Question("Complex Queue Operations", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    private static Question createQuestion8() {
        String[] code = {
                "Stack<Integer> intStack = new StackAsDynamicArray<>();",
                "Stack<String> strStack = new StackAsDynamicArray<>();",
                "intStack.push(42);",
                "strStack.push(\"hello\");",
                "intStack.push(24);",
                "strStack.push(\"world\");",
                "System.out.println(intStack.pop() + strStack.pop());",
                "System.out.println(intStack.peek() + \" \" + strStack.peek());"
        };

        Supplier<String> execution = () -> {
            TestStack<Integer> intStack = new TestStack<>();
            TestStack<String> strStack = new TestStack<>();
            intStack.push(42);
            strStack.push("hello");
            intStack.push(24);
            strStack.push("world");
            String result1 = intStack.pop() + strStack.pop();
            String result2 = intStack.peek() + " " + strStack.peek();
            return result1 + "," + result2;
        };

        String explanation = "EXPLANATION: Generics provide compile-time type safety for collections. Stack<Integer> can only store Integer objects. Stack<String> can only store String objects. Type parameters prevent ClassCastException at runtime. String concatenation: integer 24 + string \"world\" = \"24world\". Both stacks maintain their LIFO ordering independently. This demonstrates how generics enable type-safe collections.";

        return new Question("Generic Type Safety and Bounds", code, execution, explanation,
                "Your answer (separate lines with commas): ");
    }

    // Helper classes for simulating the data structure examples

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

        public boolean contains(T element) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(element)) {
                    return true;
                }
            }
            return false;
        }

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
