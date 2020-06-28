package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * Arrays
 */
public class Main_2577_회전초밥_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, D, K, C;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[] belt = new int[N+K-1];
		for (int n = 0; n < N; n++) {
			belt[n] = Integer.parseInt(br.readLine());
		}
		for (int n = N, i=0; n < N+K-1; n++, i++) {
			belt[n] = belt[i];
		}
		int max = -1;
		int cnt = 0;
		int fish[] = new int[D+1];
		
		int isNotC = 0;
		for (int k = 0; k < K; k++) {
			if(fish[belt[k]]==0) cnt++;
			fish[belt[k]]++;
		}
		if(fish[C]==0) isNotC = 1;
		if(cnt+isNotC > max) max = cnt+isNotC;
		for (int n = K; n < N+K-1; n++) {
			fish[belt[n-K]]--;
			if(fish[belt[n-K]]==0) cnt--;
			if(fish[belt[n]]==0) cnt++;
			fish[belt[n]]++;
			if(fish[C]==0) isNotC = 1;
			else isNotC = 0;
			if(cnt+isNotC > max) max = cnt+isNotC;
		}
		System.out.println(max);
	}

}
