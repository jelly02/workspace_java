package com.work.view;

import java.util.Random;

public class RandomTeamTest {

	public static void main(String[] args) {

		if(args.length != 1) {
			System.out.println("Usage: java RandomTeamTest 팀원숫자");
			System.exit(0);
		}
			
			/*실습 : 우리반 30명 학생들을 대상으로 랜덤하게 팀을 구성하는 프로그램을 구현하세여*/
			
			//학생의 이름 정보는 배열요소 30명 저장
		
		
			// String 문자열 타입의 숫자 데이터를 int타입으로 변환
			int teamLength = Integer.parseInt(args[0]);
			
			//2차원 배열 행 크기, 열 크기 분석해서 선언 및 생성
			
		
			int randomNo = getRandomNo();
			System.out.println(randomNo);
			
	}
	public static int getRandomNo() {
		/* 임의의 정수형 숫자를 추출하기 위한 제공 코드입니다. */
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		
		/* 0 ~ 29 사이의 임의의 숫자 추출 */
		int no = extractNo.nextInt(30); 
		return no;
	}

}
