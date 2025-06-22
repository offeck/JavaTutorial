import java.util.Scanner;

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
        question1();

        // Question 2: Recursive factorial
        question2();

        // Question 3: Palindrome checking
        question3();

        // Question 4: String reversal recursion
        question4();

        // Question 5: Subset sum problem
        question5();

        // Show final results
        showFinalResults();
    }

    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1: Recursive Power Function");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public static int exp(int a, int b) {");
        System.out.println("    int result;");
        System.out.println("    if(b == 0)");
        System.out.println("        result = 1;");
        System.out.println("    else");
        System.out.println("        result = a * exp(a, b-1);");
        System.out.println("    return result;");
        System.out.println("}");
        System.out.println("// Function call:");
        System.out.println("System.out.println(exp(3, 2));");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Power.java
        int result = exp(3, 2);
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: exp(3,2) = 3 * exp(3,1) = 3 * (3 * exp(3,0)) = 3 * (3 * 1) = 9. Recursive calls: exp(3,2)→exp(3,1)→exp(3,0)→1.");
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

    private static void question2() {
        totalQuestions++;
        System.out.println("\nQUESTION 2: Recursive Factorial");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public static int factorial(int n) {");
        System.out.println("    int output;");
        System.out.println("    if (n==0)");
        System.out.println("        output = 1;");
        System.out.println("    else");
        System.out.println("        output = n * factorial(n-1);");
        System.out.println("    return output;");
        System.out.println("}");
        System.out.println("// Function call:");
        System.out.println("System.out.println(factorial(4));");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Recursions1.java
        int result = factorial(4);
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: factorial(4) = 4 * factorial(3) = 4 * (3 * factorial(2)) = 4 * (3 * (2 * factorial(1))) = 4 * (3 * (2 * (1 * factorial(0)))) = 4 * 3 * 2 * 1 * 1 = 24.");
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

    private static void question3() {
        totalQuestions++;
        System.out.println("\nQUESTION 3: Recursive Palindrome Check");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public static boolean isPalindrome(String s) {");
        System.out.println("    boolean ans;");
        System.out.println("    if(s.length() == 0 || s.length() == 1)");
        System.out.println("        ans = true;");
        System.out.println("    else if (s.charAt(0) != s.charAt(s.length() - 1))");
        System.out.println("        ans = false;");
        System.out.println("    else");
        System.out.println("        ans = isPalindrome(s.substring(1, s.length() - 1));");
        System.out.println("    return ans;");
        System.out.println("}");
        System.out.println("// Function call:");
        System.out.println("System.out.println(isPalindrome(\"aba\"));");
        System.out.println("---");

        System.out.print("Your guess (true/false): ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from IsPalindrom.java
        boolean result = isPalindrome("aba");
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: isPalindrome(\"aba\") checks 'a'=='a' (true), then calls isPalindrome(\"b\"). Since \"b\" has length 1, it returns true. So \"aba\" is a palindrome.");
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

    private static void question4() {
        totalQuestions++;
        System.out.println("\nQUESTION 4: Recursive String Reversal");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public static String reverse(String s){");
        System.out.println("    String output;");
        System.out.println("    if (s.length() == 0)");
        System.out.println("        output = s;");
        System.out.println("    else");
        System.out.println("        output = reverse(s.substring(1))+s.charAt(0);");
        System.out.println("    return output;");
        System.out.println("}");
        System.out.println("// Function call:");
        System.out.println("System.out.println(reverse(\"abc\"));");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Recursions2.java
        String result = reverse("abc");
        String actualOutput = result;

        checkAnswer(userGuess, actualOutput,
                "Explanation: reverse(\"abc\") = reverse(\"bc\") + 'a' = (reverse(\"c\") + 'b') + 'a' = ((reverse(\"\") + 'c') + 'b') + 'a' = ((\"\" + 'c') + 'b') + 'a' = \"cba\".");
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

    private static void question5() {
        totalQuestions++;
        System.out.println("\nQUESTION 5: Subset Sum Recursion");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("public static boolean subsetSum(int[] weights, int sum, int i){");
        System.out.println("    boolean ans;");
        System.out.println("    if(sum == 0)");
        System.out.println("        ans = true;");
        System.out.println("    else if(sum < 0 || i >= weights.length)");
        System.out.println("        ans = false;");
        System.out.println("    else");
        System.out.println("        ans = subsetSum(weights, sum - weights[i], i + 1) ||");
        System.out.println("              subsetSum(weights, sum, i + 1);");
        System.out.println("    return ans;");
        System.out.println("}");
        System.out.println("// Function call:");
        System.out.println("int[] arr = {2, 3, 5};");
        System.out.println("System.out.println(subsetSum(arr, 5, 0));");
        System.out.println("---");

        System.out.print("Your guess (true/false): ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from SubsetSum.java
        int[] arr = { 2, 3, 5 };
        boolean result = subsetSum(arr, 5, 0);
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: subsetSum tries two paths: include arr[0]=2 (check sum 3 from index 1) or exclude it (check sum 5 from index 1). Eventually finds that arr[2]=5 matches the target sum exactly.");
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

    private static void checkAnswer(String userGuess, String actualOutput, String explanation) {
        System.out.println("\nActual output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Excellent recursive thinking!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showFinalResults() {
        System.out.println("\n=== STAGE 4 COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("🎉 Magnificent! You have mastered recursive thinking!");
        } else if (percentage >= 60) {
            System.out.println("👍 Excellent work! You're developing strong recursive intuition!");
        } else {
            System.out
                    .println("🤔 Keep practicing! Recursion takes time to master - it's a different way of thinking!");
        }

        System.out.println("\nKey concepts covered in Stage 4:");
        System.out.println("• Recursive function calls and stack frames");
        System.out.println("• Base cases and termination conditions");
        System.out.println("• Mathematical recursion (power, factorial)");
        System.out.println("• String manipulation with recursion");
        System.out.println("• Advanced recursion (subset sum, backtracking)");
        System.out.println("• Call stack visualization and tracing");

        System.out.println("\nRecursion Debugging Tips:");
        System.out.println("• Always identify the base case first");
        System.out.println("• Trace recursive calls step by step");
        System.out.println("• Understand what each recursive call returns");
        System.out.println("• Practice drawing the call stack");
        System.out.println("• Think about the problem size getting smaller");

        System.out.println("\nThese algorithms are from your recursion folder!");
        System.out.println("Explore: Power.java, IsPalindrom.java, Recursions1.java, Recursions2.java, SubsetSum.java");
        System.out.println("\nCongratulations on completing all stages of the Java Debugging Game!");
        System.out.println("You've mastered: Basic Java → Algorithms → Functions → Recursion!");
    }
}
