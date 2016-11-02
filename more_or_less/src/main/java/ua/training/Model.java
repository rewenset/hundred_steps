package ua.training;

import java.util.ArrayList;

/**
 * Implements game logic.
 * Dedicated for generating new random number in given range,
 * check if given number is correct and keep some statistics.
 *
 * @author Andriy Zakurenyi
 */
public class Model {
    /**
     * connects model with view for inform user, in case when
     * input is not equal to correct number, if correct number
     * is greater or less.
     */
    private View view;

    /**
     * the number user should to guess
     */
    private int correctNumber;
    /**
     * left limit of range in which user should guess the correct number
     * correct number > left limit
     */
    private int leftLimit;
    /**
     * left limit of range in which user should guess the correct number
     * correct number < right limit
     */
    private int rightLimit;
    /**
     * Contains numbers that user has entered.
     * Used for some statistics.
     */
    private ArrayList<Integer> enteredNumbers = new ArrayList<>();

    /**
     * Constructor which connects model with view.
     *
     * @param view the view of the game-app
     */
    public Model(View view) {
        this.view = view;
    }

    /**
     * Checks if given number is correct. If it's correct then return true.
     * Otherwise method sets new limit (right or left - depending on
     * given number) and return false.
     *
     * @param number given number
     * @return true - if correct, else - false
     */
    public boolean isCorrect(int number) {
        enteredNumbers.add(number);
        if (number == correctNumber) {
            return true;
        } else if (number < correctNumber) {
            leftLimit = number;
            view.printNewLineMessage(View.GREATER_THEN);
        } else if (number > correctNumber) {
            rightLimit = number;
            view.printNewLineMessage(View.LESS_THEN);
        }
        return false;
    }

    /**
     * Sets new correct number.
     */
    public void thinkOfNewNumber() {
        correctNumber = generateNewNumber();
    }

    /**
     * Generates new number between left and right limits.
     *
     * @return new number between left and right limits.
     */
    public int generateNewNumber() {
        return (int) Math.ceil(Math.random() *
                (rightLimit - leftLimit - 1) + leftLimit);
    }

    /**
     * Sets new limits.
     *
     * @param min left limit of range in which will be correct number.
     * @param max right limit of range in which will be correct number.
     */
    public void setLimits(int min, int max) {
        leftLimit = min;
        rightLimit = max;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public ArrayList<Integer> getEnteredNumbers() {
        return enteredNumbers;
    }
}
