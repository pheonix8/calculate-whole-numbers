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
        }
        return null;
    }

    private static WholeNumber multiply(WholeNumber number1, WholeNumber number2) {
        WholeNumber product = new WholeNumber();

        WholeNumber smallerNumber =getSmallerNumber(number1, number2);
        WholeNumber biggerNumber =getBiggerNumber(number1, number2);

        Node multiplicator = smallerNumber.getHead();

        while (multiplicator != null){

            multiplicator.getNext();
        }
        return null;
    }

    private static WholeNumber calculate(byte multiplicator, WholeNumber number) {
        return null;
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
