package com.work.view;

import java.util.Random;

public class RandomTeamTest {

	/*
	 * 실습 : 
	 * 우리반 30명 학생들을 대상으로 랜덤하게 팀 구성하는 프로그램을 구현하세요
	 * 1. 팀당 인원수??
	 * 	>> 고정적 / 가변적
	 * 	>> 가변적 => 사용자 입력(IO, main(String[] args) 아규먼트 전달)
	 *  >> 사용자 입력 : IO (java.io API 활용)
	 *  >> main(String[] args) 아규먼트 : 숫자를 입력해도 String => String 입력 숫자문자열을 숫자타입(int) 변환 기술??
	 *  >> main() 메서드에 아규먼트 전달해서 실행하는 방법??
	 *  
	 * 2. 랜덤하게 배열요소를 접근하기 위한 방법???
	 * 	>> 30명
	 * 	>> 30개 String[] 배열생성해서 학생들의 이름을 저장   
	 *  >> 배열요소 인덱스번호 0 ~ 배열크기-1
	 *  >> java.util.Random API 활용해서 임의 숫자를 추출하는 유틸리티 클래스 제공
	 * 
	 * 3. 남는 인원은 어떤 팀에 배정할것인지??
	 * 	>> 남는 인원을 첫번째 팀부터 순서대로 1명씩 일괄 배정??
	 *  >> 배정하는 팀도 랜덤하게 처리배정??
	 *  
	 * 
	 */
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: java RandomTeamTest : 정확한 값(숫자)를 입력해주세요.");
			System.exit(0);
		}
		
		// String 문자열타입의숫자데이터를 int 타입으로 변환
		int teamLength = Integer.parseInt(args[0]); 
		
		// 학생의 이름정보는 배열요소 30명 저장
		String[] student = new String[] {"김기영","김나연","김대현","김수정","김의현","김재현","김종환","김주리","김주엽","김지원","김현수","김현진","김혜진","노한나","문수인","박민재","박영규","박유정","신지수","유건","유동국","유준성","이태규","이택근","이희원","장현우","조성현","최낙원","한다예","황윤아"};
				
		int randomNo = getRandomNo();
		System.out.println(randomNo);
		
		// 2차원 배열 행크기, 열크기 분석해서 선언 및 생성
		String[][] team = new String [randomNo][];

		for(int i=0; i<randomNo; i++)
		{
			System.out.print(student[i]);
			
			for(int j=0; j<randomNo;j++)
			{
				System.out.println(team[i][j]);
			}
		}
		
		
//		for(int i=0; i<randomNo; i++)
//		{
//			for(int j=0; j<team[i].length;j++)
//			{
//				team[i][j] = student[i];
//				j++;
//			}
//		}
//		
//		for(int i=0; i<team.length;i++)
//		{
//			System.out.println((i+1)+"조"+team[i]);
//		}
//
//		
		
		
	
//		for (int i = 0; i <= student.length; i++) { 
//			
//			System.out.print((i + 1) + "팀 " + "\t");
//			
//			for(int j = 0; j < team.length; j++) {
//				System.out.print(team[j][i] + "\t");
//			}
//			System.out.println();
//		}
		
	}

	public static int getRandomNo() {
		/* 임의의 정수형 숫자를 추출하기 위한 제공 코드입니다. */
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		
		/* 0 ~ 29 사이의 임의의 숫자 추출 */
		int no = extractNo.nextInt(30); 
		return no;
	}

}
