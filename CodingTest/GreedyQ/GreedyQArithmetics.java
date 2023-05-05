package GreedyQ;

import java.util.*;
import java.io.*;

public class GreedyQArithmetics {
	
	private static int num;
	private static String str;
	private static long ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		ans = str.charAt(0) - '0';
		
		for(int i = 1; i < str.length(); i++) {
			
			num = str.charAt(i) - '0';
			
			if(num <= 1 || ans <= 1) ans += num;
			else ans *= num;
		}
		
		System.out.println(ans);
	}
	
}
