package Sorting;

import java.util.*;
import java.io.*;

public class SortingElement {
	
	public static int N, K;
	public static Integer[] arr, brr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new Integer[N];
		brr = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			brr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		Arrays.sort(brr, Collections.reverseOrder());
		
		for(int i = 0; i < K; i++) {
			
			if(arr[i] < brr[i]) {
				
				int temp = arr[i];
				arr[i] = brr[i];
				brr[i] = temp;
			}
			
			else break;
		}
		
		long result = 0;
		for(int i = 0; i < N; i++) {
			
			result += arr[i];
		}
		
		System.out.println(result);
	}

}
