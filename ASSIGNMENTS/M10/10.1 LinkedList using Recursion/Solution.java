import java.util.Scanner;
class LinkedList {
    private Node head;
    private class Node {
        private int item;
        private Node next;
        Node(final int i, final Node n) {
            this.item = i;
            this.next = n;
        }
    }
    LinkedList() {
        //Empty.
    }
    public Node insert(final Node head, final int count, final int element) {
        if (count == 0) {
            return new Node(element, head);
        }
        head.next = insert(head.next, count - 1, element);
        return head;
    }
    public void insertAt(final int pos, final int item1) {
        head = insert(head, pos, item1);
    }
    public Node Reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextHead = Reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }
    public void reverse() {
        head = Reverse(head);
    }
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
public class Solution {
    private Solution() {
        //Unused Constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                ll.insertAt(
                    Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                System.out.println(ll.display());
                break;
            case "reverse":
                ll.reverse();
                System.out.println(ll.display());
                break;
            default:
                break;
            }
        }
    }
}