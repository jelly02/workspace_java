package com.concert.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.concert.service.MemberService;

public class Menu {

	/** 회원관리 서비스 클래스 */
	MemberService service = new MemberService();
	
	
	/** 메인 화면 */
	public void mainMenu() {
		
		printLine();
		System.out.println(" \t00 공연 관리 프로그램");
		System.out.println();
		
		printSpace("1. 로그인");
		printSpace("2. 회원가입");
		printSpace("3. 프로그램 종료");
		printSpace("0. 관리자 메뉴");
	
		System.out.println();
		printLine();
		
		System.out.print("원하는 메뉴의 번호를 입력하세요 : ");
		int menuNo = inputNumber();
		
		switch(menuNo) {
		
		case 1:
			System.out.println("1. 로그인");
			loginMenu();
			break;
		case 2:
			System.out.println("2. 회원가입");
			addMemberMenu();
			break;
		case 3:
			System.out.println("3. 프로그램 종료");
			System.exit(0);;
			break;
		default:
			System.out.println("[오류] 화면에 표시된 숫자만 입력해주세요.");
			break;	
		
		}
		
	}

	/**
	 *  로그인 
	 */

	private void loginMenu() {

			
		printLine();
		System.out.println(" \t\t로그인");
		System.out.println();
				
		System.out.print("아이디 : ");
		String memberId = inputString();
				
		System.out.print("비밀번호 : ");
		String memberPw = inputString();
				
		boolean result = service.login(memberId, memberPw);
		
		
		if(result) {
			System.out.println();
			System.out.println("[안내] 로그인 성공! "+memberId+"님 환영합니다!");
			System.out.println();
			memberMenu();
			
		}else if(result == false){
			System.out.println("[오류] 입력한 정보와 맞는 회원이 없습니다. 다시 시도해주세요.");
			mainMenu();
		}	
	}
	
	/**
	 *  회원 가입
	 */
	private void addMemberMenu() {
		
		printLine();
		System.out.println(" \t\t회원가입");
		System.out.println();
		
		System.out.println("아이디 : ");
		String memberId = inputString();
		
		System.out.println("비밀번호 : ");
		String memberPw = inputString();
		
		System.out.println("이름: ");
		String name = inputString();
		
		System.out.println("휴대폰 : ");
		String mobile = inputString();
		
		boolean result = service.addMember(memberId, memberPw, name, mobile);

		if(result) {
			mainMenu();
		}else {
			mainMenu();
		}
		
	}

	private void memberMenu() {
		printLine();

		printSpace("00 공연 관리 프로그램");
		System.out.println();
		
		printSpace("1. 공연 정보 조회 ");
		printSpace("2. 공연 예약");
		printSpace("3. 공연 예약 조회");
		printSpace("4. 캐시 충전");
		printSpace("0. 로그아웃");
		System.out.println();
		printLine(); 
		
		int menuNo = inputNumber();
		
		switch(menuNo) {
		
		//공연 정보 조회
		case 1:
			infoCheck(); 
			break;
		
		//공연 예약
		case 2:
			infoReservation();
			break;
		
		
		//예약한 공연 조회
		case 3:
			infoReservationList();
			break;
			
		//캐시 충전	
		case 4:
			checkMoney();
			break;
			
		case 0:
			System.out.println("[안내] 이용해주셔서 감사합니다.");
			mainMenu();
			break;
		
		default:
			System.out.println("[오류] 화면에 표시된 숫자만 입력해주세요.");
			break;
		}
		
	}
	
	private void checkMoney() {
		// TODO Auto-generated method stub
		
	}

	private void infoReservationList() {
		// TODO Auto-generated method stub
		
	}

	private void infoReservation() {
	
		printLine();
		printSpace("\t< 2. 공연 예약  >");
		System.out.println("* 관람하실 공연의 숫자를 입력해주세요.*");
		System.out.println("* 뒤로가기 : '0' 입력*");
		System.out.println();
		
		//공연 정보 가져오기 
		service.getPlayPrint();
		
		int menuNo = inputNumber();
		
		if(menuNo == 0) {
			memberMenu();
		}else {
			service.reservation(menuNo);
		}
		
		
		
		
	}

	/**
	 *  공연 정보 조회 화면 
	 */
	private  void infoCheck() {
		
		printLine();
		printSpace("\t < 공연 조회 >");
		System.out.println("* 현재 진행되고 있는 공연들 입니다! *");
		System.out.println("* 뒤로가기 : '0' 입력*");
		System.out.println();

	
		service.getPlayPrint();
		
		int menuNo = inputNumber();
		
		if(menuNo == 0) {
			memberMenu();
		}else {
			System.out.println("[안내] 뒤로가기를 하려면 '0'을 입력하셔야 합니다.");
		}
		
		System.out.println();
		
		
		/**
		 * 사용자가 좌석 선택 배열 보여주고
		 * 배열 선택하고
		 * 저장하고 
		 * 멤버 메뉴로 나가고 
		 */
		
	}
	public  void printLine() {
		System.out.println("***********************");
	}
	
	public  void printSpace(String sub) {
		System.out.println("\t"+sub);
	}
	
	/**
	 * 문자열 입력 반환
	 * @return 입력 문자열
	 */
	public String inputString() {
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 숫자 입력 반환
	 * @return 입력 정수형 숫자
	 */
	public int inputNumber() {
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(data);
	}

}
