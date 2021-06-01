package com.work.list;

import java.util.ArrayList;
import java.util.Date;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class ListTest {

	public static void main(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	
		// 회원들을 저장하기 위한 자료 저장 구조로 List 사용
		ArrayList list = new ArrayList();
		System.out.println("======================");
		
		//등록 : add(Object) : boolean
		System.out.println(list.add("hello"));
		System.out.println(list.add("hello"));
		System.out.println(list.add("hello"));
		System.out.println(list.add("hello"));
		System.out.println(list.add("hello"));
		
		System.out.println(list.add(1004)); //Integer 객체로 자동 형변환
		System.out.println(list.add(new Integer(1004))); //Integer 객체로 아예 처음부터 지정해버림
		
		System.out.println(list.add(dto1));
		System.out.println(list.add(dto2));
		System.out.println(list.add(dto3));
		System.out.println(list.add(dto4));
		System.out.println(list.add(dto5));
		
		System.out.println(list.add(new Date()));
		System.out.println("======================");
		//저장크기 : size() : int
		System.out.println("size : "+list.size());
		System.out.println("======================");
		
		
		//전체 조회 : list.size() 만큼 돌린다
		for(int index = 0; index<list.size(); index++) {
			System.out.println("["+index+"] : "+list.get(index));
		}
		System.out.println("======================");	
		
		//조회 : 7번쨰 요소 저장 객체
		Object obj = list.get(7);
		
		//변경 : 1번째 요소의 객체를 임의의 정보로 변경
		obj = list.set(1, dto5);
		System.out.println("**변경 전 첫번째 요소 객체 : "+obj);
		System.out.println("**변경 후 첫번째 요소 객체 : "+list.get(1));
		System.out.println("======================");
		//obj 출력 > 부모 타입으로 하게 되면 가장 맨 마지막으로 재정의 해놓은 메서드로 출력 = General Member
		System.out.println(obj);
		
		//삭제 : 5,6,7번째 요소
		list.remove(5);
		list.remove(6);
		list.remove(7);
		System.out.println("======================");
		
	}

}
