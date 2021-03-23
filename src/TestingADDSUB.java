import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Description of Testing
 *
 * @version 0.1
 * @autor leo Oetterli
 * @since 23.03.2021
 */
public class TestingADDSUB {

    WholeNumber number1;
    WholeNumber number2;

    @Before
    public void createNumber() throws InterruptedException {
        Thread.sleep(300);
        number1 = new WholeNumber();
        number1.addLast((byte) 1);
        number1.addLast((byte) 0);
        number1.addLast((byte) 0);
        number1.iterateForward();

        number2 = new WholeNumber();
        number2.addLast((byte) 2);
        number2.addLast((byte) 5);
        number2.iterateForward();

        number1.setPositive(true);
        number2.setPositive(true);
    }

    /*
       Add two positive Numbers
     */

    @Test
    public void additionPP() {
        WholeNumber result = Addition.additionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 1);
        expect.addLast((byte) 2);
        expect.addLast((byte) 5);

        Assert.assertNull(Operations.compareNumberSize(expect, result));
    }

    /*
       Add negative to a positive Number
     */

    @Test
    public void additionPN() {
        number2.setPositive(false);
        WholeNumber result = Addition.additionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 7);
        expect.addLast((byte) 5);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Add positive to a negative Number
     */

    @Test
    public void additionNP() {
        number1.setPositive(false);
        WholeNumber result = Addition.additionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 7);
        expect.addLast((byte) 5);

        expect.setPositive(false);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Add two negative Numbers
     */

    @Test
    public void additionNN() {
        number1.setPositive(false);
        number2.setPositive(false);
        WholeNumber result = Addition.additionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 1);
        expect.addLast((byte) 2);
        expect.addLast((byte) 5);

        expect.setPositive(false);


        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Subtract positive from positive Numbers
     */

    @Test
    public void subtractionPP() {
        WholeNumber result = Subtraction.subtractionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 7);
        expect.addLast((byte) 5);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Subtract negative form positive Number
     */

    @Test
    public void subtractionPN() {
        number2.setPositive(false);
        WholeNumber result = Subtraction.subtractionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 1);
        expect.addLast((byte) 2);
        expect.addLast((byte) 5);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Subtract positive form negative Number
     */

    @Test
    public void subtractionNP() {
        number1.setPositive(false);
        WholeNumber result = Subtraction.subtractionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 1);
        expect.addLast((byte) 2);
        expect.addLast((byte) 5);

        expect.setPositive(false);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Subtract negative form negative Number
     */

    @Test
    public void subtractionNN() {
        number1.setPositive(false);
        number2.setPositive(false);
        WholeNumber result = Subtraction.subtractionHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 7);
        expect.addLast((byte) 5);

        expect.setPositive(false);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

}
