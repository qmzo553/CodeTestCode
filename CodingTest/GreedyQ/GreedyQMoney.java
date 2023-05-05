package GreedyQ;

import java.util.*;
import java.io.*;

public class GreedyQMoney {
	
	private static int N, ans;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		ans = 1;
		
		for(int i = 0; i < N; i++) {
			
			if(ans < arr[i]) break;
			ans += arr[i];
		}
		
		System.out.println(ans);
	}

}
