package com.work.view;

import java.util.Random;

public class Lotto {


	public static void main(String[] args) {
		int lotto[] = new int [7];
		
		for(int i=0; i<lotto.length; i++)
		{
			//random은 실수라서 int로 형변환하여 정수로 만들고, 0부터 시작이니까 +1해서 1부터 시작, 그리고 45까지니까 45를 곱한다
			lotto[i] = (int)(Math.random()*45)+1;
			
			for(int j=0; j<i; j++)
			{
				if(lotto[j]==lotto[i])
				{
					i--;
					break;
				}
			}
		}
				
		System.out.print("이번 주 로또 번호 >> ");
		
		for(int i=0;  i < lotto.length; i++) 
		{
			System.out.print(lotto[i]+" ");
		}
	}
}


