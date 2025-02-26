import java.util.Stack;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A program that reads a list of integer numbers from user input,
 * stores them in a Stack, sorts them in ascending order,
 * prints the sorted Stack, and saves it to a file.
 *
 * This program follows best coding practices and uses the Java Collections Framework.
 * It is designed to be run from the command line without needing an IDE.
 *
 * To compile:
 * javac SortedStack.java
 *
 * To run:
 * java SortedStack
 *
 * To generate Javadoc:
 * javadoc -d docs SortedStack.java
 */
public class SortedStack {

    /**
     * Reads integers from standard input, stores them in a Stack,
     * sorts the Stack, prints the sorted numbers, and saves them to a file.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();

        System.out.println("Enter integers (type 'done' to finish):");

        // Read input and push to Stack
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.push(scanner.nextInt()); // Stack insertion (push)
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
                }
            }
        }
        scanner.close();

        // Sort the stack (sort the elements first)
        Stack<Integer> sortedStack = sortStack(numbers);

        // Print the sorted numbers from the stack
        System.out.println("Sorted Stack (top to bottom):");
        printStack(sortedStack);

        // Save sorted stack to a file
        saveToFile(sortedStack);
    }

    /**
     * Sorts a stack in ascending order.
     *
     * @param stack The stack to be sorted.
     * @return A new sorted stack.
     */
    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        Collections.sort(stack); // Sorts stack in place
        return stack;
    }

    /**
     * Prints the elements of the stack, showing how they would be removed (LIFO).
     *
     * @param stack The stack to print.
     */
    private static void printStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = (Stack<Integer>) stack.clone(); // Clone stack for display
        while (!tempStack.isEmpty()) {
            System.out.println(tempStack.pop()); // Pop elements to demonstrate LIFO
        }
    }

    /**
     * Saves the sorted stack of integers to a text file.
     *
     * @param stack The sorted stack of integers.
     */
    private static void saveToFile(Stack<Integer> stack) {
        try (FileWriter writer = new FileWriter("sorted_stack.txt")) {
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone(); // Clone to avoid modifying the original
            while (!tempStack.isEmpty()) {
                writer.write(tempStack.pop() + "\n");
            }
            System.out.println("Sorted stack saved to sorted_stack.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}
