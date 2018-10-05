import java.util.Scanner;
class QuickSort {
    private final int x = 10;
    QuickSort() {
        //Unused Constructor.
    }
    public int partition(final Comparable[] a, final int lo, final int hi) {
        int i = lo;
        int j = hi + 1;
        while (!false) {
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
    public void sort(final Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    public void sort(final Comparable[] a, final int lo, final int hi) {
        if (hi <= lo) {
            return;
        }
        int p = hi - lo + 1;
        if (p <= x) {
            insertionSort(a, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(a, lo, hi);
        sort(a, lo, k - 1);
        sort(a, k + 1, hi);
    }
    public void insertionSort(final Comparable[] a, final int lo, final int hi) {
        for (int i = 0; i <= hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    public void exch(final Comparable[] a, final int i, final int j) {
        Comparable temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }
    public String show(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
}
public class Solution {
    private Solution() {
        //Unused Constructor.
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n > 0) {
            QuickSort qs = new QuickSort();
            int m = Integer.parseInt(scan.nextLine());
            String[] tokens = scan.nextLine().split(" ");
            qs.sort(tokens);
            System.out.println(qs.show(tokens));
            System.out.println();
        }
        n--;
    }
}