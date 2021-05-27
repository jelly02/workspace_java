package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;

public class TEST {
	
	public static void main(String[] args) {
		MemberService service = new MemberService();
		
		service.addMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", 0,"선임");
	}
	
	
	//instanceof, typecasting, virtual method invocation 테스트
	public static void main3(String[] args) {
		
		//부모타입의 참조 변수에 일반 회원 객체 생성
		Member dto1 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		
		//자식이 재정의해놓은 자식의 toString() 호출 수행
		System.out.println(dto1);
		
		dto1.getMemberId(); 
//		dto1.getMileage(); 부모타입의 참조변수는 자식의 멤버 접근 불가
		GeneralMember g1 = (GeneralMember) dto1;
		System.out.println(g1); 
		
/*		 형변환 하기 전에 해당 클래스의 객체(instanceof) 여부 체킹		
		1) 첫번째 방법(X)
		AdminMember a1 = (AdminMember)dto1; 
		>>  java.lang.ClassCastException: com.work.model.dto.GeneralMember cannot be cast

		2) 두번째 방법(0)
*/		
		if(dto1 instanceof AdminMember) {
			AdminMember a1 = (AdminMember)dto1;
			a1.getPosition();
		} else {
			System.out.println("[오류] 해당 클래스의 인스턴스가 아닙니다." );
		}

		
		
		Member dto2 = new GeneralMember ("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-15","G",950000);		
		Member dto3 = new SpecialMember("user03", "password04", "김유신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
		
	}

	public static void main2(String[] args) {
		
		Member dto1 = new Member("user01","password01","홍길동","01012345678","user01@work.com");
		System.out.println(dto1);
		Member dto2 = new Member("user02","password02","강감찬","01012341234","user02@work.com");
		System.out.println(dto2);
	}
	
	
	
	
	//부모 타입의 다형성 : 모든 자식 객체를 참조할 수 있음
	public static void main1(String[] args) {
	
		//할당이 가능한 이유 : Member와 같은 타입(=자동 할당)
		Member dto1 = new Member();
		
		//할당이 가능한 이유 : 부모를 상속 받아서 (큰 타입)
		Member dto2 = new GeneralMember();
		Member dto3 = new SpecialMember();
		
		//에러(다른타입) : 부모 객체를 자식 객체 타입에 저장(참조) 할 수 없음 / 다른 타입 / 부모의 속성에는 자식의 속성이 없다. 
//		GeneralMember dto4 = new Member();
		
		//에러(다른타입) : 상속도 받지 않은 완전 다른 타입임 / 부모로부터 같은 상속을 받았지만 사실 상 다른 클래스고, 서로의 클래스에 같이 참조할 만한 게 없음
		//형에게는 형 물건이 있고 동생한테는 동생 물건이 있음. 
//		GeneralMember dto4 = new AdminMember();
	}

}
