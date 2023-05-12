package RealizeQ;

import java.util.*;
import java.io.*;

public class RealizeQRe {
	
	private static String str;
	private static int sum;
	private static ArrayList<Character> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			
			if(Character.isLetter(str.charAt(i))) {
				
				result.add(str.charAt(i));
			} else {
				
				sum += str.charAt(i) - '0';
			}
		}
		
		Collections.sort(result);
		
		for(int i = 0; i < result.size(); i++) {
			
			sb.append(result.get(i));
		}
		
		sb.append(sum);
		
		System.out.println(sb);
		
	}

}
