package com.work.model.dto;

public class StudentScore {

	public String studentNo = "215200108";
	public String name;
	public int score;
	
	
	//학생의 성적 정보를 출력하는 메서드 선언(반환값 필요 없음)
	public void printInfo() {
		System.out.println(studentNo + ",\t" + name + ",\t" + score);
	}
	
	//학생의 성적을 아규먼트로 전달받은 데이터로 변경하는 메서드
	public void setScore(int modifyScore)
	{
		score = modifyScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
		
	
	
	
}
