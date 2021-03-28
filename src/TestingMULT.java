import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Description of TestingMULTDIV
 *
 * @version 0.1
 * @autor leo Oetterli
 * @since 23.03.2021
 */
public class TestingMULT {


    WholeNumber number1;
    WholeNumber number2;

    @Before
    public void createNumber() throws InterruptedException {
        Thread.sleep(300);
        number1 = new WholeNumber();
        number1.addLast((byte) 5);
        number1.addLast((byte) 8);
        number1.addLast((byte) 3);

        number2 = new WholeNumber();
        number2.addLast((byte) 7);
        number2.addLast((byte) 6);

        number1.setPositive(true);
        number2.setPositive(true);
    }

    /*
       Multiply two positive Numbers
     */

    @Test
    public void multiplicationPP() {
        WholeNumber result = Multiplication.multiplicationHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 4);
        expect.addLast((byte) 4);
        expect.addLast((byte) 3);
        expect.addLast((byte) 0);
        expect.addLast((byte) 8);

        Assert.assertNull(Operations.compareNumberSize(expect, result));
    }

    /*
       Add negative to a positive Number
     */

    @Test
    public void multiplicationPN() {
        number2.setPositive(false);
        WholeNumber result = Multiplication.multiplicationHandler(number1, number2);
        result.iterateForward();

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 4);
        expect.addLast((byte) 4);
        expect.addLast((byte) 3);
        expect.addLast((byte) 0);
        expect.addLast((byte) 8);
        expect.setPositive(false);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Add positive to a negative Number
     */

    @Test
    public void multiplicationNP() {
        number1.setPositive(false);
        WholeNumber result = Multiplication.multiplicationHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 4);
        expect.addLast((byte) 4);
        expect.addLast((byte) 3);
        expect.addLast((byte) 0);
        expect.addLast((byte) 8);
        expect.setPositive(false);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }

    /*
       Add two negative Numbers
     */

    @Test
    public void multiplicationNN() {
        number1.setPositive(false);
        number2.setPositive(false);
        WholeNumber result = Multiplication.multiplicationHandler(number1, number2);

        WholeNumber expect = new WholeNumber();
        expect.addLast((byte) 4);
        expect.addLast((byte) 4);
        expect.addLast((byte) 3);
        expect.addLast((byte) 0);
        expect.addLast((byte) 8);

        Assert.assertNull(Operations.compareNumberSize(expect, result));

    }
}
