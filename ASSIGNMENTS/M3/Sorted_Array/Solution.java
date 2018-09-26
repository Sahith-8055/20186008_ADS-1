import java.util.Scanner;
import java.util.Arrays;
class SortedArray {
    private int[] array1;
    private int m1;
    private int[] array2;
    private int m2;
    private int[] array3;
    SortedArray(final int[] ar1, final int[] ar2) {
        this.array1 = ar1;
        this.m1 = array1.length;
        this.array2 = ar2;
        this.m2 = array2.length;
        this.array3 = new int[m1 + m2];
    }
    public int[] sort(final int[] a1, final int[] a2) {

        // System.out.println(Arrays.toString(a1));
        // System.out.println(Arrays.toString(a2));
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
public class Solution {
    private Solution() {
        //Empty.
    }
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
        int n = 0;
        for (n = 0; n < a.length - 1; n++) {
            System.out.println(a[n] + ",");
        }
        System.out.println(a[n]);
    }
}