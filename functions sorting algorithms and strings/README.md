# Functions, Sorting Algorithms, and Strings

This folder contains Java implementations of fundamental programming concepts including function design, sorting algorithms, search algorithms, and string manipulation techniques. These examples demonstrate proper function structure, algorithm implementation, and string processing in Java.

## 📁 Contents Overview

| File                 | Concepts Covered         | Key Algorithms/Techniques                                     |
| -------------------- | ------------------------ | ------------------------------------------------------------- |
| `SearchAndSort.java` | Search & Sort Algorithms | Linear Search, Binary Search, Insertion Sort, Selection Sort  |
| `Strings.java`       | String Processing        | Character counting, Base conversion (8/10/16), String parsing |
| `CumulativeSum.java` | Array Modification       | In-place array transformation, cumulative operations          |
| `OverLoading.java`   | Method Overloading       | Function signatures, parameter type resolution                |
| `CopyArray.java`     | 2D Array Operations      | Deep copying, nested array handling, null safety              |
| `Ceasar.java`        | Cryptography             | Caesar cipher encryption/decryption, character manipulation   |
| `RomanToNumber.java` | Number Systems           | Roman numeral conversion, string parsing algorithms           |
| `SubString.java`     | String Analysis          | Substring counting, pattern matching, string traversal        |

## 🔍 Detailed File Descriptions

### SearchAndSort.java

**Core Concepts:** Search and sorting algorithms with proper error handling

- **Linear Search**: O(n) sequential search through unsorted arrays
- **Binary Search**: O(log n) search for sorted arrays with divide-and-conquer approach
- **Insertion Sort**: O(n²) sorting by inserting elements into their correct position
- **Selection Sort**: O(n²) sorting by repeatedly finding minimum elements
- **Error Handling**: Comprehensive null checks and bounds validation
- **Helper Methods**: Array printing, element swapping, minimum index finding

```java
// Example usage:
int[] arr = {2, 3, 5, 7};
int index = binarySearch(arr, 5);  // Returns 2
insertionSort(arr);  // Sorts array in-place
```

### Strings.java

**Core Concepts:** String manipulation and number base conversion

- **Character Counting**: Count occurrences of specific characters in strings
- **Base Conversion**: Convert strings from octal (0), decimal, or hexadecimal (0x) to decimal
- **Number Parsing**: Handle different number formats (8, 10, 16 base systems)
- **Character-to-Integer**: Convert individual characters to their numeric values

```java
// Example usage:
int count = countCharInString("hello", 'l');  // Returns 2
int decimal = toInt("0xFF");  // Returns 255 (hex to decimal)
int octal = toInt("077");     // Returns 63 (octal to decimal)
```

### CumulativeSum.java

**Core Concepts:** In-place array transformation and accumulation patterns

- **Cumulative Operations**: Transform array to contain running sums
- **In-place Modification**: Modify original array without creating new arrays
- **Memory Efficiency**: Process arrays with O(1) additional space

```java
// Example usage:
int[] arr = {1, 2, 4, 8};
accumulate(arr);  // arr becomes {1, 3, 7, 15}
```

### OverLoading.java

**Core Concepts:** Method overloading and parameter type resolution

- **Method Signatures**: Different parameter types and counts
- **Type Resolution**: How Java chooses which overloaded method to call
- **Automatic Type Conversion**: Understanding when types are automatically converted

```java
// Example methods:
overLoaded(int, double, int)     // Method 1
overLoaded(double, int, int)     // Method 2
overLoaded(int, double)          // Method 3
```

### CopyArray.java

**Core Concepts:** 2D array operations and deep copying

- **Deep Copy**: Create independent copies of nested arrays
- **Null Safety**: Handle null inner arrays gracefully
- **Memory Management**: Proper allocation for jagged arrays
- **2D Array Traversal**: Nested loops for multi-dimensional data

```java
// Example usage:
int[][] original = {{8, 4}, {11}, {}, null};
int[][] copy = copyArray(original);  // Creates independent copy
```

### Ceasar.java

**Core Concepts:** Cryptography and character manipulation

- **Caesar Cipher**: Shift-based encryption algorithm
- **Character Arithmetic**: ASCII value manipulation for letters
- **Modular Arithmetic**: Wrapping around alphabet boundaries
- **Case Preservation**: Handle both uppercase and lowercase letters
- **Encryption/Decryption**: Bidirectional transformation

