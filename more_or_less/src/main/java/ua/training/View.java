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
    public static final String WRONG_INPUT_INT_REQUIRED = "Wrong input. Please, input integer number: ";
    public static final String WRONG_INPUT_OUT_OF_LIMITS = "Oops, you out of limits. Try again.";
    public static final String YOU_WIN = "You Win.";
    public static final String NUMBER_OF_ATTEMPTS = "There were %d attempts.";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printNewLineMessage(String message) {
        System.out.println(message);
    }

    public void printMessageWithLimits(String message, int left, int right) {
        System.out.print(String.format(message, left, right));
    }

    public void printStatistic(ArrayList<Integer> enteredNumbers) {
        System.out.println(String.format(NUMBER_OF_ATTEMPTS, enteredNumbers.size()));
        for(Integer number : enteredNumbers) {
            System.out.print(number + "; ");
        }

    }
}
