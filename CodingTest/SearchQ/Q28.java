package SearchQ;

import java.util.*;
import java.io.*;

public class Q28 {
	
	public static int N;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = binarySearch(arr, 0, N - 1);
		
		System.out.println(index);
	}
	
	public static int binarySearch(int[] arr, int start, int end) {
		
		if(start > end) return -1;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == mid) return mid;
		else if(arr[mid] > mid) return binarySearch(arr, start, mid - 1);
		else return binarySearch(arr, mid + 1, end);
	}
}
