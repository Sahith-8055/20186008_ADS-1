import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for tournament.
 */
class Tournament implements Comparable<Tournament> {
    /**
     * {Name of the team in String format}.
     */
    private String teamName;
    /**
     * {Number of wins in integer format}.
     */
    private int wins;
    /**
     * {Number of losses in integer format}.
     */
    private int losses;
    /**
     * {Number of draws in integer format}.
     */
    private int draws;
    /**
     * Constructs the tournament object.
     * Time complexity of constructor is 1.
     */
    Tournament() {
        this.teamName = null;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    /**
     * Constructs the object.
     * Time complexity of constructor is 1.
     * @param      name  The name
     * @param      win   The window
     * @param      loss  The loss
     * @param      draw  The draw
     */
    Tournament(
        final String name, final int win, final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    /**
     * Method to get the name.
     * Time complexity of this method is 1.
     * @return     The name.
     */
    public String getName() {
        return this.teamName;
    }
    /**
     * Method to get the number of wins.
     * Time complexity of this method is 1.
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the losses.
     * Time complexity of this method is 1.
     * @return     The losses.
     */
    public int getLosses() {
        return this.losses;
    }
    /**
     * Method to get the number of draws.
     * Time complexity of this method is 1.
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * Method to set the team name.
     * Time complexity of this method is 1.
     * @param      s     {Team Name}
     */
    public void setName(final String s) {
        this.teamName = s;
    }
    /**
     * Method to set the number of wins.
     * Time complexity of this method is 1.
     * @param      w     {Integer wins}
     */
    public void setWins(final int w) {
        this.wins = w;
    }
    /**
     * Method to set the number of losses.
     * Time complexity of this method is 1.
     * @param      l     {Integer losses}
     */
    public void setLosses(final int l) {
        this.losses = l;
    }
    /**
     * Method to sets the number of draw.
     * Time complexity of this method is 1.
     * @param      d     {Integer draws}
     */
    public void setDraws(final int d) {
        this.draws = d;
    }
    /**
     * {Method to compare different parameters}.
     *
     * @param      that  The that
     * Time complexity of this method is 1.
     * @return     {Integers +- 1, 0}
     */
    public int compareTo(final Tournament that) {
        if (this.getWins() > that.getWins()) {
            return -1;
        } else if (this.getWins() < that.getWins()) {
            return 1;
        } else {
            if (this.getLosses() < that.getLosses()) {
                return -1;
            } else if (this.getLosses() > that.getLosses()) {
                return 1;
            } else {
                if (this.getDraws() > that.getDraws()) {
                    return -1;
                } else if (this.getDraws() < that.getDraws()) {
                    return 1;
                }
            }
        }
        return 0;
    }

}
/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * {Array of tournaments champions trophy}.
     */
    private Tournament[] championsTrophy;
    /**
     * {Variable size of integer type}.
     */
    private int size;
    /**
     * Constructs the object.
     * Time complexity of this constructor is 1.
     */
    InsertionSort() {
        final int x = 10;
        this.championsTrophy = new Tournament[x];
        this.size = 0;
    }
    /**
     * {Method to resize the array}.
     * Time complexity of this method is 1.
     */
    public void resize() {
        championsTrophy = Arrays.copyOf(
            championsTrophy, 2 * championsTrophy.length);
    }
    /**
     * Method to get the number of teams in tournament.
     * Time complexity of this method is 1.
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * {Method to add a team to the tournament}.
     * Time complexity of this method is 1.
     * @param      t     {Team}
     */
    public void add(final Tournament t) {
        if (size == championsTrophy.length) {
            resize();
        }
        championsTrophy[size++] = t;
    }
    /**
     * {Method of Insertion sort}.
     * Time complexity of Insertion sort is N^2.
     */
    public void sort() {
        for (int i = 1; i < size; i++) {
            Tournament tour = championsTrophy[i];
            int j = i - 1;
            int count = tour.compareTo(championsTrophy[j]);
            while (j >= 0 && count == -1) {
                championsTrophy[j + 1] = championsTrophy[j];
                j = j - 1;
                if (j >= 0) {
                    count = tour.compareTo(championsTrophy[j]);
                }
            }
            championsTrophy[j + 1] = tour;
        }
    }
    /**
     * Returns a string representation of the object.
     * Time complexity of toString() method is N.
     * where N is the number of teams.
     * @return     String representation of the object.
     */
    @Override
    public String toString() {
        int k = 0;
        String str = "";
        for (k = 0; k < size - 1; k++) {
            str += championsTrophy[k].getName() + ",";
        }
        str += championsTrophy[k].getName();
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
        //Unused Contructor.
    }
    /**
     * {Client program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        InsertionSort tourn = new InsertionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            tourn.add(new Tournament(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1])));
        }
        tourn.sort();
        System.out.println(tourn);
    }
}
