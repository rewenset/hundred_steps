package ua.training.model.entity;

/**
 * Represents semiprecious stone object.
 * @author Andriy Zakurenyi
 */
public class SemiPreciousStone extends Gemstone{
    /**
     * Constructor initialize all fields of new stone
     *
     * @param name    name
     * @param weight  weight in carat
     * @param clarity clarity
     * @param price   price
     */
    public SemiPreciousStone(String name, double weight, double clarity, double price) {
        super(name, weight, clarity, price);
    }

    /**
     * checks if stone is precious
     * @return false for semiprecious stones
     */
    public boolean isPrecious() {
        return false;
    }

}
