package DFSBFSQ;

import java.util.*;
import java.io.*;

public class Operator {
	
	public static int N;
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static int add, sub, mul, divi;
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		add = Integer.parseInt(st.nextToken());
		sub = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		divi = Integer.parseInt(st.nextToken());
		
		dfs(1, arr.get(0));
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int i, int now) {
		
		if(i == N) {
			
			min = Math.min(min, now);
			max = Math.max(max, now);
		} else {
			
			if(add > 0) {
				
				add -= 1;
				dfs(i + 1, now + arr.get(i));
				add += 1;
			}
			
			if(sub > 0) {
				
				sub -= 1;
				dfs(i + 1, now - arr.get(i));
				sub += 1;
			}
			
			if(mul > 0) {
				
				mul -= 1;
				dfs(i + 1, now * arr.get(i));
				mul += 1;
			}
			
			if(divi > 0) {
				
				divi -= 1;
				dfs(i + 1, now / arr.get(i));
				divi += 1;
			}
		}
	}

}
