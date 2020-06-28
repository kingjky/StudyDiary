package algoHW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class tower {
	int height;
	int location;

	public tower() {
		this.height = -1;
		this.location = -1;
	}

	public tower(int height, int location) {
		this.height = height;
		this.location = location;
	}
}

public class Main_1809_탑_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Stack<tower> stack = new Stack<tower>();
		int[] result = new int[N];
		int index = 0;
		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int current = Integer.parseInt(arr[i]);
			tower t = null;
			int reception = 0;
			while (!stack.isEmpty()) {
				t = stack.pop();
				if (t.height >= current) {
					reception = t.location;
					stack.push(t);
					break;
				}
			}
			stack.push(new tower(current, index + 1));
			result[index++] = reception;
		}
		for (int i = 0; i < N; i++)
			bw.write(result[i] + " ");
		bw.write('\n');
		bw.flush();
		bw.close();
	}
}
