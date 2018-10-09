import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
class Student implements Comparable<Student> {
    private String studentName;
    private Date dob;
    private int marks1;
    private int marks2;
    private int marks3;
    private int totalmarks;
    private String category;
    private boolean allocation;
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
    public boolean getAllocation() {
        return this.allocation;
    }
    public void setAllocation(final boolean allot) {
        this.allocation = allot;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public void setStudentName(final String student1) {
        this.studentName = student1;
    }
    public int getM1() {
        return this.marks1;
    }
    public void setM1(final int mark1) {
        this.marks1 = mark1;
    }
    public int getM2() {
        return this.marks2;
    }
    public void setM2(final int mark2) {
        this.marks2 = mark2;
    }
    public int getM3() {
        return this.marks3;
    }
    public void setM3(final int mark3) {
        this.marks3 = mark3;
    }
    public Date getDOB() {
        return this.dob;
    }
    public void setDOB(final Date d) {
        this.dob = d;
    }
    public String getReservation() {
        return this.category;
    }
    public void setCategory(final String c) {
        this.category = c;
    }
    public int getTotal() {
        return this.totalmarks;
    }
    public void setTotal(final int tm) {
        this.totalmarks = tm;
    }
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
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTotal() + ",");
        sb.append(this.getReservation());
        return sb.toString();
    }
}
class InsertionSort {
    private static boolean less(final Comparable v, final Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sort(final Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
public class Solution {
    private Solution() {
        //Unused Constructor.
    }
    public static void main(String[] args) {
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
        InsertionSort.sort(students);
        print(students);
        counselling(students, vacancies, unreservedSeats, bcSeats, scSeats, stSeats);
    }
    public static void print(final Student[] s) {
        for (Student stu : s) {
            System.out.println(stu);
        }
        System.out.println();
    }
    public static void counselling(final Student[] students, int vacancies,
                                   int unreservedSeats, int bcSeats, int scSeats, int stSeats) {
        int i = 0;
        int k = 0;
        int n = students.length;
        Student[] alloted = new Student[vacancies];
        for (i = 0; i < n; i++) {
            if (vacancies == 0) {
                break;
            }
            if (unreservedSeats > 0) {
                unreservedSeats--;
                students[i].setAllocation(true);
                alloted[k++] = students[i];
                vacancies--;
            }
            if (bcSeats > 0) {
                if (students[i].getReservation().equals("BC") &&
                        students[i].getAllocation() != true) {
                    bcSeats--;
                    students[i].setAllocation(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
            if (scSeats > 0) {
                if (students[i].getReservation().equals("SC") &&
                        students[i].getAllocation() != true) {
                    scSeats--;
                    students[i].setAllocation(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
            if (stSeats > 0) {
                if (students[i].getReservation().equals("SC") &&
                        students[i].getAllocation() != true) {
                    stSeats--;
                    students[i].setAllocation(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (vacancies > 0 && students[i].getReservation().equals("Open") &&
                    students[i].getAllocation() == false) {
                students[i].setAllocation(true);
                alloted[k++] = students[i];
                vacancies--;
            }
        }
        InsertionSort.sort(alloted);
        print(alloted);
    }
}