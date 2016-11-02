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
        settingUpLimits(sc);
        model.thinkOfNewNumber();

        while (!model.isCorrect(getInputValueWithScanner(sc))) {
        }   //main game loop

        view.printNewLineMessage(View.YOU_WIN);
        view.printStatistic(model.getEnteredNumbers());
    }

    /**
     * This method setting up limits for the game. User choose if the limits
     * would be defaults (0 and 100) or new. If last one then method also checks
     * if right limit is greater than left limit.
     *
     * @param sc input stream.
     */
    public void settingUpLimits(Scanner sc) {
        view.printMessage(View.NEW_LIMITS_QUESTION);

        int option = getIntValueWithScanner(sc);

        while (option != 0 && option != 1) {
            view.printMessage(View.WRONG_INPUT_TO_LIMITS_QUESTION);
            option = getIntValueWithScanner(sc);
        }

        switch (option) {
            case 1:
                view.printNewLineMessage(View.SETUP_NEW_LIMITS);
                view.printMessage(View.NEW_LEFT_LIMIT);
                int left = getIntValueWithScanner(sc);
                view.printMessage(View.NEW_RIGHT_LIMIT);
                int right = getIntValueWithScanner(sc);
                while (right <= (left + 1)) {
                    view.printMessageWithInt(View.LIMITS_INPUT_ERROR, (left + 1));
                    view.printMessage(View.NEW_RIGHT_LIMIT);
                    right = getIntValueWithScanner(sc);
                }
                model.setLimits(left, right);
                break;
            case 0:
                model.setLimits(GlobalConstants.PRIMARY_MIN_LIMIT, GlobalConstants.PRIMARY_MAX_LIMIT);
                view.printMessage(View.DEFAULT_LIMITS_IS_SET);

        }
    }


    /**
     * Input checker. Ask to input another value while current is not integer or
     * if given number outside of the range (- between left and right limits).
     *
     * @param sc input stream
     * @return users input value
     */
    public int getInputValueWithScanner(Scanner sc) {
        view.printMessageWithLimits(View.INPUT_INT_DATA, model.getLeftLimit(), model.getRightLimit());
        int res = getIntValueWithScanner(sc);
        while ((res <= model.getLeftLimit()) || (res >= model.getRightLimit())) {
            view.printNewLineMessage(View.WRONG_INPUT_OUT_OF_LIMITS);
            view.printMessageWithLimits(View.INPUT_INT_DATA, model.getLeftLimit(), model.getRightLimit());
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
        while (!sc.hasNextInt()) {
            view.printNewLineMessage(View.WRONG_INPUT_INT_REQUIRED);
            sc.next();
        }
        return sc.nextInt();
    }
}
