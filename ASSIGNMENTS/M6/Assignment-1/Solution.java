import java.util.Scanner;
class LinkedList {
    private Node head;
    private int size;
    private class Node {
        private String item;
        private Node next;
    }
    LinkedList() {
        this.head = null;
        this.size = 0;
    }
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public String pop() {
        if (head != null) {
            String value = head.item;
            head = head.next;
            size--;
            return value;
        }
        return null;
    }
    public void push(final String s1) {
        Node oldHead = head;
        head = new Node();
        head.item = s1;
        head.next = oldHead;
        size++;
    }
}
class AddLargeNumbers {

    public static LinkedList numberToDigits(final String number) {
        LinkedList ll = new LinkedList();
        ll.push(number);
        return ll;
    }

    public static String digitsToNumber(final LinkedList list) {
        return list.pop();
    }

    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
        LinkedList ll1 = new LinkedList();
        // for (int i = 0; i < ll1.getSize(); i++) {

        // }
        return ll1;
    }
}
public final class Solution {
    private Solution() {
        //Empty.
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }

}
