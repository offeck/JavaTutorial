# Prime Algorithms and Arrays

This folder contains Java implementations of fundamental number theory algorithms, mathematical computations, and array-based solutions. These examples demonstrate essential programming concepts including prime number generation, greatest common divisor calculations, factorial computation, and mathematical problem-solving techniques.

## 📁 Contents Overview

| File                  | Algorithm/Concept          | Mathematical Focus        | Complexity      |
| --------------------- | -------------------------- | ------------------------- | --------------- |
| `AllPrimes.java`      | Basic Prime Generation     | Primality Testing         | O(n√n)          |
| `AllPrimesArray.java` | Optimized Prime Generation | Sieve-like Algorithm      | O(n√p)          |
| `Factorial.java`      | Factorial Calculation      | Product Accumulation      | O(n)            |
| `Factorial2.java`     | Alternative Factorial      | Different Implementation  | O(n)            |
| `FindDivisors.java`   | Divisor Finding            | Prime Factorization       | O(√n)           |
| `GCD.java`            | Euclidean Algorithm        | Greatest Common Divisor   | O(log min(a,b)) |
| `NaiveGCD.java`       | Brute Force GCD            | Simple GCD Approach       | O(min(a,b))     |
| `SpecialNumbers.java` | Kaprekar Numbers           | Special Number Properties | O(n)            |
| `Digits.java`         | Digit Counting             | Number Decomposition      | O(log n)        |
| `IsSumEven.java`      | Sum Parity Check           | Accumulation Patterns     | O(n)            |
| `IsSumEven2.java`     | Alternative Sum Check      | Different Implementation  | O(n)            |
| `HelloWorld.java`     | Basic Output               | Introduction to Java      | O(1)            |

## 🔍 Detailed Algorithm Descriptions

### Prime Number Algorithms

#### AllPrimes.java - Basic Prime Generation

**Mathematical Concept:** Trial division method for primality testing

- **Algorithm**: For each number n, test divisibility by all numbers from 2 to √n
- **Optimization**: Only check up to square root of the candidate number
- **Use Case**: Finding all primes up to a given limit
- **Time Complexity**: O(n√n) where n is the upper limit

```java
// Core logic: Test each number for primality
int divisor = 2;
while (divisor * divisor <= number && isPrime) {
    if (number % divisor == 0) {
        isPrime = false;
    }
    divisor = divisor + 1;
}
```

#### AllPrimesArray.java - Optimized Prime Generation

**Mathematical Concept:** Incremental sieve using previously found primes

- **Algorithm**: Use array of previously found primes to test new candidates
- **Optimization**: Only test divisibility against known primes (not all numbers)
- **Efficiency**: Significantly faster than basic method for large ranges
- **Space Trade-off**: Uses O(π(n)) space to store primes for O(n√p) time improvement

```java
// Enhanced logic: Only test against previously found primes
for(int primesIndex = 0; primesIndex < numberOfPrimes &&
    primes[primesIndex]*primes[primesIndex] <= number && isPrime;
    primesIndex = primesIndex + 1) {
    if (number % primes[primesIndex] == 0) {
        isPrime = false;
    }
}
```

### Greatest Common Divisor Algorithms

#### GCD.java - Euclidean Algorithm

**Mathematical Concept:** Based on the principle that gcd(a,b) = gcd(b, a mod b)

- **Algorithm**: Repeatedly apply modular arithmetic until remainder is 0
- **Efficiency**: One of the most efficient algorithms for GCD
- **Historical**: Dates back to Euclid (~300 BCE)
- **Applications**: Cryptography, fraction simplification, number theory

```java
// Euclidean algorithm implementation
int r = m % n;
while (r != 0) {
    m = n;
    n = r;
    r = m % n;
}
// Result is in n
```

#### NaiveGCD.java - Brute Force Approach

**Mathematical Concept:** Test all possible divisors in descending order

- **Algorithm**: Start from min(a,b) and test each number until both divide evenly
- **Simplicity**: Easy to understand but inefficient for large numbers
- **Comparison**: Demonstrates why Euclidean algorithm is superior
- **Educational**: Good for understanding the GCD concept

### Factorial Algorithms

#### Factorial.java - Basic Factorial Computation

**Mathematical Concept:** n! = n × (n-1) × (n-2) × ... × 1

- **Algorithm**: Iterative multiplication from 1 to n
- **Loop Structure**: While loop with accumulator pattern
- **Applications**: Combinatorics, probability, mathematical analysis
- **Limitation**: Integer overflow for large values of n

```java
// Accumulation pattern for factorial
int fact = 1;
int i = 1;
while (i <= n) {
    fact = fact * i;
    i = i + 1;
}
```

### Number Analysis Algorithms

#### FindDivisors.java - Prime Factorization

**Mathematical Concept:** Every composite number has a divisor ≤ √n

- **Algorithm**: Find first divisor, which gives immediate factorization
- **Efficiency**: Stops at first divisor found (not all divisors)
- **Application**: Determines if number is prime or finds factor pair
- **Output**: Either declares prime or shows one factor pair

#### SpecialNumbers.java - Kaprekar Numbers

**Mathematical Concept:** Numbers where sum of split square equals original number

