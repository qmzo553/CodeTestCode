package Search;

import java.util.*;
import java.io.*;

public class SearchComponent {
	
	public static int N, M;
	public static int[] arr, brr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		brr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			
			if(binarySearch(arr, brr[i])) sb.append("yes").append(' ');
			else sb.append("no").append(' ');
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean binarySearch(int[] arr, int n) {
		
		int start = 0;
		int end = arr.length - 1;
		
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			if(arr[mid] == n) return true;
			else if(arr[mid] > n) end = mid - 1;
			else start = mid + 1;
		}
		
		return false;
	}

}
