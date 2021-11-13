package test;

import java.util.Arrays;
import java.util.StringJoiner;

public class split {
	
	public static void main(String[] args) {
	
		String interest = "차박,여행,사진,영상,반려동물과함께";
		
		String[] splited = interest.split(",");
	
		String separator = "|"; 
	    StringBuilder sb = new StringBuilder(); 
	    int listSize = splited.length; 
	    for (int i = 0; i < listSize; i++){ 
	        sb.append(splited[i]); 
	        if (i < listSize - 1){ 
	            sb.append(separator); 
	        } 
	    } 
	    
	    String edit = sb.toString();
	    System.out.println("result : " + sb.toString());
	
		System.out.println(edit);
		
		
	}
	
}