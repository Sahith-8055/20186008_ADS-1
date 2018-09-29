import java.util.Scanner;
class LinkedList {
    private Node head;
    private class Node {
        private String item;
        private Node next;
    }
    LinkedList() {
        this.head = null;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public String pop() {
        if (head != null) {
            String value = head.item;
            head = head.next;
            return value;
        }
        return null;
    }
    public void push(final String s1) {
        Node oldHead = head;
        head = new Node();
        head.item = s1;
        head.next = oldHead;
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
        return ll1;
    }
}

public class Solution {
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
