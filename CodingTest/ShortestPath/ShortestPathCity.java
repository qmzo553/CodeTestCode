package ShortestPath;

import java.util.*;
import java.io.*;

public class ShortestPathCity {
	
	public static final int INF = (int) 1e9;
	public static int N, M, X, K;
	public static int[][] graph = new int[101][101];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 101; i++) {
			
			Arrays.fill(graph[i], INF);
		}
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= N; j++) {
				
				if(i == j) graph[i][j] = 0;
			}
		}
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= N; j++) {
				
				for(int k = 1; k <= N; k++) {
					
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		int distance = graph[1][K] + graph[K][X];
		
		if(distance >= INF) System.out.println(-1);
		else System.out.println(distance);
		
	}

}
