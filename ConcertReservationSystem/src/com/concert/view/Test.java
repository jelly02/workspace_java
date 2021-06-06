package com.concert.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.concert.model.Member;
import com.concert.service.MemberService;


/**
 * 테스트 클래스 
 * 
 * @author KIMJURI
 *
 */


public class Test {
		

	public static void main(String[] args) {
		
		boolean outLoop1 = true;
		boolean outLoop2 = true;
		boolean outLoop3 = true;
		boolean outLoop4 = true;
		boolean outLoop5 = true;
	
		
		while(outLoop1) {
			
			mainMenu();
			
			int menuNum = inputNumber();
			
			switch(menuNum) {
			
			case 1: 
				System.out.println("1. 로그인");
				boolean result = loginMenu();
				
				if(result) {
					System.out.println("로그인 성공");
					
					while(outLoop2) 
					{
						memberMenu();
						
						int memNum = inputNumber();
						
						switch(memNum) {
						
							//공연 정보 조회 
							case 1 : 
								
									infoCheck(); 
									
									int backNum = inputNumber();
									
									if(backNum==0) {
										break;
									}else {
										System.out.println("[오류] 뒤로가려면 '0' 을 입력해주세요.");
									}
								
		
							//공연 예약	
							case 2 : 
		
									infoReservation();
									
									backNum = inputNumber();
									
									if(backNum==0) {
											break;
									}else {
										System.out.println("[오류] 뒤로가려면 '0' 을 입력해주세요.");
									}

							// 예약 조회	
							case 3 : 
								infoReservationList();
								System.out.println("예약 조회	"); 
								
							// 캐시 충전	
							case 4 : 
								addMoney();
								System.out.println("캐시 충전");
								
							// 캐시 조회 	
							case 5 : 
								checkMoney();
								System.out.println("캐시 조회 ");
							
							
						}	
					
					}
				} else {
					System.out.println("로그인 실패하였습니다. 메인 화면으로 돌아갑니다");
					mainMenu();
				}
				break;
			case 2: 
				System.out.println("2. 회원가입");
				addMemberMenu();
				break;

			case 3: 
				System.out.println("3. 프로그램 종료");
				System.exit(0);;
				break;
				
				default : 
				
			}
		}
	}

	/**
	 *  홈 메뉴  : 로그인 하지 않은 사용자도 볼 수 있는 메뉴
	 */
	private static void mainMenu() {
		
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
		
	}

	public static void printLine() {
		System.out.println("***********************");
	}
	
	public static void printSpace(String sub) {
		System.out.println("\t"+sub);
	}
	
	
	/**
	 * 로그인  화면
	 * @return true(성공) false(실패) 
	 */
	
	private static boolean loginMenu() {
		
		printLine();
		System.out.println(" \t\t로그인");
		System.out.println();
		
		System.out.print("아이디 : ");
		String memberId = inputString();
		
		System.out.print("비밀번호 : ");
		String memberPw = inputString();
		
		/*로그인 성공하면 true, 아니면 메인 메뉴를 보여줘야겠다 */
		
		return true;
		
	}
	
	/**
	 *  멤버 메뉴 : 로그인 성공 후 회원만 볼 수 있는 메뉴
	 * 
	 */
	private static void memberMenu() {
		printLine();

		printSpace("00 공연 관리 프로그램");
		printSpace(" user01 님 환영합니다!");
		System.out.println();
		
		printSpace("1. 공연 정보 조회 ");
		printSpace("2. 공연 예약");
		printSpace("3. 공연 예약 조회");
		printSpace("4. 캐시 충전");
		System.out.println();
		printLine();
		
	}

	/**
	 *  공연 정보 조회 화면 
	 */
	private static void infoCheck() {
		
		printLine();
		printSpace("\t < 공연 조회 >");
		System.out.println("* 현재 진행되고 있는 공연들 입니다! *");
		System.out.println("* 뒤로가기 : '0' 입력*");
		System.out.println();
		
		System.out.println("1. 뮤지컬 더 리퍼, 6/12, 19:30 ~ 22:00, 문채원, 송중기");
		System.out.println("2. 옥탑방 고양이,  6/19, 20:00 ~ 22:00, 남정은, 이경민");
		System.out.println("3. 피카츄의 대모험, 6/26, 19:30 ~ 21:30, 소니아, 금랑");
		System.out.println("4. 낫아웃, 7/3. 20:00 ~ 22:30, 송이재, 정재광");
		System.out.println("5. 행복, 7/10, 19:30 ~ 21:30 김단율, 정영성");
		
		System.out.println();
		
	}


	/**
	 *  공연 예약 화면 
	 */
	private static void infoReservation() {
		
		printLine();
		printSpace("\t < 1. 공연 예약  >");
		System.out.println("* 관람하실 공연의 숫자를 입력해주세요.*");
		System.out.println("* 뒤로가기 : '0' 입력*");
		System.out.println();
		
		System.out.println("1. 뮤지컬 더 리퍼, 6/12, 19:30 ~ 22:00, 문채원, 송중기");
		System.out.println("2. 옥탑방 고양이,  6/19, 20:00 ~ 22:00, 남정은, 이경민");
		System.out.println("3. 피카츄의 대모험, 6/26, 19:30 ~ 21:30, 소니아, 금랑");
		System.out.println("4. 낫아웃, 7/3. 20:00 ~ 22:30, 송이재, 정재광");
		System.out.println("5. 행복, 7/10, 19:30 ~ 21:30 김단율, 정영성");
		
		System.out.println();
		
	}

	/**
	 *  공연 예약 조회 화면
	 */
	private static void infoReservationList() {
		// TODO Auto-generated method stub
		
	}

	/**
	 *  캐시 충전 화면 
	 */

	private static void addMoney() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 *  캐시 조회 화면 
	 * 
	 */

	private static void checkMoney() {
		// TODO Auto-generated method stub
		
	}




	
	
	/**
	 * inputNumber() : 사용자 입력 내용을 가져오는 메서드
	 * 
	 * @return Integer.parseInt(data)
	 */
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

	private static void addMemberMenu() {
		
		MemberService service = new MemberService();
		
		printLine();
		System.out.println(" \t\t회원가입");
		System.out.println();
		
//		try {
//				System.out.println("아이디 : ");
//				String memberId = inputString();
//				
//				System.out.println("비밀번호 : ");
//				String memberPw = inputString();
//				
//				System.out.println("이름: ");
//				String name = inputString();
//				
//				System.out.println("휴대폰 : ");
//				String mobile = inputString();
//				
//				Member member = new Member(memberId, memberPw, name, mobile,"G",0);
//				
//				service.addMember(member);
//				
//				service.getMember();
//				
//				/*
//				 * 회원가입이 완료 되었습니다! 메인으로 이동합니다.
//				 * */
//				
//		}catch(Exception e){
//			e.getStackTrace();
//		}
		
	}
	
	/**
	 *  키보드로부터 읽은 데이터를 문자열로 반환하는 메서드
	 * @return
	 */

	private static String inputString() {
		
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



	
	
}
