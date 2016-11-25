package ua.training.model.entity;

/**
 * Represents precious stone object.
 * Have bigger worth comparing to semiprecious stones.
 * @author Andriy Zakurenyi
 */
public class PreciousStone extends Gemstone{

    /**
     * Constructor initialize all fields of new stone
     *
     * @param name    name
     * @param weight  weight in carat
     * @param clarity clarity
     * @param price   price
     */
    public PreciousStone(String name, double weight, double clarity, double price) {
        super(name, weight, clarity, price);
    }

    /**
     * checks if stone is precious
     * @return true for precious stones
     */
    public boolean isPrecious() {
        return true;
    }

    @Override
    public double getWorth() {
        /* some random coefficient for making precious stones more worthwhile */
        int preciousness = 2;
        return super.getWorth() * preciousness;
    }
}
