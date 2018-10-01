import java.util.Scanner;
class Steque {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        int item;
        Node next;
    }
    Steque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return (head == null || tail == null);
    }
    public int getSize() {
        return this.size;
    }
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
    public int pop() {
        if (head != null) {
            int value = head.item;
            head = head.next;
            size--;
            return value;
        }
        return 0;
    }
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
public class Solution {
    private Solution() {
        //Empty.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        if (n >= 1 && n <= 5) {
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