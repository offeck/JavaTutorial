import java.util.Scanner;

public class warmup {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - WARMUP ===");
        System.out.println("Welcome to the Java Code Guessing Game!");
        System.out.println("You'll see Java code snippets and need to guess their output.");
        System.out.println("After each guess, you'll see the actual output and explanation.");
        System.out.println("Let's start!\n");

        // Question 1: Basic arithmetic and operator precedence
        question1();

        // Question 2: String concatenation vs addition
        question2();

        // Question 3: Variable scope and initialization
        question3();

        // Question 4: Loop behavior
        question4();

        // Question 5: Array indexing
        question5();

        // Show final results
        showFinalResults();
    }

    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1:");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("int a = 10;");
        System.out.println("int b = 3;");
        System.out.println("System.out.println(a + b * 2);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution
        int a = 10;
        int b = 3;
        int result = a + b * 2;
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Due to operator precedence, multiplication happens first: 3 * 2 = 6, then 10 + 6 = 16");
    }

    private static void question2() {
        totalQuestions++;
        System.out.println("\nQUESTION 2:");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("System.out.println(\"5\" + 3 + 2);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution
        String actualOutput = "5" + 3 + 2;

        checkAnswer(userGuess, actualOutput,
                "Explanation: String concatenation is left-to-right. \"5\" + 3 becomes \"53\", then \"53\" + 2 becomes \"532\"");
    }

    private static void question3() {
        totalQuestions++;
        System.out.println("\nQUESTION 3:");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("int x = 5;");
        System.out.println("if (x > 3) {");
        System.out.println("    int y = x * 2;");
        System.out.println("}");
        System.out.println("System.out.println(x);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution
        int x = 5;
        if (x > 3) {
            int y = x * 2;
        }
        String actualOutput = String.valueOf(x);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Variable y is only in scope within the if block. We print x, which remains 5. y is not accessible outside the block.");
    }

    private static void question4() {
        totalQuestions++;
        System.out.println("\nQUESTION 4:");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("for (int i = 0; i < 3; i++) {");
        System.out.println("    if (i == 1) continue;");
        System.out.println("    System.out.print(i + \" \");");
        System.out.println("}");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i == 1)
                continue;
            output.append(i).append(" ");
        }
        String actualOutput = output.toString().trim();

        checkAnswer(userGuess, actualOutput,
                "Explanation: The loop runs i = 0, 1, 2. When i = 1, 'continue' skips the print statement. So only 0 and 2 are printed.");
    }

    private static void question5() {
        totalQuestions++;
        System.out.println("\nQUESTION 5:");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("int[] numbers = {10, 20, 30};");
        System.out.println("System.out.println(numbers[1] + numbers.length);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution
        int[] numbers = { 10, 20, 30 };
        int result = numbers[1] + numbers.length;
        String actualOutput = String.valueOf(result);

        checkAnswer(userGuess, actualOutput,
                "Explanation: numbers[1] is 20 (second element), numbers.length is 3. So 20 + 3 = 23");
    }

    private static void checkAnswer(String userGuess, String actualOutput, String explanation) {
        System.out.println("\nActual output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Well done!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showFinalResults() {
        System.out.println("\n=== WARMUP COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("🎉 Excellent! You have a great understanding of Java basics!");
        } else if (percentage >= 60) {
            System.out.println("👍 Good job! You're getting the hang of it!");
        } else {
            System.out.println("🤔 Keep practicing! These concepts will become clearer with time.");
        }

        System.out.println("\nKey concepts covered in Warmup:");
        System.out.println("• Operator precedence");
        System.out.println("• String concatenation vs numeric addition");
        System.out.println("• Variable scope");
        System.out.println("• Loop control flow (continue statement)");
        System.out.println("• Array indexing and length property");

        System.out.println("\nTip: Try running this code in your IDE and experiment with modifications!");
        System.out.println("\nNext: Look for stage_2.java for prime algorithms and arrays!");
    }
}