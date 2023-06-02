package SearchQ;

import java.util.*;
import java.io.*;

public class Q29 {
	
	public static int N, C;
	public static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		int start = 1;
		int end = arr.get(N - 1) - arr.get(0);
		int result = 0;
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			int value = arr.get(0);
			int cnt = 1;
			
			for(int i = 1; i < N; i++) {
				
				if(arr.get(i) >= value + mid) {
					
					value = arr.get(i);
					cnt += 1;
				}
			}
			
			if(cnt >= C) {
				
				start = mid + 1;
				result = mid;
			} else {
				
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}

}
