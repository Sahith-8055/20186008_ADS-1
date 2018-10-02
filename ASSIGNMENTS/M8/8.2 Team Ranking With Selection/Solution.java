import java.util.Scanner;
import java.util.Arrays;
class Tournament implements Comparable<Tournament> {
    private String teamName;
    private int wins;
    private int losses;
    private int draws;
    Tournament() {
        this.teamName = null;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    Tournament(final String name, final int win, final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    public String getName() {
        return this.teamName;
    }
    public int getWins() {
        return this.wins;
    }
    public int getLosses() {
        return this.losses;
    }
    public int getDraws() {
        return this.draws;
    }
    public void setName(final String s) {
        this.teamName = s;
    }
    public void setWins(final int w) {
        this.wins = w;
    }
    public void setLosses(final int l) {
        this.losses = l;
    }
    public void setDraws(final int d) {
        this.draws = d;
    }
    public int compareTo(final Tournament that) {
        if (this.getWins() > that.getWins()) {
            return 1;
        } else if (this.getWins() < that.getWins()) {
            return -1;
        } else {
            if (this.getLosses() < that.getLosses()) {
                return 1;
            } else if (this.getLosses() > that.getLosses()) {
                return -1;
            } else {
                if (this.getDraws() > that.getDraws()) {
                    return 1;
                } else if (this.getDraws() < that.getDraws()) {
                    return -1;
                }
            }
        }
        return 0;
    }

}
class InsertionSort {
    private Tournament[] championsTrophy;
    private int size;
    InsertionSort() {
        final int x = 10;
        this.championsTrophy = new Tournament[10];
        this.size = 0;
    }
    public void resize() {
        championsTrophy = Arrays.copyOf(championsTrophy, 2 * championsTrophy.length);
    }
    public int getSize() {
        return this.size;
    }
    public void add(final Tournament t) {
        if (size == championsTrophy.length) {
            resize();
        }
        championsTrophy[size++] = t;
    }
    public void sort() {
        for (int i = 0; i < size; i++) {
            Tournament tour = championsTrophy[i];
            int j = 0;
            for (j = i; j > 0; j--) {
                int count = championsTrophy[i].compareTo(championsTrophy[j]);
                if (j >= 0 && count == -1) {
                    championsTrophy[j + 1] = championsTrophy[j];
                    j--;
                }
            }
            championsTrophy[j + 1] = tour;
        }
    }
    public void print() {
        int k = 0;
        for (k = 0; k < size - 1; k++) {
            System.out.print(championsTrophy[k].getName() + ",");
        }
        System.out.println(championsTrophy[k].getName());
    }
}
public class Solution {
    private Solution() {
        //Unused Contructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        InsertionSort tourn = new InsertionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            tourn.add(new Tournament(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        }
        tourn.sort();
        tourn.print();
    }
}