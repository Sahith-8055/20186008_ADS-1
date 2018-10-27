import java.util.Scanner;
class StudentData {
    private int rollNumber;
    private String name;
    private double marks;
    StudentData(final int roll, final String name1, final double marks1) {
        this.rollNumber = roll;
        this.name = name1;
        this.marks = marks1;
    }
    StudentData(final String name3, final double marks3) {
        this.name = name3;
        this.marks = marks3;
    }
    public int getRollNumber() {
        return this.rollNumber;
    }
    public void setRollNumber(final int roll1) {
        this.rollNumber = roll1;
    }
    public String getName() {
        return this.name;
    }
    public void setProperty(final String name2) {
        this.name = name2;
    }
    public double getMarks() {
        return this.marks;
    }
    public void setMarks(final double marks2) {
        this.marks = marks2;
    }
    // public String toString() {
    //     return this.name + "\n";
    // }
}
public class Solution {
    public Solution() {
        // Constructor.
    }
    public static void main(String[] args) {
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