package ua.training;

import java.util.ArrayList;

/**
 * Contains fields and methods that intended for displaying all sorts of game info to user.
 *
 * @author Andriy Zakurenyi
 */
public class View {
    //Text's constants
    public static final String INPUT_INT_DATA = "Guess the number between %d and %d: ";
    public static final String WRONG_INPUT_INT_REQUIRED = "Wrong input. Please, input integer number.";
    public static final String WRONG_INPUT_OUT_OF_LIMITS = "Oops, you out of limits. Try again.";
    public static final String GREATER_THEN = "The correct number is GREATER than your guess.";
    public static final String LESS_THEN = "The correct number is LESS than your guess.";
    public static final String YOU_WIN = "You Win.";
    public static final String NUMBER_OF_ATTEMPTS = "There were %d attempts: ";


    /**
     * Prints a message without switching to a new line.
     *
     * @param message string which will be printed.
     */
    public void printMessage(String message) {
        System.out.print(message);
    }

    /**
     * Prints a message with switching to a new line.
     *
     * @param message string which will be printed.
     */
    public void printNewLineMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a message with two integers, appended to the end,
     * without switching to a new line.
     * Used for printing input invitation and limits.
     *
     * @param message string which will be modified and printed.
     */
    public void printMessageWithLimits(String message, int left, int right) {
        printMessage(String.format(message, left, right));
    }

    /**
     * Prints size and all elements of ArrayList.
     * Elements separated by semicolon and space.
     * Used for printing statistics.
     *
     * @param enteredNumbers list with integers that the user entered
     */
    public void printStatistic(ArrayList<Integer> enteredNumbers) {
        printMessage(String.format(NUMBER_OF_ATTEMPTS, enteredNumbers.size()));
        for (Integer number : enteredNumbers) {
            printMessage(number + "; ");
        }
    }
}
