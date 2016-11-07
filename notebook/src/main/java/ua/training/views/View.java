package ua.training.views;

/**
 * Created by Andriy on 06.11.2016.
 */
public class View {
    public static final String GREETING = "Hello, %username%!";
    public static final String MAIN_QUESTION = "\nWould you like to add a new record? (y - yes, n - no): ";
    public static final String WRONG_INPUT = "Wrong input. Try again.";
    public static final String WRONG_INPUT_Y_OR_N_REQUIRED = "Wrong input. Please, input \"y\" to create new record " +
            "or \"n\" for exit.";
    public static final String NEW_RECORD_CREATION = "Creating a New Record.\nPlease, input following information:";
    public static final String FIELD_INPUT = "- %s:";
    public static final String ADIEU = "\nBye :)";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageWithNewLine(String message) {
        System.out.println(message);
    }

    public void printField(String fieldName) {
        printMessage(String.format(FIELD_INPUT, fieldName));
    }
}
