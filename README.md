This project implements a predictive parser for a context-free grammar (CFG) as specified. The parser traces input strings over the alphabet { i, +, - , *, / ), ( } and ending with $.

## Features

- **Parsing Algorithm**: The parser uses a predictive parsing algorithm to determine whether input strings are valid according to the specified CFG and parsing table.

- **Error Handling**: The parser includes error handling mechanisms to detect invalid input strings and grammar violations.

- **Input Validation**: Before parsing, the input string is validated to ensure it contains only valid symbols according to the grammar alphabet.

- **Optimizations**: While not explicitly implemented in this version, the parser can be optimized further for efficiency using memoization or other parsing techniques.

## Usage

1. **Compile**: Compile the Parser.java file using a Java compiler.

    ```
    javac Parser.java
    ```

2. **Run**: Run the compiled program.

    ```
    java Parser
    ```

3. **Input Strings**: The program will prompt you to enter input strings for parsing. Each input string should consist of valid symbols from the grammar alphabet { i, +, - , *, / ), ( } and end with '$'.

4. **Output**: The program will output whether each input string is accepted/valid or not accepted/invalid according to the grammar.

## Files

- **Parser.java**: Contains the implementation of the predictive parser.
- **README.md**: This file provides information about the project and instructions for usage.

## License

This project is licensed under the [MIT License](LICENSE).
