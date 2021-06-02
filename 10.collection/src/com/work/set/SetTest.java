package com.work.set;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class SetTest {
	
	public static void main(String[] args) {
		
		//Generic : Member 전용 Collection
		HashSet<Member> set = new HashSet<Member>();
		
		// 회원들을 저장하기 위한 자료 저장 구조로 HashSet 사용
		System.out.println("======================");
				
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user01", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	
		//등록 : add(Object) - Member 가 아닌 경우 저장할 수 없어 >  boolean
		System.out.println(set.add(dto1));  //true
		System.out.println(set.add(dto2));  //false
		System.out.println(set.add(dto3));  //true
		System.out.println(set.add(dto4));  //true
		System.out.println(set.add(dto5));  //true 
				
		System.out.println("======================");
		
		System.out.println("저장 갯수 : "+set.size());
		
		System.out.println("=========조회===========");
		
		//전체 조회
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Member obj = (Member)iterator.next();
			System.out.println(obj);
		}
		
		System.out.println("=======아이디 조회========");
		 iterator = set.iterator();
		 
		 while(iterator.hasNext()) {
			 Member dto = (Member) iterator.next();
			 
			 if(dto.getMemberId().equals("user01")) {
				 System.out.println(dto);
				 break;
			 }
		 }
		
		System.out.println("=========삭제==========");
		//user04 삭제
		
		 iterator = set.iterator(); 
			
			while(iterator.hasNext()) {// iterator에 담겨있는 만큼!

				 Member dto = (Member) iterator.next();
				 
					if(dto.getMemberId().equals("user04")) {
						//동일한 객체를 찾아냈는데도 while문은 계속 반복 되니까
						set.remove(dto);
						System.out.println(dto.getMemberId()+"성공적으로 삭제 되었습니다!");
						break;
					}
				}
			
			System.out.println("=========조회===========");
			//전체 조회
			iterator = set.iterator();
			
			while(iterator.hasNext()) {
				Member obj = (Member)iterator.next();
				System.out.println(obj);
			}
			System.out.println("======================");
			


	}

	public static void main1(String[] args) {
		//collection Set : 순서 없음 + 중복 불가
		
		HashSet set = new HashSet();
		
		// 회원들을 저장하기 위한 자료 저장 구조로 HashSet 사용
		System.out.println("======================");
				
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user01", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	
		//등록 : add(Object) : boolean
		System.out.println(set.add("hello")); //true
		System.out.println(set.add("hello")); //false
		System.out.println(set.add("hello")); //false
		System.out.println(set.add("hello"));  //false
		System.out.println(set.add("hello"));  //false
				
		System.out.println(set.add(1004)); // true int > Integer 객체로 자동 형변환
		System.out.println(set.add(new Integer(1004))); // false Integer 객체로 아예 처음부터 지정해버림
				
		System.out.println(set.add(dto1));  //true
		System.out.println(set.add(dto2));  //false
		System.out.println(set.add(dto3));  //true
		System.out.println(set.add(dto4));  //true
		System.out.println(set.add(dto5));  //true 
				
		System.out.println(set.add(new Date())); // true > 날짜 객체 없음
		System.out.println("======================");
		
		System.out.println("저장 갯수 : "+set.size());
		
		System.out.println("=========조회===========");
		
		//전체 조회
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {// iterator에 담겨있는 만큼!
			//커서 옮겨가면서 출력
			System.out.println(iterator.next());
		}
		System.out.println("======================");
		
		
		System.out.println("=======아이디 조회========");
		
		 iterator = set.iterator(); //다시 iterator를 받아서 돌아야 되니까! > 왜냐면 위에서 끝까지 다 돌았기 때문에!
		
			while(iterator.hasNext()) {// iterator에 담겨있는 만큼!
				Object obj = iterator.next();
				
				if(obj instanceof Member) {
					Member dto = (Member) obj;
					
					if(dto.getMemberId().equals("user01")) {
						//동일한 객체를 찾아냈는데도 while문은 계속 반복 되니까
						System.out.println(dto);
						break;
					}
				}
			}
		System.out.println("======================");
		
		System.out.println("=========삭제==========");
		//user04 삭제
		
		 iterator = set.iterator(); //다시 iterator를 받아서 돌아야 되니까! > 왜냐면 위에서 끝까지 다 돌았기 때문에!
			
			while(iterator.hasNext()) {// iterator에 담겨있는 만큼!
				Object obj = iterator.next();
				
				if(obj instanceof Member) {
					Member dto = (Member) obj;
					if(dto.getMemberId().equals("user04")) {
						//동일한 객체를 찾아냈는데도 while문은 계속 반복 되니까
						set.remove(dto);
						System.out.println(dto.getMemberId()+"성공적으로 삭제 되었습니다!");
						break;
					}
				}
			}
			System.out.println("======================");
			
			//전체 조회
			 iterator = set.iterator();
			
			while(iterator.hasNext()) {// iterator에 담겨있는 만큼!
				//커서 옮겨가면서 출력
				System.out.println(iterator.next());
			}
	}
}
