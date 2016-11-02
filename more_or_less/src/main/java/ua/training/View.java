package ua.training;

import java.util.ArrayList;

/**
 * Contains fields and methods that intended for displaying all sorts of game info to user.
 *
 * @author Andriy Zakurenyi
 */
public class View {
    //Text's constants
    public static final String NEW_LIMITS_QUESTION = "Do you want to enter your limits? (for yes input 1, for no - 0): ";
    public static final String WRONG_INPUT_TO_LIMITS_QUESTION = "Wrong input. Please, input 1 for new limits and 0 for defaults: ";
    public static final String DEFAULT_LIMITS_IS_SET = "OK, will use defaults.";
    public static final String SETUP_NEW_LIMITS = "Setting up new limits";
    public static final String NEW_LEFT_LIMIT = "Input left limit: ";
    public static final String NEW_RIGHT_LIMIT = "Input right limit: ";
    public static final String LIMITS_INPUT_ERROR = "Please, choose right limit greater then %d.";
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
     * Prints a message with one integers, formatted to the message,
     * with switching to a new line.
     *
     * @param message string which will be modified and printed.
     */
    public void printMessageWithInt(String message, int number) {
        printNewLineMessage(String.format(message, number));
    }

    /**
     * Prints a message with two integers, formatted to the message,
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
