package com.concert.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.concert.model.Info;
import com.concert.model.Member;
//import com.work.exception.CommonException;
import com.concert.model.Reservation;
import  com.concert.view.MainMenu;

/**
 * 서비스 클래스 
 * 
 * @author KIMJURI
 *
 */


public class MemberService {
	
	/** 예약 도메인 클래스 */
	public Reservation res = new Reservation();

	
	
	/**  회원들을 저장하기 위한 자료 저장 구조 */
	public ArrayList<Member> list = new ArrayList<Member>();
	/** 공연 정보 저장 리스트 */
	public ArrayList<Info> play = new ArrayList<Info>();
	
	/** 공연 좌석  */
	String[] vipSeat = new String[]{"1","2","3","4","5","6","7","8","9","10"} ;
	String[] sSeat = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
	String[] rSeat = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	
	/** 예약 정보 저장 */
	public ArrayList<Reservation> reservation = new ArrayList<Reservation> ();
	
	
	
	/** 기본 생성자 */
	public MemberService() {	
		
		// 회원 초기화 
		list.add(new  Member("admin","admin1234","관리자","01082828282","A",0));
		list.add(new  Member("user01","user01","김주리","01011111111","A",0));
		
		//공연 정보 저장 		
		play.add(new Info("play1", "뮤지컬 더 리퍼", "6/12", "19:30 ~ 22:00", "문채원", "송중기"));
		play.add(new Info("play2", "옥탑방 고양이", "6/19", "20:00 ~ 22:00", "남정은", "이경민"));
		play.add(new Info("play3", "피카츄의 대모험", "6/26", "19:30 ~ 21:30", "소니아", "금랑"));
		play.add(new Info("play4", "낫아웃", "7/3", "20:00 ~ 22:30", "송이재", "정재광"));
		play.add(new Info("play5", "행복", "7/10", "19:30 ~ 21:30", "김단율", "정영성"));

	//	refresh();
		}
		
	
	
