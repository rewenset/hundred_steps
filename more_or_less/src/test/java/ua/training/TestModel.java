package ua.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class contains methods for testing Model class of game-app.
 * @author Andriy Zakurenyi
 */
public class TestModel {
    private static Model model;
    private static final int RAND_MIN = 0;
    private static final int RAND_MAX = 100;

    @BeforeClass
    public static void init() {
        model = new Model(new View());
        model.thinkOfNewNumber(RAND_MIN, RAND_MAX);
    }

    @Test
    public void testIsCorrect() {
        Assert.assertFalse(model.isCorrect(RAND_MAX + 1));
    }

    @Test
    public void testIsInLimits() {
        Assert.assertTrue(model.isInLimits(RAND_MAX - 1));
    }

    @Test
    public void testGetLeftLimit() {
        Assert.assertEquals(model.getLeftLimit(), 0);
    }

}
