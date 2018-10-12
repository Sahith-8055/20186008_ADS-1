import java.util.Scanner;
import java.lang.Math;
class Taxicab implements Comparable<Taxicab> {
    private int sum;
    private int n1;
    private int n2;
    Taxicab(final int i, final int j) {
        this.n1 = i;
        this.n2 = j;
        this.sum = (n1 * n1 * n1) + (n2 * n2 * n2);
    }
    public int getNum1() {
        return this.n1;
    }
    public void setNum1(int a) {
        this.n1 = a;
    }
    public int getNum2() {
        return this.n2;
    }
    public void setNum2(int b) {
        this.n2 = b;
    }
    public int getSum() {
        return this.sum;
    }
    public void setSum(int s) {
        this.sum = s;
    }
    public int compareTo(final Taxicab that) {
        if (this.getSum() > that.getSum()) {
            return 1;
        }
        if (this.getSum() < that.getSum()) {
            return -1;
        }
        return 0;
    }
    public String toString() {
        return Integer.toString(sum);
    }
}
public class Solution {
    private Solution() {
        //Unused Constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int n = 600;
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
                min.insert(new Taxicab(current.getNum1(), current.getNum2() + 1));
            }
        }
    }
}