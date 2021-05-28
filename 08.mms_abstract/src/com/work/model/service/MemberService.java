/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.Member;


/**
 * 회원 등록 구현 절차
 * 
 * 1) 현재 등록된 회원 수(count)와 현재 배열의 크기가 같은지 비교해서 (=우리 펜션의 방(Members)의 갯수 확인)
 * 	> 같으면 새로 확장 배열(기존 배열의 크기 +)을 생성해서 
 * 	> 별도의 메서드로 분리 설계 : 구현 클래스에서 메서드 선언 
 * 2) 몇 명이 추가되는지?
 * 3) 새로 확장한 배열 요소에 기존 배열 요소에 저장된 객체들을 이동해서 저장
 * 	추가할 인원이 들어갈 배열공간이 있는지 확인하고 있으면 삽입, 없으면 공간 추가
 * 4) 기존에 참고하고 있는 배열 대신에 새로이 확장한 배열 요소로 변경해서 참조로 설정한다 
 * 5) count의 배열 요소에 argument로 전달 받은 회원 객체 등록
 * 	> 위의 작업 완료 후 count++;
 */

public class MemberService extends MemberServiceAbstract {
	
	
	//members를 private로 선언 해서 못 씀. 구현 클래스에서 가지고 있어야 함 
	private Member[] members = new Member[10];
	 
	 /**등록 인원 수 및 등록 될 배열 요소 위치 정보(= 걍 인원 수 체크)*/
	 private int count;
	 
	 
	 /**
	  *  <현재 등록 인원수 조회 메서드> 
	  * @return 현재 등록 인원수
	  */
	 public int getCount() {
		 return count;
	 }

 
//	여기다가 너희가 적으면 돼!
	@Override
	public void addMember(Member dto) {
		
		//메서드 호출 
//		1. 현재 count와 배열의 크기가 똑같아야 함
		if (count == members.length) {
			extendMembers();
			System.out.println("회원의 자료저장구조를 추가 확장하였습니다.");		
			} 
		
//		2. id가 -1(존재하지 않음) 이면 객체에 저장
		if(exist(dto.getMemberId()) == -1) {
			members[count++] = dto;
		}else {
			System.out.println("[오류] : 이 아이디는 사용할 수 없습니다.  ");
		}
		
		
	}
	

	/**
	 * 배열 구조 추가 확장해서 기존 저장 정보 이동 처리 메서드
	 * System.array() : 기존 배열요소를 기본 배열 크기 + 배열 크기를 확정 처리하는 메서드 작성 	
	 * @see java.lang.System#arraycopy(Object, int, Object, int, int)
	 */
	public void extendMembers() {
																		//     10+10	
		Member[] membersTemp = new Member[members.length +members.length ];
																		// 기존에 있는 크기만큼 돌림
		System.arraycopy(members, 0, membersTemp, 0, members.length);
		//헌 집 말고 새 집 참조해야하지요?
		members = membersTemp;
	}

	
	/**
	 *  CRUD 메서드에서 사용하기 위한 회원 존재 유무 및 저장 위치 조회 메서드
	 *  1) 현재 등록된 회원 수만큼 반복하면서
	 *  2) 배열에 저장된 순서대로 저장된 객체의 아이디와 (dto.getMemberID()) 
	 *  	parameter로 전달 받은 아이디가 같은지 비교해서 > {@link String#equals(Object)}
	 *  3) 아이디가 같으면 현재 저장된 배열 요소의 인덱스 번호를 반환
	 *  4) 반복 작업 후 나온 게 없으면 아이디 정보를 갖는 회원 객체가 존재하지 않으므로 
	 *   @return  (존재 : 0/미존재시 -1)
	 *   
	 * @param memberId 
	 * 
	 * //			(2)저장되어 있는 객체의 id를 가지고 와서 parameter에서 들어온 id와 비교한다 		
	 * @return  (존재 : 0/미존재시 -1)
	 */
	
	@Override
	public int exist(String memberId) {
// 		(1)
        for(int index = 0; index < count; index++) {
// 		(2) 
           if(members[index].getMemberId().equals(memberId)) {
//			(3)
              return index;
           }
        }
// 		(4)
        return -1;
     }

	 /**
	  * < 회원 상세 조회 메서드>
	  * 1. exist(String memberId) : 저장위치 반환 받아서 
	  * 2. 저장 위치가 0보다 크거나 같으면  (배열은 0부터 시작하기 때문)
	  * 	> 그럼 존재하는 회원!
	  * 3. 그럼 해당 배열의 요소의 객체를 return 
	  * 4. 0보다 작으면 , 존재하지 않는 회원 > return null; (객체 타입의 기본 값)
	  * 
	  */
	

	@Override
	public Member getMember(String memberId) {
		
		int index = exist(memberId);
		
		if(index >= 0) {
			//저장 되어 있는 위치 리턴
			return members[index];
		}
		System.out.println("[오류] : "+memberId+"는 존재하지 않는 아이디입니다.");

		return null;
	}
	
	
	
	
	
	
	
	
	
}
