import java.util.Scanner;
public class Problem1 {
	private Problem1() {
		//Unused Contructor.
	}
	public static int factorial(final int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int fact = factorial(m);
		System.out.println(fact);
	}
}