package com.work.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class MapTest {

	public static void main(String[] args) {
		// 회원들을 저장 관리하기 위한 HashMap<K,V>
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");

		
		//회원 식별 속성 : 아이디 > Map의 Key(데이터 타입은 문자열), 저장하는 객체는 Member예요!
		HashMap<String, Member> map = new HashMap<String, Member>();
		
		print("등록");
		
		map.put(dto1.getMemberId(), dto1);
		map.put(dto2.getMemberId(), dto2);
		map.put(dto3.getMemberId(), dto3);
		map.put(dto4.getMemberId(), dto4);
		map.put(dto5.getMemberId(), dto5);

		print("등록된 객체의 수 : "+map.size());
		
		print("조회 : user01");
		System.out.println(map.get(dto1.getMemberId()));
		
		print("변경 : user01");
		dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01_new@work.com", "2020-12-15", "G", 50000);
		map.replace(dto1.getMemberId(),dto1);
		
		print("변경 후 조회 : user01");
		System.out.println(map.get(dto1.getMemberId()));
		
		print("삭제 : user02");
		System.out.println("삭제 확인 : "+map.remove("user02"));
		
		print("전체 조회");
		/* 
		 * (1) Map에 저장된 모든 객체들의 key를 알아야 함 (중복 불가)
		 * (2) 중복 되지 않는 collection은 Set
		 * (3) Map의 api 메서드 중 리턴 타입이 Set인 메서드를 조회 : Set<K> keyset()
		 * (4) key 목록을 Set에 반환 받아옴
		 * (5) Set은 순서가 없는 대신에 중복은 불가
		 * (6) key 목록 Set에 있는 key들을 Iterator에 담아오기
		 * (7) Iterator를 반복하면서 key를 하나씩 가져요기
		 * (8) 가져온 key를 Map에 있는 객체를 조회하기위해서 map.get(key)로 해당 key 객체 가져오기
		 * (9) 해당 내용 출력
		*/
		
//		(1) 새로운 저장 구조 사용
//		Set<String> keys = map.keySet();
//		 Iterator<String> iterator = keys.iterator();
//		 
//		 while (iterator.hasNext()) {
//             // key를 꺼내고
//             String key = iterator.next();
//             // key에 해당하는 value를 꺼내기
//             Member dto = (Member) map.get(key);
//             // key와 value를 출력
//             System.out.println(key + " : " + dto);
//         }
	
//		(2)									set		
		 Iterator<String> iterator = map.keySet().iterator();
		 
		 while(iterator.hasNext()) {
			 String str = iterator.next();
			 System.out.println(map.get(str));
		 }
		 
		 
		 
		 
	}
	
	private static void print(String message) {
		System.out.println("\n###"+message);
	}

}
