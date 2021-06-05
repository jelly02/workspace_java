package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.work.exception.CommonException;
import com.work.exception.DuplicateException;
import com.work.exception.RecordNotFoundException;
import com.work.model.dto.Member;
import com.work.model.service.MemberService;

/**
 * <pre>
 * 회원관리시스템 메뉴 구성
 * </pre>
 *  
 * @author 임경혜
 * @version ver.1.0
 * @since jdk1.8
 */
public class MemberMenu {
	/** 회원관리 서비스 클래스 */
	public MemberService service = new MemberService();
	
	public void mainMenu() {
		printTitle("회원관리시스템 메인메뉴");
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("0. 프로그램 종료");
		printLine();
		
		System.out.print("메뉴번호 입력 : ");
		int menuNo = inputNumber();
		
		switch(menuNo) {
		case 1:
			loginMenu();
			break;
		case 2:
			addMemberMenu();
			break;
		case 3:
			System.out.println("3. 아이디찾기");
			break;
		case 4:
			System.out.println("4. 비밀번호찾기");
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("메뉴번호 오류");
			break;
		}
		
	}
	
	/**
	 * 회원정보 파일 가져와서 회원자료저장구조 메모리에 저장하기
	 * 프로그램 실행시에 기존에 저장된 회원들의 정보를 메모리에 가져와서 기존 정보를 활용하기 위한 처리가 필요로 합니다.
	 */
	public void loadMemberDataFile() {
		
	}
	
	/**
	 * <pre>
	 * 회원자료저장구조 메모리에 있는 회원정보 파일에 저장하기
	 * 메모리에 저장된 자료는 프로그램이 종료되면 휘발성이므로 모두 사라지게 됩니다.
	 * 따라서 파일, 데이터베이스 등을 이용하여 영속적으로 저장해서 활용하기위한 처리가 필요로 합니다.
	 * </pre>
	 */
	public void saveMemberDataFile() {
		
	}
	
	/**
	 * 프로그램 서비스전에 초기화 작업 위한 메뉴 
	 */
	public void initMenu() {
		// 초기화 회원 등록 
		int count = 0;
		try {
			count = service.initMember();
			
		} catch (DuplicateException e) {
			print("[실패] " + e.getMessage());		
		}
		print("[회원 초기화 작업이 완료되었습니다. 현재 등록 회원수 (" + count + ")명]");
		
		// 프로그램 서비스전에 기존 회원정보 파일가져와서 회원관리저장구조 메모리에 저장하기
		// loadMemberDataFile();

	}
	
	
	/** 프로그램 종료 메뉴 */
	public void exitMenu() {
		// 프로그램 종료전에 회원정보 파일 저장
		// saveMemberDataFile();
		
		printTitle("회원관리 프로그램 정상 종료");
		System.exit(0);
	}

	/** 회원 가입 메뉴 */
	public void addMemberMenu() {
		printTitle("회원 가입 메뉴");
		
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();

		System.out.print("이름 : ");
		String name = inputString();

		System.out.print("휴대폰 : ");
		String mobile = inputString();

		System.out.print("이메일 : ");
		String email = inputString();
		
		Member dto = new Member(memberId, memberPw, name, mobile, email);
		try {
			// 회원 가입은 성공처리되나 로그인시에 오류가 발생됨 : 이유를 찾아보세요??
			// service.addMember(dto);
			
			service.addMember(memberId, memberPw, name, mobile, email);
			
			print("[성공] " + memberId + "님 회원등록 완료되었습니다. 로그인 후 회원전용 서비스를 이용하시기 바랍니다.");
			loginMenu();
		} catch (DuplicateException e) {
			print("[실패] " + e.getMessage());
			mainMenu();
		}
	}
	
	/**
	 * 메세지 출력
	 * @param message 메세지
	 */
	public void print(String message) {
		System.out.println(message);
	}
	
	/**
	 * 로그인 메뉴
	 */
	public void loginMenu() {
		printTitle("로그인 메뉴");
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();

		try {
			String grade = service.login2(memberId, memberPw);
			print("[로그인성공] " + memberId + "님 (등급: " + grade + ")");
			switch(grade) {
			case "G":
			case "S":
				serviceMainMenu();
				break;
			case "A":
				adminMainMenu();
				break;
			}
		} catch (RecordNotFoundException e) {
			print("[실패] " + e.getMessage());
			mainMenu();
		} catch (CommonException e) {
			print("[실패] " + e.getMessage());
			mainMenu();
		}
	}	
	
	/**
	 * 회원 전용 서비스 메인메뉴
	 */
	private void serviceMainMenu() {
		printTitle("회원전용 서비스 메뉴");
		
		System.out.println("1. 내정보조회");
		System.out.println("2. 내정보변경");
		System.out.println("3. 비밀번호변경");
		System.out.println("9. 로그아웃");
		System.out.println("0. 프로그램 종료");
		printLine();
		System.out.print("메뉴번호 입력 : ");
		
		int menuNo = inputNumber();
		
		switch(menuNo) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 9:
			print("[로그아웃 성공] 서비스를 이용하시려면 로그인하시기 바랍니다.");
			mainMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("메뉴번호 오류");
			break;
		}
	}

	private void adminMainMenu() {
		printTitle("관리자 서비스 메인메뉴");
		
		System.out.println("1. 내정보조회");
		System.out.println("2. 내정보변경");
		System.out.println("3. 비밀번호변경");
		System.out.println("4. 회원관리[전체회원조회]");
		System.out.println("9. 로그아웃");
		System.out.println("0. 프로그램 종료");
		printLine();
		System.out.print("메뉴번호 입력 : ");
		
		int menuNo = inputNumber();
		
		switch(menuNo) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 9:
			mainMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("메뉴번호 오류");
			break;
		}	}

	
	/**
	 * 구분선 출력
	 */
	public void printLine() {
		System.out.println("-------------------------");
	}
	
	/**
	 * 제목 출력
	 * @param title 제목
	 */
	public void printTitle(String title) {
		System.out.println();
		printLine();
		System.out.println(title);
		printLine();
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
