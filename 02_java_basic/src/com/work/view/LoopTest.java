package com.work.view;

public class LoopTest {


	public static void main(String[] args) 
	{
		int i = 1;
		int sum;
//		while(i<=5)
//		{
//			System.out.println(i);
//			i++;
//		}
		
		sum = 0;
		i = 1;
		do 
		{
			 System.out.println(i);
			 i++;
		}while(i <= 5);
		
	}
	
	
	
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
//		int sum=0;
//		
//		for(int i = 1; i <= 10; i++)
//		{
//			System.out.println(i);
//			sum += i;
//		}
//
//		System.out.println(sum);
//	
		
		int sum=0;
		
		for(int i = 1; i <= 10; i++)
		{
			if(i%2==0)
			{
				sum += i;
				System.out.println(i);
			}
			
		}

		System.out.println(sum);

	}
	public static void main2(String[] args) {
		
//		for(int i=65; i<=90; i++) 
//		{
//			System.out.println((char)i+":" + i);
//		}
		
		for(int i='A'; i<='Z';i++)
		{
			System.out.println((char)i +":" +i);
		}
		
		
		
	}
}
