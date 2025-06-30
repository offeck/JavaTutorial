import java.util.*;
import java.util.function.Supplier;

public class exam221b_stage {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - EXAM 221B STAGE ===");
        System.out.println("Welcome! These questions are inspired by the intro221b exam.");
        System.out.println();

        executeQuestion(createQuestion1());
        executeQuestion(createQuestion2());
        executeQuestion(createQuestion3());
        executeQuestion(createQuestion4());

        String[] concepts = {
                "Queue-based stack implementation",
                "Mergesort with lists",
                "Validation of gradual sequences",
                "Existence of gradual sequences via recursion"
        };

        String[] tips = {
                "Rotate queue elements after each push",
                "Divide then merge sorted halves",
                "Check adjacent differences carefully",
                "Consider base cases in recursive searches"
        };

        Question.showFinalResults(score, totalQuestions, "EXAM 221B STAGE", concepts, tips,
                "These problems mirror concepts from the exam solutions.",
                new String[] {}, new String[] {},
                "Excellent work reviewing these exam topics!");
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
                "StackAsQueue<Integer> st = new StackAsQueue<>();",
                "st.push(1);",
                "st.push(2);",
                "System.out.println(st.pop());",
                "st.push(3);",
                "System.out.println(st.pop());"
        };

        Supplier<String> exec = () -> {
            StackAsQueue<Integer> st = new StackAsQueue<>();
            st.push(1);
            st.push(2);
            int r1 = st.pop();
            st.push(3);
            int r2 = st.pop();
            return r1 + "," + r2;
        };

        String explanation = "EXPLANATION: push rotates the queue so the last pushed element becomes first. " +
                "After pushing 1 and 2, pop returns 2. Pushing 3 then popping returns 3.";

        return new Question("Queue-backed Stack", code, exec, explanation, "Your answer (comma separated): ");
    }

    private static Question createQuestion2() {
        String[] code = {
                "java.util.List<Integer> nums = java.util.Arrays.asList(3,1,4,2);",
                "System.out.println(sort(nums));"
        };

        Supplier<String> exec = () -> {
            java.util.List<Integer> nums = java.util.Arrays.asList(3, 1, 4, 2);
            java.util.List<Integer> result = sort(nums);
            return result.toString();
        };

        String explanation = "EXPLANATION: split divides the list alternately and merge combines sorted halves. " +
                "Sorting [3,1,4,2] yields [1,2,3,4].";

        return new Question("List Merge Sort", code, exec, explanation);
    }

    private static Question createQuestion3() {
        String[] code = {
                "int[] arr = {0,1,2};",
                "System.out.println(isGradual(arr, 3));"
        };

        Supplier<String> exec = () -> String.valueOf(isGradual(new int[] { 0, 1, 2 }, 3));

        String explanation = "EXPLANATION: Each step changes by at most 1 and the sum equals 3, so the sequence is gradual.";

        return new Question("Check Gradual Sequence", code, exec, explanation);
    }

    private static Question createQuestion4() {
        String[] code = {
                "System.out.println(existGradual(2, 1));"
        };

        Supplier<String> exec = () -> String.valueOf(existGradual(2, 1));

        String explanation = "EXPLANATION: There exists a gradual sequence of length 2 that sums to 1 (0,1).";

        return new Question("Gradual Sequence Exists", code, exec, explanation);
    }

    // ===== Helper methods and classes =====

    static class StackAsQueue<T> {
        private LinkedList<T> q = new LinkedList<>();
        private int size = 0;

        boolean isEmpty() {
            return q.isEmpty();
        }

        T peek() {
            if (isEmpty())
                throw new NoSuchElementException();
            return q.peek();
        }

        T pop() {
            if (isEmpty())
                throw new NoSuchElementException();
            size--;
            return q.removeFirst();
        }

        void push(T element) {
            q.addLast(element);
            for (int i = 0; i < size; i++) {
                q.addLast(q.removeFirst());
            }
            size++;
        }
    }

    private static java.util.LinkedList<Integer>[] split(java.util.List<Integer> elements) {
        java.util.LinkedList<Integer>[] answer = new java.util.LinkedList[2];
        answer[0] = new java.util.LinkedList<Integer>();
        answer[1] = new java.util.LinkedList<Integer>();
        Iterator<Integer> it = elements.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i % 2 == 0)
                answer[0].add(it.next());
            else
                answer[1].add(it.next());
            i++;
        }
        return answer;
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> answer = new LinkedList<>();
        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();
        Integer next1 = null;
        Integer next2 = null;
        if (it1.hasNext())
            next1 = it1.next();
        if (it2.hasNext())
            next2 = it2.next();
        while (next1 != null || next2 != null) {
            boolean inc1 = false;
            if (next1 == null) {
                answer.add(next2);
            } else if (next2 == null) {
                answer.add(next1);
                inc1 = true;
            } else if (next1.compareTo(next2) < 0) {
                answer.add(next1);
                inc1 = true;
            } else {
                answer.add(next2);
            }
            if (inc1) {
                if (it1.hasNext())
                    next1 = it1.next();
                else
                    next1 = null;
            } else {
                if (it2.hasNext())
                    next2 = it2.next();
                else
                    next2 = null;
            }
        }
        return answer;
    }

    public static List<Integer> sort(java.util.List<Integer> elements) {
        List<Integer> answer;
        if (elements.size() == 0) {
            answer = new LinkedList<>();
        } else if (elements.size() == 1) {
            answer = new LinkedList<>();
            answer.add(elements.get(0));
        } else {
            java.util.LinkedList<Integer>[] split = split(elements);
            answer = merge(sort(split[0]), sort(split[1]));
        }
        return answer;
    }

    private static boolean isGradual(int[] array, int sum) {
        boolean ans = array[0] == 0;
        for (int i = 1; i < array.length && ans; i++) {
            int diff = array[i] - array[i - 1];
            boolean abs = diff <= 1 && diff >= -1;
            ans = ans && abs;
            sum = sum - array[i];
        }
        return ans && sum == 0;
    }

    public static boolean existGradual(int n, int sum) {
        return existGradual(n, sum, 0);
    }

    private static boolean existGradual(int n, int sum, int num) {
        if (n == 1)
            return sum == 0;
        return existGradual(n - 1, sum - num, num) ||
                existGradual(n - 1, sum - (num - 1), num - 1) ||
                existGradual(n - 1, sum - (num + 1), num + 1);
    }
}
