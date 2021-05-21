package com.work.view;

public class ArrayTest2 {

	public static void main(String[] args) {
//		doA();
		 doB();
	}
	
	//행마다 열 크기 다르게 지정
	public static void doB() {
		
		//1반 80, 90
		//2반 70, 60, 50, 88
		//3반 95, 87, 67
	
		int [][] scores = new int [3][];
		
		scores[0] = new int [2];
		scores[0] = new int [4];
		scores[0] = new int [3];
		
		scores[0][0] = 80;
		scores[0][1] = 90;
		
		scores[1][0] = 70;
		scores[1][1] = 60;
		scores[1][2] = 50;
		scores[1][3] = 88;
		
		scores[2][0] = 98;
		scores[2][1] = 87;
		scores[2][2] = 67;
		
		/* 출력 양식
		 * 1반 : 00 00
		 * [총점:000, 평균:000]
		 * */
		int sum = 0;
		
		for (int i=0; i<scores.length;i++) //행 크기 만큼 반복
		{
			sum = 0;
			System.out.print((i+1)+"반 "+"\t");
			
			for(int j=0; j<scores[i].length;j++) 
			{
				sum+=scores[i][j];
				System.out.print(scores[i][j]+"\t");
			}
			System.out.println();
			System.out.println("[총점:"+sum+", 평균 :"+sum/scores[i].length+"]");
			System.out.println();
		}
		
		
		
	}
	
	public static void doA()
	{
		//1반 80, 90, 70, 80
		//2반 70, 60, 50, 88
		//3반 95, 87, 67, 92
		
		//1. 선언 + 2. 생성
		int [][] scores = new int [3][4];
		
		//3. 2차원 배열 요소 값 할당
		
		scores[0][0] = 80;
		scores[0][1] = 90;
		scores[0][2] = 70;
		scores[0][3] = 80;
		
		scores[1][0] = 70;
		scores[1][1] = 60;
		scores[1][2] = 50;
		scores[1][3] = 88;
		
		scores[2][0] = 98;
		scores[2][1] = 87;
		scores[2][2] = 67;
		scores[2][3] = 92 ;
	
		
		//4. 2차원 배열 요소 출력
		for (int i=0; i<scores.length;i++) //행 크기 만큼 반복
		{
			for(int j=0; j<scores[i].length;j++) 
			{
			//	System.out.print(scores[i][j]+"\t");
			}
//			System.out.println();
		}
		
		//반 별 총점과 평균 ex)1반 : 00 00 00 00 [총점 : 00, 평균 : 00]
		
		int sum = 0;
		
		for (int i=0; i<scores.length;i++) //행 크기 만큼 반복
		{
			sum = 0;
			System.out.print((i+1)+"반 "+"\t");
			
			for(int j=0; j<scores[i].length;j++) 
			{
				sum+=scores[i][j];
				System.out.print(scores[i][j]+"\t");
			}
			System.out.print("[총점:"+sum+", 평균 :"+sum/scores[i].length+"]");
			System.out.println();
		}
		
		
		
				
	}

}
