import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Interactive Question Framework for Java Tutorial Stages
 * 
 * The Question class provides a comprehensive framework for creating
 * interactive
 * Java debugging and comprehension exercises. It encapsulates all necessary
 * data
 * and logic for presenting coding challenges, capturing user responses,
 * validating
 * answers, and providing educational feedback.
 * 
 * <h2>Design Philosophy</h2>
 * This class follows the principle of encapsulation to create reusable,
 * maintainable
 * question components that can be easily integrated into any stage of the
 * tutorial
 * system. The use of functional interfaces (Supplier) allows for flexible code
 * simulation without requiring actual compilation.
 * 
 * <h2>Usage Pattern</h2>
 * 
 * <pre>
 * {@code
 * // Create a question
 * Question q1 = new Question(
 *         "Variable Assignment",
 *         new String[] { "int x = 5;", "System.out.println(x);" },
 *         () -> "5",
 *         "This demonstrates basic variable output.");
 * 
 * // Execute the question
 * Scanner scanner = new Scanner(System.in);
 * q1.execute(scanner, 1);
 * 
 * // Check if correct for scoring
 * if (q1.wasCorrect())
 *     score++;
 * }
 * </pre>
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2025
 */
public class Question {
    /**
     * The descriptive title of the question that will be displayed to the user.
     * This should clearly indicate what concept or skill is being tested.
     */
    private final String title;

    /**
     * Array containing the lines of Java code to be analyzed by the user.
     * Each string represents one line of code, maintaining proper formatting
     * and indentation for readability.
     */
    private final String[] codeLines;

    /**
     * Functional interface that provides the expected output of the code.
     * Using Supplier<String> allows for lazy evaluation and flexible
     * code simulation without requiring actual compilation or execution.
     * 
     * Example: () -> "Hello World" for a simple print statement
     */
    private final Supplier<String> execution;

    /**
     * Educational explanation provided after the user submits their answer.
     * This should explain the reasoning behind the correct answer and
     * reinforce the underlying Java concepts being demonstrated.
     */
    private final String explanation;

    /**
     * Custom prompt text displayed when requesting user input.
     * Defaults to "Your answer: " if not specified in the constructor.
     */
    private final String inputPrompt;

    /**
     * Tracks whether the user answered this question correctly.
     * Used for scoring and progress tracking within stages.
     */
    private boolean wasCorrect = false;

    /**
     * Primary constructor for creating a fully customized Question instance.
     * 
     * This constructor allows complete control over all aspects of the question,
     * including custom input prompts for specialized scenarios.
     * 
     * @param title       The descriptive title of the question
     * @param codeLines   Array of code lines to be displayed and analyzed
     * @param execution   Supplier that returns the expected output when executed
     * @param explanation Educational explanation of the correct answer
     * @param inputPrompt Custom prompt text for user input
     * 
     * @throws IllegalArgumentException if any required parameter is null
     * 
     * @since 1.0
     */
    public Question(String title, String[] codeLines, Supplier<String> execution, String explanation,
            String inputPrompt) {
        this.title = title;
        this.codeLines = codeLines;
        this.execution = execution;
        this.explanation = explanation;
        this.inputPrompt = inputPrompt;
    }

    /**
     * Simplified constructor for creating a Question with default input prompt.
     * 
     * This is the most commonly used constructor, providing a clean interface
     * for standard questions while using the default "Your answer: " prompt.
     * 
     * @param title       The descriptive title of the question
     * @param codeLines   Array of code lines to be displayed and analyzed
     * @param execution   Supplier that returns the expected output when executed
     * @param explanation Educational explanation of the correct answer
     * 
     * @see #Question(String, String[], Supplier, String, String)
     * @since 1.0
     */
    public Question(String title, String[] codeLines, Supplier<String> execution, String explanation) {
        this(title, codeLines, execution, explanation, "Your answer: ");
    }

    /**
     * Executes the complete question lifecycle in an interactive manner.
     * 
     * This method handles the entire process of presenting a question to the user:
     * 1. Displays the question title and number
     * 2. Shows the code snippet line by line with proper formatting
     * 3. Prompts the user for their predicted output
     * 4. Executes the code simulation to get the actual result
     * 5. Validates the user's answer against the expected output
     * 6. Provides immediate feedback and educational explanation
     * 7. Waits for user acknowledgment before continuing
     * 
     * The method uses a consistent format across all questions to ensure
     * a uniform user experience throughout the tutorial stages.
     * 
     * @param scanner        Scanner instance for reading user input
     * @param questionNumber The sequential number of this question in the stage
     * 
     * @throws IllegalArgumentException if scanner is null
     * @throws RuntimeException         if code execution simulation fails
     * 
     * @since 1.0
     */
    public void execute(Scanner scanner, int questionNumber) {
        System.out.println("QUESTION " + questionNumber + ": " + title);
        System.out.println("What will this code output?");
        System.out.println("---");

        // Display code with consistent formatting
        for (String line : codeLines) {
            System.out.println(line);
        }

        System.out.println("---");
        System.out.print(inputPrompt);
        String userGuess = scanner.nextLine().trim();

        // Execute the actual code simulation
        String actualOutput = execution.get();

        // Check the answer and provide feedback
        checkAnswer(userGuess, actualOutput, explanation, scanner);
    }

