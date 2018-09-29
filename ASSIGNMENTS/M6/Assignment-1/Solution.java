import java.util.Scanner;
/**
 * Class of Linked Lists.
 */
class LinkedList {
    /**
     * {Variable head of type node}.
     */
    private Node head;
    /**
     * {Variable size of type integer}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable item of type string}.
         */
        private String item;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * Method to get the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Method to determine if the linked list is empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }
    /**
     * {Method to pop an element from the linked list}.
     *
     * @return     {String}
     */
    public String pop() {
        if (head != null) {
            String value = head.item;
            head = head.next;
            size--;
            return value;
        }
        return null;
    }
    /**
     * {Method to push an element into the linked list}.
     *
     * @param      s1    The s1
     */
    public void push(final String s1) {
        Node oldHead = head;
        head = new Node();
        head.item = s1;
        head.next = oldHead;
        size++;
    }
}
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
        //Empty.
    }
    /**
     * {Method to convert the given string to integer}.
     *
     * @param      number  The number
     *
     * @return     {Linked List}
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList ll = new LinkedList();
        ll.push(number);
        return ll;
    }
    /**
     * {Method to convert the digits to number}.
     *
     * @param      list  The list
     *
     * @return     {String}
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.pop();
    }
    /**
     * Method to add two large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     {Linked List}
     */
    public static LinkedList addLargeNumbers(
        final LinkedList list1, final LinkedList list2) {
        LinkedList ll1 = new LinkedList();
        int carry = 0;
        String sum = "";
        return ll1;
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
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result =
            AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(
                AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }
}
