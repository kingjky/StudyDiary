package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1:00
 * 12920 KB
 * 76 ms
 */
public class Main_2590_색종이_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paper[] = new int[7];
		for (int i = 1; i <= 6; i++)
			paper[i] = Integer.parseInt(br.readLine());
		int cnt = 0;
		if(paper[6]>0) {
			cnt+=paper[6];
			paper[6]=0;
		}
		if(paper[5]>0) {
			cnt += paper[5];
			if(paper[1]>0)
				paper[1] -= paper[5]*11;
			paper[5] = 0;
		}
		if(paper[4]>0) {
			int area = 20 * paper[4];
			cnt += paper[4];
			if(paper[2] >= paper[4]*5) {
				area -= paper[4]*5*4;
				paper[2] -= paper[4]*5;
			} else {
				area -= paper[2]*4;
				paper[2] = 0;
			}
			if(paper[1] > 0) {
				paper[1] -= area;
			}
			paper[4] = 0;
		}
		if(paper[3]>0) {
			if(paper[3]>=4) {
				cnt+=paper[3]/4;
				paper[3] %= 4;
			}
			int tmp2 = paper[2];
			int area = 36;
			if(paper[3]>0) {
				cnt++;
				switch (paper[3]) {
				case 1:
					area -= 1*9;
					tmp2 = paper[2]>=5?5:paper[2];
					paper[2] -= tmp2;
					area -= tmp2*4;
					break;
				case 2:
					area -= 2*9;
					tmp2 = paper[2]>=3?3:paper[2];
					paper[2] -= tmp2;
					area -= tmp2*4;
					break;
				case 3:
					area -= 3*9;
					tmp2 = paper[2]>=1?1:paper[2];
					paper[2] -= tmp2;
					area -= tmp2*4;
					break;
				}
				if(paper[1]>0)
					paper[1] -= area;
			}
		}
		if(paper[2]>0) {
			if(paper[2]>9) {
				cnt+=paper[2]/9;
				paper[2] %= 9;
			}
			if(paper[2]>0) {
				cnt++;
				int area = 36;
				area -= paper[2]*4;
				paper[2] = 0;
				if(paper[1]>0)
					paper[1] -= area;
			}
		}
		if(paper[1]>0) {
			cnt += paper[1]/36;
			paper[1] %= 36;
			if(paper[1]>0) {
				cnt++;
				paper[1] = 0;
			}
		}
		System.out.println(cnt);
	}

}
