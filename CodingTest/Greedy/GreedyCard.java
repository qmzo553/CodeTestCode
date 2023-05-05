package Greedy;

import java.util.*;
import java.io.*;

public class GreedyCard {
	
	private static int N, M, min, ans;
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		ans = 0;
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			for(int j = 0; j < M; j++) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
			}
			
			ans = Math.max(ans, min);
		}
		
		System.out.println(ans);
	}

}
