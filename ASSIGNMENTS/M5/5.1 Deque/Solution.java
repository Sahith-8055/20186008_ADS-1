import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * {Variable first of node type}.
     */
    private Node first;
    /**
     * {Variable last of node type}.
     */
    private Node last;
    /**
     * {Variable size of int type}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable item of type integer}.
         */
        private int item;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Method to push from front.
     *
     * @param      int1  The int1
     */
    public void pushFront(final int int1) {
        if (first == null) {
            first = new Node();
            first.item = int1;
            first.next = null;
            last = first;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = int1;
            first.next = oldfirst;
        }
        size++;
    }
    /**
     * Method to push from back.
     *
     * @param      item1  The item 1
     */
    public void pushBack(final int item1) {
        if (last == null) {
            last = new Node();
            last.item = item1;
            last.next = null;
        } else {
            Node oldlast = last;
            last = new Node();
            last.item = item1;
            last.next = null;
            oldlast.next = last;
        }
        size++;
    }
    /**
     * {Method to pop from front}.
     */
    public void popFront() {
        if (first != null) {
            first = first.next;
            size--;
        }
    }
    /**
     * {Method to pop from back}.
     */
    public void popBack() {
        if (last != null) {
            Node old = first;
            while (old.next.next != null) {
                old = old.next;
            }
            old.next = null;
            last = old;
            size--;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String str = "[";
            Node old1 = first;
            while (old1 != null) {
                str += old1.item + ", ";
                old1 = old1.next;
            }
            return str.substring(0, str.length() - 2) + "]";
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque d = new Deque();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "size":
                int a = d.getSize();
                System.out.println(a);
                break;
            case "pushLeft":
                d.pushFront(Integer.parseInt(tokens[1]));
                System.out.println(d);
                break;
            case "pushRight":
                d.pushBack(Integer.parseInt(tokens[1]));
                System.out.println(d);
                break;
            case "popLeft":
                if (!(d.isEmpty())) {
                    d.popFront();
                    System.out.println(d);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!(d.isEmpty())) {
                    d.popBack();
                    System.out.println(d);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            default:
                break;
            }
        }
    }
}
