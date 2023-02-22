package RealizeQ;

import java.util.*;

import javax.sql.rowset.serial.SQLOutputImpl;

public class RealizeQRe {
	
	public static String str;
	public static ArrayList<Character> result = new ArrayList<Character>();
	public static int value = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				result.add(str.charAt(i));
			} else {
				value += str.charAt(i) - '0';
			}
		}
		
		Collections.sort(result);

		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
		
		if(value != 0) System.out.print(value);
		System.out.println();
	}

}
