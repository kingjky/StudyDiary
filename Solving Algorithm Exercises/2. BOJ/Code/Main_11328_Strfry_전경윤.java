package baekjoon;
import java.util.Scanner;

public class Main_11328_Strfry_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int t = 0; t < N; t++) {
			String s1, s2;
			char[] c1, c2;

			s1 = sc.next();
			s2 = sc.next();

			c1 = s1.toCharArray();
			c2 = s2.toCharArray();

			Boolean answer = true;
			
			if (c1.length != c2.length)
				answer = false;

			if (answer) {
				first: for (int i = 0; i < c2.length; i++) {
					for (int j = 0; j < c1.length; j++) {
						if (c2[i] == c1[j]) {
							c1[j] = 'a' - 1;
							continue first;
						}
					}
					answer = false;
					break;
				}
			}

			if (answer)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
	}
}