- **Definition**: For number n, if n² split into parts gives sum = n
- **Example**: 45² = 2025, split as 20 + 25 = 45
- **Range**: Searches numbers 32-99 (4-digit squares that split into 2-digit parts)
- **Mathematical Interest**: Demonstrates number properties and digit manipulation

```java
// Kaprekar number detection
int leftPart = (i*i)/100;     // First two digits of i²
int rightPart = (i*i)%100;    // Last two digits of i²
if (leftPart + rightPart == i) {
    System.out.println(i);    // Found Kaprekar number
}
```

#### Digits.java - Digit Counting

**Mathematical Concept:** Logarithmic relationship between number and digit count

- **Algorithm**: Repeatedly divide by 10 until number becomes single digit
- **Mathematical Insight**: Number of digits = floor(log₁₀(n)) + 1
- **Applications**: Number formatting, mathematical analysis, algorithm complexity
- **Pattern**: Each division by 10 removes one digit

### Accumulation Algorithms

#### IsSumEven.java - Sum Parity Analysis

**Mathematical Concept:** Accumulation pattern with termination condition

- **Algorithm**: Read positive numbers, accumulate sum, stop on non-positive
- **Parity Check**: Determine if final sum is even or odd using modulo
- **Input Pattern**: Demonstrates sentinel-controlled loops
- **Application**: Data validation, statistical analysis

## 🎯 Learning Objectives

### Mathematical Algorithm Design

- **Prime Numbers**: Understanding primality testing and optimization techniques
- **Number Theory**: GCD algorithms and their mathematical foundations
- **Combinatorics**: Factorial computation and its applications
- **Number Properties**: Special numbers and their mathematical significance

### Programming Patterns

- **Loop Structures**: While loops, for loops, and nested loop patterns
- **Accumulation**: Building results incrementally (factorial, sum, prime collection)
- **Early Termination**: Optimization through break conditions
- **Array Usage**: Dynamic arrays for storing computational results

### Algorithmic Thinking

- **Efficiency Analysis**: Comparing naive vs optimized approaches
- **Mathematical Optimization**: Using mathematical properties to reduce computation
- **Space-Time Trade-offs**: Array storage vs repeated computation
- **Algorithm Complexity**: Understanding Big O notation through examples

## 🚀 Mathematical Applications

### Cryptography

- **Prime Generation**: RSA encryption relies on large prime numbers
- **GCD Algorithms**: Used in modular arithmetic and key generation
- **Factorization**: Security depends on difficulty of prime factorization

### Computer Science

- **Algorithm Analysis**: These algorithms demonstrate complexity classes
- **Data Structures**: Arrays used for storing and accessing computed values
- **Optimization**: Show progression from naive to efficient implementations

### Pure Mathematics

- **Number Theory**: Prime distribution, GCD properties, factorial growth
- **Combinatorics**: Factorial appears in permutations and combinations
- **Mathematical Discovery**: Kaprekar numbers showcase interesting number properties

## 🔧 Implementation Insights

### Optimization Techniques

1. **Early Termination**: Stop checking when answer is found
2. **Mathematical Bounds**: Only check up to √n for primality
3. **Precomputation**: Store results for reuse (prime array)
4. **Algorithm Selection**: Choose appropriate method based on requirements

### Common Patterns

- **Scanner Input**: Consistent input handling across programs
- **Accumulation**: Building results through iterative processes
- **Boolean Flags**: Using flags to control loop termination
- **Modular Arithmetic**: Essential for many number theory algorithms

### Error Considerations

- **Integer Overflow**: Factorial grows very quickly
- **Input Validation**: Assuming positive integers where specified
- **Edge Cases**: Handling n=1, n=2 for prime algorithms
- **Resource Management**: Proper Scanner closing

## 📚 Historical and Mathematical Context

### Ancient Algorithms

- **Euclidean Algorithm**: One of the oldest algorithms still in use
- **Sieve of Eratosthenes**: Ancient prime-finding method (basis for optimized version)
- **Prime Fascination**: Mathematical interest spanning millennia

### Modern Applications

- **Computer Security**: Prime numbers in encryption
- **Mathematical Research**: Continued study of prime patterns
- **Computational Challenges**: Large-scale prime finding and factorization

## 🎮 Integration with Learning Game

These concepts are featured in **Stage 2** of the Java Learning Game (`stage_2.java`), which includes:

- Interactive questions about prime algorithms
- Factorial computation challenges
- GCD algorithm comparisons
- Array-based optimization scenarios
- Real algorithm execution simulation

The game reinforces understanding through:

- Step-by-step algorithm tracing
- Complexity comparison exercises
- Mathematical property exploration
- Code optimization challenges

## 🌟 Key Takeaways

### Algorithm Efficiency

- Simple solutions work but may not scale
- Mathematical insights often lead to dramatic improvements
- Understanding problem structure enables optimization

### Mathematical Programming

- Algorithms can implement mathematical concepts directly
- Programming provides tools for mathematical exploration
- Efficiency matters for practical applications

### Foundation Building

- These algorithms form basis for more advanced topics
- Patterns learned here apply to complex data structures
- Mathematical thinking enhances programming skills

---

_This folder represents the intersection of mathematics and programming, showing how fundamental algorithms implement important mathematical concepts while teaching essential programming patterns and optimization techniques._
