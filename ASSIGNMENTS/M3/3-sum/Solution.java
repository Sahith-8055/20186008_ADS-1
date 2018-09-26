import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sum.
 * @author Sahith.
 */
class Sum {
    /**
     * {Initializing an integer array}.
     */
    private int[] array;
    /**
     * {Variable num}.
     */
    private int num;
    /**
     * {Variable count}.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      num1  The number 1
     */
    Sum(final int num1) {
        this.count = 0;
        this.num = num1;
        this.array = new int[num1];
    }
    /**
     * {Method for binary search}.
     *
     * @param      a     { Integer array }
     * @param      key   The key
     *
     * @return     {Index value}
     */
    public int binarySearch(final int[] a, final int key) {
        int first = 0;
        int last = a.length - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (key < a[mid]) {
                last = mid - 1;
            } else if (key > a[mid]) {
                first = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    /**
     * {Method to find the sum of array}.
     *
     * @param      array  The array
     *
     * @return     {Count}
     */
    public int sumOfArray(final int[] array) {
        Arrays.sort(array);
        // System.out.println("yo");
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                // System.out.println("hello");
                int k = binarySearch(array, -(array[i] + array[j]));
                // System.out.println("yo");
                if (k > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 * {Class Solution}.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] t = new int[n];
        Sum s = new Sum(n);
        for (int i = 0; i < n; i++) {
            t[i] = scan.nextInt();
        }
        int count1 = s.sumOfArray(t);
        System.out.println(count1);
    }
}