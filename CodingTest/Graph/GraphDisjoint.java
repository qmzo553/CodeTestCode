package Graph;

import java.util.*;
import java.io.*;

public class GraphDisjoint {	
	
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
		
		for(int i = 0; i < e; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionParent(a, b);
		}
		
		sb.append("각 원소가 속한 집합 : ");
		for(int i = 1; i <= v; i++) {
			
			sb.append(findParent(i) + " ");
		}
		sb.append('\n');
		
		sb.append("부모 테이블 : ");
		for(int i = 1; i <= v; i++) {
			
			sb.append(parent[i] + " ");
		}
		sb.append('\n');
		
		System.out.println(sb);
	}
	
	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		return findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

}
