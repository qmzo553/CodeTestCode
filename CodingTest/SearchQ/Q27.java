package SearchQ;

import java.util.*;
import java.io.*;

public class Q27 {
	
	public static int N, X;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = countByRange(arr, X, X);
		
		if(cnt == 0) System.out.println(-1);
		else System.out.println(cnt);
	}
	
	public static int lowerBound(int[] arr, int target, int start, int end) {
		
		while(start < end) {
			
			int mid = (start + end) / 2;
			if(arr[mid] >= target) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	public static int upperBound(int[] arr, int target, int start, int end) {
		
		while(start < end) {
			
			int mid = (start + end) / 2;
			if(arr[mid] > target) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		
		int rightIndex = upperBound(arr, rightValue, 0, arr.length);
		int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
		
		return rightIndex - leftIndex;
	}

}
