/**
 * Project calculate-whole-numbers
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.03.2021
 */
public class Node {
    byte element;
    Node next;
    Node prev;

    public Node(byte element, Node next, Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public byte getElement() {
        return element;
    }

    public void setElement(byte element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }
}
