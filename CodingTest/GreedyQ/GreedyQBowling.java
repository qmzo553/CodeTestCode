package GreedyQ;

import java.util.*;
import java.io.*;

public class GreedyQBowling {
	
	private static int N, M, count;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			int x = Integer.parseInt(st.nextToken());
			arr[x]++; 
		}
		
		count = 0;
		
		for(int i = 1; i <= M; i++) {
			
			N -= arr[i];
			count += arr[i] * N;
		}
		
		System.out.println(count);
	}

}
