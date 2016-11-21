package ua.training;

import ua.training.model.entity.Stone;

import java.util.ArrayList;

/**
 * View of necklace creation process.
 * @author Andriy Zakurenyi
 */
public class View {
    //Text's constants
    public static final String BEGINING = "Firstly, let's add several stones. \nPlease give answer to following questions.";
    public static final String WRONG_INPUT_Y_OR_N_REQUIRED = "Wrong input. Please, input \"y\" to add new stone " +
            "or \"n\" for finish adding.";
    public static final String WRONG_INPUT_NAME_REQUIRED = "Wrong input. Please, input name of the new stone again.";
    public static final String WRONG_INPUT = "Wrong input. Please, input positive number larger than zero.";
    public static final String NAME_OF_STONE = "Name: ";
    public static final String WEIGHT_OF_STONE = "Weight: ";
    public static final String CLARITY_OF_STONE = "Clarity: ";
    public static final String PRICE_OF_STONE = "Price: ";
    public static final String NEW_STONE = "Add new stone? Type in \"y\" for yes and \"n\" for no:";
    public static final String CLARITY_RANGE_FROM = "Clarity range from:";
    public static final String CLARITY_RANGE_TO = "Clarity range to:";
    public static final String WEIGHT = "Total weight of necklace is ";
    public static final String ALL_STONES = "- all stones:";
    public static final String ALL_STONES_SORTED = "- all stones sorted:";
    public static final String ALL_STONES_RANGE = "- all stones with given clarity range:";
    public static final String EMPTY_LIST = "empty list";



    /**
     * Prints a message without switching to a new line.
     * @param message string which will be printed.
     */
    public void printMessage(String message) {
        System.out.print(message);
    }

    /**
     * Prints a message with switching to a new line.
     * @param message string which will be printed.
     */
    public void printNewLineMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints separate line.
     */
    public void printSeparateLine() {
        System.out.println("");
    }

    /**
     * Prints all elements in arrayList.
     * @param stones input list
     */
    public void printStones(ArrayList<Stone> stones) {
        if (stones.size() == 0) {
            printNewLineMessage(EMPTY_LIST);
        } else {
            for (Stone stone : stones) {
                printNewLineMessage(stone.toString());
            }
        }
    }
}
