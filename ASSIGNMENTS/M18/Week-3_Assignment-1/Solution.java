import java.util.Scanner;
class StockData implements Comparable<StockData> {
    private String name;
    private Double change;
    StockData(final String company, final Double percent) {
        this.name = company;
        this.change = percent;
    }
    public String getName() {
        return this.name;
    }

    public void setName(final String n) {
        this.name = n;
    }
    public Double getChange() {
        return this.change;
    }

    public void setChange(final Double c) {
        this.change = c;
    }
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
    public String toString() {
        String str = "";
        str += this.getName() + " " + this.getChange();
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