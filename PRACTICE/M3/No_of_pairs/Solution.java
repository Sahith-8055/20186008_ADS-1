import java.util.Arrays;
import java.util.Scanner;
class NoOfPairs {
    private int[] array;
    private int n;
    NoOfPairs(final int n1) {
        this.n = n1;
        this.array = new int[n1];
    }
    public int getPairs(final int[] a) {
        Arrays.sort(a);
        int count = 1;
        int sum = 0;
        int initial = a[0];
        for (int i = 1; i <= a.length - 1; i++) {
            if (a[i] == initial) {
                count++;
            } else {
                sum += count * (count - 1) / 2;
                initial = a[i];
                count = 1;
            }
        }
        sum += count * (count - 1) / 2;
        return sum;
    }
}
public class Solution {
    private Solution() {
        //Empty.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        NoOfPairs np = new NoOfPairs(number);
        int[] numbers = new int[number];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scan.nextLine());
        }
        int x = np.getPairs(numbers);
        System.out.println(x);
    }
}