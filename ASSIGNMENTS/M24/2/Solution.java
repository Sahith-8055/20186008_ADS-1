import java.util.Scanner;
class StudentData implements Comparable<StudentData> {
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
    StudentData(final String name1, final double marks1, final int roll) {
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
    public int compareTo(final StudentData that) {
        if (this.marks > that.marks) {
            return 1;
        }
        if (this.marks < that.marks) {
            return -1;
        }
        if (this.rollNumber > that.rollNumber) {
            return 1;
        }
        if (this.rollNumber < that.rollNumber) {
            return -1;
        }
        return 0;
    }
}
public class Solution {
    public Solution() {
        // Constructor.
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<StudentData, Integer> bst;
        bst = new BST<StudentData, Integer>();
        int n = Integer.parseInt(scan.nextLine());
        while (n > 0) {
            String[] tokens = scan.nextLine().split(",");
            bst.put(new StudentData(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[0])), Integer.parseInt(tokens[0]));
            n--;
        }
        int m = Integer.parseInt(scan.nextLine());
        while (m > 0) {
            String[] queries = scan.nextLine().split(" ");
            if (queries[0].equals("BE")) {
                double a = Double.parseDouble(queries[1]);
                double b = Double.parseDouble(queries[2]);
                for (StudentData student : bst.keys()) {
                    if (student.getMarks() >= a && student.getMarks() <= b) {
                        System.out.println(student.getName());
                    }
                }
            } else if (queries[0].equals("LE")) {
                double c = Double.parseDouble(queries[1]);
                for (StudentData student : bst.keys()) {
                    if (student.getMarks() <= c) {
                        System.out.println(student.getName());
                    }
                }
            } else if (queries[0].equals("GE")) {
                double d = Double.parseDouble(queries[1]);
                for (StudentData student : bst.keys()) {
                    if (student.getMarks() >= d) {
                        System.out.println(student.getName());
                    }
                }
            }
            m--;
        }
    }
}