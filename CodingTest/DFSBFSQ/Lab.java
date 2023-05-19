package DFSBFSQ;

import java.util.*;
import java.io.*;

public class Lab {
	
	public static int N, M, result;
	public static int[][] map, arr;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		map = new int[N][M];
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(result);
	}
	
	public static void dfs(int count) {
		
		if(count == 3) {
			
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j < M; j++) {
					
					arr[i][j] = map[i][j];
				}
			}
			
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j < M; j++) {
					
					if(arr[i][j] == 2) {
						
						virus(i, j);
					}
				}
			}
			
			result = Math.max(result, getScore());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				
				if(map[i][j] == 0) {
					
					map[i][j] = 1;
					count += 1;
					dfs(count);
					map[i][j] = 0;
					count -= 1;
				}
			}
		}
	}
	
	public static void virus(int x, int y) {
		
		for(int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				
				if(arr[nx][ny] == 0	 ) {
					
					arr[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}
	
	public static int getScore() {
		
		int score = 0;
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				
				if(arr[i][j] == 0) {
					
					score += 1;
				}
			}
		}
		
		return score;
	}

}
