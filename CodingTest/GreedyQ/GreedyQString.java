package GreedyQ;

import java.util.*;
import java.io.*;

public class GreedyQString {
	
	private static String str;
	private static int count0, count1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		if(str.charAt(0) == '1') count0 += 1;
		else count1 += 1;
		
		for(int i = 0; i < str.length() - 1; i++) {
			
			if(str.charAt(i) != str.charAt(i + 1)) {
				
				if(str.charAt(i + 1) == '1') count0 += 1;
				else count1 += 1;
			}
		}
		
		System.out.println(Math.min(count1, count0));
	}
}
