package Realize;

import java.util.*;
import java.io.*;

public class RealizeKnight {
	
	private static int count;
	private static String str;
	private static int[] dx = {2, 2, -1, 1, -2, -2, -1, 1};
	private static int[] dy = {-1, 1, 2, 2, -1, 1, -1, -2};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		int x = str.charAt(0) - 'a' + 1;
		int y = str.charAt(1) - '0';
		count = 0;
		
		for(int i = 0; i < 8; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) count++;
		}
		
		System.out.println(count);
	}

}
