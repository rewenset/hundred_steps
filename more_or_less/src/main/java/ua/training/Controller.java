package ua.training;

import java.util.Scanner;

/**
 * Contains main game loop method and input checker method.
 * Sets range of random number for the game.
 *
 * @author Andriy Zakurenyi
 */
public class Controller {
    private static final int RAND_MIN = 0;      //sets left limit for number
    private static final int RAND_MAX = 100;    //sets right limit for number

    private Model model;
    private View view;

    /**
     * Constructor which connects controller with model and view
     * @param model the model of the game-app
     * @param view the view of the game-app
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

        model.thinkOfNewNumber(RAND_MIN, RAND_MAX);

        int guessNumber;
        do {
            guessNumber = getIntValueWithScanner(sc);
        } while (!model.isCorrect(guessNumber));

        view.printNewLineMessage(View.YOU_WIN);
        view.printStatistic(model.getEnteredNumbers());
    }

    /**
     * Input checker. Ask to input another value if current is not integer.
     * @param sc input stream
     * @return users input value
     */
    public int getIntValueWithScanner(Scanner sc) {
        view.printMessageWithLimits(view.INPUT_INT_DATA, model.getLeftLimit(), model.getRightLimit());
        while(!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_REQUIRED);
            sc.next();
        }
        return sc.nextInt();
    }
}
