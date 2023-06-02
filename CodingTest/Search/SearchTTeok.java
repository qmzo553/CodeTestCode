package Search;

import java.util.*;
import java.io.*;

public class SearchTTeok {
	
	public static int N, M, result;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = (int) 1e9;
		while(start <= end) {
			
			long total = 0;
			int mid = (start + end) / 2;
			for(int i = 0; i < N; i++) {
				
				if(arr[i] > mid) total += arr[i] - mid;
			}
			
			if(total < M) end = mid - 1;
			else {
				
				result = mid;
				start = mid + 1;
			}
		}
		
		System.out.println(result);
	}

}
