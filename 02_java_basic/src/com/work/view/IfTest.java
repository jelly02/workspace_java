package com.work.view;

public class IfTest {
	
	public static void main(String[] args) {
		int score = 100;
		String grade = null;
		
		if(score>= 0 & score <= 100)
		{
			switch(score/10)
			{
				case 10:
				case 9:
					grade="A";
					break;
				case 8:
					grade="B";
					break;
				case 7:
					grade="C";
					break;
				case 6:
					grade="D";
					break;
				default :
					grade="F";
					break;
			}
		}
		
	}

	
	
	public static void main1(String[] args) {
		
		int score = 95;
		
		if (score >= 70) {
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}

	}
	
public static void main2(String[] args) {
		
		int score=107;
		String grade=null;
		
		if (score>= 0 & score <= 100)
		{
			if (score>=90)
			{
				System.out.println(score +" A등급");
			}
			else if(score>=80)
			{
				System.out.println(score +" B등급");
			}
			else if(score>=70)
			{
				System.out.println(score +" C등급");
			}
			else if(score>=60)
			{
				System.out.println(score +" D등급");
			}
			else
			{
				System.out.println(score +" F등급");
			}
		}
		else
		{
			System.out.println("점수는 0~100까지입니다"+"등급"+grade);
		}
		
	}

}
