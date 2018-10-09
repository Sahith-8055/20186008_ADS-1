import java.util.Scanner;
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
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        MinPQ<Float> minpq = new MinPQ<Float>(n);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(n);
        float median = 0.0f;
        for (int i = 0; i < n; i++) {
            float f = Float.parseFloat(scan.nextLine());
            if (f > median) {
                minpq.insert(f);
            } else {
                maxpq.insert(f);
            }
            if (maxpq.size() - minpq.size() > 1) {
                float f1 = maxpq.delMax();
                minpq.insert(f1);
            }
            if (minpq.size() - maxpq.size() > 1) {
                float f2 = minpq.delMin();
                maxpq.insert(f2);
            }
            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }
            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }
            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }
        }
    }
}
