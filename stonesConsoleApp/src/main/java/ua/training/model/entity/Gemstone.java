package ua.training.model.entity;

import java.util.Objects;

/**
 * Represents stone object with part of physical stone properties.
 * @author Andriy Zakurenyi
 */
public abstract class Gemstone implements Comparable<Gemstone> {
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
    public Gemstone(String name, double weight, double clarity, double price) {
        this.name = name;
        this.weight = weight;
        this.clarity = clarity;
        this.price = price;
    }

    /**
     * checks if stone is precious
     * @return true if precious and false otherwise
     */
    public abstract boolean isPrecious();

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
        if (!(o instanceof Gemstone)) {
            return false;
        }
        Gemstone gemstone = (Gemstone) o;
        return Objects.equals(name, gemstone.getName())
                && weight == gemstone.getWeight()
                && clarity == gemstone.getClarity()
                && price == gemstone.getPrice();
    }

    @Override
    public String toString() {
        return getName() + "(weight=" + getWeight() + ";"
                + " clarity=" + getClarity() + ";"
                + " price=" + getPrice() + ").";
    }

    @Override
    public int compareTo(Gemstone o) {
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
