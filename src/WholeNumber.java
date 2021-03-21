import java.io.IOException;

/**
 * Project calculate-whole-numbers
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.03.2021
 */
public class WholeNumber {

    private Node head;
    private Node tail;
    private boolean positive;

    public WholeNumber() {
        positive = true;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean sgn) {
        positive = sgn;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void addFirst(byte element) {
        Node tmp = new Node(element, head, null);


        if (head != null) {
            head.setPrev(tmp);
        }

        if (tail == null) {
            tail = tmp;
        }

        head = tmp;
    }

    public void addLast(byte element) {
        Node tmp = new Node(element, null, tail);


        if (tail != null) {
            tail.setNext(tmp);
        }

        if (head == null) {
            head = tmp;
        }

        tail = tmp;
    }

    public void iterateForward() {
        Node tmp = head;

        System.out.print(positive ? "+" : "-");

        while (tmp != null) {
            System.out.print(tmp.getElement());

            if (tmp.getNext() == null) {
                tmp = null;
            } else {
                tmp = tmp.getNext();
            }
        }

        System.out.println();
    }

    public void iterateBackward() {
        Node tmp = tail;

        while (tmp != null) {
            System.out.print(tmp.getElement());

            if (tmp.getPrev() == null) {
                tmp = null;
            } else {
                tmp = tmp.getPrev();
            }
        }

        System.out.println();
    }

    public void removeFirst() {
        Node oldHead = head;
        Node newHead;

        if (head != null) {
            newHead = head.getNext();

            if (newHead != null) {
                head = newHead;
                newHead.setPrev(null);
            }
            System.out.println("gelöscht: " + oldHead.getElement());

        } else {
            System.out.println("Kein Element vorhanden");
        }
    }

    public void removeLast() {
        Node oldTail = tail;
        Node newTail;

        if (tail != null) {
            newTail = tail.getPrev();

            if (newTail != null) {
                tail = newTail;
                newTail.setNext(null);
            }
            System.out.println("gelöscht: " + oldTail.getElement());

        } else {
            System.out.println("Kein Element vorhanden");
        }
    }

    public static void main(String a[]) throws IOException {


        WholeNumber number1 = new WholeNumber();
        number1.addLast((byte) 5);
        number1.addLast((byte) 5);
        number1.iterateForward();

        WholeNumber number2 = new WholeNumber();
        number2.addLast((byte) 5);
        number2.addLast((byte) 0);
        number2.iterateForward();

    /*
        WholeNumber number1 = new WholeNumber();
        number1.addLast((byte) 1);
        number1.addLast((byte) 2);
        number1.iterateForward();

        WholeNumber number2 = new WholeNumber();
        number2.addLast((byte) 4§);
        number2.addLast((byte) 0);
        number2.addLast((byte) 0);
        number2.iterateForward();
    */
        WholeNumber number3;


        number3 = Addition.additionHandler(number1, number2);
        System.out.println("***********************");
        System.out.println("*        Sum        *");
        System.out.println("***********************");
        number3.iterateForward();

    /*
        number3 = Subtraction.subtractionHandler(number1, number2);
        System.out.println("***********************");
        System.out.println("*      Difference      *");
        System.out.println("***********************");
        number3.iterateForward();
    */

    }
}
