package RealizeQ;

import java.util.*;
import java.io.*;

public class RealizeQLucky {
	
	private static String str;
	private static int sum1, sum2;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		for(int i = 0; i < str.length() / 2; i++) {
			
			sum1 += str.charAt(i) - 0;
		}
		
		for(int i = str.length() / 2; i < str.length(); i++) {
			
			sum2 += str.charAt(i) - 0;
		}
		
		if(sum1 == sum2) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
