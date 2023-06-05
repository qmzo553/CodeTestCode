package ShortedPathQ;

import java.util.*;
import java.io.*;

public class Q38 {
	
	public static final int INF = (int) 1e9;
	public static int n, m;
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 501; i++) {
			
			Arrays.fill(graph[i], INF);
		}
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= n; j++) {
				
				if(i == j) graph[i][j] = 0;
			}
		}
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= n; j++) {
				
				for(int k = 1; k <= n; k++) {
					
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
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
			
			if(cnt == n) result++;
		}
		
		System.out.println(result);
	}

}
