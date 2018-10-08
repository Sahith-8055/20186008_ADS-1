import java.util.Scanner;
class IsMin<E extends Comparable<E>> {
    private E[] array;
    IsMin(final E[] a) {
        this.array = a;
    }
    public boolean isMinHeap() {
        for (int i = 0; i < array.length - 1; i++) {
            if (less(i + 1, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean less(final int a, final int b) {
        return array[a].compareTo(array[b]) < 0;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int testcases = Integer.parseInt(scan.nextLine());
        switch (str) {
        case "String":
            while (testcases > 0) {
                String[] tokens = scan.nextLine().split(",");
                IsMin<String> min = new IsMin<String>(tokens);
                System.out.println(min.isMinHeap());
                testcases--;
            }
            break;
        case "Integer":
            while (testcases > 0) {
                String[] tokens = scan.nextLine().split(",");
                Integer[] intTokens = new Integer[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    intTokens[j] = Integer.parseInt(tokens[j]);
                }
                IsMin<Integer> min = new IsMin<Integer>(intTokens);
                System.out.println(min.isMinHeap());
                testcases--;
            }
            break;
        case "Double":
            while (testcases > 0) {
                String[] tokens = scan.nextLine().split(",");
                Double[] douTokens = new Double[tokens.length];
                for (int k = 0; k < tokens.length; k++) {
                    douTokens[k] = Double.parseDouble(tokens[k]);
                }
                IsMin<Double> min = new IsMin<Double>(douTokens);
                System.out.println(min.isMinHeap());
                testcases--;
            }
            break;
        case "Float":
            while (testcases > 0) {
                String strr = scan.nextLine();
                if (strr.equals("")) {
                    System.out.println("false");
                    break;
                } else {
                    String[] tokens = strr.split(",");
                    Float[] floTokens = new Float[tokens.length];
                    for (int l = 0; l < tokens.length; l++) {
                        floTokens[l] = Float.parseFloat(tokens[l]);
                    }
                    IsMin<Float> min = new IsMin<Float>(floTokens);
                    System.out.println(min.isMinHeap());
                    testcases--;
                }
            }
            break;
        }
    }
}