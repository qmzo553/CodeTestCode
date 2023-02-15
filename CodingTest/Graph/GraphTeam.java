package Graph;

import java.util.*;

public class GraphTeam {
	
	public static int n, m;
	public static int[] parent = new int[100001];
	
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			int oper = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(oper == 0) {
				unionParent(a, b);
			}
			
			else if(oper == 1) {
				if(findParent(a) == findParent(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

}
