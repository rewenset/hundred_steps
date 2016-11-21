package ua.training.model.entity;

import java.util.Objects;

/**
 * Represents stone object with part of physical stone properties.
 * @author Andriy Zakurenyi
 */
public class Stone implements Comparable<Stone> {
    /** name of the stone */
    private String name;

    /** weight of the stone*/
    private double weight;

    /** clarity of the stone*/
    private double clarity;

    /** price of the stone*/
    private double price;

    /**
     * Constructor initialize all fields of new stone
     *
     * @param name      name
     * @param weight    weight in carat
     * @param clarity   clarity
     * @param price     price
     */
    public Stone(String name, double weight, double clarity, double price) {
        this.name = name;
        this.weight = weight;
        this.clarity = clarity;
        this.price = price;
    }

    /**
     * calculate worth of the stone
     * @return worth
     */
    public double getWorth() {
        return (price / weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, clarity, price);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Stone)) {
            return false;
        }
        Stone stone = (Stone) o;
        return Objects.equals(name, stone.getName())
                && weight == stone.getWeight()
                && clarity == stone.getClarity()
                && price == stone.getPrice();
    }

    @Override
    public String toString() {
        return getName() + "(weight=" + getWeight() + ";"
                + " clarity=" + getClarity() + ";"
                + " price=" + getPrice() + ").";
    }

    @Override
    public int compareTo(Stone o) {
        return Double.compare(getWorth(), o.getWorth());
    }

    // Default Getters and Setters
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getClarity() {
        return clarity;
    }

    public void setClarity(double clarity) {
        this.clarity = clarity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
