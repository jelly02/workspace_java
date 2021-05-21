package com.work.view;

public class GuGuDanTest {

	public static void main(String[] args) {
		
		int sum;
		
	//(1) for 구구단
//		for(int i=2; i<=9; i++)
//		{
//			for(int j=1; j<=9; j++)
//			{
//				sum =+ i*j;
//				System.out.println(i+"*"+j+"="+sum);
//			}
//		}

/*		<선생님 풀이>
		2~9 : 제목 행 출력 
		for(int dan = 2; dan <= 9; dan++)
		{
			System.out.print(dan +"단\t");
		}
		System.out.println();
		
		1~9 : 구구단 반복 출력 
		for (int step = 1; step<=9; step++)
		{
			for(int dan = 2; dan <= 9; dan++)
			{
				System.out.print(dan +"*"+step +"="+(dan * step)+"\t");
			}
			System.out.println();
		}
*/		
	//(2) while 구구단
//		int i = 2;
//		int j = 1;
//		while(i<=9)
//		{
//			j = 1; 
//			while(j<=9)
//			{
//				sum =+ i*j;
//				System.out.println(i+"*"+j+"="+sum);
//				j++;
//			}
//			i++;
//		}

/*		<선생님 풀이>
		int step = 1;
		int dan = 2;
		
		while(step <= 9)
		{
			dan = 2;
			while(dan<=9)
			{
				System.out.print(dan +"*"+step +"="+(dan * step)+"\t");
				dan++;
			}
			System.out.println();
			step++;
		}
		
*/			
	//(3) do~while 구문을 활용한 구구단
		
//		int i = 2;
//		int j = 1;
//		
//		do {	
//			
//			do
//			{
//				sum=i*j;
//				System.out.println(i+"*"+j+"="+sum);
//				j++;
//			}while(j<=9);
//			
//			i++;
//			j=1;
//		}while(i<=9);

/* 	<선생님 풀이>
		int step = 1;
		int dan = 2;
		
		do
		{
			dan = 2;
			do 
			{
				System.out.print(dan +"*"+step +"="+(dan * step)+"\t");
				dan++;
			}while(dan<=9);
			System.out.println();
			step++;
		}while(step <= 9);
*/		
		
		
//		(4) 짝수 구구단 구구단
//		for(int i=2; i<=9; i++)
//		{
//			if(i%2==0)
//			{
//				for(int j=1; j<=9; j++)
//				{
//					if(j%2==0)
//					{
//						sum =+ i*j;
//						System.out.println(i+"*"+j+"="+sum);
//					}
//				}
//			}
//			
//		}

/*		<선생님 풀이>
		2~9 : 제목 행 출력 
		for(int dan = 2; dan <= 9; dan++)
		{
			System.out.print(dan +"단\t");
		}
		System.out.println();
		
		1~9 : 구구단 반복 출력 
		for (int step = 1; step<=9; step++)
		{
			for(int dan = 2; dan <= 9; dan++)
			{
				if(dan%2==0)
				{
					System.out.print(dan +"*"+step +"="+(dan * step)+"\t");
				}
			}
			System.out.println();
		}
*/		
		
		
//		(5) 홀수스텝의 구구단
//		for(int i=2; i<=9; i++)
//		{
//				for(int j=1; j<=9; j++)
//				{
//					if(j%2!=0)
//					{
//						sum =+ i*j;
//						System.out.println(i+"*"+j+"="+sum);
//					}
//				}
//		}

//		1~9 : 구구단 반복 출력 
		for (int step = 1; step<=9; step++)
		{
			for(int dan = 2; dan <= 9; dan++)
			{
				if(dan%2==1)
				{
					System.out.print(dan +"*"+step +"="+(dan * step)+"\t");
				}
			}
			System.out.println();
		}
		


	}

}
