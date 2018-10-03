import java.util.Scanner;
import java.util.Arrays;
class MergeX {
    // cutoff to insertion sort
    private final int CUTOFF = 7;
    private int[] array1;
    private int size;
    MergeX() {
        this.array1 = new int[1];
        this.size = 0;
    }
    public int getSize() {
        return this.size;
    }
    private void resize() {
        array1 = Arrays.copyOf(array1, 2 * array1.length);
    }
    public void add(final int item) {
        if (size == array1.length) {
            resize();
        }
        array1[size++] = item;
    }
    public void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > hi) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    public void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, array, lo, mid);
        sort(aux, array, mid + 1, hi);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = array[i];
            }
            System.out.println("Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, lo, mid, hi);
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     */
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    // sort from a[lo] to a[hi] using insertion sort
    public void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    public void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    public boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    // print array to standard output
    public Object show(Object[] a) {
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
        MergeX mx = new MergeX();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            mx.sort(tokens);
            System.out.println(mx.show(tokens));
            System.out.println();
        }
    }
}