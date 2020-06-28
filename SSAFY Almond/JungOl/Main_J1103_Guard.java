package com.ssafy.day0822;


import java.util.Scanner;

public class Main_J1103_Guard {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int col=s.nextInt();
		int row=s.nextInt();
		int circumference = (col+row)*2;
		int storeCount=s.nextInt();
		// 북쪽둘레+동쪽둘레+남쪽둘레+서쪽둘레 다 더하여 일직선처럼 처리
		int dist[]=new int[storeCount]; // 상점의 위치는 블록의 꼭지점이 될수 없으므로 storeCount+1 크기로 만들지 않아도 됨.

		int dir=0, temp=0 , storePosition = 0 , mePosition = 0;
		for (int i = 0; i <= storeCount; i++) {
			dir=s.nextInt();
			temp=s.nextInt();
			switch(dir){
			case 1:// 북쪽 : 왼쪽경계로부터의 거리가 기준이므로 m위치만큼 더한다.
				storePosition = temp;
				break;
			case 4:// 동쪽 : 일직선을 보았을때 열길이(북쪽둘레)만큼 더해진 위치가 동쪽의 시작위치
				  // 위쪽경계로부터의 거리가 기준이므로 북쪽둘레에다가 m위치만큼 더하면 됨.
				storePosition = col+temp;
				break;
			case 2:// 남쪽 :  일직선을 보았을때 열길이(북쪽둘레) + 행길이(동쪽둘레) + 열길이(남쪽둘레) 위치가 남쪽의 시작위치만
				 // 왼쪽경계로부터의 거리가 기준이므로 북동둘레에다가  열길이에서 m위치만큼 뺀 값을 더해야 둘레길이가 올바르게 됨.
				storePosition = col+row+(col-temp); 
				break;
			case 3:
				// 서쪽 : 일직선을 보았을때 열길이(북쪽둘레) + 행길이(동쪽둘레) + 열길이(남쪽둘레) + 행길이(서쪽둘레) 위치가 서쪽의 시작위치만
				 // 위쪽경계로부터의 거리가 기준이므로 북동남둘레에다가 행길이에서 m위치만큼 뺀값을 더해야 둘레길이가 올바르게 됨.
				storePosition = col+row+col+(row-temp);
				break;
			}
			if(i != storeCount){
				dist[i] = storePosition;
			}else{ // 동근이의 입력데이터인 경우
				mePosition = storePosition;
			}
		}

		//입력 끝
		
		int sum = 0;
		for (int i = 0; i < dist.length; i++) {
			temp = Math.abs(mePosition-dist[i]);  // 경비원의 위치 기준으로 상점위치를 뺀값의 절대값을 얻는다.
			// 일직선으로 다루기때문에 경비원과 상점위치간 거리는 2가지 방향으로의 경우가 존재한다.
			// 한 방향으로 경비원과 상점위치간 거리를 구했다면 다른 방향으로의 거리는 전체 둘레에서 해당 거리를 뺀값이 된다.
			// 전체 둘레가 c라고 가정하고 경비원과 상점위치의 거리가 d라면
			// c = d+(c-d) 이므로..
			sum += (Math.min(temp, circumference-temp)); 
		}
		
		System.out.println(sum);
		
		s.close();
		
	}

}
