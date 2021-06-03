package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardTest {

	public static void main(String[] args) {
		System.out.println("키보드에서 영문자/한글 1글자 입력하세요 [종료 : ctrl+Z] ");
		
		//영문자로 변환 
		try {
//			int input = System.in.read(); ? byte 단위 읽기 / 한글 깨짐
			
/*			character 단위 읽기(16bit, 2byte씩)
			InputStreamReader in = new InputStreamReader(System.in);
			
			int input = in.read();
			System.out.println("입력데이터 : "+input+">ㅈ"+(char)input );
*/			
			//String 라인 단위 읽기																키보드 입력 값 받기
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine(); //> 반환타입 String / New Integer or Integer.parseInt
			
			System.out.println("입력데이터 : "+input ); // 계속 입력받고 싶으면 while문으로 돌리기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
