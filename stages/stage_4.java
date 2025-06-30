import java.util.Scanner;
import java.util.function.Supplier;

public class stage_4 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 4 ===");
        System.out.println("Welcome to Stage 4: Recursion Mastery!");
        System.out.println("This stage focuses on understanding recursive algorithms and their execution flow.");
        System.out.println("Think carefully about base cases and recursive calls!\n");

        // Question 1: Simple recursive power
        executeQuestion(createQuestion1());

        // Question 2: Recursive factorial
        executeQuestion(createQuestion2());

        // Question 3: Palindrome checking
        executeQuestion(createQuestion3());

        // Question 4: String reversal recursion
        executeQuestion(createQuestion4());

        // Question 5: Subset sum problem
        executeQuestion(createQuestion5());

        // Show final results
        String[] keyConcepts = {
                "Recursive function calls and stack frames",
                "Base cases and termination conditions",
                "Mathematical recursion (power, factorial)",
                "String manipulation with recursion",
                "Advanced recursion (subset sum, backtracking)",
                "Call stack visualization and tracing"
        };

        String[] tips = {
                "Always identify the base case first",
                "Trace recursive calls step by step",
                "Understand what each recursive call returns",
                "Practice drawing the call stack",
                "Think about the problem size getting smaller"
        };

        String[] exploreFiles = {
                "Power.java", "IsPalindrom.java", "Recursions1.java", "Recursions2.java", "SubsetSum.java"
        };

        String[] advancedFiles = {};

        Question.showFinalResults(score, totalQuestions, "STAGE 4", keyConcepts, tips,
                "These algorithms are from your recursion folder!",
                exploreFiles, advancedFiles,
                "Congratulations on completing all stages of the Java Debugging Game!\nYou've mastered: Basic Java → Algorithms → Functions → Recursion!");
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
                "public static int exp(int a, int b) {",
                "    int result;",
                "    if(b == 0)",
                "        result = 1;",
                "    else",
                "        result = a * exp(a, b-1);",
                "    return result;",
                "}",
                "// Function call:",
                "System.out.println(exp(3, 2));"
        };

        Supplier<String> execution = () -> String.valueOf(exp(3, 2));

        String explanation = "Explanation: exp(3,2) = 3 * exp(3,1) = 3 * (3 * exp(3,0)) = 3 * (3 * 1) = 9. Recursive calls: exp(3,2)→exp(3,1)→exp(3,0)→1.";

        return new Question("Recursive Power Function", code, execution, explanation, "Your guess: ");
    }

    // Helper method for exp function
    public static int exp(int a, int b) {
        int result;
        if (b == 0)
            result = 1;
        else
            result = a * exp(a, b - 1);
        return result;
    }

    private static Question createQuestion2() {
        String[] code = {
                "public static int factorial(int n) {",
                "    int output;",
                "    if (n==0)",
                "        output = 1;",
                "    else",
                "        output = n * factorial(n-1);",
                "    return output;",
                "}",
                "// Function call:",
                "System.out.println(factorial(4));"
        };

        Supplier<String> execution = () -> String.valueOf(factorial(4));

        String explanation = "Explanation: factorial(4) = 4 * factorial(3) = 4 * (3 * factorial(2)) = 4 * (3 * (2 * factorial(1))) = 4 * (3 * (2 * (1 * factorial(0)))) = 4 * 3 * 2 * 1 * 1 = 24.";

        return new Question("Recursive Factorial", code, execution, explanation, "Your guess: ");
    }

    // Helper method for factorial function
    public static int factorial(int n) {
        int output;
        if (n == 0)
            output = 1;
        else
            output = n * factorial(n - 1);
        return output;
    }

    private static Question createQuestion3() {
        String[] code = {
                "public static boolean isPalindrome(String s) {",
                "    boolean ans;",
                "    if(s.length() == 0 || s.length() == 1)",
                "        ans = true;",
                "    else if (s.charAt(0) != s.charAt(s.length() - 1))",
                "        ans = false;",
                "    else",
                "        ans = isPalindrome(s.substring(1, s.length() - 1));",
                "    return ans;",
                "}",
                "// Function call:",
                "System.out.println(isPalindrome(\"aba\"));"
        };

        Supplier<String> execution = () -> String.valueOf(isPalindrome("aba"));

        String explanation = "Explanation: isPalindrome(\"aba\") checks 'a'=='a' (true), then calls isPalindrome(\"b\"). Since \"b\" has length 1, it returns true. So \"aba\" is a palindrome.";

        return new Question("Recursive Palindrome Check", code, execution, explanation, "Your guess (true/false): ");
    }

    // Helper method for palindrome function
    public static boolean isPalindrome(String s) {
        boolean ans;
        if (s.length() == 0 || s.length() == 1)
            ans = true;
        else if (s.charAt(0) != s.charAt(s.length() - 1))
            ans = false;
        else
            ans = isPalindrome(s.substring(1, s.length() - 1));
        return ans;
    }

    private static Question createQuestion4() {
        String[] code = {
                "public static String reverse(String s){",
                "    String output;",
                "    if (s.length() == 0)",
                "        output = s;",
                "    else",
                "        output = reverse(s.substring(1))+s.charAt(0);",
                "    return output;",
                "}",
                "// Function call:",
                "System.out.println(reverse(\"abc\"));"
        };

        Supplier<String> execution = () -> reverse("abc");

        String explanation = "Explanation: reverse(\"abc\") = reverse(\"bc\") + 'a' = (reverse(\"c\") + 'b') + 'a' = ((reverse(\"\") + 'c') + 'b') + 'a' = ((\"\" + 'c') + 'b') + 'a' = \"cba\".";

        return new Question("Recursive String Reversal", code, execution, explanation, "Your guess: ");
    }

    // Helper method for reverse function
    public static String reverse(String s) {
        String output;
        if (s.length() == 0)
            output = s;
        else
            output = reverse(s.substring(1)) + s.charAt(0);
        return output;
    }

    private static Question createQuestion5() {
        String[] code = {
                "public static boolean subsetSum(int[] weights, int sum, int i){",
                "    boolean ans;",
                "    if(sum == 0)",
                "        ans = true;",
                "    else if(sum < 0 || i >= weights.length)",
                "        ans = false;",
                "    else",
                "        ans = subsetSum(weights, sum - weights[i], i + 1) ||",
                "              subsetSum(weights, sum, i + 1);",
                "    return ans;",
                "}",
                "// Function call:",
                "int[] arr = {2, 3, 5};",
                "System.out.println(subsetSum(arr, 5, 0));"
        };

        Supplier<String> execution = () -> String.valueOf(subsetSum(new int[]{2,3,5}, 5, 0));

        String explanation = "Explanation: subsetSum tries two paths: include arr[0]=2 (check sum 3 from index 1) or exclude it (check sum 5 from index 1). Eventually finds that arr[2]=5 matches the target sum exactly.";

        return new Question("Subset Sum Recursion", code, execution, explanation, "Your guess (true/false): ");
    }

    // Helper method for subset sum function
    public static boolean subsetSum(int[] weights, int sum, int i) {
        boolean ans;
        if (sum == 0)
            ans = true;
        else if (sum < 0 || i >= weights.length)
            ans = false;
        else
            ans = subsetSum(weights, sum - weights[i], i + 1) || subsetSum(weights, sum, i + 1);
        return ans;
    }

}
