package Search;

import java.util.*;
import java.io.*;

public class SearchRepeatBinary {
	
	public static int binarySearch2(int[] arr, int target, int start, int end) {
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			if (arr[mid] == target) return mid;
			else if (arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = binarySearch2(arr, target, 0, n - 1);
		if(result == -1) {
			System.out.println("원소가 존재하지 않습니다.");
		} else {
			System.out.println(result + 1);
		}
	}

}
