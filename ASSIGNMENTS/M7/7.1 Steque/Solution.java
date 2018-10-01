import java.util.Scanner;
class Node {
    private int item;
    private Node link;
    Node() {
        this.item = 0;
        this.link = null;
    }
    Node(final int item1, final Node link1) {
        this.item = item1;
        this.link = link1;
    }
    public int getItem() {
        return this.item;
    }
    public Node getlink() {
        return this.link;
    }
    public void setItem(final int i1) {
        this.item = i1;
    }
    public void setlink(final Node n) {
        this.link = n;
    }
    public String toString() {
        return item + "";
    }
}
class Steque {
    private int size;
    private Node head;
    private Node tail;
    Steque() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty() {
        return (head == null || tail == null);
    }
    public int getSize() {
        return this.size;
    }
    public int pop() {
        if (head != null && tail != null) {
            int value = head.getItem();
            head.setlink(head);
            size--;
            return value;
        }
        return 0;
    }
    public void push(final int num) {
        if (head == null) {
            Node oldHead = head;
            head = new Node(num, null);
            tail = head;
        } else {
            Node oldhead = head;
            head = new Node(num, null);
            tail.setlink(head);
        }
        size++;
    }
    public void enqueue(final int num1) {
        if (tail == null) {
            tail = new Node();
            tail.setItem(num1);
            tail.setlink(null);
        } else {
            Node oldtail = tail;
            tail = new Node();
            tail.setItem(num1);
            tail.setlink(null);
            oldtail.setlink(tail);
        }
        size++;
    }
    public String toString() {
        if (isEmpty()) {
            System.out.println("Steque is empty");
        } else {
            String str = "";
            Node head1 = head;
            while (head1 != null) {
                str += head1.getItem() + ", ";
                head1 = head.getlink();
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}
public class Solution {
    private Solution() {
        //Empty.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i < n + 1; i++) {
            Steque sq = new Steque();
            while (scan.hasNext()) {
                String[] tokens = scan.nextLine().split(" ");
                switch (tokens[0]) {
                case "push":
                    sq.push(Integer.parseInt(tokens[1]));
                    System.out.println(sq);
                    break;
                case "pop":
                    sq.pop();
                    System.out.println(sq);
                    break;
                case "enqueue":
                    sq.enqueue(Integer.parseInt(tokens[1]));
                    System.out.println(sq);
                    break;
                default:
                    break;
                }
            }
        }
    }
}