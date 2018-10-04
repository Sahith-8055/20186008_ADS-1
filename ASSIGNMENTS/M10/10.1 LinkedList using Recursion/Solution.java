import java.util.Scanner;
/**
 * Class of linked list.
 */
class LinkedList {
    /**
     * {Variable head of node type}.
     */
    private Node head;
    /**
     * {Size of linked list}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Integer item}.
         */
        private int item;
        /**
         * {Variable next of node type}.
         */
        private Node next;
        /**
         * Constructs the object.
         * Time complexity of this method is O(1).
         * @param      i     {Integer}
         * @param      n     {Node}
         */
        Node(final int i, final Node n) {
            this.item = i;
            this.next = n;
        }
    }
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     */
    LinkedList() {
        this.size = 0;
    }
    /**
     * Method to get the size.
     * Time complexity of this method is O(1).
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * {Method to insert an element}.
     * Time complexity of this method is O(N).
     * @param      head     The head
     * @param      count    The count
     * @param      element  The element
     *
     * @return     {Node}
     */
    public Node insert(final Node head, final int count, final int element) {
        if (count == 0) {
            return new Node(element, head);
        }
        head.next = insert(head.next, count - 1, element);
        size++;
        return head;
    }
    /**
     * {Method to insert at a particular position}.
     * Time complexity of this method is O(1).
     * @param      pos    The position
     * @param      item1  The item 1
     */
    public void insertAt(final int pos, final int item1) {
        head = insert(head, pos, item1);
    }
    /**
     * {Method for reverse}.
     * Time complexity of this method is O(N).
     * @param      head  The head
     *
     * @return     {Node}
     */
    public Node Reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextHead = Reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }
    /**
     * {Method to reverse a given linked list}.
     * Time complexity of this method is O(1).
     */
    public void reverse() {
        head = Reverse(head);
    }
    /**
     * {Method to display the elements}.
     * Time complexity of this method is O(N).
     * @return     {String}
     */
    public String display() {
        Node old = head;
        String str = "";
        while (old != null) {
            str += old.item + ", ";
            old = old.next;
        }
        return str.substring(0, str.length() - 2);
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0) {
                    System.out.println("Can't insert at this position.");
                } else if (Integer.parseInt(tokens[1]) > ll.getSize() + 1) {
                    System.out.println("Can't insert at this position.");
                } else {
                    ll.insertAt(
                        Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    System.out.println(ll.display());
                }
                break;
            case "reverse":
                if (ll.getSize() == 0) {
                    System.out.println("No elements to reverse.");
                    return;
                }
                ll.reverse();
                System.out.println(ll.display());
                break;
            default:
                break;
            }
        }
    }
}
