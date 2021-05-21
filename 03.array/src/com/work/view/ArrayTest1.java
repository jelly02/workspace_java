package com.work.view;

public class ArrayTest1 {
	
	public static void main(String[] args) {
//		main1();
//		main2();
		main3();
		
	}
	
	public static void main3() {
		
		/*실습 : 학생의 성적을 관리하는 프로그램*/
		int[] score = {92, 85, 77, 98, 65};
		String[] name = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		int sum = 0;
		
		//출력 형식
		for(int index=0; index<score.length;index++)
		{
			System.out.println((index+1)+"번 "+name[index]+"\t"+score[index]);
			sum += score[index];
		}
		      
		System.out.println("총점 : "+sum);
		System.out.println("평점 : "+sum/score.length);
		
	}
	
	public static void main2() {
		//배열에 이름 넣기(선언+생성+명시적 초기화)
		String[] student = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		
		int sum = 0;
		
		for(int i=0; i<student.length;i++)
		{
			System.out.println(student[i]);
		}
		
	}
	
	

	public static void main1() {
		//5명 학생의 성적을 관리하는 프로그램 개발
		//5명 설정 : 92. 85. 77. 98. 65
		
		//1. 배열 선언
		int[] student = new int[5];
		
		//default가 메인 > public int[] student 가 에러나는 이유 
		//2. 배열 생성
		//3. 배열 요소 사용 
		
		student[0] = 92;
		student[1] = 85;
		student[2] = 77;
		student[3] = 98;
		student[4] = 65;
		
//		for(int i=0; i<student.length;i++)
//		{
//			System.out.println((i+1)+"번 "+student[i]);
//		}
		
		// 총점		
		int sum = 0;
		
		for(int i=0; i<student.length;i++)
		{
			sum += student[i];
		}
		
		// 평균 : 00 (소수 이하 버림처리)
		int avg = sum/student.length;
		
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+avg);
		

		
	}

}
