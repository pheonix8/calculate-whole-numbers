/**
 * Description of Multiplication
 *
 * @version 0.1
 * @autor leo Oetterli
 * @since 23.03.2021
 */
public class Multiplication {

    public static WholeNumber multiplicationHandler(WholeNumber number1, WholeNumber number2) {
        if (number1.isPositive() && number2.isPositive()) {
            return Multiplication.multiply(number1, number2);
        } else  if (number1.isPositive() || number2.isPositive()) {
                WholeNumber result = Multiplication.multiply(number1, number2);
                result.setPositive(false);
                return result;
        } else {
            return Multiplication.multiply(number1, number2);
        }

    }

    private static WholeNumber multiply(WholeNumber number1, WholeNumber number2) {
        WholeNumber product = new WholeNumber();
        WholeNumber tmpproduct = new WholeNumber();

        WholeNumber smallerNumber =getSmallerNumber(number1, number2);
        WholeNumber biggerNumber =getBiggerNumber(number1, number2);

        Node multiplicator = smallerNumber.getHead();

        product = calculate(multiplicator.getElement(), biggerNumber);
        multiplicator = multiplicator.getNext();

        while (multiplicator != null){
            product.addLast((byte) 0);
            tmpproduct = calculate(multiplicator.getElement(), biggerNumber);
            product = Addition.additionHandler(product, tmpproduct);

            multiplicator = multiplicator.getNext();
        }
        return product;
    }

    private static WholeNumber calculate(byte multiplicator, WholeNumber number) {
        WholeNumber tmpProduct = new WholeNumber();
        Node tmpNumber = number.getTail();

        byte tmpSolution;
        byte keep = 0;

        while (tmpNumber != null) {
            tmpSolution = (byte) ((multiplicator * tmpNumber.getElement()) + keep);

            tmpProduct.addFirst((byte) (tmpSolution % 10));

            keep = (byte) (tmpSolution / 10);

            tmpNumber = tmpNumber.getPrev();
        }

        if (keep != 0) {
            tmpProduct.addFirst(keep);
        }

        return  tmpProduct;
    }

    private static  WholeNumber getSmallerNumber(WholeNumber number1, WholeNumber number2){
        WholeNumber biggerNumber = Operations.compareNumberSize(number1,number2);

        if (number1.equals(biggerNumber)) return number2;
        return number1;
    }

    private static  WholeNumber getBiggerNumber(WholeNumber number1, WholeNumber number2){
        WholeNumber biggerNumber = Operations.compareNumberSize(number1,number2);


        if (number1.equals(biggerNumber)) return number1;
        return number2;
    }

}
