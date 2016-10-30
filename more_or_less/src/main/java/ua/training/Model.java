package ua.training;

import java.util.ArrayList;

/**
 * Created by Andriy on 30.10.2016.
 */
public class Model {

    public View view;

    private int correctNumber;
    private int leftLimit;
    private int rightLimit;
    private ArrayList<Integer> enteredNumbers = new ArrayList<Integer>();

    public Model(View view) {
        this.view = view;
    }

    public void thinkOfNewNumber(int min, int max) {
        setLimits(min, max);
        correctNumber = generateNewRandNumber();
    }

    private void setLimits(int min, int max) {
        leftLimit = min;
        rightLimit = max;
    }

    private int generateNewRandNumber() {
        return leftLimit + (int)(Math.random() * rightLimit);
    }

    public boolean isCorrect(int number) {
        if (isInLimits(number)) {
            enteredNumbers.add(number);
            return correctNumber == number;
        } else {
            view.printNewLineMessage(view.WRONG_INPUT_OUT_OF_LIMITS);
            return false;
        }
    }

    private boolean isInLimits(int number) {
        if ((leftLimit <= number) && (number <= rightLimit)) {
            changeLimit(number);
            return true;
        }
        return false;
    }

    private void changeLimit(int number) {
        if (number < correctNumber) {
            leftLimit = number;
        } else if (number > correctNumber) {
            rightLimit = number;
        }
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
