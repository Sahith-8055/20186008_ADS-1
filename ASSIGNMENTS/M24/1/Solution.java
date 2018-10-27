import java.util.Scanner;
/**
 * Class for student data.
 */
class StudentData {
    /**
     * {Roll number of the student}.
     */
    private int rollNumber;
    /**
     * {Name of the student}.
     */
    private String name;
    /**
     * {Marks of the student}.
     */
    private double marks;
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     * @param      roll    The roll
     * @param      name1   The name1
     * @param      marks1  The marks1
     */
    StudentData(final int roll, final String name1, final double marks1) {
        this.rollNumber = roll;
        this.name = name1;
        this.marks = marks1;
    }
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     * @param      name3   The name3
     * @param      marks3  The marks3
     */
    StudentData(final String name3, final double marks3) {
        this.name = name3;
        this.marks = marks3;
    }
    /**
     * Gets the roll number.
     * Time complexity of this method is O(1).
     * @return     The roll number.
     */
    public int getRollNumber() {
        return this.rollNumber;
    }
    /**
     * Sets the roll number.
     * Time complexity of this method is O(1).
     * @param      roll1  The roll 1
     */
    public void setRollNumber(final int roll1) {
        this.rollNumber = roll1;
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
     * @param      name2  The name2
     */
    public void setName(final String name2) {
        this.name = name2;
    }
    /**
     * Gets the marks.
     * Time complexity of this method is O(1).
     * @return     The marks.
     */
    public double getMarks() {
        return this.marks;
    }
    /**
     * Sets the marks.
     * Time complexity of this method is O(1).
     * @param      marks2  The marks2
     */
    public void setMarks(final double marks2) {
        this.marks = marks2;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    public Solution() {
        // Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<Integer, StudentData> hash;
        hash = new SeparateChainingHashST<Integer, StudentData>();
        int n = Integer.parseInt(scan.nextLine());
        while (n > 0) {
            String[] tokens = scan.nextLine().split(",");
            hash.put(Integer.parseInt(tokens[0]), new StudentData(
                         tokens[1], Double.parseDouble(tokens[2])));
            n--;
        }
        int m = Integer.parseInt(scan.nextLine());
        while (m > 0) {
            String[] queries = scan.nextLine().split(" ");
            if (queries[2].equals("2")) {
                int a = Integer.parseInt(queries[1]);
                if (hash.contains(a)) {
                    System.out.println(hash.get(a).getMarks());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            } else if (queries[2].equals("1")) {
                int b = Integer.parseInt(queries[1]);
                if (hash.contains(b)) {
                    System.out.println(hash.get(b).getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            m--;
        }
    }
}
