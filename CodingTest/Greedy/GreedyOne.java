package Greedy;

import java.util.*;
import java.io.*;

public class GreedyOne {

	private static int N, K, count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		count = 0;
		
		while(true) {
			
			if(N % K == 0) {
				
				N /= K;
				count++;
				continue;
			}
			
			if(N == 1) break;
			
			N--;
			count++;
		}
		
		System.out.println(count);
	}

}
