package ua.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Class contains methods for testing Model class of game-app.
 *
 * @author Andriy Zakurenyi
 */
public class ModelTest {

    @Test
    public void testGenerateNewNumber() {
        Model model = new Model(new View());
        int leftLimitForTest = 5;
        int rightLimitForTest = 15;
        int numberOfIteration = 10000;
        model.setLimits(leftLimitForTest, rightLimitForTest);
        int newNumber;
        for (int i = 0; i < numberOfIteration; i++) {
            newNumber = model.generateNewNumber();
            if (newNumber <= model.getLeftLimit() || newNumber >= model.getRightLimit()) {
                Assert.fail();
            }
        }
    }

}
