package Graph;

import java.util.*;
import java.io.*;

public class GraphTeam {
	
	public static int n, m;
	public static int[] parent = new int[100001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(oper == 0) {
				
				unionParent(a, b);
			} else if(oper == 1) {
				
				if(findParent(a) == findParent(b)) {
					
					System.out.println("YES");
				} else {
					
					System.out.println("NO");
				}
			}
		}
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
