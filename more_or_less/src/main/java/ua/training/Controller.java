package ua.training;

import java.util.Scanner;

/**
 * Created by Andriy on 30.10.2016.
 */
public class Controller {
    private static final int RAND_MIN = 0;
    private static final int RAND_MAX = 100;

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.thinkOfNewNumber(RAND_MIN, RAND_MAX);

        int guessNumber;
        do {
            guessNumber = getIntValueWithScanner(sc);
        } while (!model.isCorrect(guessNumber));

        view.printMessage(View.YOU_WIN);
        view.printStatistic(model.getEnteredNumbers());
    }

    public int getIntValueWithScanner(Scanner sc) {
        view.printMessageWithLimits(view.INPUT_INT_DATA, model.getLeftLimit(), model.getRightLimit());
        while(!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_REQUIRED);
            sc.next();
        }
        return sc.nextInt();
    }
}
