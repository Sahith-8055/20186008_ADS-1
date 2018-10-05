import java.util.Scanner;
/**
 * Class for quick sort.
 */
class QuickSort {
    /**
     * Constructs the object.
     * Time complexity of this contructor is O(1).
     */
    QuickSort() {
        //Un-used Constructor.
    }
    /**
     * {Method for insertion sort}.
     * Time complexity of this method is O(N^2).
     * @param      a     {Comparable array}
     * @param      lo    The lower
     * @param      hi    The higher
     */
    public void insertionSort(
        final Comparable[] a, final int lo, final int hi) {
        for (int i = 0; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * {Method to swap two elements}.
     * Time complexity of this method is O(N).
     * @param      a     {Comparable array}
     * @param      i     {Integer}
     * @param      j     {Integer}
     */
    public void exch(final Comparable[] a, final int i, final int j) {
        Comparable temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }
    /**
     * {Method to print all the elements in the array}.
     * Time complexity of this method is O(N).
     * @param      a     {Comparable array}
     *
     * @return     {String}
     */
    public String show(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
    /**
     * {Method to sort}.
     * Time complexity of this method is O(log(N)).
     * @param      a     {Comparable}
     * @param      lo    The lower
     * @param      hi    The higher
     * @param      cut   The cutoff
     */
    public void sort(final Comparable[] a, final int lo,
        final int hi, final int cut) {
        if (hi <= lo + cut - 1) {
            insertionSort(a, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(a, lo, hi);
        System.out.println(show(a));
        sort(a, lo, k - 1, cut);
        sort(a, k + 1, hi, cut);
    }
    /**
     * {Method for quick sort}.
     * Time complexity of this method is O(1).
     * @param      a     {Comparable array}
     * @param      c     {Cutoff}
     */
    public void sort(final Comparable[] a, final int c) {
        sort(a, 0, a.length - 1, c);
        System.out.println(show(a));
    }
    /**
     * {Method to partition an array}.
     * Time complexity of this method is O(N).
     * @param      a     {Comparable array}
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     {Index of the array}
     */
    public int partition(final Comparable[] a, final int lo, final int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    /**
     * {Method for finding the lesser of two values}.
     * Time complexity of this method is O(1).
     * @param      a     {Comaparable object}
     * @param      b     {Comaparable object}
     *
     * @return     {Boolean}
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
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
        //Unused Constructor.
    }
    /**
     * {Client program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        QuickSort qs = new QuickSort();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(scan.nextLine());
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                qs.sort(tokens, m);
            }
        }
    }
}
