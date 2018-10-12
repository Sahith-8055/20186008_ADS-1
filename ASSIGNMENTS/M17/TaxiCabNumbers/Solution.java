import java.util.Scanner;
/**
 * Class for taxicab.
 */
class Taxicab implements Comparable<Taxicab> {
    /**
     * {Sum of cubes}.
     */
    private int sum;
    /**
     * {1st number}.
     */
    private int n1;
    /**
     * {2nd number}.
     */
    private int n2;
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     * @param      i     {Integer}
     * @param      j     {Integer}
     */
    Taxicab(final int i, final int j) {
        this.n1 = i;
        this.n2 = j;
        this.sum = (n1 * n1 * n1) + (n2 * n2 * n2);
    }
    /**
     * Gets the number1.
     * Time complexity of this method is O(1).
     * @return     The number1.
     */
    public int getNum1() {
        return this.n1;
    }
    /**
     * Sets the number1.
     * Time complexity of this method is O(1).
     * @param      a     {Integer}
     */
    public void setNum1(final int a) {
        this.n1 = a;
    }
    /**
     * Gets the number2.
     * Time complexity of this method is O(1).
     * @return     The number2.
     */
    public int getNum2() {
        return this.n2;
    }
    /**
     * Sets the number2.
     * Time complexity of this method is O(1).
     * @param      b     {Integer}
     */
    public void setNum2(final int b) {
        this.n2 = b;
    }
    /**
     * Gets the sum.
     * Time complexity of this method is O(1).
     * @return     The sum.
     */
    public int getSum() {
        return this.sum;
    }
    /**
     * Sets the sum.
     * Time complexity of this method is O(1).
     * @param      s     {Integer}
     */
    public void setSum(final int s) {
        this.sum = s;
    }
    /**
     * {Method to compare two objects}.
     * Time complexity of this method is O(1).
     * @param      that  The that
     *
     * @return     {Integer}
     */
    public int compareTo(final Taxicab that) {
        if (this.getSum() > that.getSum()) {
            return 1;
        }
        if (this.getSum() < that.getSum()) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity of this method is O(1).
     * @return     String representation of the object.
     */
    public String toString() {
        return Integer.toString(sum);
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
        int N = scan.nextInt();
        int M = scan.nextInt();
        final int n = 600;
        MinPQ<Taxicab> min = new MinPQ<Taxicab>();
        for (int i = 0; i <= n; i++) {
            min.insert(new Taxicab(i, i));
        }
        int count = 0;
        int temp = 1;
        while (!min.isEmpty()) {
            Taxicab current = min.delMin();
            if (temp == current.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == M - 1) {
                N--;
                if (N == 0) {
                    System.out.println(current.getSum());
                    break;
                }
            }
            temp = current.getSum();
            if (current.getNum2() < n) {
                min.insert(new Taxicab(
                               current.getNum1(), current.getNum2() + 1));
            }
        }
    }
}
