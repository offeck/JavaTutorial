import java.util.Scanner;
import java.util.function.Supplier;

public class stage_2 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 2 ===");
        System.out.println("Welcome to Stage 2: Prime Algorithms & Arrays!");
        System.out.println("This stage focuses on understanding array operations and prime number logic.");
        System.out.println("Let's test your code comprehension skills!\n");

        // Create and execute all questions
        executeQuestion(createQuestion1());
        executeQuestion(createQuestion2());
        executeQuestion(createQuestion3());
        executeQuestion(createQuestion4());
        executeQuestion(createQuestion5());

        // Show final results
        String[] keyConcepts = {
                "Factorial calculation algorithms",
                "Prime detection with optimized divisor checking",
                "Greatest Common Divisor (Euclid's algorithm)",
                "Loop termination conditions and efficiency",
                "Array-based prime storage and checking",
                "Mathematical algorithm implementation"
        };

        String[] tips = {
                "Trace through loops step by step with actual values",
                "Pay attention to loop termination conditions",
                "Understand when variables change inside loops",
                "Notice optimization techniques (like checking up to sqrt)"
        };

        String[] exploreFiles = {
                "AllPrimes.java", "FindDivisors.java", "GCD.java", "Factorial.java"
        };

        String[] advancedFiles = {
                "AllPrimesArray.java", "Digits.java"
        };

        Question.showFinalResults(score, totalQuestions, "STAGE 2", keyConcepts, tips,
                "These are real algorithms from your prime algorithms folder!",
                exploreFiles, advancedFiles,
                "Outstanding! You have excellent understanding of arrays and prime algorithms!");
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
                "int n = 4;",
                "int fact = 1;",
                "int i = 1;",
                "while ( i <= n ) {",
                "    fact = fact * i;",
                "    i = i + 1;",
                "}",
                "System.out.println(\"n!  =\" + fact);"
        };

        Supplier<String> execution = () -> {
            int n = 4;
            int fact = 1;
            int i = 1;
            while (i <= n) {
                fact = fact * i;
                i = i + 1;
            }
            return "n!  =" + fact;
        };

        String explanation = "EXPLANATION: Factorial of 4 = 1*1*2*3*4 = 24. The loop multiplies fact by each number from 1 to n.";

        return new Question("Factorial Algorithm", code, execution, explanation);
    }

    private static Question createQuestion2() {
        String[] code = {
                "int n = 15;",
                "boolean isPrime = true;",
                "int p = 2;",
                "while ( p < n && isPrime ) {",
                "    if(n%p == 0)",
                "        isPrime = false;",
                "    else",
                "        p = p + 1;",
                "}",
                "if (isPrime)",
                "    System.out.println(n + \" is prime\");",
                "else",
                "    System.out.println(p + \", \" + n/p);"
        };

        Supplier<String> execution = () -> {
            int n = 15;
            boolean isPrime = true;
            int p = 2;
            while (p < n && isPrime) {
                if (n % p == 0)
                    isPrime = false;
                else
                    p = p + 1;
            }
            if (isPrime)
                return n + " is prime";
            else
                return p + ", " + n / p;
        };

        String explanation = "EXPLANATION: 15 is not prime. The algorithm finds p=3 as the first divisor, so it outputs '3, 5' (the divisor and its complement).";

        return new Question("Prime Detection from FindDivisors", code, execution, explanation);
    }

    private static Question createQuestion3() {
        String[] code = {
                "int m = 48;",
                "int n = 18;",
                "int r = m%n;",
                "while (r != 0) {",
                "    m = n;",
                "    n = r;",
                "    r = m%n;",
                "}",
                "System.out.println(n);"
        };

        Supplier<String> execution = () -> {
            int m = 48;
            int n = 18;
            int r = m % n;
            while (r != 0) {
                m = n;
                n = r;
                r = m % n;
            }
            return String.valueOf(n);
        };

        String explanation = "EXPLANATION: Euclid's algorithm: 48%18=12, 18%12=6, 12%6=0. GCD(48,18) = 6.";

        return new Question("GCD Algorithm (Euclid's)", code, execution, explanation);
    }

    private static Question createQuestion4() {
        String[] code = {
                "int number = 7;",
                "boolean isPrime = true;",
                "int divisor = 2;",
                "while (divisor * divisor <= number && isPrime) {",
                "    if ( number % divisor == 0) {",
                "        isPrime = false;",
                "    }",
                "    divisor = divisor + 1;",
                "}",
                "if(isPrime) {",
                "    System.out.println(number);",
                "} else {",
                "    System.out.println(\"not prime\");",
                "}"
        };

        Supplier<String> execution = () -> {
            int number = 7;
            boolean isPrime = true;
            int divisor = 2;
            while (divisor * divisor <= number && isPrime) {
                if (number % divisor == 0) {
                    isPrime = false;
                }
                divisor = divisor + 1;
            }
            if (isPrime) {
                return String.valueOf(number);
            } else {
                return "not prime";
            }
        };

        String explanation = "EXPLANATION: 7 is prime. The loop checks divisors 2,3 but stops at 3 since 3*3=9 > 7. No divisors found, so it prints 7.";

        return new Question("Prime Detection Loop from AllPrimes", code, execution, explanation);
    }

    private static Question createQuestion5() {
        String[] code = {
                "int[] primes = new int[10];",
                "int numberOfPrimes = 0;",
                "int number = 2;",
                "boolean isPrime = true;",
                "// Check if 2 is prime by testing against previous primes (none yet)",
                "for(int i = 0; i < numberOfPrimes && primes[i]*primes[i] <= number && isPrime; i++) {",
                "    if (number%primes[i] == 0) {",
                "        isPrime = false;",
                "    }",
                "}",
                "if(isPrime) {",
                "    primes[numberOfPrimes] = number;",
                "    numberOfPrimes++;",
                "}",
                "System.out.println(numberOfPrimes);"
        };

        Supplier<String> execution = () -> {
            int[] primes = new int[10];
            int numberOfPrimes = 0;
            int number = 2;
            boolean isPrime = true;

            // Check if 2 is prime by testing against previous primes (none yet)
            for (int i = 0; i < numberOfPrimes && primes[i] * primes[i] <= number && isPrime; i++) {
                if (number % primes[i] == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primes[numberOfPrimes] = number;
                numberOfPrimes++;
            }
            return String.valueOf(numberOfPrimes);
        };

        String explanation = "EXPLANATION: Since numberOfPrimes=0 initially, the for loop doesn't execute. 2 is considered prime, added to array, numberOfPrimes becomes 1.";

        return new Question("Array-based Prime Finding", code, execution, explanation);
    }
}
