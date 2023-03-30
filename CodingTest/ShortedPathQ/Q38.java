package ShortedPathQ;

import java.util.*;

public class Q38 {
	
	public static final int INF = (int) 1e9;
	public static int n, m;
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < 501; i++) { 
			
			Arrays.fill(graph[i], INF);
		}
		
		for(int a = 1; a <= n; a++) {
			for(int b = 1; b <= n; b++) { 
				
				if(a == b) graph[a][b] = 0;
			}
		}
		
		for(int i = 0; i < m; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				if(graph[i][j] != INF || graph[j][i] != INF) {
					cnt += 1;
				}
			}
			
			if(cnt == n) {
				result += 1;
			}
		}
		
		System.out.println(result);
	}

}
