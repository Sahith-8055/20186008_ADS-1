import java.util.Scanner;
import java.util.Iterator;
class Deque {
    private Node first;
    private Node last;
    private int size;
    private class Node {
        int item;
        Node next;
        // Node<Item> previous;
    }
    Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int getSize() {
        return size;
    }
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
    public void popFront() {
            if (first != null) {
                first = first.next;
                size--;
            }
    }
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
public class Solution {
    private Solution() {
        //Empty.
    }
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