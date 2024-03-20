import java.util.HashMap;
import java.util.Stack;

public class Parser {
    // Parsing table represented as a HashMap
    private static HashMap<String, HashMap<String, String>> parsingTable = new HashMap<>();

    static {
        // Populate the parsing table according to the given table
        // Example: parsingTable.put("E", new HashMap<String, String>() {{
        //     put("a", "TQ");
        //     put("+", "error");
        //     ...
        // }});
    }

    // Method to parse the input string
    public static boolean parse(String input) {
        // Validate input string
        if (!isValidInput(input)) {
            System.err.println("Invalid input string. Make sure it contains only valid symbols.");
            return false;
        }

        // Initialize stack and push initial symbol $
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("E");

        int index = 0;
        String currentSymbol = stack.peek();
        char currentInput = input.charAt(index);

        while (!stack.isEmpty()) {
            if (currentSymbol.equals("$")) {
                // If stack symbol is $ and input is also $, accept the string
                if (currentInput == '$' && index == input.length() - 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (currentSymbol.equals(String.valueOf(currentInput))) {
                // If stack symbol matches current input, pop the stack and move to next input
                stack.pop();
                index++;
                if (index < input.length()) {
                    currentInput = input.charAt(index);
                }
            } else if (parsingTable.containsKey(currentSymbol) && parsingTable.get(currentSymbol).containsKey(String.valueOf(currentInput))) {
                // If there's a valid entry in parsing table, replace stack top with parsing table entry
                stack.pop();
                String entry = parsingTable.get(currentSymbol).get(String.valueOf(currentInput));
                if (!entry.equals("\u025B")) { // Using Unicode escape sequence
                    // If entry is not epsilon, push symbols from right to left onto the stack
                    for (int i = entry.length() - 1; i >= 0; i--) {
                        stack.push(String.valueOf(entry.charAt(i)));
                    }
                }
            } else {
                // If no valid entry in parsing table, reject the string
                return false;
            }

            // Update current symbol
            currentSymbol = stack.peek();
        }

        return false;
    }

    // Method to validate input string against the grammar alphabet
    private static boolean isValidInput(String input) {
        String alphabet = "i+-*/()$"; // Valid symbols in the grammar
        for (char c : input.toCharArray()) {
            if (alphabet.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test strings
        String[] testStrings = {
            "(a+a)*a$",
            "a*(a/a)$",
            "a(a+a)$"
        };

        for (String testString : testStrings) {
            System.out.println("Input: " + testString);
            System.out.println("Output: " + (parse(testString) ? "String is accepted/valid." : "String is not accepted/invalid."));
            System.out.println();
        }
    }
}
