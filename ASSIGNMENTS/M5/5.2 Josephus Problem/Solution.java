import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * {Variable first of type node}.
     */
    private Node first;
    /**
     * {Variable last of type node}.
     */
    private Node last;
    /**
     * {Variable size of type integer}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable name of type int}.
         */
        private int name;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (first == null);
    }
    /**
     * {Method to pop an element from the front}.
     *
     * @return     {Integer}
     */
    public int popFront() {
        if (first != null) {
            int item = first.name;
            first = first.next;
            return item;
        }
        return last.name;
    }
    /**
     * Method to push back an element.
     *
     * @param      name  The name
     */
    public void pushBack(final int name) {
        if (last == null) {
            last = new Node();
            last.name = name;
            last.next = null;
            first = last;
        } else {
            Node temp = last;
            last = new Node();
            last.name = name;
            last.next = null;
            temp.next = last;
        }
    }
    /**
     * {Method to get size}.
     *
     * @return     {Integer}
     */
    public int getsize() {
        return size;
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
        int num = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            int men = Integer.parseInt(tokens[0]);
            int rounds = Integer.parseInt(tokens[1]);
            String str = "";
            Deque q = new Deque();
            for (int i = 0; i < men; i++) {
                q.pushBack(i);
            }
            while (!q.isEmpty()) {
                for (int i = 0; i < rounds - 1; i++) {
                    q.pushBack(q.popFront());
                }
                str += q.popFront() + " ";
            }
            System.out.print(str.substring(0, str.length() - 1));
            System.out.println();
        }
    }
}