    /**
     * Validates the user's answer and provides comprehensive feedback.
     * 
     * This private method handles the core logic of answer validation and
     * educational feedback delivery. It compares the user's guess with the
     * expected output and provides appropriate visual feedback using emoji
     * indicators for immediate recognition.
     * 
     * The method also delivers the educational explanation regardless of
     * whether the answer was correct, ensuring learning occurs in all cases.
     * 
     * @param userGuess    The user's predicted output (trimmed of whitespace)
     * @param actualOutput The correct output from code execution
     * @param explanation  Educational explanation to display
     * @param scanner      Scanner for waiting for user acknowledgment
     * 
     * @since 1.0
     */
    private void checkAnswer(String userGuess, String actualOutput, String explanation, Scanner scanner) {
        System.out.println("\nActual output: " + actualOutput);

        // Provide immediate visual feedback
        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Excellent understanding!");
            wasCorrect = true;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
            wasCorrect = false;
        }

        // Always provide educational explanation
        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    /**
     * Returns whether the user answered this question correctly.
     * 
     * This method is primarily used for scoring and progress tracking
     * within stage implementations. It should be called after execute()
     * to get meaningful results.
     * 
     * @return true if the user's answer matched the expected output, false
     *         otherwise
     * 
     * @since 1.0
     */
    public boolean wasCorrect() {
        return wasCorrect;
    }

    /**
     * Displays comprehensive stage completion summary with performance analysis.
     * 
     * This static utility method provides a standardized way to conclude any
     * tutorial stage with rich educational content and performance feedback.
     * It calculates performance percentages, provides qualitative assessments,
     * and offers resources for continued learning.
     * 
     * <h3>Performance Assessment Levels:</h3>
     * <ul>
     * <li><strong>80%+:</strong> Outstanding mastery of concepts</li>
     * <li><strong>60-79%:</strong> Great progress with solid understanding</li>
     * <li><strong>Below 60%:</strong> Needs additional practice and review</li>
     * </ul>
     * 
     * <h3>Educational Components:</h3>
     * <ul>
     * <li>Score summary with percentage calculation</li>
     * <li>Qualitative performance assessment</li>
     * <li>Key concepts reinforcement</li>
     * <li>Learning tips and best practices</li>
     * <li>Resource recommendations for further study</li>
     * <li>Motivational completion message</li>
     * </ul>
     * 
     * @param score           Number of questions answered correctly
     * @param totalQuestions  Total number of questions attempted
     * @param stageName       Descriptive name of the completed stage
     * @param keyConcepts     Array of key concepts covered in this stage
     * @param tips            Array of learning tips and best practices
     * @param folderInfo      Information about related code folders in the tutorial
     * @param exploreFiles    Array of recommended files for basic exploration
     * @param advancedFiles   Array of advanced files for further challenge
     * @param congratsMessage Personalized congratulatory message
     * 
     * @throws IllegalArgumentException if any array parameter is null
     * @throws ArithmeticException      if totalQuestions is zero
     * 
     * @since 1.0
     */
    public static void showFinalResults(int score, int totalQuestions, String stageName, String[] keyConcepts,
            String[] tips, String folderInfo, String[] exploreFiles, String[] advancedFiles, String congratsMessage) {
        System.out.println("\n=== " + stageName + " COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        // Calculate and display performance assessment
        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("Outstanding! You have mastered advanced data structures!");
        } else if (percentage >= 60) {
            System.out.println("Great work! You're developing strong data structure skills!");
        } else {
            System.out.println("Keep practicing! Advanced data structures require deep understanding!");
        }

        // Display key concepts for reinforcement
        System.out.println("\nKey concepts covered in " + stageName + ":");
        for (String concept : keyConcepts) {
            System.out.println("• " + concept);
        }

        // Provide learning tips and best practices
        System.out.println("\nAdvanced Data Structure Tips:");
        for (String tip : tips) {
            System.out.println("• " + tip);
        }

        // Recommend related resources
        System.out.println("\n" + folderInfo);
        System.out.print("Explore: ");
        for (int i = 0; i < exploreFiles.length; i++) {
            System.out.print(exploreFiles[i]);
            if (i < exploreFiles.length - 1)
                System.out.print(", ");
        }
        System.out.println();

        // Provide advanced challenges if available
        if (advancedFiles.length > 0) {
            // Provide advanced challenges if available
            if (advancedFiles.length > 0) {
                System.out.print("Advanced: ");
                for (int i = 0; i < advancedFiles.length; i++) {
                    System.out.print(advancedFiles[i]);
                    if (i < advancedFiles.length - 1)
                        System.out.print(", ");
                }
                System.out.println();
            }

            // Display personalized completion message
            System.out.println("\n" + congratsMessage);
        }
    }
}
