package com.work.view;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileInputOutputTest {

	public static void main(String[] args) {
		// 키보드 입력 = > 파일("test.txt") 출력
		
		//키보드 입력 스트림 : 라인 단위
		BufferedReader in = null;
		
		//라인 단위 출력 : 파일
		PrintWriter out = null;
		
		System.out.println("멋진 자기소개를 부탁합니다!  [종료 : ctrl+Z]");
		
		//파일("test.txt") 출력 : 라인 단위
		try {
			 in = new BufferedReader(new InputStreamReader(System.in));
			 																//내용이 계속 누적되어 저장
			 out = new PrintWriter(new FileWriter("test2.txt", true)); //append false : default
			 String data = null;
			 
			 //data가 읽어올 게 없을 때 까지
			 while((data = in.readLine()) != null) {
				 out.println(data);
			 }
			 
			 System.out.println("파일이 저장되었습니다!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//stream 닫아주기
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.close();
		}
	}

}
