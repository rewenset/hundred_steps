package ua.training;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

import ua.training.model.Necklace;
import ua.training.model.entity.Stone;

import java.util.ArrayList;

/**
 * Unit test for simple Main.
 */
public class MainTest {
    public static Necklace necklace = new Necklace();
    public static ArrayList<Stone> stones = new ArrayList<>();

    @BeforeClass
    public static void init() {
        stones.add(new Stone("diamond", 5, 1.3, 1));
        stones.add(new Stone("topaz", 2, 1.6, 1));
        stones.add(new Stone("pearl", 4, 1.2, 1));
        stones.add(new Stone("ruby", 3, 1.0, 1));

        necklace.addStone("diamond", 5, 1.3, 1);
        necklace.addStone("topaz", 2, 1.6, 1);
        necklace.addStone("pearl", 4, 1.2, 1);
        necklace.addStone("ruby", 3, 1.0, 1);
    }

    @Test
    public void equalsTest() {
        Stone stone1 = new Stone("diamond", 5, 1.3, 1);
        Stone stone2 = new Stone("diamond", 5, 1.3, 1);
        Stone stone3 = new Stone("diamond", 3, 1.0, 1);

        Assert.assertTrue(stone1.equals(stone2));
        Assert.assertFalse(stone1.equals(stone3));
    }

    @Test
    public void sortTest() {
        ArrayList<Stone> sortedStones = necklace.getSortedByWorthStones();
        double prevWorth = 0;
        for (Stone s : sortedStones) {
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
        for (Stone s : stones) {
            sumWeight += s.getWeight();
        }

        Assert.assertEquals(sumWeight, weight, 0);
    }

    @Test
    public void rangeTest() {
        double from = 1.1;
        double to = 1.4;
        for (Stone s : necklace.getStonesInRangeOfClarity(from, to)) {
            if (s.getClarity() < from && s.getClarity() > to) {
                Assert.fail();
            }
        }
    }
}
