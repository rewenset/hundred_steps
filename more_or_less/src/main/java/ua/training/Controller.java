package ua.training;

import java.util.Scanner;

/**
 * Contains main game loop method and input checker method.
 * Sets range of random number for the game.
 *
 * @author Andriy Zakurenyi
 */
public class Controller {

    private Model model;
    private View view;

    /**
     * Constructor which connects controller with model and view
     *
     * @param model the model of the game-app
     * @param view  the view of the game-app
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Main game loop.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setLimits(GlobalConstants.PRIMARY_MIN_LIMIT, GlobalConstants.PRIMARY_MAX_LIMIT);
        model.thinkOfNewNumber();

        while (!model.isCorrect(getInputValueWithScanner(sc))) {
        }

        view.printNewLineMessage(View.YOU_WIN);
        view.printStatistic(model.getEnteredNumbers());
    }

    /**
     * Input checker. Ask to input another value while current is not integer or
     * if given number outside of the range (- between left and right limits).
     *
     * @param sc input stream
     * @return users input value
     */
    public int getInputValueWithScanner(Scanner sc) {
        int res = getIntValueWithScanner(sc);
        while ((res <= model.getLeftLimit()) || (res >= model.getRightLimit())) {
            view.printNewLineMessage(View.WRONG_INPUT_OUT_OF_LIMITS);
            res = getIntValueWithScanner(sc);
        }
        return res;
    }


    /**
     * Input checker. Ask to input another value while current is not integer.
     *
     * @param sc input stream
     * @return users input value
     */
    public int getIntValueWithScanner(Scanner sc) {
        view.printMessageWithLimits(View.INPUT_INT_DATA, model.getLeftLimit(), model.getRightLimit());
        while (!sc.hasNextInt()) {
            view.printNewLineMessage(View.WRONG_INPUT_INT_REQUIRED);
            view.printMessageWithLimits(View.INPUT_INT_DATA, model.getLeftLimit(), model.getRightLimit());
            sc.next();
        }
        return sc.nextInt();
    }
}
