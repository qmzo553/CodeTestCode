package DFSBFS;

import java.util.*;
import java.io.*;

public class DFSBFSDrink {
	
	public static int N, M, result;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		result = 0;
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				
				if(dfs(i, j)) {
					
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean dfs(int x, int y) {
		
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		
		if(map[x][y] == 0) {
			
			map[x][y] = 1;
			
			dfs(x - 1, y);
			dfs(x, y - 1);
			dfs(x + 1, y);
			dfs(x, y + 1);
			
			return true;
		}
		
		return false;
	}

}
