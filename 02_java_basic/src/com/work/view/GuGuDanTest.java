package com.work.view;

public class GuGuDanTest {

	public static void main(String[] args) {
		
		int sum;
		
	//(1) for 구구단
		for(int i=2; i<=9; i++)
		{
			for(int j=1; j<=9; j++)
			{
				sum =+ i*j;
				System.out.println(i+"*"+j+"="+sum);
			}
		}
		
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
		
	//(4) 짝수 구구단 구구단
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
//		
//	//(5) 홀수스텝의 구구단
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
		


	}

}