```java
// Example usage:
String encrypted = encrypt("HELLO", 3);   // Returns "KHOOR"
String decrypted = decrypt("KHOOR", 3);   // Returns "HELLO"
```

### RomanToNumber.java

**Core Concepts:** Number system conversion and parsing algorithms

- **Roman Numerals**: I=1, V=5, X=10, L=50, C=100, D=500, M=1000
- **Subtraction Rules**: Handle cases like IV=4, IX=9, XL=40, etc.
- **String Parsing**: Process characters sequentially with lookahead
- **Historical Number Systems**: Understanding ancient numbering

```java
// Example usage:
int value1 = romanToDecimal("XIV");    // Returns 14
int value2 = romanToDecimal("CMLIV");  // Returns 954
```

### SubString.java

**Core Concepts:** String analysis and pattern counting

- **Substring Counting**: Count substrings with specific character patterns
- **Pattern Matching**: Find substrings that start, end, and contain specific characters
- **String Traversal**: Efficient character-by-character processing
- **Combinatorial Analysis**: Calculate possible substring combinations

```java
// Example usage:
int count = subStrC("abcbsbsbb", 'b');        // Count substrings with exactly one 'b'
int maxCount = subStrMaxC("abcbsbsbb", 'b', 3); // Count with max 3 'b's
```

## 🎯 Learning Objectives

### Algorithm Analysis

- Understand time complexity: O(1), O(log n), O(n), O(n²)
- Compare search algorithms: linear vs binary search
- Analyze sorting algorithms: insertion vs selection sort
- Learn when to use different algorithms based on data characteristics

### Function Design Principles

- **Single Responsibility**: Each function has one clear purpose
- **Parameter Validation**: Proper error handling and input validation
- **Return Values**: Consistent and meaningful return patterns
- **Method Overloading**: Creating flexible APIs with multiple signatures

### String Processing Techniques

- Character-level manipulation and analysis
- Pattern recognition and substring operations
- Number system conversions and parsing
- Cryptographic transformations

### Array Operations

- 1D and 2D array manipulation
- In-place vs out-of-place modifications
- Deep copying and memory management
- Null safety and defensive programming

## 🚀 Getting Started

### Running the Examples

```bash
# Compile any Java file
javac SearchAndSort.java

# Run the compiled program
java SearchAndSort

# Each file contains a main method with example usage
```

### Key Programming Patterns

1. **Input Validation**: Always check for null arrays and valid indices
2. **Algorithm Selection**: Choose appropriate algorithms based on data size and properties
3. **Error Handling**: Use IllegalArgumentException for invalid inputs
4. **Method Documentation**: Clear parameter assumptions and return value descriptions

### Common Use Cases

- **Searching**: Find elements in sorted/unsorted collections
- **Sorting**: Organize data for efficient access
- **String Processing**: Text analysis, parsing, and transformation
- **Cryptography**: Basic encryption and decryption techniques
- **Data Conversion**: Between different number systems and formats

## 🔧 Advanced Topics Covered

### Performance Considerations

- **Binary Search**: Requires sorted data but offers O(log n) performance
- **Insertion Sort**: Efficient for small or nearly-sorted arrays
- **Selection Sort**: Consistent O(n²) performance regardless of input
- **In-place Operations**: Memory-efficient algorithms that modify original data

### Real-World Applications

- **Search Algorithms**: Database indexing, web search, file systems
- **Sorting**: Data organization, preprocessing for other algorithms
- **String Processing**: Text editors, compilers, data parsing
- **Encryption**: Secure communications, data protection
- **Number Conversion**: Computer systems, data interchange formats

## 📚 Connection to Other Topics

This folder serves as a foundation for:

- **Recursion**: Many of these algorithms have recursive implementations
- **Object-Oriented Programming**: These functions can be encapsulated in classes
- **Data Structures**: Arrays are the foundation for more complex structures
- **Algorithm Design**: Patterns learned here apply to more advanced algorithms

## 🎮 Integration with Learning Game

These concepts are featured in **Stage 3** of the Java Learning Game (`stage_3.java`), which includes:

- Interactive questions about search and sort algorithms
- String manipulation challenges
- Method overloading scenarios
- 2D array operations puzzles
- Real code execution simulation

The game helps reinforce these concepts through hands-on practice and immediate feedback!

---

_This folder represents a crucial step in Java programming education, bridging basic syntax with algorithmic thinking and preparing students for more advanced computer science concepts._
