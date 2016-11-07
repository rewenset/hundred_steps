package ua.training.controllers;

import ua.training.models.Model;
import ua.training.views.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Andriy on 06.11.2016.
 */
public class Controller {

    private Model model;

    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Entry point.
     * Check if user wants to input new record. If yes then pass control to recordController,
     * Otherwise -- exits.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        view.printMessageWithNewLine(View.GREETING);
        view.printMessage(View.MAIN_QUESTION);

        Pattern yesOrNoPattern = Pattern.compile("[yn]");
        RecordController recordController = new RecordController(this);

        while (getMatchingValueWithScanner(sc, yesOrNoPattern, View.WRONG_INPUT_Y_OR_N_REQUIRED).equals("y")) {
            recordController.createNewRecord(sc);
            view.printMessage(View.MAIN_QUESTION);
        }

        view.printMessageWithNewLine(View.ADIEU);
    }

    /**
     * Check if input match the specified pattern. If it doesn't -- asks for new input.
     *
     * @param sc Input stream.
     * @param pt Pattern to match input.
     * @param errorMsg This message will be printed if input value doesn't match the specified pattern.
     * @return String witch mach the specified pattern.
     */
    public String getMatchingValueWithScanner(Scanner sc, Pattern pt, String errorMsg) {
        while (!sc.hasNext(pt)) {
            view.printMessageWithNewLine(errorMsg);
            sc.next();
        }
        return sc.next().trim();
    }

    /**
     * Get input from the user.
     *
     * @param sc Input stream.
     * @return Users input.
     */
    public String getValueWithScanner(Scanner sc) {
        return sc.next().trim();
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
