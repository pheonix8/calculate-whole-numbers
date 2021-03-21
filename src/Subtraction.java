/**
 * Project calculate-whole-numbers
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.03.2021
 */
public class Subtraction {

    public static WholeNumber subtractionHandler(WholeNumber number1, WholeNumber number2) {
        if (number1.isPositive() && number2.isPositive()) {
            return Subtraction.subtract(number1, number2);
        } else if (number1.isPositive() || number2.isPositive()) {
            if (number1.isPositive()) {
                number2.setPositive(true);
                WholeNumber wholeNumber = Addition.additionHandler(number1, number2);
                wholeNumber.setPositive(true);
                return wholeNumber;
            } else {
                number1.setPositive(true);
                WholeNumber wholeNumber = Addition.additionHandler(number1, number2);
                wholeNumber.setPositive(false);
                return wholeNumber;
            }
        } else {
            number2.setPositive(true);
            return Subtraction.subtract(number2, number1);
        }
    }

    private static WholeNumber subtract(WholeNumber number1, WholeNumber number2) {
        WholeNumber difference = new WholeNumber();

        System.out.println("***********************");
        System.out.println("*     Subtract    *");
        System.out.println("***********************");
        System.out.print("Number 1: ");
        number1.iterateForward();
        System.out.print("Number 2: ");
        number2.iterateForward();


        WholeNumber biggerNumber = Operations.compareNumberSize(number1, number2);


        if (biggerNumber == null) {
            difference.addFirst((byte) 0);
            return difference;
        } else if (number1 == biggerNumber) {
            return calculate(number1, number2);
        } else {
            WholeNumber wholeNumber = calculate(number2, number1);
            wholeNumber.setPositive(false);
            return wholeNumber;
        }
    }

    private static WholeNumber calculate(WholeNumber number1, WholeNumber number2) {
        WholeNumber difference = new WholeNumber();

        Node tmpNum1 = number1.getTail();
        Node tmpNum2 = number2.getTail();
        byte tmpDifference;
        byte keep = 0;

        while (tmpNum1 != null || tmpNum2 != null) {


            if (tmpNum1 != null && tmpNum2 != null) {
                if (keep == 1) {
                    tmpNum2.setElement((byte) (tmpNum2.getElement() + 1));
                    keep = 0;
                }

                if (tmpNum1.getElement() > tmpNum2.getElement()) {
                    tmpDifference = (byte) (tmpNum1.getElement() - tmpNum2.getElement());
                } else if (tmpNum1.getElement() < tmpNum2.getElement()) {
                    tmpDifference = (byte) ((10 + tmpNum1.getElement()) - tmpNum2.getElement());
                    keep = 1;
                } else {
                    tmpDifference = 0;
                }

                difference.addFirst(tmpDifference);
            } else {
                if (keep == 1) {
                    tmpDifference = (byte) (tmpNum1.getElement() - 1);
                    if (tmpDifference != 0) {
                        difference.addFirst(tmpDifference);
                    }

                    keep = 0;
                } else {
                    difference.addFirst(tmpNum1.getElement());
                }
            }

            tmpNum1 = tmpNum1.getPrev();
            tmpNum2 = tmpNum2 != null ? tmpNum2.getPrev() : null;
        }

        while (difference.getHead().getElement() == 0) {
            difference.removeFirst();
        }

        return difference;
    }
}
