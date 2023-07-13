package GreedyQ;

import java.util.*;
import java.io.*;

public class GreedyQGuild {
	
	public static int n;
	public static ArrayList<Integer> arrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			arrayList.add(sc.nextInt());
		}
		
		Collections.sort(arrayList);
		
		int result = 0;
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			
			count += 1;
			if(count >= arrayList.get(i)) {
				
				result += 1;
				count = 0;
			}
		}
		
		System.out.println(result);
	}

}
