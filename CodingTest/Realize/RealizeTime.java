package Realize;

import java.util.*;
import java.io.*;

public class RealizeTime {
	
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 0; i <= N; i++) {
			
			for(int j = 0; j <= 59; j++) {
				
				for(int k = 0; k <= 59; k++) {
					
					if(i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3) count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
