import java.util.Scanner;
class Deque {
    private Node first;
    private Node last;
    private int size;
    class Node {
        private int name;
        private Node next;
    }
    Deque() {
        first = null;
        last = null;
        size = 0;
    }
    public boolean isEmpty() {
        return (first == null);
    }
    public int popFront() {
        if (first != null) {
            int item = first.name;
            first = first.next;
            return item;
        }
        return last.name;
    }
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
    public int getsize() {
        return size;
    }
    public String displayAll() {
        if (size != 0) {
            String s = "[";
            Node temp = first;
            while (temp != null) {
                s += temp.name + ", ";
                temp = temp.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
        return "[]";
    }
}
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
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