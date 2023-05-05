package GreedyQ;

import java.util.*;
import java.io.*;

public class GreedyQGuild {
	
	private static int N, count, result;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			
			count++;
			if(count >= arr[i]) {
				
				result++;
				count = 0;
			}
		}
		
		System.out.println(result);
	}

}
