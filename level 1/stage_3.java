import java.util.Scanner;

public class stage_3 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;
    
    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 3 ===");
        System.out.println("Welcome to Stage 3: Functions, Sorting & Strings!");
        System.out.println("This stage focuses on understanding function calls, array algorithms, and string operations.");
        System.out.println("Let's test your advanced code comprehension skills!\n");
        
        // Question 1: String character counting
        question1();
        
        // Question 2: Cumulative sum algorithm
        question2();
        
        // Question 3: Method overloading
        question3();
        
        // Question 4: Binary search algorithm
        question4();
        
        // Question 5: 2D array copying
        question5();
        
        // Show final results
        showFinalResults();
    }
    
    private static void question1() {
        totalQuestions++;
        System.out.println("QUESTION 1: String Character Counting");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("String s = \"hello\";");
        System.out.println("char c = 'l';");
        System.out.println("int counter = 0;");
        System.out.println("for(int i = 0; i < s.length(); i = i + 1)");
        System.out.println("    if(s.charAt(i) == c)");
        System.out.println("        counter = counter + 1;");
        System.out.println("System.out.println(counter);");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from Strings.java countCharInString method
        String s = "hello";
        char c = 'l';
        int counter = 0;
        for(int i = 0; i < s.length(); i = i + 1)
            if(s.charAt(i) == c)
                counter = counter + 1;
        String actualOutput = String.valueOf(counter);
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: In \"hello\", the character 'l' appears twice (at positions 2 and 3), so counter = 2.");
    }
    
    private static void question2() {
        totalQuestions++;
        System.out.println("\nQUESTION 2: Cumulative Sum Array Modification");
        System.out.println("What will the array contain after this code executes?");
        System.out.println("---");
        System.out.println("int[] a = {1, 2, 4, 8};");
        System.out.println("int currentSum = 0;");
        System.out.println("for(int i = 0; i < a.length; i = i + 1) {");
        System.out.println("    currentSum = currentSum + a[i];");
        System.out.println("    a[i] = currentSum;");
        System.out.println("}");
        System.out.println("// What does a[2] contain now?");
        System.out.println("System.out.println(a[2]);");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from CumulativeSum.java accumulate method
        int[] a = {1, 2, 4, 8};
        int currentSum = 0;
        for(int i = 0; i < a.length; i = i + 1) {
            currentSum = currentSum + a[i];
            a[i] = currentSum;
        }
        String actualOutput = String.valueOf(a[2]);
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: Cumulative sum: a[0]=1, a[1]=1+2=3, a[2]=1+2+4=7, a[3]=1+2+4+8=15. So a[2]=7.");
    }
    
    private static void question3() {
        totalQuestions++;
        System.out.println("\nQUESTION 3: Method Overloading");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("// Method definitions:");
        System.out.println("public static void overLoaded(int n, double d, int m) {");
        System.out.println("    System.out.println(\"int, double, int\");");
        System.out.println("}");
        System.out.println("public static void overLoaded(int n, double d) {");
        System.out.println("    System.out.println(\"int, double\");");
        System.out.println("}");
        System.out.println("// Method call:");
        System.out.println("int myInt = 0;");
        System.out.println("overLoaded(myInt, myInt);");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from OverLoading.java logic
        // When calling overLoaded(myInt, myInt), Java will choose the closest match
        // The second int will be automatically promoted to double for the (int, double) version
        String actualOutput = "int, double";
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: Java chooses overLoaded(int, double) because the second int parameter is automatically promoted to double to match this signature.");
    }
    
    private static void question4() {
        totalQuestions++;
        System.out.println("\nQUESTION 4: Binary Search Algorithm");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("int[] array = {2, 3, 5, 7};");
        System.out.println("int key = 5;");
        System.out.println("int output = -1;");
        System.out.println("boolean found = false;");
        System.out.println("int low = 0;");
        System.out.println("int high = array.length-1;");
        System.out.println("while (low <= high && !found){");
        System.out.println("    int middle = (low+high)/2;");
        System.out.println("    if(array[middle] == key){");
        System.out.println("        output = middle;");
        System.out.println("        found = true;");
        System.out.println("    } else if (key < array[middle])");
        System.out.println("        high = middle-1;");
        System.out.println("    else");
        System.out.println("        low = middle+1;");
        System.out.println("}");
        System.out.println("System.out.println(output);");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from SearchAndSort.java binarySearch method
        int[] array = {2, 3, 5, 7};
        int key = 5;
        int output = -1;
        boolean found = false;
        int low = 0;
        int high = array.length-1;
        while (low <= high && !found){
            int middle = (low+high)/2;
            if(array[middle] == key){
                output = middle;
                found = true;
            }
            else 
                if (key < array[middle])
                    high = middle-1;
                else 
                    low = middle+1;
        }
        String actualOutput = String.valueOf(output);
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: Binary search finds 5 at index 2. First middle=(0+3)/2=1, array[1]=3<5, so search right half. Next middle=(2+3)/2=2, array[2]=5=key, found!");
    }
    
    private static void question5() {
        totalQuestions++;
        System.out.println("\nQUESTION 5: 2D Array Deep Copy Logic");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("int[][] a = {{8, 4}, {11}, {}};");
        System.out.println("int[][] copy = new int[a.length][];");
        System.out.println("for(int i = 0; i < a.length; i = i + 1) {");
        System.out.println("    if(a[i] != null){");
        System.out.println("        copy[i] = new int[a[i].length];");
        System.out.println("        for(int j = 0; j < a[i].length; j = j + 1) {");
        System.out.println("            copy[i][j] = a[i][j];");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("System.out.println(copy[1][0]);");
        System.out.println("---");
        
        System.out.print("Your guess: ");
        String userGuess = scanner.nextLine().trim();
        
        // Actual execution from CopyArray.java copyArray method
        int[][] a = {{8, 4}, {11}, {}};
        int[][] copy = new int[a.length][];
        for(int i = 0; i < a.length; i = i + 1) {
            if(a[i] != null){
                copy[i] = new int[a[i].length];
                for(int j = 0; j < a[i].length; j = j + 1) {
                    copy[i][j] = a[i][j];
                }
            }
        }
        String actualOutput = String.valueOf(copy[1][0]);
        
        checkAnswer(userGuess, actualOutput, 
            "Explanation: The 2D array is deep copied. copy[1] is a copy of {11}, so copy[1][0] = 11.");
    }
    
    private static void checkAnswer(String userGuess, String actualOutput, String explanation) {
        System.out.println("\nActual output: " + actualOutput);
        
        if (userGuess.equals(actualOutput)) {
            System.out.println("✅ CORRECT! Excellent algorithmic understanding!");
            score++;
        } else {
            System.out.println("❌ Incorrect. Your guess was: " + userGuess);
        }
        
        System.out.println(explanation);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    private static void showFinalResults() {
        System.out.println("\n=== STAGE 3 COMPLETE ===");
        System.out.println("Your score: " + score + "/" + totalQuestions);
        
        double percentage = (double) score / totalQuestions * 100;
        
        if (percentage >= 80) {
            System.out.println("🎉 Outstanding! You have mastered advanced Java concepts!");
        } else if (percentage >= 60) {
            System.out.println("👍 Great work! You're developing strong programming intuition!");
        } else {
            System.out.println("🤔 Keep practicing! These advanced concepts take time to master.");
        }
        
        System.out.println("\nKey concepts covered in Stage 3:");
        System.out.println("• String manipulation and character operations");
        System.out.println("• In-place array modification algorithms");
        System.out.println("• Method overloading and parameter matching");
        System.out.println("• Binary search algorithm implementation");
        System.out.println("• 2D array deep copying techniques");
        System.out.println("• Function design and modularity");
        
        System.out.println("\nAdvanced Debugging Tips:");
        System.out.println("• Trace method calls and parameter passing carefully");
        System.out.println("• Understand how Java chooses overloaded methods");
        System.out.println("• Follow array modifications step by step");
        System.out.println("• Pay attention to null checks in array operations");
        System.out.println("• Practice binary search by hand to understand the logic");
        
        System.out.println("\nThese algorithms are from your functions/sorting/strings folder!");
        System.out.println("Explore: Strings.java, CumulativeSum.java, SearchAndSort.java, CopyArray.java, OverLoading.java");
        System.out.println("\nCongratulations on completing the Java Debugging Game!");
    }
}
