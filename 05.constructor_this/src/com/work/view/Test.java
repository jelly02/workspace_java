package com.work.view;

import com.work.model.dto.StudentScore;
import com.work.model.service.StudentScoreService;

public class Test {
	
	//this 테스트
	public static void main3(String[] args) {
		
		//문자열,문자열,int를 받는 생성자가 있는지 확인
		StudentScore dto3 = new StudentScore("3번","이순신",88);
		
		dto3.printInfo();
		
	}
	
	//생성자 테스트
	public static void main2(String[] args) {
		
		//기본 생성자를 이용한 객체 생성
		StudentScore dto1 = new StudentScore();
		dto1.studentNo = "1번";
		dto1.setName("홍길동");
		dto1.setScore(92);
		
		//필수 초기화 생성자를 이용한 객체 생성
		StudentScore dto2 = new StudentScore("2번","강감찬"); //210517,	null,	0
		
		//전체 초기화 생성자를 이용한 객체 생성
		StudentScore dto3 = new StudentScore("3번","이순신",88);
				
		dto1.printInfo();
		dto2.printInfo();
		dto3.printInfo();
		
	
	}

	public static void main(String[] args) {

		//회원들의 자료 저장 구조 배열 객체 100개 생성
		StudentScoreService service = new StudentScoreService(100);
		
		System.out.println("\n###등록");
		
		//회원들의 자료 저장 구조 배열을 접근해서 변경 가능
		
		
		service.addStudentScore("1번","홍길동", 92);
		service.addStudentScore("2번","강감찬", 85);
		service.addStudentScore("3번","이순신", 77);
		service.addStudentScore("4번","김유신", 98);
		service.addStudentScore("5번","유관순", 65);
		
		
//		System.out.println("\n###성적 등록 학생수 "+service.count);
		System.out.println("\n###성적 등록 학생수 "+service.getCount());

		System.out.println("\n### 전체 학생 성적 조회 ");
		service.printStudentScore();

	}
	

	

}
