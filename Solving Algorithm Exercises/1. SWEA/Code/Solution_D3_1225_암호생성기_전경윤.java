import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author student
 * 00:16:07
 * M : 21060 kb
 * T : 128 ms
 */
public class Solution_D3_1225_암호생성기_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			String[] s = br.readLine().split(" ");
			Queue<Integer> queue = new LinkedList<Integer>();
			for (String string : s) {
				queue.offer(Integer.parseInt(string));
			}
			int t1 = 0;
			int j = 0;
			while ((t1 = queue.poll() - ((j++ % 5) + 1)) > 0) {
				queue.offer(t1);
			}
			queue.offer(0);
			
			System.out.print("#" + t);
			for (Integer integer : queue) {
				System.out.print(" " + integer);
			}
			System.out.println();
		}
	}
}
