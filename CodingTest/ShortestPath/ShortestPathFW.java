package ShortestPath;

import java.util.*;
import java.io.*;

public class ShortestPathFW {
	
	public static final int INF = (int) 1e9;
	public static int n, m;
	public static int[][] graph = new int[501][501];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
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
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
		}
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= n; j++) {
				
				for(int k = 1; k <= n; k++) {
					
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= n; j++) {
				
				if(graph[i][j] == INF) System.out.println("INFINITY");
				else System.out.print(graph[i][j] + " ");
			}
			
			System.out.println();
		}
	}

}
