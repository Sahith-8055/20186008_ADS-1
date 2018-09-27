import java.util.Scanner;
class LinkedList {
    private Node head;
    private class Node {
        private char item;
        private Node next;
    }
    LinkedList() {
        this.head = null;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public char pop() {
        if (head != null) {
            char value = head.item;
            head = head.next;
            return value;
        }
        return '\0';
    }
    public void push(final char value) {
        Node oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
    }

}
public class Solution {
    private Solution() {
        //Empty.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int j = 0;
        while (j < n) {
            boolean x = checkBalancing(n, scan);
            if (x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            j++;
        }
    }
    public static boolean checkBalancing(final int m, final Scanner scan) {
        boolean b = false;
        LinkedList ll = new LinkedList();
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (chr == '(' || chr == '{' || chr == '[') {
                ll.push(chr);
            } else if (ll.isEmpty()) {
                b = false;
                return b;
            } else if (chr == ')') {
                if (ll == null || ll.pop() != '(') {
                    b = false;
                    return b;
                }
            } else if (chr == ']') {
                if (ll == null || ll.pop() != '[') {
                    b = false;
                    return b;
                }
            } else if (chr == '}') {
                if (ll == null || ll.pop() != '{') {
                    b = false;
                    return b;
                }
            }
        }
        if (ll.isEmpty()) {
            b = true;
            return b;
        } else {
            return b;
        }
    }
}