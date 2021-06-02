package com.work.view;

public class ExceptionTest {

	public static void main(String[] args) {
		
System.out.println("프로그램 시작");
		
		String[] names = {"홍길동","강감찬","이순신"};
		String data = null;
		
		for(int i=0; i<5; i++) {
			
			try {
 //					System.out.println(data.length());  > NullpointerException
//					System.out.println(5 / 0); > ArithmeticException
				
				System.out.println(5 / 0);
					String message = "안녕 예외";
					
					int milege = Integer.parseInt("abc"); //> NumberFormatException
				
			} catch(ArrayIndexOutOfBoundsException e) {
				
				String message = e.getMessage();
				
				System.out.println("[오류] : 잘못 된 배열 요소 번호 : "+message);
				break;
			} catch (NullPointerException e) {
				System.out.println("[오류] : "+e.getMessage());
			} catch (Exception e) {
				System.out.println("[오류] : "+e.getMessage());
				System.out.println("[오류] : Exception "+e.getClass().getName()); //simple : class, name : ~ package
			}
			finally {
				
				System.out.println("[반드시 수행되는 로직]"); 
			}
		}
		
		System.out.println("프로그램 정상 종료");
		
		
		
		
	}
	
	
	public static void main2(String[] args) {
		
		System.out.println("프로그램 시작");
		
		String[] names = {"홍길동","강감찬","이순신"};
		String data = null;
		
		for(int i=0; i<5; i++) {
			
			try {
					//data 조회
					System.out.println(data.length()); // > NullpointerException
				
			} catch(ArrayIndexOutOfBoundsException e) {
				
				String message = e.getMessage();
				
				System.out.println("[오류] : 잘못 된 배열 요소 번호 : "+message);
				break;
			} finally {
				
				System.out.println("[반드시 수행되는 로직]"); 
			}
		}
		
		System.out.println("프로그램 정상 종료");


		
	}
	
	public static void main1(String[] args) {
		
		System.out.println("프로그램 시작");
		
		String[] names = {"홍길동","강감찬","이순신"};
		
		for(int i=0; i<5; i++) {
			
			try {
			System.out.println(names[i]); 
			}//		해당 타입의 exception이 발생하면 
			catch(ArrayIndexOutOfBoundsException e) {
				String message = e.getMessage();
				System.out.println("[오류] : 잘못 된 배열 요소 번호 : "+message);
				
				//이 exception을 해결할 방법
				break;
			} finally {
				
				//홍길동~이순신까지는 문제 없으니까 해당 요소 출력 되다가 오류 코드 실행 후 catch 한 번 finally 수행 종료
				System.out.println("[반드시 수행되는 로직]"); 
			}
		}
		
		System.out.println("프로그램 정상 종료");


	}

}
