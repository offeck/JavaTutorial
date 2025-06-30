# Question Class Documentation

## Overview

The `Question` class is a reusable component designed for creating interactive Java debugging exercises. It encapsulates all the necessary data and logic required to present coding challenges to users, capture their responses, validate answers, and provide educational feedback.

## Purpose

This class serves as the foundation for the Java Tutorial's stage-based learning system, where each stage contains multiple questions that test different aspects of Java programming concepts.

## Class Structure

### Fields

- **`title`** (String, final): The descriptive title of the question
- **`codeLines`** (String[], final): Array containing the code snippet to be analyzed
- **`execution`** (Supplier<String>, final): Functional interface that provides the actual code execution result
- **`explanation`** (String, final): Educational explanation provided after answer validation
- **`inputPrompt`** (String, final): Custom prompt text for user input (defaults to "Your answer: ")
- **`wasCorrect`** (boolean): Tracks whether the user answered correctly

### Constructors

#### Primary Constructor

```java
public Question(String title, String[] codeLines, Supplier<String> execution,
                String explanation, String inputPrompt)
```

Creates a fully customized question with all parameters.

#### Simplified Constructor

```java
public Question(String title, String[] codeLines, Supplier<String> execution,
                String explanation)
```

Creates a question using the default input prompt "Your answer: ".

### Core Methods

#### `execute(Scanner scanner, int questionNumber)`

**Purpose**: Main execution method that handles the complete question lifecycle.

**Process**:

1. Displays the question title and number
2. Shows the code snippet line by line
3. Prompts user for their answer
4. Executes the code simulation
5. Validates the answer and provides feedback

**Parameters**:

- `scanner`: Scanner instance for user input
- `questionNumber`: The sequential number of the question in the stage

#### `wasCorrect()`

**Purpose**: Returns whether the user answered the question correctly.

**Return**: boolean indicating correctness

#### `showFinalResults()` (Static Method)

**Purpose**: Displays comprehensive stage completion summary with performance metrics and learning resources.

**Parameters**:

- `score`: Number of correct answers
- `totalQuestions`: Total number of questions attempted
- `stageName`: Name of the completed stage
- `keyConcepts`: Array of key concepts covered
- `tips`: Array of learning tips
- `folderInfo`: Information about related code folders
- `exploreFiles`: Array of recommended files to explore
- `advancedFiles`: Array of advanced files for further learning
- `congratsMessage`: Personalized completion message

## Usage Pattern

### Basic Question Creation

```java
Question q1 = new Question(
    "Basic Variable Assignment",
    new String[]{
        "int x = 5;",
        "int y = x + 3;",
        "System.out.println(y);"
    },
    () -> "8",
    "This demonstrates basic variable assignment and arithmetic operations."
);
```

### Question Execution

```java
Scanner scanner = new Scanner(System.in);
q1.execute(scanner, 1);
```

### Score Tracking

```java
int score = 0;
// After executing each question
if (q1.wasCorrect()) {
    score++;
}
```

## Design Patterns Used

### 1. **Supplier Pattern**

The `execution` field uses Java's `Supplier<String>` functional interface, allowing lazy evaluation of code results. This design enables:

- Separation of question definition from execution logic
- Flexible code simulation without actual compilation
- Easy testing and modification of expected outputs

### 2. **Builder Pattern Elements**

While not a full builder pattern, the class uses constructor overloading to provide flexibility in question creation.

### 3. **Template Method Pattern**

The `execute()` method follows a consistent template for all questions while allowing customization through the constructor parameters.

## Integration with Stage System

### Stage Structure

Each stage file (e.g., `stage_7.java`) follows this pattern:

1. Create multiple Question instances
2. Execute each question sequentially
3. Track scores
4. Display final results with educational content

### Example Integration

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int score = 0;

    Question q1 = createQuestion1();
    q1.execute(scanner, 1);
    if (q1.wasCorrect()) score++;

    // ... more questions

    Question.showFinalResults(score, totalQuestions, "Stage 7",
                            keyConcepts, tips, folderInfo,
                            exploreFiles, advancedFiles, congratsMessage);
}
```

## Educational Benefits

### 1. **Interactive Learning**

- Immediate feedback on answers
- Visual code presentation
- Hands-on practice with code prediction

### 2. **Progressive Difficulty**

- Structured stage-based progression
- Concept reinforcement through repetition
- Building complexity across stages

### 3. **Comprehensive Feedback**

- Detailed explanations for each question
- Performance metrics and scoring
- Resource recommendations for further learning

## Technical Considerations

### Memory Efficiency

- Uses final fields to ensure immutability
- Minimal object creation during execution
- Efficient string handling for code display

### Extensibility

- Easy to add new question types
- Flexible execution model supports various code scenarios
- Modular design allows for easy maintenance

### Error Handling

- Graceful handling of user input
- Clear feedback for incorrect answers
- No runtime exceptions in normal usage

## Best Practices for Question Creation

### 1. **Clear Code Examples**

- Use readable, properly formatted code
- Include meaningful variable names
- Keep examples focused on specific concepts

### 2. **Educational Explanations**

- Explain the "why" behind the correct answer
- Reference relevant Java concepts
- Provide context for the learning objective

### 3. **Appropriate Difficulty**

- Match question complexity to stage level
- Build upon previously introduced concepts
- Provide reasonable challenges without frustration

## Conclusion

The `Question` class provides a robust, flexible foundation for creating interactive Java learning experiences. Its design promotes code reusability, educational effectiveness, and maintainable stage development. The class successfully abstracts the complexity of question management while providing rich functionality for both educators and learners.
