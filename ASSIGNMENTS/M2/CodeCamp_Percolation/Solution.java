import java.util.Scanner;
/**
 * Class for percolation.
 * @author Sahith.
 */
class Percolation {
    /**
     * {Declaring an object of weighted quick union}.
     */
    private WeightedQuickUnionUF uf;
    /**
     * {variable n}.
     */
    private int n;
    /**
     * {Variables size, first, last, count}.
     */
    private int size, first, last, count;
    /**
     * {Declaring an integer array of type boolean}.
     */
    private boolean[] connected;

    // create n-by-n grid, with all sites blocked
    /**
     * Constructs the object.
     *
     * @param      n1    The n1
     */
    Percolation(final int n1) {
        this.n = n1;
        this.size = n1 * n1;
        this.first = size;
        this.last = size + 1;
        this.count = 0;
        connected = new boolean[size];
        uf = new WeightedQuickUnionUF(size + 2);
        for (int i = 0; i < n; i++) {
            uf.union(first, i);
            uf.union(last, size - i - 1);
        }
    }
    /**
     * Searches for the first match.
     *
     * @param      i     {row}
     * @param      j     {column}
     *
     * @return     {index value for 1-Dimensional Array}
     */
    private int indexOf(final int i, final int j) {
        return (n * (i - 1)) + (j - 1);
    }
    /**
     * Links open sites.
     *
     * @param      row   The row
     * @param      col   The col
     */
    private void linkOpenSites(final int row, final int col) {
        if (connected[col] && !uf.connected(row, col)) {
            uf.union(row, col);
        }
    }
    /**
     * {Method to open site (row, col) if it is not open already}.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        int index = indexOf(row, col);
        connected[index] = true;
        count++;
        int top = index - n;
        int bottom = index + n;
        if (n == 1) {
            uf.union(first, index);
            uf.union(first, index);
        }
        if (bottom < size) {
            linkOpenSites(index, bottom);
        }
        if (top >= 0) {
            linkOpenSites(index, top);
        }
        if (col == 1) {
            if (col != n) {
                linkOpenSites(index, index + 1);
            }
            return;
        }
        if (col == n) {
            linkOpenSites(index, index - 1);
            return;
        }
        linkOpenSites(index, index + 1);
        linkOpenSites(index, index - 1);
    }
    /**
     * Determines if the site is open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        return connected[indexOf(row, col)];
    }
    /**
     * {Method to determine the number of open sites}.
     *
     * @return     {Number of open sites}
     */
    public int numberOfOpenSites() {
        return count;
    }
    /**
     * {Method to determine does the system percolate?}.
     *
     * @return     {Boolean value}
     */
    public boolean percolates() {
        return uf.connected(first, last);
    }
}
/**
 * {Class for Solution}.
 */
public final class Solution {
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
        int number = Integer.parseInt(scan.nextLine());
        Percolation p = new Percolation(number);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            p.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        System.out.println(p.percolates() && p.numberOfOpenSites() != 0);
    }
}
