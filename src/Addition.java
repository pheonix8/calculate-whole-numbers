import java.util.Objects;
/**
 * Project calculate-whole-numbers
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.03.2021
 */
public class Addition {

    public static WholeNumber additionHandler(WholeNumber number1, WholeNumber number2) {
        if (number1.isPositive() && number2.isPositive()) {
            return Addition.add(number1, number2);
        } else if (number1.isPositive() || number2.isPositive()) {
            if (number1.isPositive()) {
                number2.setPositive(true);
                return Subtraction.subtractionHandler(number1, number2);
            } else {
                number1.setPositive(true);
                return Subtraction.subtractionHandler(number2, number1);
            }
        } else {
            WholeNumber sum = Addition.add(number1, number2);
            sum.setPositive(false);
            return sum;
        }
    }

    private static WholeNumber add(WholeNumber number1, WholeNumber number2) {
        WholeNumber sum = new WholeNumber();
        Node tmpNum1 = number1.getTail();
        Node tmpNum2 = number2.getTail();
        byte tmpSum;
        byte keep = 0;

        while (tmpNum1 != null || tmpNum2 != null) {

            if (tmpNum1 != null && tmpNum2 != null) {
                tmpSum = (byte) (tmpNum1.getElement() + tmpNum2.getElement());
            } else {
                tmpSum = (Objects.requireNonNullElse(tmpNum1, tmpNum2).getElement());
            }

            tmpSum = (byte) (tmpSum + keep);

            if (tmpSum > 9) {
                keep = (byte) (tmpSum / 10);
                tmpSum = (byte) (tmpSum % 10);
            } else {
                keep = 0;
            }

            sum.addFirst(tmpSum);

            tmpNum1 = tmpNum1 != null ? tmpNum1.getPrev() : null;
            tmpNum2 = tmpNum2 != null ? tmpNum2.getPrev() : null;
        }

        if (keep == 1) {
            sum.addFirst(keep);
        }

        return sum;
    }
}
