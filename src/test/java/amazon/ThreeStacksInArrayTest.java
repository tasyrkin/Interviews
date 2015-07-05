package amazon;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ThreeStacksInArrayTest {

    @Test
    public void testAddElsToLeftStack() {

        ThreeStacksInArray stacksInArray = new ThreeStacksInArray();

        for (int i = 0; i < 90; i++) {
            stacksInArray.push(0, i);
        }

        for (int i = 89; i >= 0; i--) {
            int val = stacksInArray.pop(0);
            assertThat("", val, is(i));
        }

    }

    @Test
    public void testAddElsToMiddleStack() {

        ThreeStacksInArray stacksInArray = new ThreeStacksInArray();

        for (int i = 0; i < 90; i++) {
            stacksInArray.push(1, i);
        }

        for (int i = 89; i >= 0; i--) {
            int val = stacksInArray.pop(1);
            assertThat("", val, is(i));
        }

    }

    @Test
    public void testAddElsToRightStack() {

        ThreeStacksInArray stacksInArray = new ThreeStacksInArray();

        for (int i = 0; i < 90; i++) {
            stacksInArray.push(2, i);
        }

        for (int i = 89; i >= 0; i--) {
            int val = stacksInArray.pop(2);
            assertThat("", val, is(i));
        }

    }

}
