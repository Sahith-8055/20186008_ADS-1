import java.util.Scanner;
public class Solution {
    public Solution() {
        // Constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinearProbingHashST<String, Integer> hash;
        int n = Integer.parseInt(scan.nextLine());
        hash = new LinearProbingHashST<String, Integer>();
        while (n > 0) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "put":
                hash.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
            case "get":
                System.out.println(hash.get(tokens[1]));
                break;
            case "delete":
                hash.delete(tokens[1]);
                break;
            case "display":
                hash.display();
                break;
            default:
                break;
            }
            n--;
        }
    }
}