package ua.training;

import ua.training.model.Necklace;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Necklace creation controller.
 * Helps user to create a number of stones for necklace.
 * @author Andriy Zakurenyi
 */
public class Controller {
    /** necklace is our model */
    private Necklace necklace;
    /** view of the necklace creation process*/
    private View view;

    public Controller(Necklace model, View view) {
        this.necklace = model;
        this.view = view;
    }

    /**
     * Helps user to create a number of stones for necklace.
     *
     */
    public void processUser() {

        Scanner sc = new Scanner(System.in);
        Pattern yesOrNoPattern = Pattern.compile("[yn]");
        Pattern newStoneNamePattern = Pattern.compile("\\w{3,12}");

        view.printNewLineMessage(View.BEGINING);

        double weight, clarity, price;
        String name;
//        do {
//            name    = getMatchingValue(sc, newStoneNamePattern, View.NAME_OF_STONE, View.WRONG_INPUT_NAME_REQUIRED);
//            weight  = getPositiveDoubleValue(sc, View.WEIGHT_OF_STONE);
//            clarity = getPositiveDoubleValue(sc, View.CLARITY_OF_STONE);
//            price   = getPositiveDoubleValue(sc, View.PRICE_OF_STONE);
//
//            necklace.addStone(name, weight, clarity, price);
//            view.printMessage(View.NEW_STONE);
//        } while (getMatchingValueWithScanner(sc, yesOrNoPattern, View.WRONG_INPUT_Y_OR_N_REQUIRED).equals("y"));
//
//        double clarityFrom = getPositiveDoubleValue(sc,View.CLARITY_RANGE_FROM);
//        double clarityTo = getPositiveDoubleValue(sc,View.CLARITY_RANGE_TO);


        necklace.addStone("diamond", 5, 1.3, 1);
        necklace.addStone("topaz",   2, 1.6, 1);
        necklace.addStone("pearl",   4, 1.2, 1);
        necklace.addStone("ruby",    3, 1.0, 1);
        double clarityFrom = 1.1;
        double clarityTo = 1.4;
        view.printSeparateLine();
        view.printNewLineMessage(View.WEIGHT + necklace.getNecklaceWeight());
        view.printSeparateLine();
        view.printNewLineMessage(View.ALL_STONES);
        view.printStones(necklace.getStones());
        view.printSeparateLine();
        view.printNewLineMessage(View.ALL_STONES_SORTED);
        view.printStones(necklace.getSortedByWorthStones());
        view.printSeparateLine();
        view.printNewLineMessage(View.ALL_STONES_RANGE);
        view.printStones(necklace.getStonesInRangeOfClarity(clarityFrom, clarityTo));
    }

    /**
     * Check if input match the specified pattern. If it doesn't -- asks for new input.
     * @param sc        Input stream.
     * @param pt        Pattern to match input.
     * @param outputMsg This message will be printed in the beginning.
     * @param errorMsg  This message will be printed if input value doesn't match the specified pattern.
     * @return String witch mach the specified pattern.
     */
    public String getMatchingValue(Scanner sc, Pattern pt, String outputMsg, String errorMsg) {
        view.printMessage(outputMsg);
        return getMatchingValueWithScanner(sc, pt, errorMsg);
    }

    /**
     * Check if input is positive double. If it doesn't -- asks for new input.
     * @param sc        Input stream.
     * @param outputMsg This message will be printed in the beginning.
     * @return          double value.
     */
    public double getPositiveDoubleValue(Scanner sc, String outputMsg) {
        view.printMessage(outputMsg);
        double retValue;
        while ((retValue = getDoubleValueWithScanner(sc, View.WRONG_INPUT)) <= 0) {
            view.printNewLineMessage(View.WRONG_INPUT);
        }
        return retValue;
    }

    /**
     * Check if input is double. If it doesn't -- asks for new input.
     *
     * @param sc       Input stream.
     * @param errorMsg This message will be printed if input value isn't double.
     * @return double value.
     */
    public double getDoubleValueWithScanner(Scanner sc, String errorMsg) {
        while (!sc.hasNextDouble()) {
            view.printNewLineMessage(errorMsg);
            sc.next();
        }
        return sc.nextDouble();
    }

    /**
     * Check if input match the specified pattern. If it doesn't -- asks for new input.
     *
     * @param sc       Input stream.
     * @param pt       Pattern to match input.
     * @param errorMsg This message will be printed if input value doesn't match the specified pattern.
     * @return String witch mach the specified pattern.
     */
    public String getMatchingValueWithScanner(Scanner sc, Pattern pt, String errorMsg) {
        while (!sc.hasNext(pt)) {
            view.printNewLineMessage(errorMsg);
            sc.next();
        }
        return sc.next().trim();
    }
}
