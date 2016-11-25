package ua.training;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

import ua.training.model.Necklace;
import ua.training.model.entity.Gemstone;
import ua.training.model.entity.PreciousStone;
import ua.training.model.entity.SemiPreciousStone;

import java.util.ArrayList;

/**
 * Unit test for simple Main.
 */
public class MainTest {
    private static Necklace necklace = new Necklace();
    private static ArrayList<Gemstone> gemstones = new ArrayList<>();

    @BeforeClass
    public static void init() {
        gemstones.add(new PreciousStone("diamond", 5, 1.3, 1));
        gemstones.add(new SemiPreciousStone("topaz", 2, 1.6, 1));
        gemstones.add(new SemiPreciousStone("pearl", 4, 1.2, 1));
        gemstones.add(new PreciousStone("ruby", 3, 1.0, 1));

        necklace.addStone("diamond", 5, 1.3, 1);
        necklace.addStone("topaz", 2, 1.6, 1);
        necklace.addStone("pearl", 4, 1.2, 1);
        necklace.addStone("ruby", 3, 1.0, 1);
    }

    @Test
    public void equalsTest() {
        Gemstone gemstone1 = new PreciousStone("diamond", 5, 1.3, 1);
        Gemstone gemstone2 = new PreciousStone("diamond", 5, 1.3, 1);
        Gemstone gemstone3 = new PreciousStone("diamond", 3, 1.0, 1);

        Assert.assertTrue(gemstone1.equals(gemstone2));
        Assert.assertFalse(gemstone1.equals(gemstone3));
    }

    @Test
    public void sortTest() {
        ArrayList<Gemstone> sortedGemstones = necklace.getSortedByWorthStones();
        double prevWorth = 0;
        for (Gemstone s : sortedGemstones) {
            if (s.getWorth() < prevWorth) {
                Assert.fail();
            }
            prevWorth = s.getWorth();
        }
    }

    @Test
    public void sumWeightTest() {
        double weight = necklace.getNecklaceWeight();
        double sumWeight = 0;
        for (Gemstone s : gemstones) {
            sumWeight += s.getWeight();
        }

        Assert.assertEquals(sumWeight, weight, 0);
    }

    @Test
    public void rangeTest() {
        double from = 1.1;
        double to = 1.4;
        for (Gemstone s : necklace.getStonesInRangeOfClarity(from, to)) {
            if (s.getClarity() < from && s.getClarity() > to) {
                Assert.fail();
            }
        }
    }

    @Test
    public void onlyPreciousTest() {
        for (Gemstone s : necklace.getPreciousStones()) {
            if (!s.isPrecious()) {
                Assert.fail();
            }
        }
    }
}
