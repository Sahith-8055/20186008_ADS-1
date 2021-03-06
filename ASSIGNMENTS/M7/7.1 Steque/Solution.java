import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
    /**
     * {Variable head of type node}.
     */
    private Node head;
    /**
     * {Variable tail of type node}.
     */
    private Node tail;
    /**
     * {Variable size of type integer}.
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
     * Time complexity of Steque() is 1.
     */
    Steque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Method to determine if the steque is empty.
     * Time complexity of isEmpty() is 1.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null || tail == null);
    }
    /**
     * {Method to push an element into the steque}.
     * Time complexity of push() is 1.
     * @param      num1  The number1
     */
    public void push(final int num1) {
        if (head == null) {
            head = new Node();
            head.item = num1;
            head.next = null;
            tail = head;
        } else {
            Node oldhead = head;
            head = new Node();
            head.item = num1;
            head.next = oldhead;
        }
        size++;
    }
    /**
     * {Method to pop an element into the steque}.
     * Time complexity of pop() is 1.
     * @return     {Integer value}
     */
    public int pop() {
        if (head != null) {
            int value = head.item;
            head = head.next;
            size--;
            return value;
        }
        return 0;
    }
    /**
     * {Method to enqueue a value into the steque}.
     * Time complexity of enqueue() is 1.
     * @param      num2  The number 2
     */
    public void enqueue(final int num2) {
        if (tail == null || head == null) {
            tail = new Node();
            tail.item = num2;
            tail.next = null;
            head = tail;
        } else {
            Node node = tail;
            tail = new Node();
            tail.item = num2;
            tail.next = null;
            node.next = tail;
        }
        size++;
    }
    /**
     * {Method to display the steque}.
     * Time Complexity of display() is n.
     * where n is size of steque.
     */
    public void display() {
        if (size != 0) {
            String str = "";
            Node node1 = head;
            while (node1 != null) {
                str += node1.item + ", ";
                node1 = node1.next;
            }
            System.out.println(str.substring(0, str.length() - 2));
        } else {
            System.out.println("Steque is empty.");
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
        //Unused Contructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        if (n >= 1 && n <= 2 + 2 + 1) {
            for (int i = 1; i < n + 1; i++) {
                Steque sq = new Steque();
                while (scan.hasNext()) {
                    String[] tokens = scan.nextLine().split(" ");
                    switch (tokens[0]) {
                    case "push":
                        sq.push(Integer.parseInt(tokens[1]));
                        sq.display();
                        break;
                    case "pop":
                        sq.pop();
                        sq.display();
                        break;
                    case "enqueue":
                        sq.enqueue(Integer.parseInt(tokens[1]));
                        sq.display();
                        break;
                    default:
                        sq = new Steque();
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
}
