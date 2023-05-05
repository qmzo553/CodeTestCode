package Greedy;

import java.util.*;
import java.io.*;

public class GreedyLargeNumber {

	private static int N, M, K, ans;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		ans = 0;
		while(true) {
			for(int i = 0; i < K; i++) {
				
				if(M == 0) break;
				
				ans += arr[N - 1];
				M--;
			}
			
			if(M == 0) break;
			
			ans += arr[N - 2];
			M--;
		}
		
		System.out.println(ans);
	} 

}
