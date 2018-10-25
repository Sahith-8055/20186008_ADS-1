import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // Unused constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> chaining;
        chaining = new SeparateChainingHashST<String, Integer>();
        String tokens = scan.nextLine();
        String[] magazine = scan.nextLine().split(" ");
        for (int i = 0; i < magazine.length; i++) {
            if (chaining.contains(magazine[i])) {
                chaining.put(magazine[i], chaining.get(magazine[i]) + 1);
            } else {
                chaining.put(magazine[i], 1);
            }
        }
        String[] tobeSearched = scan.nextLine().split(" ");
        for (int i = 0; i < tobeSearched.length; i++) {
            if (chaining.contains(tobeSearched[i])) {
                if (chaining.get(tobeSearched[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    chaining.put(
                        tobeSearched[i], chaining.get(tobeSearched[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
