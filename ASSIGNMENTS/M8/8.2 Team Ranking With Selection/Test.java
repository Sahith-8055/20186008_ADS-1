import java.util.Arrays;
public class Test {
    public void sort(Integer[] championsTrophy) {
        for (int i = 1; i < championsTrophy.length; i++) {
            Integer tour = championsTrophy[i];
            int j = i - 1;
            int count = tour.compareTo(championsTrophy[j]);
            while (j >= 0 && count == -1) {
                championsTrophy[j + 1] = championsTrophy[j];
                j = j - 1;
                if (j > 0) {
                    count = tour.compareTo(championsTrophy[j]);
                }
            }
            championsTrophy[j + 1] = tour;
        }
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[] {1,4,2,5,3,6,8,-1};
        System.out.println(Arrays.toString(a));
        new Test().sort(a);
        System.out.println(Arrays.toString(a));
    }
}