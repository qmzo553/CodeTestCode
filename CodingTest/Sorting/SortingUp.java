package Sorting;

import java.util.*;
import java.io.*;

public class SortingUp {
	
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		//Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = arr.length - 1; i >= 0; i--) {
			
			System.out.print(arr[i] + " ");
		}

	}

}
