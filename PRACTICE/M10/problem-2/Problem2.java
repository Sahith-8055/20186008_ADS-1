import java.util.Scanner;
/**
 * Class for problem 2.
 */
public class Problem2 {
	/**
	 * Constructs the object.
	 */
	private Problem2() {
		//Unused Contructor.
	}
	/**
	 * {compute recursively a new string where identical chars adjacent in the original string are separated by "*"}.
	 *
	 * @param      s     {String}
	 *
	 * @return     {String with a star}
	 */
	public static String pairStar(String s) {
		if (s.length() <= 1) {
			return s;
		}
		if (s.charAt(0) == s.charAt(1)) {
			return s.charAt(0) + "*" + pairStar(s.substring(1));
		}
		return s.charAt(0) + pairStar(s.substring(1));
	}
	/**
	 * {Client program}.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String newStr = pairStar(str);
		System.out.println(newStr);
	}
}