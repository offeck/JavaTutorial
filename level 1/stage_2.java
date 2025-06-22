import java.util.Scanner;

public class stage_2 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 2 ===");
        System.out.println("Welcome to Stage 2: Prime Algorithms & Arrays!");
        System.out.println("This stage focuses on understanding array operations and prime number logic.");
        System.out.println("Let's test your code comprehension skills!\n");

        // Question 1: Basic prime checking logic
        question1();

        // Question 2: Array initialization and access
        question2();

        // Question 3: Prime counting with arrays
        question3();

        // Question 4: Array modification
        question4();

        // Question 5: Sieve of Eratosthenes concept
        question5();

        // Show final results
        showFinalResults();
    }    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1: Factorial Algorithm");
        System.out.println("What will this code output when input is 4?");
        System.out.println("---");
        System.out.println("int n = 4;");
        System.out.println("int fact = 1;");
        System.out.println("int i = 1;");
        System.out.println("while ( i <= n ) {");
        System.out.println("    fact = fact * i;");
        System.out.println("    i = i + 1;");
        System.out.println("}");
        System.out.println("System.out.println(\"n!  =\" + fact);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from Factorial.java
        int n = 4;
        int fact = 1;
        int i = 1;
        while ( i <= n ) {
            fact = fact * i;
            i = i + 1;
        }
        String actualOutput = "n!  =" + fact;

        checkAnswer(userGuess, actualOutput,
                "Explanation: Factorial of 4 = 1*1*2*3*4 = 24. The loop multiplies fact by each number from 1 to n.");
    }    private static void question2() {
        totalQuestions++;
        System.out.println("\nQUESTION 2: Prime Detection from FindDivisors");
        System.out.println("What will this code output when n = 15?");
        System.out.println("---");
        System.out.println("int n = 15;");
        System.out.println("boolean isPrime = true;");
        System.out.println("int p = 2;");
        System.out.println("while ( p < n && isPrime ) {");
        System.out.println("    if(n%p == 0)");
        System.out.println("        isPrime = false;");
        System.out.println("    else");
        System.out.println("        p = p + 1;");
        System.out.println("}");
        System.out.println("if (isPrime)");
        System.out.println("    System.out.println(n + \" is prime\");");
        System.out.println("else");
        System.out.println("    System.out.println(p + \", \" + n/p);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from FindDivisors.java
        int n = 15;
        boolean isPrime = true;
        int p = 2;
        while ( p < n && isPrime ) {
            if(n%p == 0)
                isPrime = false;
            else
                p = p + 1;
        }
        String actualOutput;
        if (isPrime)
            actualOutput = n + " is prime";
        else
            actualOutput = p + ", " + n/p;

        checkAnswer(userGuess, actualOutput,
                "Explanation: 15 is not prime. The algorithm finds p=3 as the first divisor, so it outputs '3, 5' (the divisor and its complement).");
    }    private static void question3() {
        totalQuestions++;
        System.out.println("\nQUESTION 3: GCD Algorithm (Euclid's)");
        System.out.println("What will this code output when m = 48 and n = 18?");
        System.out.println("---");
        System.out.println("int m = 48;");
        System.out.println("int n = 18;");
        System.out.println("int r = m%n;");
        System.out.println("while (r != 0) {");
        System.out.println("    m = n;");
        System.out.println("    n = r;");
        System.out.println("    r = m%n;");
        System.out.println("}");
        System.out.println("System.out.println(n);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from GCD.java
        int m = 48;
        int n = 18;
        int r = m%n;
        while (r != 0) {
            m = n;
            n = r; 
            r = m%n;
        }
        String actualOutput = String.valueOf(n);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Euclid's algorithm: 48%18=12, 18%12=6, 12%6=0. GCD(48,18) = 6.");
    }    private static void question4() {
        totalQuestions++;
        System.out.println("\nQUESTION 4: Prime Detection Loop from AllPrimes");
        System.out.println("What will this code output for number = 7?");
        System.out.println("---");
        System.out.println("int number = 7;");
        System.out.println("boolean isPrime = true;");
        System.out.println("int divisor = 2;");
        System.out.println("while (divisor * divisor <= number && isPrime) {");
        System.out.println("    if ( number % divisor == 0) {");
        System.out.println("        isPrime = false;");
        System.out.println("    }");
        System.out.println("    divisor = divisor + 1;");
        System.out.println("}");
        System.out.println("if(isPrime) {");
        System.out.println("    System.out.println(number);");
        System.out.println("} else {");
        System.out.println("    System.out.println(\"not prime\");");
        System.out.println("}");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from AllPrimes.java logic
        int number = 7;
        boolean isPrime = true;
        int divisor = 2;
        while (divisor * divisor <= number && isPrime) {
            if ( number % divisor == 0) {
                isPrime = false; 
            }
            divisor = divisor + 1;
        }
        String actualOutput;
        if(isPrime) {
            actualOutput = String.valueOf(number);
        } else {
            actualOutput = "not prime";
        }

        checkAnswer(userGuess, actualOutput,
                "Explanation: 7 is prime. The loop checks divisors 2,3 but stops at 3 since 3*3=9 > 7. No divisors found, so it prints 7.");
    }    private static void question5() {
        totalQuestions++;
        System.out.println("\nQUESTION 5: Array-based Prime Finding");
        System.out.println("What will this code output? (Trace through the logic)");
        System.out.println("---");
        System.out.println("int[] primes = new int[10];");
        System.out.println("int numberOfPrimes = 0;");
        System.out.println("int number = 2;");
        System.out.println("boolean isPrime = true;");
        System.out.println("// Check if 2 is prime by testing against previous primes (none yet)");
        System.out.println("for(int i = 0; i < numberOfPrimes && primes[i]*primes[i] <= number && isPrime; i++) {");
        System.out.println("    if (number%primes[i] == 0) {");
        System.out.println("        isPrime = false;");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("if(isPrime) {");
        System.out.println("    primes[numberOfPrimes] = number;");
        System.out.println("    numberOfPrimes++;");
        System.out.println("}");
        System.out.println("System.out.println(numberOfPrimes);");
        System.out.println("---");

        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();

        // Actual execution from AllPrimesArray.java logic
        int[] primes = new int[10];
        int numberOfPrimes = 0;
        int number = 2;
        boolean isPrime = true;
        
        // Check if 2 is prime by testing against previous primes (none yet)
        for(int i = 0; i < numberOfPrimes && primes[i]*primes[i] <= number && isPrime; i++) {
            if (number%primes[i] == 0) {
                isPrime = false;
            }
        }
        if(isPrime) {
            primes[numberOfPrimes] = number;
            numberOfPrimes++;
        }
        String actualOutput = String.valueOf(numberOfPrimes);

        checkAnswer(userGuess, actualOutput,
                "Explanation: Since numberOfPrimes=0 initially, the for loop doesn't execute. 2 is considered prime, added to array, numberOfPrimes becomes 1.");
    }

    private static void checkAnswer(String userGuess, String actualOutput, String explanation) {
        System.out.println("\nActual output: " + actualOutput);

        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Excellent understanding!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }

        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showFinalResults() {
        System.out.println("\n=== STAGE 2 COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);

        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) {
            System.out.println("🎉 Outstanding! You have excellent understanding of arrays and prime algorithms!");
        } else if (percentage >= 60) {
            System.out.println("👍 Good work! You're developing solid algorithmic thinking!");
        } else {
            System.out.println("🤔 Keep practicing! Arrays and algorithms take time to master.");
        }        System.out.println("\nKey concepts covered in Stage 2:");
        System.out.println("• Factorial calculation algorithms");
        System.out.println("• Prime detection with optimized divisor checking");
        System.out.println("• Greatest Common Divisor (Euclid's algorithm)");
        System.out.println("• Loop termination conditions and efficiency");
        System.out.println("• Array-based prime storage and checking");
        System.out.println("• Mathematical algorithm implementation");
        
        System.out.println("\nDebugging Tips:");
        System.out.println("• Trace through loops step by step with actual values");
        System.out.println("• Pay attention to loop termination conditions");
        System.out.println("• Understand when variables change inside loops");
        System.out.println("• Notice optimization techniques (like checking up to sqrt)");
        
        System.out.println("\nThese are real algorithms from your prime algorithms folder!");
        System.out.println("Try running the original files: AllPrimes.java, FindDivisors.java, GCD.java, etc.");
    }
}
