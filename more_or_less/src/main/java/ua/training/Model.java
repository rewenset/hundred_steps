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

    private View view;

    private int correctNumber;  //the number user should to guess
    private int leftLimit;      //left limit
    private int rightLimit;     //right limit
    private ArrayList<Integer> enteredNumbers = new ArrayList<Integer>();   //contains numbers that user has entered.

    /**
     * Constructor which connects model with view.
     * @param view the view of the game-app
     */
    public Model(View view) {
        this.view = view;
    }

    /**
     * Sets new limits and new correct number.
     * @see #setLimits(int, int)
     * @see #generateNewRandNumber()
     * @param min left limit
     * @param max right limit
     */
    public void thinkOfNewNumber(int min, int max) {
        setLimits(min, max);
        correctNumber = generateNewRandNumber();
    }

    /**
     * Sets new limits.
     * @param min left limit
     * @param max right limit
     */
    private void setLimits(int min, int max) {
        leftLimit = min;
        rightLimit = max;
    }

    /**
     * Generates new random number.
     * @see Math
     * @return new random number
     */
    private int generateNewRandNumber() {
        return leftLimit + (int)(Math.random() * rightLimit);
    }

    /**
     * Checks if given number is correct. If it's correct then adds
     * it to enteredNumbers list.
     * @see #isInLimits(int)
     * @param number given number
     * @return true - if correct, else - false
     */
    public boolean isCorrect(int number) {
        if (isInLimits(number)) {
            enteredNumbers.add(number);
            return correctNumber == number;
        } else {
            view.printNewLineMessage(view.WRONG_INPUT_OUT_OF_LIMITS);
            return false;
        }
    }

    /**
     * Checks if given number inside of the range (- between left and right limits).
     * @param number given number
     * @return true - if inside, else - false
     */
    public boolean isInLimits(int number) {
        if ((leftLimit <= number) && (number <= rightLimit)) {
            changeLimit(number);
            return true;
        }
        return false;
    }

    /**
     * Sets new limit (right or left - depending on given number).
     * @param number given number
     */
    private void changeLimit(int number) {
        if (number < correctNumber) {
            leftLimit = number;
            view.printNewLineMessage(view.GREATER_THEN);
        } else if (number > correctNumber) {
            rightLimit = number;
            view.printNewLineMessage(view.LESS_THEN);
        }
    }

    /**
     * @return left limit of the current range.
     */
    public int getLeftLimit() {
        return leftLimit;
    }

    /**
     * @return right limit of the current range.
     */
    public int getRightLimit() {
        return rightLimit;
    }

    /**
     * @return list of numbers entered by user.
     */
    public ArrayList<Integer> getEnteredNumbers() {
        return enteredNumbers;
    }
}
