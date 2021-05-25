package com.work.model.service;

import com.work.model.dto.StudentScore;

/**
 * <pre>
 * 학생 성적 관리 프로그램 시작 클래스 
 * 1. 등록 : addStudentScore (학번, 이름, 성적) > void
 * 2. 조회
 * 
 * 3. 총점 계산 기능
 * 4. 평균 계산 기능
 * 
 * </pre>
 * 
 * @author Kimjuri
 * @version ver.1.0
 * @since jdk1.8
 * @see com.work.model.dto.StudentScore
 * @see com.work.model.dto.StudentScore#printInfo()
 * @see com.work.model.service.StudentScoreSerivice
 */

public class StudentScoreService {
	
	/**
	 *  학생 성적 관리 프로그램 시작 메서드
	 */
//	public StudentScore[] students = new StudentScore[3]; //컨쉬o
	
	//학생들의 성적 정보 개체를 그룹으로 관리하기 위한 자료 저장구조 멤버변수 선언 : 배열 객체 생성은 생성자 위임처리
	private StudentScore[] students ;
	
	// 등록된 학생의 숫자 정보 및 등록해야하는 배열 요소의 인덱스 번호 
	//변경은 불가하지만, 등록 학생수 조회는 제공해야함 getter();
	private int count;
	
	//기본 생성자 : 배열의 크기를 기본 10개 초기화
	public StudentScoreService() {
		this(10);

	}
	
	public StudentScoreService(int length) {
		students = new StudentScore[length];
	}
	
	//현재 등록된 학생 성적의 숫자 조회 메서드 
	public int getCount(){
		return count;
	}
	
	
	// 1. 등록 : addStudentScore (학번, 이름, 성적) > void
	/**
	 * <pre>
	 * 등록 결과 메시지 출력
	 * - 성공 : 등록 성공
	 * - 실패 : 등록 실패
	 * </pre>
	 * @param studentNo
	 * @param name
	 * @param score
	 */
	public void addStudentScore(String studentNo, String name, int score) {
		
		if(count== students.length) {
			extendStudents(10);
			System.out.println("학생들의 자료 저장 구조를 추가 확장하였습니다");
		}
		
		//StudentScore 객체 생성 
		StudentScore dto = new StudentScore();
		
		// argument로 전달 받은 정보로 생성 객체 정보 설정
		dto.studentNo = studentNo;
		dto.name = name;
		dto.score = score;
		
		// 생성된 객체를 배열의  count 요소 위치에 등록
		//count 등록 인원을 1 증가
		students[count++] = dto;
		
	}
	
	public void extendStudents(int length) {
	
		StudentScore[] studentTemp = new StudentScore[students.length + length];
		
		for(int index = 0; index < students.length; index++)
		{
			studentTemp[index]=students[index];
		}
		
		students = studentTemp;
	}
	
	//전체 학생 성적 조회 메소드
	public void printStudentScore() {
		for(int index=0; index<count; index++) {
			students[index].printInfo();
		}
	}

}
