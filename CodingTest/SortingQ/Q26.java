package SortingQ;

import java.util.*;
import java.io.*;

public class Q26 {
	
	public static int N, result, sum;
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		result = 0;
		
		while(pq.size() != 1) {
			
			int one = pq.poll();
			int two = pq.poll();
			
			sum = one + two;
			result += sum;
			pq.offer(sum);
		}
		
		System.out.println(result);
		
	}

}
