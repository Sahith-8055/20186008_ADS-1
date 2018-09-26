import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted array.
 * @author Sahith.
 */
class SortedArray {
    /**
     * {Initializing an integer array1}.
     */
    private int[] array1;
    /**
     * {Size of 1st array}.
     */
    private int m1;
    /**
     * {Initializing an integer array2}.
     */
    private int[] array2;
    /**
     * {Size of 2nd array}.
     */
    private int m2;
    /**
     * {Initializing an integer array3}.
     */
    private int[] array3;
    /**
     * Constructs the object.
     *
     * @param      ar1   The archive 1
     * @param      ar2   The archive 2
     */
    SortedArray(final int[] ar1, final int[] ar2) {
        this.array1 = ar1;
        this.m1 = array1.length;
        this.array2 = ar2;
        this.m2 = array2.length;
        this.array3 = new int[m1 + m2];
    }
    /**
     * {Method to sort the array}
     *
     * @param      a1    Array 1
     * @param      a2    Array 2
     *
     * @return     {Array}
     */
    public int[] sort(final int[] a1, final int[] a2) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m1 && j < m2) {
            if (a1[i] < a2[j]) {
                this.array3[k++] = a1[i++];
            } else {
                this.array3[k++] = a2[j++];
            }
        }
        while (i < m1) {
            this.array3[k++] = a1[i++];
        }
        while (j < m2) {
            this.array3[k++] = a2[j++];
        }
        return this.array3;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int s1 = Integer.parseInt(scan.nextLine());
        int s2 = Integer.parseInt(scan.nextLine());
        int[] ar1 = new int[s1];
        int[] ar2 = new int[s2];
        if (s1 > 0) {
            String[] tokens = scan.next().split(",");
            for (int i = 0; i < s1; i++) {
                ar1[i] = Integer.parseInt(tokens[i]);
            }
        }
        if (s2 > 0) {
            String[] tokens1 = scan.next().split(",");
            for (int i = 0; i < s2; i++) {
                ar2[i] = Integer.parseInt(tokens1[i]);
            }
        }
        SortedArray sa = new SortedArray(ar1, ar2);
        int[] a = sa.sort(ar1, ar2);
        System.out.println(Arrays.toString(a).substring(
            1, Arrays.toString(a).length() - 1).replace(" ", ""));
    }
}