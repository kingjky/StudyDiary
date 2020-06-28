package com.ssafy.day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Main_J1438_색종이_초 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[100][100];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j < a + 10; j++) {
                for (int j2 = b; j2 < b + 10; j2++) {
                    input[j][j2] = 1;
                }
            }
        }
        int result = 0;
        for (int[] is : input) {
            for (int i : is) {
                result += i;
            }
        }
  
        System.out.println(result);
    }// end main
}// end class
