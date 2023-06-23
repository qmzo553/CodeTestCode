package GraphQ;

import java.util.*;
import java.io.*;

public class Q41 {
	
	public static int n, m;
	public static int[] parent = new int[501];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			
			parent[i] = i;
		}
		
		for(int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					
					unionParent(i + 1, j + 1);
				}
			}
		}
		
		ArrayList<Integer> plan = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			
			int x = Integer.parseInt(st.nextToken());
			plan.add(x);
		}
		
		boolean result = true;
		for(int i = 0; i < m - 1; i++) { 
			
			if(findParent(plan.get(i)) != findParent(plan.get(i + 1))) {
				
				result = false;
			}
		}
		
		if(result) System.out.println("YES");
		else System.out.println("NO");
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
