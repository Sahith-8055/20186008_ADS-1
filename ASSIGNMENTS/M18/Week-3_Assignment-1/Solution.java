import java.util.Scanner;
/**
 * Class for stock data.
 */
class StockData implements Comparable<StockData> {
    /**
     * {Name of the company}.
     */
    private String name;
    /**
     * {Change of stock percentage}.
     */
    private Double change;
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     * @param      company  The company
     * @param      percent  The percent
     */
    StockData(final String company, final Double percent) {
        this.name = company;
        this.change = percent;
    }
    /**
     * Gets the name.
     * Time complexity of this method is O(1).
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     * Time complexity of this method is O(1).
     * @param      n     {String}
     */
    public void setName(final String n) {
        this.name = n;
    }
    /**
     * Gets the change.
     * Time complexity of this method is O(1).
     * @return     The change.
     */
    public Double getChange() {
        return this.change;
    }

    /**
     * Sets the change.
     * Time complexity of this method is O(1).
     * @param      c     {Double}
     */
    public void setChange(final Double c) {
        this.change = c;
    }
    /**
     * {Method to compare two objects}.
     * Time complexity of this method is O(1).
     * @param      that  The that
     *
     * @return     {Integer}
     */
    public int compareTo(final StockData that) {
        if (this.getChange() > that.getChange()) {
            return 1;
        }
        if (this.getChange() < that.getChange()) {
            return -1;
        }
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        }
        if (this.getName().compareTo(that.getName()) < 0) {
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
        String str = "";
        str += this.getName() + " " + this.getChange();
        return str;
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
        for (int i = 0; i < 2 + 2 + 2; i++) {
            int flag = 0;
            MinPQ<StockData> min = new MinPQ<StockData>();
            MaxPQ<StockData> max = new MaxPQ<StockData>();
            while (flag < n) {
                String[] tokens = scan.nextLine().split(",");
                StockData sd = new StockData(
                    tokens[0], Double.parseDouble(tokens[1]));
                min.insert(sd);
                max.insert(sd);
                flag++;
            }
            BinarySearch<String, Double> b = new BinarySearch<String, Double>();
            BinarySearch<String, Double> w = new BinarySearch<String, Double>();
            for (int k = 0; k < 2 + 2 + 1; k++) {
                StockData bm = max.delMax();
                System.out.println(bm);
                b.put(bm.getName(), bm.getChange());
            }
            System.out.println();
            for (int l = 0; l < 2 + 2 + 1; l++) {
                StockData wm = min.delMin();
                System.out.println(wm);
                w.put(wm.getName(), wm.getChange());
            }
            System.out.println();
        }
    }
}
