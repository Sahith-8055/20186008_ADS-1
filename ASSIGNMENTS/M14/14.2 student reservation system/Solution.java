import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * {Name of the student}.
     */
    private String studentName;
    /**
     * {Date of birth}.
     */
    private Date dob;
    /**
     * {Marks in subject1}.
     */
    private int marks1;
    /**
     * {Marks in subject2}.
     */
    private int marks2;
    /**
     * {Marks in subject3}.
     */
    private int marks3;
    /**
     * {Total marks}.
     */
    private int totalmarks;
    /**
     * {Category}.
     */
    private String category;
    /**
     * {Student gets admission (or) not}.
     */
    private boolean allocation;
    /**
     * Constructs the object.
     *
     * @param      name  The name
     * @param      dob1  The dob1
     * @param      m1    The m1
     * @param      m2    The m2
     * @param      m3    The m3
     * @param      t     {Total marks}
     * @param      cat   The category
     */
    Student(final String name, final String dob1, final int m1,
            final int m2, final int m3, final int t, final String cat) {
        this.studentName = name;
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dob = sd.parse(dob1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.totalmarks = t;
        this.category = cat;
        this.allocation = false;
    }
    /**
     * Gets the allocation.
     * Time complexity of this method is O(1).
     * @return     The allocation.
     */
    public boolean getAllocation() {
        return this.allocation;
    }
    /**
     * Sets the allocation.
     * Time complexity of this method is O(1).
     * @param      allot  The allot
     */
    public void setAllocation(final boolean allot) {
        this.allocation = allot;
    }
    /**
     * Gets the student name.
     * Time complexity of this method is O(1).
     * @return     The student name.
     */
    public String getStudentName() {
        return this.studentName;
    }
    /**
     * Sets the student name.
     * Time complexity of this method is O(1).
     * @param      student1  The student1
     */
    public void setStudentName(final String student1) {
        this.studentName = student1;
    }
    /**
     * Gets the m1.
     * Time complexity of this method is O(1).
     * @return     The m1.
     */
    public int getM1() {
        return this.marks1;
    }
    /**
     * Sets the m1.
     * Time complexity of this method is O(1).
     * @param      mark1  The mark 1
     */
    public void setM1(final int mark1) {
        this.marks1 = mark1;
    }
    /**
     * Gets the m2.
     * Time complexity of this method is O(1).
     * @return     The m 2.
     */
    public int getM2() {
        return this.marks2;
    }
    /**
     * Sets the m2.
     * Time complexity of this method is O(1).
     * @param      mark2  The mark 2
     */
    public void setM2(final int mark2) {
        this.marks2 = mark2;
    }
    /**
     * Gets the m3.
     * Time complexity of this method is O(1).
     * @return     The m 3.
     */
    public int getM3() {
        return this.marks3;
    }
    /**
     * Sets the m3.
     * Time complexity of this method is O(1).
     * @param      mark3  The mark 3
     */
    public void setM3(final int mark3) {
        this.marks3 = mark3;
    }
    /**
     * Gets the dob.
     * Time complexity of this method is O(1).
     * @return     The dob.
     */
    public Date getDOB() {
        return this.dob;
    }
    /**
     * Sets the dob.
     * Time complexity of this method is O(1).
     * @param      d     {Date object}
     */
    public void setDOB(final Date d) {
        this.dob = d;
    }
    /**
     * Gets the reservation.
     * Time complexity of this method is O(1).
     * @return     The reservation.
     */
    public String getReservation() {
        return this.category;
    }
    /**
     * Sets the category.
     * Time complexity of this method is O(1).
     * @param      c     {String}
     */
    public void setCategory(final String c) {
        this.category = c;
    }
    /**
     * Gets the total.
     * Time complexity of this method is O(1).
     * @return     The total.
     */
    public int getTotal() {
        return this.totalmarks;
    }
    /**
     * Sets the total.
     * Time complexity of this method is O(1).
     * @param      tm    The time
     */
    public void setTotal(final int tm) {
        this.totalmarks = tm;
    }
    /**
     * {Method to compare two objects}
     * Time complexity of this method is O(1).
     * @param      that  The that
     *
     * @return     {Integer}
     */
    public int compareTo(final Student that) {
        if (this.getTotal() > that.getTotal()) {
            return -1;
        }
        if (this.getTotal() < that.getTotal()) {
            return 1;
        }
        if (this.getM3() > that.getM3()) {
            return -1;
        }
        if (this.getM3() < that.getM3()) {
            return 1;
        }
        if (this.getM2() > that.getM2()) {
            return -1;
        }
        if (this.getDOB().compareTo(that.getDOB()) < 0) {
            return 1;
        }
        if (this.getDOB().compareTo(that.getDOB()) > 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity of this method is O(N).
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTotal() + ",");
        sb.append(this.getReservation());
        return sb.toString();
    }
}
/**
 * Class for heap.
 */
