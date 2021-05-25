package com.work.model.dto;

/**
 * <pre>
 * 학생 정보 도메인 클래스 
 * </pre>
 * 
 * @author Kimjuri
 * @version ver.1.0
 * @since jdk1.8
 */


public class StudentScore {
	
	/**학번 : 식별 키*/
	public String studentNo = "210517";
	
	/**이름 : 필수*/
	public String name;
	
	/**성적 : 선택*/
	public int score;

	//기본 생성자
	public StudentScore() {
		System.out.println("기본 생성자 수행 : 객체 생성시 공통로직 : 바람 출력 ");

	}
	
	/**
	 * 필수 데이터 초기화 생성자 
	 * @param studentNo : 학번
	 * @param name : 이름
	 */
	public StudentScore(String studentNo, String name) {
		this();//자기의 기본 생성자로 갈!
		this.studentNo = studentNo;
		this.name = name;
		
//		System.out.println("필수 생성자 수행 : 별 출력");
	}
	
	
	/**
	 * 전체데이터 초기화생성자(학번, 이름, 성적)
	 * @param studentNo : 학번
	 * @param name : 이름
	 * @param score : 성적
	 */
	public StudentScore(String studentNo, String name, int score)
	{
		this(studentNo,name);
	
//		this.studentNo = studentNo;
//		this.name = name;
		this.score = score;
		
//		System.out.println("전체 생성자 수행 : 별 출력");
	}
	
	/**
	 * 학생의 성적정보를 출력하는 메서드
	 */
	
	public void printInfo() {
		System.out.println(studentNo + ",\t" + name + ",\t" + score);
	}
	

	/**
	 * 성적 변경 메서드 
	 * @param modifyScore 변경 성적
	 */
	public void setScore(int modifyScore) {
		score = modifyScore;
	}

	
	/**
	 * 학생의 성적을 조회하는 메서드
	 * @return 학생 성적
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 학생의 이름정보를 변경하는 메서드
	 * @param modifyName (변경 이름)
	 */
	public void setName(String modifyName) {
		name = modifyName;
	}
	
	/**
	 * 학생의 이름정보를 변경하는 메서드
	 * @param name (학생 이름)
	 */
	public String getName() {
		return name;
	}
}







