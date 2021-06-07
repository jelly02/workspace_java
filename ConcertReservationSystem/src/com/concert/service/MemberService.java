package com.concert.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.concert.model.Info;
import com.concert.model.Member;
//import com.work.exception.CommonException;


/**
 * 서비스 클래스 
 * 
 * @author KIMJURI
 *
 */


public class MemberService {
	
	/**  회원들을 저장하기 위한 자료 저장 구조 */
	private ArrayList<Member> list = new ArrayList<Member>();
	/** 공연 정보 저장 리스트 */
	private ArrayList<Info> play = new ArrayList<Info>();
	
	/** 공연 좌석  */
	String[] vipSeat = new String[10];
	String[] sSeat = new String[15];
	String[] rSeat = new String[20];
	
	
	/** 기본 생성자 */
	public MemberService() {	
		
		// 회원 초기화 
		list.add(new  Member("admin","admin1234","관리자","01082828282","A",0));
		list.add(new  Member("user01","user01","김주리","01011111111","A",0));
		
		//공연 정보 저장 		
		play.add(new Info("play_1", "뮤지컬 더 리퍼", "6/12", "19:30 ~ 22:00", "문채원", "송중기"));
		play.add(new Info("play_2", "옥탑방 고양이", "6/19", "20:00 ~ 22:00", "남정은", "이경민"));
		play.add(new Info("play_3", "피카츄의 대모험", "6/26", "19:30 ~ 21:30", "소니아", "금랑"));
		play.add(new Info("play_4", "낫아웃", "7/3", "20:00 ~ 22:30", "송이재", "정재광"));
		play.add(new Info("play_5", "행복", "7/10", "19:30 ~ 21:30", "김단율", "정영성"));
		
		//공연 좌석 초기화
		int i = 0;
		
		while(i < 20) {
			
			if(i < 10) {
				vipSeat[i] = "□";		
			}
			
			if(i < 15) {
				sSeat[i] = "□";		
			}
			rSeat[i] = "□";
		}
		
		
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
		
		String editCode = "play_"+playNum;
		
		int index = playExist(editCode);
		
		//해당 공연이 존재하면 
		if(index>= 0) {
			 seatReservation(index);
			 
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
	private int playExist(String editCode) {
	
		for (int index = 0; index < play.size(); index++) {
			if(play.get(index).getInfoCode().equals(editCode)) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 *  사용자 선택 공연 좌석 메소드
	 */
	
	

	private void seatReservation(int index) {
		
		System.out.print("VIP석 : ");
		for(int i=0; i<vipSeat.length; i++) {
            System.out.print(vipSeat[i] + " ");
        }
		
		System.out.print("S석 : ");
		for(int i=0; i<sSeat.length; i++) {
            System.out.print(sSeat[i] + " ");
        }
		
		System.out.print("R석 : ");
		for(int i=0; i<rSeat.length; i++) {
            System.out.print(rSeat[i] + " ");
        }
		
		
		
	}
}
