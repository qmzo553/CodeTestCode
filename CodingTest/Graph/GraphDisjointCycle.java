package Graph;

import java.util.*;
import java.io.*;

public class GraphDisjointCycle {
	
	public static int v, e;
	public static int[] parent = new int[100001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= v; i++) {
			
			parent[i] = i;
		}
		
		boolean cycle = false;
		
		for(int i = 0; i < e; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(findParent(a) == findParent(b)) {
				
				cycle = true;
				break;
			} else {
				
				unionParent(a, b);
			}
		}
		
		if(cycle) {
			
			sb.append("사이클이 발생했습니다.").append('\n');
		} else {
			
			sb.append("사이클이 발생하지 않았습니다.").append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

}
