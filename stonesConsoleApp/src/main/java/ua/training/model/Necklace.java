package ua.training.model;

import ua.training.model.entity.Stone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Dedicated for creating new necklace with stones, sorting it by worth,
 * calculating weight and filter by clarity.
 *
 * @author Andriy Zakurenyi
 */
public class Necklace {
    /** all of the stones in necklace */
    private ArrayList<Stone> stones;

    public Necklace() {
        this.stones = new ArrayList<>();
    }

    /**
     * Add new stone to necklace
     * @param name      name
     * @param weight    weight in carat
     * @param clarity   clarity
     * @param price     price
     */
    public void addStone(String name, double weight, double clarity, double price) {
        stones.add(new Stone(name, weight, clarity, price));
    }

    /**
     * Creates deep copy of stones list.
     * @return list of stones.
     */
    public ArrayList<Stone> getStones() {
        return new ArrayList<>(
                stones.stream().map(stone -> new Stone( stone.getName(),
                                                        stone.getWeight(),
                                                        stone.getClarity(),
                                                        stone.getPrice())    ).collect(Collectors.toList()));
    }

    /**
     * Sort all stones by worth on deep copy of stones list.
     * @return sorted copy of stones.
     */
    public ArrayList<Stone> getSortedByWorthStones() {
//        ArrayList<Stone> copyStones = getStones();
//        Collections.sort(copyStones, Stone::compareTo);
//        return copyStones;
        return (ArrayList<Stone>)(getStones().stream().sorted(Stone::compareTo).collect(Collectors.toList()));
    }

    /**
     * Calculate weight of all stones in necklace.
     * @return necklace weight
     */
    public double getNecklaceWeight() {
//        return stones.stream().map(Stone::getWeight).reduce((w1, w2) -> w1 + w2).get();
        return stones.stream().collect(Collectors.summarizingDouble(Stone::getWeight)).getSum();
    }

    /**
     * Creates new copy of stones having clarity in specific range.
     * @param from  beginning of clarity range
     * @param to    ending of clarity range
     * @return  list of stones
     */
    public ArrayList<Stone> getStonesInRangeOfClarity(double from, double to) {
        return (ArrayList<Stone>)(getStones().stream()
                .filter(s -> from <= s.getClarity() && s.getClarity() <= to)
                .collect(Collectors.toList()));
    }
}
