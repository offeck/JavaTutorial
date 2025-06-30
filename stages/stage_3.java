import java.util.Scanner;
import java.util.function.Supplier;

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
        executeQuestion(createQuestion1());

        // Question 2: Cumulative sum algorithm
        executeQuestion(createQuestion2());

        // Question 3: Method overloading
        executeQuestion(createQuestion3());

        // Question 4: Binary search algorithm
        executeQuestion(createQuestion4());

        // Question 5: 2D array copying
        executeQuestion(createQuestion5());

        // Question 6: Insertion sort algorithm
        executeQuestion(createQuestion6());

        // Question 7: Caesar cipher encryption
        executeQuestion(createQuestion7());

        // Question 8: Roman numeral conversion
        executeQuestion(createQuestion8());

        // Question 9: Base conversion (hexadecimal)
        executeQuestion(createQuestion9());

        // Question 10: Selection sort with helper methods
        executeQuestion(createQuestion10());

        // Show final results
        String[] keyConcepts = {
                "String manipulation and character operations",
                "In-place array modification algorithms",
                "Method overloading and parameter matching",
                "Binary search algorithm implementation",
                "2D array deep copying techniques",
                "Sorting algorithms: Insertion sort and Selection sort",
                "Cryptography: Caesar cipher encryption",
                "Number system conversion: Roman numerals and hexadecimal",
                "Base conversion algorithms and character arithmetic",
                "Function design and modularity"
        };

        String[] tips = {
                "Trace method calls and parameter passing carefully",
                "Understand how Java chooses overloaded methods",
                "Follow array modifications step by step",
                "Pay attention to null checks in array operations",
                "Practice binary search by hand to understand the logic",
                "Understand sorting algorithm invariants and loop progress",
                "Master character arithmetic for encryption and parsing",
                "Learn base conversion patterns for different number systems"
        };

        String[] exploreFiles = {
                "Strings.java", "CumulativeSum.java", "SearchAndSort.java", "CopyArray.java"
        };

        String[] advancedFiles = {
                "OverLoading.java", "Ceasar.java", "RomanToNumber.java"
        };

        Question.showFinalResults(score, totalQuestions, "STAGE 3", keyConcepts, tips,
                "These algorithms are from your functions/sorting/strings folder!",
                exploreFiles, advancedFiles,
                "Congratulations on mastering advanced Java algorithms and string processing!");
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
                "String s = \"hello\";",
                "char c = 'l';",
                "int counter = 0;",
                "for(int i = 0; i < s.length(); i = i + 1)",
                "    if(s.charAt(i) == c)",
                "        counter = counter + 1;",
                "System.out.println(counter);"
        };

        Supplier<String> execution = () -> {
            String s = "hello";
            char c = 'l';
            int counter = 0;
            for (int i = 0; i < s.length(); i = i + 1)
                if (s.charAt(i) == c)
                    counter = counter + 1;
            return String.valueOf(counter);
        };

        String explanation = "Explanation: In \"hello\", the character 'l' appears twice (at positions 2 and 3), so counter = 2.";

        return new Question("String Character Counting", code, execution, explanation, "Your guess: ");
    }

    private static Question createQuestion2() {
        String[] code = {
                "int[] a = {1, 2, 4, 8};",
                "int currentSum = 0;",
                "for(int i = 0; i < a.length; i = i + 1) {",
                "    currentSum = currentSum + a[i];",
                "    a[i] = currentSum;",
                "}",
                "// What does a[2] contain now?",
                "System.out.println(a[2]);"
        };

        Supplier<String> execution = () -> {
            int[] a = { 1, 2, 4, 8 };
            int currentSum = 0;
            for (int i = 0; i < a.length; i = i + 1) {
                currentSum = currentSum + a[i];
                a[i] = currentSum;
            }
            return String.valueOf(a[2]);
        };

        String explanation = "Explanation: Cumulative sum: a[0]=1, a[1]=1+2=3, a[2]=1+2+4=7, a[3]=1+2+4+8=15. So a[2]=7.";

        return new Question("Cumulative Sum Array Modification", code, execution, explanation, "Your guess: ");
    }

    private static Question createQuestion3() {
        String[] code = {
                "// Method definitions:",
                "public static void overLoaded(int n, double d, int m) {",
                "    System.out.println(\"int, double, int\");",
                "}",
                "public static void overLoaded(int n, double d) {",
                "    System.out.println(\"int, double\");",
                "}",
                "// Method call:",
                "int myInt = 0;",
                "overLoaded(myInt, myInt);"
        };

        Supplier<String> execution = () -> {
            String actualOutput = "int, double";
            return actualOutput;
        };

        String explanation = "Explanation: Java chooses overLoaded(int, double) because the second int parameter is automatically promoted to double to match this signature.";

        return new Question("Method Overloading", code, execution, explanation, "Your guess: ");
    }

    private static Question createQuestion4() {
        String[] code = {
                "int[] array = {2, 3, 5, 7};",
                "int key = 5;",
                "int output = -1;",
                "boolean found = false;",
                "int low = 0;",
                "int high = array.length-1;",
                "while (low <= high && !found){",
                "    int middle = (low+high)/2;",
                "    if(array[middle] == key){",
                "        output = middle;",
                "        found = true;",
                "    } else if (key < array[middle])",
                "        high = middle-1;",
                "    else",
                "        low = middle+1;",
                "}",
                "System.out.println(output);"
        };

        Supplier<String> execution = () -> {
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
            return String.valueOf(output);
        };

        String explanation = "Explanation: Binary search finds 5 at index 2. First middle=(0+3)/2=1, array[1]=3<5, so search right half. Next middle=(2+3)/2=2, array[2]=5=key, found!";

        return new Question("Binary Search Algorithm", code, execution, explanation, "Your guess: ");
    }

    private static Question createQuestion5() {
        String[] code = {
                "int[][] a = {{8, 4}, {11}, {}};",
                "int[][] copy = new int[a.length][];",
                "for(int i = 0; i < a.length; i = i + 1) {",
                "    if(a[i] != null){",
                "        copy[i] = new int[a[i].length];",
                "        for(int j = 0; j < a[i].length; j = j + 1) {",
                "            copy[i][j] = a[i][j];",
                "        }",
                "    }",
                "}",
                "System.out.println(copy[1][0]);"
        };

        Supplier<String> execution = () -> {
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
            return String.valueOf(copy[1][0]);
        };

        String explanation = "Explanation: The 2D array is deep copied. copy[1] is a copy of {11}, so copy[1][0] = 11.";

        return new Question("2D Array Deep Copy Logic", code, execution, explanation, "Your guess: ");
    }

    private static Question createQuestion6() {
        String[] code = {
                "int[] array = {4, 2, 7, 1, 3};",
                "// Insertion sort algorithm:",
                "for (int i = 1; i < array.length; i++) {",
                "    int value = array[i];",
                "    int j = i;",
                "    while (j > 0 && array[j-1] > value) {",
                "        array[j] = array[j-1];",
                "        j--;",
                "    }",
                "    array[j] = value;",
                "}",
                "System.out.println(Arrays.toString(array));"
        };

        Supplier<String> execution = () -> {
            int[] array = { 4, 2, 7, 1, 3 };
            insertionSortSimulation(array);
            return java.util.Arrays.toString(array);
        };

        String explanation = "EXPLANATION: Insertion sort builds a sorted portion from left to right. Starting with index 1, each element is inserted into its correct position. Step by step: {4,2,7,1,3} → {2,4,7,1,3} → {2,4,7,1,3} → {1,2,4,7,3} → {1,2,3,4,7}. Elements are shifted right to make room for the inserted element. Time complexity: O(n²) worst case, O(n) best case (already sorted).";

        return new Question("Insertion Sort Algorithm", code, execution, explanation, "Your answer: ");
    }

    private static Question createQuestion7() {
        String[] code = {
                "String str = \"HELLO\";",
                "int key = 3;",
                "String encrypted = \"\";",
                "for(int i = 0; i < str.length(); i++) {",
                "    char c = str.charAt(i);",
                "    if(c >= 'A' && c <= 'Z') {",
                "        c = (char)((c - 'A' + key) % 26 + 'A');",
                "    }",
                "    encrypted = encrypted + c;",
                "}",
                "System.out.println(encrypted);"
        };

        Supplier<String> execution = () -> caesarEncrypt("HELLO", 3);

        String explanation = "EXPLANATION: Caesar cipher shifts each letter by a fixed number of positions. H (pos 7) + 3 = K (pos 10), E (pos 4) + 3 = H (pos 7). L (pos 11) + 3 = O (pos 14), L + 3 = O, O (pos 14) + 3 = R (pos 17). The modulo 26 ensures wrapping around the alphabet (Z + 1 = A). This is a simple substitution cipher used since ancient Rome.";

        return new Question("Caesar Cipher Encryption", code, execution, explanation, "Your answer: ");
    }

    private static Question createQuestion8() {
        String[] code = {
                "String roman = \"XIV\";",
                "int result = 0;",
                "for(int i = 0; i < roman.length(); i++) {",
                "    int current = getValue(roman.charAt(i));",
                "    if(i + 1 < roman.length()) {",
                "        int next = getValue(roman.charAt(i+1));",
                "        if (current >= next) {",
                "            result += current;",
                "        } else {",
                "            result += (next - current);",
                "            i++; // skip next character",
                "        }",
                "    } else {",
                "        result += current;",
                "    }",
                "}",
                "System.out.println(result);",
                "// where X=10, I=1, V=5"
        };

        Supplier<String> execution = () -> String.valueOf(romanToDecimal("XIV"));

        String explanation = "EXPLANATION: Roman numerals use subtraction when smaller numeral precedes larger. XIV: X=10, I=1, V=5. Process: X(10) ≥ I(1), so add X=10, result=10. Next: I(1) < V(5), so add (V-I) = 5-1 = 4, skip V, result=10+4=14. This handles special cases like IV=4, IX=9, XL=40, etc.";

        return new Question("Roman Numeral Conversion", code, execution, explanation, "Your answer: ");
    }

    private static Question createQuestion9() {
        String[] code = {
                "String s = \"0xFF\";",
                "int value = 0, power = 1;",
                "int base = 16, first = 2; // skip '0x'",
                "for(int i = s.length()-1; i >= first; i--) {",
                "    char c = s.charAt(i);",
                "    int digit;",
                "    if (c >= '0' && c <= '9') {",
                "        digit = c - '0';",
                "    } else if (c >= 'A' && c <= 'F') {",
                "        digit = c - 'A' + 10;",
                "    }",
                "    value = value + digit * power;",
                "    power = power * base;",
                "}",
                "System.out.println(value);"
        };

        Supplier<String> execution = () -> String.valueOf(baseConversion("0xFF"));

        String explanation = "EXPLANATION: Hexadecimal uses base 16: digits 0-9 and letters A-F (A=10, B=11, ..., F=15). 0xFF means hex number FF (prefix 0x indicates hexadecimal). Processing right to left: F=15, F=15. F * 16^0 = 15 * 1 = 15, F * 16^1 = 240. Total: 15 + 240 = 255. This is how computers internally convert hex to decimal.";

        return new Question("Base Conversion (Hexadecimal)", code, execution, explanation, "Your answer: ");
    }

    private static Question createQuestion10() {
        String[] code = {
                "int[] arr = {3, 1, 4, 2};",
                "for (int i = 0; i < arr.length-1; i++) {",
                "    int minIndex = i;",
                "    for(int j = i+1; j < arr.length; j++) {",
                "        if (arr[j] < arr[minIndex]) {",
                "            minIndex = j;",
                "        }",
                "    }",
                "    // swap arr[i] with arr[minIndex]",
                "    int temp = arr[i];",
                "    arr[i] = arr[minIndex];",
                "    arr[minIndex] = temp;",
                "}",
                "System.out.println(Arrays.toString(arr));"
        };

        Supplier<String> execution = () -> {
            int[] arr = { 3, 1, 4, 2 };
            selectionSortSimulation(arr);
            return java.util.Arrays.toString(arr);
        };

        String explanation = "EXPLANATION: Selection sort finds the minimum element and swaps it to the front. Round 1: min(3,1,4,2)=1 at index 1, swap with index 0: {1,3,4,2}. Round 2: min(3,4,2)=2 at index 3, swap with index 1: {1,2,4,3}. Round 3: min(4,3)=3 at index 3, swap with index 2: {1,2,3,4}. Each pass guarantees one more element is in its final position. Time complexity: O(n²) for all cases (consistent performance).";

        return new Question("Selection Sort with Helper Methods", code, execution, explanation, "Your answer: ");
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
