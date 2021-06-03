package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.work.model.dto.Member;

public class IOMemberTest {
	
	public static void main(String[] args) {
		
		while(true) {
			mainMenu();
			
			int menuNum = inputNumber();
			
			switch(menuNum) {
			
			case 1: 
				System.out.println("1. 로그인");
				loginMenu();
				break;
			case 2: 
				System.out.println("2. 회원가입");
				addMemberMenu();
				break;
			case 3: 
				System.out.println("3. 아이디찾기");
				break;
			case 4: 
				System.out.println("4. 비밀번호찾기");
				break;
			case 0: 
				System.out.println("프로그램종료");
				System.exit(0);;
				break;
				
				default : 
				
			}
		}
	}
	
	public static void printLine() {
		System.out.println("====================");
	}
	
	public static void printTitle(String title) {
		printLine();
		System.out.println(title);
		printLine();
	}
	
	public static void mainMenu() {
//		System.out.println("회원 관리 시스템 메인");
		
		printTitle("회원관리시스템 메인 메뉴");
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("0. 프로그램 종료");
		
		printLine();
		
		System.out.print("원하는 메뉴의 번호를 입력하세요 : ");
		
	}

	public static void addMemberMenu() {
		
		printTitle("회원관리시스템 메인 메뉴");
		
		System.out.println("아이디 : ");
		String memberId = inputString();
		
		System.out.println("비밀번호 : ");
		String memberPw = inputString();
		System.out.println("이름: ");
		String name = inputString();
		System.out.println("휴대폰 : ");
		String mobile = inputString();
		System.out.println("이메일 : ");
		String email = inputString();
		System.out.println("마일리지 : ");
		int mileage = inputNumber();
		
		Member dto = new Member(memberId, memberPw, name, mobile, email);
		dto.setMileage(mileage);
		
		System.out.println(dto);
		
	
/*		실습 (1) 호출
		System.out.print("아이디 : ");
//		String memberId = inputString();
		
		System.out.println("memberId : "+memberId);

		//실습 (2) 호출
		System.out.print("마일리지 : ");
//		int mileage = inputNumber();
*/
	}
	

	//실습(1) : 
	//객체 생성 없이 사용 가능한 메서드 
	//키보드로부터 읽은 데이터를 문자열로 반환하는 메서드
	public static String inputString() {
		
		String data = null;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data =  in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	//실습(2) : 
	//객체 생성 없이 사용 가능한 메서드 
	//키보드로부터 읽은 데이터를 int로 반환하는 메서드

	private static int inputNumber() {
		String data = null;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data =  in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(data);
	}
	
	//s
	private static String inputStringScanner() {
		Scanner in = new Scanner(System.in);
		
		return in.nextLine();
	}
	
	private static int inputNumberScanner() {
		Scanner in = new Scanner(System.in);
		
		return in.nextInt();
	}
	
	public static void loginMenu() {
		
		printTitle("로그인 메뉴");
		System.out.println("아이디 : ");
		String memberId = inputString();
		
		System.out.println("비밀번호 : ");
		String memberPw = inputString();
		
		//service login 요청 처리
	}
}