	/** 현재 등록한 전체 회원 조회 */
	public ArrayList<Member> getMember() {
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
	
	
	/**
	 * 로그인
	 * @param memberId
	 * @param memberPw
	 * @return 성공시 true, 실패시 false
	 * @throws CommonException 
	 */
	public boolean login(String memberId, String memberPw)  {
		
		int exist = exist(memberId);
		Member dto = getMember(memberId);
		
		if (exist != -1 && dto.getMemberPw().equals(memberPw)  ) {
			return true;
		}else {
			return false;
		}
		
	}
	

	/**
	 * 회원 존재 유무 조회 메서드
	 * @param memberId 아이디
	 * @return 존재 시 저장 위치 인덱스 번호, 미존재시 -1
	 */
	private int exist(String memberId) {

		for (int index = 0; index < list.size(); index++) {
			if(list.get(index).getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;
	}
	
	
	/**
	 *  회원 등록 메서드
	 * @param member
	 */
	public boolean addMember(String memberId, String memberPw, String name, String mobile) {
			
		int index = exist(memberId);
		
		if(index >= 0 ) {
			System.out.println("[오류] 해당 아이디는 이미 존재하는 아이디 입니다.");
			System.out.println("[오류] 회원가입이 정상적으로 처리 되지 않았습니다.");
			
			return false;
		}else {
			list.add(new Member(memberId, memberPw, name, mobile,"G",0));
			System.out.println("[안내] : "+name+"님의 회원 가입이 정상적으로 처리 됐습니다.");
			System.out.println();
			return true;
		}
		
	}	
	/**
	 * 회원 상세조회
	 * @param memberId 회원아이디
	 * @return 존재하면 회원객체, 미존재 null
	 * @throws RecordNotFoundException 
	 * @see exist(String)
	 */
	public Member getMember(String memberId){
		int index = exist(memberId);
		if (index >= 0) {
			return (Member)list.get(index);
		}
		
		return null;
	}

	/**
	 *  공연 정보 조회
	 */
	public ArrayList<Info> getPlayPrint() {
		
		for(int i=0; i<play.size(); i++) {
			System.out.print((i)+1+" : ");
			System.out.print(play.get(i).getInfoName() +" / ");
			System.out.print(play.get(i).getInfoDate()+" / ");
			System.out.print(play.get(i).getInfoTime()+" / ");
			System.out.print(play.get(i).getInfoFemaleActor()+" / ");
			System.out.print(play.get(i).getInfoMaleActor()+" / ");
			
			System.out.println();
		}
		
		return play;
	}
	
	/**
	 *  공연 예약 하기 
	 *  
	 */
	
	public boolean reservation(int playNum) {
		
		String editCode = "play"+playNum;
		
		int index = playExist(editCode);
		
		//해당 공연이 존재하면 
		if(index>= 0) {
			 seatReservation(editCode);
			 
			 return true;
		}else {
			//사용자가 딴 값을 입력하면 
			System.out.println("[오류] 해당 번호의 공연은 존재하지 않습니다. 화면에 나와있는 공연 숫자를 적어주세요");
			return false;
		}
	
		
	}


	/**
	 * 공연 존재 유무 조회 메서드
	 * @param memberId 아이디
	 * @return 존재 시 저장 위치 인덱스 번호, 미존재시 -1
	 */
	public int playExist(String editCode) {
	
		for (int index = 0; index < play.size(); index++) {
			if(play.get(index).getInfoCode().equals(editCode)) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 *  공연 좌석 전체 출력 메소드
	 */
	
	public void seatReservation(String editCode) {
		
			System.out.print("VIP석 : ");
				for(int i=0; i<vipSeat.length; i++) {
		            System.out.print("[ "+vipSeat[i] + " ]");
		        }
				System.out.println();
			
			System.out.print("S석 : ");
				for(int i=0; i<sSeat.length; i++) {
		            System.out.print("[ "+sSeat[i]+ " ]");
		        }
				System.out.println();
			System.out.print("R석 : ");
				for(int i=0; i<rSeat.length; i++) {
		            System.out.print("[ "+rSeat[i]+ " ]");  
				}
				System.out.println();
	}
	
	/**
	 *  사용자가 원하는 좌석만 보여주는 메서드 
	 */
	
	public boolean userSeatChoice(int type) {
		
		switch(type) {
		
			case 1 : System.out.print("VIP석 : ");
				for(int i=0; i<vipSeat.length; i++) {
		            System.out.print("[ "+ vipSeat[i] + " ]");
		        }
				System.out.println();
				return true;
			
			case 2 : System.out.print("S석 : ");
				for(int i=0; i<sSeat.length; i++) {
		            System.out.print("[ "+sSeat[i] + " ]");
		        }
				System.out.println();
				return true;
				
			case 3 :System.out.print("R석 : ");
				for(int i=0; i<rSeat.length; i++) {
		            System.out.print("[ "+rSeat[i]+ " ]");  
				}
				System.out.println();
				return true;
			
			default : 
				//1~3 사이의 숫자 입력 안했을 경우
                System.out.println("[오류] 잘못 입력하였습니다. 다시 입력해주세요.");
                return false;
		}
}
	
	/**
	 *  좌석 예약
	 */
	
	public boolean userSeatChoice(int playCode, int type, int seatChoice, String memberId ) {
		
		String modifyCode = "play"+ playCode;
		String seat = "";
		

		if(type == 1) {
			seat = "VIP석";
		}else if(type == 2 ) {
			seat = "S석";
		}else {
			seat = "R석";
		}
		//System.out.println("userSeatChoice 리스트에 넣기 전 "+modifyCode+seat+seatChoice+memberId );
		
		try {
			switch(type) {
			
				case 1 :
						
						vipSeat[seatChoice-1] = "X";
						reservation.add(new Reservation(memberId, modifyCode, seat, seatChoice));
						System.out.println("[안내] 좌석 예약을 완료했습니다. 즐거운 관람 되시길 바랍니다!");
						System.out.println();
						//getReservationList();
						return true;
						
				case 2 : 
					
						sSeat[seatChoice-1] = "X";
						reservation.add(new Reservation(memberId, modifyCode, seat, seatChoice));
						System.out.println("[안내] 좌석 예약을 완료했습니다. 즐거운 관람 되시길 바랍니다!");
						System.out.println();
						getReservationList();
						return true;
					
				case 3 :
						rSeat[seatChoice-1] = "X";
						reservation.add(new Reservation(memberId, modifyCode, seat, seatChoice));
						System.out.println("[안내] 좌석 예약을 완료했습니다. 즐거운 관람 되시길 바랍니다!");
						System.out.println();

						getReservationList();
						return true;
			}
		}catch (Exception e) {
			System.out.println("[오류] 정확한 좌석 번호를 다시 입력해주세요.");
		}
		
		
		
		
		return false;
		
	}
	
		/**
		 *  공연 정보 조회
		 */
		public void getReservationList() {
		
			if(reservation.isEmpty()) {
				System.out.println("[오류] 현재 예약된 내역이 없습니다.");
			}else {
				for (int i = 0; i < reservation.size(); i++) {
					
					System.out.print((i+1)+" . ");
					if(reservation.get(i).getInfoCode().equals("play1")) {
						System.out.print("뮤지컬 더 리퍼 |");
					}else if(reservation.get(i).getInfoCode().equals("play2")) {
						System.out.print("옥탑방 고양이 |");
					}else if(reservation.get(i).getInfoCode().equals("play3")) {
						System.out.print( "피카츄의 대모험 |");
					}else if(reservation.get(i).getInfoCode().equals("play4")) {
						System.out.print("낫아웃 |");
					}else if(reservation.get(i).getInfoCode().equals("play5")) {
						System.out.print("행복 |");
					}
					
					if(reservation.get(i).getSeat().equals("1")) {
						System.out.print(" 좌석 : VIP석  |");
					}else if(reservation.get(i).getSeat().equals("2")) {
						System.out.print(" 좌석 : S석  |");
					}else {
						System.out.print(" 좌석 : A석  |");
					}
					
					System.out.print(" 좌석 번호 : "+reservation.get(i).getSeatNum()+"번");
					System.out.println();
				}
			
			}
	}
	

	
	
}
