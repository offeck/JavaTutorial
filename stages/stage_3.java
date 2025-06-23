import java.util.Scanner;

public class stage_3 {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== JAVA DEBUGGING GAME - STAGE 3 ===");
        System.out.println("Welcome to Stage 3: Functions, Sorting & Strings!");
        System.out.println(
                "This stage focuses on understanding function calls, array algorithms, and string operations.");
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

        // Question 6: Insertion sort algorithm
        question6();

        // Question 7: Caesar cipher encryption
        question7();

        // Question 8: Roman numeral conversion
        question8();

        // Question 9: Base conversion (hexadecimal)
        question9();

        // Question 10: Selection sort with helper methods
        question10();

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
        for (int i = 0; i < s.length(); i = i + 1)
            if (s.charAt(i) == c)
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
        int[] a = { 1, 2, 4, 8 };
        int currentSum = 0;
        for (int i = 0; i < a.length; i = i + 1) {
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
        // The second int will be automatically promoted to double for the (int, double)
        // version
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
        int[] array = { 2, 3, 5, 7 };
        int key = 5;
        int output = -1;
        boolean found = false;
        int low = 0;
        int high = array.length - 1;
        while (low <= high && !found) {
            int middle = (low + high) / 2;
            if (array[middle] == key) {
                output = middle;
                found = true;
            } else if (key < array[middle])
                high = middle - 1;
            else
                low = middle + 1;
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
        int[][] a = { { 8, 4 }, { 11 }, {} };
        int[][] copy = new int[a.length][];
        for (int i = 0; i < a.length; i = i + 1) {
            if (a[i] != null) {
                copy[i] = new int[a[i].length];
                for (int j = 0; j < a[i].length; j = j + 1) {
                    copy[i][j] = a[i][j];
                }
            }
        }
        String actualOutput = String.valueOf(copy[1][0]);

        checkAnswer(userGuess, actualOutput,
                "Explanation: The 2D array is deep copied. copy[1] is a copy of {11}, so copy[1][0] = 11.");
    }

    private static void question6() {
        totalQuestions++;
        System.out.println("QUESTION 6: Insertion Sort Algorithm");
        System.out.println("What will this array look like after the insertion sort?");
        System.out.println("---");
        System.out.println("int[] array = {4, 2, 7, 1, 3};");
        System.out.println("// Insertion sort algorithm:");
        System.out.println("for (int i = 1; i < array.length; i++) {");
        System.out.println("    int value = array[i];");
        System.out.println("    int j = i;");
        System.out.println("    while (j > 0 && array[j-1] > value) {");
        System.out.println("        array[j] = array[j-1];");
        System.out.println("        j--;");
        System.out.println("    }");
        System.out.println("    array[j] = value;");
        System.out.println("}");
        System.out.println("System.out.println(Arrays.toString(array));");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        int[] array = { 4, 2, 7, 1, 3 };
        insertionSortSimulation(array);
        String actualOutput = java.util.Arrays.toString(array);

        checkAnswer(userGuess, actualOutput,
                "EXPLANATION: Insertion sort builds a sorted portion from left to right. Starting with index 1, each element is inserted into its correct position. Step by step: {4,2,7,1,3} → {2,4,7,1,3} → {2,4,7,1,3} → {1,2,4,7,3} → {1,2,3,4,7}. Elements are shifted right to make room for the inserted element. Time complexity: O(n²) worst case, O(n) best case (already sorted).");
    }

    private static void question7() {
        totalQuestions++;
        System.out.println("QUESTION 7: Caesar Cipher Encryption");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("String str = \"HELLO\";");
        System.out.println("int key = 3;");
        System.out.println("String encrypted = \"\";");
        System.out.println("for(int i = 0; i < str.length(); i++) {");
        System.out.println("    char c = str.charAt(i);");
        System.out.println("    if(c >= 'A' && c <= 'Z') {");
        System.out.println("        c = (char)((c - 'A' + key) % 26 + 'A');");
        System.out.println("    }");
        System.out.println("    encrypted = encrypted + c;");
        System.out.println("}");
        System.out.println("System.out.println(encrypted);");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        String actualOutput = caesarEncrypt("HELLO", 3);

        checkAnswer(userGuess, actualOutput,
                "EXPLANATION: Caesar cipher shifts each letter by a fixed number of positions. H (pos 7) + 3 = K (pos 10), E (pos 4) + 3 = H (pos 7). L (pos 11) + 3 = O (pos 14), L + 3 = O, O (pos 14) + 3 = R (pos 17). The modulo 26 ensures wrapping around the alphabet (Z + 1 = A). This is a simple substitution cipher used since ancient Rome.");
    }

    private static void question8() {
        totalQuestions++;
        System.out.println("QUESTION 8: Roman Numeral Conversion");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("String roman = \"XIV\";");
        System.out.println("int result = 0;");
        System.out.println("for(int i = 0; i < roman.length(); i++) {");
        System.out.println("    int current = getValue(roman.charAt(i));");
        System.out.println("    if(i + 1 < roman.length()) {");
        System.out.println("        int next = getValue(roman.charAt(i+1));");
        System.out.println("        if (current >= next) {");
        System.out.println("            result += current;");
        System.out.println("        } else {");
        System.out.println("            result += (next - current);");
        System.out.println("            i++; // skip next character");
        System.out.println("        }");
        System.out.println("    } else {");
        System.out.println("        result += current;");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("System.out.println(result);");
        System.out.println("// where X=10, I=1, V=5");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        int actualOutput = romanToDecimal("XIV");

        checkAnswer(userGuess, String.valueOf(actualOutput),
                "EXPLANATION: Roman numerals use subtraction when smaller numeral precedes larger. XIV: X=10, I=1, V=5. Process: X(10) ≥ I(1), so add X=10, result=10. Next: I(1) < V(5), so add (V-I) = 5-1 = 4, skip V, result=10+4=14. This handles special cases like IV=4, IX=9, XL=40, etc.");
    }

    private static void question9() {
        totalQuestions++;
        System.out.println("QUESTION 9: Base Conversion (Hexadecimal)");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("String s = \"0xFF\";");
        System.out.println("int value = 0, power = 1;");
        System.out.println("int base = 16, first = 2; // skip '0x'");
        System.out.println("for(int i = s.length()-1; i >= first; i--) {");
        System.out.println("    char c = s.charAt(i);");
        System.out.println("    int digit;");
        System.out.println("    if (c >= '0' && c <= '9') {");
        System.out.println("        digit = c - '0';");
        System.out.println("    } else if (c >= 'A' && c <= 'F') {");
        System.out.println("        digit = c - 'A' + 10;");
        System.out.println("    }");
        System.out.println("    value = value + digit * power;");
        System.out.println("    power = power * base;");
        System.out.println("}");
        System.out.println("System.out.println(value);");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        int actualOutput = baseConversion("0xFF");

        checkAnswer(userGuess, String.valueOf(actualOutput),
                "EXPLANATION: Hexadecimal uses base 16: digits 0-9 and letters A-F (A=10, B=11, ..., F=15). 0xFF means hex number FF (prefix 0x indicates hexadecimal). Processing right to left: F=15, F=15. F * 16^0 = 15 * 1 = 15, F * 16^1 = 15 * 16 = 240. Total: 15 + 240 = 255. This is how computers internally convert hex to decimal.");
    }

    private static void question10() {
        totalQuestions++;
        System.out.println("QUESTION 10: Selection Sort with Helper Methods");
        System.out.println("What will this code output?");
        System.out.println("---");
        System.out.println("int[] arr = {3, 1, 4, 2};");
        System.out.println("for (int i = 0; i < arr.length-1; i++) {");
        System.out.println("    int minIndex = i;");
        System.out.println("    for(int j = i+1; j < arr.length; j++) {");
        System.out.println("        if (arr[j] < arr[minIndex]) {");
        System.out.println("            minIndex = j;");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println("    // swap arr[i] with arr[minIndex]");
        System.out.println("    int temp = arr[i];");
        System.out.println("    arr[i] = arr[minIndex];");
        System.out.println("    arr[minIndex] = temp;");
        System.out.println("}");
        System.out.println("System.out.println(Arrays.toString(arr));");
        System.out.println("---");

        System.out.print("Your answer: ");
        String userGuess = scanner.nextLine().trim(); // Simulate the actual execution
        int[] arr = { 3, 1, 4, 2 };
        selectionSortSimulation(arr);
        String actualOutput = java.util.Arrays.toString(arr);

        checkAnswer(userGuess, actualOutput,
                "EXPLANATION: Selection sort finds the minimum element and swaps it to the front. Round 1: min(3,1,4,2)=1 at index 1, swap with index 0: {1,3,4,2}. Round 2: min(3,4,2)=2 at index 3, swap with index 1: {1,2,4,3}. Round 3: min(4,3)=3 at index 3, swap with index 2: {1,2,3,4}. Each pass guarantees one more element is in its final position. Time complexity: O(n²) for all cases (consistent performance).");
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
        System.out.println("• Sorting algorithms: Insertion sort and Selection sort");
        System.out.println("• Cryptography: Caesar cipher encryption");
        System.out.println("• Number system conversion: Roman numerals and hexadecimal");
        System.out.println("• Base conversion algorithms and character arithmetic");
        System.out.println("• Function design and modularity");

        System.out.println("\nAdvanced Debugging Tips:");
        System.out.println("• Trace method calls and parameter passing carefully");
        System.out.println("• Understand how Java chooses overloaded methods");
        System.out.println("• Follow array modifications step by step");
        System.out.println("• Pay attention to null checks in array operations");
        System.out.println("• Practice binary search by hand to understand the logic");
        System.out.println("• Understand sorting algorithm invariants and loop progress");
        System.out.println("• Master character arithmetic for encryption and parsing");
        System.out.println("• Learn base conversion patterns for different number systems");

        System.out.println("\nThese algorithms are from your functions/sorting/strings folder!");
        System.out.println("Explore: Strings.java, CumulativeSum.java, SearchAndSort.java, CopyArray.java");
        System.out.println("Also check: OverLoading.java, Ceasar.java, RomanToNumber.java");
        System.out.println("\nCongratulations on mastering advanced Java algorithms and string processing!");
    }

    // Helper methods for algorithm simulations
    private static void insertionSortSimulation(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > value) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = value;
        }
    }

    private static void selectionSortSimulation(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap arr[i] with arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Caesar cipher encryption simulation
    private static String caesarEncrypt(String str, int key) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + key) % 26 + 'A');
            }
            encrypted = encrypted + c;
        }
        return encrypted;
    }

    // Roman to decimal conversion simulation
    private static int romanToDecimal(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int current = getRomanValue(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int next = getRomanValue(roman.charAt(i + 1));
                if (current >= next) {
                    result += current;
                } else {
                    result += (next - current);
                    i++; // skip next character
                }
            } else {
                result += current;
            }
        }
        return result;
    }

    // Get integer value of a Roman numeral character
    private static int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    // Base conversion simulation (hexadecimal to decimal)
    private static int baseConversion(String s) {
        int value = 0, power = 1;
        int base = 16, first = 2; // skip '0x'
        for (int i = s.length() - 1; i >= first; i--) {
            char c = s.charAt(i);
            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                digit = c - 'A' + 10;
            } else {
                digit = 0;
            }
            value = value + digit * power;
            power = power * base;
        }
        return value;
    }
}