final class Heap {
    /**
     * Constructs the object.
     */
    private Heap() {
        //Unused Constructor.
    }
    /**
     * {Method to sink}.
     * Time complexity of this method is O(log(N)).
     * @param      a    {Comparable array}
     * @param      k     {Integer}
     * @param      n     {Integer}
     */
    private static void sink(final Comparable[] a,
        final int k, final int n) {
        int l = k;
        while (2 * l <= n) {
            int j = 2 * l;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, l, j)) {
                break;
            }
            exch(a, l, j);
            l = j;
        }
    }
    /**
     * {Method for comparing two objects}.
     * Time complexity of this method is O(1).
     * @param      a     {Comparable array}
     * @param      i     {Integer}
     * @param      j     {Integer}
     *
     * @return     {Boolean}
     */
    private static boolean less(final Comparable[] a,
        final int i, final int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }
    /**
     * {Method to exchange two objects}.
     * Time complexity of this method is O(1).
     * @param      a     {Comparable array}
     * @param      i     {Integer}
     * @param      j     {Integer}
     */
    private static void exch(final Comparable[] a,
        final int i, final int j) {
        Comparable swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }
    /**
     * {Method for sort}.
     * Time complexity of this method is O(Nlog(N)).
     * @param      a     {Comparable array}
     */
    public static void sort(final Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
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
        //Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int unreservedSeats = Integer.parseInt(scan.nextLine());
        int bcSeats = Integer.parseInt(scan.nextLine());
        int scSeats = Integer.parseInt(scan.nextLine());
        int stSeats = Integer.parseInt(scan.nextLine());

        Student[] students = new Student[n];
        for (int k = 0; k < n; k++) {
            String[] tokens = scan.nextLine().split(",");
            students[k] = new Student(tokens[0], tokens[1],
                                      Integer.parseInt(tokens[2]),
                                      Integer.parseInt(tokens[2 + 1]),
                                      Integer.parseInt(tokens[2 + 2]),
                                      Integer.parseInt(tokens[2 + 2 + 1]),
                                      tokens[2 + 2 + 2]);
        }
        Heap.sort(students);
        print(students);
        counselling(students, vacancies,
                    unreservedSeats, bcSeats, scSeats, stSeats);
    }
    /**
     * {Method to print}.
     * Time complexity of this method is O(N).
     * @param      s     {Student array}
     */
    public static void print(final Student[] s) {
        for (Student stu : s) {
            System.out.println(stu);
        }
        System.out.println();
    }
    /**
     * {Method for counselling}.
     * Time complexity of this method is O(N^2).
     * @param      students         The students
     * @param      vacancies        The vacancies
     * @param      unreservedSeats  The unreserved seats
     * @param      bcSeats          The bc seats
     * @param      scSeats          The screen seats
     * @param      stSeats          The st seats
     */
    public static void counselling(final Student[] students, final int vacancies,
                                   final int unreservedSeats, final int bcSeats,
                                   final int scSeats, final int stSeats) {
        int i = 0;
        int k = 0;
        int n = students.length;
        int v = vacancies;
        int us = unreservedSeats;
        int bc = bcSeats;
        int sc = scSeats;
        int st = stSeats;
        Student[] alloted = new Student[v];
        for (i = 0; i < n; i++) {
            if (v == 0) {
                break;
            }
            if (us > 0) {
                us--;
                students[i].setAllocation(true);
                alloted[k++] = students[i];
                v--;
            }
            if (bc > 0) {
                if (students[i].getReservation().equals("BC")
                        &&  students[i].getAllocation() == false) {
                    bc--;
                    students[i].setAllocation(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }
            if (sc > 0) {
                if (students[i].getReservation().equals("SC")
                        &&  students[i].getAllocation() == false) {
                    sc--;
                    students[i].setAllocation(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }
            if (st > 0) {
                if (students[i].getReservation().equals("ST")
                        &&  students[i].getAllocation() == false) {
                    st--;
                    students[i].setAllocation(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (v > 0 && students[i].getReservation().equals("Open")
                    && students[i].getAllocation() == false) {
                students[i].setAllocation(true);
                alloted[k++] = students[i];
                v--;
            }
        }
        Heap.sort(alloted);
        print(alloted);
    }
}
