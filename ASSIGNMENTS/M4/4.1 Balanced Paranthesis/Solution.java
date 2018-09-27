import java.util.Scanner;
/**
 * Linked Lists.
 */
class LinkedList {
    /**
     * {Variable of type Node}.
     */
    private Node head;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable of type char}.
         */
        private char item;
        /**
         * {Variable of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }
    /**
     * {Method to get the latest element from stack}.
     *
     * @return     {Character}
     */
    public char pop() {
        if (head != null) {
            char value = head.item;
            head = head.next;
            return value;
        }
        return '\0';
    }
    /**
     * {Method to push a character from the stack}.
     *
     * @param      value  The value
     */
    public void push(final char value) {
        Node oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
    }
    /**
     * {Method to check whether the parenthesis are balanced}.
     *
     * @param      m     {Integer}
     * @param      scan  The scanner object
     *
     * @return     {Boolean}
     */
    public boolean checkBalancing(final int m, Scanner scan) {
        scan = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        boolean b = false;
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (chr == '(' || chr == '{' || chr == '[') {
                push(chr);
            } else if (isEmpty()) {
                b = false;
                return b;
            } else if (chr == ')') {
                if (ll == null || pop() != '(') {
                    b = false;
                    return b;
                }
            } else if (chr == ']') {
                if (ll == null || pop() != '[') {
                    b = false;
                    return b;
                }
            } else if (chr == '}') {
                if (ll == null || pop() != '{') {
                    b = false;
                    return b;
                }
            }
        }
        if (isEmpty()) {
            b = true;
            return b;
        } else {
            return b;
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
        LinkedList ll = new LinkedList();
        int n = Integer.parseInt(scan.nextLine());
        int j = 0;
        while (j < n) {
            boolean x = ll.checkBalancing(n, scan);
            if (x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            j++;
        }
    }
}
