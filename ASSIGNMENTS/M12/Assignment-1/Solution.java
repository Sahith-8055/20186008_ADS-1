import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * {Student Name}.
     */
    private String studentName;
    /**
     * {Date of birth}.
     */
    private String dob;
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
     * {Marks in all subjects}.
     */
    private int total;
    /**
     * {Category}.
     */
    private String category;
    /**
     * Constructs the object.
     * Time complexity of this methood is O(1).
     * @param      name  The name
     * @param      dob1  The dob 1
     * @param      m1    The m 1
     * @param      m2    The m 2
     * @param      m3    The m 3
     * @param      t     {Total}
     * @param      c     {Category}
     */
    Student(final String name, final String dob1, final int m1,
            final int m2, final int m3, final int t, final String c) {
        this.studentName = name;
        this.dob = dob1;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.total = t;
        this.category = c;
    }
    /**
     * Gets the total.
     * Time complexity of this methood is O(1).
     * @return     The total.
     */
    public int getTotal() {
        return this.total;
    }
    /**
     * Gets the name.
     * Time complexity of this methood is O(1).
     * @return     The name.
     */
    public String getName() {
        return this.studentName;
    }
    /**
     * Gets the dob.
     * Time complexity of this methood is O(1).
     * @return     The birth.
     */
    public String getBirth() {
        return this.dob;
    }
    /**
     * Gets the marks in subject1.
     * Time complexity of this methood is O(1).
     * @return     The marks1.
     */
    public int getMarks1() {
        return this.marks1;
    }
    /**
     * Gets the marks in subject2.
     * Time complexity of this methood is O(1).
     * @return     The marks 2.
     */
    public int getMarks2() {
        return this.marks2;
    }
    /**
     * Gets the marks in subject3.
     * Time complexity of this methood is O(1).
     * @return     The marks 3.
     */
    public int getMarks3() {
        return this.marks3;
    }
    /**
     * Gets the category.
     * Time complexity of this methood is O(1).
     * @return     The category.
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * Sets the name.
     * Time complexity of this methood is O(1).
     * @param      n     {Name}
     */
    public void setName(final String n) {
        this.studentName = n;
    }
    /**
     * Sets the dob.
     * Time complexity of this methood is O(1).
     * @param      d     {DOB}
     */
    public void setDOB(final String d) {
        this.dob = d;
    }
    /**
     * Sets the marks of subject1.
     * Time complexity of this methood is O(1).
     * @param      mark1  The mark1
     */
    public void setMarks1(final int mark1) {
        this.marks1 = mark1;
    }
    /**
     * Sets the marks of subject2.
     * Time complexity of this methood is O(1).
     * @param      mark2  The mark 2
     */
    public void setMarks2(final int mark2) {
        this.marks2 = mark2;
    }
    /**
     * Sets the marks of subject3.
     * Time complexity of this methood is O(1).
     * @param      mark3  The mark 3
     */
    public void setMarks3(final int mark3) {
        this.marks3 = mark3;
    }
    /**
     * Sets the category.
     * Time complexity of this methood is O(1).
     * @param      caste  The caste
     */
    public void setCategory(final String caste) {
        this.category = caste;
    }
    /**
     * Gets the age.
     * Time complexity of this methood is O(1).
     * @return     The age.
     */
    public String[] getAge() {
        String[] year = this.dob.split("-");
        return year;
    }
    /**
     * {Method for comparing two objects}.
     * Time complexity of this method is O(1).
     * @param      that  The that
     *
     * @return     {Integer}
     */
    public int compareTo(final Student that) {
        if (this.getTotal() > that.getTotal()) {
            return 1;
        } else if (this.getTotal() < that.getTotal()) {
            return -1;
        } else {
            if (this.getMarks3() > that.getMarks3()) {
                return 1;
            } else if (this.getMarks3() < that.getMarks3()) {
                return -1;
            } else {
                if (this.getMarks2() > that.getMarks2()) {
                    return 1;
                } else if (this.getMarks2() < that.getMarks2()) {
                    return -1;
                } else {
                    if (Integer.parseInt(this.getAge()[2])
                           > Integer.parseInt(that.getAge()[2])) {
                        return 1;
                    } else if (Integer.parseInt(this.getAge()[2])
                            <  Integer.parseInt(that.getAge()[2])) {
                        return -1;
                    } else {
                        if (Integer.parseInt(this.getAge()[1])
                            > Integer.parseInt(that.getAge()[1])) {
                            return 1;
                        } else if (Integer.parseInt(this.getAge()[1])
                                > Integer.parseInt(that.getAge()[1])) {
                            return -1;
                        } else {
                            if (Integer.parseInt(this.getAge()[0])
                                > Integer.parseInt(that.getAge()[0])) {
                                return 1;
                            } else if (Integer.parseInt(this.getAge()[0])
                                    < Integer.parseInt(that.getAge()[0])) {
                                return -1;
                            }
                        }
                    }
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
     * {Method for sort}
     * Time complexity of this method is O(N^2).
     * @param      students  The students
     */
    public void sort(final Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(students[j - 1], students[j])) {
                    exch(students, i, j);
                } else {
                    break;
                }
            }
        }
    }
    /**
     * {Method to swap two elements}.
     * Time complexity of this method is O(N).
     * @param      stud  The stud
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void exch(final Student[] stud, final int i, final int j) {
        Student temporary = stud[i];
        stud[i] = stud[j];
        stud[j] = temporary;
    }
    /**
     * {Method to find out the lesser value}.
     * Time complexity of this method is O(1).
     * @param      s1    The s 1
     * @param      s2    The s 2
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Student s1, final Student s2) {
        return s1.compareTo(s2) < 0;
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
     * {Number of students of open category}.
     */
    static int openStudents = 0;
    /**
     * {Number of students of bc category}.
     */
    static int bcStudents = 0;
    /**
     * {Number of students of sc category}.
     */
    static int scStudents = 0;
    /**
     * {Number of students of st category}.
     */
    static int stStudents = 0;
    /**
     * {Method for counting the number of students}.
     *
     * @param      s     {Student array}
     */
    public static void count(final Student[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].getCategory().equals("Open")) {
                openStudents++;
            }
            if (s[i].getCategory().equals("BC")) {
                bcStudents++;
            }
            if (s[i].getCategory().equals("SC")) {
                scStudents++;
            }
            if (s[i].getCategory().equals("ST")) {
                stStudents++;
            }
        }
    }
    /**
     * {Method for alloting seats}.
     *
     * @param      s        {Student array}
     * @param      vacancy  The vacancy
     * @param      open     The open
     * @param      back     The backward
     * @param      sc       The sc
     * @param      st       {st}
     */
    public static void counselling(final Student[] s,  int vacancy,
                                    int open,  int back,  int sc,  int st) {
        count(s);
        final int x = 30;
        Student[] array = new Student[x];
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (vacancy == 0) {
                return;
            }
            if (open > 0) {
                array[count++] = s[i];
                open--;
                vacancy--;
            } else {
                if (s[i].getCategory().equals("BC") || s[i].getCategory().equals("SC") ||
                        s[i].getCategory().equals("ST")) {
                    if (s[i].getCategory().equals("BC") && back > 0) {
                        array[count++] = s[i];
                        back--;
                        vacancy--;
                    } else if (s[i].getCategory().equals("SC") && sc > 0) {
                        array[count++] = s[i];
                        sc--;
                        vacancy--;
                    } else if (s[i].getCategory().equals("ST") && st > 0) {
                        array[count++] = s[i];
                        st--;
                        vacancy--;
                    }
                } else if (vacancy > 0 && bcStudents == 0 &&
                           scStudents == 0 && stStudents == 0) {
                    array[count++] = s[i];
                    vacancy--;
                }
            }
        }
        if (vacancy > 0) {
            for (int i = 0; i < s.length; i++) {
                if (vacancy <= 0) {
                    break;
                }
                if (s[i] != array[i]) {
                    array[count++] = s[i];
                    vacancy--;
                }
            }
        }
    }
    /**
     * {Method to display the list of students}.
     * Time complexity of this method is O(N).
     * @param      s     { parameter_description }
     */
    public static void display(Student[] s) {
        String str = "";
        int i;
        for (i = 0; i < s.length; i++) {
            str += s[i].getName() + ",";
            str += s[i].getTotal() + ",";
            str += s[i].getCategory();
            str += '\n';
        }
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        InsertionSort insertion = new InsertionSort();
        int num = Integer.parseInt(scan.nextLine());
        Student[] students = new Student[num];
        int vacancies = Integer.parseInt(scan.nextLine());
        int openvacancies = Integer.parseInt(scan.nextLine());
        int bcvacancies = Integer.parseInt(scan.nextLine());
        int scvacancies = Integer.parseInt(scan.nextLine());
        int stvacancies = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            Student data = new Student(tokens[0], tokens[1],
                                       Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                                       Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
            students[i] = data;
        }
        insertion.sort(students);
        display(students);
        System.out.println();
        counselling(students, vacancies, openvacancies, bcvacancies, scvacancies, stvacancies);
    }
}