package DFSBFSQ;

import java.util.*;
import java.io.*;

public class Operator {
	
	public static int n;
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static int add, sub, mul, div;
	public static int minValue = (int) 1e9;
	public static int maxValue = (int) -1e9;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			int x = sc.nextInt();
			arr.add(x);
		}
		
		add = sc.nextInt();
		sub = sc.nextInt();
		mul = sc.nextInt();
		div = sc.nextInt();
		
		dfs(1, arr.get(0));
		
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	
	public static void dfs(int i, int now) {
		
		if(i == n) {
			
			minValue = Math.min(minValue, now);
			maxValue = Math.max(maxValue, now);
		} else {
			
			if(add > 0) {
				
				add -= 1;
				dfs(i + 1, now + arr.get(i));
				add += 1;
			} if(sub > 0) {
				
				sub -= 1;
				dfs(i + 1, now - arr.get(i));
				sub += 1;
			} if(mul > 0) {
				
				mul -= 1;
				dfs(i + 1, now * arr.get(i));
				mul += 1;
			} if(div > 0) {
				
				div -= 1;
				dfs(i + 1, now / arr.get(i));
				div += 1;
			}
		}
	}

}
