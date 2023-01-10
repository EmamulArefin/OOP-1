import java.util.*;

public class ZStart{
	public static void main(String args[]){
		
		System.out.println(ZStart.generateOtp(4));
		
	}
	
	public static String generateOtp(int otpLength){
		SplittableRandom split = new SplittableRandom();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<otpLength; i++){
			sb.append(split.nextInt(0,10));
		}
		return sb.toString();
	}
	
}