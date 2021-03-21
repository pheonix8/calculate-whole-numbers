/**
 * Project calculate-whole-numbers
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.03.2021
 */
public class Operations {
    public static WholeNumber compareNumberSize(WholeNumber number1, WholeNumber number2) {

        Node tmpTail1 = number1.getTail();
        Node tmpTail2 = number2.getTail();

        while (tmpTail1 != null && tmpTail2 != null) {
            tmpTail1 = tmpTail1.getPrev();
            tmpTail2 = tmpTail2.getPrev();
        }

        if(tmpTail1 == null && tmpTail2 == null) {
            return compareForward(number1, number2);
        }


        if(tmpTail1 == null) {
            return number2;
        } else {
            return number1;
        }
    }

    private static WholeNumber compareForward(WholeNumber number1, WholeNumber number2){
        Node tmpHead1 = number1.getHead();
        Node tmpHead2 = number2.getHead();

        while (tmpHead1 != null && tmpHead2 != null){

            if (tmpHead1.getElement() > tmpHead2.getElement()) return number1;
            if (tmpHead2.getElement() > tmpHead1.getElement()) return number2;

            tmpHead1 = tmpHead1.getNext();
            tmpHead2 = tmpHead2.getNext();
        }

        return null;
    }
}
