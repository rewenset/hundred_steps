package ua.training.model;

import ua.training.model.entity.Gemstone;
import ua.training.model.entity.PreciousStone;
import ua.training.model.entity.SemiPreciousStone;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Dedicated for creating new necklace with gemstones, sorting it by worth,
 * calculating weight and filter by clarity or preciousness.
 *
 * @author Andriy Zakurenyi
 */
public class Necklace {
    /** all of the gemstones in necklace */
    private ArrayList<Gemstone> gemstones;

    public Necklace() {
        this.gemstones = new ArrayList<>();
    }

    /**
     * Add new stone to necklace
     * @param name      name
     * @param weight    weight in carat
     * @param clarity   clarity
     * @param price     price
     */
    public void addStone(String name, double weight, double clarity, double price) {
        for (PreciousStonesNames preciousName : PreciousStonesNames.values()) {
            if (name.equalsIgnoreCase(preciousName.getName())) {
                gemstones.add(new PreciousStone(name, weight, clarity, price));
                return;
            }
        }
        gemstones.add(new SemiPreciousStone(name, weight, clarity, price));
    }

    /**
     * Creates deep copy of gemstones list.
     * @return list of gemstones.
     */
    public ArrayList<Gemstone> getGemstones() {
        return new ArrayList<>(
                gemstones.stream().map(gemstone -> {
                    if (gemstone.isPrecious()) {
                        return new PreciousStone(gemstone.getName(),
                                                 gemstone.getWeight(),
                                                 gemstone.getClarity(),
                                                 gemstone.getPrice());
                    } else {
                        return new SemiPreciousStone(gemstone.getName(),
                                                     gemstone.getWeight(),
                                                     gemstone.getClarity(),
                                                     gemstone.getPrice());
                    }

                }).collect(Collectors.toList()));
    }

    /**
     * Sort all gemstones by worth on deep copy of gemstones list.
     * @return sorted copy of gemstones.
     */
    public ArrayList<Gemstone> getSortedByWorthStones() {
//        ArrayList<Gemstone> copyStones = getGemstones();
//        Collections.sort(copyStones, Gemstone::compareTo);
//        return copyStones;
        return (ArrayList<Gemstone>)(getGemstones().stream().sorted(Gemstone::compareTo).collect(Collectors.toList()));
    }

    /**
     * Calculate weight of all gemstones in necklace.
     * @return necklace weight
     */
    public double getNecklaceWeight() {
//        return gemstones.stream().map(Gemstone::getWeight).reduce((w1, w2) -> w1 + w2).get();
        return gemstones.stream().collect(Collectors.summarizingDouble(Gemstone::getWeight)).getSum();
    }

    /**
     * Creates new copy of gemstones having clarity in specific range.
     * @param from  beginning of clarity range
     * @param to    ending of clarity range
     * @return  list of gemstones
     */
    public ArrayList<Gemstone> getStonesInRangeOfClarity(double from, double to) {
        return (ArrayList<Gemstone>)(
                getGemstones().stream()
                .filter(s -> from <= s.getClarity() && s.getClarity() <= to)
                .collect(Collectors.toList()));
    }

    /**
     * Creates new copy of gemstones having only precious stones.
     * @return  list of precious stones in necklace
     */
    public ArrayList<Gemstone> getPreciousStones() {
        return (ArrayList<Gemstone>)(
                getGemstones().stream()
                .filter(Gemstone::isPrecious)
                .collect(Collectors.toList()));
    }

}
